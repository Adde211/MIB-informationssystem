package MIB_informationssystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author axelh
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

// A) metod som hämtar vårt losen
// B) metod hämtar namn
// C) Hämta ansvarig agent 
// D) hämtar alla aliens i området
// F) Knapp för att ändra lösenord = ändrar menyn
// G) knapp för att uppdtarea nya lösen mot DB
// G 1) Update DB med nytt lösen
// H) bakotknapp från lösenordbyte
// I) Logga ut
 //J) metod för att visa/gömma byta lösen




public class AlienHuvudmeny extends javax.swing.JFrame {
//Skapar de variabel vi använder genom hela klassen
    private InfDB idb;
    String losen;
    String namn;
    String ID;

    public AlienHuvudmeny() {
       
        //initiearar vår JFrame och visar de knappar vi vill 
        initComponents();
        txtNyttlos.setVisible(false);
        nyttLosen.setVisible(false);
        btnNyttLosen.setVisible(false);
        btnTillbaka.setVisible(false);
        //kopplar upp sig mot databasen

        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel" + ettUndantag);
        }

    }

    // A) metod som hämtar vårt losen, string input password vi hämtar från inloggningssidan
    public void getLosen(String password) {

        losen = password;

        

    }
     // B) metod hämtar namn, string input alienNamn hämtas från inloggningssidan
    public void setNamn(String alienNamn) {

        namn = alienNamn;
        //välkomnar vår alien med Namn, vår jlbRubrik 

        txtRubrik.setText("Välkomen " + namn);

    }
    //sätter vårt ID som oxå hämtas som de innan
     public void setID(String alienID) {

       ID = alienID;

    }
    // J) metod för att visa/gömma byta lösen
     
    public void bytaLosen(boolean visa){
    //är visa sant så ändras alla knappar till visible
    
       if (visa == true){
       txtNyttlos.setVisible(true);
        nyttLosen.setVisible(true);
        btnNyttLosen.setVisible(true);
        btnAliensOmrade.setVisible(false);
        btnHämtaAgent.setVisible(false);
        txtOmrådesAgent.setVisible(false);
        btnAndralosen.setVisible(false);
        btnTillbaka.setVisible(true); 
        txtRubrik.setVisible(false);
        lbAgentTel.setVisible(false);
        txtOmrådesAgentNum.setVisible(false);
        lbAgentNamn.setVisible(false);
       }
       // om visa inte är true gömmer vi alla knappar och fönster etc.
       else {
        txtNyttlos.setVisible(false);
        nyttLosen.setVisible(false);
        btnNyttLosen.setVisible(false);
        btnAliensOmrade.setVisible(true);
        btnHämtaAgent.setVisible(true);
        txtOmrådesAgent.setVisible(true);
        btnAndralosen.setVisible(true);
        btnTillbaka.setVisible(false);
        txtRubrik.setVisible(true);
        lbAgentTel.setVisible(true);
        txtOmrådesAgentNum.setVisible(true);
        lbAgentNamn.setVisible(true);
       }
        
    }
            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRubrik = new javax.swing.JLabel();
        btnHämtaAgent = new javax.swing.JButton();
        txtOmrådesAgent = new javax.swing.JTextField();
        btnAndralosen = new javax.swing.JButton();
        btnAliensOmrade = new javax.swing.JButton();
        txtNyttlos = new javax.swing.JLabel();
        nyttLosen = new javax.swing.JTextField();
        btnNyttLosen = new javax.swing.JButton();
        btnLoggUt = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        txtOmrådesAgentNum = new javax.swing.JTextField();
        lbAgentNamn = new javax.swing.JLabel();
        lbAgentTel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtRubrik.setText("Welcome to Earth");

        btnHämtaAgent.setText("Hämta din områdes-agent");
        btnHämtaAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHämtaAgentActionPerformed(evt);
            }
        });

        txtOmrådesAgent.setColumns(10);
        txtOmrådesAgent.setMinimumSize(new java.awt.Dimension(50, 22));

        btnAndralosen.setText("Ändra lösenord");
        btnAndralosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndralosenActionPerformed(evt);
            }
        });

        btnAliensOmrade.setText("Aliens i ditt område");
        btnAliensOmrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAliensOmradeActionPerformed(evt);
            }
        });

        txtNyttlos.setText("Skriv in nytt lösenord:");

        nyttLosen.setColumns(10);

        btnNyttLosen.setText("Updatera lösenord");
        btnNyttLosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyttLosenActionPerformed(evt);
            }
        });

        btnLoggUt.setText("Logga ut");
        btnLoggUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggUtActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        txtOmrådesAgentNum.setColumns(10);
        txtOmrådesAgentNum.setMinimumSize(new java.awt.Dimension(50, 22));

        lbAgentNamn.setText("Namn:");

        lbAgentTel.setText("Telefon:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnHämtaAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAndralosen)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAliensOmrade)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtNyttlos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nyttLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNyttLosen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTillbaka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoggUt)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(txtRubrik))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOmrådesAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAgentNamn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAgentTel)
                            .addComponent(txtOmrådesAgentNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(txtRubrik)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAgentNamn)
                    .addComponent(lbAgentTel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOmrådesAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOmrådesAgentNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHämtaAgent)
                    .addComponent(btnAndralosen)
                    .addComponent(btnAliensOmrade))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNyttlos)
                    .addComponent(nyttLosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNyttLosen)
                    .addComponent(btnLoggUt)
                    .addComponent(btnTillbaka))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHämtaAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHämtaAgentActionPerformed
          // C) Hämta ansvarig agent 
          //Skapar en fråga mot databasen med vår databas-klass och metoden fetchSingle()
          
        try {
            // Vår string fråga som ändras pg.a namn och lösen vår alien har 
            String sqlOmrade = "SELECT agent.`Namn` FROM agent, alien WHERE ansvarig_Agent = Agent_ID AND alien.namn LIKE '" + namn + "' AND alien.losenord LIKE '" + losen + "';";
            //Ny String som sparar reusltatet av vår fetchsingle() fråga mot databasen
            String hamtaAgent = idb.fetchSingle(sqlOmrade);
            
            

            //byter text till agentens namn(vi fått av vår fråga till databasen) på vår textruta txtOmrådesAgent via setText() metoden
            txtOmrådesAgent.setText(hamtaAgent);
        } catch (Exception e) {
//en catch för eventuellt fel
            txtOmrådesAgent.setText("något gick fel");
        }
        
         try {
            // Vår string fråga som ändras pg.a namn och lösen vår alien har 
            String sqlOmrade = "SELECT agent.Telefon FROM agent, alien WHERE ansvarig_Agent = Agent_ID AND alien.namn LIKE '" + namn + "' AND alien.losenord LIKE '" + losen + "';";
            //Ny String som sparar reusltatet av vår fetchsingle() fråga mot databasen
            String hamtaAgent = idb.fetchSingle(sqlOmrade);
            
            

            //byter text till agentens namn(vi fått av vår fråga till databasen) på vår textruta txtOmrådesAgent via setText() metoden
            txtOmrådesAgentNum.setText(hamtaAgent);
        } catch (Exception e) {
//en catch för eventuellt fel
            txtOmrådesAgent.setText("något gick fel");
        }
    }//GEN-LAST:event_btnHämtaAgentActionPerformed

    private void btnAliensOmradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAliensOmradeActionPerformed
       // D) hämtar alla aliens i området, inre hittar plats id och yttre tar bort mig själv. Få bort egna namnet ur arraylistan
       //Vår SQL fråga, den yttrefrågan hittar alla i området samt tar bort användarens eget namn via den ID, så fler kan ha samma namn
       // den inre frågan frågan hittar plats id'et
        String databasfraga = "SELECT namn FROM alien WHERE plats LIKE (SELECT plats FROM alien WHERE namn LIKE '" + namn + "' AND losenord LIKE '" + losen + "') AND Alien_ID != "+ID+";";

         
       //en arraylist för att spara alla namn i en lista som retuneras av databasfrågan och metoden
       //fetchcolumn() längre ner
        ArrayList<String> fraga = new ArrayList<String>();

        try {
            //skickar frågan och visar vårt svar i en pop upp ruta
            fraga = idb.fetchColumn(databasfraga);
            JOptionPane.showMessageDialog(null, "Aliens i ditt område är " + fraga);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");

        }


    }//GEN-LAST:event_btnAliensOmradeActionPerformed

    private void btnAndralosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndralosenActionPerformed
      // F) Knapp för att ändra lösenord = ändrar menyn genom metod högre upp i koden
        bytaLosen(true);
        
    }//GEN-LAST:event_btnAndralosenActionPerformed

    private void btnNyttLosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyttLosenActionPerformed
        // G) knapp för att uppdtarea nya lösen mot DB
        
        //sparar det användaren skrivit i textfältet nyttLosen i ny string med getText()
        String nyttlosen = nyttLosen.getText();
        //vår databasfraga använder UPDATE och sätter losenord = inmatade strängen vi fått av användaren samnt WHERE sattsen 
        //som bestämmer användaren genom namn¨å lösen
        String fragaDB = "UPDATE alien SET losenord = '" + nyttlosen + "' WHERE namn LIKE '" + namn + "' AND losenord LIKE '" + losen + "';";
       
        
        try {
            //skickar vår fråga, skriver ut en popuppruta, döljer bytalosen menyn 
            idb.update(fragaDB);
            JOptionPane.showMessageDialog(null, "Ditt lösenord är uppdaterat");
            bytaLosen(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");

        }
        
        
        
        
        
       
    }//GEN-LAST:event_btnNyttLosenActionPerformed

    private void btnLoggUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggUtActionPerformed
        // H) Logga ut, stänger vår Jframe med dispose() 
       dispose();
       
        
    }//GEN-LAST:event_btnLoggUtActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // tillbaka knappen döljer allaa objekt ssom har med byta losen att göra 
        bytaLosen(false);
        
    }//GEN-LAST:event_btnTillbakaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlienHuvudmeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlienHuvudmeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlienHuvudmeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlienHuvudmeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlienHuvudmeny().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAliensOmrade;
    private javax.swing.JButton btnAndralosen;
    private javax.swing.JButton btnHämtaAgent;
    private javax.swing.JButton btnLoggUt;
    private javax.swing.JButton btnNyttLosen;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel lbAgentNamn;
    private javax.swing.JLabel lbAgentTel;
    private javax.swing.JTextField nyttLosen;
    private javax.swing.JLabel txtNyttlos;
    private javax.swing.JTextField txtOmrådesAgent;
    private javax.swing.JTextField txtOmrådesAgentNum;
    private javax.swing.JLabel txtRubrik;
    // End of variables declaration//GEN-END:variables
}
