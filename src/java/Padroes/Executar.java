package Padroes;

import Modelo.Cliente;
import Modelo.Fantasia;

public class Executar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // PADRÃO OBSERVER
        System.out.println("Implementação do Padrão Observer\n");
        Fantasia wolverine = new Fantasia("Wolverine");
        Fantasia mistica = new Fantasia("Mistica");
        
        Cliente fulano = new Cliente("Fulano");
        Cliente beltrano = new Cliente("beltrano");

        fulano.observarFantasia(mistica);
        fulano.observarFantasia(wolverine);
        beltrano.observarFantasia(mistica);
        beltrano.observarFantasia(wolverine);
        
        wolverine.setNomeEstado("Disponível");
        mistica.setNomeEstado("Alugada");
    }
    
}
