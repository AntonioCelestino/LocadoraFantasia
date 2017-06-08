package Padroes;

public class FuncionarioRecepcionista extends Modelo.Funcionario{
    
    public FuncionarioRecepcionista(Modelo.Funcionario superior){    
        listaAtividades.add(RolAtividades.getInstance().getTipoAtividadeAtender());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo(){
        return "Recepcionista";
    } 
    
}
