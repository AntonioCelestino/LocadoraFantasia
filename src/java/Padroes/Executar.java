package Padroes;

import Modelo.Cliente;
import Modelo.Fantasia;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println(gerente.executarAtividade(new Atividade(RolAtividades.getInstance().getTipoAtividadeAtender())));
        
         // PADRÃO OBSERVER
        System.out.println("\n\nImplementação do Padrão Observer\n");
        
        List<Fantasia> fantasias = new ArrayList<Fantasia>();
        Fantasia fantasia = new Fantasia("Wolverine");
        fantasias.add(fantasia);
        
        Cliente cliente = new Cliente("Fulano", fantasias);

        cliente.confereEstado("Disponível");
        cliente.confereEstado("Alugada");
        cliente.confereEstado("Disponível");
        
    }
    
}
