
package transformationfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Main.SQLDBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Metadata {

    Connection con=SQLDBConnect.ConnectDB("dwm");
    
    public static void main(String a[]){
        new Metadata();
    }

//    public Metadata() {
//        
//        updateMetadataRow("vendorGen.txt", "zone", 1);
//        if(checkTranform("vendorGen.txt", "missing")){
//            
//        }
//        else{
//        }
//        
//        if(checkInput("customer.txt")){
//            JOptionPane.showMessageDialog(null, "Some Transformation has already been done", "Information", JOptionPane.ERROR_MESSAGE);
//        }
//        
//    }
    
    
    

    
//    to check whether particular tranformation has been done or not
    public boolean checkTranform(String input_table,String s){
        try {
            Statement st=con.createStatement();
            String sql="select * from metadata";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                if(input_table.contains(rs.getString("name"))){
                    if(rs.getString(s).equalsIgnoreCase("1")){
                        JOptionPane.showMessageDialog(null, s.toUpperCase()+" transformation has already been done", "Information", JOptionPane.ERROR_MESSAGE);
                        return true;
                        
                    }
                }
            }
            
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
//    to check whether any transformation has been applied or not
    public boolean checkInput(String input_table){
         try {
            Statement st=con.createStatement();
            String sql="select * from metadata";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                if(input_table.contains(rs.getString("name"))){
                    if(rs.getString(3).equalsIgnoreCase("1")||rs.getString(4).equalsIgnoreCase("1")||rs.getString(5).equalsIgnoreCase("1")){
                        return true;
                        
                    }
                }
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        public void updateMetadataRow(String rowName,String colName,int value){
        try {
            if(rowName.contains("vendor")){
                rowName="vendor";
            }
            else if(rowName.contains("customer")){
                rowName="customer";
            }
            else if(rowName.contains("product")){
                rowName="products";
            }
            Statement st=con.createStatement();
            String sql="update metadata "
                    + "set "+colName+"='"+value+
                    "' where name='"+rowName+"';";
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLDBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
