package Modelo;

public class FantasiaMemento {
    private FantasiaEstado estado;

    public FantasiaMemento(FantasiaEstado estadoSalvar) {
        this.estado = estadoSalvar;
    }

    public FantasiaEstado getEstadoSalvo() {
        return estado;
    }
    
    @Override
    public String toString(){
        return estado.getEstado();
    }
}
