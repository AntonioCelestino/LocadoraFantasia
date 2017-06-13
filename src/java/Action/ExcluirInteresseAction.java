package Action;

import Controller.Action;
import DAO.ClienteDAO;
import DAO.FantasiaDAO;
import DAO.InteresseDAO;
import Modelo.Interesse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirInteresseAction implements Action{

    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        Interesse i = new Interesse();
        i.setCliente(ClienteDAO.getInstance().obterT(Integer.parseInt(request.getParameter("codCliente"))));
        i.setFantasia(FantasiaDAO.getInstance().obterT(Integer.parseInt(request.getParameter("codFantasia"))));
        try {
            InteresseDAO.getInstance().operacao(i, "Excluir");
            response.sendRedirect("FrontController?action=Cliente&acao=pesquisar");
        } catch (IOException | ServletException e) {
            throw new ServletException(e);
        }
    }
    
}
