package DAO;

import Modelo.Aluguel;
import Modelo.Fantasia;
import Modelo.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class AluguelDAO extends GenericoDAO<Aluguel>{

    private static AluguelDAO instance = new AluguelDAO();
    private final String tabela = "ALUGUEL";
    private final List<Object> params = new ArrayList<>();
    private String sql = null;
    
    public static AluguelDAO getInstance() {
        return instance;
    }
    
    @Override
    public List<Aluguel> obterTs() throws ServletException {
        params.clear();
        List<Aluguel> as = new ArrayList<>();
        sql = "SELECT * FROM "+tabela;
        try {
            as = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return as;
    }

    @Override
    public Aluguel obterT(int codAluguel) throws ServletException {
        params.clear();
        Aluguel a = new Aluguel();
        sql = "SELECT * FROM "+tabela+" WHERE ID_ALUGUEL = ?";
        params.add(codAluguel);
        try {
            a = super.obterClasse(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        return a;
    }

    @Override
    public void operacao(Aluguel a, String operacao) throws ServletException {
        params.clear();
        if(operacao.equals("Excluir")){
            sql = "DELETE FROM "+tabela
                    +" WHERE ID_ALUGUEL = ?";
            params.add(a.getCodAluguel());
        }else{
            params.add(a.getDataAluguel());
            params.add(a.getDataDevolucao());
            params.add(a.getPromocao());
            params.add(a.getPrecoAluguel());
            params.add(a.getFantasia().getCodFantasia());
            params.add(a.getPessoa().getCodPessoa());
            if(operacao.equals("Incluir")){
                sql = "INSERT INTO "+tabela+" ("
                        + "DATA_ALUGUEL, "
                        + "DATA_DEVOLUCAO, "
                        + "PROMOCAO, "
                        + "PRECO_ALUGUEL, "
                        + "FANTASIA_ID_FANTASIA, "
                        + "PESSOA_ID_PESSOA "
                        + ") VALUES (?,?,?,?,?,?)";
            } else if(operacao.equals("Editar")){
                sql = "UPDATE "+tabela+" SET "
                        + "DATA_ALUGUEL = ?, "
                        + "DATA_DEVOLUCAO = ?, "
                        + "PROMOCAO = ?, "
                        + "PRECO_ALUGUEL = ?, "
                        + "FANTASIA_ID_FANTASIA = ?, "
                        + "PESSOA_ID_PESSOA = ? "
                        + "WHERE ID_ALUGUEL = ?";
                params.add(a.getCodAluguel());
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
                Aluguel a = new Aluguel();
                a.setCodAluguel(rs.getInt("ID_ALUGUEL"));
                a.setDataAluguel(rs.getDate("DATA_ALUGUEL"));
                a.setDataDevolucao(rs.getDate("DATA_DEVOLUCAO"));
                a.setPromocao(rs.getString("PROMOCAO"));
                a.setPrecoAluguel(rs.getDouble("PRECO_ALUGUEL"));
                a.setFantasia((Fantasia) FantasiaDAO.getInstance().obterT(rs.getInt("FANTASIA_ID_FANTASIA")));
                a.setPessoa((Pessoa) PessoaDAO.getInstance().obterT(rs.getInt("PESSOA_ID_PESSOA")));
                return a;
            }
        };
    }
    
}
