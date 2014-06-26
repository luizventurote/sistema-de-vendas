package model.factory;

import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class AVista implements Pagamento {

    @Override
    public boolean efetuarPagamento() {
        JOptionPane.showMessageDialog(null, "Pagamento à vista efetuado!");
        return true;
    }
    
}
