package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Categoria extends Atributo{

    private ArrayList atributos = new ArrayList();

    public Categoria(String descricao) {
        super(descricao);
    }
    
    public void addAtributo(Atributo atributo){
        atributos.add(atributo);
    }

    @Override
    public String getDescricao() {
        String descricaoSaida = "<p><b>"+this.descricao+":</b></p><ul>";
        for (Iterator i = atributos.iterator(); i.hasNext();) {
            Atributo atributo = (Atributo) i.next();
            descricaoSaida += atributo.getDescricao();
        }
        return descricaoSaida+"</ul>";
    }
    
}
