package DAO;

import Modelo.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO extends GenericoDAO<Pessoa>{

    private static PessoaDAO instance = new PessoaDAO();
    private final String tabela = "PESSOA";
    
    public static PessoaDAO getInstance() {
        return instance;
    }

    @Override
    public List<Pessoa> obterTs() {
        List<Pessoa> ps = new ArrayList<>();
        List<Object> params = new ArrayList<>();
        try {
            ps = super.obterClasses("SELECT * FROM "+tabela, params, new RowMapping() {
                @Override
                public Object mapeamento(ResultSet rs) throws SQLException {
                    Pessoa p = new Pessoa();
                    p.setCodPessoa(rs.getInt("ID_PESSOA"));
                    p.setCpf(rs.getString("CPF"));
                    p.setNome(rs.getString("NOME"));
                    p.setEmail(rs.getString("EMAIL"));
                    return p;
                }
            });
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    public Pessoa obterT(int codPessoa) {
        Pessoa p = new Pessoa();
        String sql = "SELECT * FROM "+tabela+" WHERE ID_PESSOA = ?";
        List<Object> params = new ArrayList<>();
        params.add(codPessoa);
        try {
            p = super.obterClasse(sql, params, new RowMapping() {
                @Override
                public Object mapeamento(ResultSet rs) throws SQLException {
                    Pessoa p = new Pessoa();
                    p.setCodPessoa(rs.getInt("ID_PESSOA"));
                    p.setCpf(rs.getString("CPF"));
                    p.setNome(rs.getString("NOME"));
                    p.setEmail(rs.getString("EMAIL"));
                    return p;
                }
            });
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void operacao(Pessoa p, String operacao) {
        String sql = null;
        List<Object> params = new ArrayList<>();  
        if(operacao.equals("Excluir")){
            sql = "DELETE FROM "+tabela
                    +" WHERE ID_PESSOA = ?";
            params.add(p.getCodPessoa());
        }else{
            params.add(p.getCpf());
            params.add(p.getNome());
            params.add(p.getEmail());
            if(operacao.equals("Incluir")){
                sql = "INSERT INTO "+tabela+" ("
                        + "CPF, "
                        + "NOME, "
                        + "EMAIL"
                        + ") VALUES (?,?,?)";
            } else if(operacao.equals("Editar")){
                sql = "UPDATE "+tabela+" SET "
                        + "CPF = ?, "
                        + "NOME = ?, "
                        + "EMAIL = ? "
                        + "WHERE ID_PESSOA = ?";
                params.add(p.getCodPessoa());
            }
        }
        try {
            super.operacaoClasse(sql, params);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
