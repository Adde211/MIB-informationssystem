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
public class Databas {
             
    public InfDB mibdb;
    
    public Databas () {
        
        try {
            
        mibdb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        
        }
        catch (InfException ex) {

            JOptionPane.showMessageDialog(null, "Databasen mibdb nåddes inte.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
}
    
    
}
