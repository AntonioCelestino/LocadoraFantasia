package Modelo;

import DAO.InteresseDAO;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

public class Cliente implements Observer{
    protected int codCliente;
    private String tipo;
    protected Pessoa pessoa;

    public Cliente() {
    }
    
    public Cliente(String nome){
        this.pessoa = new Pessoa();
        this.pessoa.setNome(nome);
    }
    
    @Override
    public void update(Observable fantasiaSubject, Object arg1){
        if(fantasiaSubject instanceof Fantasia){
            Fantasia f = (Fantasia) fantasiaSubject;
            try {
                adicionarMensagem("Data: "+new Date()+" | Atenção "+pessoa.getNome()+", a fantasia "
                        +f.getNome()+" está "+f.getNomeEstado()+".\n", f);
            } catch (ServletException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void adicionarMensagem(String msg, Fantasia f) throws ServletException{
        try {
            Interesse i = new Interesse();
            i.setCliente(this);
            i.setFantasia(f);
            i.setMensagem(msg);
            InteresseDAO.getInstance().operacao(i, "Editar");
        } catch (ServletException ex) {
            throw new ServletException(ex);
        }
    }
    
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Integer getDescontoTipo(){
        return null;
    }
    
    public String getDadosCliente(){
        return "Cliente "+this.getPessoa().getNome()+" tem "+this.getDescontoTipo()+"% de Desconto pois é "+this.getTipo();
    }
}
