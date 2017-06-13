package DAO;

import Modelo.Cliente;
import Modelo.Interesse;
import Modelo.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class ClienteDAO extends GenericoDAO<Cliente>{

    private static ClienteDAO instance = new ClienteDAO();
    private final String tabela = "CLIENTE";
    private final List<Object> params = new ArrayList<>();
    private String sql = null;
    
    public List<String> getMensagensObserver(Cliente c) throws ServletException{
        List<Interesse> is = InteresseDAO.getInstance().obterTs();
        List<String> msgs = new ArrayList<>();
        for (Interesse i : is) {
            if(i.getCliente().getCodCliente() == c.getCodCliente() && i.getMensagem() != null){
                msgs.add(i.getMensagem());
            }
        }
        if(msgs.isEmpty()){
            msgs.add("Nenhuma Mensagem Recebida");
        }
        return msgs;
    }
    
    public static ClienteDAO getInstance() {
        return instance;
    }
    
    @Override
    public List<Cliente> obterTs() throws ServletException {
        params.clear();
        List<Cliente> cs = new ArrayList<>();
        sql = "SELECT * FROM "+tabela;
        try {
            cs = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return cs;
    }

    @Override
    public Cliente obterT(int codCliente) throws ServletException {
        params.clear();
        Cliente c = new Cliente();
        sql = "SELECT * FROM "+tabela+" WHERE ID_CLIENTE = ?";
        params.add(codCliente);
        try {
            c = super.obterClasse(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        return c;
    }

    @Override
    public void operacao(Cliente c, String operacao) throws ServletException {
        params.clear();
        if(operacao.equals("Excluir")){
            sql = "DELETE FROM "+tabela
                    +" WHERE ID_CLIENTE = ?";
            params.add(c.getCodCliente());
        }else{
            params.add(c.getTipo());
            params.add(c.getPessoa().getCodPessoa());
            if(operacao.equals("Incluir")){
                sql = "INSERT INTO "+tabela+" ("
                        + "TIPO, "
                        + "PESSOA_ID_PESSOA "
                        + ") VALUES (?,?)";
            } else if(operacao.equals("Editar")){
                sql = "UPDATE "+tabela+" SET "
                        + "TIPO = ?, "
                        + "PESSOA_ID_PESSOA = ? "
                        + "WHERE ID_CLIENTE = ?";
                params.add(c.getCodCliente());
            }
        }
        try {
            super.operacaoClasse(sql, params);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected RowMapping getMapa() {
        return new RowMapping() {
            @Override
            public Object mapeamento(ResultSet rs) throws SQLException, ServletException {
                Cliente c = new Cliente();
                c.setCodCliente(rs.getInt("ID_CLIENTE"));
                c.setTipo(rs.getString("TIPO"));
                c.setPessoa((Pessoa) PessoaDAO.getInstance().obterT(rs.getInt("PESSOA_ID_PESSOA")));
                return c;
            }
        };
    }
    
}
