package Modelo;

public class Cliente {
    protected int codCliente;
    private String tipo;
    protected Pessoa pessoa;

    public Cliente() {
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
