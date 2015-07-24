package cute_gamecity_support;

import javax.swing.UIManager;
import java.awt.*;
import java.util.GregorianCalendar;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class appSupport {
  frmSupport frmsupport;
  ListenSocketThread lst=new ListenSocketThread();

  public static boolean isClose=false;


  int i;

  int[] RoomCount=new int[2];
  String[][] RoomIP=new String[2][4];
  int[][] RoomPort=new int[2][4];
  int[][] RoomFace=new int[2][4];


  //Construct the application
  public appSupport() {
    /*先建立連線到資料庫，以供後面整個系統使用*/
    clsDataBase.ed_ConnectionString = "jdbc:sqlserver://127.0.0.1:1433;databaseName=CUTE_GameCity;user=sa;password=stdyhs;";
    clsDataBase.ed_ConnectionClass ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    clsDataBase.ed_Connection = clsDataBase.Connect2DataBase(clsDataBase.ed_ConnectionString, clsDataBase.ed_ConnectionClass,clsDataBase.ed_Connection);
    /**/

    /**/
    clsNet.LocalPort=1111;
    //clsNet.RemotePort=4444;
    clsNet.SS=clsNet.ListenSocket(clsNet.LocalPort);
    /**/

    /**/
    frmsupport=new frmSupport();
    frmsupport.setBounds(400,300,400,300);
    frmsupport.show();
    /**/

    for(i=0;i<1;i++){
      RoomCount[i]=0;
    }

    lst.start();
  }

  //Main method
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }catch(Exception e) {
      e.printStackTrace();
    }
    new appSupport();
  }



  public class ListenSocketThread extends Thread {
    int i;
    boolean flag;

    String SQLString = null;
    String table;
    String values;

    String data = null;
    String ls=null;
    String lsbk=null;
    String[] temp;
    char[] tempchar;
    int tempint;
    int tempid;

    GregorianCalendar g;
    String today = "";
    long PlurkCount=0;
    long ChatCount=0;
    int PlurkSelectPort=9999;
    int ChatSelectPort=9998;

    public void run() {
      while (!isClose){
        try {
          data = clsNet.GetData(clsNet.SS, 50000);
          System.out.println(data);

          if (data != null && !data.equals("")) {
            temp=data.split(" ");
            clsNet.RemotePort=Integer.parseInt(temp[0]);
            tempchar=temp[1].toCharArray();

            switch(tempchar[0]){
              case 'r':  //註冊相關命令


                tempchar=temp[2].toCharArray();

                switch(tempchar[0]){
                  case 'q':  //查詢是否有此帳號
                    SQLString = "SELECT * FROM TB_Account where ID='" + temp[3] + "'";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);

                    if (clsDataBase.ed_ResultSet.next()) {
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,"true", 50000);
                    }else {
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,"false", 50000);
                    }
                    break;

                  case 'd':  //調閱帳號資料
                    SQLString = "SELECT * FROM TB_Account where ID='" + temp[3] + "'";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);

                    if (clsDataBase.ed_ResultSet.next()) {
                      data = clsDataBase.ed_ResultSet.getString("ID");
                      data += (" " + clsDataBase.ed_ResultSet.getString("name"));

                      if (clsDataBase.ed_ResultSet.getString("sex").equals("0")) {
                        data += (" 女");
                      } else {
                        data += (" 男");
                      }

                      data += (" " + clsDataBase.ed_ResultSet.getString("birthday").replace('-', '/').substring(0, 10));
                      data += (" " + clsDataBase.ed_ResultSet.getString("email"));
                      data += (" " + clsDataBase.ed_ResultSet.getString("picture"));

                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, data, 50000);
                    }else{
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "", 50000);
                    }
                    break;


                  case 'l':  //登錄帳號
                    SQLString = "SELECT * FROM TB_Account where ID='" + temp[3] + "' and PW='" + temp[4] + "'";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);

                    if (clsDataBase.ed_ResultSet.next()) {
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,"true" + clsDataBase.ed_ResultSet.getString(7), 50000);
                    } else {
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,"false", 50000);
                    }
                    break;


                  case 'n':  //註冊新的帳號
                    SQLString = "SELECT * FROM TB_Account where ID='" + temp[3] + "'";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);

                    if (clsDataBase.ed_ResultSet.next()) {
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "true",50000);
                    }else{
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "false",50000);
                    }
                    break;


                  case 'u':  //修改帳號資料
                    SQLString = "SELECT * FROM TB_Account where ID='" + temp[3] + "' and PW='" + temp[4] + "'";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);

                    if (clsDataBase.ed_ResultSet.next()) {
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,"true", 50000);
                    }else {
                      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,"false", 50000);
                    }
                    break;


                  default:
                    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "false", 50000);
                    break;
                }

                break;


              case 'g':  //遊戲相關資料收發
                tempchar=temp[2].toCharArray();
                tempint=tempchar[0]-'0';

                switch(tempchar[0]){
                  case '0':  //有人連線房間一或房間二
                  case '1':
                    //System.out.println(temp[3] + " " + temp[0]);
                    for(flag=true,i=0;i<RoomCount[tempint];i++){
                      if(RoomIP[tempint][i].equals(temp[3]) && RoomPort[tempint][i]==Integer.parseInt(temp[0])){
                        //System.out.println("in");
                        flag=false;
                      }
                      //System.out.println(i + " " + RoomIP[tempint][i] + " " + RoomPort[tempint][i]);
                    }
                    //System.out.println(flag + " " + RoomCount[tempint]);
                    //System.out.println();

                    if(flag){
                      flag=false;

                      RoomIP[tempint][RoomCount[tempint]] = temp[3];
                      RoomPort[tempint][RoomCount[tempint]] = Integer.parseInt(temp[0]);
                      RoomFace[tempint][RoomCount[tempint]]= Integer.parseInt(temp[4]);
                      RoomCount[tempint]++;

                      clsNet.SendData(RoomIP[tempint][i], RoomPort[tempint][i], tempint + " " + i, 50000);
                    }else if (RoomCount[tempint] >= 4) {
                      for (i = 0; i < 4; i++) {
                        clsNet.SendData(RoomIP[tempint][i], RoomPort[tempint][i], "s4 " + RoomFace[tempint][0] + " " + RoomFace[tempint][1] + " " + RoomFace[tempint][2] + " " + RoomFace[tempint][3], 50000);
                      }
                    }

                    break;


                  case 'c':  //同步所客戶端的牌組
                    tempchar=temp[3].toCharArray();
                    tempint=tempchar[0]-'0';

                    for(i=1;i<RoomCount[tempint];i++){
                       clsNet.SendData(RoomIP[tempint][i],RoomPort[tempint][i],temp[4],50000);
                    }

                    break;


                  case 's':  //取得指定玩家的歷史成績
                    SQLString = "SELECT top 1 * from TB_Game_Score where ID='" + temp[3] + "' and Class='" + temp[4] + "'";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString, clsDataBase.ed_Connection, clsDataBase.ed_Statement, clsDataBase.ed_ResultSet);

                    if (clsDataBase.ed_ResultSet.next()) {
                      ls = "false";
                      ls += (" " + clsDataBase.ed_ResultSet.getString("PlayFrequency"));
                      ls += (" " + clsDataBase.ed_ResultSet.getString("WinFrequency"));
                      ls += (" " + clsDataBase.ed_ResultSet.getString("LoseFrequency"));
                      ls += (" " + clsDataBase.ed_ResultSet.getString("HighScore"));
                      ls += (" " + clsDataBase.ed_ResultSet.getString("TotalScore"));
                    } else {
                      ls = "true";
                      ls +=" 0 0 0 0 0";
                    }

                    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, ls, 50000);

                    break;


                  case 'n':  //同步遊戲中每個玩家目前取牌現況
                    tempchar=temp[3].toCharArray();
                    tempint=tempchar[0]-'0';

                    tempchar=temp[4].toCharArray();
                    tempid=tempchar[0]-'0';

                    for(i=0;i<RoomCount[tempint];i++){
                      if(tempid!=i){
                        clsNet.SendData(RoomIP[tempint][i],RoomPort[tempint][i],temp[5],50000);
                      }
                    }

                    break;


                  case 'e':  //每結束一場，就清除一場的連線資料
                    tempchar=temp[3].toCharArray();
                    tempint=tempchar[0]-'0';

                    RoomCount[tempint]=0;
                    break;


                  case 'd':  //有玩家等不及了，送出直接開場
                    tempchar=temp[3].toCharArray();
                    tempint=tempchar[0]-'0';

                    for (ls="",i = 0; i < RoomCount[tempint]; i++) {
                      ls = ls + " " + RoomFace[tempint][i];
                    }
                    for (i = 0; i < RoomCount[tempint]; i++) {
                      clsNet.SendData(RoomIP[tempint][i], RoomPort[tempint][i], "s" + RoomCount[tempint] + ls, 50000);
                    }

                    break;


                }

                break;


              case 'q':  //查詢遊戲成績
                /*十點半遊戲次數排行*/
                SQLString = "SELECT top 10 * FROM VW_105PlayRank";
                clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString, clsDataBase.ed_Connection, clsDataBase.ed_Statement, clsDataBase.ed_ResultSet);
                //lsbk="";

                ls = "帳號  遊戲次數  總分";
                while (clsDataBase.ed_ResultSet.next()) {
                  ls += ",";
                  ls += (clsDataBase.ed_ResultSet.getString("ID") + "  " + clsDataBase.ed_ResultSet.getString("PlayFrequency") + "            " + clsDataBase.ed_ResultSet.getString("TotalScore"));
                }
                //lsbk+=(ls+":");
                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,ls, 50000);


                /*十點半獲勝次數排行*/
                SQLString = "SELECT top 10 * FROM VW_105WinRank";
                clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);
                ls="帳號  獲勝次數  總分";
                while (clsDataBase.ed_ResultSet.next()) {
                  ls += ",";
                  ls+=(clsDataBase.ed_ResultSet.getString("ID")+"  "+clsDataBase.ed_ResultSet.getString("PlayFrequency")+"            "+clsDataBase.ed_ResultSet.getString("TotalScore"));
                }
                //lsbk+=(ls+":");
                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,ls, 50000);


                /*十點半平均分數排行*/
                SQLString = "SELECT top 10 * FROM VW_105AverRank";
                clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);
                ls="帳號  遊戲次數  平均";
                while (clsDataBase.ed_ResultSet.next()) {
                  ls += ",";
                  ls+=(clsDataBase.ed_ResultSet.getString("ID")+"  "+clsDataBase.ed_ResultSet.getString("PlayFrequency")+"            "+((int)Double.parseDouble(clsDataBase.ed_ResultSet.getString("AverageScore"))));
                }
                //lsbk+=(ls+":");
                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,ls, 50000);


                /*二十一點遊戲次數排行*/
                SQLString = "SELECT top 10 * FROM VW_210PlayRank";
                clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);
                ls="帳號  遊戲次數  總分";
                while (clsDataBase.ed_ResultSet.next()) {
                  ls += ",";
                  ls+=(clsDataBase.ed_ResultSet.getString("ID")+"  "+clsDataBase.ed_ResultSet.getString("PlayFrequency")+"            "+clsDataBase.ed_ResultSet.getString("TotalScore"));
                }
                //lsbk+=(ls+":");
                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,ls, 50000);


                /*二十一點獲勝次數排行*/
                SQLString = "SELECT top 10 * FROM VW_210WinRank";
                clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);
                ls="帳號  獲勝次數  總分";
                while (clsDataBase.ed_ResultSet.next()) {
                  ls += ",";
                  ls+=(clsDataBase.ed_ResultSet.getString("ID")+"  "+clsDataBase.ed_ResultSet.getString("PlayFrequency")+"            "+clsDataBase.ed_ResultSet.getString("TotalScore"));
                }
                //lsbk+=(ls+":");
                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,ls, 50000);


                /*二十一點平均分數排行*/
                SQLString = "SELECT top 10 * FROM VW_210AverRank";
                clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);
                ls="帳號  遊戲次數  平均";
                while (clsDataBase.ed_ResultSet.next()) {
                  ls += ",";
                  ls+=(clsDataBase.ed_ResultSet.getString("ID")+"  "+clsDataBase.ed_ResultSet.getString("PlayFrequency")+"            "+((int)Double.parseDouble(clsDataBase.ed_ResultSet.getString("AverageScore"))));
                }
                //lsbk+=(ls);
                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,ls, 50000);

                //clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,lsbk, 50000);


                break;


              case 'e':  //單純執行SQL Command
                for(SQLString="",i=2;i<temp.length;i++){
                  SQLString+=(temp[i]+" ");
                }
                clsDataBase.ExecuteSQL(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement);

                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort,"true", 50000);
                break;


              case 'p':  //噗浪相關命令
                tempchar=temp[2].toCharArray();

                switch(tempchar[0]){
                  case 'q':  //查詢前一百筆噗浪記錄
                    SQLString = "SELECT top 100 * FROM VW_Plurk_Record order by Unikey desc";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString,clsDataBase.ed_Connection, clsDataBase.ed_Statement,clsDataBase.ed_ResultSet);

                    ls="";
                    lsbk="";
                    while (clsDataBase.ed_ResultSet.next()) {
                      ls+=",p,";
                      ls += (clsDataBase.ed_ResultSet.getString("Name") + "於" +
                          clsDataBase.ed_ResultSet.getString("PlurkTime") + "時說：" +
                          clsDataBase.ed_ResultSet.getString("Body"));

                      lsbk+=",p,";
                      lsbk+=clsDataBase.ed_ResultSet.getString("Unikey");
                    }
                    ls=ls.substring(3);
                    lsbk=lsbk.substring(3);
                    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort , ls, 50000);
                    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort , lsbk, 50000);
                    break;


                  case 'i':  //寫入一筆噗浪記錄
                    /*取得今天星期幾*/
                    g = new GregorianCalendar();
                    today = g.get(GregorianCalendar.YEAR) + "/" + (g.get(GregorianCalendar.MONTH) + 1) + "/" + g.get(GregorianCalendar.DATE);
                    today += " ";
                    today += g.get(GregorianCalendar.HOUR_OF_DAY) + ":" + g.get(GregorianCalendar.MINUTE) + ":" + g.get(GregorianCalendar.SECOND);
                    /**/

                    /*取得目前的ID應該叫多少*/
                    SQLString = "SELECT top 1 Unikey FROM TB_Plurk_Record order by Unikey desc";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString, clsDataBase.ed_Connection, clsDataBase.ed_Statement, clsDataBase.ed_ResultSet);
                    try {
                      if (clsDataBase.ed_ResultSet.next()) {
                        PlurkCount = Long.parseLong(clsDataBase.ed_ResultSet.getString("Unikey")) + 1;
                      } else {
                        PlurkCount = 0;
                      }
                    } catch (Exception ex) {
                      ex.printStackTrace();
                    }
                    /**/

                    /*插入一筆噗文到資料庫*/
                    for(ls="",i=4;i<temp.length;i++){
                      ls+=temp[i];
                    }
                    table = "Unikey,ID,PlurkTime,Body";
                    values = "'" + PlurkCount + "','" + temp[3] + "','" + today + "','" + ls + "'";
                    SQLString = "insert into TB_Plurk_Record (" + table + ") values (" + values + ")";
                    clsDataBase.ExecuteSQL(SQLString, clsDataBase.ed_Connection, clsDataBase.ed_Statement);
                    /**/

                    break;

                  default:
                    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "false", 50000);
                    break;
                }

                break;


              case 'c':
                tempchar = temp[2].toCharArray();

                switch (tempchar[0]) {
                  case 'q': //查詢前一百筆聊天記錄
                    SQLString = "SELECT * FROM VW_Chat_Record where Unikey='" + temp[3] + "' order by Unikey desc";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString, clsDataBase.ed_Connection, clsDataBase.ed_Statement, clsDataBase.ed_ResultSet);

                    ls = "";
                    while (clsDataBase.ed_ResultSet.next()) {
                      ls += ",c,";
                      ls += (clsDataBase.ed_ResultSet.getString("Name") + "於" +
                          clsDataBase.ed_ResultSet.getString("ChatTime") + "時說：" +
                          clsDataBase.ed_ResultSet.getString("Body"));
                    }
                    ls = ls.substring(3);
                    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort , ls, 50000);
                    break;


                  case 'i':  //新增一筆留言記錄
                    /*取得今天星期幾*/
                    g = new GregorianCalendar();
                    today = g.get(GregorianCalendar.YEAR) + "/" + (g.get(GregorianCalendar.MONTH) + 1) + "/" + g.get(GregorianCalendar.DATE);
                    today += " ";
                    today += g.get(GregorianCalendar.HOUR_OF_DAY) + ":" + g.get(GregorianCalendar.MINUTE) + ":" + g.get(GregorianCalendar.SECOND);
                    /**/


                    /*取得目前的ID應該叫多少*/
                    SQLString = "SELECT top 1 Chkey FROM TB_Chat_Record where Unikey='" + temp[3] + "' order by Chkey desc";
                    clsDataBase.ed_ResultSet = clsDataBase.OpenRecordset(SQLString, clsDataBase.ed_Connection, clsDataBase.ed_Statement, clsDataBase.ed_ResultSet);
                    try {
                      if (clsDataBase.ed_ResultSet.next()) {
                        ChatCount = Long.parseLong(clsDataBase.ed_ResultSet.getString("Chkey")) + 1;
                      } else {
                        ChatCount = 0;
                      }
                    } catch (Exception ex) {
                      ex.printStackTrace();
                    }
                    /**/


                    /*插入一筆噗文到資料庫*/
                    for(ls="",i=5;i<temp.length;i++){
                      ls+=temp[i];
                    }
                    table = "Unikey,Chkey,ID,ChatTime,Body";
                    values = "'" + temp[3] + "','" + ChatCount + "','" + temp[4] + "','" + today + "','" + ls + "'";
                    SQLString = "insert into TB_Chat_Record (" + table + ") values (" + values + ")";
                    clsDataBase.ExecuteSQL(SQLString, clsDataBase.ed_Connection, clsDataBase.ed_Statement);
                    /**/

                    break;


                  default:
                    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "false", 50000);
                    break;
                }

                break;


              default:
                clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "false", 50000);
                break;
            }

          }else {
            clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, "false", 50000);
          }

          this.sleep(1000);
        }catch (Exception ex) {
          ex.printStackTrace();
        }
      }


    }
  }


}
