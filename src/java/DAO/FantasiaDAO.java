package DAO;

import Modelo.Fantasia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FantasiaDAO extends GenericoDAO<Fantasia>{

    private static FantasiaDAO instance = new FantasiaDAO();
    private final String tabela = "FANTASIA";
    
    public static FantasiaDAO getInstance() {
        return instance;
    }

    @Override
    public List<Fantasia> obterTs() {
        List<Fantasia> fs = new ArrayList<>();
        List<Object> params = new ArrayList<>();
        try {
            fs = super.obterClasses("SELECT * FROM "+tabela, params, new RowMapping() {
                @Override
                public Object mapeamento(ResultSet rs) throws SQLException {
                    Fantasia f = new Fantasia();
                    f.setCodFantasia(rs.getInt("ID_FANTASIA"));
                    f.setNome(rs.getString("NOME"));
                    f.setCategoria(rs.getString("CATEGORIA"));
                    f.setTamanho(rs.getString("TAMANHO"));
                    f.setNomeEstado(rs.getString("ESTADO"));
                    f.setDiaria(rs.getDouble("DIARIA"));
                    return f;
                }
            });
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fs;
    }

    @Override
    public Fantasia obterT(int codFantasia) {
        Fantasia f = new Fantasia();
        String sql = "SELECT * FROM "+tabela+" WHERE ID_FANTASIA = ?";
        List<Object> params = new ArrayList<>();
        params.add(codFantasia);
        try {
            f = super.obterClasse(sql, params, new RowMapping() {
                @Override
                public Object mapeamento(ResultSet rs) throws SQLException {
                    Fantasia f = new Fantasia();
                    f.setCodFantasia(rs.getInt("ID_FANTASIA"));
                    f.setNome(rs.getString("NOME"));
                    f.setCategoria(rs.getString("CATEGORIA"));
                    f.setTamanho(rs.getString("TAMANHO"));
                    f.setNomeEstado(rs.getString("ESTADO"));
                    f.setDiaria(rs.getDouble("DIARIA"));
                    return f;
                }
            });
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    @Override
    public void operacao(Fantasia f, String operacao) {
        String sql = null;
        List<Object> params = new ArrayList<>();  
        if(operacao.equals("Excluir")){
            sql = "DELETE FROM "+tabela
                    +" WHERE ID_FANTASIA = ?";
            params.add(f.getCodFantasia());
        }else{
            params.add(f.getNome());
            params.add(f.getCategoria());
            params.add(f.getTamanho());
            params.add(f.getEstado());
            params.add(f.getDiaria());
            if(operacao.equals("Incluir")){
                sql = "INSERT INTO "+tabela+" ("
                        + "NOME, "
                        + "CATEGORIA, "
                        + "TAMANHO, "
                        + "ESTADO, "
                        + "DIARIA"
                        + ") VALUES (?,?,?,?,?)";
            } else if(operacao.equals("Editar")){
                sql = "UPDATE "+tabela+" SET "
                        + "NOME = ?, "
                        + "CATEGORIA = ?, "
                        + "TAMANHO = ?, "
                        + "ESTADO = ?, "
                        + "DIARIA = ? "
                        + "WHERE ID_FANTASIA = ?";
                params.add(f.getCodFantasia());
            }
        }
        try {
            super.operacaoClasse(sql, params);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
