package Modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Aluguel {
    private int codAluguel;
    private Pessoa pessoa;
    private Fantasia fantasia;
    private Date dataAluguel;
    private Date dataDevolucao;
    private Promocao promocao;
    private double precoAluguel;

    public Aluguel() {
    }

    public int getCodAluguel() {
        return codAluguel;
    }

    public void setCodAluguel(int codAluguel) {
        this.codAluguel = codAluguel;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Fantasia getFantasia() {
        return fantasia;
    }

    public void setFantasia(Fantasia fantasia) {
        this.fantasia = fantasia;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        df.setLenient(false);
        this.dataAluguel = df.parse(dataAluguel);
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        df.setLenient(false);
        this.dataDevolucao = df.parse(dataDevolucao);
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }
    
    public void calculaPrecoAluguel(){
        //Cálculo do preço do aluguel da fantasia
        //Preco fixo + (Preco diario * número de dias)
        if(dataDevolucao == null){
            dataDevolucao = new Date();
        }      
        long dt = (dataDevolucao.getTime() - dataAluguel.getTime()) + 3600000;
        Double precoFixo = 10.00;
        precoAluguel = precoFixo + (fantasia.getDiaria() * (dt / 86400000L)); 
    }
}
