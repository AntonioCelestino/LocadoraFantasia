package model;

public class FantasiaEstadoRestaurando implements FantasiaEstado{
    @Override
    public String getEstado() {
        return "Restaurando";
    }

    @Override
    public String disponibilizar(Fantasia fantasia) {
        fantasia.setEstado(new FantasiaEstadoDisponivel());
        return "A fantasia pode ser disponibilizada";
    }
    @Override
    public String alugar(Fantasia fantasia) {
        return "A fantasia não pode ser alugada";
    }

    @Override
    public String descartar(Fantasia fantasia) {
        fantasia.setEstado(new FantasiaEstadoDescartado());
        return "A fantasia pode ser descartada";
    }

    @Override
    public String restaurar(Fantasia fantasia) {
        return "A fantasia já está em restauração";
    }
    
}
