package control.memento;


import dao.ClienteDao;
import java.util.List;
import model.Cliente;

/**
 * "Recordacao"
 * @author Luiz
 */
public class ClienteMemento {
    
    private ClienteDao dao = new ClienteDao();
    protected Cliente cli;

    public ClienteMemento(int id) throws Exception { 
        if(id > 0) {
            this.cli = dao.get(id);
        }
    }

    public int getIdSalvo() {
        return this.cli.getId();
    }
    
    public String getNomeSalvo() {
        return this.cli.getNome();
    }
    
    public String getEmailSalvo() {
        return this.cli.getEmail();
    }
    
}
