package Modelo;

public class FantasiaEstadoRestaurando implements FantasiaEstado{

    @Override
    public String getEstado() {
        return "Restaurando";
    }

    @Override
    public boolean disponibilizar(Fantasia f) {
        f.setEstado(new FantasiaEstadoDisponivel());
        return true;
    }

    @Override
    public boolean alugar(Fantasia f) {
        //f.setEstado(new FantasiaEstadoAlugado());
        return false;
    }

    @Override
    public boolean descartar(Fantasia f) {
        f.setEstado(new FantasiaEstadoDescartada());
        return true;
    }

    @Override
    public boolean restaurar(Fantasia f) {
        //f.setEstado(new FantasiaEstadoRestaurando());
        return true;
    }
    
}
