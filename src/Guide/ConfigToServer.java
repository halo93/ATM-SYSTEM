package Guide;

import Connections.SplashConnect;


import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.Timer;

public class ConfigToServer extends javax.swing.JFrame {
    //mouse move

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int positionx;
    private int positiony;
    Container frame = this;
    //connect
    Connection con;

    public ConfigToServer() {
        setUndecorated(true);
        initComponents();
        this.setResizable(false);
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 500, 400)).start();
        txtdatabase.setEditable(false);
        Image icon = getToolkit().getImage(getClass().getResource("/images/iconmanager.png"));
        setIconImage(icon);
    }
/// check enter 

    boolean check() {
        String server = this.txtserver.getText();
        String port = this.txtport.getText();
        String login = this.txtlogin.getText();
        String database = this.txtdatabase.getText();
        String password = new String(this.txtpassword.getPassword());
        if (server.equals("")) {
            lbserver.setText("Server is not empty.");
            return false;
        } else {
            lbserver.setText("");
        }
        if (port.equals("")) {
            lbport.setText("Port is not empty.");
            return false;
        } else {
            lbport.setText("");

        }
        if (login.equals("")) {
            lblogin.setText("Login is not empty.");
            return false;
        } else {
            lblogin.setText("");
        }

        if (password.equals("")) {
            lbpassword.setText("Password is not empty.");
            return false;
        } else {
            lbpassword.setText("");
        }
        if (database.equals("")) {
            lbdatabase.setText("Database is not empty.");
            return false;
        } else {
            lbdatabase.setText("");
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btCancel = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        txtport = new javax.swing.JTextField();
        txtlogin = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        txtserver = new javax.swing.JTextField();
        txtdatabase = new javax.swing.JTextField();
        lbserver = new javax.swing.JLabel();
        lbpassword = new javax.swing.JLabel();
        lbdatabase = new javax.swing.JLabel();
        lbport = new javax.swing.JLabel();
        lblogin = new javax.swing.JLabel();
        lbletter = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connect Database");
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Database :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Password :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Login :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Server :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Port  :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 40, -1));

        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btCancel.setBorderPainted(false);
        btCancel.setContentAreaFilled(false);
        btCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCancel.setDefaultCapable(false);
        btCancel.setFocusPainted(false);
        btCancel.setFocusable(false);
        btCancel.setRequestFocusEnabled(false);
        btCancel.setRolloverEnabled(false);
        btCancel.setVerifyInputWhenFocusTarget(false);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 150, 50));

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btSave.setBorderPainted(false);
        btSave.setContentAreaFilled(false);
        btSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSave.setDefaultCapable(false);
        btSave.setFocusPainted(false);
        btSave.setFocusable(false);
        btSave.setRequestFocusEnabled(false);
        btSave.setRolloverEnabled(false);
        btSave.setVerifyInputWhenFocusTarget(false);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 150, 50));

        txtport.setText("1433");
        txtport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtportActionPerformed(evt);
            }
        });
        txtport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtportKeyPressed(evt);
            }
        });
        getContentPane().add(txtport, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 47, -1));

        txtlogin.setText("sa");
        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });
        getContentPane().add(txtlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 180, -1));

        txtpassword.setText("123456");
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 180, -1));

        txtserver.setText("localhost");
        txtserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtserverActionPerformed(evt);
            }
        });
        getContentPane().add(txtserver, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 180, -1));

        txtdatabase.setText("ATM_SYSTEM");
        getContentPane().add(txtdatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 180, -1));

        lbserver.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lbserver, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 120, 160, 13));

        lbpassword.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lbpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 180, 10));

        lbdatabase.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lbdatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 160, 12));

        lbport.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lbport, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 160, 13));

        lblogin.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 180, 15));

        lbletter.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lbletter, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 130, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Help");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/config.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Timer thoigian;
    Integer second;

    public void timecancel() {

        second = 2;

        thoigian = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second = second - 1;
                if (second == 0) {
                    System.exit(0);
                }
            }
        });
    }

    public void timeConnect() {

        second = 2;

        thoigian = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second = second - 1;

                if (second == 0) {
                    if (check()) {
                        try {
                            FileWriter fw = new FileWriter("connect.cfg");
                            BufferedWriter bw = new BufferedWriter(fw);

                            ////
                            try {
                                bw.write(txtserver.getText());
                                bw.newLine();
                                bw.write(txtport.getText());
                                bw.newLine();
                                bw.write(txtlogin.getText());
                                bw.newLine();
                                bw.write(new String(txtpassword.getPassword()));
                                bw.newLine();
                                bw.write(txtdatabase.getText());
                                bw.close();
                                fw.close();
                            } catch (Exception ex) {
                                System.out.println("Cann not to encryption!");
                            }
                        } catch (IOException iOException) {
                            System.out.println("Can not to write!");
                        }
                        SplashConnect ss = new SplashConnect();
                        ss.showSplash();
                        dispose();
                    }
                }
            }
        });
    }

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed

        timecancel();
        thoigian.start();
        this.setSize(500, 400);
        new Thread(new DisplayClose(this, 0, 0)).start();

    }//GEN-LAST:event_btCancelActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        timeConnect();
        thoigian.start();
        this.setSize(500, 400);
        new Thread(new DisplayClose(this, 0, 0)).start();

}//GEN-LAST:event_btSaveActionPerformed

    private void txtportKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtportKeyPressed

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtport.setEditable(true);
            lbletter.setText("");
        } else if (evt.getKeyCode() == 8) {
            txtport.setEditable(true);
        } else {
            lbletter.setText("Can not enter letters.");
            txtport.setEditable(false);
        }

    }//GEN-LAST:event_txtportKeyPressed

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

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed

        btSaveActionPerformed(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed

        btSaveActionPerformed(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginActionPerformed

    private void txtportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtportActionPerformed

        btSaveActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtportActionPerformed

    private void txtserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtserverActionPerformed

        btSaveActionPerformed(evt);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtserverActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try {
            Runtime.getRuntime().exec("hh.exe \"HelpConnect.chm");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

          if (evt.getKeyCode() == 112) {
            try {
                Runtime.getRuntime().exec("hh.exe \"HelpConnect.chm");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbdatabase;
    private javax.swing.JLabel lbletter;
    private javax.swing.JLabel lblogin;
    private javax.swing.JLabel lbpassword;
    private javax.swing.JLabel lbport;
    private javax.swing.JLabel lbserver;
    private javax.swing.JTextField txtdatabase;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtport;
    private javax.swing.JTextField txtserver;
    // End of variables declaration//GEN-END:variables
}
