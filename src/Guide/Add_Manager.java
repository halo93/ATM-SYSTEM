package Guide;

import Connections.Connect;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.text.ParseException;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Add_Manager extends javax.swing.JDialog {

    public Add_Manager(java.awt.Frame parent, boolean modal) throws ParseException {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        Date a = new Date();
        String date1mont = (a.getYear() + 1900) + "-" + (a.getMonth() + 1) + "-" + a.getDate();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date daate = form.parse(date1mont);
        txtbirthday.setDate(daate);
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        final Date startDate = new Date(0);
        ft.set2DigitYearStart(startDate);
        txtbirthday.setFormats(ft);
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 440, 480)).start();
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
        if (txtusername.getText().equals("")) {
            lb1.setText("Username is not empty.");
            return false;
        } else {
            lb1.setText("");
        }
        if (txtfulname.getText().equals("")) {
            lb2.setText("Full name is not empty.");
            return false;
        } else {
            lb2.setText("");
        }
        if (txtphone.getText().equals("")) {
            lb3.setText("Phone number is not empty.");
            return false;
        } else {
            lb3.setText("");
        }
        if (txtemail.getText().equals("")) {
            lb4.setText("Email is not empty");
            return false;
        } else {
            lb4.setText("");
        }
        if (txtaddress.getText().equals("")) {
            lb5.setText("Address is not empty");
            return false;
        } else {
            lb5.setText("");
        }
        if (txtbirthday.getDate() == null) {
            lbbirthday.setText("Address is not empty");
            return false;
        } else {
            lbbirthday.setText("");
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtemail = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtbirthday = new org.jdesktop.swingx.JXDatePicker();
        butadd = new javax.swing.JButton();
        butcancel = new javax.swing.JButton();
        lb1 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lberror = new javax.swing.JLabel();
        txtfulname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbbirthday = new javax.swing.JLabel();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtemailKeyPressed(evt);
            }
        });
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 210, -1));

        txtaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaddressKeyPressed(evt);
            }
        });
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 210, -1));

        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusernameKeyPressed(evt);
            }
        });
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 210, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Username :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Gender :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 30));

        Male.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(Male);
        Male.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Male.setForeground(new java.awt.Color(204, 102, 0));
        Male.setSelected(true);
        Male.setText("Male");
        Male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(Male, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 165, -1, -1));

        Female.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(Female);
        Female.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Female.setForeground(new java.awt.Color(204, 102, 0));
        Female.setText("Female");
        Female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(Female, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 165, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Email :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Phone :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Address :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 20));

        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphoneKeyTyped(evt);
            }
        });
        getContentPane().add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Birthday :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, 20));

        txtbirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbirthdayActionPerformed(evt);
            }
        });
        getContentPane().add(txtbirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 160, -1));

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butaddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butaddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butaddMouseExited(evt);
            }
        });
        getContentPane().add(butadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 155, 40));

        butcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        butcancel.setToolTipText("");
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
        getContentPane().add(butcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 155, 40));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 210, 20));

        lb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 210, 20));

        lb4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 310, 20));

        lb5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 210, 20));

        lberror.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lberror.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lberror, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 310, 30));

        txtfulname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfulnameKeyPressed(evt);
            }
        });
        getContentPane().add(txtfulname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 210, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Full Name :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        lb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 210, 20));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 170, 10));

        jLabel8.setForeground(new java.awt.Color(204, 102, 0));
        jLabel8.setText("(  dd / MM / YYYY )");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, 20));

        lbbirthday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbirthday.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lbbirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 210, 20));

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
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 12, 18, 18));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgaddnewmanager.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbirthdayActionPerformed

    private void txtusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyPressed

        String aa = this.txtusername.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
            lb1.setText("More than five character");
            butadd.setEnabled(false);
        } else {
            lb1.setText("");
            butadd.setEnabled(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameKeyPressed

    private void txtfulnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfulnameKeyPressed

        String aa = this.txtfulname.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
            lb2.setText("More than five character");
            butadd.setEnabled(false);
        } else {
            lb2.setText("");
            butadd.setEnabled(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtfulnameKeyPressed

    private void txtphoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyPressed

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            lb3.setText("");
            txtphone.setEditable(true);
            butadd.setEnabled(true);
        } else if (evt.getKeyCode() == 8) {
            txtphone.setEditable(true);
        } else {
            lb3.setText("enter only numeric digits(0-9)");
            txtphone.setEditable(false);
            butadd.setEnabled(false);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneKeyPressed

    private void txtemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyPressed

        String aa = this.txtemail.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
//            lb4.setText("More than five character");
            butadd.setEnabled(false);
        } else {
            butadd.setEnabled(true);
            lb4.setText("");

        }
//
        String email1 = aa;
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Boolean b = email1.matches(EMAIL_REGEX);

        if (b == false) {
            lb4.setText(aa + " is invalid");
            butadd.setEnabled(false);
        } else {
            lb4.setText("");
            butadd.setEnabled(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailKeyPressed

    private void txtaddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaddressKeyPressed

        String aa = this.txtaddress.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
            lb5.setText("More than five character");
            butadd.setEnabled(false);
        } else {
            butadd.setEnabled(true);
            lb5.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressKeyPressed

    private void txtphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyTyped
        if (evt.getSource().equals(txtphone)) {
            if (txtphone.getText().length() > 16) {
                evt.setKeyChar('\n');
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneKeyTyped

    private void butcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseEntered

        butclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseEntered

    private void butcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseExited
        butclose.setIcon(new ImageIcon("src/images/close1.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseExited

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked

        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(440, 480);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseClicked

    private void butaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseEntered
        butadd.setIcon(new ImageIcon("src/images/butadd1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseEntered

    private void butaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseExited
        butadd.setIcon(new ImageIcon("src/images/butadd.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseExited

    private void butaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseClicked
        if (evt.getClickCount() == 1) {
            if (check()) {
                try {
                    Connect.connectDatabase();
                    CallableStatement cs = Connect.connectDatabase().prepareCall("{call InsertManager(?,?,?,?,?,?,?,?,?,?,?)}");
                    cs.setString(1, "");
                    cs.setString(2, this.txtusername.getText());
                    cs.setString(3, "e10adc3949ba59abbe56e057f20f883e");
                    cs.setString(4, this.txtfulname.getText());

                    Date date = txtbirthday.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    cs.setString(5, strDate);

                    if (Male.isSelected()) {
                        cs.setString(6, this.Male.getText());
                    } else if (Female.isSelected()) {
                        cs.setString(6, this.Female.getText());
                    }
                    cs.setString(7, this.txtphone.getText());
                    cs.setString(8, this.txtaddress.getText());
                    cs.setString(9, this.txtemail.getText());
                    cs.setString(10, "Activated");
                    cs.setString(11, "admin");
                    int inser = cs.executeUpdate();
                    if (inser > 0) {
                        lberror.setText("Insert successfully!");
                        timel();
                        thoigian.start();
                        this.setSize(440, 480);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    lberror.setText(txtusername.getText() + " already in the database!");
                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseClicked

    private void butcancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseEntered
        butcancel.setIcon(new ImageIcon("src/images/cancel1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseEntered

    private void butcancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseExited
        butcancel.setIcon(new ImageIcon("src/images/cancel.png"));
    }//GEN-LAST:event_butcancelMouseExited

    private void butcancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(440, 480);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
    }//GEN-LAST:event_butcancelMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JLabel bg;
    private javax.swing.JButton butadd;
    private javax.swing.JButton butcancel;
    private javax.swing.JButton butclose;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lbbirthday;
    private javax.swing.JLabel lberror;
    private javax.swing.JTextField txtaddress;
    private org.jdesktop.swingx.JXDatePicker txtbirthday;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfulname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
