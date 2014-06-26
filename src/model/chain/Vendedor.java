package model.chain;

import model.Funcionario;

/**
 *
 * @author Luiz
 */
public class Vendedor extends Funcionario {
    
    public Vendedor() {
        super();
    }

    public void processarSolicitacao(Float valor) {
        
        int val = valor.intValue();
        
        if ( val < 1000 ) {
            System.out.println("Vendedor aprovou");
        } else if (successor != null) {
            System.out.println("Passou para o gerente");
            successor.processarSolicitacao(valor);
        }
    }

}
