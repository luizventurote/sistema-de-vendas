package control;

import dao.PedidoDao;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Pedido;
import view.PedidoWin;

/**
 *
 * @author Luiz
 */
public class PedidoControl {

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
    public void insert(int produto_id, int cliente_id, int funcionario_id, String status, String data_pedido) throws Exception, SQLException {
        
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
     * Converte e formata uma String para uma data
     * @param data
     * @return Data formatada
     * @throws Exception 
     */
    public Date formatarData(String data) throws Exception {   
        if (data == null || data.equals(""))  
            return null;  
          
        Date date = null;  
        try {  
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            date = (java.util.Date)formatter.parse(data);  
        } catch (ParseException e) {              
            throw e;  
        }  
        return date;  
    } 

}
