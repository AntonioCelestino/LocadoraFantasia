package model;

public class FantasiaEstadoDisponivel implements FantasiaEstado{
    
    @Override
    public String getEstado() {
        return "Disponível";
    }

    @Override
    public String disponibilizar(Fantasia fantasia) {
        return "A fantasia já está disponível";
    }
    @Override
    public String alugar(Fantasia fantasia) {
        fantasia.setEstado(new FantasiaEstadoAlugado());
        return "A fantasia pode ser alugada";
    }

    @Override
    public String descartar(Fantasia fantasia) {
        fantasia.setEstado(new FantasiaEstadoDescartado());
        return "A fantasia pode ser descartada";
    }

    @Override
    public String restaurar(Fantasia fantasia) {
        fantasia.setEstado(new FantasiaEstadoRestaurando());
        return "A fantasia pode ser restaurada";
    }
}
