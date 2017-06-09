package Action;

import Controller.Action;
import DAO.AluguelDAO;
import DAO.FantasiaDAO;
import DAO.PessoaDAO;
import Modelo.Aluguel;
import Modelo.Fantasia;
import Modelo.Pessoa;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AluguelAction implements Action{

    private Aluguel aluguel = new Aluguel();
    
    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("alugueis", AluguelDAO.getInstance().obterTs());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaAlugueis.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("pessoas", PessoaDAO.getInstance().obterTs());
            request.setAttribute("fantasias", FantasiaDAO.getInstance().obterTs());
            if(!operacao.equals("Incluir")){
                int codAluguel = Integer.parseInt(request.getParameter("codAluguel"));
                aluguel = (Aluguel) AluguelDAO.getInstance().obterT(codAluguel);
                String msg = aluguel.getPromocao();
                if(!msg.equals("")){
                    msg = "Aluguel da Fantasia "+aluguel.getFantasia().getNome()+
                            " está com desconto de "+aluguel.getP().getDesconto()+"% na Promoção "+aluguel.getPromocao();
                }
                request.setAttribute("mensagem", msg);
                request.setAttribute("aluguel", aluguel);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAluguel.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
            throw ex;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        if(!operacao.equals("Incluir")){
            int codAluguel = Integer.parseInt(request.getParameter("codAluguel"));
            aluguel = (Aluguel) AluguelDAO.getInstance().obterT(codAluguel);
            aluguel.setCodAluguel(codAluguel);
            try {
                aluguel.setDtAluguel(request.getParameter("txtDataAluguel"));
                aluguel.setDtDevolucao(request.getParameter("txtDataDevolucao"));
            } catch (ParseException ex) {
                throw new ServletException(ex);
            }
        }else{
            aluguel.setDataAluguel(new Date());
            aluguel.setDataDevolucao(new Date());
            aluguel.setPessoa((Pessoa) PessoaDAO.getInstance().obterT(Integer.parseInt(request.getParameter("optPessoa"))));
            aluguel.setFantasia((Fantasia) FantasiaDAO.getInstance().obterT(Integer.parseInt(request.getParameter("optFantasia"))));
        }
        if(request.getParameter("optPromocao") != null){
            aluguel.setPromocao(request.getParameter("optPromocao"));
        }else{
            aluguel.setPromocao("");
        }
        aluguel.calculaPrecoAluguel();
        Fantasia f = aluguel.getFantasia();
        String msg = null;
        if(operacao.equals("Incluir")){
            msg = f.alugar();
        }else if(operacao.equals("Editar")){
            String t = request.getParameter("finalizar");
            if(t != null && t.equals("on")){
                msg = f.disponibilizar();
            }
        }
        if(msg != null){ 
            if(!msg.equals("")){
                throw new ServletException(msg);
            }else{
                FantasiaDAO.getInstance().operacao(f, "Editar");
            }
        }
        try{
            AluguelDAO.getInstance().operacao(aluguel, operacao);
            response.sendRedirect("FrontController?action=Aluguel&acao=pesquisar");
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
}