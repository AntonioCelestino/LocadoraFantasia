package model;

public class Funcionario extends Pessoa{
    private String cargo;

    public Funcionario(String cpf, String nome, String email, String cargo) {
        super(cpf, nome, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
