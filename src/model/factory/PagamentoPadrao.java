package model.factory;

/**
 *
 * @author Luiz
 */
public class PagamentoPadrao implements AbstractFactoryPagamento {

    @Override
    public AVista criarPagamento() {
        return new AVista();
    }
    
}
