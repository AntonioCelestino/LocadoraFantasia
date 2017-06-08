package Modelo;

public class ClienteVip extends Cliente{
    public ClienteVip(Cliente c){
        this.codCliente = c.getCodCliente();
        this.pessoa = c.getPessoa();
    }
    
    @Override
    public String getTipo() {
        return "Vip";
    }
    
    @Override
    public Integer getDescontoTipo(){
        return 15;
    }
}
