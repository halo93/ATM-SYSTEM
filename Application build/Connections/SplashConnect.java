package Connections;

import Guide.ConfigToServer;
import Guide.Admin_Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SplashConnect extends JWindow {

    private int percent = 0;
    private Timer time;
    private JProgressBar progessBar;
    private JLabel splashImage;
    private JLabel lb;

    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        int width = 400;
        int height = 120;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        splashImage = new JLabel();
        lb = new JLabel();
        lb.setIcon(new ImageIcon(getClass().getResource("/images/plash.gif")));
        progessBar = new javax.swing.JProgressBar();
        progessBar.setForeground(Color.GREEN);
        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                percent += (Math.random() * 20);
                if (percent > 50) {
                    boolean flag = true;
                    try {
                        Connect.connectDatabase().equals(flag);
                    } catch (Exception exception) {
                        flag = false;
                        time.stop();
                        dispose();
                        System.out.println("can not to connect!");
                        JOptionPane.showMessageDialog(rootPane, "Can not connect to databse!");
                        ConfigToServer ss = new ConfigToServer();
                        ss.setVisible(true);
                    }
                }
                if (percent >= 100) {
                    time.stop();
                    dispose();
                    new Admin_Login().setVisible(true);
//                    JOptionPane.showMessageDialog(rootPane, "connect thành công");
                }
                progessBar.setValue(percent);
            }
        };
        // call action every 200 ms
        time = new Timer(300, action);
        progessBar.setValue(0);
        // timer starts
        time.start();
        content.add(splashImage, BorderLayout.CENTER);
        // create a panel to contain the label and the progess bar
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(lb, BorderLayout.PAGE_START);
//        panel.add(progessBar, BorderLayout.PAGE_END);
        content.add(panel, BorderLayout.SOUTH);
        // Display it
        setVisible(true);
    }
//    public static void main(String[] args) {
//        SplashConnect aaa = new SplashConnect();
//        aaa.showSplash();
//    }
}
