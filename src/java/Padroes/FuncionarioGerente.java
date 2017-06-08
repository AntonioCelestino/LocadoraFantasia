package Padroes;

public class FuncionarioGerente extends Modelo.Funcionario{
    
    public FuncionarioGerente(Modelo.Funcionario superior){    
        listaAtividades.add(RolAtividades.getInstance().getTipoAtividadeNegociar());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo(){
        return "Gerente negocia preço do aluguel";
    }  
}
