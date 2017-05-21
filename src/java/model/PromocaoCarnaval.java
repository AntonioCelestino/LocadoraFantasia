package model;

public class PromocaoCarnaval implements Promocao{

    @Override
    public double getDesconto() {
        double desconto = 0.5;
        return desconto;
    }

    @Override
    public double getPromocao() {
        double promocao = 0.5;
        return promocao;
    }
}
