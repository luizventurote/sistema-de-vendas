package control;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    
}
