package control;

import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import view.ProdutoWin;

/**
 *
 * @author Luiz
 */
public class ProdutoControl {

    private static ProdutoControl instance = new ProdutoControl();
    ProdutoDao dao;
    Produto frame;

    private ProdutoControl() {

        try {
            this.dao = new ProdutoDao();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ProdutoControl getInstance() {
        return instance;
    }

    /**
     * Inserir
     *
     * @param name
     * @throws Exception
     * @throws SQLException
     */
    public void insert(String name) throws Exception, SQLException {

        this.frame = new Produto();
        this.frame.setNome(name);

        dao.insert(this.frame);

    }

    /**
     * Update
     *
     * @param id
     * @param text
     */
    public void update(int id, String nome) throws Exception, SQLException {

        this.frame = new Produto();
        this.frame.setId(id);
        this.frame.setNome(nome);

        dao.update(this.frame);

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
        Produto comp = this.dao.get(id);

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
        Produto obj;

        int size_list = components.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Produto> it = components.iterator(); //iterator
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
    private Produto get(int id) throws Exception, SQLException {

        return this.dao.get(id);

    }

    /**
     * Carrega dados na tabela
     *
     * @param win
     * @param id
     */
    public void loadValuesByID(ProdutoWin win, int id) throws Exception, SQLException {

        Produto obj = this.get(id);

    }

}
