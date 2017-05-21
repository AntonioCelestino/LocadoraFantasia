package model;

public interface FantasiaEstado {
    public String getEstado();
    public String disponibilizar(Fantasia fantasia);
    public String alugar(Fantasia fantasia);
    public String descartar(Fantasia fantasia);
    public String restaurar(Fantasia fantasia);
}
