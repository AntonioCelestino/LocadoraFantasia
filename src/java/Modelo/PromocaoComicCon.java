package Modelo;

public class PromocaoComicCon implements Promocao{

    @Override
    public String getPromocao() {
        return "ComicCon";
    }

    @Override
    public double getDesconto() {
        return 15;
    }
    
}
