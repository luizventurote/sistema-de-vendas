package control;

import dao.ClienteDao;
import dao.FuncionarioDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Funcionario;
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
    public void insert(int cliente_id, int funcionario_id, int status, String data_pedido, JTable table) throws Exception, SQLException {

        // Produto
        ProdutoDao prod_dao = new ProdutoDao();

        // Cliente
        ClienteDao cli_dao = new ClienteDao();

        // Funcionário
        FuncionarioDao fun_dao = new FuncionarioDao();

        this.obj = new Pedido();
        this.obj.setCliente(cli_dao.get(cliente_id));
        this.obj.setFuncionario(fun_dao.get(funcionario_id));
        this.obj.setStatus(this.getStatus(status));
        this.obj.setData(this.formatarData(data_pedido));
        this.obj.setValor(this.updateTotalValue(table));

        // Insere os arquivos ao componente
        int qtd_row = table.getRowCount();

        int id;

        Set<Produto> produtos = new HashSet(0);

        Produto file;

        for (int i = 0; i < qtd_row; i++) {

            // Recupera um objeto pelo ID e adicona na lista 
            id = Integer.parseInt(table.getValueAt(i, 0).toString());
            file = prod_dao.get(id);
            produtos.add(file);

        }

        this.obj.setProdutos(produtos);

        dao.insert(this.obj);

        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

    }

    /**
     * Update
     *
     * @throws Exception
     * @throws SQLException
     */
    public void update(int id, int cliente_id, int funcionario_id, int status, String data_pedido, JTable table) throws Exception, SQLException {

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

        List list = this.getAll();
        Pedido obj;

        int size_list = list.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Pedido> it = list.iterator(); //iterator
            while (it.hasNext()) {

                obj = it.next();

                int id = obj.getId();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(id, linha, col++);
                table.setValueAt(obj.getStatus(), linha, col++);
                table.setValueAt(obj.getCliente().getNome(), linha, col++);
                table.setValueAt(obj.getData(), linha, col++);
                table.setValueAt(obj.getValor(), linha, col);

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

        // Pedido
        Pedido obj = this.get(id);

        // Funcionário
        Funcionario fun = obj.getFuncionario();

        // Cliente
        Cliente cli = obj.getCliente();

        win.setId(id);
        win.setCliente(cli.getId(), cli.getNome());
        win.setVendedor(fun.getId(), fun.getNome());
        win.setData_pedido(obj.getData().toString());
        win.setStatus(this.getStatus(obj.getStatus()));
        this.loadTableProdutos(id, win.getTable());

    }
    
    /**
     * Carrega os produtos da tabela a partir do id do pedido
     * @param table
     * @param list 
     */
    public void loadTableProdutos(int pedido_id, JTable table) throws Exception {
        
        this.cleanTable(table);
        
        // Pedido
        Pedido obj = this.get(pedido_id);
        
        List<Produto> list = new ArrayList(obj.getProdutos());

        int size = list.size();

        int linha = table.getRowCount();
        int col = 0;
        
        Produto produto;

        for (int i = 0; i < size; i++) {

            produto = list.get(i);

            // New line
            ((DefaultTableModel) table.getModel()).addRow(new Vector());
            table.setValueAt(produto.getId(), linha, col++);
            table.setValueAt(produto.getNome(), linha, col++);
            table.setValueAt(produto.getPreco(), linha, col++);
            table.setValueAt(1, linha, col);

            // Reset number of columns
            col = 0;

            linha++;
            
        }
        
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
     *
     * @param table
     * @param id
     * @return
     */
    public boolean SearchIdInTable(JTable table, int id) {

        int qtd_row = table.getRowCount();

        for (int i = 0; i < qtd_row; i++) {

            if (id == Integer.parseInt(table.getValueAt(i, 0).toString())) {
                return true;
            }
        }

        return false;

    }

    /**
     * Pega a string que representa o status do pedido
     *
     * @param type
     * @return
     */
    public String getStatus(int type) {

        switch (type) {
            case 0:
                return "pendente";
            case 1:
                return "confirmado";
            case 2:
                return "cancelado";
        }

        return "";
    }

    /**
     * Pega o int que representa o status do pedido
     *
     * @param type
     * @return
     */
    public int getStatus(String sts) {

        switch (sts) {
            case "pendente":
                return 0;
            case "confirmado":
                return 1;
            case "cancelado":
                return 2;
        }

        return 0;
    }

    /**
     * Atualiza o valor total do pedido
     *
     * @param table
     * @return
     */
    public Float updateTotalValue(JTable table) {

        Float total = Float.parseFloat("0");

        // Pega a quantiade de linhas selecionadas
        int size = table.getRowCount();

        // Soma os valores
        for (int i = 0; i < size; i++) {

            total = (Float.parseFloat(table.getValueAt(i, 2).toString()) * Integer.parseInt(table.getValueAt(i, 3).toString()) + total);
        }

        return total;
    }

}
