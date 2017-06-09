package Modelo;

public class FantasiaEstadoDisponivel implements FantasiaEstado{

    @Override
    public String getEstado() {
        return "Disponível";
    }

    @Override
    public boolean disponibilizar(Fantasia f) {
        //f.setEstado(new FantasiaEstadoDisponivel());
        return false;
    }

    @Override
    public boolean alugar(Fantasia f) {
        f.setEstado(new FantasiaEstadoAlugada());
        return true;
    }

    @Override
    public boolean descartar(Fantasia f) {
        f.setEstado(new FantasiaEstadoDescartada());
        return true;
    }

    @Override
    public boolean restaurar(Fantasia f) {
        f.setEstado(new FantasiaEstadoRestaurando());
        return true;
    }
    
}
