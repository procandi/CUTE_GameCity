package cute_gamecity;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import com.borland.jbcl.layout.*;
import java.net.*;
import java.io.*;
import java.util.GregorianCalendar;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Plurk extends Panel {
  /*變數*/
  public static long[] unikey=new long[100];
  public static int chat_count=0;
  /**/

  /*物件*/
  ChangePlurkThread CP_TH=new ChangePlurkThread();
  /**/

  private boolean isStandalone = false;
  BorderLayout borderLayout1 = new BorderLayout();
  JButton jbtn_plurk = new JButton();
  JTextField jtxtf_plurk = new JTextField();
  JPanel jpanel_plurk = new JPanel();
  JList jlist_plurk = new JList();
  JScrollBar jsb_plurk = new JScrollBar();


  //Construct the applet
  public Plurk() {
    init();
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
    this.setFont(new java.awt.Font("MS Sans Serif", 0, 11));
    this.setForeground(Color.black);
    this.setLocale(java.util.Locale.getDefault());

    this.setLayout(borderLayout1);
    jbtn_plurk.setText("噗文");
    jbtn_plurk.addActionListener(new Plurk_jbtn_plurk_actionAdapter(this));
    jtxtf_plurk.setText("你說：");
    jpanel_plurk.setLayout(null);
    jlist_plurk.addMouseListener(new Plurk_jlist_plurk_mouseAdapter(this));
    jlist_plurk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jlist_plurk.addMouseListener(new Plurk_jlist_plurk_mouseAdapter(this));
    jsb_plurk.addAdjustmentListener(new Plurk_jsb_plurk_adjustmentAdapter(this));
    jsb_plurk.addAdjustmentListener(new Plurk_jsb_plurk_adjustmentAdapter(this));
    this.add(jtxtf_plurk, BorderLayout.SOUTH);
    this.add(jbtn_plurk, BorderLayout.EAST);
    this.add(jpanel_plurk, BorderLayout.CENTER);
    jpanel_plurk.add(jlist_plurk, null);
    jpanel_plurk.add(jsb_plurk, null);

    /**/
    jlist_plurk.setBounds(0,0,950,600);
    jsb_plurk.setBounds(950,0,24,30);
    /**/

    CP_TH.start();
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  void jbtn_plurk_actionPerformed(ActionEvent e)  {
    /*插入一筆噗文到資料庫*/
    try{
      clsNet.SendData(clsNet.RemoteIP,clsNet.RemotePort, clsNet.PlurkSelectPort + " p i "+Main.ID+" "+jtxtf_plurk.getText().substring(3),50000);
      jtxtf_plurk.setText("你說：");
    }catch(Exception ex){
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null,"噗文失敗！");
    }
    /**/
  }

  void jlist_plurk_mouseClicked(MouseEvent e) {
    if(jlist_plurk.getSelectedIndex()!=-1 && chat_count==0){
      chat_count++;
      System.out.println("IN");
      Main.PlurkList = unikey[jlist_plurk.getSelectedIndex()];

      Main.chat = new Chat();
      Main.chat.setBounds(400, 300, 400, 300);
      Main.chat.setVisible(true);
    }
  }

  void jsb_plurk_adjustmentValueChanged(AdjustmentEvent e) {
    jlist_plurk.setBounds(new Rectangle(0, -e.getValue(), 950, 600));
  }

}

class Plurk_jbtn_plurk_actionAdapter implements java.awt.event.ActionListener {
  Plurk adaptee;

  Plurk_jbtn_plurk_actionAdapter(Plurk adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_plurk_actionPerformed(e);
  }
}

class ChangePlurkThread extends Thread{
  public void run() {
    while(clsNet.PlurkSS!=null && !clsNet.PlurkSS.isClosed()){
      try {
        clsNet.PlurkSS.close();
      } catch (Exception ex) {
      }
    }
    clsNet.PlurkSelectPort=(int)(Math.random()*1000);
    clsNet.PlurkSS = clsNet.ListenSocket(clsNet.PlurkSelectPort);

    while(true){
      int i=0;
      String[] ls;

      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.PlurkSelectPort + " p q",50000);

      try{
        Main.messagedata=clsNet.GetData(clsNet.PlurkSS, 50000);
        ls=Main.messagedata.split(",p,");
        Main.plurk.jlist_plurk.setListData(ls);

        Main.messagedata=clsNet.GetData(clsNet.PlurkSS, 50000);
        ls = Main.messagedata.split(",p,");
        for (i = 0; i < ls.length; i++) {
          Plurk.unikey[i] = Long.parseLong(ls[i]);
        }
      }catch(Exception ex){
        //ex.printStackTrace();
        break;
      }


      try {
        this.sleep(1000);
      } catch (InterruptedException ie) {
      }
    }
  }
}

class Plurk_jsb_plurk_adjustmentAdapter implements java.awt.event.AdjustmentListener {
  Plurk adaptee;

  Plurk_jsb_plurk_adjustmentAdapter(Plurk adaptee) {
    this.adaptee = adaptee;
  }
  public void adjustmentValueChanged(AdjustmentEvent e) {
    adaptee.jsb_plurk_adjustmentValueChanged(e);
  }
}

class Plurk_jlist_plurk_mouseAdapter extends java.awt.event.MouseAdapter {
  Plurk adaptee;

  Plurk_jlist_plurk_mouseAdapter(Plurk adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.jlist_plurk_mouseClicked(e);
  }
}

