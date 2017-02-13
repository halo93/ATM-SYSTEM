package Guide;

import Connections.Connect;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ChangeProfile extends javax.swing.JDialog {

    /**
     * @return the profileFullname
     */
    public static String getProfileFullname() {
        return profileFullname;
    }

    /**
     * @param aProfileFullname the profileFullname to set
     */
    public static void setProfileFullname(String aProfileFullname) {
        profileFullname = aProfileFullname;
    }

    /**
     * @return the profileGender
     */
    public static String getProfileGender() {
        return profileGender;
    }

    /**
     * @param aProfileGender the profileGender to set
     */
    public static void setProfileGender(String aProfileGender) {
        profileGender = aProfileGender;
    }

    /**
     * @return the profileBirthday
     */
    public static String getProfileBirthday() {
        return profileBirthday;
    }

    /**
     * @param aProfileBirthday the profileBirthday to set
     */
    public static void setProfileBirthday(String aProfileBirthday) {
        profileBirthday = aProfileBirthday;
    }

    /**
     * @return the profilePhone
     */
    public static String getProfilePhone() {
        return profilePhone;
    }

    /**
     * @param aProfilePhone the profilePhone to set
     */
    public static void setProfilePhone(String aProfilePhone) {
        profilePhone = aProfilePhone;
    }

    /**
     * @return the profileEmail
     */
    public static String getProfileEmail() {
        return profileEmail;
    }

    /**
     * @param aProfileEmail the profileEmail to set
     */
    public static void setProfileEmail(String aProfileEmail) {
        profileEmail = aProfileEmail;
    }

    /**
     * @return the profileAddress
     */
    public static String getProfileAddress() {
        return profileAddress;
    }

    /**
     * @param aProfileAddress the profileAddress to set
     */
    public static void setProfileAddress(String aProfileAddress) {
        profileAddress = aProfileAddress;
    }
    private String username = Management.username; // get username
    private String position = Management.position;
    private static String profileFullname;
    private static String profileGender;
    private static String profileBirthday;
    private static String profilePhone;
    private static String profileEmail;
    private static String profileAddress;

    public ChangeProfile(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        setContentPane(new JLabel(new ImageIcon("src/images/loginbg.png")));
        initComponents();

        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 430, 400)).start();
        if (position.equals("Administrator")) {
            try {
                Connect.connectDatabase();
                CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowAdmin(?)}");

                call.setString(1, username);

                ResultSet rs = call.executeQuery();

                while (rs.next()) {
                    this.txtfullname.setText(rs.getString("Admin_FullName"));
                    String gen = rs.getString("Admin_Gender");
                    if (gen.equals("Male")) {
                        this.male.setSelected(true);
                    } else if (gen.equals("Female")) {
                        this.female.setSelected(true);
                    }

                    String date_s = rs.getString("Admin_Birthday");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    jxdate.setDate(date);
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    final Date startDate = new Date(0);//01.01.1970
                    format.set2DigitYearStart(startDate);
                    jxdate.setFormats(format);


                    this.txtemail.setText(rs.getString("Admin_Email"));
                    this.txtphone.setText(rs.getString("Admin_Phone"));
                    this.txtaddress.setText(rs.getString("Admin_Address"));

                }
            } catch (Exception e) {
                System.out.println("Can not connect database!");
                e.printStackTrace();
            }
        } else if (position.equals("Manager")) {
            try {
                Connect.connectDatabase();
                CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowManager(?)}");

                call.setString(1, username);

                ResultSet rs = call.executeQuery();

                while (rs.next()) {
                    this.txtfullname.setText(rs.getString("Managers_FullName"));
                    String gen = rs.getString("Managers_Gender");
                    if (gen.equals("Male")) {
                        this.male.setSelected(true);
                    } else if (gen.equals("Female")) {
                        this.female.setSelected(true);
                    }

                    String date_s = rs.getString("Managers_Birthday");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    jxdate.setDate(date);
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    final Date startDate = new Date(0);//01.01.1970
                    format.set2DigitYearStart(startDate);
                    jxdate.setFormats(format);


                    this.txtemail.setText(rs.getString("Managers_Email"));
                    this.txtphone.setText(rs.getString("Managers_Phone"));
                    this.txtaddress.setText(rs.getString("Managers_Address"));

                }
            } catch (Exception e) {
                System.out.println("Can not connect database!");
                e.printStackTrace();
            }
        }


    }

    boolean check() {

        if (txtfullname.getText().equals("")) {
            lb1.setText("Full name is not empty.");
            return false;
        } else {
            lb1.setText("");
        }
        if (txtphone.getText().equals("")) {
            lb2.setText("Phone number is not empty.");
            return false;
        } else {
            lb2.setText("");
        }
        if (txtaddress.getText().equals("")) {
            lb4.setText("Address is not empty.");
            return false;
        } else {
            lb4.setText("");
        }
        if (jxdate.getDate() == null) {
            lbbirthday.setText("Birthday is not empty.");
            return false;
        } else {
            lbbirthday.setText("");
        }
        return true;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtfullname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        lbmessage = new javax.swing.JLabel();
        jxdate = new org.jdesktop.swingx.JXDatePicker();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        butchange = new javax.swing.JButton();
        butcancel = new javax.swing.JButton();
        lbbirthday = new javax.swing.JLabel();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtfullname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfullname.setForeground(new java.awt.Color(0, 0, 255));
        txtfullname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });
        txtfullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfullnameKeyPressed(evt);
            }
        });
        getContentPane().add(txtfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 278, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Full name :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gender :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Birthday :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 70, -1));

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(0, 0, 255));
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtemailKeyPressed(evt);
            }
        });
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 278, 21));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Email :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Address :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtaddress.setForeground(new java.awt.Color(0, 0, 255));
        txtaddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });
        txtaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaddressKeyPressed(evt);
            }
        });
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 278, -1));

        male.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        male.setForeground(new java.awt.Color(204, 102, 0));
        male.setText("Male");
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        female.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        female.setForeground(new java.awt.Color(204, 102, 0));
        female.setText("Female");
        getContentPane().add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Phone :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtphone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtphone.setForeground(new java.awt.Color(0, 0, 255));
        txtphone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });
        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphoneKeyTyped(evt);
            }
        });
        getContentPane().add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 278, 20));

        lbmessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbmessage.setForeground(new java.awt.Color(255, 0, 0));
        lbmessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbmessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 221, 20));

        jxdate.setForeground(new java.awt.Color(0, 153, 0));
        getContentPane().add(jxdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 167, -1));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb1.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 280, 20));

        lb2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb2.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 278, 20));

        lb3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lb3.setForeground(new java.awt.Color(153, 0, 0));
        lb3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 370, 19));

        lb4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb4.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 270, 20));

        jLabel8.setForeground(new java.awt.Color(255, 204, 51));
        jLabel8.setText("(dd / MM / YYYY)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, 20));

        butchange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        butchange.setToolTipText("Change");
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
        getContentPane().add(butchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 155, 42));

        butcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        butcancel.setToolTipText("Cancel");
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
        getContentPane().add(butcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 154, 41));

        lbbirthday.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbbirthday.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lbbirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 280, 20));

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
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 7, 18, 19));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgchangepro.png"))); // NOI18N
        bg.setToolTipText("");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed


        if (check()) {
            if (position.equals("Administrator")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileAdmin(?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);

                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());

                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");
                        Management.profileFullname = this.txtfullname.getText();
                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }
                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                    // TODO add your handling code here:
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);

                }
            } else if (position.equals("Manager")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileManager(?,?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);
                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());
                    call.setString(8, "Activated");
                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");


                        Management.profileFullname = this.txtfullname.getText();

                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }


                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed

        if (check()) {
            if (position.equals("Administrator")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileAdmin(?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);

                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());

                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");
                        Management.profileFullname = this.txtfullname.getText();
                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }
                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                    // TODO add your handling code here:
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);

                }
            } else if (position.equals("Manager")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileManager(?,?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);
                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());
                    call.setString(8, "Activated");
                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");


                        Management.profileFullname = this.txtfullname.getText();

                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }


                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }     // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed


        if (check()) {
            if (position.equals("Administrator")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileAdmin(?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);

                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());

                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");
                        Management.profileFullname = this.txtfullname.getText();
                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }
                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                    // TODO add your handling code here:
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);

                }
            } else if (position.equals("Manager")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileManager(?,?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);
                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());
                    call.setString(8, "Activated");
                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");


                        Management.profileFullname = this.txtfullname.getText();

                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }


                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed



        if (check()) {
            if (position.equals("Administrator")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileAdmin(?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);

                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());

                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");
                        Management.profileFullname = this.txtfullname.getText();
                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }
                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                    // TODO add your handling code here:
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);

                }
            } else if (position.equals("Manager")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileManager(?,?,?,?,?,?,?,?)}");
                    call.setString(1, this.username);
                    call.setString(2, this.txtfullname.getText().toString());
                    if (male.isSelected()) {
                        call.setString(3, this.male.getText().toString());
                    } else if (female.isSelected()) {
                        call.setString(3, this.female.getText().toString());
                    }
                    Date date = jxdate.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                    call.setString(4, strDate);
                    call.setString(5, this.txtemail.getText().toString());
                    call.setString(6, this.txtphone.getText().toString());
                    call.setString(7, this.txtaddress.getText().toString());
                    call.setString(8, "Activated");
                    int rowAffectted = call.executeUpdate();
                    if (rowAffectted > 0) {
                        lbmessage.setText("Change Successfully!");


                        Management.profileFullname = this.txtfullname.getText();

                        if (male.isSelected()) {
                            Management.profileGender = this.male.getText().toString();
                        } else if (female.isSelected()) {
                            Management.profileGender = this.female.getText().toString();
                        }


                        Date dates = jxdate.getDate();
                        String expectedPatterns = "dd/MM/YYYY";
                        String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                        SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                        String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                        Management.profileBirthday = strDates;
                        Management.profilePhone = txtphone.getText();
                        Management.profileEmail = txtemail.getText();
                        Management.profileAddress = txtaddress.getText();


                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    } else {
                        lbmessage.setText("Change Unsuccessfully!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtfullnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfullnameKeyPressed


        String aa = this.txtfullname.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
            lb1.setText("More than five character");
            butchange.setEnabled(false);
        } else {
            lb1.setText("");
            butchange.setEnabled(true);
        }


    }//GEN-LAST:event_txtfullnameKeyPressed

    private void txtphoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyPressed


        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            lb2.setText("");
            txtphone.setEditable(true);
            butchange.setEnabled(true);
        } else if (evt.getKeyCode() == 8) {
            txtphone.setEditable(true);
        } else {
            lb2.setText("enter only numeric digits(0-9)");
            txtphone.setEditable(false);
            butchange.setEnabled(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneKeyPressed

    private void txtemailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyPressed

        String aa = this.txtemail.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
//            lb4.setText("More than five character");
            butchange.setEnabled(false);
        } else {
            butchange.setEnabled(true);
            lb3.setText("");
        }

        String email1 = aa;
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Boolean b = email1.matches(EMAIL_REGEX);

        if (b == false) {
            lb3.setText("<html><font color = '#1FBED6'>" + aa + "</font>is invalid</html>");
            butchange.setEnabled(false);
        } else {
            lb3.setText("");
            butchange.setEnabled(true);
        }
    }//GEN-LAST:event_txtemailKeyPressed

    private void txtaddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaddressKeyPressed
        String aa = this.txtaddress.getText();
        if (aa.length() < 5 || (evt.getKeyCode() == 8 && aa.length() < 6)) {
            lb4.setText("More than five character");
            butchange.setEnabled(false);
        } else {
            butchange.setEnabled(true);
            lb4.setText("");
        }
    }//GEN-LAST:event_txtaddressKeyPressed

    private void txtphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphoneKeyTyped

        if (evt.getSource().equals(txtphone)) {
            if (txtphone.getText().length() > 16) {
                evt.setKeyChar('\n');
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneKeyTyped

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

    private void butcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseEntered
        butclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseEntered

    private void butcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseExited
        butclose.setIcon(new ImageIcon("src/images/close1.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseExited

    private void butchangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butchangeMouseClicked

        if (evt.getClickCount() == 1) {
            if (check()) {
                if (position.equals("Administrator")) {
                    try {
                        Connect.connectDatabase();
                        CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileAdmin(?,?,?,?,?,?,?)}");
                        call.setString(1, this.username);
                        call.setString(2, this.txtfullname.getText().toString());
                        if (male.isSelected()) {
                            call.setString(3, this.male.getText().toString());
                        } else if (female.isSelected()) {
                            call.setString(3, this.female.getText().toString());
                        }
                        Date date = jxdate.getDate();
                        String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                        String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                        SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                        String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                        call.setString(4, strDate);

                        call.setString(5, this.txtemail.getText().toString());
                        call.setString(6, this.txtphone.getText().toString());
                        call.setString(7, this.txtaddress.getText().toString());

                        int rowAffectted = call.executeUpdate();
                        if (rowAffectted > 0) {
                            lbmessage.setText("Change Successfully!");
                            Management.profileFullname = this.txtfullname.getText();
                            if (male.isSelected()) {
                                Management.profileGender = this.male.getText().toString();
                            } else if (female.isSelected()) {
                                Management.profileGender = this.female.getText().toString();
                            }
                            Date dates = jxdate.getDate();
                            String expectedPatterns = "dd/MM/YYYY";
                            String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                            SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                            SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                            String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                            Management.profileBirthday = strDates;
                            Management.profilePhone = txtphone.getText();
                            Management.profileEmail = txtemail.getText();
                            Management.profileAddress = txtaddress.getText();


                            timel();
                            thoigian.start();
                            this.setSize(430, 400);
                            new Thread(new DisplayClose(this, 0, 0)).start();
                        } else {
                            lbmessage.setText("Change Unsuccessfully!");
                        }
                        // TODO add your handling code here:
                    } catch (Exception ex) {
                        Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);

                    }
                } else if (position.equals("Manager")) {
                    try {
                        Connect.connectDatabase();
                        CallableStatement call = Connect.connectDatabase().prepareCall("{call ChangeProfileManager(?,?,?,?,?,?,?,?)}");
                        call.setString(1, this.username);
                        call.setString(2, this.txtfullname.getText().toString());
                        if (male.isSelected()) {
                            call.setString(3, this.male.getText().toString());
                        } else if (female.isSelected()) {
                            call.setString(3, this.female.getText().toString());
                        }
                        Date date = jxdate.getDate();
                        String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                        String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                        SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                        SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                        String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));
                        call.setString(4, strDate);
                        call.setString(5, this.txtemail.getText().toString());
                        call.setString(6, this.txtphone.getText().toString());
                        call.setString(7, this.txtaddress.getText().toString());
                        call.setString(8, "Activated");
                        int rowAffectted = call.executeUpdate();
                        if (rowAffectted > 0) {
                            lbmessage.setText("Change Successfully!");


                            Management.profileFullname = this.txtfullname.getText();

                            if (male.isSelected()) {
                                Management.profileGender = this.male.getText().toString();
                            } else if (female.isSelected()) {
                                Management.profileGender = this.female.getText().toString();
                            }


                            Date dates = jxdate.getDate();
                            String expectedPatterns = "dd/MM/YYYY";
                            String currentFormats = "dd-MM-yyyy hh:mm:ss.SSS";
                            SimpleDateFormat dateFormatReqs = new SimpleDateFormat(expectedPatterns);
                            SimpleDateFormat dateFormatCurrs = new SimpleDateFormat(currentFormats);
                            String strDates = dateFormatReqs.format(dateFormatCurrs.parse(dateFormatCurrs.format(dates)));
                            Management.profileBirthday = strDates;
                            Management.profilePhone = txtphone.getText();
                            Management.profileEmail = txtemail.getText();
                            Management.profileAddress = txtaddress.getText();


                            timel();
                            thoigian.start();
                            this.setSize(430, 400);
                            new Thread(new DisplayClose(this, 0, 0)).start();
                        } else {
                            lbmessage.setText("Change Unsuccessfully!");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(ChangeProfile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butchangeMouseClicked

    private void butcancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcancelMouseClicked
        if (evt.getClickCount() == 1) {
            if (position.equals("Administrator")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowAdmin(?)}");

                    call.setString(1, username);

                    ResultSet rs = call.executeQuery();

                    while (rs.next()) {
                        Management.profileFullname = rs.getString("Admin_FullName");
                        String a = rs.getString("Admin_Gender");
                        if (a.equals("Male")) {
                            Management.profileGender = "Male";
                        } else if (a.equals("Female")) {
                            Management.profileGender = "Female";
                        }
                        String date_s = rs.getString("Admin_Birthday");
                        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date = dt.parse(date_s);
                        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                        Management.profileBirthday = dt1.format(date);
                        Management.profileEmail = rs.getString("Admin_Email");
                        Management.profilePhone = rs.getString("Admin_Phone");
                        Management.profileAddress = rs.getString("Admin_Address");
                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception e) {
                    System.out.println("Can not connect database!");
                    e.printStackTrace();
                }
            } else if (position.equals("Manager")) {

                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowManager(?)}");

                    call.setString(1, username);

                    ResultSet rs = call.executeQuery();

                    while (rs.next()) {
                        Management.profileFullname = rs.getString("Managers_FullName");
                        String a = rs.getString("Managers_Gender");
                        if (a.equals("Male")) {
                            Management.profileGender = "Male";
                        } else if (a.equals("Female")) {
                            Management.profileGender = "Female";
                        }
                        String date_s = rs.getString("Managers_Birthday");
                        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date = dt.parse(date_s);
                        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                        Management.profileBirthday = dt1.format(date);
                        Management.profileEmail = rs.getString("Managers_Email");
                        Management.profilePhone = rs.getString("Managers_Phone");
                        Management.profileAddress = rs.getString("Managers_Address");
                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception e) {
                    System.out.println("Can not connect database!");
                    e.printStackTrace();
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butcancelMouseClicked

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked

        if (evt.getClickCount() == 1) {
            if (position.equals("Administrator")) {
                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowAdmin(?)}");

                    call.setString(1, username);

                    ResultSet rs = call.executeQuery();

                    while (rs.next()) {
                        Management.profileFullname = rs.getString("Admin_FullName");
                        String a = rs.getString("Admin_Gender");
                        if (a.equals("Male")) {
                            Management.profileGender = "Male";
                        } else if (a.equals("Female")) {
                            Management.profileGender = "Female";
                        }
                        String date_s = rs.getString("Admin_Birthday");
                        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date = dt.parse(date_s);
                        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                        Management.profileBirthday = dt1.format(date);
                        Management.profileEmail = rs.getString("Admin_Email");
                        Management.profilePhone = rs.getString("Admin_Phone");
                        Management.profileAddress = rs.getString("Admin_Address");
                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception e) {
                    System.out.println("Can not connect database!");
                    e.printStackTrace();
                }
            } else if (position.equals("Manager")) {

                try {
                    Connect.connectDatabase();
                    CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowManager(?)}");

                    call.setString(1, username);

                    ResultSet rs = call.executeQuery();

                    while (rs.next()) {
                        Management.profileFullname = rs.getString("Managers_FullName");
                        String a = rs.getString("Managers_Gender");
                        if (a.equals("Male")) {
                            Management.profileGender = "Male";
                        } else if (a.equals("Female")) {
                            Management.profileGender = "Female";
                        }
                        String date_s = rs.getString("Managers_Birthday");
                        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date = dt.parse(date_s);
                        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                        Management.profileBirthday = dt1.format(date);
                        Management.profileEmail = rs.getString("Managers_Email");
                        Management.profilePhone = rs.getString("Managers_Phone");
                        Management.profileAddress = rs.getString("Managers_Address");
                        timel();
                        thoigian.start();
                        this.setSize(430, 400);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception e) {
                    System.out.println("Can not connect database!");
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_butcloseMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton butcancel;
    private javax.swing.JButton butchange;
    private javax.swing.JButton butclose;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private org.jdesktop.swingx.JXDatePicker jxdate;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lbbirthday;
    private javax.swing.JLabel lbmessage;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
