/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author owners
 */
public class KMeans {
    
    KMeansGUI gui;
    
    public static void main(String m[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k");
        int k = sc.nextInt();
        
       
    }

    KMeans(int k,String col,KMeansGUI _gui)
    {
        gui=_gui;
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        try{
            
            Vector<Integer> list[] = new Vector[k];
            double oldmean[] = new double[k];
            double mean[] = new double[k];
            
            for(int i=0; i<k ; i++)
            {
                list[i] = new Vector();
            }
            
            //database connection
            String myurl="jdbc:mysql://localhost/mining";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myurl,"root","");
            
            String query = "SELECT * FROM training_data";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            // input elements in a vector 
            Vector elements = new Vector();    
//            System.out.println("cluster with respect to \n 1. cust_age \n 2. total_amount ");
//            String col =sc.next();
            
            while(rs.next())
            {
                int n = rs.getInt(col);
                elements.addElement(n);
            }
            
            if(k<=elements.size()){
            // print elements
            for(int i=0; i<elements.size() ; i++)
            {
                printOutput(elements.get(i)+", ");
                //System.out.print(elements.get(i)+" \t");
            }
               printOutput("\n");
            int diff[] = new int[k];
            
            
            for(int i=0 ; i<k ; i++)
            {
                mean[i] =  (Integer) elements.get(i);
            }
            // loop 
            while(!stop){
           
                // add lowest difference element in respective list
            for(int i=0 ; i<elements.size() ; i++)
            {
                double n = (Integer) elements.get(i);
                for(int j=0 ; j<k ; j++)
                {
                    diff[j] = (int) Math.abs(mean[j]-n);
                }
                int x = 0, temp = diff[0], index=0 ;
               
                for(x=1 ; x<k ; x++)
                {
                    if(diff[x]<temp)
                    {
                        temp=diff[x];
                        index=x;
                    }
                    
                }
                list[index].addElement((int)n);
            }
             
                System.arraycopy(mean, 0, oldmean, 0, k);
                 
   
            // calculate the new mean of the values in each list
           for(int o=0 ; o<k; o++)
           {
               int sum=0;
              
               for(int n=0; n<list[o].size();n++){
                   sum+=list[o].get(n);
               }
               if(list[o].size()!=0)
               mean[o]=sum/list[o].size();
           }
           // print oldmean, new mean
//           System.out.println("old mean \t\t mean");
//           for(int i=0; i<k ;i++)
//           {
//               System.out.println(oldmean[i]+"\t\t\t"+ mean[i]);
//           }
//           
//           // print lists
//           for(int i=0; i<k ;i++)
//           {
//               System.out.println("LIST " + (1+i));
//               for(int j=0;j<list[i].size(); j++)
//               {
//                   System.out.print(list[i].get(j) + "\t");
//               }
//               System.out.println();
//           }
           
//           compare old mean and new mean values
           int count=0;
           for(int i=0;i<k;i++){
               if(oldmean[i]==mean[i])
                   count++;
           }
           if(count==k)
               stop = true;
           
           
           
           // clear lists
           if(!stop)
           {
                for(int i=0; i<k ; i++)
                {
                    list[i].clear();
                }
           }
            } 
           //printOutputln(k + "Clusters using kmeans clustering :");
           for(int i=0; i<k ;i++)
           {
               printOutput("LIST " + (1+i)+": ");
               for(int j=0;j<list[i].size(); j++)
               {
                   printOutput(list[i].get(j) + " ");
               }
               printOutput("\n");
              
           }  
            }else{
                JOptionPane.showMessageDialog(_gui, "K should be less than or equal to"+elements.size(), "Error", JOptionPane.ERROR_MESSAGE);
                
            }
         
        }catch(Exception e)
        {
            System.err.print(e);
        }
        
    }
            
    
    private void printOutput(String s){
        gui.setOutput(s);
    }   
  
    
}

