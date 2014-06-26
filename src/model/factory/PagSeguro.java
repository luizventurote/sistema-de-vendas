package model.factory;

import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class PagSeguro implements AbstractFactoryPagamento {

    @Override
    public Cartao criarPagamento() {
        JOptionPane.showMessageDialog(null, "Pagamento efetuado pelo cartão!");
        return new Cartao();
    }
    
}
