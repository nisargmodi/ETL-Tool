
package transformationfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Split {
    int name_index;
    int address_index;
    public void splitting(String input,String transform){
        try {
         String st=input.replace(".txt","");
         if(input.contains("Trans")){
                st=input.replace("Trans.txt","");
            }
            Metadata md=new Metadata();
            md.updateMetadataRow(st, "split", 1);
            File in=new File(input);
               Scanner sc=new Scanner(in);
                String s=sc.nextLine();
               String table="";
               if(!input.contains("Trans")){
               table=input.replace(".txt","");
               table+="Trans.txt";
               } 
               else
                   table=input;
               FileOutputStream fout=new FileOutputStream(table);
               PrintStream out=new PrintStream(fout);
              String title=splitIndex(s); 
              out.println(title);
               while(sc.hasNextLine()){
                String s1=sc.nextLine();
                String clean=split(s1);
                if(sc.hasNextLine()){
                    out.println(clean);
                   }
                else
                out.print(clean);
            }
               System.out.println("inside split");
               out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Split.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String splitIndex(String s){
        String x[]=s.split(",");
        String title="";
        for(int i=0;i<x.length;i++){        //finding index of name and address
            if(x[i].contains("name")){
                name_index=i;

            }
            if(x[i].contains("address")){
                address_index=i;
            }
        }
        int j;
        for(j=0;j<name_index;j++){
            title+=x[j]+",";
        }
        title+="\"first name\",\"last name\",";
        for(j=name_index+1;j<address_index;j++){
            title+=x[j]+",";
        }
        title+="\"address line 1\",\"address line 2\",\"city\",\"pincode\"";
          if(j==x.length-1) {
            title+=";";
        }
        else {
            title+=",";
        }
          if(x.length-1!=address_index){
         for(j=address_index+1;j<x.length-1;j++){
              title+=x[j]+",";
              //System.out.println("dd");
         }
          if(j==x.length-1) {
            title+=x[j];
        }
          }
        return title;
    }
    public String split(String dirty){
       String clean="";
       String x[]=dirty.split(",");
       int i;
       for(i=0;i<name_index;i++){
           clean+=x[i]+",";
       }
        String name[]=x[i].split(" ");
        clean+=name[0]+"\",\""+name[1]+",";
        for(i=name_index+1;i<address_index;i++){
            clean+=x[i]+",";
        }
        clean+=x[i++]+"\",\""+x[i++]+"\",";
        String city[]=x[i].split("-");
        System.out.println(x[i]);
        clean+="\""+city[0]+"\",\""+city[1];
        if(i==x.length-1){
           return clean;
        }
        else{
            clean+=",";
        }
        i++;
         while(i<x.length-1){
          clean+=x[i++]+",";
          
          System.out.println("hcv");
      }
       if(i==x.length-1)
          clean+=x[i];
        return clean;
    }
}
