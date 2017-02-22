/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Guide;

import Connections.Connect;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Ngo Luan
 */
public class Block_Managers extends javax.swing.JDialog {

    static String Username;

    public Block_Managers(java.awt.Frame parent, boolean modal, String username) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        this.Username = username;

        this.setSize(0, 0);
        new Thread(new DisplayClose(this, 600, 300)).start();
        try {
            Connect.connectDatabase();
            CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowManager(?)}");
            call.setString(1, username);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                lbusername.setText("<html>" + rs.getString("Managers_Fullname") + "<font color ='#FFFFFF'> !</font></html>");
            }
        } catch (Exception e) {
        }
    }
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int positionx;
    private int positiony;
    Container frame = this;
    Timer time;
    Integer second;

    public void timelexit() {

        second = 2;

        time = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second = second - 1;
                if (second == 0) {
                    System.exit(0);
                }

            }
        });
    }

    public void timel() {

        second = 1;

        time = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second = second - 1;
                if (second == 0) {
                    dispose();
                    new Admin_Login().setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbusername = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        butback = new javax.swing.JButton();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hi ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        lbusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbusername.setForeground(new java.awt.Color(0, 153, 153));
        lbusername.setText("jLabel2");
        getContentPane().add(lbusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Your account is locked, please contact the administrator!");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        butback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        butback.setToolTipText("Back");
        butback.setBorderPainted(false);
        butback.setContentAreaFilled(false);
        butback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butback.setDefaultCapable(false);
        butback.setFocusPainted(false);
        butback.setFocusable(false);
        butback.setRequestFocusEnabled(false);
        butback.setRolloverEnabled(false);
        butback.setVerifyInputWhenFocusTarget(false);
        butback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butbackMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butbackMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butbackMouseEntered(evt);
            }
        });
        getContentPane().add(butback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 44, 42));

        butclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close1.png"))); // NOI18N
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butcloseMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butcloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butcloseMouseEntered(evt);
            }
        });
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 19, 19));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgblocked.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged


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
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        this.x1 = evt.getXOnScreen();
        this.y1 = evt.getYOnScreen();
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void butbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butbackMouseEntered

        butback.setIcon(new ImageIcon("src/images/back1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butbackMouseEntered

    private void butbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butbackMouseExited

        butback.setIcon(new ImageIcon("src/images/back.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butbackMouseExited

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked

        if (evt.getClickCount() == 1) {
            timelexit();
            time.start();
            this.setSize(600, 300);
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

    private void butbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butbackMouseClicked
        if (evt.getClickCount() == 1) {

            timel();
            time.start();
            this.setSize(600, 300);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
    }//GEN-LAST:event_butbackMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton butback;
    private javax.swing.JButton butclose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbusername;
    // End of variables declaration//GEN-END:variables
}
