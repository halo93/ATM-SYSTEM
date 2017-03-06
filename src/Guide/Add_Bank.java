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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Ngo Luan
 */
public class Add_Bank extends javax.swing.JDialog {

    /**
     * Creates new form Add_Bank
     */
    public Add_Bank(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 509, 270)).start();
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
    
    boolean check() {
        
        if (txtnamebank.getText().equals("")) {
            lb1.setText("Bank name is not empty.");
            return false;
        } else {
            lb1.setText("");
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnamebank = new javax.swing.JTextField();
        butadd = new javax.swing.JButton();
        butcancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtnamebank, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 260, 30));

        butadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/butadd.png"))); // NOI18N
        butadd.setBorderPainted(false);
        butadd.setContentAreaFilled(false);
        butadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butadd.setDefaultCapable(false);
        butadd.setFocusPainted(false);
        butadd.setFocusable(false);
        butadd.setRequestFocusEnabled(false);
        butadd.setRolloverEnabled(false);
        butadd.setVerifyInputWhenFocusTarget(false);
        butadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butaddMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butaddMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butaddMouseExited(evt);
            }
        });
        getContentPane().add(butadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 154, 39));

        butcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        butcancel.setBorderPainted(false);
        butcancel.setContentAreaFilled(false);
        butcancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butcancel.setDefaultCapable(false);
        butcancel.setFocusPainted(false);
        butcancel.setFocusable(false);
        butcancel.setRequestFocusEnabled(false);
        butcancel.setRolloverEnabled(false);
        butcancel.setVerifyInputWhenFocusTarget(false);
        butcancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butcancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butcancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butcancelMouseExited(evt);
            }
        });
        getContentPane().add(butcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 154, 39));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Bank Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, 20));

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

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgaddnewbank.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseClicked
        if (evt.getClickCount() == 1) {
            if (check()) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call addbank(?)}");
                    call.setString(1, txtnamebank.getText());
                    
                    int inser = call.executeUpdate();
                    if (inser > 0) {
                        lb1.setText("Successfully!");
                        timel();
                        thoigian.start();
                        this.setSize(509, 270);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lb1.setText("Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    lb1.setText("sorry! This Bank Name was used!");
                }
            }
        }
    }//GEN-LAST:event_butaddMouseClicked
    
    private void butcancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseClicked
        
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(509, 270);
            new Thread(new DisplayClose(this, 0, 0)).start();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseClicked
    
    private void butcancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseEntered
        
        butcancel.setIcon(new ImageIcon("src/images/cancel1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseEntered
    
    private void butcancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseExited
        
        butcancel.setIcon(new ImageIcon("src/images/cancel.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseExited
    
    private void butaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseEntered
        
        butadd.setIcon(new ImageIcon("src/images/butadd1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseEntered
    
    private void butaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseExited
        butadd.setIcon(new ImageIcon("src/images/butadd.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseExited
    
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton butadd;
    private javax.swing.JButton butcancel;
    private javax.swing.JButton butclose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JTextField txtnamebank;
    // End of variables declaration//GEN-END:variables
}
