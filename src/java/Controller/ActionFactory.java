package Controller;

import Modelo.FantasiaEstado;
import Modelo.Promocao;

public class ActionFactory {
    public static Action create(String nomeClasse){
        Action actionObject;
        Class classe;
        Object objeto;
        try{
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex){
            return null;
        }
        if(!(objeto instanceof Action)) return null;
        actionObject = (Action) objeto;
        return actionObject;
    }
    
    public static FantasiaEstado estado(String nomeClasse){
        FantasiaEstado estadoObject;
        Class classe;
        Object objeto;
        try{
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex){
            return null;
        }
        if(!(objeto instanceof FantasiaEstado)) return null;
        estadoObject = (FantasiaEstado) objeto;
        return estadoObject;
    }
    
    public static Promocao promocao(String nomeClasse){
        Promocao promocaoObject;
        Class classe;
        Object objeto;
        try{
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex){
            return null;
        }
        if(!(objeto instanceof Promocao)) return null;
        promocaoObject = (Promocao) objeto;
        return promocaoObject;
    }
}