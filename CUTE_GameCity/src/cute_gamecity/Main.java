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
  //宣告控制整個系統流程的公用變數
  public static int gs=0;                               //用來記錄現在使用者所選擇的遊戲是哪一款
  public static int pm=0;                               //用來記錄現在使用者所選擇的是單玩還是連線模式
  public static int rore=0;                             //用來記錄現在使用者是採用登入、註冊還是修改帳號
  public static boolean first=false;                    //用來記錄現在使用者在連線時，是屬於伺服端還是客戶端

  //建立系統會用到的表單、畫布、物件
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


  //建立系統會用到的連線物件、變數
  public static String messagedata="";
  public static int c=0;
  public static int room=0;


  //宣告系統會用到的公用變數
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
    /*先建立連線到資料庫，以供後面整個系統使用*/
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

    /*先儲存好系統所在的資料夾位置，以供後面若要載入圖片等地方要用到時，可以隨時取用*/
    CodeBase=this.getCodeBase().toString().replaceAll("%20"," ").toString();
    DocumentBase=this.getDocumentBase().toString().replaceAll("%20"," ").toString();
    /**/

    /*儲存每個使用者所用的圖像代碼*/
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
