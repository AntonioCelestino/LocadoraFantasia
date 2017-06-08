package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class FantasiaListagem {
    private ArrayList atributos = new ArrayList();

    public void addAtributo(Atributo atributo){
        atributos.add(atributo);
    }
    
    public String listarCategorias(){
        String descricaoCategoria = "<h3>Lista de Fantasias por Categoria: </h3>";
        for (Iterator i = atributos.iterator(); i.hasNext();) {
            Atributo atributo = (Atributo) i.next();
            descricaoCategoria += atributo.getDescricao();
        }
        return descricaoCategoria;
    }
}
