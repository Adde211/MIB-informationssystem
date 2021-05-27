/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

/**
 *
 * @author adamd
 */
public class Validering {
    
    
    public static String kollaTextField(javax.swing.JTextField tf) {
        
        String retursträng = "";
                
        if (tf.getText().isEmpty()) {
            
            retursträng = "Gör en inmatning.";
        }
        
        return retursträng;
        
    }
    
    public static boolean isHeltal(javax.swing.JTextField tf) {
        
        boolean isHeltal = false;
        
        try {
            Integer.parseInt(tf.getText());
            isHeltal = true;
        }
        catch (NumberFormatException ex) {
            isHeltal = false;
        }
        
        return isHeltal;
    }
    
    
    
    
    
    
}
