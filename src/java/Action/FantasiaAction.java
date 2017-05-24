package Action;

import Controller.Action;
import DAO.FantasiaDAO;
import Modelo.Fantasia;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FantasiaAction implements Action{

    private Fantasia fantasia = new Fantasia();
    
    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("fantasias", FantasiaDAO.getInstance().obterTs());
            RequestDispatcher view = request.getRequestDispatcher("/pesquisaFantasias.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        }
    }

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try{
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            if(!operacao.equals("Incluir")){
                int codFantasia = Integer.parseInt(request.getParameter("codFantasia"));
                fantasia = (Fantasia) FantasiaDAO.getInstance().obterT(codFantasia);
                request.setAttribute("fantasia", fantasia);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterFantasia.jsp");
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
            int codFantasia = Integer.parseInt(request.getParameter("codFantasia"));
            fantasia.setCodFantasia(codFantasia);
        }
        fantasia.setNome(request.getParameter("txtNome"));
        fantasia.setCategoria(request.getParameter("txtCategoria"));
        fantasia.setTamanho(request.getParameter("txtTamanho"));
        fantasia.setNomeEstado(request.getParameter("optEstado"));
        fantasia.setDiaria(Double.parseDouble(request.getParameter("txtDiaria")));
        try{
            FantasiaDAO.getInstance().operacao(fantasia, operacao);
            this.pesquisar(request, response);
        }catch(ServletException e){
            throw e;
        }catch(IOException ex){
            throw new ServletException(ex);
        }
    }
    
}
