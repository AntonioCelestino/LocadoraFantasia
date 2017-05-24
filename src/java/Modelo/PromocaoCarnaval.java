package Modelo;

public class PromocaoCarnaval implements Promocao{

    @Override
    public String getPromocao() {
        return "Promoção de Carnaval";
    }

    @Override
    public double getDesconto() {
        return 0.10;
    }
    
}
