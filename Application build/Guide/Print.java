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
import java.io.InputStream;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ngo Luan
 */
public class Print extends javax.swing.JFrame {

    /**
     * Creates new form Print
     */
    public Print() {
        setUndecorated(true);
        initComponents();
        this.setSize(0, 0);
        new Thread(new DisplayOpen(this, 720, 490)).start();
        panelmonth.setVisible(false);
        panelyear.setVisible(false);
        butprintall.setEnabled(false);
    }
    Timer thoigian;
    Integer second;

    public void timeclose() {

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

        jTabbedPane3 = new javax.swing.JTabbedPane();
        butprintall = new javax.swing.JButton();
        butprintmont = new javax.swing.JButton();
        butprintyear = new javax.swing.JButton();
        panelyear = new javax.swing.JPanel();
        txtyear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtaccountyear = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbyearerror = new javax.swing.JLabel();
        panelmonth = new javax.swing.JPanel();
        cbmonth = new javax.swing.JComboBox();
        printmontly = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtyearmontly = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtaccountmonth = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        labelmonterror = new javax.swing.JLabel();
        panelall = new javax.swing.JPanel();
        printall = new javax.swing.JButton();
        txtaccountall = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lberror1 = new javax.swing.JLabel();
        lbclose = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butprintall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/butprint.png"))); // NOI18N
        butprintall.setBorderPainted(false);
        butprintall.setContentAreaFilled(false);
        butprintall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butprintall.setDefaultCapable(false);
        butprintall.setFocusPainted(false);
        butprintall.setFocusable(false);
        butprintall.setRequestFocusEnabled(false);
        butprintall.setRolloverEnabled(false);
        butprintall.setVerifyInputWhenFocusTarget(false);
        butprintall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butprintallMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butprintallMouseExited(evt);
            }
        });
        butprintall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butprintallActionPerformed(evt);
            }
        });
        getContentPane().add(butprintall, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 70));

        butprintmont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/butprintmont.png"))); // NOI18N
        butprintmont.setBorderPainted(false);
        butprintmont.setContentAreaFilled(false);
        butprintmont.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butprintmont.setDefaultCapable(false);
        butprintmont.setFocusPainted(false);
        butprintmont.setFocusable(false);
        butprintmont.setRequestFocusEnabled(false);
        butprintmont.setRolloverEnabled(false);
        butprintmont.setVerifyInputWhenFocusTarget(false);
        butprintmont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butprintmontMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butprintmontMouseExited(evt);
            }
        });
        butprintmont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butprintmontActionPerformed(evt);
            }
        });
        getContentPane().add(butprintmont, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 130, 70));

        butprintyear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/butprintyear.png"))); // NOI18N
        butprintyear.setBorderPainted(false);
        butprintyear.setContentAreaFilled(false);
        butprintyear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butprintyear.setDefaultCapable(false);
        butprintyear.setFocusPainted(false);
        butprintyear.setFocusable(false);
        butprintyear.setRequestFocusEnabled(false);
        butprintyear.setRolloverEnabled(false);
        butprintyear.setVerifyInputWhenFocusTarget(false);
        butprintyear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butprintyearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butprintyearMouseExited(evt);
            }
        });
        butprintyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butprintyearActionPerformed(evt);
            }
        });
        getContentPane().add(butprintyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 130, 70));

        panelyear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtyear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtyearKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtyearKeyTyped(evt);
            }
        });
        panelyear.add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Year:");
        panelyear.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        print.setBorderPainted(false);
        print.setContentAreaFilled(false);
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.setDefaultCapable(false);
        print.setFocusPainted(false);
        print.setFocusable(false);
        print.setRequestFocusEnabled(false);
        print.setRolloverEnabled(false);
        print.setVerifyInputWhenFocusTarget(false);
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printMouseEntered(evt);
            }
        });
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        panelyear.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 120, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Note :");
        panelyear.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 74, -1, 20));

        jLabel5.setText("Enter years before entering print.");
        panelyear.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 230, 30));

        txtaccountyear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtaccountyear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtaccountyearMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtaccountyearMousePressed(evt);
            }
        });
        txtaccountyear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaccountyearKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaccountyearKeyTyped(evt);
            }
        });
        panelyear.add(txtaccountyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 220, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Account :");
        panelyear.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));
        panelyear.add(lbyearerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 370, 30));

        getContentPane().add(panelyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 660, 310));

        panelmonth.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        panelmonth.add(cbmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 90, -1));

        printmontly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printmontly.setBorderPainted(false);
        printmontly.setContentAreaFilled(false);
        printmontly.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printmontly.setDefaultCapable(false);
        printmontly.setFocusPainted(false);
        printmontly.setFocusable(false);
        printmontly.setRequestFocusEnabled(false);
        printmontly.setRolloverEnabled(false);
        printmontly.setVerifyInputWhenFocusTarget(false);
        printmontly.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printmontlyMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printmontlyMouseEntered(evt);
            }
        });
        printmontly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printmontlyActionPerformed(evt);
            }
        });
        panelmonth.add(printmontly, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 120, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Monthly :");
        panelmonth.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        txtyearmontly.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtyearmontlyKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtyearmontlyKeyTyped(evt);
            }
        });
        panelmonth.add(txtyearmontly, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 100, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Year :");
        panelmonth.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 20));

        txtaccountmonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtaccountmonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtaccountmonthMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtaccountmonthMousePressed(evt);
            }
        });
        txtaccountmonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaccountmonthKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaccountmonthKeyTyped(evt);
            }
        });
        panelmonth.add(txtaccountmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 270, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Account:");
        panelmonth.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        labelmonterror.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelmonterror.setForeground(new java.awt.Color(204, 0, 0));
        panelmonth.add(labelmonterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 400, 30));

        getContentPane().add(panelmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 660, 310));

        panelall.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/print.png"))); // NOI18N
        printall.setBorderPainted(false);
        printall.setContentAreaFilled(false);
        printall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printall.setDefaultCapable(false);
        printall.setFocusPainted(false);
        printall.setFocusable(false);
        printall.setRequestFocusEnabled(false);
        printall.setRolloverEnabled(false);
        printall.setVerifyInputWhenFocusTarget(false);
        printall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printallMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printallMouseEntered(evt);
            }
        });
        printall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printallActionPerformed(evt);
            }
        });
        panelall.add(printall, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 120, 40));

        txtaccountall.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtaccountall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtaccountallMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtaccountallMouseReleased(evt);
            }
        });
        txtaccountall.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaccountallKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtaccountallKeyTyped(evt);
            }
        });
        panelall.add(txtaccountall, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 280, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Account :");
        panelall.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        lberror1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lberror1.setForeground(new java.awt.Color(204, 0, 0));
        panelall.add(lberror1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 380, 50));

        getContentPane().add(panelall, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 660, 310));

        lbclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close1.png"))); // NOI18N
        lbclose.setToolTipText("Close");
        lbclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbcloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbcloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbcloseMouseExited(evt);
            }
        });
        getContentPane().add(lbclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, 20));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgprint.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbcloseMouseClicked
        if (evt.getClickCount() == 1) {
            timeclose();
            thoigian.start();
            this.setSize(720, 490);
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

    private void butprintallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintallMouseEntered

        butprintall.setIcon(new ImageIcon("src/images/butprint1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintallMouseEntered

    private void butprintallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintallMouseExited

        butprintall.setIcon(new ImageIcon("src/images/butprint.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintallMouseExited

    private void butprintmontMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintmontMouseEntered

        butprintmont.setIcon(new ImageIcon("src/images/butprintmont1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintmontMouseEntered

    private void butprintmontMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintmontMouseExited
        butprintmont.setIcon(new ImageIcon("src/images/butprintmont.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintmontMouseExited

    private void butprintyearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintyearMouseEntered

        butprintyear.setIcon(new ImageIcon("src/images/butprintyear1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintyearMouseEntered

    private void butprintyearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butprintyearMouseExited
        butprintyear.setIcon(new ImageIcon("src/images/butprintyear.png"));

        // TODO add your handling code here:
    }//GEN-LAST:event_butprintyearMouseExited

    private void butprintallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butprintallActionPerformed
        butprintall.setEnabled(false);
        butprintmont.setEnabled(true);
        butprintyear.setEnabled(true);
        panelall.setVisible(true);
        panelmonth.setVisible(false);
        panelyear.setVisible(false);
        cbmonth.setVisible(false);
        txtyearmontly.setVisible(false);
        printmontly.setVisible(false);
        txtyear.setVisible(false);
        printall.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_butprintallActionPerformed

    private void butprintmontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butprintmontActionPerformed
        butprintall.setEnabled(true);
        butprintmont.setEnabled(false);
        butprintyear.setEnabled(true);
        panelall.setVisible(false);
        panelmonth.setVisible(true);
        panelyear.setVisible(false);
        cbmonth.setVisible(true);
        txtyearmontly.setVisible(true);
        printmontly.setVisible(true);
        printall.setVisible(false);
        txtyear.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintmontActionPerformed

    private void butprintyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butprintyearActionPerformed
        butprintall.setEnabled(true);
        butprintmont.setEnabled(true);
        butprintyear.setEnabled(false);
        cbmonth.setVisible(false);
        txtyearmontly.setVisible(false);
        printmontly.setVisible(false);
        txtyear.setVisible(true);
        panelall.setVisible(false);
        panelmonth.setVisible(false);
        panelyear.setVisible(true);
        printall.setVisible(false);
///
        // TODO add your handling code here:
    }//GEN-LAST:event_butprintyearActionPerformed

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered

        print.setIcon(new ImageIcon("src/images/print1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_printMouseEntered

    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited

        print.setIcon(new ImageIcon("src/images/print.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_printMouseExited

    private void printmontlyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printmontlyMouseEntered
        printmontly.setIcon(new ImageIcon("src/images/print1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_printmontlyMouseEntered

    private void printmontlyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printmontlyMouseExited

        printmontly.setIcon(new ImageIcon("src/images/print.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_printmontlyMouseExited

    private void printallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printallMouseEntered

        printall.setIcon(new ImageIcon("src/images/print1.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_printallMouseEntered

    private void printallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printallMouseExited

        printall.setIcon(new ImageIcon("src/images/print.png"));
        // TODO add your handling code here:
    }//GEN-LAST:event_printallMouseExited
    String keyall1;
    String keyall2;
    String keyall3;
    private void printallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printallActionPerformed
        String charac = this.txtaccountall.getText();
        if (charac.length() < 14) {
            lberror1.setText("You must enter the full 12-digit");
        } else {
            lberror1.setText("");

            keyall1 = txtaccountall.getText().charAt(0) + "" + txtaccountall.getText().charAt(1) + "" + txtaccountall.getText().charAt(2) + "" + txtaccountall.getText().charAt(3);
            keyall2 = txtaccountall.getText().charAt(5) + "" + txtaccountall.getText().charAt(6) + "" + txtaccountall.getText().charAt(7) + "" + txtaccountall.getText().charAt(8);
            keyall3 = txtaccountall.getText().charAt(10) + "" + txtaccountall.getText().charAt(11) + "" + txtaccountall.getText().charAt(12) + "" + txtaccountall.getText().charAt(13);
            String stringkey = keyall1 + keyall2 + keyall3;
            try {
                String reportName = "report/reportall.jasper";
                HashMap map = new HashMap();
                map.put("AccountID", stringkey);
                //  map.put("Ten", "Ten");
//            map.put("Givoitinh", "Gioitinh");
//            map.put("Namsinh", "Namsinh");
//            map.put("Diachi", "Diachi ");

                InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
                JasperPrint jasperPrint = JasperFillManager.fillReport(is, map, Connect.connectDatabase());
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_printallActionPerformed
    String keymontly1;
    String keymontly2;
    String keymontly3;
    private void printmontlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printmontlyActionPerformed
        String charac = this.txtaccountmonth.getText();
        if (charac.length() < 14) {
            labelmonterror.setText("You must enter the full 12-digit");
        } else {
            labelmonterror.setText("");
            keymontly1 = txtaccountmonth.getText().charAt(0) + "" + txtaccountmonth.getText().charAt(1) + "" + txtaccountmonth.getText().charAt(2) + "" + txtaccountmonth.getText().charAt(3);
            keymontly2 = txtaccountmonth.getText().charAt(5) + "" + txtaccountmonth.getText().charAt(6) + "" + txtaccountmonth.getText().charAt(7) + "" + txtaccountmonth.getText().charAt(8);
            keymontly3 = txtaccountmonth.getText().charAt(10) + "" + txtaccountmonth.getText().charAt(11) + "" + txtaccountmonth.getText().charAt(12) + "" + txtaccountmonth.getText().charAt(13);
            String stringkey = keymontly1 + keymontly2 + keymontly3;
            try {
                String reportName = "report/reportmonth.jasper";

                HashMap map = new HashMap();
                map.put("AccountID", stringkey);
                map.put("thang", cbmonth.getSelectedItem().toString());
                map.put("nam", txtyearmontly.getText());
//            map.put("Namsinh", "Namsinh");
//            map.put("Diachi", "Diachi ");

                InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
                JasperPrint jasperPrint = JasperFillManager.fillReport(is, map, Connect.connectDatabase());

                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_printmontlyActionPerformed
    String key1;
    String key2;
    String key3;

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed

        String charac = this.txtaccountyear.getText();
        if (charac.length() < 14) {
            lbyearerror.setText("You must enter the full 12-digit");
        } else {
            lbyearerror.setText("");

            key1 = txtaccountyear.getText().charAt(0) + "" + txtaccountyear.getText().charAt(1) + "" + txtaccountyear.getText().charAt(2) + "" + txtaccountyear.getText().charAt(3);

            key2 = txtaccountyear.getText().charAt(5) + "" + txtaccountyear.getText().charAt(6) + "" + txtaccountyear.getText().charAt(7) + "" + txtaccountyear.getText().charAt(8);

            key3 = txtaccountyear.getText().charAt(10) + "" + txtaccountyear.getText().charAt(11) + "" + txtaccountyear.getText().charAt(12) + "" + txtaccountyear.getText().charAt(13);
            String stringkey = key1 + key2 + key3;
            try {
                String reportName = "Report/reportyear.jasper";

                HashMap map = new HashMap();
                map.put("account", stringkey);
                map.put("nam", txtyear.getText());
//            map.put("Namsinh", "Namsinh");
//            map.put("Diachi", "Diachi ");

                InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
                JasperPrint jasperPrint = JasperFillManager.fillReport(is, map, Connect.connectDatabase());

                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_printActionPerformed

    private void txtaccountallKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountallKeyPressed

        String aa = this.txtaccountall.getText();
        if (aa.length() == 4) {
            txtaccountall.setText(aa + "-");
        }
        if (aa.length() == 9) {
            txtaccountall.setText(aa + "-");
        }
//                 NUMERIC ENTER NUMBER
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtaccountall.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtaccountall.setText(aa);
            txtaccountall.setEditable(true);
        } else {
            txtaccountall.setEditable(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountallKeyPressed

    private void txtaccountallKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountallKeyTyped

        if (evt.getSource().equals(txtaccountall)) {
            if (txtaccountall.getText().length() > 13) {
                evt.setKeyChar('\n');
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountallKeyTyped

    private void txtaccountallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountallMousePressed
        String aa = this.txtaccountall.getText();
        txtaccountall.setText(aa);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountallMousePressed

    private void txtaccountallMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountallMouseReleased
        String aa = this.txtaccountall.getText();
        txtaccountall.setText(aa);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountallMouseReleased

    private void txtyearmontlyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyearmontlyKeyTyped
        if (evt.getSource().equals(txtyearmontly)) {
            if (txtyearmontly.getText().length() > 3) {
                evt.setKeyChar('\n');
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearmontlyKeyTyped

    private void txtaccountmonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountmonthKeyPressed
        String aa = this.txtaccountmonth.getText();
        if (aa.length() == 4) {
            txtaccountmonth.setText(aa + "-");
        }
        if (aa.length() == 9) {
            txtaccountmonth.setText(aa + "-");
        }
//                 NUMERIC ENTER NUMBER
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtaccountmonth.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtaccountmonth.setText(aa);
            txtaccountmonth.setEditable(true);
        } else {
            txtaccountmonth.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountmonthKeyPressed

    private void txtaccountmonthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountmonthKeyTyped
        if (evt.getSource().equals(txtaccountmonth)) {
            if (txtaccountmonth.getText().length() > 13) {
                evt.setKeyChar('\n');
            }
        }
    }//GEN-LAST:event_txtaccountmonthKeyTyped

    private void txtaccountmonthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountmonthMousePressed
        String aa = this.txtaccountmonth.getText();
        txtaccountmonth.setText(aa);        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountmonthMousePressed

    private void txtaccountmonthMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountmonthMouseReleased
        String aa = this.txtaccountmonth.getText();
        txtaccountmonth.setText(aa);        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountmonthMouseReleased

    private void txtaccountyearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountyearKeyPressed
        String aa = this.txtaccountyear.getText();
        if (aa.length() == 4) {
            txtaccountyear.setText(aa + "-");
        }
        if (aa.length() == 9) {
            txtaccountyear.setText(aa + "-");
        }
//                 NUMERIC ENTER NUMBER
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtaccountyear.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtaccountyear.setText(aa);
            txtaccountyear.setEditable(true);
        } else {
            txtaccountyear.setEditable(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountyearKeyPressed

    private void txtyearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyearKeyTyped

        if (evt.getSource().equals(txtyear)) {
            if (txtyear.getText().length() > 3) {
                evt.setKeyChar('\n');
            }
        }
    }//GEN-LAST:event_txtyearKeyTyped

    private void txtyearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyearKeyPressed
        String aa = this.txtyear.getText();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtyear.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtyear.setText(aa);
            txtyear.setEditable(true);
        } else {
            txtyear.setEditable(false);
        }
    }//GEN-LAST:event_txtyearKeyPressed

    private void txtaccountyearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaccountyearKeyTyped
        if (evt.getSource().equals(txtaccountyear)) {
            if (txtaccountyear.getText().length() > 13) {
                evt.setKeyChar('\n');
            }
        }
    }//GEN-LAST:event_txtaccountyearKeyTyped

    private void txtaccountyearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountyearMousePressed
        String aa = this.txtaccountyear.getText();
        txtaccountyear.setText(aa);        // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountyearMousePressed

    private void txtaccountyearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtaccountyearMouseReleased
        String aa = this.txtaccountyear.getText();
        txtaccountyear.setText(aa);         // TODO add your handling code here:
    }//GEN-LAST:event_txtaccountyearMouseReleased

    private void txtyearmontlyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyearmontlyKeyPressed
        String aa = this.txtyearmontly.getText();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            txtyearmontly.setEditable(true);
        } else if (evt.getKeyCode() == 8) {
            txtyearmontly.setText(aa);
            txtyearmontly.setEditable(true);
        } else {
            txtyearmontly.setEditable(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearmontlyKeyPressed
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /*
//         * Set the Nimbus look and feel
//         */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /*
//         * If Nimbus (introduced in Java SE 6) is not available, stay with the
//         * default look and feel. For details see
//         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /*
//         * Create and display the form
//         */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new Print().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton butprintall;
    private javax.swing.JButton butprintmont;
    private javax.swing.JButton butprintyear;
    private javax.swing.JComboBox cbmonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel labelmonterror;
    private javax.swing.JLabel lbclose;
    private javax.swing.JLabel lberror1;
    private javax.swing.JLabel lbyearerror;
    private javax.swing.JPanel panelall;
    private javax.swing.JPanel panelmonth;
    private javax.swing.JPanel panelyear;
    private javax.swing.JButton print;
    private javax.swing.JButton printall;
    private javax.swing.JButton printmontly;
    private javax.swing.JTextField txtaccountall;
    private javax.swing.JTextField txtaccountmonth;
    private javax.swing.JTextField txtaccountyear;
    private javax.swing.JTextField txtyear;
    private javax.swing.JTextField txtyearmontly;
    // End of variables declaration//GEN-END:variables
}
