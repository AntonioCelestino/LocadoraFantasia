package Modelo;

public class FantasiaEstadoDescartado implements FantasiaEstado{

    @Override
    public String getEstado() {
        return "Descartado";
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
        return "já está "+f.getEstado();
    }

    @Override
    public String restaurar(Fantasia f) {
        f.setEstado(new FantasiaEstadoRestaurando());
        return "está "+f.getEstado();
    }
    
}
