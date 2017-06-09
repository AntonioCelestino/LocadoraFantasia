package Action;

import Controller.Action;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChainAction implements Action{

    private Funcionario funcionario = new Funcionario();
    
    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
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

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
