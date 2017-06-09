package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class FantasiaListagem {
    private ArrayList categorias = new ArrayList();

    public void addAtributo(Atributo atributo){
        categorias.add(atributo);
    }
    
    public String listarCategorias(){
        String descricaoCategoria = "<h3>Lista de Fantasias por Categoria: </h3>";
        for (Iterator i = categorias.iterator(); i.hasNext();) {
            Atributo atributo = (Atributo) i.next();
            descricaoCategoria += atributo.getDescricao();
        }
        return descricaoCategoria;
    }
}
