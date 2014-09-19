/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author $ujen
 */
public class ExtractTxt {
    private String outputFile;
    private File file;
    
   
// public static void main(String a[]) throws IOException{
//     ExtractTxt ex=new ExtractTxt("customer.csv");
//     ExtractTxt t=new ExtractTxt("products.csv");
// }
    
    public ExtractTxt(String input)throws IOException
    {
        
//        System.out.println("Enter full input path");
//        String i=sc.next();
//        System.out.println("Enter full output path");
//        String o=sc.next();
       File f=new File(input);
       Scanner sc=new Scanner(f);
        
        input=input.replace(".csv", "");
        String output=input+"Gen.txt";
        
        String row="";
        File f1=new File(output);
        file=f1;
        boolean flag=false;
         //System.out.println(f1.getName());
		if(f1.exists())
		{
                    flag=true;
			//row=sc.nextLine();
		}
                
         //FileWriter fw=new FileWriter(f1.getName(), true);
         FileOutputStream fout=new FileOutputStream(f1.getName(), true);
         PrintStream out=new PrintStream(fout);
         while(sc.hasNextLine())
		{
                    if(flag)
			{
			
				row=sc.nextLine();
				row=sc.nextLine();
				flag=false;
			}
			else 
			row=sc.nextLine();
                    
                    String txt="";
			String x[]=row.split(",");

			for(int i=0;i<x.length;i++)
			{	
				if(x[i].indexOf('"',0)==0)
				{
					txt+=x[i];
					int length=x[i].length();
					
					while(!( x[i].lastIndexOf('"',length-1)==(length-1) ))
					{
						i++;
						txt+=","+x[i];
						length=x[i].length();
						
					}




				}
				else 
				{
                                	txt+="\""+x[i]+"\"";
                            	}
		
			if(i!=(x.length-1)) {
                                txt+=",";
                            }
			else {
                                txt+=";";
                            }

			}//end for

                        
                        if(!sc.hasNext()){
                            out.print(txt);
                        }
                        else{
                            out.println(txt);
                        }
			//System.out.println(txt);

		}//end while
		
			out.close();

    }
    
    public File getOutputFile(){
        return file;
    }
}
