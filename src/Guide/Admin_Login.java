package Guide;

import Connections.Connect;
import Connections.SplashConnect;
import Encryption.encryptionMD5;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Admin_Login extends javax.swing.JFrame {

    //time
    Timer time;
    Integer second;

    public Admin_Login() {
        setUndecorated(true);
        initComponents();
        this.setSize(0, 0);
        new Thread(new DisplayClose(this, 400, 315)).start();
        Image icon = getToolkit().getImage(getClass().getResource("/images/icon1.png"));
        setIconImage(icon);
    }

    boolean check() {
        if (txtusername.getText().equals("")) {
            lbusername.setText("Username is not empty.");
            return false;
        } else {
            lbusername.setText("");
        }
        if (String.valueOf(txtpassword.getPassword()).equals("")) {
            lbpassword.setText("Password is not empty.");
            return false;
        } else {
            lbpassword.setText("");
        }
        return true;
    }

    /// time 
    public void timel() {

        second = 3;

        time = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                second = second - 1;
                if (second == 0) {
                    dispose();
                }
            }
        });
    }
    //time exit 

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        butlogin = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbusername = new javax.swing.JLabel();
        lbpassword = new javax.swing.JLabel();
        lbaccount = new javax.swing.JLabel();
        radiomanager = new javax.swing.JRadioButton();
        radioadministrator = new javax.swing.JRadioButton();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        butlogin.setToolTipText("Login");
        butlogin.setBorderPainted(false);
        butlogin.setContentAreaFilled(false);
        butlogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butlogin.setDefaultCapable(false);
        butlogin.setFocusPainted(false);
        butlogin.setFocusable(false);
        butlogin.setRequestFocusEnabled(false);
        butlogin.setRolloverEnabled(false);
        butlogin.setVerifyInputWhenFocusTarget(false);
        butlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butloginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butloginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butloginMouseExited(evt);
            }
        });
        getContentPane().add(butlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 156, 40));

        txtusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtusername.setForeground(new java.awt.Color(0, 0, 204));
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusernameKeyPressed(evt);
            }
        });
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 226, -1));

        txtpassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(0, 0, 204));
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 226, -1));

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        cancel.setToolTipText("Cancel");
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
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 156, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Username :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Password :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lbusername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbusername.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lbusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 226, 20));

        lbpassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbpassword.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lbpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 226, 20));

        lbaccount.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbaccount.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lbaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 250, 20));

        radiomanager.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(radiomanager);
        radiomanager.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radiomanager.setSelected(true);
        radiomanager.setText("Manager");
        radiomanager.setToolTipText("");
        radiomanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radiomanager.setFocusable(false);
        getContentPane().add(radiomanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        radioadministrator.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(radioadministrator);
        radioadministrator.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        radioadministrator.setText("Administrator");
        radioadministrator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radioadministrator.setFocusable(false);
        getContentPane().add(radioadministrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

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
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 11, 18, 18));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bglogin.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //mouse move
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int positionx;
    private int positiony;
    Container frame = this;
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
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.x1 = evt.getXOnScreen();
        this.y1 = evt.getYOnScreen();
    }//GEN-LAST:event_formMousePressed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed

        checklogin();
    }//GEN-LAST:event_txtusernameActionPerformed
    public void checklogin() {
        if (check()) {
            if (radioadministrator.isSelected()) {
                encryptionMD5 MD5 = new encryptionMD5();
                String username = this.txtusername.getText();
                String password = MD5.encryptMD5(new String(this.txtpassword.getPassword()));
                try {
                    Connect.connectDatabase();
                    CallableStatement csta = Connect.connectDatabase().prepareCall("{call Login_Amin}");
                    ResultSet rs = csta.executeQuery();
                    boolean flag = false;

                    while (rs.next()) {
                        if ((rs.getString("Admin_Username").equals(username) && rs.getString("Admin_Password").equals(password))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    if (flag) {
                        Management a = new Management(txtusername.getText(), MD5.encryptMD5(new String(this.txtpassword.getPassword())), radioadministrator.getText());
                        a.setVisible(true);
                        this.dispose();
                        lbaccount.setText("");
                    } else {
                        lbaccount.setText("Username or password incorrect!");
                        Image icon = getToolkit().getImage(getClass().getResource("/images/icon1.png"));
                        setIconImage(icon);
                    }
                } catch (Exception e) {
                    System.out.println("Can not connect to database!");
                    e.printStackTrace();
                }
            } else if (radiomanager.isSelected()) {
                encryptionMD5 MD5 = new encryptionMD5();
                String username = this.txtusername.getText();
                String password = MD5.encryptMD5(new String(this.txtpassword.getPassword()));
                try {
                    Connect.connectDatabase();
                    CallableStatement csta = Connect.connectDatabase().prepareCall("{call Login_Manager}");
                    ResultSet rs = csta.executeQuery();
                    boolean flag = false;
                    while (rs.next()) {
                        String status = rs.getString("Managers_Status");
                        if ((rs.getString("Managers_Username").equals(username) && rs.getString("Managers_Password").equals(password))) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                        if (!status.equals("Activated")) {
                            dispose();
                            new Block_Managers(this, true, this.txtusername.getText()).setVisible(true);
                            break;
                        }
                        
                    }
                    if (flag) {
                        Management a = new Management(txtusername.getText(), MD5.encryptMD5(new String(this.txtpassword.getPassword())), radiomanager.getText());
                        a.setVisible(true);
                        this.dispose();
                        lbaccount.setText("");
                    } else {
                        lbaccount.setText("Username or password incorrect!");
                        Image icon = getToolkit().getImage(getClass().getResource("/images/icon1.png"));
                        setIconImage(icon);
                    }
                } catch (Exception e) {
                    System.out.println("Can not connect to database!");
                    e.printStackTrace();
                }
            }
        }
    }
    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        checklogin();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        timelexit();
        time.start();
        this.setSize(400, 315);
        new Thread(new DisplayClose(this, 0, 0)).start();
    }//GEN-LAST:event_formWindowClosing

    private void butcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseEntered
        butclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseEntered

    private void butcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseExited
        butclose.setIcon(new ImageIcon("src/images/close1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseExited

    private void butloginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butloginMouseEntered

        butlogin.setIcon(new ImageIcon("src/images/login1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butloginMouseEntered

    private void butloginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butloginMouseExited

        butlogin.setIcon(new ImageIcon("src/images/login.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butloginMouseExited

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered

        cancel.setIcon(new ImageIcon("src/images/cancel1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited

        cancel.setIcon(new ImageIcon("src/images/cancel.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseExited

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked
        if (evt.getClickCount() == 1) {
            timelexit();
            time.start();
            this.setSize(400, 315);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseClicked

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        if (evt.getClickCount() == 1) {
            timelexit();
            time.start();
            this.setSize(400, 315);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void butloginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butloginMouseClicked
        if (evt.getClickCount() == 1) {
            if (check()) {
                if (radioadministrator.isSelected()) {
                    encryptionMD5 MD5 = new encryptionMD5();
                    String username = this.txtusername.getText();
                    String password = MD5.encryptMD5(new String(this.txtpassword.getPassword()));
                    try {
                        Connect.connectDatabase();
                        CallableStatement csta = Connect.connectDatabase().prepareCall("{call Login_Amin}");
                        ResultSet rs = csta.executeQuery();
                        boolean flag = false;

                        while (rs.next()) {
                            if ((rs.getString("Admin_Username").equals(username) && rs.getString("Admin_Password").equals(password))) {
                                flag = true;
                                break;
                            } else {
                                flag = false;
                            }
                        }
                        if (flag) {
                            Management a = new Management(txtusername.getText(), MD5.encryptMD5(new String(this.txtpassword.getPassword())), radioadministrator.getText());
                            a.setVisible(true);
                            timel();
                            time.start();
                            this.setSize(400, 315);
                            new Thread(new DisplayOpen(this, 0, 0)).start();
                            lbaccount.setText("");
                        } else {
                            lbaccount.setText("Username or password incorrect!");
                            Image icon = getToolkit().getImage(getClass().getResource("/images/icon1.png"));
                            setIconImage(icon);
                        }
                    } catch (Exception e) {
                        System.out.println("Can not connect to database!");
                        e.printStackTrace();
                    }
                } else if (radiomanager.isSelected()) {
                    encryptionMD5 MD5 = new encryptionMD5();
                    String username = this.txtusername.getText();

                    String password = MD5.encryptMD5(new String(this.txtpassword.getPassword()));
                    try {
                        Connect.connectDatabase();
                        CallableStatement csta = Connect.connectDatabase().prepareCall("{call Login_Manager}");
                        ResultSet rs = csta.executeQuery();
                        boolean flag = false;
                        while (rs.next()) {
                            String status = rs.getString("Managers_Status");
                            System.out.println("flag tuoc dang false");
                            if (status.equals("Blocked")) {
                                dispose();
                                flag = false;
                                new Block_Managers(this, true, this.txtusername.getText()).setVisible(true);
                                break;
                            }
                            System.out.println("flag sau check if 1"+flag);
                            if ((rs.getString("Managers_Username").equals(username) && rs.getString("Managers_Password").equals(password)&& status.equals("Activated"))) {
                                flag = true;
                                break;
                            } else {
                                flag = false;
                            }

                        }
                        
                        if (flag) {
                            Management a = new Management(txtusername.getText(), MD5.encryptMD5(new String(this.txtpassword.getPassword())), radiomanager.getText());
                            a.setVisible(true);
                            timel();
                            time.start();
                            this.setSize(400, 315);
                            new Thread(new DisplayOpen(this, 0, 0)).start();
                            lbaccount.setText("");
                        } else {
                            lbaccount.setText("Username or password incorrect!");
                            Image icon = getToolkit().getImage(getClass().getResource("/images/icon1.png"));
                            setIconImage(icon);
                        }
                    } catch (Exception e) {
                        System.out.println("Can not connect to database!");
                        e.printStackTrace();

                    }
                }
            }
        }
    }//GEN-LAST:event_butloginMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == 112) {
            try {
                Runtime.getRuntime().exec("hh.exe \"help Login.chm");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void txtusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyPressed

        if (evt.getKeyCode() == 112) {
            try {
                Runtime.getRuntime().exec("hh.exe \"help Login.chm");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameKeyPressed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed

        if (evt.getKeyCode() == 112) {
            try {
                Runtime.getRuntime().exec("hh.exe \"help Login.chm");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordKeyPressed

    public static void main(String args[]) {
        /*
         * Set the Windows look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                SplashConnect connect = new SplashConnect();
                connect.showSplash();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton butclose;
    private javax.swing.JButton butlogin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbaccount;
    private javax.swing.JLabel lbpassword;
    private javax.swing.JLabel lbusername;
    private javax.swing.JRadioButton radioadministrator;
    private javax.swing.JRadioButton radiomanager;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
