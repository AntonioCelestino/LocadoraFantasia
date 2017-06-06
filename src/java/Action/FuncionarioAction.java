package Action;

import Controller.Action;
import DAO.FuncionarioDAO;
import DAO.PessoaDAO;
import Modelo.Funcionario;
import Modelo.Pessoa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FuncionarioAction implements Action{

    private Funcionario funcionario = new Funcionario();
    
    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("funcionarios", FuncionarioDAO.getInstance().obterTs());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaFuncionarios.jsp");
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
            if(!operacao.equals("Incluir")){
                int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
                funcionario = (Funcionario) FuncionarioDAO.getInstance().obterT(codFuncionario);
                request.setAttribute("funcionario", funcionario);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionario.jsp");
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
            int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));
            funcionario.setCodFuncionario(codFuncionario);
        }
        funcionario.setCargo(request.getParameter("optCargo"));
        funcionario.setPessoa((Pessoa) PessoaDAO.getInstance().obterT(Integer.parseInt(request.getParameter("optPessoa"))));
        try{
            FuncionarioDAO.getInstance().operacao(funcionario, operacao);
            response.sendRedirect("FrontController?action=Funcionario&acao=pesquisar");
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
    
}
