/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import java.util.ArrayList;
import java.util.HashMap;

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


    /* Hämtar all data från en instans i alientabellen i form av en HashMap.
    De motsvarande agent- och platsnamnen ersätter värdena för kolumnerna Plats och Ansvarig_Agent.

    @param id ID:et som användaren har skrivit in för att söka på en alien.
    */
    public static HashMap<String, String> getAlienInstansData(String value, String kolumn) {

        value = value.trim();
        //kommentarskoden är alternativ kod.

        //ArrayList<String> alienData = new ArrayList<>();

        HashMap<String, String> alienInstansData = null;
        
        try {
            //Alternativ kod

            /*String fraga = "SELECT Namn FROM alien Where " + kolumn + " = " + id.getText();
            alienData.add(mibdb.fetchSingle(fraga));
            fraga = "SELECT Telefon FROM alien Where kolumn = " + id.getText();
            alienData.add(mibdb.fetchSingle(fraga));
            fraga = "SELECT Benamning FROM plats WHERE Plats_ID = (SELECT plats FROM alien Where " + kolumn + " = " + id.getText() + ")";
            alienData.add(mibdb.fetchSingle(fraga));
            fraga = "SELECT Namn FROM Agent WHERE Agent_ID = (SELECT Ansvarig_agent FROM alien Where " + kolumn + " = " + id.getText() + ")";
            alienData.add(mibdb.fetchSingle(fraga));
            fraga = "SELECT Losenord FROM alien Where " + kolumn + " = " + id.getText();
            alienData.add(mibdb.fetchSingle(fraga));
            fraga = "SELECT Registreringsdatum FROM alien Where " + kolumn + " = " + id.getText();
            alienData.add(mibdb.fetchSingle(fraga));
            */

            alienInstansData = mibdb.fetchRow("SELECT * FROM Alien WHERE " + kolumn + " = " + value);

            //Platsnamnet ersätter platsID:et.
            String query = "SELECT Benamning FROM plats WHERE Plats_ID = (SELECT plats FROM alien Where " + kolumn + " = " + value + ")";
            String platsnamn = mibdb.fetchSingle(query);
            alienInstansData.put("Plats", platsnamn);

            //Agentnamnet ersätter agentID:et.
            query = "SELECT Namn FROM Agent WHERE Agent_ID = (SELECT Ansvarig_agent FROM alien Where " + kolumn + " = " + value + ")";
            String agentnamn = mibdb.fetchSingle(query);
            alienInstansData.put("Ansvarig_Agent", agentnamn);
        }
        catch(InfException ex) {
            //Ett felmeddelande till användaren respektive ett internt felmeddelande skrivs ut.
            String errorMeddelande = "Ett eller flera värden från mibdb lyckades inte att hämtas.";
            JOptionPane.showMessageDialog(null, errorMeddelande);
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }

        return alienInstansData;

    }

    public static void laggTillEnAlien(HashMap<String, String> alienInstansData) {

        alienInstansData = OvrigaFunktioner.trimHashMap(alienInstansData);
        String agentID = null;
        String platsID = null;
        
        try {
            agentID = mibdb.fetchSingle("SELECT Agent_ID FROM Agent WHERE Namn = " + alienInstansData.get("Agent"));
            platsID = mibdb.fetchSingle("SELECT Plats_ID FROM Plats WHERE Benamning = " + alienInstansData.get("Plats"));
            
            String query = "INSERT INTO Alien Values(" + alienInstansData.get("ID") + ", '" + alienInstansData.get("Registreringsdatum") + "', '" + alienInstansData.get("Losenord") + "', '"
                        + alienInstansData.get("Namn") + "', '" + alienInstansData.get("Telefonnummer") + "', " + platsID  + ", " + agentID + ")";
            mibdb.insert(query);
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, "Registreringen lyckade ej.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }

    }
    
    
    public static void uppdateraEnAlien(HashMap<String, String> alienInstansData) {

        alienInstansData = OvrigaFunktioner.trimHashMap(alienInstansData);
        String agentID = null;
        String platsID = null;
        
        try {
            agentID = mibdb.fetchSingle("SELECT Agent_ID FROM Agent WHERE Namn = " + alienInstansData.get("Agent"));
            platsID = mibdb.fetchSingle("SELECT Plats_ID FROM Plats WHERE Benamning = " + alienInstansData.get("Plats"));
            
            String query = "UPDATE Alien SET Agent_ID = " + alienInstansData.get("ID") + ", Registreringsdatum = '" + alienInstansData.get("Registreringsdatum")
                    + "', Losenord = '" + alienInstansData.get("Losenord") + "', Namn = '" + alienInstansData.get("Namn") +
                    "', Telefon = '" + alienInstansData.get("Telefonnummer") + "', Plats = " + platsID  + ", Ansvarig_Agent = " + agentID
                    + " WHERE Alien_ID = " + alienInstansData.get("ID");
            mibdb.update(query);
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(null, "Uppdateringen lyckade ej.");
            System.out.println("Internt felmeddelande: " + ex.getMessage());
        }

    }
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
