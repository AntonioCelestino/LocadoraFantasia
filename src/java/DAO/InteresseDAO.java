package DAO;

import Modelo.Cliente;
import Modelo.Fantasia;
import Modelo.Interesse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class InteresseDAO extends GenericoDAO<Interesse>{

    private static InteresseDAO instance = new InteresseDAO();
    private final String tabela = "INTERESSE";
    private final List<Object> params = new ArrayList<>();
    private String sql = null;
    
    public static InteresseDAO getInstance(){
        return instance;
    }
    
    public void obterClientesInteressados(Fantasia f) throws SQLException, ClassNotFoundException, ServletException{
        params.clear();
        List<Interesse> is = new ArrayList<>();
        sql = "SELECT * FROM CLIENTE, "+tabela+" WHERE "+tabela+".CLIENTE_ID_CLIENTE = CLIENTE.ID_CLIENTE AND "+tabela+".FANTASIA_ID_FANTASIA = ?";
        params.add(f.getCodFantasia());    
        try {
            is = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        for (Interesse i : is) {
            if(i.getFantasia().getCodFantasia() == f.getCodFantasia()){
                f.addObserver(i.getCliente());
            }
        }
    }
    public List<Interesse> obterClientesInteressados2(Fantasia f) throws SQLException, ClassNotFoundException, ServletException{
        params.clear();
        List<Interesse> is = new ArrayList<>();
        sql = "SELECT * FROM CLIENTE, "+tabela+" WHERE "+tabela+".CLIENTE_ID_CLIENTE = CLIENTE.ID_CLIENTE AND "+tabela+".FANTASIA_ID_FANTASIA = ?";
        params.add(f.getCodFantasia());    
        try {
            is = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return is;
    }
    
    public List<Interesse> obterFantasiasEmInteresse(Cliente c) throws ServletException{
        params.clear();
        List<Interesse> is = new ArrayList<>();
        sql = "SELECT * FROM FANTASIA, "+tabela+" WHERE "+tabela+".FANTASIA_ID_FANTASIA = FANTASIA.ID_FANTASIA AND "+tabela+".CLIENTE_ID_CLIENTE = ?";
        params.add(c.getCodCliente());    
        try {
            is = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return is;
    }
    
    @Override
    public List<Interesse> obterTs() throws ServletException {
        params.clear();
        List<Interesse> is = new ArrayList<>();
        sql = "SELECT * FROM "+tabela;
        try {
            is = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return is;
    }

    @Override
    public Interesse obterT(int codInteresse) throws ServletException {
        throw new UnsupportedOperationException("Não suportado"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void operacao(Interesse i, String operacao) throws ServletException {
        params.clear();
        if(operacao.equals("Excluir")){
            sql = "DELETE FROM "+tabela
                    +" WHERE CLIENTE_ID_CLIENTE = ? AND FANTASIA_ID_FANTASIA = ?";
            params.add(i.getCliente().getCodCliente());
            params.add(i.getFantasia().getCodFantasia());
        }else{
            params.add(i.getCliente().getCodCliente());
            params.add(i.getFantasia().getCodFantasia());
            params.add(i.getMensagem());
            if(operacao.equals("Incluir")){
                sql = "INSERT INTO "+tabela+" ("
                        + "CLIENTE_ID_CLIENTE, "
                        + "FANTASIA_ID_FANTASIA, "
                        + "MENSAGEM "
                        + ") VALUES (?,?,?)";
            } else if(operacao.equals("Editar")){
                params.clear();
                sql = "UPDATE "+tabela+" SET "
                        + "MENSAGEM = ? "
                        + "WHERE CLIENTE_ID_CLIENTE = ? AND FANTASIA_ID_FANTASIA = ?";
                params.add(i.getMensagem());
                params.add(i.getCliente().getCodCliente());
                params.add(i.getFantasia().getCodFantasia());
            }
        }
        try {
            super.operacaoClasse(sql, params);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected RowMapping getMapa() throws ServletException {
        return new RowMapping() {
            @Override
            public Object mapeamento(ResultSet rs) throws SQLException, ServletException {
                Interesse i = new Interesse();
                i.setCliente((Cliente) ClienteDAO.getInstance().obterT(rs.getInt("CLIENTE_ID_CLIENTE")));
                i.setFantasia((Fantasia) FantasiaDAO.getInstance().obterT(rs.getInt("FANTASIA_ID_FANTASIA")));
                i.setMensagem(rs.getString("MENSAGEM"));
                return i;
            }
        };
    }
}
