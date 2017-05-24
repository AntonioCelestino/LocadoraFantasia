package Modelo;

public interface FantasiaEstado {
    public String getEstado();
    public String disponibilizar(Fantasia f);
    public String alugar(Fantasia f);
    public String descartar(Fantasia f);
    public String restaurar(Fantasia f);
}
