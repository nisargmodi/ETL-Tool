
package transformationfinal;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransformationFinal {

//    public static void main(String[] args) {
//        
//        Scanner sc1=new Scanner(System.in);
//      System.out.println("Enter the file name");
//        String input_file=sc1.next()+".txt";
//      System.out.println("Enter transformation to be performed");
//        String transform=sc1.next();
//        Metadata md=new Metadata();
//        boolean flag=md.checkInput(input_file,transform);
//        
//        if(!flag){
//       
//            boolean trap=md.checkTransform(input_file);
//            
//            if(!trap){      //no transformation done before
//               
//              if("split".equals(transform)){
//                 Split ss=new Split();
//                 ss.splitting(input_file,transform);
//             }
//             else if("missing".equals(transform)){
//                 MissingValues ms=new MissingValues();
//                 ms.missingValues(input_file,transform);
//             }
//             else {
//                    try {
//                        File f2=new File("metadata"+input_file);
//                        Scanner x=new Scanner(f2);
//                String data=x.nextLine();
//                if(!data.contains("split")){
//                    Split ss=new Split();
//                     ss.splitting(input_file,"split");
//                }
//                     Zonal z=new Zonal();
//                     z.zones(input_file,transform);
//                    } catch (FileNotFoundException ex) {
//                        Logger.getLogger(TransformationFinal.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//             }
//      }
//            else{
//                   String table=input_file.replace(".txt","");
//                if("spilt".equals(transform)){
//                    Split ss=new Split();
//                    ss.splitting(table+"Trans.txt",transform);
//                  }
//                else if("missing".equals(transform)){
//                    MissingValues ms=new MissingValues();
//                    ms.missingValues(table+"Trans.txt",transform);
//                }
//                 else {
//                   try {
//                        File f2=new File("metadata"+input_file);
//                        Scanner x=new Scanner(f2);
//                String data=x.nextLine();
//                if(!data.contains("split")){
//                    Split ss=new Split();
//                     ss.splitting(input_file,"split");
//                }
//                     Zonal z=new Zonal();
//                     z.zones(input_file,transform);
//                    } catch (FileNotFoundException ex) {
//                        Logger.getLogger(TransformationFinal.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//            }
//        }      
//     } 
//  }

    public TransformationFinal(String input_file, String transform) {
        Metadata md=new Metadata();
        boolean flag=md.checkTranform(input_file,transform);
        
        if(!flag){
       
            boolean trap=md.checkInput(input_file);
            
            if(!trap){      //no transformation done before
               
              if("split".equals(transform)){
                 Split ss=new Split();
                 ss.splitting(input_file,transform);
             }
             else if("missing".equals(transform)){
                 MissingValues ms=new MissingValues();
                 ms.missingValues(input_file,transform);
             }
             else {
                    try {
                        if(!md.checkTranform(input_file, "split")){
                            Split ss=new Split();
                            ss.splitting(input_file, "split");
                        }
                     Zonal z=new Zonal();
                     z.zones(input_file,transform);
                    } catch (Exception ex) {
                        Logger.getLogger(TransformationFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
             }
      }
            else{
                   String table=input_file.replace(".txt","");
                if("spilt".equals(transform)){
                    Split ss=new Split();
                    ss.splitting(table+"Trans.txt",transform);
                  }
                else if("missing".equals(transform)){
                    MissingValues ms=new MissingValues();
                    ms.missingValues(table+"Trans.txt",transform);
                }
                 else {
                   try {
                        if(!md.checkTranform(input_file, "split")){
                            Split ss=new Split();
                            ss.splitting(input_file, "split");
                        }
                     Zonal z=new Zonal();
                     z.zones(input_file,transform);
                    } catch (Exception ex) {
                        Logger.getLogger(TransformationFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }      
     } 
    }
    
    public static void main(String a[]){
        new TransformationFinal("vendorGen.txt", "split");
    }
}


