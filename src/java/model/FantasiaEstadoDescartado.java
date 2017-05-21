package model;

public class FantasiaEstadoDescartado implements FantasiaEstado{
    @Override
    public String getEstado() {
        return "Descartada";
    }

    @Override
    public String disponibilizar(Fantasia fantasia) {
        return "A fantasia não pode ser disponibilizada";
    }
    @Override
    public String alugar(Fantasia fantasia) {
        return "A fantasia não pode ser alugada";
    }

    @Override
    public String descartar(Fantasia fantasia) {
        return "A fantasia já está descartada";
    }

    @Override
    public String restaurar(Fantasia fantasia) {
        return "A fantasia não pode ser restaurada";
    }   
}
