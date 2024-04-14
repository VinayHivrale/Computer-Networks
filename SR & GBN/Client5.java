import java.io.*;
import java.net.*;

public class Client5 {
    public static void main(String[] args)throws IOException {
        Socket s= new Socket("localhost",3000);
        DataInputStream din =new DataInputStream(s.getInputStream());
        DataOutputStream dout= new DataOutputStream(s.getOutputStream());
        int y= din.read();
        int [] arr=new int[y];
        for(int i=0;i<y;i++){
           arr[i]=din.read();
           System.out.println("receiving frame:"+arr[i]);

        }
        System.out.println("\n");
        arr[4]=-1;
       int temp=4;
       for(int i=0;i<y;i++){
        if(arr[i]==-1){
         System.out.println("ERROR FRAME RECEIVED:"+arr[i]);
        }else{
            System.out.println("receiving frame:"+arr[i]);
        }
       }dout.write(temp);
       for(int i=temp;i<arr.length;i++){
        arr[i]=din.read();
        System.out.println("resent frame is:"+arr[i]);

       }
       System.out.println("final frame is:");
       System.out.println(arr[temp+2]);
       din.close();
       s.close();
        
    }
    
}
