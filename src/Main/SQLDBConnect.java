/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author $ujen
 */
public class SQLDBConnect {
    static Connection conn;
    public static Connection ConnectDB(String DBName){
        try {
             Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost/"+DBName,"root","");
            return conn;
        } catch (Exception e) {
            //Logger.getLogger(SQLDBConnect.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
         return null;
        }
    }
    
    public static Connection accessConnect(String DBName){
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

                String accessFileName = DBName;

                String connURL="jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+accessFileName;
            try {
                conn = DriverManager.getConnection(connURL, "","");
            } catch (SQLException ex) {
                Logger.getLogger(SQLDBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
        
    }
    

}
