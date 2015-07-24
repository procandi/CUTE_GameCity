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
import java.util.Locale;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Chat extends Frame {
  ChangeChatThread CC_TH=new ChangeChatThread();

  private boolean isStandalone = false;
  JList jlist_chat = new JList();
  JButton jbtn_chat = new JButton();
  JTextField jtxtf_chat = new JTextField();
  JButton jbtn_exit = new JButton();
  JScrollBar jsb_chat = new JScrollBar();


  //Construct the applet
  public Chat() {
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
    this.setIgnoreRepaint(false);
    this.setForeground(Color.black);
    this.setLocale(java.util.Locale.getDefault());

    this.setLayout(null);
    this.setBounds(100,75,400,300);
    jbtn_chat.setBounds(new Rectangle(345, 137, 55, 141));
    jbtn_chat.setText("留言");
    jbtn_chat.addActionListener(new Chat_jbtn_chat_actionAdapter(this));
    jtxtf_chat.setText("你說：");
    jtxtf_chat.setBounds(new Rectangle(0, 278, 400, 22));
    jbtn_exit.setBounds(new Rectangle(346, 33, 54, 105));
    jbtn_exit.setText("離開");
    jbtn_exit.addActionListener(new Chat_jbtn_exit_actionAdapter(this));
    jlist_chat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jlist_chat.setBounds(new Rectangle(0, 33, 330, 245));
    jsb_chat.addAdjustmentListener(new Chat_jsb_chat_adjustmentAdapter(this));
    jlist_chat.add(jsb_chat);
    jsb_chat.setBounds(new Rectangle(330, 33, 18, 245));
    this.add(jlist_chat, null);
    this.add(jbtn_chat, null);
    this.add(jtxtf_chat, null);
    this.add(jbtn_exit, null);
    this.add(jsb_chat, null);

    CC_TH.start();
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  void jbtn_chat_actionPerformed(ActionEvent e)  {
    /*插入一筆留言到資料庫*/
    try{
      clsNet.SendData(clsNet.RemoteIP,clsNet.RemotePort, clsNet.ChatSelectPort + " c i "+Main.PlurkList+" "+Main.ID+" "+jtxtf_chat.getText().substring(3),50000);
      jtxtf_chat.setText("你說：");
    }catch(Exception ex){
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null,"留言失敗！");
    }
    /**/
  }

  void jbtn_exit_actionPerformed(ActionEvent e) {
    Main.plurk.chat_count--;
    this.dispose();
  }

  void jsb_chat_adjustmentValueChanged(AdjustmentEvent e) {
    jlist_chat.setBounds(new Rectangle(0, 33-e.getValue(), 330, 245));
  }
}

class Chat_jbtn_chat_actionAdapter implements java.awt.event.ActionListener {
  Chat adaptee;

  Chat_jbtn_chat_actionAdapter(Chat adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_chat_actionPerformed(e);
  }
}

class ChangeChatThread extends Thread{
  public void run() {
    while(clsNet.ChatSS!=null && !clsNet.ChatSS.isClosed()){
      try {
        clsNet.ChatSS.close();
      } catch (Exception ex) {
      }
    }
    clsNet.ChatSelectPort=(int)(Math.random()*10000);
    clsNet.ChatSS=clsNet.ListenSocket(clsNet.ChatSelectPort);


    while(true){
      String[] ls;

      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.ChatSelectPort + " c q " + Main.PlurkList,50000);

      try{
        Main.messagedata=clsNet.GetData(clsNet.ChatSS, 50000);

        ls = Main.messagedata.split(",c,");
        Main.chat.jlist_chat.setListData(ls);
      } catch (Exception ex) {
        ex.printStackTrace();
      }


      try {
        this.sleep(1000);
      } catch (Exception ex) {
        //ex.printStackTrace();
        break;
      }
    }
    }
}

class Chat_jbtn_exit_actionAdapter implements java.awt.event.ActionListener {
  Chat adaptee;

  Chat_jbtn_exit_actionAdapter(Chat adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_exit_actionPerformed(e);
  }
}

class Chat_jsb_chat_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  Chat adaptee;

  Chat_jsb_chat_mouseMotionAdapter(Chat adaptee) {
    this.adaptee = adaptee;
  }
}

class Chat_jsb_chat_adjustmentAdapter implements java.awt.event.AdjustmentListener {
  Chat adaptee;

  Chat_jsb_chat_adjustmentAdapter(Chat adaptee) {
    this.adaptee = adaptee;
  }
  public void adjustmentValueChanged(AdjustmentEvent e) {
    adaptee.jsb_chat_adjustmentValueChanged(e);
  }
}

