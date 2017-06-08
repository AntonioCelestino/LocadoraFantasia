package Modelo;

import Padroes.Atividade;
import java.util.ArrayList;

public class Funcionario {
    private int codFuncionario;
    private String cargo;
    private Pessoa pessoa;
    
    protected ArrayList listaAtividades = new ArrayList();
    private Funcionario funcionarioSuperior;
    
    public Funcionario getFuncionarioSuperior(){
        return funcionarioSuperior;
    }
    
    public void setFuncionarioSuperior(Funcionario funcionarioSuperior){
        this.funcionarioSuperior = funcionarioSuperior;
    }
    
    public String getDescricaoCargo(){
        return "Cargo";
    }
    
    public String executarAtividade(Atividade atividade){
        if(listaAtividades.contains(atividade.getTipoAtividade())){
            return getDescricaoCargo();
        }
        else{
            if(funcionarioSuperior != null){
                return funcionarioSuperior.executarAtividade(atividade);
            }
            else{
                return "Sem atividade";
            }
        }
    }

    public Funcionario() {
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
