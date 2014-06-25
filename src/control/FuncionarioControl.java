package control;

import dao.FuncionarioDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.FuncionarioWin;

/**
 *
 * @author Luiz
 */
public class FuncionarioControl extends DefaultControl {

    private static FuncionarioControl instance = new FuncionarioControl();
    FuncionarioDao dao;
    Funcionario obj;

    private FuncionarioControl() {

        try {
            this.dao = new FuncionarioDao();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static FuncionarioControl getInstance() {
        return instance;
    }

    /**
     * Inserir
     *
     * @param name
     * @throws Exception
     * @throws SQLException
     */
    public void insert(String nome) throws Exception, SQLException {
        
        this.obj = new Funcionario();
        this.obj.setNome(nome);
        dao.insert(this.obj);
        
        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

    }

    /**
     * Update
     *
     * @param id
     * @param text
     */
    public void update(int id, String nome) throws Exception, SQLException {

        this.obj = new Funcionario();
        this.obj.setId(id);
        this.obj.setNome(nome);
        dao.update(this.obj);

        JOptionPane.showMessageDialog(null, "Alterações salvas!");
        
    }

    /**
     * Delete
     *
     * @param id
     * @throws Exception
     * @throws SQLException
     */
    public void delete(int id) throws Exception, SQLException {

        // Pega os dados do objeto a partir do ID
        Funcionario comp = this.dao.get(id);

        // Apaga o registro no banco
        this.dao.delete(comp);

    }

    /**
     * Pega o valor do próximo ID
     *
     * @return valor do próximo ID
     */
    public int getTheNextID() {
        return this.dao.getTheNextID();
    }

    /**
     * Return all inserted Objects.
     */
    private List getAll() throws Exception, SQLException {

        return dao.getAll();

    }

    /**
     * Load Table objects
     *
     * @param table
     * @throws Exception
     * @throws SQLException
     */
    public void loadTable(JTable table) throws Exception, SQLException {

        List components = this.getAll();
        Funcionario obj;

        int size_list = components.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Funcionario> it = components.iterator(); //iterator
            while (it.hasNext()) {

                obj = it.next();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(obj.getId(), linha, col++);
                table.setValueAt(obj.getNome(), linha, col);

                // Reset number of columns
                col = 0;

                linha++;

            }

        }

    }

    /**
     * Get object
     *
     * @param id
     * @return
     * @throws Exception
     * @throws SQLException
     */
    private Funcionario get(int id) throws Exception, SQLException {

        return this.dao.get(id);

    }

    /**
     * Carrega dados na tabela
     *
     * @param win
     * @param id
     */
    public void loadValuesByID(FuncionarioWin win, int id) throws Exception, SQLException {

        Funcionario obj = this.get(id);
        
        win.setId( id );
        win.setNome( obj.getNome() );
    }

}
