package DAO;

import Modelo.Funcionario;
import Modelo.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class FuncionarioDAO extends GenericoDAO<Funcionario>{

    private static FuncionarioDAO instance = new FuncionarioDAO();
    private final String tabela = "FUNCIONARIO";
    private final List<Object> params = new ArrayList<>();
    private String sql = null;
    
    public static FuncionarioDAO getInstance() {
        return instance;
    }
    
    @Override
    public List<Funcionario> obterTs() throws ServletException{
        params.clear();
        List<Funcionario> fs = new ArrayList<>();
        sql = "SELECT * FROM "+tabela;
        try {
            fs = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return fs;
    }

    @Override
    public Funcionario obterT(int codFuncionario) throws ServletException{
        params.clear();
        Funcionario f = new Funcionario();
        sql = "SELECT * FROM "+tabela+" WHERE ID_FUNCIONARIO = ?";
        params.add(codFuncionario);
        try {
            f = super.obterClasse(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        return f;
    }

    @Override
    public void operacao(Funcionario f, String operacao) throws ServletException{
        params.clear();
        if(operacao.equals("Excluir")){
            sql = "DELETE FROM "+tabela
                    +" WHERE ID_FUNCIONARIO = ?";
            params.add(f.getCodFuncionario());
        }else{
            params.add(f.getCargo());
            params.add(f.getPessoa().getCodPessoa());
            if(operacao.equals("Incluir")){
                sql = "INSERT INTO "+tabela+" ("
                        + "CARGO, "
                        + "PESSOA_ID_PESSOA "
                        + ") VALUES (?,?)";
            } else if(operacao.equals("Editar")){
                sql = "UPDATE "+tabela+" SET "
                        + "CARGO = ?, "
                        + "PESSOA_ID_PESSOA = ? "
                        + "WHERE ID_FUNCIONARIO = ?";
                params.add(f.getCodFuncionario());
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
                Funcionario f = new Funcionario();
                f.setCodFuncionario(rs.getInt("ID_FUNCIONARIO"));
                f.setCargo(rs.getString("CARGO"));
                f.setPessoa((Pessoa) PessoaDAO.getInstance().obterT(rs.getInt("PESSOA_ID_PESSOA")));
                return f;
            }
        };
    }
    
}
