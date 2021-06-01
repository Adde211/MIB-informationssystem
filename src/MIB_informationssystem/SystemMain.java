package MIB_informationssystem;


import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adamd
 */
public class SystemMain {
    
    private static InfDB mibdb;
    
    public static void main(String[] args) {
        try {
            
        mibdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        }
        catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasen mibdb nåddes inte.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        new AlienFunktioner(mibdb);
        new Validering(mibdb);
        
        //new SökPåEnAlien().setVisible(true);
        //new LäggTillEnAlien().setVisible(true);
        //new UppdateraEnAlien().setVisible(true);
        new TaBortEnAlien().setVisible(true);
        
    }
    
    
    
    
    
    
    
}
