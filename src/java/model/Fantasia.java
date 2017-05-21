package model;

public class Fantasia {
    private int idFantasia;
    private String nome;
    private String categoria;
    private String tamanho;
    private double diaria;
    private FantasiaEstado estado;

    public Fantasia() {
        this.estado = new FantasiaEstadoDisponivel();
    }
    
    public String getNomeEstado(){
        return estado.getEstado();
    }
    
    public String disponibilizar(){
        return estado.disponibilizar(this);
    } 
    public String alugar(){
        return estado.alugar(this);
    }  
    public String descartar(){
        return estado.descartar(this);
    }   
    public String restaurar(){
        return estado.restaurar(this);
    }   

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public FantasiaEstado getEstado() {
        return estado;
    }
    public void setEstado(FantasiaEstado estado) {
        this.estado = estado;
    }
    
}
