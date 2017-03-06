/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Guide;

import Connections.Connect;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Ngo Luan
 */
public class Edit_Bank extends javax.swing.JDialog {

    /**
     * Creates new form Edit_Bank
     */
    static String bankname;

    public Edit_Bank(java.awt.Frame parent, boolean modal, String bankname) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 509, 270)).start();
        this.bankname = bankname;
        showbank();
    }
    Timer thoigian;
    Integer second;

    public void timel() {

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

    public void showbank() {
        try {
            Connect.connectDatabase();
            CallableStatement ca = Connect.connectDatabase().prepareCall("{call ShowBankname(?)}");
            ca.setString(1, bankname);
            ResultSet rs = ca.executeQuery();
            while (rs.next()) {
                txtnamebank.setText(bankname);
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnamebank = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        butchange = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bank Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        txtnamebank.setEnabled(false);
        txtnamebank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamebankActionPerformed(evt);
            }
        });
        getContentPane().add(txtnamebank, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 260, 30));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, 20));

        butchange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        butchange.setBorderPainted(false);
        butchange.setContentAreaFilled(false);
        butchange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butchange.setDefaultCapable(false);
        butchange.setFocusPainted(false);
        butchange.setFocusable(false);
        butchange.setRequestFocusEnabled(false);
        butchange.setRolloverEnabled(false);
        butchange.setVerifyInputWhenFocusTarget(false);
        butchange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butchangeMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butchangeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butchangeMouseExited(evt);
            }
        });
        getContentPane().add(butchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 155, 39));

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        cancel.setBorderPainted(false);
        cancel.setContentAreaFilled(false);
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.setDefaultCapable(false);
        cancel.setFocusPainted(false);
        cancel.setFocusable(false);
        cancel.setRequestFocusEnabled(false);
        cancel.setRolloverEnabled(false);
        cancel.setVerifyInputWhenFocusTarget(false);
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 155, 39));

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butcloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butcloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butcloseMouseExited(evt);
            }
        });
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 18, 19));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgaeditbank.png"))); // NOI18N
        bg.setFocusable(false);
        bg.setInheritsPopupMenu(false);
        bg.setRequestFocusEnabled(false);
        bg.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(509, 270);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseClicked

    private void butcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseEntered
        butclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseEntered

    private void butcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseExited
        butclose.setIcon(new ImageIcon("src/images/close1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseExited

    private void butchangeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butchangeMouseEntered

        butchange.setIcon(new ImageIcon("src/images/change1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butchangeMouseEntered

    private void butchangeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butchangeMouseExited

        butchange.setIcon(new ImageIcon("src/images/change.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butchangeMouseExited

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered

        cancel.setIcon(new ImageIcon("src/images/cancel1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setIcon(new ImageIcon("src/images/cancel.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseExited

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked

        if (evt.getClickCount() == 1) {
            if (evt.getClickCount() == 1) {
                timel();
                thoigian.start();
                this.setSize(509, 270);
                new Thread(new DisplayClose(this, 0, 0)).start();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    boolean check() {
        if (txtnamebank.getText().equals("")) {
            lb1.setText("Bank name is not empty.");
            return false;
        } else {
            lb1.setText("");
        }
        return true;
    }

    private void butchangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butchangeMouseClicked
        if (evt.getClickCount() == 1) {
            if (check()) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeBankname(?)}");

                    call.setString(1, txtnamebank.getText());
                    
                    int ins = call.executeUpdate();

                    if (ins > 0) {
                        lb1.setText("Successfully!");
                        timel();
                        thoigian.start();
                        this.setSize(509, 270);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Edit_Bank.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_butchangeMouseClicked

    private void txtnamebankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamebankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamebankActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton butchange;
    private javax.swing.JButton butclose;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JTextField txtnamebank;
    // End of variables declaration//GEN-END:variables
}
