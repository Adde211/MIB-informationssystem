/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author adamd
 */
public class Alienfunktioner {
        
    private static InfDB mibdb;
    
    public Alienfunktioner(InfDB mibdb) {
        
        this.mibdb = mibdb;
    }
    
    
    
    
    public static ArrayList<String> getAlienInfo(javax.swing.JTextField id) {
        
        ArrayList<String> alienInfo = new ArrayList<>();
        String errorMeddelande = "Värdet från mibdb lyckades inte att hämtas.";
        
        String fraga = "SELECT Namn FROM alien Where Alien_ID = " + id.getText();
        try {
        alienInfo.add(mibdb.fetchSingle(fraga));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        fraga = "SELECT Telefonnummer FROM alien Where Alien_ID = " + id.getText();
        try {
        alienInfo.add(mibdb.fetchSingle(fraga));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        
        fraga = "SELECT Benamning FROM plats WHERE Plats_ID = (SELECT plats FROM alien Where Alien_ID = " + id.getText() + ")";
        try {
        alienInfo.add(mibdb.fetchSingle(fraga));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        fraga = "SELECT Namn FROM Agent WHERE Agent_ID = (SELECT Ansvarig_agent FROM alien Where Alien_ID = " + id.getText() + ")";
        try {
        alienInfo.add(mibdb.fetchSingle(fraga));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        fraga = "SELECT Losenord FROM alien Where Alien_ID = " + id.getText();
        try {
        alienInfo.add(mibdb.fetchSingle(fraga));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        fraga = "SELECT Registreringsdatum FROM alien Where Alien_ID = " + id.getText();try {
        alienInfo.add(mibdb.fetchSingle(fraga));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        return alienInfo;
        
    }
    
    
    
    
    
    
    
    
    
    
}
