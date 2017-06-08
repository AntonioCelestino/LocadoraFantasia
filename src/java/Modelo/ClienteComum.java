package Modelo;

public class ClienteComum extends Cliente{
    public ClienteComum(Cliente c){
        this.codCliente = c.getCodCliente();
        this.pessoa = c.getPessoa();
    }
    
    @Override
    public String getTipo() {
        return "Comum";
    }
    
    @Override
    public Integer getDescontoTipo(){
        return 10;
    }
}
