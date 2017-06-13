package Modelo;

public class Interesse {
    private Cliente cliente;
    private Fantasia fantasia;
    private String mensagem;

    public Interesse() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fantasia getFantasia() {
        return fantasia;
    }

    public void setFantasia(Fantasia fantasia) {
        this.fantasia = fantasia;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
