package cute_gamecity_support;

import java.sql.*;

public class clsDataBase {
  public static Connection ed_Connection=null;
  public static Statement ed_Statement=null;
  public static ResultSet ed_ResultSet=null;

  public static String ed_ConnectionString=null;
  public static String ed_ConnectionClass=null;


  public clsDataBase() {
  }

  /**/
  public static boolean Connect2SQLServer(){
    return true;
  }
  /**/

  /**/
  public static Connection Connect2DataBase(String ConnStr,String ConnCls,Connection Conn){
    try {
      Class.forName(ConnCls);
      Conn = DriverManager.getConnection(ConnStr);
    }catch (Exception e) {
      e.printStackTrace();
    }

    return Conn;
  }
  //�]�wjdbc�s���r��A�Ш̧A��SQL Server�]�w�ȭק�
  //ConnStr = "jdbc:sqlserver://localhost:1433;databaseName=Cute_GameCity;user=sa;password=sameway;"; //for jdbc 1.2
  //���UJODBC���O�A�ëإ߳s�u
  //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  /**/


  /**/
  public static ResultSet OpenRecordset(String SQL,Connection Conn,Statement Stmt, ResultSet RecSet){
    try {
      Stmt = Conn.createStatement();
      RecSet = Stmt.executeQuery(SQL);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return RecSet;
  }
  /**/


  /**/
  public static boolean ExecuteSQL(String SQL, Connection Conn,Statement Stmt) {
    try {
      Stmt = Conn.createStatement();
      Stmt.execute(SQL);

      return true;
    } catch (SQLException e) {
      e.printStackTrace();

      return false;
    }

  }
  /**/

}
