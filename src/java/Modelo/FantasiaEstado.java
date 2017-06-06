package Modelo;

public interface FantasiaEstado {
    public String getEstado();
    public boolean disponibilizar(Fantasia f);
    public boolean alugar(Fantasia f);
    public boolean descartar(Fantasia f);
    public boolean restaurar(Fantasia f);
}
