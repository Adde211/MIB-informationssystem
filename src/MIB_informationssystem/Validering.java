/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamd
 */
public class Validering {
    
    private static InfDB mibdb;

    public Validering()
    {
        try {
            mibdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        }
        catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasen mibdb nåddes inte.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
    }
    
    
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
    
    
    public static boolean isHeltal(String heltal) {
        
        boolean isHeltal = false;
        
        try {
            Integer.parseInt(heltal);
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
        
        String felmeddelande = "";
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
    
    /*  
        Kollar om datumet har ett gilgt format. Om inte så kommer ett felmeddelande att returneras.
    */
    public static String kollaOmEttDatumArGiltigt(String datum) {
        
        String[] substrings = datum.split("-");
        String felmeddelande = "";
        
        /*  
            Kollar om datumet har fler än två bindesstreck i rad på minst ett ställe.
            I så fall så kommer ett felmeddelande att returneras.
        */
        for(String substring : substrings)  {
            if(substring.isEmpty()) {
                felmeddelande = "Datumet behöver ha formatet ÅÅÅÅ-MM-DD";
            }
        }
        
        /*  
            Kollar om det inmatade datumet har ett bindesstrerck i slutet och om antalet siffror stämmer för år, månad respektive dag. 
            Om något av dessa inte stämmer så kommer ett felmeddelande att returneras.
        */
        if(felmeddelande.isEmpty()) {
            if(datum.endsWith("-") || !(substrings[0].length() == 4 && substrings[0].length() == 2 && substrings[0].length() == 2)) {
                
                felmeddelande = "Datumet behöver ha formatet ÅÅÅÅ-MM-DD";
            }
        }
        
        return felmeddelande;
    }
    
    /*
        Metoden kollar om det inmatade namnet består av fler än 30 tecken.
        I så fall så returneras ett felmeddelande.
    */
    public static String kollaOmEttNamnArGiltigt(String namn) {
        
        String felmeddelande = "";
        
        if(namn.length() >= 31) {
            felmeddelande = "Ett namn kan högst bestå av 30 tecken.";
        }
        
        return felmeddelande;
    }
    
    
    /*  Metoden kollar om det inmatade losenordet är giltigt. För att losenordet ska vara giltigt så behöver lösenordet innehålla
        minst en siffra, minst en versal och minst ett specialtecken. Lösenordet behöver även innehålla mellan 8 och 25 tecken.
    */
    public static String kollaOmLosenordetArGiltigt(String losen) {
        
        int numOfChars = losen.length();
        int numOfDigits = 0;
        int numOfCapLets = 0;
        int numOfSecialChars = 0;
        
        char[] losenChars = losen.toCharArray();
        String felmeddelande = "";
        
        // Går igenom den inmatade strängen och räknar på hur många tecken det finns av typerna siffror, versaler och specialtecken.
        for(char character : losenChars) {
            
            try {
                Character.getNumericValue(character);
                ++ numOfDigits;
            }
            catch(NumberFormatException ex) {
                
                if(character >= 'A' && character <= 'Z') {
                    ++numOfCapLets;
                }
                else if(!(character >= 'a' && character <= 'z')) {
                    ++numOfSecialChars;
                }
            }
        }
        
        /*  
            Kollar om det inmatade losenordet är giltigt baserat på nämnd beskrivning. Om lösenordet inte är giltigt så returneras ett felmeddelande.
        */
        if (numOfChars >= 26 || numOfChars <= 7 || numOfDigits == 0 || numOfCapLets == 0 || numOfSecialChars == 0) {
            felmeddelande = "Lösenordet behöver innehålla minst en siffra, minst en versal och minst ett specialtecken."
                    + " Lösenordet behöver även innehålla mellan 8 och 25 tecken.";
        }
        
        
        return felmeddelande;
    }
    
    
    /*  
         Kollar om det inmatade platsnamnet finns registrerat i databasen eller inte.
         Om inte så returneras ett felmeddelande och ett internt felmeddelande skrivs ut.
    */
    public static String platsArRegistrerad(String platsnamn) {
        
        String felmeddelande = "";
        
        try {
            mibdb.fetchSingle("SELECT Plats_ID FROM Plats WHERE Benamning = " + platsnamn);
        } catch(InfException ex) {
            felmeddelande = "Antingen så skrev du in fel eller så finns inte platsen i systemet än.";
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
            
            return felmeddelande;
    }
    
    
    /*  
         Kollar om det inmatade agentnamnet finns registrerat i databasen eller inte.
         Om inte så returneras ett felmeddelande och ett internt felmeddelande skrivs ut.
    */
    public static String agentArRegistrerad(String agentnamn) {
        
        String felmeddelande = "";
        
        try {
            mibdb.fetchSingle("SELECT Agent_ID FROM Agent WHERE Namn = " + agentnamn);
        } catch(InfException ex) {
            felmeddelande = "Antingen så skrev du in fel eller så finns inte agenten i systemet än.";
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
            
        return felmeddelande;
    }
    
    
    
    
    
}
