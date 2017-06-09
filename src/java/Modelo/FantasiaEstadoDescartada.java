package Modelo;

public class FantasiaEstadoDescartada implements FantasiaEstado{

    @Override
    public String getEstado() {
        return "Descartada";
    }

    @Override
    public boolean disponibilizar(Fantasia f) {
        //f.setEstado(new FantasiaEstadoDisponivel());
        return false;
    }

    @Override
    public boolean alugar(Fantasia f) {
        //f.setEstado(new FantasiaEstadoAlugado());
        return false;
    }

    @Override
    public boolean descartar(Fantasia f) {
        //f.setEstado(new FantasiaEstadoDescartada());
        return false;
    }

    @Override
    public boolean restaurar(Fantasia f) {
        //f.setEstado(new FantasiaEstadoRestaurando());
        return false;
    }
    
}
