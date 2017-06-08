package Action;

import Controller.Action;
import DAO.ClienteDAO;
import DAO.PessoaDAO;
import Modelo.Cliente;
import Modelo.ClienteComum;
import Modelo.ClienteVip;
import Modelo.Pessoa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteAction implements Action{

    private Cliente cliente = new Cliente();
    
    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("clientes", ClienteDAO.getInstance().obterTs());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaClientes.jsp");
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
                int codCliente = Integer.parseInt(request.getParameter("codCliente"));
                cliente = ClienteDAO.getInstance().obterT(codCliente);
                if(cliente.getTipo().equals("Vip")){
                    cliente = new ClienteVip(cliente);
                }else if(cliente.getTipo().equals("Comum")){
                    cliente = new ClienteComum(cliente);
                }
                request.setAttribute("mensagem", cliente.getDadosCliente());
                request.setAttribute("cliente", cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
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
            int codCliente = Integer.parseInt(request.getParameter("codCliente"));
            cliente.setCodCliente(codCliente);
        }
        cliente.setTipo(request.getParameter("optTipo"));
        cliente.setPessoa((Pessoa) PessoaDAO.getInstance().obterT(Integer.parseInt(request.getParameter("optPessoa"))));
        try{
            ClienteDAO.getInstance().operacao(cliente, operacao);
            response.sendRedirect("FrontController?action=Cliente&acao=pesquisar");
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
    
}
