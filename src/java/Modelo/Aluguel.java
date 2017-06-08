package Modelo;

import Controller.ActionFactory;
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
    private String dtAluguel;
    private String dtDevolucao;
    private Promocao promocao;
    private double precoAluguel;
    
    private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

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
    
    public String getDtAluguel() {
        return dtAluguel;
    }
    
    public void setDataAluguel(Date dataAluguel){
        this.dataAluguel = dataAluguel;
        df.setLenient(false);
        this.dtAluguel = df.format(dataAluguel);
    }

    public void setDtAluguel(String dataAluguel) throws ParseException {
        df.setLenient(false);
        this.dataAluguel = df.parse(dataAluguel);
        this.dtAluguel = dataAluguel;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    
    public String getDtDevolucao() {
        return dtDevolucao;
    }
    
    public void setDataDevolucao(Date dataDevolucao){
        this.dataDevolucao = dataDevolucao;
        df.setLenient(false);
        this.dtDevolucao = df.format(dataDevolucao);
    }

    public void setDtDevolucao(String dataDevolucao) throws ParseException {
        df.setLenient(false);
        this.dataDevolucao = df.parse(dataDevolucao);
        this.dtDevolucao = dataDevolucao;
    }

    public String getPromocao() {
        if(promocao == null){return "";}
        return promocao.getPromocao();
    }

    public void setPromocao(String promocao) {
        if(!promocao.equals("")){
            Promocao actionObject = ActionFactory.promocao("Modelo.Promocao"+promocao); 
            this.promocao = actionObject;
        }else{
            this.promocao = null;
        }
    }
    
    public Promocao getP(){
        return promocao;
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
            setDataDevolucao(new Date());      
        }      
        long dt = (dataDevolucao.getTime() - dataAluguel.getTime()) + 3600000;
        Double precoFixo = 10.00;
        precoAluguel = precoFixo + (fantasia.getDiaria() * (dt / 86400000L));
        if(promocao != null){
            precoAluguel = precoAluguel - ((precoAluguel)*((promocao.getDesconto())/100));
        }
    }
}
