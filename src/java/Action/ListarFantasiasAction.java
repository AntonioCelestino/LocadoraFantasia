package Action;

import Controller.Action;
import DAO.FantasiaDAO;
import Modelo.Categoria;
import Modelo.Fantasia;
import Modelo.FantasiaListagem;
import Modelo.FantasiaNome;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarFantasiasAction implements Action{

    @Override
    public void pesquisar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try {
            List<Fantasia> fs = FantasiaDAO.getInstance().obterTs();
            FantasiaListagem fl = new FantasiaListagem();
            List<Categoria> cs = new ArrayList<>();
            for (Fantasia f : fs) {
                boolean b = false;
                for (int i = 0; i < cs.size(); i++) {
                    Categoria c = cs.get(i);
                    if(c.getDescricao().contains(f.getCategoria())){
                        c.addAtributo(new FantasiaNome(f.getNome()));
                        cs.set(i, c);
                        b = true;
                        break;
                    }
                }
                if(!b){
                    Categoria c = new Categoria(f.getCategoria());
                    c.addAtributo(new FantasiaNome(f.getNome()));
                    cs.add(c);
                }
            }
            for (Iterator<Categoria> it = cs.iterator(); it.hasNext();) {
                fl.addAtributo(it.next());
            }
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

    @Override
    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
