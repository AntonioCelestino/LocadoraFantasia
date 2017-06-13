package Action;

import Controller.Action;
import DAO.FantasiaDAO;
import DAO.InteresseDAO;
import Modelo.Fantasia;
import Modelo.FantasiaEstado;
import Modelo.FantasiaEstadoDisponivel;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            throw new ServletException(ex);
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
        if(request.getParameter("btnMemento").equals("restaurarEstado")){
            restaurarEstado(request, response);
        }else{
            String operacao = request.getParameter("operacao");
            if(!operacao.equals("Incluir")){
                int codFantasia = Integer.parseInt(request.getParameter("codFantasia"));
                fantasia = (Fantasia) FantasiaDAO.getInstance().obterT(codFantasia);
                String estado = request.getParameter("optEstado");
                /*fantasia.getClass().getMethod(estado, String.class);*/
                FantasiaEstado estadoAnterior = fantasia.getEstado();
                String msg = "";
                try {
                    InteresseDAO.getInstance().obterClientesInteressados(fantasia);
                } catch (SQLException ex) {
                    throw new ServletException(ex);
                }
                if(!estadoAnterior.getEstado().equals(estado)){
                    switch (estado) {
                        case "Disponível":
                            msg = fantasia.disponibilizar();
                            break;
                        case "Alugada":
                            msg = fantasia.alugar();
                            break;
                        case "Descartada":
                            msg = fantasia.descartar();
                            break;
                        case "Restaurando":
                            msg = fantasia.restaurar();
                            break;
                        default:
                            break;
                    }
                }
                if(!msg.equals("")){
                    throw new ServletException(msg);
                }else{
                    FantasiaDAO.getInstance().setEstadoAnterior(fantasia.saveToMemento(estadoAnterior));
                }
            }else{
                fantasia.setEstado(new FantasiaEstadoDisponivel());
            }
            fantasia.setNome(request.getParameter("txtNome"));
            fantasia.setCategoria(request.getParameter("txtCategoria"));
            fantasia.setTamanho(request.getParameter("optTamanho"));
            fantasia.setDiaria(Double.parseDouble(request.getParameter("txtDiaria")));
            try{
                FantasiaDAO.getInstance().operacao(fantasia, operacao);
                response.sendRedirect("FrontController?action=Fantasia&acao=pesquisar");
            }catch(IOException ex){
                throw new ServletException(ex);
            }
        }
    }
    
    private void restaurarEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String operacao = request.getParameter("operacao");
        if(operacao.equals("Editar")){
            int codFantasia = Integer.parseInt(request.getParameter("codFantasia"));
            fantasia = (Fantasia) FantasiaDAO.getInstance().obterT(codFantasia);
            try {
                fantasia.restoreFromMemento(FantasiaDAO.getInstance().getEstadoAnterior());
            } catch (Exception e) {
                throw new ServletException("<b>Não há estados anteriores</b>");
            }
            FantasiaDAO.getInstance().operacao(fantasia, operacao);
            FantasiaDAO.getInstance().removerUltimoEstadoAnterior();
        }
        response.sendRedirect("FrontController?action=Fantasia&acao=pesquisar");
    }
}
