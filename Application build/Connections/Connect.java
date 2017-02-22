package Connections;


import Guide.ConfigToServer;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connect {

    Statement sta;
    ResultSet rs;
    java.sql.Connection con;
    String url;

    public Connect() throws Exception {
        File file = new File("connect.cfg");
        if (file.exists()) {
            con = connectDatabase();
        } else {
            new ConfigToServer().setVisible(true);
        }
    }

    public static java.sql.Connection connectDatabase() throws Exception {
        java.sql.Connection con = null;
        try {

            ////
            FileReader fr = new FileReader("connect.cfg");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] arrStrings = new String[5];
            int i = 0;
            while ((line = br.readLine()) != null) {
                arrStrings[i] = line;
                i++;
            }
            br.close();
            fr.close();
            ///decrypt inline
            String server = arrStrings[0];
            String port = arrStrings[1];
            String userSQL = arrStrings[2];
            String passSQL = arrStrings[3];
            String database = arrStrings[4];
            ///////
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://" + server + ":" + port + ";username=" + userSQL + ";password=" + passSQL + ";database=" + database + ";";
            con = DriverManager.getConnection(url);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Cannot found connect ");
        } catch (IOException iOException) {
            System.out.println("Cannot file coonnect ");
        } catch (ClassNotFoundException classNotFoundException) {
            JOptionPane.showMessageDialog(null, "Did you forget to import the jdbc4 library? ");
        } catch (SQLException eSQLException) {
            System.out.println("Cannot connect to database");
        }
        return con;
    }

    void closeConnect() {
        try {
            rs.close();
            sta.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Can not connect to Databse");
        }
    }
}
