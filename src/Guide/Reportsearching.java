/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Guide;

import Connections.Connect;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.joda.time.*;

/**
 *
 * @author Administrator
 */
public class Reportsearching extends javax.swing.JFrame {

    DefaultComboBoxModel Comborange = new DefaultComboBoxModel();
    DefaultComboBoxModel Comborange2 = new DefaultComboBoxModel();
    DefaultTableModel tmod = new DefaultTableModel();
    Date date = new Date();
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int positionx;
    private int positiony;
    Container frame = this;

    public Reportsearching() {
        this.setUndecorated(true);
        initComponents();
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 1000, 557)).start();
        this.resulttable.setModel(tmod);
        this.actionrange.setModel(Comborange);
        this.timerange.setModel(Comborange2);
        addCol();
        ActionComboItem();
        TimeComboItem();
    }
    Timer thoigian;
    Integer second;

    public void timeclose() {

        second = 2;

        thoigian = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second = second - 1;
                if (second == 0) {
                    dispose();
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    int a = 0;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        keywordtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        timerange = new javax.swing.JComboBox();
        Searchbn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        actionrange = new javax.swing.JComboBox();
        txtyearsearch = new javax.swing.JTextField();
        txtmonthsearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdatesearch = new javax.swing.JTextField();
        butclose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resulttable = new org.jdesktop.swingx.JXTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Keywords:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        keywordtxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        keywordtxt.setForeground(new java.awt.Color(0, 0, 153));
        keywordtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keywordtxtMouseClicked(evt);
            }
        });
        getContentPane().add(keywordtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 253, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Time Range:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        timerange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        timerange.setForeground(new java.awt.Color(0, 0, 204));
        timerange.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "1 week ago", "1 month ago", "6 months ago", "1 year ago", "3 years ago" }));
        timerange.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                timerangeItemStateChanged(evt);
            }
        });
        timerange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerangeActionPerformed(evt);
            }
        });
        getContentPane().add(timerange, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 253, -1));

        Searchbn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.gif"))); // NOI18N
        Searchbn.setBorderPainted(false);
        Searchbn.setContentAreaFilled(false);
        Searchbn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Searchbn.setDefaultCapable(false);
        Searchbn.setFocusPainted(false);
        Searchbn.setFocusable(false);
        Searchbn.setRequestFocusEnabled(false);
        Searchbn.setRolloverEnabled(false);
        Searchbn.setVerifyInputWhenFocusTarget(false);
        Searchbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchbnActionPerformed(evt);
            }
        });
        getContentPane().add(Searchbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 180, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Action:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 50, -1));

        actionrange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        actionrange.setForeground(new java.awt.Color(0, 0, 153));
        actionrange.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "DEPOSITED", "WITHDRAWED", "TRANSFERED" }));
        actionrange.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                actionrangeItemStateChanged(evt);
            }
        });
        actionrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionrangeActionPerformed(evt);
            }
        });
        getContentPane().add(actionrange, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 253, -1));

        txtyearsearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtyearsearch.setForeground(new java.awt.Color(0, 0, 153));
        txtyearsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtyearsearchMouseClicked(evt);
            }
        });
        getContentPane().add(txtyearsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 93, -1));

        txtmonthsearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtmonthsearch.setForeground(new java.awt.Color(0, 0, 153));
        txtmonthsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtmonthsearchMouseClicked(evt);
            }
        });
        getContentPane().add(txtmonthsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 93, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Search in YEAR:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 182, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Search in MONTH:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 182, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Search in DATE:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 182, -1, -1));

        txtdatesearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtdatesearch.setForeground(new java.awt.Color(0, 0, 153));
        txtdatesearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdatesearchMouseClicked(evt);
            }
        });
        getContentPane().add(txtdatesearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 93, -1));

        butclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close1.png"))); // NOI18N
        butclose.setToolTipText("Close");
        butclose.setBorderPainted(false);
        butclose.setContentAreaFilled(false);
        butclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butclose.setDefaultCapable(false);
        butclose.setFocusPainted(false);
        butclose.setFocusable(false);
        butclose.setRequestFocusEnabled(false);
        butclose.setRolloverEnabled(false);
        butclose.setVerifyInputWhenFocusTarget(false);
        butclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butcloseMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butcloseMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butcloseMouseExited(evt);
            }
        });
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 18, 18));

        resulttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        resulttable.setColumnControlVisible(true);
        resulttable.setShowHorizontalLines(false);
        resulttable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(resulttable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 960, 310));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("(ID , Account , Full name)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 130, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Note : distinguish uppercase and lowercase!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Help");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, -1, -1));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgadvancedsearch.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchbnActionPerformed
        // TODO add your handling code here:
        tmod.getDataVector().removeAllElements();
        revalidate();
        if (a == 0) {
            LoadingDataSearch(this.keywordtxt.getText());
        } else {
            LoadingDataSearch2(this.keywordtxt.getText());
        }
    }//GEN-LAST:event_SearchbnActionPerformed

    private void timerangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timerangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timerangeActionPerformed

    private void actionrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionrangeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actionrangeActionPerformed

    private void txtyearsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtyearsearchMouseClicked
        a = 1;
    }//GEN-LAST:event_txtyearsearchMouseClicked

    private void txtmonthsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtmonthsearchMouseClicked
        a = 1;
    }//GEN-LAST:event_txtmonthsearchMouseClicked

    private void txtdatesearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdatesearchMouseClicked
        a = 1;
    }//GEN-LAST:event_txtdatesearchMouseClicked

    private void actionrangeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_actionrangeItemStateChanged
        // TODO add your handling code here:
        tmod.getDataVector().removeAllElements();

        LoadingDataSearch(this.keywordtxt.getText());
        revalidate();
    }//GEN-LAST:event_actionrangeItemStateChanged

    private void timerangeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_timerangeItemStateChanged
        // TODO add your handling code here:
        tmod.getDataVector().removeAllElements();
        revalidate();
        LoadingDataSearch(this.keywordtxt.getText());
    }//GEN-LAST:event_timerangeItemStateChanged

    private void keywordtxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keywordtxtMouseClicked
        // TODO add your handling code here:
        a = 0;
    }//GEN-LAST:event_keywordtxtMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        this.positionx = evt.getXOnScreen();
        this.positiony = evt.getYOnScreen();

        if (this.positionx > this.x1) {
            this.x2 = this.positionx - this.x1;
            this.frame.setLocation(this.frame.getX() + this.x2, this.frame.getY());
        } else if (this.positionx < this.x1) {
            this.x2 = this.x1 - this.positionx;
            this.frame.setLocation(this.frame.getX() - this.x2, this.frame.getY());
        }
        if (this.positiony > this.y1) {
            this.y2 = this.positiony - this.y1;
            this.frame.setLocation(this.frame.getX(), this.frame.getY() + this.y2);
        } else if (this.positiony < this.y1) {
            this.y2 = this.y1 - this.positiony;
            this.frame.setLocation(this.frame.getX(), this.frame.getY() - this.y2);
        }
        this.x1 = this.positionx;
        this.y1 = this.positiony;

    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        this.x1 = evt.getXOnScreen();
        this.y1 = evt.getYOnScreen();
    }//GEN-LAST:event_formMousePressed

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked
        if (evt.getClickCount() == 1) {
            timeclose();
            thoigian.start();
            this.setSize(1000, 557);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
    }//GEN-LAST:event_butcloseMouseClicked

    private void butcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseEntered

        butclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseEntered

    private void butcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseExited

        butclose.setIcon(new ImageIcon("src/images/close1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Searchbn;
    private javax.swing.JComboBox actionrange;
    private javax.swing.JLabel bg;
    private javax.swing.JButton butclose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keywordtxt;
    private org.jdesktop.swingx.JXTable resulttable;
    private javax.swing.JComboBox timerange;
    private javax.swing.JTextField txtdatesearch;
    private javax.swing.JTextField txtmonthsearch;
    private javax.swing.JTextField txtyearsearch;
    // End of variables declaration//GEN-END:variables

    private void addCol() {
        tmod.addColumn("ID");
        tmod.addColumn("Account");
        tmod.addColumn("Full Name");
        tmod.addColumn("Action");
        tmod.addColumn("Money");
        tmod.addColumn("Beneficiary");
        tmod.addColumn("Balance");
        tmod.addColumn("Dates");
    }

    private void LoadingDataSearch(String RegID) {
        try {
            Connect.connectDatabase();
            CallableStatement csta = Connect.connectDatabase().prepareCall("{call Reportloading}");
            ResultSet rst = csta.executeQuery();

            while (rst.next()) {

                Vector dulieu = new Vector();
                dulieu.add(rst.getString("ReportID").toString());
                dulieu.add(rst.getString("Report_AccountID").toString());
                dulieu.add(rst.getString("Report_Fullname").toString());
                dulieu.add(rst.getString("Report_Action").toString());
                dulieu.add(rst.getInt("Report_Amount") + "$");
                dulieu.add(rst.getString("Report_Beneficiary").toString());
                dulieu.add(rst.getInt("Report_Balance") + "$");


                String date_s = rst.getString("ReportDate");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = dt.parse(date_s);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");

                dulieu.add(dt1.format(date));


                DateTime start = new DateTime(
                        rst.getDate("ReportDate").getYear() + 1900,
                        rst.getDate("ReportDate").getMonth() + 1,
                        rst.getDate("ReportDate").getDate(), 0, 0, 0, 0);
                DateTime ends = new DateTime(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), 0, 0, 0, 0);
                Months m = Months.monthsBetween(start, ends);
                Days da = Days.daysBetween(start, ends);

                if (keywordtxt.getText().equals(rst.getString("ReportID").toString())
                        || keywordtxt.getText().equals(rst.getString("Report_AccountID").toString())
                        || keywordtxt.getText().equals(rst.getString("Report_Fullname").toString())) {
                    if (timerange.getSelectedItem().toString() == "All") {
                        if (actionrange.getSelectedItem() == "All") {
                            tmod.addRow(dulieu);
                        } else if (actionrange.getSelectedItem() == "DEPOSITED") {
                            if (rst.getString("Report_Action").toString().equals("DEPOSITED")) {
                                tmod.addRow(dulieu);
                            }
                        } else if (actionrange.getSelectedItem() == "WITHDREW") {
                            if (rst.getString("Report_Action").toString().equals("WITHDREW")) {
                                tmod.addRow(dulieu);
                            }
                        } else {
                            if (rst.getString("Report_Action").toString().equals("TRANSFERED")) {
                                tmod.addRow(dulieu);
                            }
                        }

                    } // 1 week ago
                    else if (timerange.getSelectedItem().toString().equals("1 week ago")) {
                        if (da.getDays() <= 7) {
                            if (actionrange.getSelectedItem() == "All") {
                                tmod.addRow(dulieu);
                            } else if (actionrange.getSelectedItem() == "DEPOSITED") {
                                if (rst.getString("Report_Action").toString().equals("DEPOSITED")) {
                                    tmod.addRow(dulieu);
                                }
                            } else if (actionrange.getSelectedItem() == "WITHDREW") {
                                if (rst.getString("Report_Action").toString().equals("WITHDREW")) {
                                    tmod.addRow(dulieu);
                                }
                            } else {
                                if (rst.getString("Report_Action").toString().equals("TRANSFERED")) {
                                    tmod.addRow(dulieu);
                                }
                            }
                        }


                    } else if (timerange.getSelectedItem().toString().equals("1 month ago")) {
                        if (da.getDays() <= 31) {
                            if (actionrange.getSelectedItem() == "All") {
                                tmod.addRow(dulieu);
                            } else if (actionrange.getSelectedItem() == "DEPOSITED") {
                                if (rst.getString("Report_Action").toString().equals("DEPOSITED")) {
                                    tmod.addRow(dulieu);
                                }
                            } else if (actionrange.getSelectedItem() == "WITHDREW") {
                                if (rst.getString("Report_Action").toString().equals("WITHDREW")) {
                                    tmod.addRow(dulieu);
                                }
                            } else {
                                if (rst.getString("Report_Action").toString().equals("TRANSFERED")) {
                                    tmod.addRow(dulieu);
                                }
                            }
                        }
                    } else if (timerange.getSelectedItem().toString().equals("6 months ago")) {
                        if (m.getMonths() <= 6) {
                            if (actionrange.getSelectedItem() == "All") {
                                tmod.addRow(dulieu);
                            } else if (actionrange.getSelectedItem() == "DEPOSITED") {
                                if (rst.getString("Report_Action").toString().equals("DEPOSITED")) {
                                    tmod.addRow(dulieu);
                                }
                            } else if (actionrange.getSelectedItem() == "WITHDREW") {
                                if (rst.getString("Report_Action").toString().equals("WITHDREW")) {
                                    tmod.addRow(dulieu);
                                }
                            } else {
                                if (rst.getString("Report_Action").toString().equals("TRANSFERED")) {
                                    tmod.addRow(dulieu);
                                }
                            }
                        }
                    } else if (timerange.getSelectedItem().toString().equals("1 year ago")) {
                        if (da.getDays() <= 366) {
                            if (actionrange.getSelectedItem() == "All") {
                                tmod.addRow(dulieu);
                            } else if (actionrange.getSelectedItem() == "DEPOSITED") {
                                if (rst.getString("Report_Action").toString().equals("DEPOSITED")) {
                                    tmod.addRow(dulieu);
                                }
                            } else if (actionrange.getSelectedItem() == "WITHDREW") {
                                if (rst.getString("Report_Action").toString().equals("WITHDREW")) {
                                    tmod.addRow(dulieu);
                                }
                            } else {
                                if (rst.getString("Report_Action").toString().equals("TRANSFERED")) {
                                    tmod.addRow(dulieu);
                                }
                            }
                        }
                    } else if (timerange.getSelectedItem().toString().equals("3 years ago")) {

                        if (da.getDays() <= 1096) {
                            if (actionrange.getSelectedItem() == "All") {
                                tmod.addRow(dulieu);
                            } else if (actionrange.getSelectedItem() == "DEPOSITED") {
                                if (rst.getString("Report_Action").toString().equals("DEPOSITED")) {
                                    tmod.addRow(dulieu);
                                }
                            } else if (actionrange.getSelectedItem() == "WITHDREW") {
                                if (rst.getString("Report_Action").toString().equals("WITHDREW")) {
                                    tmod.addRow(dulieu);
                                }
                            } else {
                                if (rst.getString("Report_Action").toString().equals("TRANSFERED")) {
                                    tmod.addRow(dulieu);
                                }
                            }
                        }
                    }
//             
                }

            }

        } catch (Exception e) {
            //System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }
    Connection con = null;

    private void ActionComboItem() {
        Comborange.addElement("All");
        Comborange.addElement("DEPOSITED");
        Comborange.addElement("WITHDREW");
        Comborange.addElement("TRANSFERED");
    }

    private void TimeComboItem() {
        Comborange2.addElement("All");
        Comborange2.addElement("1 week ago");
        Comborange2.addElement("1 month ago");
        Comborange2.addElement("6 months ago");
        Comborange2.addElement("1 year ago");
        Comborange2.addElement("3 years ago");
    }

    private void LoadingDataSearch2(String RegID) {
        try {
            Connect.connectDatabase();
            CallableStatement csta = Connect.connectDatabase().prepareCall("{call Reportloading}");
            ResultSet rst = csta.executeQuery();

            while (rst.next()) {

                Vector dulieu = new Vector();
                dulieu.add(rst.getString("ReportID").toString());
                dulieu.add(rst.getString("Report_AccountID").toString());
                dulieu.add(rst.getString("Report_Fullname").toString());
                dulieu.add(rst.getString("Report_Action").toString());
                dulieu.add(rst.getInt("Report_Amount") + "$");
                dulieu.add(rst.getString("Report_Beneficiary").toString());
                dulieu.add(rst.getInt("Report_Balance") + "$");



                String date_s = rst.getString("ReportDate");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = dt.parse(date_s);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");

                dulieu.add(dt1.format(date));


                if (txtyearsearch.getText().toString().equals("")
                        || txtmonthsearch.getText().toString().equals("")
                        || txtdatesearch.getText().toString().equals("")) {

                    if (txtyearsearch.getText().toString().equals(
                            String.valueOf(
                            rst.getDate("ReportDate").getYear() + 1900))) {
                        tmod.addRow(dulieu);
                    } else if (txtmonthsearch.getText().toString().equals(String.valueOf(rst.getDate("ReportDate").getMonth() + 1))) {
                        tmod.addRow(dulieu);


                    } else if (txtdatesearch.getText().toString().equals(
                            String.valueOf(
                            rst.getDate("ReportDate").getDate()))) {
                        tmod.addRow(dulieu);
                    }
                } else {
                    if (txtmonthsearch.getText().toString().equals(String.valueOf(rst.getDate("ReportDate").getMonth() + 1))
                            && txtdatesearch.getText().toString().equals(
                            String.valueOf(
                            rst.getDate("ReportDate").getDate()))) {
                        tmod.addRow(dulieu);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error has occurred!");
        }
    }
}
