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

    @Override
    public void processarSolicitacao(Float valor) {
        if (valor < 1000.0) {
            System.out.println("Vendedor aprovou");
        } else if (successor != null) {
            successor.processarSolicitacao(valor);
        }
    }

}
