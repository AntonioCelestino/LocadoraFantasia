package DAO;

import Modelo.Fantasia;
import Modelo.FantasiaMemento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class FantasiaDAO extends GenericoDAO<Fantasia>{

    private final ArrayList<FantasiaMemento> estadosSalvos = new ArrayList<>();
    
    public FantasiaMemento getEstadoAnterior(){
        return estadosSalvos.get(estadosSalvos.size()-1);
    }
    
    public void removerUltimoEstadoAnterior(){
        this.estadosSalvos.remove(estadosSalvos.size()-1);
    }
    
    public void setEstadoAnterior(FantasiaMemento fm){
        this.estadosSalvos.add(fm);
    }
    
    private static FantasiaDAO instance = new FantasiaDAO();
    private final String tabela = "FANTASIA";
    private final List<Object> params = new ArrayList<>();
    private String sql = null;
    
    public static FantasiaDAO getInstance() {
        return instance;
    }

    @Override
    public List<Fantasia> obterTs() throws ServletException {
        params.clear();
        List<Fantasia> fs = new ArrayList<>();
        sql = "SELECT * FROM "+tabela;
        try {
            fs = super.obterClasses(sql, params, getMapa());
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
        return fs;
    }

    @Override
    public Fantasia obterT(int codFantasia) throws ServletException {
        params.clear();
        Fantasia f = new Fantasia();
        sql = "SELECT * FROM "+tabela+" WHERE ID_FANTASIA = ?";
        params.add(codFantasia);
        try {
            f = super.obterClasse(sql, params, getMapa());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
        return f;
    }

    @Override
    public void operacao(Fantasia f, String operacao) throws ServletException {
        params.clear();
        if(operacao.equals("Excluir")){
            sql = "DELETE FROM "+tabela
                    +" WHERE ID_FANTASIA = ?";
            params.add(f.getCodFantasia());
        }else{
            params.add(f.getNome());
            params.add(f.getCategoria());
            params.add(f.getTamanho());
            params.add(f.getNomeEstado());
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
            throw new ServletException(ex);
        }
    }

    @Override
    protected RowMapping getMapa() {
        return new RowMapping() {
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
        };
    }
}
