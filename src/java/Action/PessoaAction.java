package Action;

import Controller.Action;
import DAO.PessoaDAO;
import Modelo.Pessoa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaAction implements Action{

    private Pessoa pessoa = new Pessoa();
    
    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("pessoas", PessoaDAO.getInstance().obterTs());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaPessoas.jsp");
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
            if(!operacao.equals("Incluir")){
                int codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
                pessoa = (Pessoa) PessoaDAO.getInstance().obterT(codPessoa);
                request.setAttribute("pessoa", pessoa);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterPessoa.jsp");
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
            int codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
            pessoa.setCodPessoa(codPessoa);
        }
        pessoa.setCpf(request.getParameter("txtCPF"));
        pessoa.setNome(request.getParameter("txtNome"));
        pessoa.setEmail(request.getParameter("txtEmail"));
        try{
            PessoaDAO.getInstance().operacao(pessoa, operacao);
            response.sendRedirect("FrontController?action=Pessoa&acao=pesquisar");
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
    
}
