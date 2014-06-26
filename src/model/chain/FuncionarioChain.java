package model.chain;

/**
 *
 * @author Luiz
 */
public abstract class FuncionarioChain {
    
    protected FuncionarioChain successor;
    
    public void setSucessor(FuncionarioChain successor) {
        this.successor = successor;
    }
    
    public abstract void processarSolicitacao(Float valor); 

}
