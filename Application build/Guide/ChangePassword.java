package Guide;

import Connections.Connect;
import Encryption.encryptionMD5;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ChangePassword extends javax.swing.JDialog {

    private String password = Management.getPassword(); // set password to manager
    private String username = Management.getUsername();// get username from manager
    private String position = Management.position;

    public ChangePassword(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);

        //image backround
        setContentPane(new JLabel(new ImageIcon("src/images/loginbg.png")));
        initComponents();
        //splash
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 400, 300)).start();

    }
    // time dispose
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

        if (String.valueOf(txtpasswordold.getPassword()).equals("")) {
            lb1.setText("Old password  is not empty.");
            return false;
        } else {
            lb1.setText("");
        }
        if (String.valueOf(txtpasswordnew.getPassword()).equals("")) {
            lb2.setText("New password  is not empty.");
            return false;
        } else {
            lb2.setText("");
        }
        if (String.valueOf(txtpasswordcon.getPassword()).equals("")) {
            lb3.setText("Confirm Password is not empty.");
            return false;
        } else {
            lb3.setText("");
        }
        encryptionMD5 MD5 = new encryptionMD5();
        String passold = MD5.encryptMD5(new String(this.txtpasswordold.getPassword()));
        String passwordnew = MD5.encryptMD5(new String(this.txtpasswordnew.getPassword()));
        String passwordcon = MD5.encryptMD5(new String(this.txtpasswordcon.getPassword()));


        if (!passold.equals(password)) {
            lb1.setText("Old password is incorrect!");
            return false;
        } else {
            lb1.setText("");
        }
        if (passwordnew.equals(passold)) {
            lb2.setText("Can't be the same Old password!");
            return false;
        } else {
            lb2.setText("");
        }
        if (!passwordcon.equals(passwordnew)) {
            lb3.setText("Must have the same new password!");
            return false;
        } else {
            lb3.setText("");
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        txtpasswordold = new javax.swing.JPasswordField();
        txtpasswordnew = new javax.swing.JPasswordField();
        txtpasswordcon = new javax.swing.JPasswordField();
        lb4 = new javax.swing.JLabel();
        butchange = new javax.swing.JButton();
        butcancel = new javax.swing.JButton();
        close = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Old Password :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 136, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("New Password :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 136, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Confirm Password :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 210, 20));

        lb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 210, 20));

        lb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 230, 20));

        txtpasswordold.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpasswordold.setForeground(new java.awt.Color(0, 0, 204));
        txtpasswordold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordoldActionPerformed(evt);
            }
        });
        getContentPane().add(txtpasswordold, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 210, -1));

        txtpasswordnew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpasswordnew.setForeground(new java.awt.Color(0, 0, 204));
        txtpasswordnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordnewActionPerformed(evt);
            }
        });
        txtpasswordnew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordnewKeyPressed(evt);
            }
        });
        getContentPane().add(txtpasswordnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 210, -1));

        txtpasswordcon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpasswordcon.setForeground(new java.awt.Color(0, 0, 204));
        txtpasswordcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordconActionPerformed(evt);
            }
        });
        txtpasswordcon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordconKeyPressed(evt);
            }
        });
        getContentPane().add(txtpasswordcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 210, -1));

        lb4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb4.setForeground(new java.awt.Color(153, 0, 0));
        lb4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 310, 20));

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butchangeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butchangeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butchangeMouseExited(evt);
            }
        });
        getContentPane().add(butchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 155, 40));

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
        getContentPane().add(butcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 155, 40));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close1.png"))); // NOI18N
        close.setToolTipText("");
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setDefaultCapable(false);
        close.setFocusPainted(false);
        close.setFocusable(false);
        close.setRequestFocusEnabled(false);
        close.setRolloverEnabled(false);
        close.setVerifyInputWhenFocusTarget(false);
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeMouseExited(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 12, 18, 18));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgchangepassword.png"))); // NOI18N
        bg.setToolTipText("");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpasswordnewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordnewKeyPressed

        String aa = String.valueOf(txtpasswordnew.getPassword());
        if (aa.length() < 5) {
            lb2.setText("More than five character");
            txtpasswordcon.setEditable(false);
            butchange.setEnabled(false);
        } else {
            lb2.setText("");
            txtpasswordcon.setEditable(true);
            butchange.setEnabled(true);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordnewKeyPressed

    private void txtpasswordconKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordconKeyPressed

        String bb = String.valueOf(txtpasswordcon.getPassword());
        if (bb.length() < 5) {
            lb3.setText("More than five character");
            butchange.setEnabled(false);
        } else {
            lb3.setText("");
            butchange.setEnabled(true);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordconKeyPressed

    private void txtpasswordconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordconActionPerformed

        if (check()) {
            // change passwor admin
            if (position.equals("Administrator")) {
                encryptionMD5 MD5 = new encryptionMD5();

                try {
                    Connect.connectDatabase();
                    CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassAdmin(?,?)}");
                    admin.setString(1, this.username);
                    admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                    int rowAffectted = admin.executeUpdate();
                    if (rowAffectted > 0) {
                        lb4.setText("successfully!");
                        Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                        timel();
                        thoigian.start();
                        this.setSize(400, 300);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lb4.setText("Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (position.equals("Manager")) {
                encryptionMD5 MD5 = new encryptionMD5();

                try {
                    Connect.connectDatabase();
                    CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassManager(?,?)}");
                    admin.setString(1, this.username);
                    admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                    int rowAffectted = admin.executeUpdate();
                    if (rowAffectted > 0) {
                        lb4.setText("successfully!");
                        Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                        timel();
                        thoigian.start();
                        this.setSize(400, 300);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lb4.setText("Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_txtpasswordconActionPerformed

    private void txtpasswordoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordoldActionPerformed
        if (check()) {
            // change passwor admin
            if (position.equals("Administrator")) {
                encryptionMD5 MD5 = new encryptionMD5();

                try {
                    Connect.connectDatabase();
                    CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassAdmin(?,?)}");
                    admin.setString(1, this.username);
                    admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                    int rowAffectted = admin.executeUpdate();
                    if (rowAffectted > 0) {
                        lb4.setText("successfully!");
                        Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                        timel();
                        thoigian.start();
                        this.setSize(400, 300);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lb4.setText("Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (position.equals("Manager")) {
                encryptionMD5 MD5 = new encryptionMD5();

                try {
                    Connect.connectDatabase();
                    CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassManager(?,?)}");
                    admin.setString(1, this.username);
                    admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                    int rowAffectted = admin.executeUpdate();
                    if (rowAffectted > 0) {
                        lb4.setText("successfully!");
                        Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                        timel();
                        thoigian.start();
                        this.setSize(400, 300);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lb4.setText("Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordoldActionPerformed

    private void txtpasswordnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordnewActionPerformed


        if (check()) {
            // change passwor admin
            if (position.equals("Administrator")) {
                encryptionMD5 MD5 = new encryptionMD5();

                try {
                    Connect.connectDatabase();
                    CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassAdmin(?,?)}");
                    admin.setString(1, this.username);
                    admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                    int rowAffectted = admin.executeUpdate();
                    if (rowAffectted > 0) {
                        lb4.setText("successfully!");
                        Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                        timel();
                        thoigian.start();
                        this.setSize(400, 300);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lb4.setText("Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (position.equals("Manager")) {
                encryptionMD5 MD5 = new encryptionMD5();

                try {
                    Connect.connectDatabase();
                    CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassManager(?,?)}");
                    admin.setString(1, this.username);
                    admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                    int rowAffectted = admin.executeUpdate();
                    if (rowAffectted > 0) {
                        lb4.setText("successfully!");
                        Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                        timel();
                        thoigian.start();
                        this.setSize(400, 300);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lb4.setText("Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordnewActionPerformed

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered

        close.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseEntered

    private void closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseExited
        close.setIcon(new ImageIcon("src/images/close1.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_closeMouseExited

    private void butchangeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butchangeMouseEntered

        butchange.setIcon(new ImageIcon("src/images/change1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butchangeMouseEntered

    private void butchangeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butchangeMouseExited

        butchange.setIcon(new ImageIcon("src/images/change.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butchangeMouseExited

    private void butcancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseEntered

        butcancel.setIcon(new ImageIcon("src/images/cancel1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseEntered

    private void butcancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseExited

        butcancel.setIcon(new ImageIcon("src/images/cancel.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseExited

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(400, 300);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
    }//GEN-LAST:event_closeMouseClicked

    private void butchangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butchangeMouseClicked

        if (evt.getClickCount() == 1) {
            if (check()) {
                // change passwor admin
                if (position.equals("Administrator")) {
                    encryptionMD5 MD5 = new encryptionMD5();

                    try {
                        Connect.connectDatabase();
                        CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassAdmin(?,?)}");
                        admin.setString(1, this.username);
                        admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                        int rowAffectted = admin.executeUpdate();
                        if (rowAffectted > 0) {
                            lb4.setText("successfully!");
                            Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                            timel();
                            thoigian.start();
                            this.setSize(400, 300);
                            new Thread(new DisplayClose(this, 0, 0)).start();
                        } else {
                            lb4.setText("Unsuccessfully!");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (position.equals("Manager")) {
                    encryptionMD5 MD5 = new encryptionMD5();

                    try {
                        Connect.connectDatabase();
                        CallableStatement admin = Connect.connectDatabase().prepareCall("{call ChangePassManager(?,?)}");
                        admin.setString(1, this.username);
                        admin.setString(2, MD5.encryptMD5(new String(this.txtpasswordcon.getPassword())));

                        int rowAffectted = admin.executeUpdate();
                        if (rowAffectted > 0) {
                            lb4.setText("successfully!");
                            Management.setPassword(MD5.encryptMD5(String.valueOf(txtpasswordcon.getPassword())));
                            timel();
                            thoigian.start();
                            this.setSize(400, 300);
                            new Thread(new DisplayClose(this, 0, 0)).start();
                        } else {
                            lb4.setText("Unsuccessfully!");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_butchangeMouseClicked

    private void butcancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(400, 300);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton butcancel;
    private javax.swing.JButton butchange;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JPasswordField txtpasswordcon;
    private javax.swing.JPasswordField txtpasswordnew;
    private javax.swing.JPasswordField txtpasswordold;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }
}
