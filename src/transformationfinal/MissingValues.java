
package transformationfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MissingValues {
    
        public void missingValues(String input,String transform){
        try {
           String st=input.replace(".txt","");
         if(input.contains("Trans")){
                st=input.replace("Trans.txt","");
            } 
            Metadata md=new Metadata();
            md.updateMetadataRow(st, "missing", 1); //updating metadata
            File f=new File(input);
            Scanner sc=new Scanner(f);
            String s=sc.nextLine();
          String table="";
               if(!input.contains("Trans")){
               table=input.replace(".txt","");
               table+="Trans.txt";
               } 
               else {
                table=input;
            }
               FileOutputStream fout=new FileOutputStream(table);
            PrintStream out=new PrintStream(fout);
           
            out.println(s);
             while(sc.hasNextLine()){
             String s1=sc.nextLine();
             String clean=missing(s1);
             if(sc.hasNextLine()){
             out.println(clean);
             }
             else
                 out.print(clean);
         }
             out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MissingValues.class.getName()).log(Level.SEVERE, null, ex);
        }
       } 
        
          public String missing(String dirty){
          String clean="";
        String df="UNKNOWN";
        String x[]=dirty.split(",");
        for(int i=0;i<x.length;i++){
            char inner[]=x[i].toCharArray();
       if(inner[0]==inner[1]){
            clean=clean+inner[0]+df+inner[1];
        }
        else{
            clean=clean+x[i];
        }
        if(i==x.length-1){
            clean=clean+"\n";
        }
        else{
            clean+=",";
        }
        }
        return clean;
    }
}
