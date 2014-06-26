package model.factory;

/**
 *
 * @author Luiz
 */
public class Cartao implements Pagamento {

    @Override
    public boolean efetuarPagamento() {
        System.out.println("Pagamento efetuado pelo cartão de crédito efetuado!");
        return true;
    }
    
}
