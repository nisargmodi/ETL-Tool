package Mining;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Hierarchical 
{
    public static double threshold;
    public static void main(String m[]){
       new Hierarchical();
    }
    
    Hierarchical()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String Url = "jdbc:mysql://localhost/mining";     //jdbc:mysql://hostname/databaseName
            Connection con=DriverManager.getConnection(Url,"root",""); //connectionString,Username,Password
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT total_amount FROM training_data");

            Vector elements=new Vector();
            while(rs.next())
            {
                int n = rs.getInt("total_amount");
                elements.addElement(n);
            }
            
           long difference[][]=new long[elements.size()][elements.size()];
            
            for(int i=0;i<elements.size();i++)
            {
                for(int j=0;j<elements.size();j++)
                {
                   
                    
                    difference[i][j] = Math.abs((Integer)elements.get(i)-(Integer)elements.get(j));
                   
                }
            }
            //print col names 
            for(int i=0; i<elements.size(); i++){
                System.out.print("\t" + elements.get(i) + "\t");
            }
            System.out.println("");
            
            for(int i=0;i<elements.size();i++)
            {
                System.out.print(elements.get(i));
                for(int j=0;j<elements.size();j++)
                {
                    System.out.print("\t" + difference[i][j]+ "\t");
                }
                System.out.println();
            }
            
            rs=st.executeQuery("SELECT AVG(total_amount) from training_data");
            rs.first();
            threshold=rs.getInt(1)*0.3;
            
            Vector clusters[]=new Vector[elements.size()];
            Vector tempclusters[]=new Vector[elements.size()];
            int numberOfClusters=elements.size();
            int tempnumberOfClusters=elements.size();
            boolean included[];
            
            for(int i=0;i<clusters.length;i++)
            {
                clusters[i]=new Vector();
                tempclusters[i]=new Vector();
            }
            
            System.out.println("Threshold :"+threshold+"");
            
            for(int i=0;i<tempclusters.length;i++)
            {
                tempclusters[i].addElement(i);
            }
            
            for(int i=0;i<tempclusters.length;i++)
            {
                System.out.print("Cluster "+(i+1)+": ");
                
                for(int j=0;j<tempclusters[i].size();j++)
                {
                    System.out.print(tempclusters[i].get(j)+ "\t\t");
                }
                System.out.println();
            }
            
            for(int i=0;i<tempclusters.length;i++)
            {
                for(int j=0;j<tempclusters[i].size();j++)
                {
                    clusters[i].addElement(tempclusters[i].get(j)+"");
                }
            }
            
            
            //-----------------END OF INITIALIZATION----------------------------
            while(numberOfClusters!=1)
            {
                System.out.println();
                threshold*=1.5;
                System.out.println("Threshold :"+threshold+"");
                included=new boolean[numberOfClusters];
                for(int k=0;k<tempclusters.length;k++)
                {
                    tempclusters[k].removeAllElements();
                }
                tempclusters=new Vector[numberOfClusters];
                tempnumberOfClusters=0;
                for(int i=0;i<numberOfClusters;i++)
                {
                    tempclusters[i]=new Vector();
                    if(!included[i])
                    {
                        for(int k=0;k<clusters[i].size();k++)
                        {
                            tempclusters[i].addElement(clusters[i].get(k)+"");
                        }
                        
                        for(int j=i+1;j<numberOfClusters;j++)
                        {
                            if(!included[j])
                            {
                                for(int k1=0;k1<clusters[i].size();k1++)
                                {
                                    for(int k2=0;k2<clusters[j].size();k2++)
                                    {
                                        int i1=Integer.parseInt(clusters[i].get(k1)+"");
                                        int i2=Integer.parseInt(clusters[j].get(k2)+"");
                                        if(difference[i1][i2]<=threshold)
                                        {
                                            included[j]=true;
                                        }
                                    }
                                }
                            }
                            if(included[j])
                            {
                                for(int k=0;k<clusters[j].size();k++)
                                {
                                    tempclusters[i].addElement(clusters[j].get(k)+"");
                                }
                                clusters[j].removeAllElements();
                            }
                            
                            
                        }
                        
                        included[i]=true;
                    }
                    if(tempclusters[i].size()>0)
                    {
                        tempnumberOfClusters++;
                    }
                }

                numberOfClusters=tempnumberOfClusters;
                
                for(int k=0;k<clusters.length;k++)
                {
                    clusters[k].removeAllElements();
                }
                
                clusters=new Vector[numberOfClusters];
                tempnumberOfClusters=0;

                for(int i=0;i<clusters.length;i++)
                {
                    clusters[i]=new Vector();
                    while(tempnumberOfClusters<tempclusters.length && tempclusters[tempnumberOfClusters].size()==0)
                    {
                        tempnumberOfClusters++;
                    }
                    for(int k=0;tempnumberOfClusters<tempclusters.length && k<tempclusters[tempnumberOfClusters].size();k++)
                    {
                         clusters[i].addElement(tempclusters[tempnumberOfClusters].get(k)+"");
                    }
                    tempnumberOfClusters++;
                }

                for(int i=0;i<clusters.length;i++)
                {

                    System.out.print("Cluster "+(i+1)+": ");

                    for(int j=0;j<clusters[i].size();j++)
                    {
                        System.out.print(clusters[i].get(j)+ "\t\t");
                    }
                    System.out.println();
                }
                
            }
            
        } 
        catch (Exception e) 
        {
           System.out.println(e.getMessage());
        }
        
    }
    
    
}
