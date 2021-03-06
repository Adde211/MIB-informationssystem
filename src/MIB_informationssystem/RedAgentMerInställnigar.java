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
 * @author robertkorpics
 */
public class RedAgentMerInställnigar extends javax.swing.JFrame {

    
    private InfDB idb;
    
    /**
     * Creates new form RedAgentMerInställnigar
     */
    public RedAgentMerInställnigar() {
        initComponents();
        
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel" + ettUndantag);
        }
        
        
        
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        
        
        
        fetchComboBox3();
        fetchComboBox4();
        fetchComboBox5();
        
        
    }
    
        private void fetchComboBox3() {

        String fetchOmrade = "SELECT NAMN FROM AGENT";
        ArrayList<String> comboList;
        try {

            comboList = idb.fetchColumn(fetchOmrade);

            System.out.println(comboList);
            for (String list : comboList) {
                jComboBoxhamtaAgentPanel1.addItem(list);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Felmeddelande:");

        }
        
    }
        
        private void fetchComboBox4() {

        String fetchOmrade = "SELECT NAMN FROM AGENT";
        ArrayList<String> comboList;
        try {

            comboList = idb.fetchColumn(fetchOmrade);

            System.out.println(comboList);
            for (String list : comboList) {
                jComboBoxFetchAgent.addItem(list);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Felmeddelande:");

        }
    
        
        
    }
                  
            
        private void fetchComboBox5() {

        String fetchOmrade = "SELECT BENAMNING FROM OMRADE";
        ArrayList<String> comboList;
        try {

            comboList = idb.fetchColumn(fetchOmrade);

            System.out.println(comboList);
            for (String list : comboList) {
                jComboBoxFetchArea.addItem(list);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Felmeddelande:");

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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jButtonUppdateraPanel1 = new javax.swing.JButton();
        jTextFieldnyttDatumPanel1 = new javax.swing.JTextField();
        jComboBoxhamtaAgentPanel1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxFetchAgent = new javax.swing.JComboBox<>();
        jComboBoxFetchArea = new javax.swing.JComboBox<>();
        jBtnUppdatera = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonShowPanel1 = new javax.swing.JButton();
        jButtonShowPanel2 = new javax.swing.JButton();
        jButtonDispose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonUppdateraPanel1.setText("Uppdatera");
        jButtonUppdateraPanel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUppdateraPanel1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nytt Datum");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUppdateraPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldnyttDatumPanel1)
                    .addComponent(jComboBoxhamtaAgentPanel1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jComboBoxhamtaAgentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldnyttDatumPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jButtonUppdateraPanel1)
                .addGap(122, 122, 122))
        );

        jBtnUppdatera.setText("Uppdatera");
        jBtnUppdatera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnUppdateraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxFetchAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxFetchArea, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtnUppdatera)))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFetchAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxFetchArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnUppdatera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(83, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(9, Short.MAX_VALUE)))
        );

        jButtonShowPanel1.setText("Byt område");
        jButtonShowPanel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowPanel1ActionPerformed(evt);
            }
        });

        jButtonShowPanel2.setText("Byt Datum");
        jButtonShowPanel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowPanel2ActionPerformed(evt);
            }
        });

        jButtonDispose.setText("Tillbaka");
        jButtonDispose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisposeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonShowPanel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonShowPanel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDispose)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonShowPanel1)
                    .addComponent(jButtonShowPanel2)
                    .addComponent(jButtonDispose))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonShowPanel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowPanel1ActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        
    }//GEN-LAST:event_jButtonShowPanel1ActionPerformed

    private void jButtonShowPanel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowPanel2ActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jButtonShowPanel2ActionPerformed

    private void jButtonDisposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisposeActionPerformed
        // TODO add your handling code here:
           dispose();
    }//GEN-LAST:event_jButtonDisposeActionPerformed

    private void jButtonUppdateraPanel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUppdateraPanel1ActionPerformed
        // TODO add your handling code here:
        String valdAgent = jComboBoxhamtaAgentPanel1.getSelectedItem().toString();
        String datum = jTextFieldnyttDatumPanel1.getText();
        
        try{
        String agentID = idb.fetchSingle("Select Agent_ID from agent where agent.namn = " + "'" + valdAgent + "'");
                
        String query = "Update agent set AnstallningsDatum = '" + datum + "' WHERE Agent_ID = " + agentID;
                idb.update(query);
                JOptionPane.showMessageDialog(null,"Datumet är uppdaterat");
            
            }
            catch(InfException e){
                JOptionPane.showMessageDialog(null, "Något gick fel");
                
            }
      
    }//GEN-LAST:event_jButtonUppdateraPanel1ActionPerformed

       
    private void jBtnUppdateraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnUppdateraActionPerformed
        // TODO add your handling code here:
        String valdAgent = jComboBoxFetchAgent.getSelectedItem().toString();
        String omrade = "'" + jComboBoxFetchArea.getSelectedItem().toString() + "'";
     
        
        
            try{
                String agentID = idb.fetchSingle("Select Agent_id from agent where agent.namn = " + "'" + valdAgent + "'");
                String omradesID = idb.fetchSingle("Select omrades_id from omrade where omrade.benamning = " + omrade);
                
                String query = "Update agent set omrade =" + omradesID + " " + "Where agent_id =" + "'" + agentID + "'";
                idb.update(query);
                JOptionPane.showMessageDialog(null,"Området är uppdaterat");
            
            }
            catch(InfException e){
                JOptionPane.showMessageDialog(null, "Fel");
            
            }
        
        
    }//GEN-LAST:event_jBtnUppdateraActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnUppdatera;
    private javax.swing.JButton jButtonDispose;
    private javax.swing.JButton jButtonShowPanel1;
    private javax.swing.JButton jButtonShowPanel2;
    private javax.swing.JButton jButtonUppdateraPanel1;
    private javax.swing.JComboBox<String> jComboBoxFetchAgent;
    private javax.swing.JComboBox<String> jComboBoxFetchArea;
    private javax.swing.JComboBox<String> jComboBoxhamtaAgentPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldnyttDatumPanel1;
    // End of variables declaration//GEN-END:variables
}
