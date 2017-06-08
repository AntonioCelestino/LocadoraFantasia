package Padroes;

public class FuncionarioGerente extends Modelo.Funcionario{
    
    public FuncionarioGerente(Modelo.Funcionario superior){    
        listaAtividades.add(RolAtividades.getInstance().getTipoAtividadeNegociar());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo(){
        return "Gerente";
    }  
}
