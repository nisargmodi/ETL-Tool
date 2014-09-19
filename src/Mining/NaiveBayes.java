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
public class NaiveBayes {
    
//    public static void main(String a[]){
//       new NaiveBayes();
//    }
    String sp_class=null;
    NaiveBayes(String name ,int age , int amount )
    {
        try
    {
      Scanner sc=new Scanner(System.in);
      // create our mysql database connection
      String myUrl = "jdbc:mysql://localhost/mining";
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      
      String query = "SELECT * FROM training_data";
      Statement st = conn.createStatement();
      ResultSet rs=st.executeQuery(query);
      
      String counts[]={ "total","low","med","high",
          "age1low","age1med","age1high",
          "age2low","age2med","age2high",
          "age3low","age3med","age3high",
          "amt1low","amt1med","amt1high",
          "amt2low","amt2med","amt2high",
          "amt3low","amt3med","amt3high",
          "amt4low","amt4med","amt4high",
          "amt5low","amt5med","amt5high",
          "amt6low","amt6med","amt6high"};
  
      String queries[]={"select COUNT(*) from training_data",
                        "select COUNT(*) from training_data where spender_class='low'",
                        "select COUNT(*) from training_data where spender_class='med'",
                        "select COUNT(*) from training_data where spender_class='high'",
                        "select COUNT(*) from training_data where spender_class='low' and cust_age<21",
                        "select COUNT(*) from training_data where spender_class='med' and cust_age<21",
                        "select COUNT(*) from training_data where spender_class='high' and cust_age<21",
                        "select COUNT(*) from training_data where spender_class='low' and cust_age>20 and cust_age<=40",
                        "select COUNT(*) from training_data where spender_class='med' and cust_age>20 and cust_age<=40",
                        "select COUNT(*) from training_data where spender_class='high' and cust_age>20 and cust_age<=40",
                        "select COUNT(*) from training_data where spender_class='low' and cust_age>40",
                        "select COUNT(*) from training_data where spender_class='med' and cust_age>40",
                        "select COUNT(*) from training_data where spender_class='high' and cust_age>40",
                        "select COUNT(*) from training_data where spender_class='low' and total_amount<1000",
                        "select COUNT(*) from training_data where spender_class='med' and total_amount<1000",
                        "select COUNT(*) from training_data where spender_class='high' and total_amount<1000",
                        "select COUNT(*) from training_data where spender_class='low' and total_amount>=1000 and total_amount<2000",
                        "select COUNT(*) from training_data where spender_class='med' and total_amount>=1000 and total_amount<2000",
                        "select COUNT(*) from training_data where spender_class='high' and total_amount>=1000 and total_amount<2000",
                        "select COUNT(*) from training_data where spender_class='low' and total_amount>=2000 and total_amount<3000",
                        "select COUNT(*) from training_data where spender_class='med' and total_amount>=2000 and total_amount<3000",
                        "select COUNT(*) from training_data where spender_class='high' and total_amount>=2000 and total_amount<3000",
                        "select COUNT(*) from training_data where spender_class='low' and total_amount>=3000 and total_amount<4000",
                        "select COUNT(*) from training_data where spender_class='med' and total_amount>=3000 and total_amount<4000",
                        "select COUNT(*) from training_data where spender_class='high' and total_amount>=3000 and total_amount<4000",
                        "select COUNT(*) from training_data where spender_class='low' and total_amount>=4000 and total_amount<5000",
                        "select COUNT(*) from training_data where spender_class='med' and total_amount>=4000 and total_amount<5000",
                        "select COUNT(*) from training_data where spender_class='high' and total_amount>=4000 and total_amount<5000",
                        "select COUNT(*) from training_data where spender_class='low' and total_amount>=5000",
                        "select COUNT(*) from training_data where spender_class='med' and total_amount>=5000",
                        "select COUNT(*) from training_data where spender_class='high' and total_amount>=5000",};

   
     double counter[]=new double[queries.length];
     int i=0;
     
     while(i<queries.length)
     {
         rs=st.executeQuery(queries[i]);
         rs.next();
         counter[i]=(double)rs.getLong(1);
         i++;
     }
    
     
     //print values of the counters
     /* for(i=0;i<counter.length;i++)
      {
         
          System.out.print(counts[i]+" = "+counter[i]);
        if(i%3==0)
        System.out.println();
             
          
      }*/
     
     //calculate probabilty
     i=4;
     double probablity[]=new double[counter.length];
     while(i<counter.length)
     {  
         if(counts[i].contains("low"))
            probablity[i]=counter[i]/counter[1];
         else if(counts[i].contains("med"))
            probablity[i]=counter[i]/counter[2];
         else
            probablity[i]=counter[i]/counter[3];
         i++;
      }
     
     
     
     double plow=counter[1]/counter[0],pmed=counter[2]/counter[0],phigh=counter[3]/counter[0];
     
//     System.out.println("enter the tuple to be inserted : name , age , total_amount ");
//     String name=sc.next();
//     int age=sc.nextInt();
//     int amount=sc.nextInt();
     
     double tlow=1,tmed=1,thigh=1;
     if(age<=20){
        tlow*=probablity[4];
        tmed*=probablity[5];
        thigh*=probablity[6];       
     }
     else if(age>20 && age<=40){
        tlow*=probablity[7];
        tmed*=probablity[8];
        thigh*=probablity[9]; 
     }else{
         
        tlow*=probablity[10];
        tmed*=probablity[11];
        thigh*=probablity[12]; 
     }
     
     if(amount<1000){
       
        tlow*=probablity[13];
        tmed*=probablity[14];
        thigh*=probablity[15]; 
        
     }else if(amount>=1000 && amount<2000){
        
         tlow*=probablity[16];
         tmed*=probablity[17];
        thigh*=probablity[18]; 
     }else if(amount>=2000 && amount<3000){

         tlow*=probablity[19];
         tmed*=probablity[20];
        thigh*=probablity[21]; 
         
     }else if(amount>=3000 && amount<4000){
         
         tlow*=probablity[22];
         tmed*=probablity[23];
        thigh*=probablity[24];    
        
     }else if(amount>=4000 && amount<5000){
         
         tlow*=probablity[25];
         tmed*=probablity[26];
        thigh*=probablity[27];  
        
     }else{
         
         tlow*=probablity[28];
         tmed*=probablity[29];
        thigh*=probablity[30];         
     }
         
     double t=tlow+tmed+thigh;
     
     double lowt=tlow/t,medt=tmed/t,hight=thigh/t;
     if(lowt>=medt && lowt>=hight){
         sp_class="low";
     }else if(medt>=lowt && medt>=hight){
        sp_class="medium";
     }else if(hight>=lowt && hight>=medt){
          sp_class="high";
     }
     // System.out.println("classp = "+sp_class); 
     
     if(sp_class==null)
     {
         if(age<=20 && amount<1000)
             sp_class="low";
         else if(amount>1000 && amount<2000)
             sp_class="medium";
         else
             sp_class="high";
         
         if(age>20 && age <=40 && amount<1000)
            sp_class="low";
         else if(amount>1000 && amount<4000)
             sp_class="medium";
         else
             sp_class="high";
         
         if(age>40 && amount>=2500)
             sp_class="high";
         else if(amount>=1000 && amount<2500)
             sp_class="medium";
         else
             sp_class="low";
         
     }
         //printing probability 
     /*
     for(i=0;i<probablity.length;i++)
     {
         System.out.print(counts[i]+"\t\t"+probablity[i]);
         if(i%3==0)
             System.out.println();
     }*/
          
   
     // inserting new tuple in the database
     
     
     st.executeUpdate("INSERT INTO training_data " + "VALUES ('"
             + name+"',"
             + age +","
             + amount+","
             +"'"+ sp_class+"');");
       st.close();
       
    }catch(Exception e)
    {
    System.err.print(e);
    }
    }
  
    public String getOutput(){
        return sp_class;
    }
}

