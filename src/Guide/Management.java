package Guide;

import Connections.Connect;
import TableSearch.Filterbank;
import TableSearch.MyTableFilter;
import TableSearch.MyTableRenderer;
import efiect.DisplayClose;
import efiect.DisplayOpen;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import static org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ;

public class Management extends javax.swing.JFrame {

    /**
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * @param aUsername the username to set
     */
    public static void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }
    // frame
    Container frame = this;
    ///parameter login
    static String username;
    static String password;
    static String position;
    static String gender;
    //paramerter from ChangeProfile
    static String profileFullname;
    static String profileGender;
    static String profileBirthday;
    static String profilePhone;
    static String profileEmail;
    static String profileAddress;
    //manager ID
    static String ManagerID;
    // model table manager
    DefaultTableModel model = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            // only read
            return false;
        }
    };
    // model table acccounts
    DefaultTableModel modelaccount = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            // only read
            return false;
        }
    };
    // model table report
    DefaultTableModel mod = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            // only read
            return false;
        }
    };
    //model bank
    DefaultTableModel modelbank = new DefaultTableModel() {
        
        @Override
        public boolean isCellEditable(int row, int column) {
            // only read
            return false;
        }
    };
    // parameter search
    MyTableFilter filterController = null;
    Filterbank filbank = null;
    //Transaction limit
    DefaultComboBoxModel valueModel = new DefaultComboBoxModel();
    String cr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    String stringcombo;
    
    public Management(String user, String pass, String position) throws IOException, Exception {
        setUndecorated(true);
        //image backround
        setContentPane(new JLabel(new ImageIcon("src/images/managerbg.jpg")));
        
        initComponents();

        //splash
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 1000, 600)).start();
        // icon
        Image icon = getToolkit().getImage(getClass().getResource("/images/icon1.png"));
        
        setIconImage(icon);
        /// parametter from longin
        this.username = user;
        this.password = pass;
        this.position = position;


        //hide buttion delete admin
        butdeletemanager.setEnabled(false);
        //hide buttion edit admin
        buteditmanager.setEnabled(false);
        //hide buttion edit account 
        deleaccount.setEnabled(false);
        // hide buttion delete account
        editaccount.setEnabled(false);
        // hide buttion 
        buteditbank.setEnabled(false);
        butdeletebank.setEnabled(false);


        // report

        this.ReportTable.setModel(mod);
        addCol();
        LoadingData();
        customizeTableReport();
        setCountreport();
        // data manager
        this.tablemanager.setModel(model);
        ComlumDataTableManager();
        RowDataTableManager();
        // data bank
        this.tablebank.setModel(modelbank);
        comlumbank();
        cellbank();
        
        setCountBank();
        customizeTableBanks();
        /// search at manager panel
        customizeTable();
        setCountLabel();

        //hide panel
        panelaManager.setVisible(false);
        panelaccount.setVisible(false);
        panelreport.setVisible(false);
        panelbank.setVisible(false);
        paneldeposit.setVisible(false);
        Panellimit.setVisible(false);
        
        
        if (position.equals("Administrator")) {
            try {
                butaccount.setVisible(false);
                panelreport.setVisible(false);
                butreport.setVisible(false);
                butbank.setVisible(true);
                butdeposit.setVisible(false);
                butlimit.setVisible(true);
                Panellimit.setVisible(false);
                // transaction limit
                this.combovalue.setModel(valueModel);
                radiotransactfee.setSelected(true);
                turnfee.setText("0");
                turnfee.setEnabled(false);
                AddItemforCombo();
                ShowRecentSetting();
                
                
                lbpositions.setText("ADMINSTRATOR");
                Connect.connectDatabase();
                CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowAdmin(?)}");
                call.setString(1, user);
                ResultSet rs = call.executeQuery();
                while (rs.next()) {
                    this.lbfullname.setText(rs.getString("Admin_FullName"));
                    this.lbgender.setText(rs.getString("Admin_Gender"));
                    this.gender = this.lbgender.getText();
                    String date_s = rs.getString("Admin_Birthday");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                    this.lbbirthday.setText(dt1.format(date));
                    this.lbemail.setText(rs.getString("Admin_Email"));
                    this.lbphone.setText(rs.getString("Admin_Phone"));
                    this.lbaddress.setText(rs.getString("Admin_Address"));
                }
            } catch (Exception e) {
                System.out.println("Can not connect database!");
                e.printStackTrace();
            }
        } else if (position.equals("Manager")) {
            try {
                tablemanager.setVisible(false);
                butlistmanager.setVisible(false);
                butaccount.setVisible(true);
                butbank.setVisible(false);
                panelbank.setVisible(false);
                butlimit.setVisible(false);
                Panellimit.setVisible(false);
                lbpositions.setText("MANAGER");
                Connect.connectDatabase();
                CallableStatement call = Connect.connectDatabase().prepareCall("{call ShowManager(?)}");
                call.setString(1, user);
                ResultSet rs = call.executeQuery();
                while (rs.next()) {
                    // get ID manager
                    this.ManagerID = rs.getString("Managers_ID");
                    this.lbfullname.setText(rs.getString("Managers_Fullname"));
                    this.gender = this.lbgender.getText();
                    
                    String date_s = rs.getString("Managers_Birthday");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                    this.lbbirthday.setText(dt1.format(date));
                    
                    this.lbgender.setText(rs.getString("Managers_Gender"));
                    this.lbphone.setText(rs.getString("Managers_Phone"));
                    this.lbemail.setText(rs.getString("Managers_Email"));
                    this.lbaddress.setText(rs.getString("Managers_Address"));
                }
            } catch (Exception e) {
                System.out.println("Cannot connect database!");
                e.printStackTrace();
            }
        }
        // date accounts
        this.tableaccount.setModel(modelaccount);
        ComlumDataTableAccount();
        RowDataTableAcccount();

        /// search at accounts panel
        customizeTableAccout();
        setCountAccount();
        
    }
    // transaction limit

    public void AddItemforCombo() {
        
        valueModel.addElement("per Day");
        valueModel.addElement("per Week");
        valueModel.addElement("per Month");
        valueModel.addElement("per Year");
    }
    
    public void Reset() {
        
        this.turnnum.setText("");
        this.valueModel.setSelectedItem("per Day");
        this.minmoney.setText("");
        this.maxmoney.setText("");
        if (radiotransactfee.isSelected() == true) {
            turnfee.setText("0");
            tranfee.setText("");
            tranfee.setEnabled(true);
            turnfee.setEnabled(false);
        } else {
            tranfee.setText("0");
            turnfee.setText("");
            tranfee.setEnabled(false);
            turnfee.setEnabled(true);
        }
    }
    
    public void RuleSet() {
        try {
            Connect.connectDatabase();
            CallableStatement cs = Connect.connectDatabase().prepareCall("{call InsertLimit_Setting(?,?,?,?,?,?,?,?,?)}");
            
            if (Float.parseFloat(minmoney.getText().toString()) <= Float.parseFloat(maxmoney.getText().toString())) {
                cs.setInt(1, Integer.parseInt(turnnum.getText().toString()));
                cs.setString(2, this.combovalue.getSelectedItem().toString());
                
                cs.setFloat(3, Float.parseFloat(minmoney.getText().toString()));
                cs.setFloat(4, Float.parseFloat(maxmoney.getText().toString()));
                
                cs.setFloat(5, Float.parseFloat(tranfee.getText().toString()));
                cs.setFloat(6, Float.parseFloat(turnfee.getText().toString()));
                
                if (valueModel.getSelectedItem().toString() != "per Week") {
                    cs.setFloat(7, Float.parseFloat(moneyonvalue.getText().toString()));
                } else {
                    JOptionPane.showMessageDialog(this, "The system does not provide this type of value for limit calculation! Please select another one!");
                }
                
                cs.setString(8, cr);
                cs.setString(9, "admin");
//                System.out.println("aaa");
                int rd = cs.executeUpdate();
                lberrorwarm.setText("setting successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "The minimum value of the amount of money cannot be higher than the maximum one. Please check again!");
            }
        } catch (Exception ex) {
//            ex.printStackTrace();
            lberrorwarm.setText("Error! please try again!");
        }
        
    }
    
    public void ShowRecentSetting() {
        
        try {
            Connect.connectDatabase();
            CallableStatement cst = Connect.connectDatabase().prepareCall("{call ShowLimitSetting}");
            cst.setMaxRows(1);
            ResultSet rt = cst.executeQuery();
            while (rt.next()) {
                this.lbturnnum.setText("<html><b>Number of turns: </b>" + rt.getInt("NumberOfTurn") + "</html>");
                
                this.lbturnvalue.setText("<html><b>Turn value: </b>" + rt.getString("TurnValue").toString() + "</html>");
                String date_s = rt.getString("DateSet");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = dt.parse(date_s);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                
                
                this.lbdate.setText("<html><b>Time: </b>" + dt1.format(date) + "</html>");
                this.lbmax.setText("<html><b>Maximum money allowed: </b>$" + rt.getFloat("MaxMoney") + "</html>");
                this.lbmin.setText("<html><b>Minimum money allowed: </b>$" + rt.getFloat("MinMoney") + "</html>");
                this.lbtranfee.setText("<html><b>Transaction Fee: </b>" + rt.getFloat("TransactionFee") + "%</html>");
                this.lbturnfee.setText("<html><b>Fee on Turn: </b>$" + rt.getFloat("FeeCountedOnTurn") + "</html>");
                this.lbmoneyvalue.setText("<html><b>Total money/PoT: </b>$" + rt.getFloat("TotalOnTurnValue") + "</html>");
                this.lbnameset.setText("<html><b>Set by: </b>" + rt.getString("Admin_Username") + "</html>");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int positionx;
    private int positiony;
    Timer thoigian;
    Integer second;
    
    public void timel() {
        
        second = 3;
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

    // time close window
    public void timeclose() {
        
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
    
    private void comlumbank() {
        modelbank.addColumn("Banks");
        modelbank.addColumn("Note");
    }
    
    private void cellbank() {
        try {
            Connect.connectDatabase();
            CallableStatement cs = Connect.connectDatabase().prepareCall("{call ShowBank}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Vector banks = new Vector();
                banks.add(rs.getString("BankName"));
                banks.add(rs.getString("Note"));
                this.modelbank.addRow(banks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void addCol() {
        mod.addColumn("ID");
        mod.addColumn("Account");
        mod.addColumn("Full Name");
        mod.addColumn("Action");
        mod.addColumn("Money");
        mod.addColumn("Beneficiary");
        mod.addColumn("Balance");
        mod.addColumn("Date");
    }
    
    private void LoadingData() {
        try {
            Connect.connectDatabase();
            CallableStatement csta = Connect.connectDatabase().prepareCall("{call Reportloading}");
            ResultSet rst = csta.executeQuery();
//ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet <= kiểu cuộn khi load dữ liệu
            while (rst.next()) {
                Vector dulieu = new Vector();
                dulieu.add(rst.getString("ReportID").toString());
                dulieu.add(rst.getString("Report_AccountID").toString());
                dulieu.add(rst.getString("Report_Fullname").toString());
                dulieu.add(rst.getString("Report_Action").toString());
                dulieu.add(rst.getInt("Report_Amount") + "$");
                dulieu.add(rst.getString("Report_Beneficiary").toString());
                dulieu.add(rst.getInt("Report_Balance") + "$");
                
                String date_s = rst.getString("ReportDate");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = dt.parse(date_s);
                SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                
                dulieu.add(dt1.format(date));
                mod.addRow(dulieu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void customizeTableReport() {
        ReportTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // set table rollover color
        ReportTable.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW, null, new Color(255, 102, 0)));
        ReportTable.getColumn(0).setMaxWidth(80);
        ReportTable.getColumn(1).setMaxWidth(80);
        ReportTable.getColumn(2).setMaxWidth(90);
        ReportTable.getColumn(3).setMaxWidth(80);
        ReportTable.getColumn(4).setMaxWidth(80);
        ReportTable.getColumn(5).setMaxWidth(80);
        ReportTable.getColumn(6).setMaxWidth(80);
        ReportTable.getColumn(7).setMaxWidth(90);
        ReportTable.getColumn(0).setCellRenderer(new MyTableRenderer.IDRenderer());
        filterController = new MyTableFilter(ReportTable);
        
        BindingGroup filterGroup = new BindingGroup();
        filterGroup.addBinding(Bindings.createAutoBinding(READ, searchreport, BeanProperty.create("text"), filterController, BeanProperty.create("filterString")));
        filterGroup.bind();
        
    }
    // data table manager

    private void ComlumDataTableManager() {
        model.addColumn("ID");
        model.addColumn("Username");
        model.addColumn("Full Name");
        model.addColumn("Phone");
        model.addColumn("Address");
        model.addColumn("Administrator");
    }
    
    private void RowDataTableManager() {
        try {
            Connect.connectDatabase();
            CallableStatement cs = Connect.connectDatabase().prepareCall("{call ShowListManager}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (rs.getString("Admin_Username").equals(username)) {
                    Vector dulieu = new Vector();
                    dulieu.add(rs.getString("Managers_ID"));
                    dulieu.add(rs.getString("Managers_Username"));
                    dulieu.add(rs.getString("Managers_FullName"));
                    dulieu.add(rs.getString("Managers_Phone"));
                    dulieu.add(rs.getString("Managers_Address"));
                    dulieu.add(rs.getString("Admin_Username"));
                    this.model.addRow(dulieu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void customizeTable() {
        tablemanager.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // set table rollover color
        tablemanager.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW, null, new Color(255, 102, 0)));
        
        tablemanager.getColumn(0).setMaxWidth(60);
        tablemanager.getColumn(0).setCellRenderer(new MyTableRenderer.IDRenderer());
        filterController = new MyTableFilter(tablemanager);
        
        BindingGroup filterGroup = new BindingGroup();
        filterGroup.addBinding(Bindings.createAutoBinding(READ, txtsearch, BeanProperty.create("text"), filterController, BeanProperty.create("filterString")));
        filterGroup.bind();
        
    }
    
    private void customizeTableBanks() {
        tablebank.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // set table rollover color
        tablebank.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW, null, new Color(255, 102, 0)));
        
        
        filbank = new Filterbank(tablebank);
        
        BindingGroup filterGroup = new BindingGroup();
        filterGroup.addBinding(Bindings.createAutoBinding(READ, txtsearchbank, BeanProperty.create("text"), filbank, BeanProperty.create("filterString")));
        filterGroup.bind();
    }

    // count number of admins
    private void setCountLabel() {
        Dim.setText("" + tablemanager.getRowCount());
    }
    /// data table accounts

    private void ComlumDataTableAccount() {
        modelaccount.addColumn("Accounts");
        modelaccount.addColumn("Full Name");
        modelaccount.addColumn("Creation  Date");
        
        
        modelaccount.addColumn("Banks");
        modelaccount.addColumn("Managers ID");
    }
    
    private void RowDataTableAcccount() {
        try {
            Connect.connectDatabase();
            CallableStatement cs = Connect.connectDatabase().prepareCall("{call Show_Account}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (rs.getString("Managers_ID").equals(ManagerID)) {
                    Vector dulieu = new Vector();
                    dulieu.add(rs.getString("AccountID"));
                    dulieu.add(rs.getString("Fullname"));
                    
                    String date_s = rs.getString("CreationDate");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                    dulieu.add(dt1.format(date));
                    dulieu.add(rs.getString("BankName"));
                    dulieu.add(rs.getString("Managers_ID"));
                    this.modelaccount.addRow(dulieu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void customizeTableAccout() {
        tableaccount.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // set table rollover color
        tableaccount.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW, null, new Color(255, 102, 0)));
        tableaccount.getColumn(0).setMaxWidth(100);
        tableaccount.getColumn(0).setCellRenderer(new MyTableRenderer.IDRenderer());
        filterController = new MyTableFilter(tableaccount);
        
        BindingGroup filterGroup = new BindingGroup();
        filterGroup.addBinding(Bindings.createAutoBinding(READ, txtsearchaccount, BeanProperty.create("text"), filterController, BeanProperty.create("filterString")));
        filterGroup.bind();
        
    }

    // count number of admins
    private void setCountAccount() {
        dimaccount.setText("" + tableaccount.getRowCount());
    }
    
    private void setCountBank() {
        countbank.setText("" + tablebank.getRowCount());
    }
    
    private void setCountreport() {
        countreport.setText("" + ReportTable.getRowCount());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        butlogout = new javax.swing.JButton();
        lbclose = new javax.swing.JLabel();
        lbminmin = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbfullname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbgender = new javax.swing.JLabel();
        lbbirthday = new javax.swing.JLabel();
        lbemail = new javax.swing.JLabel();
        lbphone = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        lbpositions = new javax.swing.JLabel();
        lbchangepass = new javax.swing.JButton();
        butprofile = new javax.swing.JButton();
        butaccount = new javax.swing.JButton();
        butlistmanager = new javax.swing.JButton();
        butbank = new javax.swing.JButton();
        butreport = new javax.swing.JButton();
        butaboutus = new javax.swing.JButton();
        paneldeposit = new javax.swing.JPanel();
        txtaccount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtmoneyben = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();
        lbmoneyer = new javax.swing.JLabel();
        deposit = new javax.swing.JButton();
        butclear = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        butcheck = new javax.swing.JButton();
        txtphoneben = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtaddressben = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtnameben = new javax.swing.JTextField();
        lbnameer = new javax.swing.JLabel();
        lbaddresser = new javax.swing.JLabel();
        lbphoneer = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtcardno = new javax.swing.JTextField();
        lbidcarder = new javax.swing.JLabel();
        bgseposit = new javax.swing.JLabel();
        Panellimit = new javax.swing.JPanel();
        turnnum = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        combovalue = new javax.swing.JComboBox();
        maxmoney = new javax.swing.JTextField();
        radiotransactfee = new javax.swing.JRadioButton();
        tranfee = new javax.swing.JTextField();
        radioturnfee = new javax.swing.JRadioButton();
        turnfee = new javax.swing.JTextField();
        change = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        moneyonvalue = new javax.swing.JTextField();
        minmoney = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lbturnnum = new javax.swing.JLabel();
        lbturnvalue = new javax.swing.JLabel();
        lbtranfee = new javax.swing.JLabel();
        lbmin = new javax.swing.JLabel();
        lbmax = new javax.swing.JLabel();
        lbdate = new javax.swing.JLabel();
        lbnameset = new javax.swing.JLabel();
        lbturnfee = new javax.swing.JLabel();
        lbmoneyvalue = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lberrorwarm = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        bglimit = new javax.swing.JLabel();
        panelreport = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReportTable = new org.jdesktop.swingx.JXTable();
        butadvance = new javax.swing.JButton();
        searchreport = new org.jdesktop.swingx.JXSearchField();
        jLabel6 = new javax.swing.JLabel();
        butprint = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        countreport = new javax.swing.JLabel();
        butrefreshreport = new javax.swing.JButton();
        bgreport = new javax.swing.JLabel();
        panelbank = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablebank = new org.jdesktop.swingx.JXTable();
        txtsearchbank = new org.jdesktop.swingx.JXSearchField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        countbank = new javax.swing.JLabel();
        Butrefreshbank = new javax.swing.JButton();
        lbbankerror = new javax.swing.JLabel();
        butaddbank = new javax.swing.JButton();
        buteditbank = new javax.swing.JButton();
        butdeletebank = new javax.swing.JButton();
        bgbank = new javax.swing.JLabel();
        panelaccount = new javax.swing.JPanel();
        txtsearchaccount = new org.jdesktop.swingx.JXSearchField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableaccount = new org.jdesktop.swingx.JXTable();
        jLabel2 = new javax.swing.JLabel();
        dimaccount = new javax.swing.JLabel();
        butaddaccount = new javax.swing.JButton();
        editaccount = new javax.swing.JButton();
        deleaccount = new javax.swing.JButton();
        butrefreshaccount = new javax.swing.JButton();
        lberroraccount = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbshowall = new javax.swing.JCheckBox();
        bgmanager = new javax.swing.JLabel();
        panelaManager = new javax.swing.JPanel();
        txtsearch = new org.jdesktop.swingx.JXSearchField();
        Addmanager = new javax.swing.JButton();
        butdeletemanager = new javax.swing.JButton();
        buteditmanager = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Dim = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        butrefesh = new javax.swing.JButton();
        lberrordelete = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablemanager = new org.jdesktop.swingx.JXTable();
        bg = new javax.swing.JLabel();
        butdeposit = new javax.swing.JButton();
        butlimit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        butlogout.setToolTipText("Logout");
        butlogout.setBorderPainted(false);
        butlogout.setContentAreaFilled(false);
        butlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butlogout.setDefaultCapable(false);
        butlogout.setFocusPainted(false);
        butlogout.setFocusable(false);
        butlogout.setRequestFocusEnabled(false);
        butlogout.setRolloverEnabled(false);
        butlogout.setVerifyInputWhenFocusTarget(false);
        butlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butlogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butlogoutMouseExited(evt);
            }
        });
        getContentPane().add(butlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 80, 80));

        lbclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close1.png"))); // NOI18N
        lbclose.setToolTipText("");
        lbclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbcloseMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbcloseMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbcloseMouseExited(evt);
            }
        });
        getContentPane().add(lbclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, 20));

        lbminmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbminmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/min1.png"))); // NOI18N
        lbminmin.setToolTipText("");
        lbminmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbminmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbminminMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbminminMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbminminMouseExited(evt);
            }
        });
        getContentPane().add(lbminmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, -1, 5));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Full name :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 217, -1, 20));

        lbfullname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfullname.setForeground(new java.awt.Color(255, 255, 255));
        lbfullname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbfullname.setText("fullname");
        getContentPane().add(lbfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 217, 113, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Gender :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 248, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Birthday :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 283, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 255, 153));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Email :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 353, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 255, 153));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Phone :");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 318, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 255, 153));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Address :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 388, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("( dd / MM / YYYY )");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, 20));

        lbgender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbgender.setForeground(new java.awt.Color(255, 255, 255));
        lbgender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbgender.setText("gender");
        getContentPane().add(lbgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 248, 51, -1));

        lbbirthday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbbirthday.setForeground(new java.awt.Color(255, 255, 255));
        lbbirthday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbbirthday.setText("birthday");
        getContentPane().add(lbbirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 283, -1, -1));

        lbemail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbemail.setForeground(new java.awt.Color(255, 255, 255));
        lbemail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbemail.setText("email");
        getContentPane().add(lbemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 353, -1, -1));

        lbphone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbphone.setForeground(new java.awt.Color(255, 255, 255));
        lbphone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbphone.setText("phone");
        getContentPane().add(lbphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 318, -1, -1));

        lbaddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaddress.setForeground(new java.awt.Color(255, 255, 255));
        lbaddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbaddress.setText("address");
        getContentPane().add(lbaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 388, -1, -1));

        lbpositions.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbpositions.setForeground(new java.awt.Color(255, 255, 255));
        lbpositions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbpositions.setText("ADMINSTRATOR");
        getContentPane().add(lbpositions, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 260, 110));

        lbchangepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/changepassword1.png"))); // NOI18N
        lbchangepass.setBorderPainted(false);
        lbchangepass.setContentAreaFilled(false);
        lbchangepass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbchangepass.setDefaultCapable(false);
        lbchangepass.setFocusPainted(false);
        lbchangepass.setFocusable(false);
        lbchangepass.setMaximumSize(new java.awt.Dimension(119, 124));
        lbchangepass.setMinimumSize(new java.awt.Dimension(119, 124));
        lbchangepass.setRequestFocusEnabled(false);
        lbchangepass.setRolloverEnabled(false);
        lbchangepass.setVerifyInputWhenFocusTarget(false);
        lbchangepass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbchangepassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbchangepassMouseExited(evt);
            }
        });
        lbchangepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbchangepassActionPerformed(evt);
            }
        });
        getContentPane().add(lbchangepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 120, 130));

        butprofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/changeprofile.png"))); // NOI18N
        butprofile.setBorderPainted(false);
        butprofile.setContentAreaFilled(false);
        butprofile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butprofile.setDefaultCapable(false);
        butprofile.setFocusPainted(false);
        butprofile.setFocusable(false);
        butprofile.setRequestFocusEnabled(false);
        butprofile.setRolloverEnabled(false);
        butprofile.setVerifyInputWhenFocusTarget(false);
        butprofile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butprofileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butprofileMouseExited(evt);
            }
        });
        butprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butprofileActionPerformed(evt);
            }
        });
        getContentPane().add(butprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 120, 130));

        butaccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account.png"))); // NOI18N
        butaccount.setBorderPainted(false);
        butaccount.setContentAreaFilled(false);
        butaccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butaccount.setDefaultCapable(false);
        butaccount.setFocusPainted(false);
        butaccount.setFocusable(false);
        butaccount.setRequestFocusEnabled(false);
        butaccount.setRolloverEnabled(false);
        butaccount.setVerifyInputWhenFocusTarget(false);
        butaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butaccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butaccountMouseExited(evt);
            }
        });
        butaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaccountActionPerformed(evt);
            }
        });
        getContentPane().add(butaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 80, 70));

        butlistmanager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/listmanager.png"))); // NOI18N
        butlistmanager.setBorderPainted(false);
        butlistmanager.setContentAreaFilled(false);
        butlistmanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butlistmanager.setDefaultCapable(false);
        butlistmanager.setFocusPainted(false);
        butlistmanager.setFocusable(false);
        butlistmanager.setRequestFocusEnabled(false);
        butlistmanager.setRolloverEnabled(false);
        butlistmanager.setVerifyInputWhenFocusTarget(false);
        butlistmanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butlistmanagerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butlistmanagerMouseExited(evt);
            }
        });
        butlistmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butlistmanagerActionPerformed(evt);
            }
        });
        getContentPane().add(butlistmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 78, 70));

        butbank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bank.png"))); // NOI18N
        butbank.setBorderPainted(false);
        butbank.setContentAreaFilled(false);
        butbank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butbank.setDefaultCapable(false);
        butbank.setFocusPainted(false);
        butbank.setFocusable(false);
        butbank.setRequestFocusEnabled(false);
        butbank.setRolloverEnabled(false);
        butbank.setVerifyInputWhenFocusTarget(false);
        butbank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butbankMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butbankMouseExited(evt);
            }
        });
        butbank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butbankActionPerformed(evt);
            }
        });
        getContentPane().add(butbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 80, 70));

        butreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        butreport.setToolTipText("");
        butreport.setBorderPainted(false);
        butreport.setContentAreaFilled(false);
        butreport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butreport.setDefaultCapable(false);
        butreport.setFocusPainted(false);
        butreport.setFocusable(false);
        butreport.setRequestFocusEnabled(false);
        butreport.setRolloverEnabled(false);
        butreport.setVerifyInputWhenFocusTarget(false);
        butreport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butreportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butreportMouseExited(evt);
            }
        });
        butreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butreportActionPerformed(evt);
            }
        });
        getContentPane().add(butreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 80, 70));

        butaboutus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/aboutus.png"))); // NOI18N
        butaboutus.setBorderPainted(false);
        butaboutus.setContentAreaFilled(false);
        butaboutus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butaboutus.setDefaultCapable(false);
        butaboutus.setFocusPainted(false);
        butaboutus.setFocusable(false);
        butaboutus.setRequestFocusEnabled(false);
        butaboutus.setRolloverEnabled(false);
        butaboutus.setVerifyInputWhenFocusTarget(false);
        butaboutus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butaboutusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butaboutusMouseExited(evt);
            }
        });
        butaboutus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaboutusActionPerformed(evt);
            }
        });
        getContentPane().add(butaboutus, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 80, 70));

        paneldeposit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtaccount.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtaccountMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtaccountMousePressed(evt);
            }
        });
        txtaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaccountActionPerformed(evt);
            }
        });
        txtaccount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaccountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaccountKeyTyped(evt);
            }
        });
        paneldeposit.add(txtaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 340, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Account :");
        paneldeposit.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Amount of money :");
        paneldeposit.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 140, 30));

        txtmoneyben.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtmoneyben.setForeground(new java.awt.Color(0, 0, 204));
        paneldeposit.add(txtmoneyben, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 340, 40));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb1.setForeground(new java.awt.Color(204, 0, 0));
        paneldeposit.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 340, 25));

        lbmoneyer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbmoneyer.setForeground(new java.awt.Color(204, 0, 0));
        paneldeposit.add(lbmoneyer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 480, 30));

        deposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/depo.png"))); // NOI18N
        deposit.setBorderPainted(false);
        deposit.setContentAreaFilled(false);
        deposit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deposit.setDefaultCapable(false);
        deposit.setFocusPainted(false);
        deposit.setFocusable(false);
        deposit.setRequestFocusEnabled(false);
        deposit.setRolloverEnabled(false);
        deposit.setVerifyInputWhenFocusTarget(false);
        deposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                depositMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                depositMouseExited(evt);
            }
        });
        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });
        paneldeposit.add(deposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 150, 70));

        butclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        butclear.setBorderPainted(false);
        butclear.setContentAreaFilled(false);
        butclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butclear.setDefaultCapable(false);
        butclear.setFocusPainted(false);
        butclear.setFocusable(false);
        butclear.setRequestFocusEnabled(false);
        butclear.setRolloverEnabled(false);
        butclear.setVerifyInputWhenFocusTarget(false);
        butclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butclearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butclearMouseExited(evt);
            }
        });
        butclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butclearActionPerformed(evt);
            }
        });
        paneldeposit.add(butclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 150, 70));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 153));
        jLabel15.setText("Note : Press ENTER to check the existence of account.");
        paneldeposit.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 390, -1));

        butcheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checking.png"))); // NOI18N
        butcheck.setBorderPainted(false);
        butcheck.setContentAreaFilled(false);
        butcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butcheck.setDefaultCapable(false);
        butcheck.setFocusPainted(false);
        butcheck.setFocusable(false);
        butcheck.setRequestFocusEnabled(false);
        butcheck.setRolloverEnabled(false);
        butcheck.setVerifyInputWhenFocusTarget(false);
        butcheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butcheckMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butcheckMouseEntered(evt);
            }
        });
        butcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butcheckActionPerformed(evt);
            }
        });
        paneldeposit.add(butcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 130, 50));

        txtphoneben.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtphoneben.setForeground(new java.awt.Color(0, 0, 204));
        txtphoneben.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtphonebenKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtphonebenKeyTyped(evt);
            }
        });
        paneldeposit.add(txtphoneben, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 340, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Phone ( Benefactor) :");
        paneldeposit.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Address  (Benefactor):");
        paneldeposit.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        txtaddressben.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtaddressben.setForeground(new java.awt.Color(0, 0, 204));
        paneldeposit.add(txtaddressben, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 340, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("Name (Benefactor):");
        paneldeposit.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        txtnameben.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtnameben.setForeground(new java.awt.Color(0, 0, 204));
        paneldeposit.add(txtnameben, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 106, 340, 30));

        lbnameer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnameer.setForeground(new java.awt.Color(204, 0, 0));
        paneldeposit.add(lbnameer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 340, 20));

        lbaddresser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbaddresser.setForeground(new java.awt.Color(204, 0, 0));
        paneldeposit.add(lbaddresser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 340, 20));

        lbphoneer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbphoneer.setForeground(new java.awt.Color(204, 0, 0));
        paneldeposit.add(lbphoneer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 340, 20));

        jLabel32.setText("(Benefactor)");
        paneldeposit.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("ID card No. (Benefactor):");
        paneldeposit.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        txtcardno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtcardno.setForeground(new java.awt.Color(0, 0, 204));
        txtcardno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcardnoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcardnoKeyTyped(evt);
            }
        });
        paneldeposit.add(txtcardno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 340, 30));

        lbidcarder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbidcarder.setForeground(new java.awt.Color(204, 0, 0));
        paneldeposit.add(lbidcarder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 460, 20));

        bgseposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgmanager.png"))); // NOI18N
        paneldeposit.add(bgseposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        getContentPane().add(paneldeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 690, 500));

        Panellimit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Panellimit.add(turnnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 160, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Set number of turns:");
        Panellimit.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Maximum amount of money users can interact:");
        Panellimit.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Turn value:");
        Panellimit.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        combovalue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combovalueActionPerformed(evt);
            }
        });
        combovalue.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                combovalueInputMethodTextChanged(evt);
            }
        });
        combovalue.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                combovaluePropertyChange(evt);
            }
        });
        combovalue.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                combovalueVetoableChange(evt);
            }
        });
        Panellimit.add(combovalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, -1));
        Panellimit.add(maxmoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 210, -1));

        radiotransactfee.setBackground(new java.awt.Color(112, 124, 136));
        buttonGroup1.add(radiotransactfee);
        radiotransactfee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radiotransactfee.setText("Transaction Fee (Ex: 0.05):");
        radiotransactfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiotransactfeeActionPerformed(evt);
            }
        });
        Panellimit.add(radiotransactfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        Panellimit.add(tranfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 210, -1));

        radioturnfee.setBackground(new java.awt.Color(112, 124, 136));
        buttonGroup1.add(radioturnfee);
        radioturnfee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioturnfee.setText("Fee calculated on turns of transaction:");
        radioturnfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioturnfeeActionPerformed(evt);
            }
        });
        Panellimit.add(radioturnfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));
        Panellimit.add(turnfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 210, 20));

        change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        change.setBorderPainted(false);
        change.setContentAreaFilled(false);
        change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        change.setDefaultCapable(false);
        change.setFocusPainted(false);
        change.setFocusable(false);
        change.setRequestFocusEnabled(false);
        change.setRolloverEnabled(false);
        change.setVerifyInputWhenFocusTarget(false);
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        Panellimit.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 244, 150, 35));

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        clear.setBorderPainted(false);
        clear.setContentAreaFilled(false);
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.setDefaultCapable(false);
        clear.setFocusPainted(false);
        clear.setFocusable(false);
        clear.setRequestFocusEnabled(false);
        clear.setRolloverEnabled(false);
        clear.setVerifyInputWhenFocusTarget(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        Panellimit.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 245, 150, 35));
        Panellimit.add(moneyonvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 210, -1));
        Panellimit.add(minmoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 210, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Minimum amount of money users can interact:");
        Panellimit.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Total money allowed for one period of time:");
        Panellimit.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel25.setText("RECENT RULES SETTING FOR SYSTEM");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 415, -1));

        lbturnnum.setText("Number of turns:");
        jPanel1.add(lbturnnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, -1, -1));

        lbturnvalue.setText("Turn value:");
        jPanel1.add(lbturnvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, -1, -1));

        lbtranfee.setText("Transaction Fee:");
        jPanel1.add(lbtranfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 51, -1, -1));

        lbmin.setText("Minimum money allowed:");
        jPanel1.add(lbmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 83, -1, -1));

        lbmax.setText("Maximum money allowed:");
        jPanel1.add(lbmax, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 115, -1, -1));

        lbdate.setText("Time:");
        jPanel1.add(lbdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        lbnameset.setText("Set by: ");
        jPanel1.add(lbnameset, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 177, -1, -1));

        lbturnfee.setText("Fee on Turn:");
        jPanel1.add(lbturnfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 147, -1, -1));

        lbmoneyvalue.setText("Total money/PoT:");
        jPanel1.add(lbmoneyvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 147, -1, -1));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 22, -1, -1));

        Panellimit.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 540, 200));

        lberrorwarm.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lberrorwarm.setForeground(new java.awt.Color(153, 0, 0));
        Panellimit.add(lberrorwarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 430, 30));

        jLabel19.setText("$");
        Panellimit.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));

        jLabel29.setText("$");
        Panellimit.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 10, -1));

        jLabel30.setText("$");
        Panellimit.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 10, -1));

        jLabel31.setText("%");
        Panellimit.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 143, -1, -1));

        jLabel34.setText("$");
        Panellimit.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 213, -1, -1));

        bglimit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bglimit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgmanager.png"))); // NOI18N
        Panellimit.add(bglimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(Panellimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 690, 500));

        panelreport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ReportTable.setColumnControlVisible(true);
        ReportTable.setShowHorizontalLines(false);
        ReportTable.setShowVerticalLines(false);
        jScrollPane3.setViewportView(ReportTable);

        panelreport.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 97, 670, 340));

        butadvance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/advanced.png"))); // NOI18N
        butadvance.setBorderPainted(false);
        butadvance.setContentAreaFilled(false);
        butadvance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butadvance.setDefaultCapable(false);
        butadvance.setFocusPainted(false);
        butadvance.setFocusable(false);
        butadvance.setRequestFocusEnabled(false);
        butadvance.setRolloverEnabled(false);
        butadvance.setVerifyInputWhenFocusTarget(false);
        butadvance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butadvanceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butadvanceMouseExited(evt);
            }
        });
        butadvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butadvanceActionPerformed(evt);
            }
        });
        panelreport.add(butadvance, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 150, 40));

        searchreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchreportActionPerformed(evt);
            }
        });
        panelreport.add(searchreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search ID or Account or Full Name :");
        panelreport.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        butprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        butprint.setBorderPainted(false);
        butprint.setContentAreaFilled(false);
        butprint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butprint.setDefaultCapable(false);
        butprint.setFocusPainted(false);
        butprint.setFocusable(false);
        butprint.setRequestFocusEnabled(false);
        butprint.setRolloverEnabled(false);
        butprint.setVerifyInputWhenFocusTarget(false);
        butprint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butprintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butprintMouseExited(evt);
            }
        });
        butprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butprintActionPerformed(evt);
            }
        });
        panelreport.add(butprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 120, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total :");
        panelreport.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, -1, -1));

        countreport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        countreport.setForeground(new java.awt.Color(255, 102, 0));
        countreport.setText("0");
        panelreport.add(countreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        butrefreshreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        butrefreshreport.setBorderPainted(false);
        butrefreshreport.setContentAreaFilled(false);
        butrefreshreport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butrefreshreport.setDefaultCapable(false);
        butrefreshreport.setFocusPainted(false);
        butrefreshreport.setFocusable(false);
        butrefreshreport.setRequestFocusEnabled(false);
        butrefreshreport.setRolloverEnabled(false);
        butrefreshreport.setVerifyInputWhenFocusTarget(false);
        butrefreshreport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butrefreshreportMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butrefreshreportMouseEntered(evt);
            }
        });
        butrefreshreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butrefreshreportActionPerformed(evt);
            }
        });
        panelreport.add(butrefreshreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 40, 43));

        bgreport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgmanager.png"))); // NOI18N
        panelreport.add(bgreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        getContentPane().add(panelreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 690, 500));

        panelbank.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablebank.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablebank.setColumnControlVisible(true);
        tablebank.setShowHorizontalLines(false);
        tablebank.setShowVerticalLines(false);
        tablebank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebankMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablebank);

        panelbank.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, 670, 260));

        txtsearchbank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchbankActionPerformed(evt);
            }
        });
        panelbank.add(txtsearchbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Search Bank name :");
        panelbank.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total :");
        panelbank.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        countbank.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        countbank.setForeground(new java.awt.Color(255, 102, 0));
        countbank.setText("0");
        panelbank.add(countbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        Butrefreshbank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        Butrefreshbank.setBorderPainted(false);
        Butrefreshbank.setContentAreaFilled(false);
        Butrefreshbank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Butrefreshbank.setDefaultCapable(false);
        Butrefreshbank.setFocusPainted(false);
        Butrefreshbank.setFocusable(false);
        Butrefreshbank.setRequestFocusEnabled(false);
        Butrefreshbank.setRolloverEnabled(false);
        Butrefreshbank.setVerifyInputWhenFocusTarget(false);
        Butrefreshbank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ButrefreshbankMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ButrefreshbankMouseEntered(evt);
            }
        });
        Butrefreshbank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButrefreshbankActionPerformed(evt);
            }
        });
        panelbank.add(Butrefreshbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 40, 42));

        lbbankerror.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbbankerror.setForeground(new java.awt.Color(153, 0, 0));
        panelbank.add(lbbankerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 370, 30));

        butaddbank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        butaddbank.setBorderPainted(false);
        butaddbank.setContentAreaFilled(false);
        butaddbank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butaddbank.setDefaultCapable(false);
        butaddbank.setFocusPainted(false);
        butaddbank.setFocusable(false);
        butaddbank.setRequestFocusEnabled(false);
        butaddbank.setRolloverEnabled(false);
        butaddbank.setVerifyInputWhenFocusTarget(false);
        butaddbank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butaddbankMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butaddbankMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butaddbankMouseExited(evt);
            }
        });
        panelbank.add(butaddbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 40, 40));

        buteditbank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        buteditbank.setBorderPainted(false);
        buteditbank.setContentAreaFilled(false);
        buteditbank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buteditbank.setDefaultCapable(false);
        buteditbank.setFocusPainted(false);
        buteditbank.setFocusable(false);
        buteditbank.setRequestFocusEnabled(false);
        buteditbank.setRolloverEnabled(false);
        buteditbank.setVerifyInputWhenFocusTarget(false);
        buteditbank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buteditbankMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buteditbankMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buteditbankMouseExited(evt);
            }
        });
        panelbank.add(buteditbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 41, 42));

        butdeletebank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        butdeletebank.setBorderPainted(false);
        butdeletebank.setContentAreaFilled(false);
        butdeletebank.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butdeletebank.setDefaultCapable(false);
        butdeletebank.setFocusPainted(false);
        butdeletebank.setFocusable(false);
        butdeletebank.setRequestFocusEnabled(false);
        butdeletebank.setRolloverEnabled(false);
        butdeletebank.setVerifyInputWhenFocusTarget(false);
        butdeletebank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butdeletebankMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butdeletebankMouseExited(evt);
            }
        });
        butdeletebank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butdeletebankActionPerformed(evt);
            }
        });
        panelbank.add(butdeletebank, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 40, 40));

        bgbank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgbank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgmanager.png"))); // NOI18N
        panelbank.add(bgbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        getContentPane().add(panelbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 690, 500));

        panelaccount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearchaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsearchaccountMouseClicked(evt);
            }
        });
        txtsearchaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchaccountActionPerformed(evt);
            }
        });
        panelaccount.add(txtsearchaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, -1));

        tableaccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tableaccount.setToolTipText("Double click to edit accoint's profile");
        tableaccount.setColumnControlVisible(true);
        tableaccount.setName("adminTable"); // NOI18N
        tableaccount.setShowHorizontalLines(false);
        tableaccount.setShowVerticalLines(false);
        tableaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableaccountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableaccount);

        panelaccount.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 670, 290));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total :");
        panelaccount.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 54, -1, 20));

        dimaccount.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dimaccount.setForeground(new java.awt.Color(255, 153, 0));
        dimaccount.setText("0");
        panelaccount.add(dimaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 54, 10, 20));

        butaddaccount.setForeground(new java.awt.Color(255, 255, 255));
        butaddaccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        butaddaccount.setToolTipText("Add new");
        butaddaccount.setBorderPainted(false);
        butaddaccount.setContentAreaFilled(false);
        butaddaccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butaddaccount.setDefaultCapable(false);
        butaddaccount.setFocusPainted(false);
        butaddaccount.setFocusable(false);
        butaddaccount.setRequestFocusEnabled(false);
        butaddaccount.setRolloverEnabled(false);
        butaddaccount.setVerifyInputWhenFocusTarget(false);
        butaddaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butaddaccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butaddaccountMouseExited(evt);
            }
        });
        butaddaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaddaccountActionPerformed(evt);
            }
        });
        panelaccount.add(butaddaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 50, 40));

        editaccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        editaccount.setToolTipText("Edit");
        editaccount.setBorderPainted(false);
        editaccount.setContentAreaFilled(false);
        editaccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editaccount.setDefaultCapable(false);
        editaccount.setFocusPainted(false);
        editaccount.setFocusable(false);
        editaccount.setRequestFocusEnabled(false);
        editaccount.setRolloverEnabled(false);
        editaccount.setVerifyInputWhenFocusTarget(false);
        editaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editaccountMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editaccountMouseEntered(evt);
            }
        });
        editaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaccountActionPerformed(evt);
            }
        });
        panelaccount.add(editaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 40, 42));

        deleaccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        deleaccount.setToolTipText("Delete");
        deleaccount.setBorderPainted(false);
        deleaccount.setContentAreaFilled(false);
        deleaccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleaccount.setDefaultCapable(false);
        deleaccount.setFocusPainted(false);
        deleaccount.setFocusable(false);
        deleaccount.setRequestFocusEnabled(false);
        deleaccount.setRolloverEnabled(false);
        deleaccount.setVerifyInputWhenFocusTarget(false);
        deleaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleaccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleaccountMouseExited(evt);
            }
        });
        deleaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleaccountActionPerformed(evt);
            }
        });
        panelaccount.add(deleaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 40, 40));

        butrefreshaccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        butrefreshaccount.setToolTipText("Refresh");
        butrefreshaccount.setBorderPainted(false);
        butrefreshaccount.setContentAreaFilled(false);
        butrefreshaccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butrefreshaccount.setDefaultCapable(false);
        butrefreshaccount.setFocusPainted(false);
        butrefreshaccount.setFocusable(false);
        butrefreshaccount.setRequestFocusEnabled(false);
        butrefreshaccount.setRolloverEnabled(false);
        butrefreshaccount.setVerifyInputWhenFocusTarget(false);
        butrefreshaccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butrefreshaccountMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butrefreshaccountMouseEntered(evt);
            }
        });
        butrefreshaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butrefreshaccountActionPerformed(evt);
            }
        });
        panelaccount.add(butrefreshaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 40, 42));

        lberroraccount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lberroraccount.setForeground(new java.awt.Color(153, 0, 0));
        panelaccount.add(lberroraccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 404, 440, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search Account or Full Name or Create Date:");
        panelaccount.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 260, -1));

        cbshowall.setBackground(new java.awt.Color(105, 116, 119));
        cbshowall.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbshowall.setForeground(new java.awt.Color(255, 255, 255));
        cbshowall.setText("Show all");
        cbshowall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbshowallActionPerformed(evt);
            }
        });
        panelaccount.add(cbshowall, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 80, -1));

        bgmanager.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bgmanager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgmanager.png"))); // NOI18N
        panelaccount.add(bgmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(panelaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 690, 500));

        panelaManager.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsearchMouseClicked(evt);
            }
        });
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        panelaManager.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 192, -1));

        Addmanager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        Addmanager.setToolTipText("Add");
        Addmanager.setBorderPainted(false);
        Addmanager.setContentAreaFilled(false);
        Addmanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Addmanager.setDefaultCapable(false);
        Addmanager.setFocusPainted(false);
        Addmanager.setFocusable(false);
        Addmanager.setRequestFocusEnabled(false);
        Addmanager.setRolloverEnabled(false);
        Addmanager.setVerifyInputWhenFocusTarget(false);
        Addmanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddmanagerMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddmanagerMouseEntered(evt);
            }
        });
        Addmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddmanagerActionPerformed(evt);
            }
        });
        panelaManager.add(Addmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 40, 40));

        butdeletemanager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        butdeletemanager.setToolTipText("Delete");
        butdeletemanager.setBorderPainted(false);
        butdeletemanager.setContentAreaFilled(false);
        butdeletemanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butdeletemanager.setDefaultCapable(false);
        butdeletemanager.setFocusPainted(false);
        butdeletemanager.setFocusable(false);
        butdeletemanager.setRequestFocusEnabled(false);
        butdeletemanager.setRolloverEnabled(false);
        butdeletemanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butdeletemanagerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butdeletemanagerMouseExited(evt);
            }
        });
        butdeletemanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butdeletemanagerActionPerformed(evt);
            }
        });
        panelaManager.add(butdeletemanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 40, 42));

        buteditmanager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        buteditmanager.setToolTipText("Edit");
        buteditmanager.setBorderPainted(false);
        buteditmanager.setContentAreaFilled(false);
        buteditmanager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buteditmanager.setDefaultCapable(false);
        buteditmanager.setFocusPainted(false);
        buteditmanager.setFocusable(false);
        buteditmanager.setRequestFocusEnabled(false);
        buteditmanager.setRolloverEnabled(false);
        buteditmanager.setVerifyInputWhenFocusTarget(false);
        buteditmanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buteditmanagerMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buteditmanagerMouseEntered(evt);
            }
        });
        buteditmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buteditmanagerActionPerformed(evt);
            }
        });
        panelaManager.add(buteditmanager, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 40, 42));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total :");
        panelaManager.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        Dim.setForeground(new java.awt.Color(255, 153, 0));
        Dim.setText("0");
        panelaManager.add(Dim, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search ID or Username or Full Name :");
        panelaManager.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        butrefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        butrefesh.setToolTipText("Refresh");
        butrefesh.setBorderPainted(false);
        butrefesh.setContentAreaFilled(false);
        butrefesh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butrefesh.setDefaultCapable(false);
        butrefesh.setFocusPainted(false);
        butrefesh.setFocusable(false);
        butrefesh.setRequestFocusEnabled(false);
        butrefesh.setRolloverEnabled(false);
        butrefesh.setVerifyInputWhenFocusTarget(false);
        butrefesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butrefeshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butrefeshMouseExited(evt);
            }
        });
        butrefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butrefeshActionPerformed(evt);
            }
        });
        panelaManager.add(butrefesh, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 40, 42));

        lberrordelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lberrordelete.setForeground(new java.awt.Color(153, 0, 0));
        panelaManager.add(lberrordelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 460, 30));

        tablemanager.setModel(model);
        tablemanager.setToolTipText("Double click to edit manager's profile");
        tablemanager.setColumnControlVisible(true);
        tablemanager.setShowHorizontalLines(false);
        tablemanager.setShowVerticalLines(false);
        tablemanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablemanagerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablemanager);

        panelaManager.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 118, 660, 259));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgmanager.png"))); // NOI18N
        panelaManager.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

        getContentPane().add(panelaManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 690, 500));

        butdeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deposit.png"))); // NOI18N
        butdeposit.setBorderPainted(false);
        butdeposit.setContentAreaFilled(false);
        butdeposit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butdeposit.setDefaultCapable(false);
        butdeposit.setFocusPainted(false);
        butdeposit.setFocusable(false);
        butdeposit.setRequestFocusEnabled(false);
        butdeposit.setRolloverEnabled(false);
        butdeposit.setVerifyInputWhenFocusTarget(false);
        butdeposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butdepositMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butdepositMouseExited(evt);
            }
        });
        butdeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butdepositActionPerformed(evt);
            }
        });
        getContentPane().add(butdeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 80, 70));

        butlimit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/limit.png"))); // NOI18N
        butlimit.setBorderPainted(false);
        butlimit.setContentAreaFilled(false);
        butlimit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butlimit.setDefaultCapable(false);
        butlimit.setFocusPainted(false);
        butlimit.setFocusable(false);
        butlimit.setRequestFocusEnabled(false);
        butlimit.setRolloverEnabled(false);
        butlimit.setVerifyInputWhenFocusTarget(false);
        butlimit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butlimitMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butlimitMouseEntered(evt);
            }
        });
        butlimit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butlimitActionPerformed(evt);
            }
        });
        getContentPane().add(butlimit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 80, 70));

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
    }//GEN-LAST:event_formMousePressed
    
    private void lbminminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbminminMouseEntered
        
        lbminmin.setIcon(new ImageIcon("src/images/min2.png"));
    }//GEN-LAST:event_lbminminMouseEntered
    
    private void lbminminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbminminMouseExited
        
        lbminmin.setIcon(new ImageIcon("src/images/min1.png"));
        
    }//GEN-LAST:event_lbminminMouseExited
    
    private void lbminminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbminminMouseClicked
        
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lbminminMouseClicked
    private void lbcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcloseMouseClicked
        if (evt.getClickCount() == 1) {
            timeclose();
            thoigian.start();
            this.setSize(1000, 600);
            new Thread(new DisplayClose(this, 0, 0)).start();
        }
    }//GEN-LAST:event_lbcloseMouseClicked
    
    private void lbcloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcloseMouseEntered
        
        lbclose.setIcon(new ImageIcon("src/images/close2.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_lbcloseMouseEntered
    
    private void lbcloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcloseMouseExited
        lbclose.setIcon(new ImageIcon("src/images/close1.png"));
    }//GEN-LAST:event_lbcloseMouseExited
    
    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        
        if (evt.getKeyCode() == 112) {
            try {
                Runtime.getRuntime().exec("hh.exe \"Interface.chm");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_formKeyReleased
                
    private void lbchangepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbchangepassActionPerformed
        
        new ChangePassword(this, true).setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_lbchangepassActionPerformed
    
    private void lbchangepassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbchangepassMouseEntered
        lbchangepass.setIcon(new ImageIcon("src/images/changepassword.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_lbchangepassMouseEntered
    
    private void lbchangepassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbchangepassMouseExited
        
        lbchangepass.setIcon(new ImageIcon("src/images/changepassword1.png"));
    }//GEN-LAST:event_lbchangepassMouseExited
    
    private void butprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butprofileActionPerformed
        ChangeProfile aa = new ChangeProfile(this, true);
        aa.setVisible(true);
        this.lbfullname.setText(profileFullname);
        this.lbgender.setText(profileGender);
        this.lbbirthday.setText(profileBirthday);
        this.lbphone.setText(profilePhone);
        this.lbemail.setText(profileEmail);
        this.lbaddress.setText(profileAddress);

        // TODO add your handling code here:
    }//GEN-LAST:event_butprofileActionPerformed
    
    private void butprofileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprofileMouseEntered
        
        butprofile.setIcon(new ImageIcon("src/images/changeprofile1.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butprofileMouseEntered
    
    private void butprofileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprofileMouseExited
        
        butprofile.setIcon(new ImageIcon("src/images/changeprofile.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butprofileMouseExited
    
    private void butaboutusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaboutusMouseEntered
        
        
        butaboutus.setIcon(new ImageIcon("src/images/aboutus1.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butaboutusMouseEntered
    
    private void butaboutusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaboutusMouseExited
        
        
        butaboutus.setIcon(new ImageIcon("src/images/aboutus.png"));


        // TODO add your handling code here:
    }//GEN-LAST:event_butaboutusMouseExited
    
    private void butaboutusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaboutusActionPerformed
        
        new AboutUs(this, true).setVisible(true);
    }//GEN-LAST:event_butaboutusActionPerformed
    
    private void butlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butlogoutMouseEntered
        
        butlogout.setIcon(new ImageIcon("src/images/logout1.png"));
    }//GEN-LAST:event_butlogoutMouseEntered
    
    private void butlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butlogoutMouseExited
        
        butlogout.setIcon(new ImageIcon("src/images/logout.png"));
        
    }//GEN-LAST:event_butlogoutMouseExited
    
    private void butdeletemanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butdeletemanagerActionPerformed
        
        try {
            String index = String.valueOf(tablemanager.getValueAt(tablemanager.getSelectedRow(), 1).toString());
            Connect.connectDatabase();
            CallableStatement callPROC = Connect.connectDatabase().prepareCall("{call DeleteManager(?)}");
            callPROC.setString(1, index);
            callPROC.executeUpdate();
            lberrordelete.setText("Delete successfully!");
            while (tablemanager.getRowCount() > 0) {
                ((DefaultTableModel) tablemanager.getModel()).removeRow(0);
            }
            RowDataTableManager();
            butdeletemanager.setEnabled(false);
            buteditmanager.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Can not connect to dadatabse! please check connnection!");
        }
        setCountLabel();
    }//GEN-LAST:event_butdeletemanagerActionPerformed
    
    private void AddmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddmanagerActionPerformed
        try {
            // message will bew losing
            lberrordelete.setText("");
            /// new add new manager
            new Add_Manager(this, true).setVisible(true);
            while (tablemanager.getRowCount() > 0) {
                ((DefaultTableModel) tablemanager.getModel()).removeRow(0);
            }
            RowDataTableManager();
            
        } catch (ParseException ex) {
            Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        buteditmanager.setEnabled(false);
        butdeletemanager.setEnabled(false);
        setCountLabel();
    }//GEN-LAST:event_AddmanagerActionPerformed
    
    private void buteditmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buteditmanagerActionPerformed
        // message will bew losing
        lberrordelete.setText("");
        int rowIndex = this.tablemanager.convertRowIndexToModel(tablemanager.getSelectedRow());
        String username = tablemanager.getModel().getValueAt(rowIndex, 1).toString();
        
        new Edit_Manager(this, true, username).setVisible(true);
        
        DefaultTableModel model = (DefaultTableModel) tablemanager.getModel();
        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }
        while (tablemanager.getRowCount() > 0) {
            ((DefaultTableModel) tablemanager.getModel()).removeRow(0);
        }
        RowDataTableManager();
        
        
        butdeletemanager.setEnabled(false);
        buteditmanager.setEnabled(false);
        setCountLabel();
    }//GEN-LAST:event_buteditmanagerActionPerformed
    
    private void butrefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butrefeshActionPerformed
        // refesh dim
        setCountLabel();
        // message will bew losing
        lberrordelete.setText("");
        // refesh row
        while (tablemanager.getRowCount() > 0) {
            ((DefaultTableModel) tablemanager.getModel()).removeRow(0);
        }
        RowDataTableManager();
        
        buteditmanager.setEnabled(false);
        butdeletemanager.setEnabled(false);
    }//GEN-LAST:event_butrefeshActionPerformed
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        timeclose();
        thoigian.start();
        this.setSize(1000, 600);
        new Thread(new DisplayClose(this, 0, 0)).start();
        
    }//GEN-LAST:event_formWindowClosing
    
    private void tablemanagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablemanagerMouseClicked
        
        try {
            int rowIndex = this.tablemanager.convertRowIndexToModel(tablemanager.getSelectedRow());
            if (evt.getClickCount() >= 1) {
                butdeletemanager.setEnabled(true);
                buteditmanager.setEnabled(true);
                lberrordelete.setText("");
            }
            if (evt.getClickCount() >= 2 && tablemanager.getSelectedRow() != -1) {
                String username = tablemanager.getModel().getValueAt(rowIndex, 1).toString();
                new Edit_Manager(this, true, username).setVisible(true);
                //refesh when update informatin table admin
                DefaultTableModel model = (DefaultTableModel) tablemanager.getModel();
                while (model.getRowCount() > 0) {
                    for (int i = 0; i < model.getRowCount(); i++) {
                        model.removeRow(i);
                    }
                }
                while (tablemanager.getRowCount() > 0) {
                    ((DefaultTableModel) tablemanager.getModel()).removeRow(0);
                }
                RowDataTableManager();
            }
            if (evt.getClickCount() != 1) {
                butdeletemanager.setEnabled(false);
                buteditmanager.setEnabled(false);
            }
        } catch (Exception e) {
            lberrordelete.setText("Please select one table row!");
            buteditmanager.setEnabled(false);
            butdeletemanager.setEnabled(false);
        }
        
    }//GEN-LAST:event_tablemanagerMouseClicked
    
    private void butlistmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butlistmanagerActionPerformed
        butaddbank.setVisible(false);
        panelaManager.setVisible(true);
        butlistmanager.setEnabled(false);
        butbank.setEnabled(true);
        panelbank.setVisible(false);
        butlimit.setEnabled(true);
        Panellimit.setVisible(false);
    }//GEN-LAST:event_butlistmanagerActionPerformed
    
    private void butlistmanagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butlistmanagerMouseEntered
        
        butlistmanager.setIcon(new ImageIcon("src/images/listmanager1.png"));
    }//GEN-LAST:event_butlistmanagerMouseEntered
    
    private void butlistmanagerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butlistmanagerMouseExited
        
        butlistmanager.setIcon(new ImageIcon("src/images/listmanager.png"));
    }//GEN-LAST:event_butlistmanagerMouseExited
    
    private void butaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaccountMouseEntered
        butaccount.setIcon(new ImageIcon("src/images/account1.png"));
    }//GEN-LAST:event_butaccountMouseEntered
    
    private void butaccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaccountMouseExited
        butaccount.setIcon(new ImageIcon("src/images/account.png"));
    }//GEN-LAST:event_butaccountMouseExited
    
    private void butaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaccountActionPerformed
        
        butaccount.setEnabled(false);
        panelaccount.setVisible(true);
        panelreport.setVisible(false);
        butreport.setEnabled(true);
        txtsearchaccount.setVisible(true);
        cbshowall.setVisible(true);
        butaddaccount.setVisible(true);
        editaccount.setVisible(true);
        deleaccount.setVisible(true);
        butrefreshaccount.setVisible(true);
        butdeposit.setEnabled(true);
        paneldeposit.setVisible(false);
        tableaccount.setVisible(true);
        ReportTable.setVisible(false);
    }//GEN-LAST:event_butaccountActionPerformed
    
    private void butaddaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaddaccountActionPerformed
        lberroraccount.setText("");
        new Add_Account(this, true, this.ManagerID).setVisible(true);
        while (tableaccount.getRowCount() > 0) {
            ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
        }
        RowDataTableAcccount();
        if (cbshowall.isSelected()) {
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            DefaultTableModel model = (DefaultTableModel) tableaccount.getModel();
            while (model.getRowCount() > 0) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    model.removeRow(i);
                }
            }
            try {
                Connect.connectDatabase();
                CallableStatement cs = Connect.connectDatabase().prepareCall("{call Show_Account}");
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Vector dulieu = new Vector();
                    dulieu.add(rs.getString("AccountID"));
                    dulieu.add(rs.getString("Fullname"));
                    String date_s = rs.getString("CreationDate");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                    dulieu.add(dt1.format(date));
                    dulieu.add(rs.getString("BankName"));
                    dulieu.add(rs.getString("Managers_ID"));
                    this.modelaccount.addRow(dulieu);
                }
                setCountAccount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            while (tableaccount.getRowCount() > 0) {
                ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
            }
            RowDataTableAcccount();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            lberroraccount.setText("");
            setCountAccount();
        }
    }//GEN-LAST:event_butaddaccountActionPerformed
    
    private void butrefreshaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butrefreshaccountActionPerformed
        lberroraccount.setText("");
        while (tableaccount.getRowCount() > 0) {
            ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
        }
        RowDataTableAcccount();
        if (cbshowall.isSelected()) {
            setCountAccount();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            DefaultTableModel model = (DefaultTableModel) tableaccount.getModel();
            while (model.getRowCount() > 0) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    model.removeRow(i);
                }
            }
            try {
                Connect.connectDatabase();
                CallableStatement cs = Connect.connectDatabase().prepareCall("{call Show_Account}");
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Vector dulieu = new Vector();
                    dulieu.add(rs.getString("AccountID"));
                    dulieu.add(rs.getString("Fullname"));
                    String date_s = rs.getString("CreationDate");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                    dulieu.add(dt1.format(date));
                    dulieu.add(rs.getString("BankName"));
                    dulieu.add(rs.getString("Managers_ID"));
                    this.modelaccount.addRow(dulieu);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setCountAccount();
        } else {
            while (tableaccount.getRowCount() > 0) {
                ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
            }
            RowDataTableAcccount();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            setCountAccount();
        }
        setCountAccount();
    }//GEN-LAST:event_butrefreshaccountActionPerformed
    
    private void tableaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableaccountMouseClicked
        try {
            if (evt.getClickCount() >= 1) {
                deleaccount.setEnabled(true);
                editaccount.setEnabled(true);
                lberroraccount.setText("");
            }
            int rowIndex = this.tableaccount.convertRowIndexToModel(tableaccount.getSelectedRow());
            if (evt.getClickCount() >= 2 && tableaccount.getSelectedRow() != -1) {
                String account = tableaccount.getModel().getValueAt(rowIndex, 0).toString();
                String accountType = tableaccount.getModel().getValueAt(rowIndex, 4).toString();
                new Edit_Account(this, true, account, ManagerID, accountType).setVisible(true);
                //refesh when update informatin table admin
                DefaultTableModel model = (DefaultTableModel) tableaccount.getModel();
                while (model.getRowCount() > 0) {
                    for (int i = 0; i < model.getRowCount(); i++) {
                        model.removeRow(i);
                    }
                }
                while (tableaccount.getRowCount() > 0) {
                    ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
                }
                RowDataTableAcccount();
                deleaccount.setEnabled(false);
                editaccount.setEnabled(false);
                /// combo box
                if (cbshowall.isSelected()) {
                    
                    deleaccount.setEnabled(false);
                    editaccount.setEnabled(false);
                    
                    while (tableaccount.getRowCount() > 0) {
                        ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
                    }
                    
                    try {
                        Connect.connectDatabase();
                        CallableStatement cs = Connect.connectDatabase().prepareCall("{call Show_Account}");
                        ResultSet rs = cs.executeQuery();
                        while (rs.next()) {
                            Vector dulieu = new Vector();
                            dulieu.add(rs.getString("AccountID"));
                            dulieu.add(rs.getString("Fullname"));
                            String date_s = rs.getString("CreationDate");
                            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            Date date = dt.parse(date_s);
                            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                            dulieu.add(dt1.format(date));
                            dulieu.add(rs.getString("BankName"));
                            dulieu.add(rs.getString("Managers_ID"));
                            this.modelaccount.addRow(dulieu);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    while (tableaccount.getRowCount() > 0) {
                        ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
                    }
                    RowDataTableAcccount();
                    deleaccount.setEnabled(false);
                    editaccount.setEnabled(false);
                    setCountAccount();
                }
            }
        } catch (Exception e) {
            lberroraccount.setText("Please select one table row!");
            editaccount.setEnabled(false);
            deleaccount.setEnabled(false);
        }
    }//GEN-LAST:event_tableaccountMouseClicked
    
    private void txtsearchaccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsearchaccountMouseClicked
        while (tableaccount.getRowCount() > 0) {
            ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
        }
        RowDataTableAcccount();
        butdeletemanager.setEnabled(false);
        butdeletemanager.setEnabled(false);
        deleaccount.setEnabled(false);
        editaccount.setEnabled(false);
        
        
    }//GEN-LAST:event_txtsearchaccountMouseClicked
    
    private void cbshowallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbshowallActionPerformed
        
        if (cbshowall.isSelected()) {
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            DefaultTableModel model = (DefaultTableModel) tableaccount.getModel();
            while (model.getRowCount() > 0) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    model.removeRow(i);
                }
            }
            try {
                Connect.connectDatabase();
                CallableStatement cs = Connect.connectDatabase().prepareCall("{call Show_Account}");
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Vector dulieu = new Vector();
                    dulieu.add(rs.getString("AccountID"));
                    dulieu.add(rs.getString("Fullname"));
                    String date_s = rs.getString("CreationDate");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                    dulieu.add(dt1.format(date));
                    dulieu.add(rs.getString("BankName"));
                    dulieu.add(rs.getString("Managers_ID"));
                    this.modelaccount.addRow(dulieu);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setCountAccount();
        } else {
            
            while (tableaccount.getRowCount() > 0) {
                ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
            }
            RowDataTableAcccount();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            setCountAccount();
        }
    }//GEN-LAST:event_cbshowallActionPerformed
    
    private void editaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaccountActionPerformed
        try {
            lberroraccount.setText("");
            int rowIndex = this.tableaccount.convertRowIndexToModel(tableaccount.getSelectedRow());
            String account = tableaccount.getModel().getValueAt(rowIndex, 0).toString();
            String accountType = tableaccount.getModel().getValueAt(rowIndex, 4).toString();
            new Edit_Account(this, true, account, ManagerID, accountType).setVisible(true);
            //refesh when update informatin table admin
            DefaultTableModel model = (DefaultTableModel) tableaccount.getModel();
            while (model.getRowCount() > 0) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    model.removeRow(i);
                }
            }
            while (tableaccount.getRowCount() > 0) {
                ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
            }
            RowDataTableAcccount();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            /// combo box
            if (cbshowall.isSelected()) {
                setCountAccount();
                deleaccount.setEnabled(false);
                editaccount.setEnabled(false);
                while (model.getRowCount() > 0) {
                    for (int i = 0; i < model.getRowCount(); i++) {
                        model.removeRow(i);
                    }
                }
                try {
                    Connect.connectDatabase();
                    CallableStatement cs = Connect.connectDatabase().prepareCall("{call Show_Account}");
                    ResultSet rs = cs.executeQuery();
                    while (rs.next()) {
                        Vector dulieu = new Vector();
                        dulieu.add(rs.getString("AccountID"));
                        dulieu.add(rs.getString("Fullname"));
                        String date_s = rs.getString("CreationDate");
                        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date = dt.parse(date_s);
                        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                        dulieu.add(dt1.format(date));
                        dulieu.add(rs.getString("BankName"));
                        dulieu.add(rs.getString("Managers_ID"));
                        this.modelaccount.addRow(dulieu);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                
                while (tableaccount.getRowCount() > 0) {
                    ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
                }
                RowDataTableAcccount();
                deleaccount.setEnabled(false);
                editaccount.setEnabled(false);
                lberroraccount.setText("");
                setCountAccount();
            }
            setCountAccount();
        } catch (Exception e) {
            lberroraccount.setText("Please select one table row!");
        }
    }//GEN-LAST:event_editaccountActionPerformed
    
    private void deleaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleaccountActionPerformed
        try {
            String index = String.valueOf(tableaccount.getValueAt(tableaccount.getSelectedRow(), 0).toString());
            Connect.connectDatabase();
            CallableStatement callPROC = Connect.connectDatabase().prepareCall("{call DeleteAccount(?)}");
            callPROC.setString(1, index);
            callPROC.executeUpdate();
            lberroraccount.setText("Delete successfully!");
            while (tablemanager.getRowCount() > 0) {
                ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
            }
            RowDataTableManager();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Can not connect to dadatabse! please check connnection!");
            e.printStackTrace();
        }
        if (cbshowall.isSelected()) {
            setCountAccount();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            DefaultTableModel model = (DefaultTableModel) tableaccount.getModel();
            while (model.getRowCount() > 0) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    model.removeRow(i);
                }
            }
            try {
                Connect.connectDatabase();
                CallableStatement cs = Connect.connectDatabase().prepareCall("{call Show_Account}");
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    
                    Vector dulieu = new Vector();
                    dulieu.add(rs.getString("AccountID"));
                    dulieu.add(rs.getString("Fullname"));
                    
                    String date_s = rs.getString("CreationDate");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date date = dt.parse(date_s);
                    SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
                    dulieu.add(dt1.format(date));
                    dulieu.add(rs.getString("BankName"));
                    dulieu.add(rs.getString("Managers_ID"));
                    this.modelaccount.addRow(dulieu);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            setCountAccount();
        } else {
            while (tableaccount.getRowCount() > 0) {
                ((DefaultTableModel) tableaccount.getModel()).removeRow(0);
            }
            RowDataTableAcccount();
            deleaccount.setEnabled(false);
            editaccount.setEnabled(false);
            setCountAccount();
        }
        setCountAccount();
    }//GEN-LAST:event_deleaccountActionPerformed
    
    private void butaddaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddaccountMouseEntered
        butaddaccount.setIcon(new ImageIcon("src/images/add1.png"));
    }//GEN-LAST:event_butaddaccountMouseEntered
    
    private void butaddaccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddaccountMouseExited
        butaddaccount.setIcon(new ImageIcon("src/images/add.png"));
    }//GEN-LAST:event_butaddaccountMouseExited
    
    private void editaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editaccountMouseEntered
        editaccount.setIcon(new ImageIcon("src/images/edit1.png"));
    }//GEN-LAST:event_editaccountMouseEntered
    
    private void editaccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editaccountMouseExited
        editaccount.setIcon(new ImageIcon("src/images/edit.png"));
    }//GEN-LAST:event_editaccountMouseExited
    
    private void deleaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleaccountMouseEntered
        deleaccount.setIcon(new ImageIcon("src/images/delete1.png"));
    }//GEN-LAST:event_deleaccountMouseEntered
    
    private void deleaccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleaccountMouseExited
        deleaccount.setIcon(new ImageIcon("src/images/delete.png"));
    }//GEN-LAST:event_deleaccountMouseExited
    
    private void butrefreshaccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butrefreshaccountMouseEntered
        butrefreshaccount.setIcon(new ImageIcon("src/images/refresh1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butrefreshaccountMouseEntered
    
    private void butrefreshaccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butrefreshaccountMouseExited
        butrefreshaccount.setIcon(new ImageIcon("src/images/refresh.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butrefreshaccountMouseExited
    
    private void AddmanagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddmanagerMouseEntered
        Addmanager.setIcon(new ImageIcon("src/images/add1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_AddmanagerMouseEntered
    
    private void AddmanagerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddmanagerMouseExited
        Addmanager.setIcon(new ImageIcon("src/images/add.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_AddmanagerMouseExited
    
    private void buteditmanagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buteditmanagerMouseEntered
        buteditmanager.setIcon(new ImageIcon("src/images/edit1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_buteditmanagerMouseEntered
    
    private void buteditmanagerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buteditmanagerMouseExited
        
        buteditmanager.setIcon(new ImageIcon("src/images/edit.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_buteditmanagerMouseExited
    
    private void butdeletemanagerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butdeletemanagerMouseEntered
        
        butdeletemanager.setIcon(new ImageIcon("src/images/delete1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butdeletemanagerMouseEntered
    
    private void butdeletemanagerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butdeletemanagerMouseExited
        butdeletemanager.setIcon(new ImageIcon("src/images/delete.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butdeletemanagerMouseExited
    
    private void butrefeshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butrefeshMouseEntered
        
        butrefesh.setIcon(new ImageIcon("src/images/refresh1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butrefeshMouseEntered
    
    private void butrefeshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butrefeshMouseExited
        butrefesh.setIcon(new ImageIcon("src/images/refresh.png"));
    }//GEN-LAST:event_butrefeshMouseExited
    
    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        
        butdeletemanager.setEnabled(false);
        butdeletemanager.setEnabled(false);
        deleaccount.setEnabled(false);
        editaccount.setEnabled(false);
        setCountLabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed
    
    private void butlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butlogoutMouseClicked
        if (evt.getClickCount() == 1) {
            timel();
            thoigian.start();
            this.setSize(1000, 600);
            new Thread(new DisplayClose(this, 0, 0)).start();
            new Admin_Login().setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butlogoutMouseClicked
    
    private void butadvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butadvanceActionPerformed
        
        new Reportsearching().setVisible(true);
        
    }//GEN-LAST:event_butadvanceActionPerformed
    
    private void butreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butreportActionPerformed
        ReportTable.setVisible(true);
        tableaccount.setVisible(false);
        butreport.setEnabled(false);
        butaccount.setEnabled(true);
        panelreport.setVisible(true);
        txtsearchaccount.setVisible(false);
        cbshowall.setVisible(false);
        butaddaccount.setVisible(false);
        editaccount.setVisible(false);
        deleaccount.setVisible(false);
        butrefreshaccount.setVisible(false);
        butdeposit.setEnabled(true);
        paneldeposit.setVisible(false);
        searchreport.setVisible(true);
        butadvance.setVisible(true);
        butprint.setVisible(true);
        
    }//GEN-LAST:event_butreportActionPerformed
    
    private void butreportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butreportMouseEntered
        
        butreport.setIcon(new ImageIcon("src/images/report1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butreportMouseEntered
    
    private void butreportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butreportMouseExited
        
        butreport.setIcon(new ImageIcon("src/images/report.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butreportMouseExited
    
    private void butbankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butbankMouseEntered
        butbank.setIcon(new ImageIcon("src/images/bank1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butbankMouseEntered
    
    private void butbankMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butbankMouseExited
        butbank.setIcon(new ImageIcon("src/images/bank.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butbankMouseExited
    
    private void butbankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butbankActionPerformed
        butlistmanager.setEnabled(true);
        butbank.setEnabled(false);
        panelaManager.setVisible(false);
        panelbank.setVisible(true);
        butaddbank.setVisible(true);
        butlimit.setEnabled(true);
        Panellimit.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_butbankActionPerformed
    
    private void butprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butprintActionPerformed
        new Print().setVisible(true);
    }//GEN-LAST:event_butprintActionPerformed
    
    private void searchreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchreportActionPerformed
        setCountreport();

        // TODO add your handling code here:
    }//GEN-LAST:event_searchreportActionPerformed
    
    private void txtsearchaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchaccountActionPerformed
        setCountAccount();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchaccountActionPerformed
    
    private void txtsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsearchMouseClicked
        buteditmanager.setEnabled(false);
        butdeletemanager.setEnabled(false);
        while (tablemanager.getRowCount() > 0) {
            ((DefaultTableModel) tablemanager.getModel()).removeRow(0);
        }
        RowDataTableManager();

        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchMouseClicked
    
    private void txtsearchbankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchbankActionPerformed
        setCountBank();


        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchbankActionPerformed
    
    private void ButrefreshbankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButrefreshbankActionPerformed
        
        setCountBank();
        // message will bew losing
        lbbankerror.setText("");
        // refesh row
        while (tablebank.getRowCount() > 0) {
            ((DefaultTableModel) tablebank.getModel()).removeRow(0);
        }
        cellbank();
        buteditbank.setEnabled(false);
        butdeletebank.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_ButrefreshbankActionPerformed
    
    private void butaddbankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddbankMouseClicked
        if (evt.getClickCount() == 1) {
            new Add_Bank(this, true).setVisible(true);

            // message will bew losing
            lbbankerror.setText("");
            // refesh row
            while (tablebank.getRowCount() > 0) {
                ((DefaultTableModel) tablebank.getModel()).removeRow(0);
            }
            cellbank();
            buteditbank.setEnabled(false);
            butdeletebank.setEnabled(false);
            setCountBank();
        }
    }//GEN-LAST:event_butaddbankMouseClicked
    
    private void butaddbankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddbankMouseEntered
        
        butaddbank.setIcon(new ImageIcon("src/images/add1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butaddbankMouseEntered
    
    private void butaddbankMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butaddbankMouseExited
        butaddbank.setIcon(new ImageIcon("src/images/add.png"));


        // TODO add your handling code here:
    }//GEN-LAST:event_butaddbankMouseExited
    
    private void tablebankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebankMouseClicked
        
        if (evt.getClickCount() >= 1) {
            buteditbank.setEnabled(true);
            butdeletebank.setEnabled(true);
            lbbankerror.setText("");
        }
        try {
            int rowIndex = this.tablebank.convertRowIndexToModel(tablebank.getSelectedRow());
            if (evt.getClickCount() >= 2 && tablebank.getSelectedRow() != -1) {
                String Bankname = tablebank.getModel().getValueAt(rowIndex, 0).toString();
                
                new Edit_Bank(this, true, Bankname).setVisible(true);
                //refesh when update informatin table admin
                DefaultTableModel model = (DefaultTableModel) tablebank.getModel();
                while (model.getRowCount() > 0) {
                    for (int i = 0; i < model.getRowCount(); i++) {
                        model.removeRow(i);
                    }
                }
                while (tablebank.getRowCount() > 0) {
                    ((DefaultTableModel) tablebank.getModel()).removeRow(0);
                }
                cellbank();
                buteditbank.setEnabled(false);
                butdeletebank.setEnabled(false);
            }
        } catch (Exception e) {
            buteditbank.setEnabled(false);
            butdeletebank.setEnabled(false);
            lbbankerror.setText("Please select one table row!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tablebankMouseClicked
    
    private void butdeletebankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butdeletebankActionPerformed
        
        try {
            String index = String.valueOf(tablebank.getValueAt(tablebank.getSelectedRow(), 0).toString());
            Connect.connectDatabase();
            CallableStatement callPROC = Connect.connectDatabase().prepareCall("{call DeleteBank(?)}");
            callPROC.setString(1, index);
            callPROC.executeUpdate();
            lbbankerror.setText("Delete successfully!");
            while (tablebank.getRowCount() > 0) {
                ((DefaultTableModel) tablebank.getModel()).removeRow(0);
            }
            cellbank();
            buteditbank.setEnabled(false);
            butdeletebank.setEnabled(false);
            setCountBank();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Can not connect to dadatabse! please check connnection!");
//            e.printStackTrace();
            lbbankerror.setText("Sorry! This Bank Name was used!");
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_butdeletebankActionPerformed
    
    private void buteditbankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buteditbankMouseClicked
        if (evt.getClickCount() == 1) {
            if (evt.getClickCount() >= 1) {
                buteditbank.setEnabled(true);
                butdeletebank.setEnabled(true);
                lbbankerror.setText("");
            }
            try {
                int rowIndex = this.tablebank.convertRowIndexToModel(tablebank.getSelectedRow());
                String Bankname = tablebank.getModel().getValueAt(rowIndex, 0).toString();
                new Edit_Bank(this, true, Bankname).setVisible(true);
                //refesh when update informatin table admin
                DefaultTableModel model = (DefaultTableModel) tablebank.getModel();
                while (model.getRowCount() > 0) {
                    for (int i = 0; i < model.getRowCount(); i++) {
                        model.removeRow(i);
                    }
                }
                while (tablebank.getRowCount() > 0) {
                    ((DefaultTableModel) tablebank.getModel()).removeRow(0);
                }
                cellbank();
                setCountBank();
                buteditbank.setEnabled(false);
                butdeletebank.setEnabled(false);
            } catch (Exception e) {
                buteditbank.setEnabled(false);
                butdeletebank.setEnabled(false);
                lbbankerror.setText("Please select one table row!");
            }
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_buteditbankMouseClicked
    
    private void buteditbankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buteditbankMouseEntered
        
        buteditbank.setIcon(new ImageIcon("src/images/edit1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_buteditbankMouseEntered
    
    private void buteditbankMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buteditbankMouseExited
        buteditbank.setIcon(new ImageIcon("src/images/edit.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_buteditbankMouseExited
    
    private void butdeletebankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butdeletebankMouseEntered
        
        butdeletebank.setIcon(new ImageIcon("src/images/delete1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butdeletebankMouseEntered
    
    private void butdeletebankMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butdeletebankMouseExited
        butdeletebank.setIcon(new ImageIcon("src/images/delete.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butdeletebankMouseExited
    
    private void ButrefreshbankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButrefreshbankMouseEntered
        
        Butrefreshbank.setIcon(new ImageIcon("src/images/refresh1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButrefreshbankMouseEntered
    
    private void ButrefreshbankMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButrefreshbankMouseExited
        
        Butrefreshbank.setIcon(new ImageIcon("src/images/refresh.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_ButrefreshbankMouseExited
    
    private void butadvanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butadvanceMouseEntered
        butadvance.setIcon(new ImageIcon("src/images/advanced1.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butadvanceMouseEntered
    
    private void butadvanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butadvanceMouseExited
        
        butadvance.setIcon(new ImageIcon("src/images/advanced.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butadvanceMouseExited
    
    private void butprintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintMouseEntered
        
        butprint.setIcon(new ImageIcon("src/images/print1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintMouseEntered
    
    private void butprintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintMouseExited
        butprint.setIcon(new ImageIcon("src/images/print.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintMouseExited
    
    private void butdepositMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butdepositMouseEntered
        
        butdeposit.setIcon(new ImageIcon("src/images/deposit1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butdepositMouseEntered
    
    private void butdepositMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butdepositMouseExited
        
        butdeposit.setIcon(new ImageIcon("src/images/deposit.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butdepositMouseExited
    
    private void butdepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butdepositActionPerformed
        butaccount.setEnabled(true);
        butreport.setEnabled(true);
        butdeposit.setEnabled(false);
        paneldeposit.setVisible(true);
        tableaccount.setVisible(false);
        butadvance.setVisible(false);
        butprint.setVisible(false);
        ReportTable.setVisible(false);
        txtsearchaccount.setVisible(false);
        searchreport.setVisible(false);
        panelreport.setVisible(false);
        cbshowall.setVisible(false);
        butaddaccount.setVisible(false);
        editaccount.setVisible(false);
        deleaccount.setVisible(false);
        butrefreshaccount.setVisible(false);
        panelaccount.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_butdepositActionPerformed
    
    private void txtaccountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountKeyPressed
        
        String aa = this.txtaccount.getText();
        if (aa.length() == 4) {
            txtaccount.setText(aa + "-");
        }
        if (aa.length() == 9) {
            txtaccount.setText(aa + "-");
        }
//                 NUMERIC ENTER NUMBER
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtaccount.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtaccount.setText(aa);
            txtaccount.setEditable(true);
        } else {
            txtaccount.setEditable(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountKeyPressed
    String key1;
    String key2;
    String key3;
    
    private void txtaccountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountKeyTyped
        if (evt.getSource().equals(txtaccount)) {
            if (txtaccount.getText().length() > 13) {
                evt.setKeyChar('\n');
            }
        }
    }//GEN-LAST:event_txtaccountKeyTyped
    
    private void txtaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaccountActionPerformed
        
        checkingAccountID();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountActionPerformed
    
    private void txtaccountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountMousePressed
        String aa = this.txtaccount.getText();
        txtaccount.setText(aa);        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountMousePressed
    
    private void txtaccountMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountMouseReleased
        String aa = this.txtaccount.getText();
        txtaccount.setText(aa);        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountMouseReleased
    
    private void butcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butcheckActionPerformed
        
        checkingAccountID();
        // TODO add your handling code here:
    }//GEN-LAST:event_butcheckActionPerformed
    
    private void butcheckMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcheckMouseEntered
        
        butcheck.setIcon(new ImageIcon("src/images/checking1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcheckMouseEntered
    
    private void butcheckMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butcheckMouseExited
        
        butcheck.setIcon(new ImageIcon("src/images/checking.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butcheckMouseExited
    
    private void depositMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositMouseExited
        
        deposit.setIcon(new ImageIcon("src/images/depo.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_depositMouseExited
    
    private void depositMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositMouseEntered
        
        deposit.setIcon(new ImageIcon("src/images/depo1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_depositMouseEntered
    
    private void butclearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butclearMouseEntered
        butclear.setIcon(new ImageIcon("src/images/clear1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butclearMouseEntered
    
    private void butclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butclearMouseExited
        
        butclear.setIcon(new ImageIcon("src/images/clear.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butclearMouseExited
    
    private void combovalueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combovalueActionPerformed
        // TODO add your handling code here:
//        stringcombo = valueModel.getSelectedItem().toString();
//        switch (stringcombo) {
//            case "per Day":
//                System.out.println("You just chose per Day");
//                break;
//            case "per Week":
//                System.out.println("Sorry! The system does not provide this setting for Week Option. Please try another one!");
//                break;
//            case "per Month":
//                System.out.println("You just chose per Month");
//                break;
//            case "per Year":
//                System.out.println("You just chose per Year");
//                break;
//        }
   }//GEN-LAST:event_combovalueActionPerformed
    
    private void combovalueInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_combovalueInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_combovalueInputMethodTextChanged
    
    private void combovaluePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_combovaluePropertyChange
        // TODO add your handling code here:
//        System.out.println("aaa");
    }//GEN-LAST:event_combovaluePropertyChange
    
    private void combovalueVetoableChange(java.beans.PropertyChangeEvent evt) throws java.beans.PropertyVetoException {//GEN-FIRST:event_combovalueVetoableChange
        // TODO add your handling code here: 
    }//GEN-LAST:event_combovalueVetoableChange
    
    private void radiotransactfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiotransactfeeActionPerformed
        // TODO add your handling code here:
        if (radiotransactfee.isSelected() == true) {
            turnfee.setText("0");
            tranfee.setText("");
            tranfee.setEnabled(true);
            turnfee.setEnabled(false);
        }
    }//GEN-LAST:event_radiotransactfeeActionPerformed
    
    private void radioturnfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioturnfeeActionPerformed
        if (radiotransactfee.isSelected() == false) {
            tranfee.setText("0");
            turnfee.setText("");
            tranfee.setEnabled(false);
            turnfee.setEnabled(true);
        }
    }//GEN-LAST:event_radioturnfeeActionPerformed
    
    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        RuleSet();
    }//GEN-LAST:event_changeActionPerformed
    
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        
        Reset();
    }//GEN-LAST:event_clearActionPerformed
    
    private void butlimitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butlimitActionPerformed
        Panellimit.setVisible(true);
        panelbank.setVisible(false);
        panelaManager.setVisible(false);
        butbank.setEnabled(true);
        butlimit.setEnabled(false);
        butlistmanager.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_butlimitActionPerformed
    
    private void butlimitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butlimitMouseEntered
        butlimit.setIcon(new ImageIcon("src/images/limit1.png"));
    }//GEN-LAST:event_butlimitMouseEntered
    
    private void butlimitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butlimitMouseExited
        
        butlimit.setIcon(new ImageIcon("src/images/limit.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butlimitMouseExited
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ShowRecentSetting();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        checkingAccountID();
        if (b == 1) {
            Confirmation();
            checkingAccountID();
        } else {
            lb1.setText("This Account number incorrect!");
        }
        
    }//GEN-LAST:event_depositActionPerformed
    
    private void txtphonebenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphonebenKeyPressed
        
        String aa = this.txtphoneben.getText();
        
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtphoneben.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtphoneben.setText(aa);
            txtphoneben.setEditable(true);
        } else {
            txtphoneben.setEditable(false);
        }
        
        
    }//GEN-LAST:event_txtphonebenKeyPressed
    
    private void txtcardnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcardnoKeyPressed
        
        String aa = this.txtcardno.getText();
        
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtcardno.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtcardno.setText(aa);
            txtcardno.setEditable(true);
        } else {
            txtcardno.setEditable(false);
        }
        
    }//GEN-LAST:event_txtcardnoKeyPressed
    
    private void butclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butclearActionPerformed
        
        ClearText();
        lb1.setText("");
        
    }//GEN-LAST:event_butclearActionPerformed
    
    private void butrefreshreportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butrefreshreportMouseEntered
        
        butrefreshreport.setIcon(new ImageIcon("src/images/refresh1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butrefreshreportMouseEntered
    
    private void butrefreshreportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butrefreshreportMouseExited
        butrefreshreport.setIcon(new ImageIcon("src/images/refresh.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butrefreshreportMouseExited
    
    private void butrefreshreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butrefreshreportActionPerformed
        setCountreport();

        // refesh row
        while (ReportTable.getRowCount() > 0) {
            ((DefaultTableModel) ReportTable.getModel()).removeRow(0);
        }
        LoadingData();

        // TODO add your handling code here:
    }//GEN-LAST:event_butrefreshreportActionPerformed
    
    private void txtcardnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcardnoKeyTyped
        if (evt.getSource().equals(txtcardno)) {
            if (txtcardno.getText().length() > 9) {
                evt.setKeyChar('\n');
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcardnoKeyTyped
    
    private void txtphonebenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtphonebenKeyTyped
        if (evt.getSource().equals(txtcardno)) {
            if (txtcardno.getText().length() > 16) {
                evt.setKeyChar('\n');
            }
        }    // TODO add your handling code here:
    }//GEN-LAST:event_txtphonebenKeyTyped
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addmanager;
    private javax.swing.JButton Butrefreshbank;
    private javax.swing.JLabel Dim;
    private javax.swing.JPanel Panellimit;
    private org.jdesktop.swingx.JXTable ReportTable;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bgbank;
    private javax.swing.JLabel bglimit;
    private javax.swing.JLabel bgmanager;
    private javax.swing.JLabel bgreport;
    private javax.swing.JLabel bgseposit;
    private javax.swing.JButton butaboutus;
    private javax.swing.JButton butaccount;
    private javax.swing.JButton butaddaccount;
    private javax.swing.JButton butaddbank;
    private javax.swing.JButton butadvance;
    private javax.swing.JButton butbank;
    private javax.swing.JButton butcheck;
    private javax.swing.JButton butclear;
    private javax.swing.JButton butdeletebank;
    private javax.swing.JButton butdeletemanager;
    private javax.swing.JButton butdeposit;
    private javax.swing.JButton buteditbank;
    private javax.swing.JButton buteditmanager;
    private javax.swing.JButton butlimit;
    private javax.swing.JButton butlistmanager;
    private javax.swing.JButton butlogout;
    private javax.swing.JButton butprint;
    private javax.swing.JButton butprofile;
    private javax.swing.JButton butrefesh;
    private javax.swing.JButton butrefreshaccount;
    private javax.swing.JButton butrefreshreport;
    private javax.swing.JButton butreport;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbshowall;
    private javax.swing.JButton change;
    private javax.swing.JButton clear;
    private javax.swing.JComboBox combovalue;
    private javax.swing.JLabel countbank;
    private javax.swing.JLabel countreport;
    private javax.swing.JButton deleaccount;
    private javax.swing.JButton deposit;
    private javax.swing.JLabel dimaccount;
    private javax.swing.JButton editaccount;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lbaddress;
    private javax.swing.JLabel lbaddresser;
    private javax.swing.JLabel lbbankerror;
    private javax.swing.JLabel lbbirthday;
    private javax.swing.JButton lbchangepass;
    private javax.swing.JLabel lbclose;
    private javax.swing.JLabel lbdate;
    private javax.swing.JLabel lbemail;
    private javax.swing.JLabel lberroraccount;
    private javax.swing.JLabel lberrordelete;
    private javax.swing.JLabel lberrorwarm;
    private javax.swing.JLabel lbfullname;
    private javax.swing.JLabel lbgender;
    private javax.swing.JLabel lbidcarder;
    private javax.swing.JLabel lbmax;
    private javax.swing.JLabel lbmin;
    private javax.swing.JLabel lbminmin;
    private javax.swing.JLabel lbmoneyer;
    private javax.swing.JLabel lbmoneyvalue;
    private javax.swing.JLabel lbnameer;
    private javax.swing.JLabel lbnameset;
    private javax.swing.JLabel lbphone;
    private javax.swing.JLabel lbphoneer;
    private javax.swing.JLabel lbpositions;
    private javax.swing.JLabel lbtranfee;
    private javax.swing.JLabel lbturnfee;
    private javax.swing.JLabel lbturnnum;
    private javax.swing.JLabel lbturnvalue;
    private javax.swing.JTextField maxmoney;
    private javax.swing.JTextField minmoney;
    private javax.swing.JTextField moneyonvalue;
    private javax.swing.JPanel panelaManager;
    private javax.swing.JPanel panelaccount;
    private javax.swing.JPanel panelbank;
    private javax.swing.JPanel paneldeposit;
    private javax.swing.JPanel panelreport;
    private javax.swing.JRadioButton radiotransactfee;
    private javax.swing.JRadioButton radioturnfee;
    private org.jdesktop.swingx.JXSearchField searchreport;
    private org.jdesktop.swingx.JXTable tableaccount;
    private org.jdesktop.swingx.JXTable tablebank;
    private org.jdesktop.swingx.JXTable tablemanager;
    private javax.swing.JTextField tranfee;
    private javax.swing.JTextField turnfee;
    private javax.swing.JTextField turnnum;
    private javax.swing.JTextField txtaccount;
    private javax.swing.JTextField txtaddressben;
    private javax.swing.JTextField txtcardno;
    private javax.swing.JTextField txtmoneyben;
    private javax.swing.JTextField txtnameben;
    private javax.swing.JTextField txtphoneben;
    private org.jdesktop.swingx.JXSearchField txtsearch;
    private org.jdesktop.swingx.JXSearchField txtsearchaccount;
    private org.jdesktop.swingx.JXSearchField txtsearchbank;
    // End of variables declaration//GEN-END:variables
    int b = 0;
    
    public void checkingAccountID() {
        try {
            Connect.connectDatabase();
            CallableStatement ct = Connect.connectDatabase().prepareCall("{call AccountShow(?)}");
            String charac = this.txtaccount.getText();
            if (charac.length() < 14) {
                lb1.setText("You must enter the full 12-digit");
            } else {
                lb1.setText("");
                key1 = txtaccount.getText().charAt(0) + "" + txtaccount.getText().charAt(1) + "" + txtaccount.getText().charAt(2) + "" + txtaccount.getText().charAt(3);
                key2 = txtaccount.getText().charAt(5) + "" + txtaccount.getText().charAt(6) + "" + txtaccount.getText().charAt(7) + "" + txtaccount.getText().charAt(8);
                key3 = txtaccount.getText().charAt(10) + "" + txtaccount.getText().charAt(11) + "" + txtaccount.getText().charAt(12) + "" + txtaccount.getText().charAt(13);
                String stringkey = key1 + key2 + key3;
                ct.setString(1, stringkey);
                
                ResultSet ret = ct.executeQuery();
                int a = 0;
                while (ret.next()) {
                    a++;
                    if (a == 1) {
                        lb1.setText(ret.getString("Fullname").toString());
                        b = 1;
                    } else {
                        lb1.setText("This Account number incorrect!");
                        b = 0;
                    }
                }
                if (a != 1) {
                    lb1.setText("This Account number incorrect!");
                }
            }
        } catch (Exception ex) {
            lb1.setText("This Account number incorrect!");
        }
    }
    
    public void AddDeposit() {
        
        key1 = txtaccount.getText().charAt(0) + "" + txtaccount.getText().charAt(1) + "" + txtaccount.getText().charAt(2) + "" + txtaccount.getText().charAt(3);
        key2 = txtaccount.getText().charAt(5) + "" + txtaccount.getText().charAt(6) + "" + txtaccount.getText().charAt(7) + "" + txtaccount.getText().charAt(8);
        key3 = txtaccount.getText().charAt(10) + "" + txtaccount.getText().charAt(11) + "" + txtaccount.getText().charAt(12) + "" + txtaccount.getText().charAt(13);
        String stringkey = key1 + key2 + key3;
        try {
            Connect.connectDatabase();
            CallableStatement trc = Connect.connectDatabase().prepareCall("{call InsertDEPOSIT(?,?,?,?,?,?,?,?,?,?)}");
            
            trc.setString(1, txtnameben.getText().toString());
            trc.setString(2, this.txtcardno.getText().toString());
            trc.setString(3, this.txtaddressben.getText().toString());
            trc.setString(4, this.txtphoneben.getText().toString());
            
            trc.setString(5, cr);
            trc.setString(6, stringkey);
            trc.setFloat(7, Float.parseFloat(this.txtmoneyben.getText().toString()));
            trc.setFloat(8, 0);
            trc.setFloat(9, Float.parseFloat(this.txtmoneyben.getText().toString()));
            trc.setString(10, null);
            
            trc.executeUpdate();
            
            CallableStatement clt = Connect.connectDatabase().prepareCall("{call DepositAccount(?,?,?,?)}");
            trc.setString(1, txtnameben.getText().toString());
            trc.setString(2, this.txtcardno.getText().toString());
            trc.setString(3, this.txtaddressben.getText().toString());
            trc.setString(4, this.txtphoneben.getText().toString());
            
        } catch (Exception ex) {
            lb1.setText("This Account number incorrect!");
        }
        
    }
    
    public void DepositMoney() {
        
        key1 = txtaccount.getText().charAt(0) + "" + txtaccount.getText().charAt(1) + "" + txtaccount.getText().charAt(2) + "" + txtaccount.getText().charAt(3);
        key2 = txtaccount.getText().charAt(5) + "" + txtaccount.getText().charAt(6) + "" + txtaccount.getText().charAt(7) + "" + txtaccount.getText().charAt(8);
        key3 = txtaccount.getText().charAt(10) + "" + txtaccount.getText().charAt(11) + "" + txtaccount.getText().charAt(12) + "" + txtaccount.getText().charAt(13);
        String stringkey = key1 + key2 + key3;
        try {
            Connect.connectDatabase();
            CallableStatement cat = Connect.connectDatabase().prepareCall("{call Show_Account}");
            ResultSet rst = cat.executeQuery();
            CallableStatement cast = Connect.connectDatabase().prepareCall("{call showDEPOSIT2(?,?)}");
            CallableStatement ct = Connect.connectDatabase().prepareCall("{call DepositIntoAccount(?,?)}");
            while (rst.next()) {
                if (stringkey.equals(rst.getString("AccountID").toString())) {
                    
                    CallableStatement clt = Connect.connectDatabase().prepareCall("{call InsertREPORTS(?,?,?,?,?,?,?,?,?)}");
                    clt.setString(1, "");
                    clt.setString(2, rst.getString("AccountID").toString());
                    clt.setString(3, rst.getString("Fullname").toString());
                    clt.setString(4, "DEPOSITED");
                    clt.setFloat(5, Float.parseFloat(txtmoneyben.getText().toString()));
                    clt.setString(6, stringkey);
                    clt.setFloat(7, rst.getFloat("AccountBalance"));
                    clt.setString(8, cr);
                    clt.setString(9, null);
                    int reportinsert = clt.executeUpdate();
                    
                    ct.setString(1, stringkey);
                    ct.setFloat(2, rst.getFloat("AccountBalance") + Float.parseFloat(this.txtmoneyben.getText()));
                    int in = ct.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Successfully deposited!");
                    butclearActionPerformed(null);
                    
                }
            }
        } catch (Exception E) {
//            E.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errors! Wrong data input!");
        }
        
    }
    
    public void Confirmation() {
        if (checkemptyinput()) {
            int Cpane = JOptionPane.showConfirmDialog(null, "Are you sure you to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (Cpane == JOptionPane.YES_OPTION) {
                AddDeposit();
                DepositMoney();
                
            } else if (Cpane == JOptionPane.NO_OPTION) {
            }
        }
    }
    
    boolean checkemptyinput() {
        
        if (txtaccount.getText().toString().length() < 14) {
            lb1.setText("<html>You must input the full 12-digit code</html>");
            return false;
        } else {
            lb1.setText("");
        }
        
        if (txtnameben.getText().toString().equals("")) {
            lbnameer.setText("Name textfield must not be remained empty.");
            return false;
        } else {
            lbnameer.setText("");
        }
        if (txtcardno.getText().toString().equals("")) {
            lbidcarder.setText("ID Card No. textfield must not be remained empty.");
            return false;
        } else {
            lbidcarder.setText("");
        }
        
        if (txtphoneben.getText().toString().equals("")) {
            lbphoneer.setText("Phone textfield must not be remained empty.");
            return false;
        } else {
            lbphoneer.setText("");
        }
        
        if (txtaddressben.getText().toString().equals("")) {
            lbaddresser.setText("Address textfield must not be remained empty.");
            return false;
        } else {
            lbaddresser.setText("");
        }
        
        if (txtmoneyben.getText().toString().equals("")) {
            lbmoneyer.setText("Amount of mouney textfield must not be remained empty.");
            return false;
        } else {
            lbmoneyer.setText("");
        }
        
        
        
        
        
        
        return true;
        
    }
    
    public void ClearText() {
        
        txtaccount.setText("");
        txtaddressben.setText("");
        txtphoneben.setText("");
        txtcardno.setText("");
        txtnameben.setText("");
        txtmoneyben.setText("");
        lbnameer.setText("");
        lbidcarder.setText("");
        lbphoneer.setText("");
        lbaddresser.setText("");
        lbmoneyer.setText("");
    }
}
