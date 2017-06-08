package Padroes;

public class FuncionarioVendedor extends Modelo.Funcionario{
    
    public FuncionarioVendedor(Modelo.Funcionario superior){    
        listaAtividades.add(RolAtividades.getInstance().getTipoAtividadeVender());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo(){
        return "Vendedor";
    }
    
}
