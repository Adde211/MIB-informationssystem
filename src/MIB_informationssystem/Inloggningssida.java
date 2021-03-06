package MIB_informationssystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import oru.inf.InfDB;
import oru.inf.InfException;

import javax.swing.JOptionPane;

/**
 *
 * @author adamd
 */
public class Inloggningssida extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form Inloggningssida
     */
    public Inloggningssida() {
        initComponents();

        //döljer felmeddelande
        lblFelmeddelande.setVisible(false);
        //kopplar up oss mot vår DB
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel" + ettUndantag);
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

        lblInloggning = new javax.swing.JLabel();
        txtWindowUser = new javax.swing.JTextField();
        btnLoggaIn = new javax.swing.JButton();
        lblFelmeddelande = new javax.swing.JLabel();
        lblAnvandarnamn = new javax.swing.JLabel();
        lblLosenord = new javax.swing.JLabel();
        txtWindowPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInloggning.setText("Inloggning");

        txtWindowUser.setColumns(10);

        btnLoggaIn.setText("Logga in");
        btnLoggaIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaInActionPerformed(evt);
            }
        });

        lblFelmeddelande.setText("Felmeddelande");

        lblAnvandarnamn.setText("Användarnamn");

        lblLosenord.setText("Lösenord");

        txtWindowPassword.setColumns(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(lblInloggning))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(btnLoggaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLosenord)
                            .addComponent(lblAnvandarnamn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWindowUser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWindowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(lblFelmeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(lblInloggning)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnvandarnamn)
                    .addComponent(txtWindowUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLosenord)
                    .addComponent(txtWindowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFelmeddelande)
                .addGap(18, 18, 18)
                .addComponent(btnLoggaIn)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoggaInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaInActionPerformed
        // Sparar inmatade rutan för lösen och namn med getText metoden
        
       

        String namn = txtWindowUser.getText();
        String password = txtWindowPassword.getText();
        //Vi behöver skilja på de olika användarna och admin finns bara hos agenter, dvs null = inte agent
        String input = "SELECT Administrator FROM agent WHERE namn LIKE '" + namn + "' AND losenord LIKE '" + password + "';";
        //skapar scenario där användaeren inte fyllt i txt fönstren, det genom att räkna längden på password sedan namn
        int langd = password.length();
        if (langd < 1)
        {
            if(namn.length() < 1){
                lblFelmeddelande.setText("Vänligen fyll i både namn och lösenord ");
            }
            else{
                lblFelmeddelande.setText("Vänligen fyll i lösenord");
            }
        
        lblFelmeddelande.setVisible(true);
        }
      
        if (langd > 1) {
        // B) Ställer frågan till DB om Admin J / N      
        try {
            String adminJaNej = idb.fetchSingle(input);

            // C) Retunerar den Null kollar vi i alien columnen och ändrar vår fråga
            if (adminJaNej == null) {
                //hämtar namn från alien tabellen
                String input2 = "SELECT Namn FROM alien WHERE namn LIKE '" + namn + "' AND losenord LIKE '" + password + "';";
                //hämtar oxå alien ID pga. att använda vill använda det i vår alien områdessök i nästa JFRame
                String input3 = "SELECT Alien_ID FROM alien WHERE namn LIKE '" + namn + "' AND losenord LIKE '" + password + "';";
                try {
                    //frågar båda frågorna mot databasen
                    String alienNamn = idb.fetchSingle(input2);
                    String alienID = idb.fetchSingle(input3);

                    // D) Retunerar den fortarande null finns inte användaren eller fel inmmatning = ruta att användaern inte finns
                    if (alienNamn == null) {

                        lblFelmeddelande.setText("Hittar inte användaren eller fel lösenord, vänligen försök igen");

                        lblFelmeddelande.setVisible(true);

                    } // E) Öpnnar Alien rutan och välkomnar Alien
                    else {
                        //Skapar ett Alienfonster och visar det samnt skickar med namn, losen, ID via 
                        //AlienHuvudmeny metoderna 

                        AlienHuvudmeny Alienfonster = new AlienHuvudmeny();
                        Alienfonster.setVisible(true);
                        Alienfonster.getLosen(password);
                        Alienfonster.setNamn(alienNamn);
                        Alienfonster.setID(alienID);

                    }

                } catch (Exception e) {
                    txtWindowUser.setText("något gick med hämtandet av data");
                }

            }

            //  F) Om Admin retuneras J
            if ("J".equals(adminJaNej)) {
                // Välkomen Administratör,
                // F -- 2) kör en till fråga och frågar efter namn på agenten tillstring
                String inputAdmin = "SELECT namn FROM agent WHERE namn LIKE '" + namn + "' AND losenord LIKE '" + password + "';";
                try {
                    String adminNamn = idb.fetchSingle(inputAdmin);
                    // JOptionPane.showMessageDialog(null, "Välkomen Administrator " + adminNamn);
                    AdministratörHuvudmeny adminFonster = new AdministratörHuvudmeny();
                    adminFonster.setVisible(true);
                    
                    

                } catch (Exception e) {
                    txtWindowUser.setText("något gick fel i adminNamn frågan");
                }

                // F -- 3) startar Adminklass-rutan
            }

            // G) om AdminJaNej = N
            if ("N".equals(adminJaNej)) {

                // G -- 2) kör en till fråga och frågar efter namn på agenten tillstring
                String inputAgent = "SELECT namn FROM agent WHERE namn LIKE '" + namn + "' AND losenord LIKE '" + password + "';";
                try {
                    String agentNamn = idb.fetchSingle(inputAgent);
                    // JOptionPane.showMessageDialog(null, "Välkomen  " + agentNamn);
                    
                    //Skapar mitt agent fönster objekt och skickar password samt namn
                    AgentHuvudmeny agentFonster = new AgentHuvudmeny();
                    agentFonster.setVisible(true);
                    agentFonster.getLosen(password);
                    agentFonster.setNamn(agentNamn);

                } catch (Exception e) {
                    txtWindowUser.setText("något gick fel i agentFrågan frågan");
                }

                // G -- 3) startar Agentklass-rutan
            }

        } catch (Exception e) {
            txtWindowUser.setText("något gick feli adminfrågan");
        }
        
        }
        


    }//GEN-LAST:event_btnLoggaInActionPerformed

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
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inloggningssida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inloggningssida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoggaIn;
    private javax.swing.JLabel lblAnvandarnamn;
    private javax.swing.JLabel lblFelmeddelande;
    private javax.swing.JLabel lblInloggning;
    private javax.swing.JLabel lblLosenord;
    private javax.swing.JPasswordField txtWindowPassword;
    private javax.swing.JTextField txtWindowUser;
    // End of variables declaration//GEN-END:variables
}
