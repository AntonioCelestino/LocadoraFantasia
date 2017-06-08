package Modelo;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer{
    private Observable fantasia;
    private List<Fantasia> fantasias;
    
    protected int codCliente;
    private String tipo;
    protected Pessoa pessoa;

    public Cliente() {
    }
    
    public Cliente(String nome, List<Fantasia> fantasias){
        this.pessoa = new Pessoa();
        this.pessoa.setNome(nome);
        this.fantasias = fantasias;
    }
    
    public void confereEstado(String estado){
        for(Fantasia fan : getFantasias()){
            setFantasia(fan);
            fantasia.addObserver(this);
            fan.setNomeEstado(estado);
        }
    }
    
    @Override
    public void update(Observable fantasiaSubject, Object arg1){
        if(fantasiaSubject instanceof Fantasia){
            Fantasia f = (Fantasia) fantasiaSubject;
                System.out.println("Atenção "+pessoa.getNome()+", a fantasia "+f.getNome()+" está "+f.getNomeEstado());
        }
    }
    
    public List<Fantasia> getFantasias() {
        return fantasias;
    }
    public void setFantasias(List<Fantasia> fantasias) {
        this.fantasias = fantasias;
    }
    public Observable getFantasia() {
        return fantasia;
    }
    public void setFantasia(Observable fantasia) {
        this.fantasia = fantasia;
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
