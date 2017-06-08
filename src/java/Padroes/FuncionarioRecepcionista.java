package Padroes;

public class FuncionarioRecepcionista extends Modelo.Funcionario{
    
    public FuncionarioRecepcionista(Modelo.Funcionario superior){    
        listaAtividades.add(RolAtividades.getInstance().getTipoAtividadeAtender());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo(){
        return "Recepcionista atende o cliente";
    } 
    
}
