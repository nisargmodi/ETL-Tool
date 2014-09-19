/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krima
 */
public class clearTransform {
    
    public static void main(String a[]){
        try {
            Connection con=SQLDBConnect.ConnectDB("dwm");
            Statement st=con.createStatement();
            String name="customer";
            String sql="update metadata set split=0,missing=0,zone=0 where name='"+name+"';";
            st.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(clearTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}