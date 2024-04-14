import java.io.*;
import java.net.*;
import java.util.*;

public class Server{

public static void main(String args[]) throws Exception
{

   ServerSocket ss=new ServerSocket(3333);
   Socket s=ss.accept();
   DataInputStream din=new DataInputStream(s.getInputStream());
   DataOutputStream dout=new DataOutputStream(s.getOutputStream());
   Scanner in=new Scanner(System.in);
  
   String str="";
   String str2="";
  

while(str2!="end")
{
   str2=din.readUTF();
   System.out.println("Client Says:"+str2);
   str=in.nextLine();
   dout.writeUTF(str);
   dout.flush();

}
  
  din.close();
  s.close();
  ss.close();
}
}