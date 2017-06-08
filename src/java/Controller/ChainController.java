package Controller;

import DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Padroes.Atividade;
import Padroes.FuncionarioGerente;
import Padroes.FuncionarioRecepcionista;
import Padroes.FuncionarioVendedor;
import Padroes.RolAtividades;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChainController extends HttpServlet {
    private Funcionario funcionario = new Funcionario();
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
            int codFuncionario = Integer.parseInt(request.getParameter("codFuncionario"));

            Funcionario f = FuncionarioDAO.getInstance().obterT(codFuncionario);
            
            switch(f.getCargo()){
                case "Recepcionista":
                    funcionario = new FuncionarioRecepcionista(new FuncionarioVendedor(new FuncionarioGerente(null)));
                    break;
                case "Vendedor":
                    funcionario = new FuncionarioVendedor(new FuncionarioGerente(null));
                    break;
                case "Gerente":
                    funcionario = new FuncionarioGerente(null);
                    break;
                default:
                    break;
            }

            funcionario.setCargo(f.getCargo());
            funcionario.setCodFuncionario(f.getCodFuncionario());
            funcionario.setPessoa(f.getPessoa());

            String atividade = request.getParameter("atividade");
            String msg;
            switch(atividade){
                case "Atender":
                    msg = funcionario.executarAtividade(new Atividade(RolAtividades.getInstance().getTipoAtividadeAtender()));
                    break;
                case "Vender":
                    msg = funcionario.executarAtividade(new Atividade(RolAtividades.getInstance().getTipoAtividadeVender()));
                    break;
                case "Negociar":
                    msg = funcionario.executarAtividade(new Atividade(RolAtividades.getInstance().getTipoAtividadeNegociar()));
                    break;
                default:
                    msg = "";
                    break;
            }
            out.println("<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<title>Ativiade designada</title>"
                        + "</head>"
                        + "<body>"
                        + "<h1>"+msg+"</h1>"
                        + "</body>"
                        + "</html>");    
        } catch (NumberFormatException | ServletException e) {
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
