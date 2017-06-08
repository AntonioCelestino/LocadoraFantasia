package Modelo;

public abstract class Atributo {
    protected String descricao;

    public Atributo(String descricao) {
        this.descricao = descricao;
    }

    public abstract String getDescricao();

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
