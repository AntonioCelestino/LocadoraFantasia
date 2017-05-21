package model;

public class Cliente extends Pessoa{
    private String tipo;
    
    public Cliente(String cpf, String nome, String email, String tipo) {
        super(cpf, nome, email);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
