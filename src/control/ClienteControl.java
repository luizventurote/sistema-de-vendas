package control;

import dao.ClienteDao;
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
import model.Cliente;
import view.ClienteWin;

/**
 *
 * @author Luiz
 */
public class ClienteControl {

    private static ClienteControl instance = new ClienteControl();
    ClienteDao dao;
    Cliente obj;

    private ClienteControl() {

        try {
            this.dao = new ClienteDao();
        } catch (Exception ex) {
            Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ClienteControl getInstance() {
        return instance;
    }

    /**
     * Inserir
     *
     * @param name
     * @throws Exception
     * @throws SQLException
     */
    public void insert(String nome, String email, String nasc, String tel, String cel, String end, String bairro, String cidade, String uf, String comp, String num) throws Exception, SQLException {
        
        this.obj = new Cliente();
        this.obj.setNome(nome);
        this.obj.setEmail(email);
        this.obj.setDataNasc( this.formatarData(nasc) );
        this.obj.setTelFixo(tel);
        this.obj.setTelCel(cel);
        this.obj.setEndereco(end);
        this.obj.setBairro(bairro);
        this.obj.setCidade(cidade);
        this.obj.setUf(uf);
        this.obj.setNumero( Integer.parseInt( num ) );
        this.obj.setComplemento(comp);
        dao.insert(this.obj);
        
        JOptionPane.showMessageDialog(null, "Inserido com sucesso!");

    }

    /**
     * Update
     *
     * @param id
     * @param text
     */
    public void update(int id, String nome, String email, String nasc, String tel, String cel, String end, String bairro, String cidade, String uf, String comp, String num) throws Exception, SQLException {

        this.obj = new Cliente();
        this.obj.setId(id);
        this.obj.setNome(nome);
        this.obj.setEmail(email);
        this.obj.setDataNasc( this.formatarData(nasc) );
        this.obj.setTelFixo(tel);
        this.obj.setTelCel(cel);
        this.obj.setEndereco(end);
        this.obj.setBairro(bairro);
        this.obj.setCidade(cidade);
        this.obj.setUf(uf);
        this.obj.setNumero( Integer.parseInt( num ) );
        this.obj.setComplemento(comp);
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
        Cliente comp = this.dao.get(id);

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
        Cliente obj;

        int size_list = components.size();

        if (size_list > 0) {

            // Config table
            int linha = 0;
            int col = 0;

            Iterator<Cliente> it = components.iterator(); //iterator
            while (it.hasNext()) {

                obj = it.next();

                // New line
                ((DefaultTableModel) table.getModel()).addRow(new Vector());
                table.setValueAt(obj.getId(), linha, col++);
                table.setValueAt(obj.getNome(), linha, col++);
                table.setValueAt(obj.getEmail(), linha, col++);
                table.setValueAt(obj.getDataNasc(), linha, col++);
                table.setValueAt(obj.getTelFixo(), linha, col++);
                table.setValueAt(obj.getTelCel(), linha, col++);
                table.setValueAt(obj.getEndereco(), linha, col++);
                table.setValueAt(obj.getNumero(), linha, col++);
                table.setValueAt(obj.getBairro(), linha, col++);
                table.setValueAt(obj.getCidade(), linha, col++);
                table.setValueAt(obj.getUf(), linha, col++);
                table.setValueAt(obj.getComplemento(), linha, col);

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
    private Cliente get(int id) throws Exception, SQLException {

        return this.dao.get(id);

    }

    /**
     * Carrega dados na tabela
     *
     * @param win
     * @param id
     */
    public void loadValuesByID(ClienteWin win, int id) throws Exception, SQLException {

        Cliente obj = this.get(id);
        
        win.setId( id );
        win.setNome( obj.getNome() );
        win.setEmail( obj.getEmail() );
        win.setNasc(obj.getDataNasc().toString());
        win.setTel(obj.getTelFixo());
        win.setCel(obj.getTelCel());
        win.setEnd(obj.getEndereco());
        win.setBairro(obj.getBairro());
        win.setNum( Integer.toString( obj.getNumero() ) );
        win.setComp(obj.getComplemento());
        win.setUf(obj.getUf());
        win.setCidade(obj.getCidade());
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
