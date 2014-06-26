package model.chain;

import model.Funcionario;

/**
 *
 * @author Luiz
 */
public class Gerente extends Funcionario {

    public Gerente() {
        super();
    }
    
    public void processarSolicitacao(Float valor) {

        int val = valor.intValue();
        
        if (val < 10000) {
            System.out.println("Gerente aprovou");
        } else if (successor != null) {
            System.out.println("O valor é muito alto!");
        }
    }

}
