package Modelo;

public class FantasiaEstadoRestaurando implements FantasiaEstado{

    @Override
    public String getEstado() {
        return "Restaurando";
    }

    @Override
    public String disponibilizar(Fantasia f) {
        f.setEstado(new FantasiaEstadoDisponivel());
        return "está "+f.getEstado();
    }

    @Override
    public String alugar(Fantasia f) {
        f.setEstado(new FantasiaEstadoAlugado());
        return "está "+f.getEstado();
    }

    @Override
    public String descartar(Fantasia f) {
        f.setEstado(new FantasiaEstadoDescartado());
        return "está "+f.getEstado();
    }

    @Override
    public String restaurar(Fantasia f) {
        f.setEstado(new FantasiaEstadoRestaurando());
        return "já está "+f.getEstado();
    }
    
}
