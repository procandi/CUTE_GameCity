package cute_gamecity;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class clsNet {
  public static Socket S;
  public static ServerSocket SS;
  public static DataInputStream instream;
  public static DataOutputStream outstream;

  public static String LocalIP="127.0.0.1";
  public static int LocalPort=1234;
  public static String RemoteIP="127.0.0.1";
  public static int RemotePort=1234;

  public static ServerSocket PlurkSS;
  public static ServerSocket ChatSS;
  public static String PlurkIP="127.0.0.1";
  public static String ChatIP="127.0.0.1";
  public static int PlurkSelectPort=9999;
  public static int ChatSelectPort=9998;


  public clsNet() {
  }

  /**/
  public static boolean SendData(String IP,int Port,String Msg,int TimeOut){
    try {
      Socket OutputS = new Socket(IP, Port);
      OutputS.setSoTimeout(TimeOut);

      instream = new DataInputStream(OutputS.getInputStream());
      outstream = new DataOutputStream(OutputS.getOutputStream());
      outstream.writeUTF(Msg);

      OutputS.close();

      return true;
    } catch (Exception ex) {
      ex.printStackTrace();

      return false;
    }
  }
  /**/

  /**/
 public static String GetData(int Port,int TimeOut){
   String Result=null;

   try {
     ServerSocket InputSS=new ServerSocket(Port);
     InputSS.setSoTimeout(TimeOut);
     Socket OutputS = InputSS.accept();
     OutputS.setSoTimeout(TimeOut);

     if (OutputS.isConnected()) {
       instream = new DataInputStream(OutputS.getInputStream());
       outstream = new DataOutputStream(OutputS.getOutputStream());
       Result = instream.readUTF();

       InetAddress inetadd=OutputS.getInetAddress();
       RemoteIP=inetadd.getHostAddress();

       OutputS.close();
     }
   } catch (Exception ex) {
     ex.printStackTrace();
   }


   return Result;
 }
 /**/



  /**/
  public static ServerSocket ListenSocket(int port) {
    ServerSocket MakeSS;

    try {
      MakeSS = new ServerSocket(port);

      return MakeSS;
    }
    catch (Exception ex) {
      ex.printStackTrace();

      return null;
    }
  }
  /**/


  /**/
  public static String GetData(ServerSocket InputSS,int TimeOut){
    String Result=null;

    try {
      InputSS.setSoTimeout(TimeOut);
      Socket OutputS = InputSS.accept();
      OutputS.setSoTimeout(TimeOut);

      if (OutputS.isConnected()) {
        instream = new DataInputStream(OutputS.getInputStream());
        outstream = new DataOutputStream(OutputS.getOutputStream());
        Result = instream.readUTF();

        InetAddress inetadd=OutputS.getInetAddress();
        RemoteIP=inetadd.getHostAddress();

        OutputS.close();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }


    return Result;
  }
  /**/

}



