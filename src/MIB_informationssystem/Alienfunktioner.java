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
        
        fraga = "SELECT Registreringsdatum FROM alien Where Alien_ID = " + id.getText();
        try {
        alienInfo.add(mibdb.fetchSingle(fraga));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        return alienInfo;
        
    }
    /*
    public static void laggTillEnAlien(ArrayList<String> alienData) {
        
        try {
        String agentID = mibdb.fetchSingle("SELECT Agent_ID FROM Agent WHERE Namn = " + alienData.get(1));
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, "Antingen så skrev du in fel eller så finns inte agenten i systemet än.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        try {
            String platsID = "mibdb.fetchSingle(SELECT Plats_ID FROM Plats WHERE Benamning = " + alienData.get(3);
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, "Antingen så skrev du in fel eller så finns inte platsen i systemet än.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
        String query = "INSERT INTO Alien Values(" + alienData.get(1) + ", " + alienData.get(6) + ", " + alienData.get(5) + ", " + alienData.get(1)
                 + ", " + alienData.get(2) + ", " + platsID  + ", " + agentID;
        
        
        try {
            mibdb.insert(query);
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, "Antingen så skrev du in fel eller så finns inte platsen i systemet än.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }
        
    }
    
    
    
    
    String fraga = "SELECT telefon FROM agent WHERE Namn = " + tfAnvandarnamn.getText();
    
    fraga = "SELECT losenord FROM alien WHERE Namn = " + tfAnvandarnamn.getText();
    
    
    */
    
    
    
    
}
