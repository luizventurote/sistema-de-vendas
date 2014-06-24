package control;

import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    Produto obj;

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
    public void insert(String nome, int estoque, Float preco, Float peso, String descricao) throws Exception, SQLException {

        this.obj = new Produto();
        this.obj.setNome(nome);
        this.obj.setEstoque(estoque);
        this.obj.setPreco(preco);
        this.obj.setPeso(peso);
        this.obj.setDescricao(descricao);
        dao.insert(this.obj);
        
        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

    }

    /**
     * Update
     *
     * @param id
     * @param text
     */
    public void update(int id, String nome, int estoque, Float preco, Float peso, String descricao) throws Exception, SQLException {

        this.obj = new Produto();
        this.obj.setId(id);
        this.obj.setNome(nome);
        this.obj.setEstoque(estoque);
        this.obj.setPreco(preco);
        this.obj.setPeso(peso);
        this.obj.setDescricao(descricao);
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
                table.setValueAt(obj.getNome(), linha, col++);
                table.setValueAt(obj.getEstoque(), linha, col++);
                table.setValueAt(obj.getPreco(), linha, col);

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
        
        win.setId( id );
        win.setNome( obj.getNome() );
        win.setPreco( obj.getPreco() );
        win.setPeso( obj.getPeso() );
        win.setEstoque( obj.getEstoque() );
        win.setDescricao( obj.getDescricao() );
    }

}
