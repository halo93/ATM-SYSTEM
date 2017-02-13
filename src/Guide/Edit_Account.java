package Guide;

import Connections.Connect;
import Encryption.encryptionMD5;
import efiect.DisplayClose;
import efiect.DisplayOpen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Edit_Account extends javax.swing.JDialog {

    Date a = new Date();
    // paramnerter manager ID
    static String account;
    static String ManagerID;
    static String AccountT;
    DefaultComboBoxModel standardModel = new DefaultComboBoxModel();

    public Edit_Account(java.awt.Frame parent, boolean modal, String account, String managerID, String AccountT) {
        super(parent, modal);

        setUndecorated(true);
        initComponents();
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 730, 623)).start();
        this.ManagerID = managerID;
        this.account = account;
        this.AccountT = AccountT;

        try {
            Connect.connectDatabase();
            CallableStatement call = Connect.connectDatabase().prepareCall("{call AccountShow(?)}");
            call.setString(1, account);
            ResultSet res = call.executeQuery();
            while (res.next()) {
                txtcard.setText(account);
                txtfullname.setText(res.getString("Fullname"));
                String gen = res.getString("Gender");
                if (gen.equals("Male")) {
                    this.Male.setSelected(true);
                } else if (gen.equals("Female")) {
                    this.Female.setSelected(true);
                }
                String date_s = res.getString("Birthday");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = dt.parse(date_s);
                txtbirthday.setDate(date);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                final Date startDate = new Date(0);//01.01.1970
                format.set2DigitYearStart(startDate);
                txtbirthday.setFormats(format);
                txtresident.setText(res.getString("ResidentIdentifyNo"));
                txtphone.setText(res.getString("PhoneNo"));
               
                txtaddress.setText(res.getString("Address"));

                String date_ = res.getString("CreationDate");
                SimpleDateFormat de = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date dte = de.parse(date_);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                txtdatecreate.setText(dt1.format(dte));
                
                txtbank.setText(res.getString("BankName"));
                this.txtBalance.setText(res.getString("AccountBalance"));
                this.comstatus.setModel(standardModel);
                if (res.getString("Account_Status").equals("Activated")) {
                    this.standardModel.addElement("Activated");
                    this.comstatus.addItem("Blocked");
                } else if (res.getString("Account_Status").equals("Blocked")) {
                    this.standardModel.addElement("Blocked");
                    this.comstatus.addItem("Activated");
                }
                txtnote.setText(res.getString("Note"));
                this.txtidmanager.setText(managerID);
            }
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
            lbwarning.setText("Birthday is not empty.");
            return false;
        } else {
            lbwarning.setText("");
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
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
        butadd = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        lbwarning = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcard = new javax.swing.JTextField();
        txtdatecreate = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        comstatus = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        txtidmanager = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtbank = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bg1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        combank = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtnote = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        butclose = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Full name :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Gender :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Birthday :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Resident Identify :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Phone number :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Address :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 220, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("INFORMANTION USER :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtfullname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtfullname.setForeground(new java.awt.Color(0, 0, 204));
        txtfullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfullnameKeyPressed(evt);
            }
        });
        getContentPane().add(txtfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 180, -1));

        Male.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(Male);
        Male.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Male.setForeground(new java.awt.Color(204, 102, 0));
        Male.setText("Male");
        getContentPane().add(Male, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        Female.setBackground(new java.awt.Color(78, 90, 93));
        buttonGroup1.add(Female);
        Female.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Female.setForeground(new java.awt.Color(204, 102, 0));
        Female.setText("Female");
        getContentPane().add(Female, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));
        getContentPane().add(txtbirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, -1));

        txtresident.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtresident.setForeground(new java.awt.Color(0, 0, 204));
        txtresident.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtresidentKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtresidentKeyTyped(evt);
            }
        });
        getContentPane().add(txtresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 180, -1));

        txtphone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtphone.setForeground(new java.awt.Color(0, 0, 204));
        txtphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphoneKeyTyped(evt);
            }
        });
        getContentPane().add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 180, -1));

        txtaddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtaddress.setForeground(new java.awt.Color(0, 0, 204));
        txtaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaddressKeyPressed(evt);
            }
        });
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 180, 20));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 180, 20));

        lb2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 240, 20));

        lb3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 180, 20));

        lb5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 180, 20));

        butadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
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
        getContentPane().add(butadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 155, 40));

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        cancel.setToolTipText("");
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
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, 155, 40));

        lbwarning.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbwarning.setForeground(new java.awt.Color(255, 51, 0));
        getContentPane().add(lbwarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 580, 23));

        jLabel16.setForeground(new java.awt.Color(255, 102, 0));
        jLabel16.setText("( dd/ MM / YYYY )");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, 20));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("INFORMATION ACCOUNT"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Account No :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Creation Date :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        txtcard.setEditable(false);
        txtcard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcard.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(txtcard, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 27, 190, 30));

        txtdatecreate.setEditable(false);
        txtdatecreate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtdatecreate.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(txtdatecreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 110, -1));

        jLabel18.setText("(dd / MM / YYYY )");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 188, -1, 20));

        comstatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comstatus.setForeground(new java.awt.Color(153, 0, 0));
        comstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acivated", "Blocked" }));
        jPanel1.add(comstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 140, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Status :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        txtidmanager.setEditable(false);
        txtidmanager.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtidmanager.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(txtidmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 120, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Manager ID :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jLabel25.setForeground(new java.awt.Color(204, 102, 0));
        jLabel25.setText("( dd / MM / YYYY )");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Bank Name :");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 74, -1, 20));

        txtbank.setEditable(false);
        txtbank.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtbank.setForeground(new java.awt.Color(0, 0, 255));
        jPanel1.add(txtbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 74, 190, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setText("Reset PIN code");
        jButton1.setToolTipText("Reset PIN code");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        bg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgedit.png"))); // NOI18N
        jPanel1.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 340, 320));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("CHANGE"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Bank Name :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 20));

        combank.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combank.setForeground(new java.awt.Color(0, 0, 204));
        combank.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----" }));
        jPanel2.add(combank, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 190, -1));

        txtnote.setColumns(20);
        txtnote.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtnote.setForeground(new java.awt.Color(0, 0, 204));
        txtnote.setRows(5);
        jScrollPane1.setViewportView(txtnote);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, 110));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Note :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Balance : ");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        txtBalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBalance.setForeground(new java.awt.Color(0, 0, 204));
        txtBalance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBalanceKeyPressed(evt);
            }
        });
        jPanel2.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 190, -1));

        jLabel20.setText("$");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 240, 20));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgedit.png"))); // NOI18N
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 320));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 340, 320));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("ACCOUNT :");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 20));

        butclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close1.png"))); // NOI18N
        butclose.setToolTipText("Close");
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
        getContentPane().add(butclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 12, 18, 18));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgeditaccount.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 623));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } else if (evt.getKeyCode() == 8) {
            txtphone.setEditable(true);
        } else {
            lb3.setText("enter only numeric digits(0-9)");
            txtphone.setEditable(false);
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
        } else if (evt.getKeyCode() == 8) {
            txtresident.setEditable(true);
        } else {
            lb2.setText("enter only numeric digits(0-9)");
            txtresident.setEditable(false);

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

        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        "4a7d1ed414474e4033ac29ccb8653d9b"
        encryptionMD5 MD5 = new encryptionMD5();
        try {
            Connect.connectDatabase();
            CallableStatement admin = Connect.connectDatabase().prepareCall("{call ResetPINAccount(?,?)}");
            admin.setString(1, account);
            // reset password default
            admin.setString(2, MD5.encryptMD5("0000"));
            int rowAffectted = admin.executeUpdate();
            if (rowAffectted > 0) {
                lbwarning.setText("Reset PIN successfully!");
            } else {
                lbwarning.setText("Unsuccessfully!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBalanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBalanceKeyPressed
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtBalance.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtBalance.setEditable(true);
        } else {
            txtBalance.setEditable(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceKeyPressed

    private void butaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseEntered

        butadd.setIcon(new ImageIcon("src/images/change1.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseEntered

    private void butaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseExited
        butadd.setIcon(new ImageIcon("src/images/change.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butaddMouseExited

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered

        cancel.setIcon(new ImageIcon("src/images/cancel1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited

        cancel.setIcon(new ImageIcon("src/images/cancel.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseExited

    private void butcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseEntered
        butclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseEntered

    private void butcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseExited
        butclose.setIcon(new ImageIcon("src/images/close1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseExited

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(730, 623);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }// TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void butcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcloseMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(730, 623);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }// TODO add your handling code here:
    }//GEN-LAST:event_butcloseMouseClicked

    private void butaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddMouseClicked

        if (evt.getClickCount() == 1) {
            if (check()) {
                try {
                    Connect.connectDatabase();
                    CallableStatement cs = Connect.connectDatabase().prepareCall("{call ChangeAccount(?,?,?,?,?,?,?,?,?,?,?)}");

                    cs.setString(1, this.txtcard.getText());
                    cs.setString(2, this.txtfullname.getText());
                    if (Male.isSelected()) {
                        cs.setString(3, this.Male.getText());
                    } else if (Female.isSelected()) {
                        cs.setString(3, this.Female.getText());
                    }
                    Date date = txtbirthday.getDate();
                    String expectedPattern = "yyyy-MM-dd hh:mm:ss.SSS";
                    String currentFormat = "dd-MM-yyyy hh:mm:ss.SSS";
                    SimpleDateFormat dateFormatReq = new SimpleDateFormat(expectedPattern);
                    SimpleDateFormat dateFormatCurr = new SimpleDateFormat(currentFormat);
                    String strDate = dateFormatReq.format(dateFormatCurr.parse(dateFormatCurr.format(date)));

                    cs.setString(4, strDate);
                    cs.setString(5, this.txtresident.getText());
                    cs.setString(6, this.txtphone.getText());
             
                    cs.setString(7, this.txtaddress.getText());

                    if (combank.getSelectedItem().toString().equals("-----")) {
                        cs.setString(8, txtbank.getText());
                    } else {
                        cs.setString(8, this.combank.getSelectedItem().toString());
                    }
                    cs.setString(9, txtBalance.getText());
                    cs.setString(10, comstatus.getSelectedItem().toString());
                    cs.setString(11, this.txtnote.getText().toString());
                    int ins = cs.executeUpdate();
                    if (ins > 0) {
                        lbwarning.setText("Successfully!");
                        timel();
                        thoigian.start();
                        this.setSize(730, 623);
                        new Thread(new DisplayClose(this, 0, 0)).start();
                    }
                } catch (Exception e) {
                    lbwarning.setText("Error ! Can not update !");
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
    private javax.swing.JButton butclose;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox combank;
    private javax.swing.JComboBox comstatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lbwarning;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbank;
    private org.jdesktop.swingx.JXDatePicker txtbirthday;
    private javax.swing.JTextField txtcard;
    private javax.swing.JTextField txtdatecreate;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtidmanager;
    private javax.swing.JTextArea txtnote;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtresident;
    // End of variables declaration//GEN-END:variables
}
