package cute_gamecity;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.net.URL;
import com.borland.jbcl.layout.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Main extends Applet {
  //�ŧi�����Өt�άy�{�������ܼ�
  public static int gs=0;                               //�ΨӰO���{�b�ϥΪ̩ҿ�ܪ��C���O���@��
  public static int pm=0;                               //�ΨӰO���{�b�ϥΪ̩ҿ�ܪ��O�檱�٬O�s�u�Ҧ�
  public static int rore=0;                             //�ΨӰO���{�b�ϥΪ̬O�ĥεn�J�B���U�٬O�ק�b��
  public static boolean first=false;                    //�ΨӰO���{�b�ϥΪ̦b�s�u�ɡA�O�ݩ���A���٬O�Ȥ��

  //�إߨt�η|�Ψ쪺���B�e���B����
  public static Login login;
  public static Regist regist;
  public static GameLoader gameloader;
  public static Plurk plurk;
  public static Chat chat;
  public static Ranklist ranklist;
  public static NetConnect netconnect;
  public static RoomSelect roomselect;
  public static SelectPictureLoader selpiclod;
  public static Image FramBackground;


  //�إߨt�η|�Ψ쪺�s�u����B�ܼ�
  public static String messagedata="";
  public static int c=0;
  public static int room=0;


  //�ŧi�t�η|�Ψ쪺�����ܼ�
  public static String CodeBase=null;
  public static String DocumentBase=null;
  public static String ID="";
  public static String PW="";
  public static long PlurkCount=0;
  public static long PlurkList=0;
  public static long ChatCount=0;
  public static int backcolor=0;
  public static int picsel=0;
  public static int[] playpicselc=new int[4];
  public static int PlayCount=4;


  private boolean isStandalone = false;
  GridLayout gridLayout1 = new GridLayout();

  //Get a parameter value
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public Main() {
    /*���إ߳s�u���Ʈw�A�H�ѫ᭱��Өt�Ψϥ�*/
    //clsDataBase.ed_ConnectionString = "jdbc:sqlserver://localhost:1433;databaseName=CUTE_GameCity;user=sa;password=sameway;";
    //clsDataBase.ed_ConnectionClass ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //clsDataBase.ed_Connection = clsDataBase.Connect2DataBase(clsDataBase.ed_ConnectionString, clsDataBase.ed_ConnectionClass,clsDataBase.ed_Connection);
    /**/
  }

  //Initialize the applet
  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    /**/
    while (clsNet.SS != null && !clsNet.SS.isClosed()) {
      try {
        clsNet.SS.close();
      } catch (Exception ex) {
      }
    }
    clsNet.LocalPort=(int)(Math.random()*10000);
    clsNet.RemotePort=1111;
    clsNet.SS=clsNet.ListenSocket(clsNet.LocalPort);
    /**/

    /*���x�s�n�t�ΩҦb����Ƨ���m�A�H�ѫ᭱�Y�n���J�Ϥ����a��n�Ψ�ɡA�i�H�H�ɨ���*/
    CodeBase=this.getCodeBase().toString().replaceAll("%20"," ").toString();
    DocumentBase=this.getDocumentBase().toString().replaceAll("%20"," ").toString();
    /**/

    /*�x�s�C�ӨϥΪ̩ҥΪ��Ϲ��N�X*/
    playpicselc[0]=-1;
    playpicselc[1]=-1;
    playpicselc[2]=-1;
    playpicselc[3]=-1;
    /**/

    this.setLayout(gridLayout1);


    login=new Login();
    login.setBounds(400,300,400,300);
    login.setVisible(true);
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }
}
