/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Guide;

import Connections.Connect;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jdesktop.swingx.auth.KeyChain;

/**
 *
 * @author DMX
 */
public class Add_Account extends javax.swing.JDialog {

    Date a = new Date();
    // paramnerter manager ID
    static String managerID;

    public Add_Account(java.awt.Frame parent, boolean modal, String managerID) {
        super(parent, modal);

        setUndecorated(true);
        initComponents();
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 720, 570)).start();

        //hide txtExpiration
        //get ID manager
        this.managerID = managerID;
        // get date from system
        try {
            String date1mont = (a.getYear() + 1900) + "-" + (a.getMonth() + 1) + "-" + a.getDate();
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
            Date daate = form.parse(date1mont);
            txtbirthday.setDate(daate);
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            final Date startDate = new Date(0);
            ft.set2DigitYearStart(startDate);
            txtbirthday.setFormats(ft);

           
            this.txtdatecreate.setText(a.getDate() + "/" + (a.getMonth() + 1) + "/" + (a.getYear() + 1900));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /// show all banks on combo box  
        try {
            Connect.connectDatabase();
            CallableStatement ca = Connect.connectDatabase().prepareCall("{call ShowBank}");
            ResultSet rs = ca.executeQuery();
            while (rs.next()) {
                this.combank.addItem(rs.getString("BankName"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   
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

        if (txtfullname.getText().equals("")) {
            lb1.setText("Full name is not empty.");
            return false;
        } else {
            lb1.setText("");
        }
        if (txtresident.getText().equals("")) {
            lb2.setText("Resident Identify is not empty.");
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
     
        if (txtaddress.getText().equals("")) {
            lb5.setText("Address is not empty");
            return false;
        } else {
            lb5.setText("");
        }
        if (txtbirthday.getDate() == null) {
            lbbirthday.setText("Birthday is not empty.");
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        butadd = new javax.swing.JButton();
        butcancel = new javax.swing.JButton();
        lbwarning = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfullname = new javax.swing.JTextField();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        txtbirthday = new org.jdesktop.swingx.JXDatePicker();
        txtresident = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbbirthday = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        combank = new javax.swing.JComboBox();
        txtcard = new javax.swing.JTextField();
        txtdatecreate = new javax.swing.JTextField();
        lberror = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 220, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel9.setText("INFORMANTION USER :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 260, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel10.setText("INFORMATION ACCOUNT :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        butadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/butadd.png"))); // NOI18N
        butadd.setToolTipText("");
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butaddMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butaddMouseClicked(evt);
            }
        });
        getContentPane().add(butadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 155, 40));

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
        getContentPane().add(butcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 155, 40));

        lbwarning.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbwarning.setForeground(new java.awt.Color(255, 51, 0));
        getContentPane().add(lbwarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 580, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Full name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Gender :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Birthday :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ID Card No :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Phone  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Address :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 20));

        txtfullname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtfullname.setForeground(new java.awt.Color(0, 0, 255));
        txtfullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfullnameKeyPressed(evt);
            }
        });
        jPanel1.add(txtfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 180, -1));

        Male.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(Male);
        Male.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Male.setForeground(new java.awt.Color(255, 153, 51));
        Male.setSelected(true);
        Male.setText("Male");
        jPanel1.add(Male, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        Female.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(Female);
        Female.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Female.setForeground(new java.awt.Color(255, 153, 51));
        Female.setText("Female");
        jPanel1.add(Female, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));
        jPanel1.add(txtbirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 120, -1));

        txtresident.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtresident.setForeground(new java.awt.Color(0, 0, 255));
        txtresident.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtresidentKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtresidentKeyTyped(evt);
            }
        });
        jPanel1.add(txtresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 180, -1));

        txtphone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtphone.setForeground(new java.awt.Color(0, 0, 255));
        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphoneKeyTyped(evt);
            }
        });
        jPanel1.add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 180, -1));

        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtaddress.setForeground(new java.awt.Color(0, 0, 255));
        txtaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaddressKeyPressed(evt);
            }
        });
        jPanel1.add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 180, -1));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 190, 20));

        lb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 230, 20));

        lb3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 210, 20));

        lb5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 200, 20));

        lb4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 260, 20));

        jLabel16.setForeground(new java.awt.Color(255, 102, 0));
        jLabel16.setText("( dd / MM / YYYY )");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, 20));

        lbbirthday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbirthday.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lbbirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 112, 190, 20));

        bg1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bg1.setForeground(new java.awt.Color(255, 51, 51));
        bg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgpaneladd1.png"))); // NOI18N
        jPanel1.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 310, 290));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Account No:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Creation Date :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Bank Name :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 20));

        combank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combank.setForeground(new java.awt.Color(0, 0, 255));
        jPanel2.add(combank, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, -1));

        txtcard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtcard.setForeground(new java.awt.Color(0, 0, 255));
        txtcard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtcardMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtcardMouseReleased(evt);
            }
        });
        txtcard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcardActionPerformed(evt);
            }
        });
        txtcard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcardKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcardKeyTyped(evt);
            }
        });
        jPanel2.add(txtcard, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 220, -1));

        txtdatecreate.setEditable(false);
        txtdatecreate.setForeground(new java.awt.Color(0, 0, 255));
        jPanel2.add(txtdatecreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 130, -1));

        lberror.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lberror.setForeground(new java.awt.Color(255, 51, 0));
        jPanel2.add(lberror, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 270, 20));

        jLabel17.setForeground(new java.awt.Color(255, 102, 0));
        jLabel17.setText("( dd / MM / YYYY )");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, 20));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgaddaccount1.png"))); // NOI18N
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 380));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 360, 380));

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
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 10, 18, 19));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgaddnewaccount.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcardMousePressed
        String aa = this.txtcard.getText();
        txtcard.setText(aa);
    }//GEN-LAST:event_txtcardMousePressed

    private void txtcardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcardMouseReleased
        String aa = this.txtcard.getText();
        txtcard.setText(aa);
    }//GEN-LAST:event_txtcardMouseReleased
    String key1;
    String key2;
    String key3;
    private void txtcardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcardActionPerformed
        if (check()) {
            try {
                Connect.connectDatabase();
                CallableStatement cs = Connect.connectDatabase().prepareCall("{call InsertAccount(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                //// account number
                String charac = this.txtcard.getText();
                if (charac.length() < 14) {
                    lberror.setText("you must enter the full 12-digit");
                } else {
                    lberror.setText("");
                    key1 = txtcard.getText().charAt(0) + "" + txtcard.getText().charAt(1) + "" + txtcard.getText().charAt(2) + "" + txtcard.getText().charAt(3);
                    key2 = txtcard.getText().charAt(5) + "" + txtcard.getText().charAt(6) + "" + txtcard.getText().charAt(7) + "" + txtcard.getText().charAt(8);
                    key3 = txtcard.getText().charAt(10) + "" + txtcard.getText().charAt(11) + "" + txtcard.getText().charAt(12) + "" + txtcard.getText().charAt(13);
                    String key = key1 + key2 + key3;
                    cs.setString(1, key);
                }
                // default PIN
                cs.setString(2, "4a7d1ed414474e4033ac29ccb8653d9b");
                cs.setString(3, txtfullname.getText());

                if (Male.isSelected()) {
                    cs.setString(4, this.Male.getText());
                } else if (Female.isSelected()) {
                    cs.setString(4, this.Female.getText());
                }
                Date date = txtbirthday.getDate();
                String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                cs.setString(5, strDate);


                cs.setString(6, this.txtresident.getText());

                cs.setString(7, this.txtphone.getText());

                cs.setString(8, this.txtaddress.getText());

                String datecreate = (a.getYear() + 1900) + "-" + (a.getMonth() + 1) + "-" + a.getDate();
                cs.setString(9, datecreate);

                
                
                cs.setString(10, this.combank.getSelectedItem().toString());
                cs.setString(11, "0");
                cs.setString(12, "Activated");
                cs.setString(13, this.managerID);
                
                int inser = cs.executeUpdate();
                if (inser > 0) {
                    lbwarning.setText("Insert successfully!");
                    timel();
                    thoigian.start();
                    this.setSize(720, 570);
                    new Thread(new DisplayClose(this, 0, 0)).start();
                }
            } catch (Exception e) {
                lbwarning.setText("Resident Identity or This account has already been registered");
//                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_txtcardActionPerformed

    private void txtcardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcardKeyPressed

        String aa = this.txtcard.getText();
        if (aa.length() == 4) {
            txtcard.setText(aa + "-");
        }
        if (aa.length() == 9) {
            txtcard.setText(aa + "-");
        }
//                 NUMERIC ENTER NUMBER
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtcard.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtcard.setText(aa);
            txtcard.setEditable(true);
        } else {
            txtcard.setEditable(false);
        }
    }//GEN-LAST:event_txtcardKeyPressed

    private void txtcardKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcardKeyTyped
        if (evt.getSource().equals(txtcard)) {
            if (txtcard.getText().length() > 13) {
                evt.setKeyChar('\n');
            }
        }
    }//GEN-LAST:event_txtcardKeyTyped

    private void txtfullnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfullnameKeyPressed

        String aa = this.txtfullname.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
            lb1.setText("More than five character");
            butadd.setEnabled(false);
        } else {
            butadd.setEnabled(true);
            lb1.setText("");
        }

    }//GEN-LAST:event_txtfullnameKeyPressed

    private void txtphoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyPressed

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            lb3.setText("");
            txtphone.setEditable(true);
//            butadd.setEnabled(true);
        } else if (evt.getKeyCode() == 8) {
            txtphone.setEditable(true);
        } else {
            lb3.setText("enter only numeric digits(0-9)");
            txtphone.setEditable(false);
//            butadd.setEnabled(false);
        }
    }//GEN-LAST:event_txtphoneKeyPressed

    private void txtresidentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtresidentKeyTyped
        if (evt.getSource().equals(txtresident)) {
            if (txtresident.getText().length() > 9) {
                evt.setKeyChar('\n');
            }
        }
    }//GEN-LAST:event_txtresidentKeyTyped

    private void txtphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyTyped

        if (evt.getSource().equals(txtphone)) {
            if (txtphone.getText().length() > 16) {
                evt.setKeyChar('\n');
            }
        }

    }//GEN-LAST:event_txtphoneKeyTyped

    private void txtresidentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtresidentKeyPressed

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            lb2.setText("");
            txtresident.setEditable(true);
//            butadd.setEnabled(true);
        } else if (evt.getKeyCode() == 8) {
            txtresident.setEditable(true);
        } else {
            lb2.setText("enter only numeric digits(0-9)");
            txtresident.setEditable(false);
//            butadd.setEnabled(false);
        }
    }//GEN-LAST:event_txtresidentKeyPressed

    private void txtaddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaddressKeyPressed

        String aa = this.txtaddress.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
            lb5.setText("More than five character");
            butadd.setEnabled(false);
        } else {
            butadd.setEnabled(true);
            lb5.setText("");
        }
    }//GEN-LAST:event_txtaddressKeyPressed

    private void butcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseEntered
        butclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseEntered

    private void butcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseExited

        butclose.setIcon(new ImageIcon("src/images/close1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseExited

    private void butaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseEntered

        butadd.setIcon(new ImageIcon("src/images/butadd1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseEntered

    private void butaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseExited
        butadd.setIcon(new ImageIcon("src/images/butadd.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseExited

    private void butcancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseEntered

        butcancel.setIcon(new ImageIcon("src/images/cancel1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseEntered

    private void butcancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseExited
        butcancel.setIcon(new ImageIcon("src/images/cancel.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseExited

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(720, 570);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseClicked

    private void butcancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(720, 570);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseClicked

    private void butaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseClicked

        if (evt.getClickCount() == 1) {
            if (check()) {
                try {
                    Connect.connectDatabase();
                    CallableStatement cs = Connect.connectDatabase().prepareCall("{call InsertAccount(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    //// account number
                    String charac = this.txtcard.getText();
                    if (charac.length() < 14) {
                        lberror.setText("you must enter the full 12-digit");
                    } else {
                        lberror.setText("");
                        key1 = txtcard.getText().charAt(0) + "" + txtcard.getText().charAt(1) + "" + txtcard.getText().charAt(2) + "" + txtcard.getText().charAt(3);
                        key2 = txtcard.getText().charAt(5) + "" + txtcard.getText().charAt(6) + "" + txtcard.getText().charAt(7) + "" + txtcard.getText().charAt(8);
                        key3 = txtcard.getText().charAt(10) + "" + txtcard.getText().charAt(11) + "" + txtcard.getText().charAt(12) + "" + txtcard.getText().charAt(13);
                        String key = key1 + key2 + key3;
                        cs.setString(1, key);
                    }
                    // default PIN
                    cs.setString(2, "4a7d1ed414474e4033ac29ccb8653d9b");
                    cs.setString(3, txtfullname.getText());

                    if (Male.isSelected()) {
                        cs.setString(4, this.Male.getText());
                    } else if (Female.isSelected()) {
                        cs.setString(4, this.Female.getText());
                    }

                   
                    Date date = txtbirthday.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    cs.setString(5, strDate);


                    cs.setString(6, this.txtresident.getText());

                    cs.setString(7, this.txtphone.getText());
                   
                    cs.setString(8, this.txtaddress.getText());

                    String datecreate = (a.getYear() + 1900) + "-" + (a.getMonth() + 1) + "-" + a.getDate();
                    cs.setString(9, datecreate);
                    cs.setString(10, this.combank.getSelectedItem().toString());
                    cs.setString(11, "0");
                    cs.setString(12, "Activated");
                    cs.setString(13, this.managerID);
                    
                    int inser = cs.executeUpdate();
                    if (inser > 0) {
                        lbwarning.setText("Insert successfully!");
                        timel();
                        thoigian.start();
                        this.setSize(720, 570);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception e) {
                    lbwarning.setText("Resident Identity or This account has already been registered");
                e.printStackTrace();
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JButton butadd;
    private javax.swing.JButton butcancel;
    private javax.swing.JButton butclose;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combank;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lbbirthday;
    private javax.swing.JLabel lberror;
    private javax.swing.JLabel lbwarning;
    private javax.swing.JTextField txtaddress;
    private org.jdesktop.swingx.JXDatePicker txtbirthday;
    private javax.swing.JTextField txtcard;
    private javax.swing.JTextField txtdatecreate;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtresident;
    // End of variables declaration//GEN-END:variables
}
