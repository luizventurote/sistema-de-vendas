package control;

import dao.PedidoDao;
import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Pedido;
import model.Produto;
import view.PedidoWin;

/**
 *
 * @author Luiz
 */
public class PedidoControl extends DefaultControl {

    private static PedidoControl instance = new PedidoControl();
    PedidoDao dao;
    Pedido obj;

    private PedidoControl() {

        try {
            this.dao = new PedidoDao();
        } catch (Exception ex) {
            Logger.getLogger(PedidoControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static PedidoControl getInstance() {
        return instance;
    }

    /**
     * Inserir
     * 
     * @throws Exception
     * @throws SQLException
     */
    public void insert(int cliente_id, int funcionario_id, String status, String data_pedido, JTable table) throws Exception, SQLException {
        
        this.obj = new Pedido();
        dao.insert(this.obj);
        
        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

    }

    /**
     * Update
     * 
     * @throws Exception
     * @throws SQLException
     */
    public void update(int id, int produto_id, int cliente_id, int funcionario_id, String status, String data_pedido) throws Exception, SQLException {

        this.obj = new Pedido();
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
        Pedido comp = this.dao.get(id);

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
        Pedido obj;

        int size_list = components.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Pedido> it = components.iterator(); //iterator
            while (it.hasNext()) {

                obj = it.next();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(obj.getId(), linha, col++);

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
    private Pedido get(int id) throws Exception, SQLException {

        return this.dao.get(id);

    }

    /**
     * Carrega dados na tabela
     *
     * @param win
     * @param id
     */
    public void loadValuesByID(PedidoWin win, int id) throws Exception, SQLException {

        Pedido obj = this.get(id);
        
        win.setId( id );
    } 
    
    /**
     * Adiciona itens na tabela
     *
     * @param list
     */
    public void addItemTable(JTable table, List list) throws Exception, SQLException {

        ProdutoDao produto_dao = new ProdutoDao();

        int id;

        Produto file;

        int size_list = list.size();

        if (size_list > 0) {;

            // Config table
            int linha = table.getRowCount();
            int col = 0;

            for (int i = 0; i < size_list; i++) {

                id = Integer.parseInt(list.get(i).toString());

                if (this.SearchIdInTable(table, id)) { 

                } else {

                    file = produto_dao.get(id);

                    // New line
                    ((DefaultTableModel) table.getModel()).addRow(new Vector());
                    table.setValueAt(file.getId(), linha, col++);
                    table.setValueAt(file.getNome(), linha, col++);
                    table.setValueAt(file.getPreco(), linha, col++);
                    table.setValueAt(1, linha, col);

                    // Reset number of columns
                    col = 0;

                    linha++;

                }
            }
        }
    }
    
    /**
     * Procura por um ID na tabela
     * @param table
     * @param id
     * @return 
     */
    public boolean SearchIdInTable(JTable table, int id) {
        
        int qtd_row = table.getRowCount();
                
        for (int i = 0; i < qtd_row; i++) {

            if( id == Integer.parseInt( table.getValueAt(i, 0).toString() ) ) {
                return true;
            }
        }
        
        return false;
        
    }

}
