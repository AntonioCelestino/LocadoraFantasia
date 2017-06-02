package DAO;

import Modelo.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class PessoaDAO extends GenericoDAO<Pessoa>{

    private static PessoaDAO instance = new PessoaDAO();
    private final String tabela = "PESSOA";
    private final List<Object> params = new ArrayList<>();
    private String sql = null;
    
    public static PessoaDAO getInstance() {
        return instance;
    }

    @Override
    public List<Pessoa> obterTs() throws ServletException{
        params.clear();
        List<Pessoa> ps = new ArrayList<>();
        sql = "SELECT * FROM "+tabela;
        try {
            ps = super.obterClasses(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        return ps;
    }

    @Override
    public Pessoa obterT(int codPessoa) throws ServletException{
        params.clear();
        Pessoa p = new Pessoa();
        sql = "SELECT * FROM "+tabela+" WHERE ID_PESSOA = ?";
        params.add(codPessoa);
        try {
            p = super.obterClasse(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return p;
    }

    @Override
    public void operacao(Pessoa p, String operacao) throws ServletException{ 
        params.clear();
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
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected RowMapping getMapa(){
        return new RowMapping() {
            @Override
            public Object mapeamento(ResultSet rs) throws SQLException {
                Pessoa p = new Pessoa();
                p.setCodPessoa(rs.getInt("ID_PESSOA"));
                p.setCpf(rs.getString("CPF"));
                p.setNome(rs.getString("NOME"));
                p.setEmail(rs.getString("EMAIL"));
                return p;
            }
        };
    }
}
