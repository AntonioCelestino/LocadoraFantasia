package Controller;

import DAO.FantasiaDAO;
import Modelo.Categoria;
import Modelo.Fantasia;
import Modelo.FantasiaListagem;
import Modelo.FantasiaNome;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarFantasias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try {
            List<Fantasia> fs = FantasiaDAO.getInstance().obterTs();
            FantasiaListagem fl = new FantasiaListagem();
            Categoria marvel = new Categoria("Marvel");
            Categoria dc_comics = new Categoria("DC Comics");
            for (Iterator<Fantasia> iterator = fs.iterator(); iterator.hasNext();) {
                Fantasia f = iterator.next();
                if(f.getCategoria().equals("Marvel")){
                    marvel.addAtributo(new FantasiaNome(f.getNome()));
                }else if(f.getCategoria().equals("DC Comics")){
                    dc_comics.addAtributo(new FantasiaNome(f.getNome()));
                }
            } 
            
            fl.addAtributo(marvel);
            fl.addAtributo(dc_comics);
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Lista de Fantasias Cadastradas</title>"
                    + "</head>"
                    + "<body>"
                    + "<h1>Lista</h1>"
                    + fl.listarCategorias()
                    + "</body>"
                    + "</html>");
        } catch (ServletException e) {
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
