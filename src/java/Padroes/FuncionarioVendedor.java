package Padroes;

public class FuncionarioVendedor extends Modelo.Funcionario{
    
    public FuncionarioVendedor(Modelo.Funcionario superior){    
        listaAtividades.add(RolAtividades.getInstance().getTipoAtividadeVender());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo(){
        return "Vendedor aluga a fantasia";
    }
    
}
