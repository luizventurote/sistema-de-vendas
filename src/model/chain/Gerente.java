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
    
    @Override
    public void processarSolicitacao(Float valor) {

        if (valor < 10000.0) {
            System.out.println("Gerente aprovou");
        } else if (successor != null) {
            System.out.println("O valor é muito alto!");
        }
    }

}
