package Modelo;

public class FantasiaNome extends Atributo{

    public FantasiaNome(String descricao) {
        super(descricao);
    }

    @Override
    public String getDescricao() {
        return "<li>"+descricao+";</li>";
    }
    
}
