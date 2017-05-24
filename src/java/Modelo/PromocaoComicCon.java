package Modelo;

public class PromocaoComicCon implements Promocao{

    @Override
    public String getPromocao() {
        return "Promoção do Evento ComicCon";
    }

    @Override
    public double getDesconto() {
        return 0.15;
    }
    
}
