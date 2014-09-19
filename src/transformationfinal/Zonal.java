
package transformationfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Zonal {
     int index;
    
    public void zones(String input,String transform){
        try {
                Metadata md=new Metadata();
            md.updateMetadataRow(input, "zone", 1); //updating metadata
          
                 String table=input.replace(".txt","");
                     File f=new File(table+"Trans.txt");
                     Scanner sc1=new Scanner(f);
                     String t=sc1.nextLine();
                     FileOutputStream fout=new FileOutputStream(table+"Trans.txt");
                     PrintStream out=new PrintStream(fout);
                  //   String t=sc1.nextLine();
                     t=zonalTitle(t);
                     out.println(t);
                     while(sc1.hasNextLine()){
                         String s1=sc1.nextLine();
                         String clean=zonal(s1);
                         if(sc1.hasNextLine()){
                          out.println(clean);
                         }
                         else
                             out.print(clean);
                     }
                     out.close();
              
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Zonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String zonalTitle(String t){
        String title="";
        String z[]=t.split(";");
        title+=z[0]+",\"Zones\";";
        String x[]=t.split(",");
         for(int i=0;i<x.length;i++){
            if(x[i].contains("pincode")){
                index=i;
                System.out.println(index);
            }
        }
        return title;
    }
    
    public String zonal(String dirty){
        String clean="";
        String x[]=dirty.split(",");
        dirty=dirty.replace(";",",");
       
        String p=x[index].substring(1,7);
        System.out.println(p);
     String zone=new String("UNKNOWN");
        int zip=Integer.parseInt(p);
        if(zip>=400001&&zip<=400030){
            zone="Southern";
        }
        else if(zip>=400031&&zip<=400070){
            zone="western";
        }
        else if(zip>=400071&&zip<=400100){
            zone="central";
        }
        else if(zip>=400600&&zip<=400750){
            zone="navi mumbai";
        }
        clean=dirty+"\""+zone+"\";";
        return clean;
    }
}
