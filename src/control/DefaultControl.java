package control;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luiz
 */
public class DefaultControl {
    
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
    
    /**
     * Limpa o conteúdo de uma tabela
     * @param table 
     */
    public void cleanTable(JTable table) {
        // Clean table
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) table.getModel()).removeRow(i);
        }
    }
    
}
