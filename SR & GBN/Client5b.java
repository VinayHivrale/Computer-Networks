import java.io.*;
import java.net.*;

public class Client5b {
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
       int temp=0;
       for(int i=0;i<y;i++){
        
        if(arr[i]==-1){
            temp=i;
         System.out.println("ERROR FRAME RECEIVED:"+arr[i]);
        }else{
            System.out.println("receiving frame:"+arr[i]);
        }
       }dout.write(temp);
       arr[temp]=din.read();
       System.out.println("resent frame:"+arr[temp]);
       System.out.println("final frame is:");
       System.out.println(arr[temp]);
       din.close();
       s.close();
        
    }
    
}
