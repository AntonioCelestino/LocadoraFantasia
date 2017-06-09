package Modelo;

import java.util.Observable;
import java.util.Observer;

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
    
    public void observarFantasia(Observable fantasia){
        fantasia.addObserver(this);
    }
    
    @Override
    public void update(Observable fantasiaSubject, Object arg1){
        if(fantasiaSubject instanceof Fantasia){
            Fantasia f = (Fantasia) fantasiaSubject;
            System.out.println("Atenção "+pessoa.getNome()+", a fantasia "+f.getNome()+" está "+f.getNomeEstado());
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
