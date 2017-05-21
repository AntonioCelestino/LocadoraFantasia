package model;

public class Aluguel {
    private int codAluguel;
    private String dataAluguel;
    private String dataDevolucao;

    public Aluguel(int codAluguel, String dataAluguel, String dataDevolucao) {
        this.codAluguel = codAluguel;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }

    public int getCodAluguel() {
        return codAluguel;
    }

    public void setCodAluguel(int codAluguel) {
        this.codAluguel = codAluguel;
    }

    public String getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public double calculaPrecoAluguel(){
        double preco=0; // implementar o calculo
        return preco;
    }
    
}
