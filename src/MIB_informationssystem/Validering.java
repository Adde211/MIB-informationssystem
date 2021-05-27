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
    
    //Alternativ till att använda koden tfNAMN.getText().isEmpty()
    /* 
    public static boolean tfHarText(javax.swing.JTextField tf) {
        
        boolean tfHarText = false;
                
        if (tf.getText().isEmpty()) {
            
            tfHarText = false;
        }
        else {
            tfHarText = true;
        }
        
        return tfHarText;
    }
    */
    
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
    
    /* Metoden kollar ifall ett inmatat telefonnummer har fler än ett tecken annat än siffror.
       Om telefonnumret har fler än ett tecken annat än siffror så returneras ett felmeddelande, annars returneras en tom sträng.
    
        @param telenum Det inmatade telefonnumret.
    */
    public static String kollaEttTelefonnummer(String telenum) {
        
        String felmeddelande = null;
        char[] telenumChars = telenum.toCharArray();
        int numOfNonInts = 0;
        
        //  Kollar hur många tecken som det inmatade telefonnumret har annat än siffror.
        for (char character : telenumChars) {
            
            try {
                Character.getNumericValue(character);
            }
            catch(NumberFormatException ex) {
                ++numOfNonInts;
            }
        }
        
        if(numOfNonInts >= 2) {
            felmeddelande = "Telefonnumret få högst ha 1 tecken annat än siffror.";
        }
        
        return felmeddelande;
    }
    
    
    public static String kollaOmEttDatumArGiltigt(String datum) {
        
        String[] substrings = datum.split("-");
        String felmeddelande = null;
        
        /*  
            Kollar om datumet har fler än två bindesstreck i rad på minst ett ställe.
            I så fall så kommer ett felmeddelande att returneras.
        */
        for(String substring : substrings)  {
            if(substring.isEmpty()) {
                felmeddelande = "Datumet behövear ha formatet ÅÅÅÅ-MM-DD";
            }
        }
        
        if(felmeddelande.isEmpty()) {
            if(datum.endsWith("-") || !(substrings[0].length() == 4 && substrings[0].length() == 2 && substrings[0].length() == 2)) {
                
                felmeddelande = "Datumet behövear ha formatet ÅÅÅÅ-MM-DD";
            }
        }
        
        return felmeddelande;
    }
    
    
    
    
    
    
    
    
    
}
