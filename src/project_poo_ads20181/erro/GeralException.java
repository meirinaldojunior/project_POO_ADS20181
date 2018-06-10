package project_poo_ads20181.erro;

import javax.swing.JOptionPane;

public class GeralException extends Exception{
    public GeralException(){
        
    }
    
    public GeralException(String x){
        //super(x);
        JOptionPane.showMessageDialog(null, x,"Ops...", JOptionPane.ERROR_MESSAGE);
    }
}
