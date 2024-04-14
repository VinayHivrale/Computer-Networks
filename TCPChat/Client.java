import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

public static void main(String args[])throws Exception
{
   Socket s = new Socket("localhost",3333);
   DataInputStream din= new DataInputStream(s.getInputStream());
   DataOutputStream dout= new DataOutputStream(s.getOutputStream());
   Scanner in=new Scanner(System.in);
   
   String str="";
   String str2="";
   
   
  while(str!="end")
{
   
  str2=in.nextLine();
  dout.writeUTF(str2);
  dout.flush();
  str=din.readUTF();
  System.out.println("server says:"+str);
 
}

din.close();
s.close();

}
}