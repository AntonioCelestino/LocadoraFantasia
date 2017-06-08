package Padroes;

public class Executar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // PADRÃO ChainOfResponsability
        FuncionarioGerente gerente = new FuncionarioGerente(null);
        FuncionarioVendedor vendedor = new FuncionarioVendedor(gerente);
        FuncionarioRecepcionista recepcionista = new FuncionarioRecepcionista(vendedor);
        
        System.out.println("Implementação do Padrão ChainOfResponsability\n");
        
        System.out.println(recepcionista.executarAtividade(new Atividade(RolAtividades.getInstance().getTipoAtividadeAtender())));
        System.out.println(recepcionista.executarAtividade(new Atividade(RolAtividades.getInstance().getTipoAtividadeVender())));
        System.out.println(recepcionista.executarAtividade(new Atividade(RolAtividades.getInstance().getTipoAtividadeNegociar())));
        
    }
    
}
