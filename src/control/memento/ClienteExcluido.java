package control.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * "Originador"
 *
 * @author Luiz
 */
public class ClienteExcluido {

    ClienteCareTaker caretaker;
    protected int cliente_id;
    protected String cliente_nome;
    protected String cliente_email;

    public ClienteExcluido() {
        this.caretaker = new ClienteCareTaker();
    }

    public void addCliente(int id) throws Exception {
        this.caretaker.adicionarMemento(new ClienteMemento(id));
    }

    public boolean desfazerCliente() throws Exception {

        ClienteMemento cli = caretaker.getUltimoEstadoSalvo();

        if (cli != null) {

            this.cliente_id = cli.getIdSalvo();
            this.cliente_nome = cli.getNomeSalvo();
            this.cliente_email = cli.getEmailSalvo();

            return true;
        }
        
        return false;
        
    }

    public int getClienteId() {
        return this.cliente_id;
    }

    public String getClienteNome() {
        return cliente_nome;
    }

    public String getClienteEmail() {
        return cliente_email;
    }

}
