package Main;

import com.mysql.jdbc.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *

 */
public class ExtractMdb {

     Connection con;
    java.sql.DatabaseMetaData dbmd;
    ResultSet rs;
    Statement st;
    String table[];
    private String outputFile;
    private File file;
    
    public static void main(String a[]) throws SQLException, IOException{

        ExtractMdb ex=new ExtractMdb("c:/DWM/files/SUJEN/test1.mdb");
        ex.extractTable("Products");
    }

    public ExtractMdb(String DBName){
         try {
            con=SQLDBConnect.accessConnect(DBName);
            
            st = con.createStatement();
            dbmd=con.getMetaData();
            rs=dbmd.getTables(null, null, "%", null);
        } catch (SQLException ex) {
            Logger.getLogger(ExtractSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
     public String[] getTableNames() throws SQLException{
        table=new String[3];
        int i=0;
         while(rs.next()){
                    System.out.println(rs.getString(3));
                    
                    String tableName=rs.getString(3);
                    table[i]=tableName;
                    i++;
         }
         return table;
    }
    
    public void extractTable(String tableName) throws IOException{
        try {
            
                         outputFile=tableName.toLowerCase()+"Gen.txt";
                         
                        ResultSet rs1 = st.executeQuery("select * from "+tableName);
                        java.sql.ResultSetMetaData rsmd=rs1.getMetaData();
                        int columnCount=rsmd.getColumnCount();
                    
                    
                     file=new File(outputFile);
                      String str = "";
                      
                    if(!file.exists()){
                        file.createNewFile();
                        System.out.println("New file created "+file.getName());
                        for(int i=1;i<=columnCount;i++){
                        str=str.concat("\"");
                        str=str.concat(rsmd.getColumnName(i));
                        str=str.concat("\"");
                        
                        if(i!=columnCount){
                            str=str.concat(",");
                        }
                        }
                        str=str.concat(";");
                        //System.out.print(str);
                    }
                    FileWriter fw=new FileWriter(file.getName(),true);
                    BufferedWriter out=new BufferedWriter(fw);
                    
                     out.write(str);
                     out.newLine();
                   
                    while(rs1.next()) {
                        str="";
                        for(int i=1;i<=columnCount;i++){
                        str=str.concat("\"");
                        str=str.concat(rs1.getString(i));
                        str=str.concat("\"");
                        
                        if(i!=columnCount){
                            str=str.concat(",");
                        }
                        }
                        str=str.concat(";");
                        System.out.println(str);
                       
                        out.write(str);
                        if(!rs1.isLast())
                        out.newLine();
                
                    }
                    
                    out.close();
                    fw.close();
                    
                    
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(ExtractSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
               
                }
                 
    public File getOutputFile(){
        return file;
    }
    
    
//            DatabaseMetaData dbmd=con.getMetaData();
//             ResultSet rs=dbmd.getTables(null, null, "%", null);


              //while(rs.next()){
//                    System.out.println(rs.getString(3));
//                    String tableName="Products";
//                    String outputFile=tableName+"Gen.txt";
//
//                    ResultSet rs1 = st.executeQuery("select * from "+tableName);
//                    java.sql.ResultSetMetaData rsmd=rs1.getMetaData();
//                    int columnCount=rsmd.getColumnCount();
//
//
//                File file=new File(outputFile);
//
//                  String str = "";
//
//                if(!file.exists()){
//                    file.createNewFile();
//                    System.out.println("New file created "+file.getName());
//                    for(int i=1;i<=columnCount;i++){
//                    str=str.concat("\"");
//                    str=str.concat(rsmd.getColumnName(i));
//                    str=str.concat("\"");
//
//                    if(i!=columnCount){
//                        str=str.concat(",");
//                    }
//                    }
//                    str=str.concat(";");
//                    //System.out.print(str);
//                }
//                FileWriter fw=new FileWriter(file.getName(),true);
//                BufferedWriter out=new BufferedWriter(fw);
//
//                 out.write(str);
//                 out.newLine();
//
//                while(rs1.next()) {
//                    str="";
//                    for(int i=1;i<=columnCount;i++){
//                    str=str.concat("\"");
//                    str=str.concat(rs1.getString(i));
//                    str=str.concat("\"");
//
//                    if(i!=columnCount){
//                        str=str.concat(",");
//                    }
//                    }
//                    str=str.concat(";");
//                    System.out.println(str);
//
//                    out.write(str);
//                    out.newLine();
//
//                }
//
//
//                out.close();
//                fw.close();
//
//                //}
//                 st.close();
//                //rs.close();
//                con.close();
//        }catch (Exception err) {
//                System.out.println("ERROR: " + err);
//            }
//    }
    
      
}
