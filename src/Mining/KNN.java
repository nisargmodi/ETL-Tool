/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mining;

import java.awt.Container;
import java.sql.*;
import java.util.Scanner;
import javax.swing.text.Highlighter;

/**
 *
 * @author owners
 */
public class KNN {
    
//    public static void main(String m[])
//    {
//        new KNN();
//    }
    String spclass="";
    KNN(String name , int age, int amount)
    {
        try{
            
            Scanner sc = new Scanner(System.in);
            String myUrl = "jdbc:mysql://localhost/mining";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "");
            
            String query = "SELECT * FROM training_data";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
//            System.out.println("Enter new Tuple : name , age , amount ");
//            String name = sc.next();
//            int age = sc.nextInt();
//            int amount = sc.nextInt();
            
            
            Statement st1 = conn.createStatement();
                        
            
            while(rs.next())
            {
                int amt = rs.getInt("total_amount");
                int n = Math.abs(amt-amount);
                String cust_name=rs.getString(1);
                st1.executeUpdate("UPDATE training_data set knn=" + n + " where cust_name = '" + cust_name + "'");
               
            }
            
            query="SELECT * FROM training_data ORDER BY knn ASC";
            rs=st.executeQuery(query);
            
            int i=7,low=0,med=0,high=0;
            String spclass = "";
            
            while(i!=0 && rs.next())
            {
                String s = rs.getString(4);
                if(s.equals("low"))
                {
                    low++;
                    spclass="low";
                }
                else if(s.equals("med"))
                {
                    med++;
                    if(med>low && med>=high)
                        spclass="medium";
                }
                else
                {
                    high++;
                    if(high>low && high>med)
                        spclass="high";
                }
                i--;
                
//                int age1 = rs.getInt("cust_age");
//                String class_sp=rs.getString(4);
//                String custname=rs.getString(1);
//                int amt = rs.getInt("total_amount");
//                int n = rs.getInt("knn");
//                System.out.println(custname + "\t\t\t" + age1 + "\t\t" + amt + "\t\t" + class_sp + "\t\t" + n);
                
            }

            
            
            //insert tuple in database
             st.executeUpdate("INSERT INTO training_data " + "VALUES "
             + "('" + name+ "',"
                    + age + ","
                    + amount+ ","
             + "'" + spclass+ "',"
             + 0 + ");"); 
             
            st.close();
        }catch(Exception e){
         System.err.print(e);   
        }
    }
    
    String getoutput(){
        return spclass;
    }
}
