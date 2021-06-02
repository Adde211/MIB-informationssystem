/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB_informationssystem;

import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author robertkorpics
 */
public class AdminAgentMeny extends javax.swing.JFrame {

    private InfDB idb;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form AdminAgentMeny
     */
    public AdminAgentMeny() {
        initComponents();
        
        jPanelRegAgent.setVisible(false);
        jPanelDelAgent.setVisible(false);
        jPanelAlterAgent.setVisible(false);
        jPanelMerInställningar.setVisible(false);

        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ettUndantag) {
            JOptionPane.showMessageDialog(null, "Något gick fel" + ettUndantag);
        }
       

        
        // Combobox i "Registrera Agent", lista agenter i Redigera Agent.
        fetchComboBox();   
        
        // Combobox i "redigera agent", lista agenter i Redigera agent.
        fetchComboBoxAgent();
              
        // Konstruktorn för combox för kontorchef combobox.
        //---------------------------
        // Combobox i "mer inställningar", lista Agenter i Kontorchef inställningen.
        fetchComboBoxen();
        
        // Combobox i "mer inställningar", lista kontor som alternativ.
        listaComboBoxAndraKontor();
        //---------------------------
        
        
        
        
        
        
        
        
        // OMRÅDESCHEF I MER INSTÄLLINGAR - KOD VÄLJ AGENT / OMRÅDE
        // ---------------------------------
        // ComboBox i "mer inställnigar", lista Agenter i Områdes inställningen.
        listaComboBoxAgenterTillOmrade();
        // Combox i "mer inställningar", listar områden i områdes inställningen.
        listaComboBoxOmradenChef();
        //----------------------------------
        
        
        

    }
        // TILL AGENT REGISTERING, COMBOBOXEN FÖR HÄMTA OMRÅDE I PANELEN.
        private void fetchComboBox() {

        String fetchOmrade = "SELECT BENAMNING FROM OMRADE";
        ArrayList<String> comboList;
        try {

            comboList = idb.fetchColumn(fetchOmrade);

            System.out.println(comboList);
            for (String list : comboList) {
                jComboBoxOmrade.addItem(list);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null,"Fel i systemet, kontakta IT-avdelning");

        }
    }
        // ----------------------------------
     
        
        
        
        // TILL REDIGERA AGENT
        //-----------------------------------
        private void fetchComboBoxAgent() {

        String fetchAgent = "SELECT NAMN FROM AGENT";
        ArrayList<String> comboAgentList;
        try {
            comboAgentList = idb.fetchColumn(fetchAgent);
            for (String listan : comboAgentList) {
                jComboBoxAgentFetch.addItem(listan);
            }
        } catch (InfException e) {
            
            JOptionPane.showMessageDialog(null, "Fel i systemet, kontakta IT-avdelning");
        }
        
    }
        //-----------------------------------

        
        //KONTORSCHEF
        //-----------------------------------
        private void fetchComboBoxen() {

        String fetchAgent = "SELECT NAMN FROM AGENT";
        ArrayList<String> comboAgentList;
        try {

            comboAgentList = idb.fetchColumn(fetchAgent);

            System.out.println(fetchAgent);
            for (String listan : comboAgentList) {
                fetchComboBoxAgentKCF.addItem(listan);
            }
        } catch (InfException e) {
            
            JOptionPane.showMessageDialog(null, "Fel i systemet, kontakta IT-avdelning");

            }
        }
        
        private void listaComboBoxAndraKontor() { 

        String fraga = "SELECT KONTORSBETECKNING FROM KONTORSCHEF";
        ArrayList<String> ComboBoxAndraKontorList;
        try {
            ComboBoxAndraKontorList = idb.fetchColumn(fraga);
            for (String s : ComboBoxAndraKontorList) {
                jComboBoxListaOmrade.addItem(s);
            }
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Fel i systemet, kontakta IT-avdelning");

        }
  
    }
        //-----------------------------------
    
        
        //OMRÅDESCHEF
        //-------------------------------
        // Metod som fyller Combobox med agenter, hittas i " mer inställningar, gäller område stalpen, hämtar agenter"
        private void listaComboBoxAgenterTillOmrade() {

        String fetchAgent = "SELECT NAMN FROM AGENT";
        ArrayList<String> comboAgentList;
        try {

            comboAgentList = idb.fetchColumn(fetchAgent);
            for (String listan : comboAgentList) {
                jComboBoxOmradesChef1.addItem(listan);
            }
        } catch (InfException e) {
            
            JOptionPane.showMessageDialog(null, "Fel i systemet, kontakta IT-avdelning");
            
            }
        }
        
        private void listaComboBoxOmradenChef(){
        
        String fetchBanmning = "SELECT BENAMNING FROM OMRADE";
        ArrayList<String> comboListChefOmrade;
        
        try {
            
            comboListChefOmrade = idb.fetchColumn(fetchBanmning);
            for (String s : comboListChefOmrade) {
                jComboBoxOmradesChef2.addItem(s);
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Fel i systemet, kontakta IT-avdelning");
            
        }
            
    }
        //-------------------------------

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonRegAgent = new javax.swing.JButton();
        jButtonDelAgent = new javax.swing.JButton();
        jButtonAlterAgent = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelRegAgent = new javax.swing.JPanel();
        jLabelRegAgent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldAgentRegAgentID = new javax.swing.JTextField();
        jTextFieldAgentRegNamn = new javax.swing.JTextField();
        jTextFieldAgentRegTelNr = new javax.swing.JTextField();
        jTextFieldAgentRegPW = new javax.swing.JTextField();
        jButtonSparaAgentRegistrering = new javax.swing.JButton();
        jButtonAgentRegRensa = new javax.swing.JButton();
        jComboBoxAdmin = new javax.swing.JComboBox<>();
        jComboBoxOmrade = new javax.swing.JComboBox<>();
        jTextFieldDatum = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jPanelDelAgent = new javax.swing.JPanel();
        jLabelDelAgent = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonTaBortAgent = new javax.swing.JButton();
        txtFieldTaBortAgent = new javax.swing.JTextField();
        jTextFieldSvar = new javax.swing.JTextField();
        jPanelAlterAgent = new javax.swing.JPanel();
        jLabelAlterAgent = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxRedigeraAgent = new javax.swing.JComboBox<>();
        jTxtRedigeraAgent = new javax.swing.JTextField();
        jButtonUppdateraAgent = new javax.swing.JButton();
        jButtonRensaRedigeraAgent = new javax.swing.JButton();
        jComboBoxAgentFetch = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jBtnRedigeraAgentBacka = new javax.swing.JButton();
        jButtonRedAgentMerInställningar = new javax.swing.JButton();
        jPanelMerInställningar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButtonSparaKontorChef = new javax.swing.JButton();
        fetchComboBoxAgentKCF = new javax.swing.JComboBox<>();
        jComboBoxListaOmrade = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxOmradesChef2 = new javax.swing.JComboBox<>();
        jComboBoxOmradesChef1 = new javax.swing.JComboBox<>();
        jComboBoxSeAnsvarsOmrade = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButtonSparaOmradesChef = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonTillbaka = new javax.swing.JButton();
        jButtonMerInställningar = new javax.swing.JButton();

        jButton4.setText("jButton1");

        jTextField3.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonRegAgent.setText("Registrera en Agent");
        jButtonRegAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegAgentActionPerformed(evt);
            }
        });

        jButtonDelAgent.setText("Ta bort Agent");
        jButtonDelAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelAgentActionPerformed(evt);
            }
        });

        jButtonAlterAgent.setText("Ändra Agent");
        jButtonAlterAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterAgentActionPerformed(evt);
            }
        });

        jLabelRegAgent.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelRegAgent.setText("Agent registrering");
        jLabelRegAgent.setSize(new java.awt.Dimension(45, 20));

        jLabel1.setText("Agent ID");

        jLabel2.setText("Namn");

        jLabel3.setText("Telefon");

        jLabel4.setText("Anställningsdatum");

        jLabel5.setText("Administrator");

        jLabel6.setText("Lösenord");

        jLabel7.setText("Område");

        jButtonSparaAgentRegistrering.setText("Spara");
        jButtonSparaAgentRegistrering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSparaAgentRegistreringActionPerformed(evt);
            }
        });

        jButtonAgentRegRensa.setText("Rensa");
        jButtonAgentRegRensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgentRegRensaActionPerformed(evt);
            }
        });

        jComboBoxAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JA", "NEJ" }));

        jTextFieldDatum.setMaximumSize(new java.awt.Dimension(8, 1));
        jTextFieldDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDatumActionPerformed(evt);
            }
        });

        jLabel21.setText("YYYY/MM/DD");

        javax.swing.GroupLayout jPanelRegAgentLayout = new javax.swing.GroupLayout(jPanelRegAgent);
        jPanelRegAgent.setLayout(jPanelRegAgentLayout);
        jPanelRegAgentLayout.setHorizontalGroup(
            jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabelRegAgent))
                    .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                                .addComponent(jButtonSparaAgentRegistrering)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAgentRegRensa))
                            .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(24, 24, 24)
                                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAgentRegTelNr)
                                    .addComponent(jTextFieldAgentRegNamn)
                                    .addComponent(jTextFieldAgentRegAgentID)
                                    .addComponent(jTextFieldAgentRegPW)
                                    .addComponent(jComboBoxOmrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                                        .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelRegAgentLayout.setVerticalGroup(
            jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegAgentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRegAgent)
                .addGap(18, 18, 18)
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldAgentRegAgentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegAgentLayout.createSequentialGroup()
                        .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldAgentRegNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(jTextFieldAgentRegTelNr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldAgentRegPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanelRegAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgentRegRensa)
                    .addComponent(jButtonSparaAgentRegistrering))
                .addGap(112, 112, 112))
        );

        jLabelDelAgent.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelDelAgent.setText("Ta bort Agent");

        jLabel8.setText("Agent namn :");

        jButtonTaBortAgent.setText("Ta bort");
        jButtonTaBortAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaBortAgentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDelAgentLayout = new javax.swing.GroupLayout(jPanelDelAgent);
        jPanelDelAgent.setLayout(jPanelDelAgentLayout);
        jPanelDelAgentLayout.setHorizontalGroup(
            jPanelDelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDelAgentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldSvar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDelAgent)
                    .addGroup(jPanelDelAgentLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonTaBortAgent)
                            .addComponent(txtFieldTaBortAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanelDelAgentLayout.setVerticalGroup(
            jPanelDelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDelAgentLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelDelAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanelDelAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldTaBortAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldSvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTaBortAgent)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jLabelAlterAgent.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabelAlterAgent.setText("Redigera Agent");

        jLabel9.setText("Vilken agent");

        jComboBoxRedigeraAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Namn", "Telefon", "Administrator", "Losenord", "" }));

        jButtonUppdateraAgent.setText("Uppdatera");
        jButtonUppdateraAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUppdateraAgentActionPerformed(evt);
            }
        });

        jButtonRensaRedigeraAgent.setText("Rensa Fält");
        jButtonRensaRedigeraAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRensaRedigeraAgentActionPerformed(evt);
            }
        });

        jLabel12.setText("Vad ska redigeras");

        jLabel13.setText("Det nya");

        jBtnRedigeraAgentBacka.setText("Tillbaka");
        jBtnRedigeraAgentBacka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRedigeraAgentBackaActionPerformed(evt);
            }
        });

        jButtonRedAgentMerInställningar.setText("Mer inställningar");
        jButtonRedAgentMerInställningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedAgentMerInställningarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlterAgentLayout = new javax.swing.GroupLayout(jPanelAlterAgent);
        jPanelAlterAgent.setLayout(jPanelAlterAgentLayout);
        jPanelAlterAgentLayout.setHorizontalGroup(
            jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterAgentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                        .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonUppdateraAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                                .addComponent(jLabelAlterAgent)
                                .addGap(43, 43, 43))
                            .addComponent(jButtonRensaRedigeraAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlterAgentLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                                .addComponent(jButtonRedAgentMerInställningar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnRedigeraAgentBacka))
                            .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                                .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33))
                                        .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(75, 75, 75)))
                                .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTxtRedigeraAgent)
                                    .addComponent(jComboBoxAgentFetch, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAlterAgentLayout.createSequentialGroup()
                                        .addComponent(jComboBoxRedigeraAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 26, Short.MAX_VALUE)))))
                        .addGap(15, 15, 15))))
        );
        jPanelAlterAgentLayout.setVerticalGroup(
            jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlterAgentLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelAlterAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAgentFetch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRedigeraAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRedigeraAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUppdateraAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRensaRedigeraAgent)
                .addGap(52, 52, 52)
                .addGroup(jPanelAlterAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRedigeraAgentBacka)
                    .addComponent(jButtonRedAgentMerInställningar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel10.setText("Mer inställningar");

        jButtonSparaKontorChef.setText("SPARA");
        jButtonSparaKontorChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSparaKontorChefActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setText("Kontorschef");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel14.setText("Områdeschef");

        jComboBoxSeAnsvarsOmrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel15.setText("Välj en områdeschef och se vilket ansvarsområde");

        jLabel16.setText("Ändra information om vilken agent som är kontorschef/områdeschef");

        jButtonSparaOmradesChef.setText("SPARA");
        jButtonSparaOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSparaOmradesChefActionPerformed(evt);
            }
        });

        jLabel17.setText("Välj agent");

        jLabel18.setText("Område");

        jLabel19.setText("Välj agent");

        jLabel20.setText("Område");

        jButton1.setText("Uppdatera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMerInställningarLayout = new javax.swing.GroupLayout(jPanelMerInställningar);
        jPanelMerInställningar.setLayout(jPanelMerInställningarLayout);
        jPanelMerInställningarLayout.setHorizontalGroup(
            jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)))
                    .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(311, 311, 311)
                        .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxOmradesChef1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                        .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fetchComboBoxAgentKCF, javax.swing.GroupLayout.Alignment.LEADING, 0, 115, Short.MAX_VALUE)
                                    .addComponent(jComboBoxListaOmrade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonSparaKontorChef, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)))
                        .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxOmradesChef2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel19))
                            .addComponent(jButtonSparaOmradesChef, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(84, 84, 84))))
            .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSeAnsvarsOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelMerInställningarLayout.setVerticalGroup(
            jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMerInställningarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxSeAnsvarsOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fetchComboBoxAgentKCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOmradesChef1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxListaOmrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOmradesChef2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMerInställningarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSparaKontorChef)
                    .addComponent(jButtonSparaOmradesChef))
                .addGap(84, 84, 84))
        );

        jLayeredPane1.setLayer(jPanelRegAgent, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelDelAgent, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelAlterAgent, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanelMerInställningar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRegAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelMerInställningar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDelAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelAlterAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanelRegAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMerInställningar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanelDelAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAlterAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );

        jButtonTillbaka.setText("Tillbaka");
        jButtonTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTillbakaActionPerformed(evt);
            }
        });

        jButtonMerInställningar.setText("Mer Inställningar");
        jButtonMerInställningar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMerInställningarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAlterAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRegAgent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMerInställningar)
                .addGap(44, 44, 44)
                .addComponent(jButtonTillbaka)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterAgent)
                    .addComponent(jButtonDelAgent)
                    .addComponent(jButtonRegAgent)
                    .addComponent(jButtonTillbaka)
                    .addComponent(jButtonMerInställningar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterAgentActionPerformed
        // TODO add your handling code here:
        jPanelRegAgent.setVisible(false);
        jPanelDelAgent.setVisible(false);
        jPanelAlterAgent.setVisible(true);
        jPanelMerInställningar.setVisible(false);
    }//GEN-LAST:event_jButtonAlterAgentActionPerformed

    private void jButtonDelAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelAgentActionPerformed
        // TODO add your handling code here:
        jPanelRegAgent.setVisible(false);
        jPanelDelAgent.setVisible(true);
        jPanelAlterAgent.setVisible(false);
        jPanelMerInställningar.setVisible(false);
    }//GEN-LAST:event_jButtonDelAgentActionPerformed

    private void jButtonRegAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegAgentActionPerformed
        // TODO add your handling code here:
        jPanelRegAgent.setVisible(true);
        jPanelDelAgent.setVisible(false);
        jPanelAlterAgent.setVisible(false);
        jPanelMerInställningar.setVisible(false);
    }//GEN-LAST:event_jButtonRegAgentActionPerformed

    private void jButtonSparaAgentRegistreringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSparaAgentRegistreringActionPerformed
        // TODO add your handling code here:
        
        // skriv kod
        
        String id = jTextFieldAgentRegAgentID.getText();
        String datum = jTextFieldDatum.getText();
        String losenord = "'" + jTextFieldAgentRegPW.getText() + "'";
        String namn = "'" + jTextFieldAgentRegNamn.getText() + "'";
        String telefon = "'" + jTextFieldAgentRegTelNr.getText() + "'";
        String omrade = "'" + jComboBoxOmrade.getSelectedItem().toString() + "'";
        String admin = "'" + jComboBoxAdmin.getSelectedItem().toString() + "'";
        int agentID = parseInt(id);
        
        
        try {
             String omradesID = idb.fetchSingle("Select omrades_id from omrade where benamning = " + omrade);
                String fraga = "INSERT INTO AGENT (AGENT_ID, NAMN, TELEFON, ANSTALLNINGSDATUM, ADMINISTRATOR, LOSENORD, OMRADE) VALUES"
                + " (" + agentID + "," + namn + "," + telefon + "," + datum  + "," + admin + "," + losenord + "," + omradesID + ")";
                idb.insert(fraga);
                JOptionPane.showMessageDialog(null, "Agenten tillagd i databasen!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Det blev något fel när du försökte regga en Alien," + "\n"
                    + "Regler;" + "\n" 
                    + "Inga tomma rutor" + "\n" 
                    + "Datum måste vara i rätt format tex 20210517" + "\n" 
                    + "Agent ID måste vara en siffra" + "\n" 
                    +  "Telefonnummer måste vara siffror" + "\n" 
                    + "vänligen försök igen");
            
        }
             

    }//GEN-LAST:event_jButtonSparaAgentRegistreringActionPerformed

    private void jButtonAgentRegRensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgentRegRensaActionPerformed
        // rensar textfält.
        jTextFieldAgentRegAgentID.setText("");    
        jTextFieldAgentRegNamn.setText("");
        jTextFieldAgentRegPW.setText("");
        jTextFieldAgentRegTelNr.setText("");
    }//GEN-LAST:event_jButtonAgentRegRensaActionPerformed

    private void jButtonTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTillbakaActionPerformed
        // går tillbaka till förgående ruta
        dispose();
    }//GEN-LAST:event_jButtonTillbakaActionPerformed

    private void jButtonTaBortAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTaBortAgentActionPerformed
        // Tar bort agent från databasen, kontroll om agent har en alien.
        // fixa combofox ist för textstring
        String agentNamn = "'" + txtFieldTaBortAgent.getText() + "'";
        String fragaDB = "DELETE FROM AGENT WHERE AGENT.NAMN = " + agentNamn;

        try {
            String agentID = idb.fetchSingle("SELECT AGENT_ID FROM AGENT WHERE NAMN = " + agentNamn);
            String agentAnsvarig = idb.fetchSingle("SELECT ALIEN_ID FROM ALIEN WHERE ANSVARIG_AGENT =" + agentID);
           // System.out.println(agentID);
          //  System.out.println(agentAnsvarig);
          //  System.out.println(agentNamn);

            if (agentAnsvarig != null) {
                JOptionPane.showMessageDialog(null, "Agenten du försöker ta bort ansvarar över en Alien!");
            } else {
                System.out.println(fragaDB);
                idb.delete(fragaDB);
                jTextFieldSvar.setText("Agent borttagen!");

            }
        } catch (Exception e) {
            System.out.println("catch");

        }


    }//GEN-LAST:event_jButtonTaBortAgentActionPerformed

    private void jButtonRensaRedigeraAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRensaRedigeraAgentActionPerformed
        // Rensar fältet på textfält i redigeraAgent

        jTxtRedigeraAgent.setText("");
    }//GEN-LAST:event_jButtonRensaRedigeraAgentActionPerformed

    
    private void jButtonMerInställningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMerInställningarActionPerformed
        // För nå respektive layer i panelen kan man sätta diverse saker till boolean värde true/false,
        // i detta fallet visas mer inställningar och allt annat göms.
       
        jPanelRegAgent.setVisible(false);
        jPanelDelAgent.setVisible(false);
        jPanelAlterAgent.setVisible(false);
        jPanelMerInställningar.setVisible(true);
    }//GEN-LAST:event_jButtonMerInställningarActionPerformed

    
    // Uppdaterar redigera Agent
    private void jButtonUppdateraAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUppdateraAgentActionPerformed
           // hämtar agent, hämtar vad man vill byta i combobox, i textrutan fyller man i nya värdet.
          
            String agentNamn = "'" + jComboBoxAgentFetch.getSelectedItem().toString() + "'";      
            String nyttVärde = jTxtRedigeraAgent.getText();          
            String attUppdatera = jComboBoxRedigeraAgent.getSelectedItem().toString();
    
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date parsed = null;

             try {
             parsed = format.parse("20110210");
             } catch (ParseException ex) {
            Logger.getLogger(AdminAgentMeny.class.getName()).log(Level.SEVERE, null, ex);
             }
            java.sql.Date sql = new java.sql.Date(parsed.getTime());

            
            try {
            String agentID = idb.fetchSingle("SELECT Agent_ID FROM AGENT WHERE NAMN = " + agentNamn);
  
                String input = "UPDATE AGENT SET " + attUppdatera + " = '" + nyttVärde + "' WHERE Agent_ID = " + agentID;
                updateDB(input);
        
                 JOptionPane.showMessageDialog(null, input);
                 
            
            
        } catch (InfException ex) {
            Logger.getLogger(AdminAgentMeny.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonUppdateraAgentActionPerformed

    // Backa från mer inställningar i redigera agent
    private void jBtnRedigeraAgentBackaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRedigeraAgentBackaActionPerformed
        // Backa funktion
        
        dispose();
    }//GEN-LAST:event_jBtnRedigeraAgentBackaActionPerformed
 
    // gör Mer inställningar i redigera agent synlig
    private void jButtonRedAgentMerInställningarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedAgentMerInställningarActionPerformed
        // gör panelen synlig
        new RedAgentMerInställnigar().setVisible(true);
    }//GEN-LAST:event_jButtonRedAgentMerInställningarActionPerformed

    // spara knappen till mer inställningar kontorstalpen
    private void jButtonSparaKontorChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSparaKontorChefActionPerformed
    // jButton som hämtar valda saker i respektive combobox och uppdaterar databasen. 
        String fetchAgent = "'" + fetchComboBoxAgentKCF.getSelectedItem().toString() + "'";
        String fetchKontorOmrade = "'" + jComboBoxListaOmrade.getSelectedItem().toString() + "'"; 
        try {
        String omradesID = idb.fetchSingle("SELECT OMRADES_ID FROM OMRADE WHERE BENAMNING = " + fetchKontorOmrade);
        String agentID = idb.fetchSingle("SELECT AGENT_ID FROM AGENT WHERE NAMN = " + fetchAgent);  
        
        idb.update("UPDATE OMRADESCHEF SET AGENT_ID = " + agentID + " WHERE OMRADE = " + omradesID); 
        
        JOptionPane.showMessageDialog(null, "Kontorchefen är uppdaterad");    
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Fel i systemet, kontakta IT-avdelning");
        }
    }//GEN-LAST:event_jButtonSparaKontorChefActionPerformed
    
    // spara knappen till mer inställningar områdeschefstalpen
    private void jButtonSparaOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSparaOmradesChefActionPerformed
        // TODO add your handling code here:
        String fetchAgent = "'" + jComboBoxOmradesChef1.getSelectedItem().toString() + "'";
        String fetchOmrade = "'" + jComboBoxOmradesChef2.getSelectedItem().toString() + "'"; 
        try {
        String omradesID = idb.fetchSingle("SELECT OMRADES_ID FROM OMRADE WHERE BENAMNING = " + fetchOmrade);
        String agentID = idb.fetchSingle("SELECT AGENT_ID FROM AGENT WHERE NAMN = " + fetchAgent);
      
        idb.update("UPDATE OMRADESCHEF SET AGENT_ID = " + agentID + " WHERE OMRADE = " + omradesID); 
       
        } catch (InfException e) {
            JOptionPane.showMessageDialog(null, "Fel i systemet, kontakta IT-avdelning");
        }
    }//GEN-LAST:event_jButtonSparaOmradesChefActionPerformed

    // onödig ta bort
    private void jTextFieldDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDatumActionPerformed
    
    
    // JbuttonPerformed metod, används för se områdeschef över ett område
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAgentMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAgentMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAgentMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAgentMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAgentMeny().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> fetchComboBoxAgentKCF;
    private javax.swing.JButton jBtnRedigeraAgentBacka;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAgentRegRensa;
    private javax.swing.JButton jButtonAlterAgent;
    private javax.swing.JButton jButtonDelAgent;
    private javax.swing.JButton jButtonMerInställningar;
    private javax.swing.JButton jButtonRedAgentMerInställningar;
    private javax.swing.JButton jButtonRegAgent;
    private javax.swing.JButton jButtonRensaRedigeraAgent;
    private javax.swing.JButton jButtonSparaAgentRegistrering;
    private javax.swing.JButton jButtonSparaKontorChef;
    private javax.swing.JButton jButtonSparaOmradesChef;
    private javax.swing.JButton jButtonTaBortAgent;
    private javax.swing.JButton jButtonTillbaka;
    private javax.swing.JButton jButtonUppdateraAgent;
    private javax.swing.JComboBox<String> jComboBoxAdmin;
    private javax.swing.JComboBox<String> jComboBoxAgentFetch;
    private javax.swing.JComboBox<String> jComboBoxListaOmrade;
    private javax.swing.JComboBox<String> jComboBoxOmrade;
    private javax.swing.JComboBox<String> jComboBoxOmradesChef1;
    private javax.swing.JComboBox<String> jComboBoxOmradesChef2;
    private javax.swing.JComboBox<String> jComboBoxRedigeraAgent;
    private javax.swing.JComboBox<String> jComboBoxSeAnsvarsOmrade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAlterAgent;
    private javax.swing.JLabel jLabelDelAgent;
    private javax.swing.JLabel jLabelRegAgent;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAlterAgent;
    private javax.swing.JPanel jPanelDelAgent;
    private javax.swing.JPanel jPanelMerInställningar;
    private javax.swing.JPanel jPanelRegAgent;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldAgentRegAgentID;
    private javax.swing.JTextField jTextFieldAgentRegNamn;
    private javax.swing.JTextField jTextFieldAgentRegPW;
    private javax.swing.JTextField jTextFieldAgentRegTelNr;
    private javax.swing.JTextField jTextFieldDatum;
    private javax.swing.JTextField jTextFieldSvar;
    private javax.swing.JTextField jTxtRedigeraAgent;
    private javax.swing.JTextField txtFieldTaBortAgent;
    // End of variables declaration//GEN-END:variables

    private void updateDB(String fraga) {
        try{
            
            String ettID = fraga;
            idb.update(ettID);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Försök igen");
        
        }
    }

}
