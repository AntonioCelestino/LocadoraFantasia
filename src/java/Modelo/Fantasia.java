package Modelo;

import Controller.ActionFactory;
import java.text.Normalizer;

public class Fantasia {
    private int codFantasia;
    private String nome;
    private String categoria;
    private String tamanho;
    private FantasiaEstado estado;
    private String nomeEstado;
    private double diaria;

    public Fantasia() {
        this.estado = new FantasiaEstadoDisponivel();
    }

    public int getCodFantasia() {
        return codFantasia;
    }

    public void setCodFantasia(int codFantasia) {
        this.codFantasia = codFantasia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEstado() {
        return estado.getEstado();
    }
    
    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setEstado(FantasiaEstado estado) {
        this.estado = estado;
        this.nomeEstado = estado.getEstado();
    }
    
    public void setNomeEstado(String estado) {
        this.nomeEstado = estado;
        estado = removeAcentos(estado);
        FantasiaEstado actionObject = ActionFactory.estado("Modelo.FantasiaEstado"+estado);
        this.estado = actionObject;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }
    
    public String disponibilizar(){
        return estado.disponibilizar(this);
    }
    
    public String descartar(){
        return estado.descartar(this);
    }
    
    public String alugar(){
        return estado.alugar(this);
    }
    
    public String restaurar(){
        return estado.restaurar(this);
    }
    
    private String removeAcentos(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD);
        str = str.replaceAll("[^\\p{ASCII}]", "");
        return str;
    }
}
