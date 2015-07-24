package cute_gamecity;

import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
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

public class RoomSelect extends Frame {
  private boolean isStandalone = false;
  JButton jbtn_submit = new JButton();
  BorderLayout borderLayout1 = new BorderLayout();
  ButtonGroup bg_netselect = new ButtonGroup();
  JComboBox jcb_room = new JComboBox();

  RoomSelectThread rst=new RoomSelectThread();
  boolean ClickCheck=false;
  JButton jbtn_open = new JButton();


  //Construct the applet
  public RoomSelect() {
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
    this.setBounds(100,75,400,100);
    jbtn_submit.setText("確定");
    jbtn_submit.addActionListener(new RoomSelect_jbtn_submit_actionAdapter(this));
    jbtn_submit.addActionListener(new RoomSelect_jbtn_submit_actionAdapter(this));
    this.setLayout(borderLayout1);
    this.setTitle("");
    jbtn_open.setText("暫無功能");
    jbtn_open.addActionListener(new RoomSelect_jbtn_open_actionAdapter(this));
    this.add(jbtn_submit, BorderLayout.CENTER);
    this.add(jcb_room, BorderLayout.NORTH);
    this.add(jbtn_open, BorderLayout.EAST);

    jcb_room.addItem("房間一");
    jcb_room.addItem("房間二");

    rst.start();
  }

  public void paint(Graphics g){
    if(Main.FramBackground==null){
      Main.FramBackground=Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/bk/purple.png").substring(6));
    }
    g.drawImage(Main.FramBackground, 0, 0, this);
    this.paintComponents(g);
  }


  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  void jbtn_submit_actionPerformed(ActionEvent e) {
    if(jbtn_submit.getText().equals("確定")){
      jbtn_submit.setText("連線中，等候滿四個人");
      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " g " + jcb_room.getSelectedIndex() + " " + clsNet.LocalIP + " " + Main.playpicselc[0], 50000);
      ClickCheck=true;
      jbtn_open.setText("直接開房");
    }
  }

  void jbtn_open_actionPerformed(ActionEvent e) {
    if (ClickCheck) {
      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " g d " + jcb_room.getSelectedIndex(), 50000);
    }
  }
}


class RoomSelectThread extends Thread{
  int i;
  String[] ls;

  public void run() {
    while(true){
      try{
        Main.messagedata=clsNet.GetData(clsNet.SS, 50000);
        System.out.println(Main.messagedata);

        if(!Main.messagedata.equals("")){
          ls = Main.messagedata.split(" ");

          if (ls[0].equals("s1") || ls[0].equals("s2") || ls[0].equals("s3") || ls[0].equals("s4")) {
            Main.PlayCount = Integer.parseInt(ls[0].substring(1));
            for(i=0;i<Main.PlayCount;i++){
              Main.playpicselc[i]=Integer.parseInt(ls[i+1]);
            }

            Main.pm = 1;
            Main.gameloader = new GameLoader();
            Main.gameloader.setVisible(true);
            Main.roomselect.dispose();
            break;
          } else {
            Main.room = Integer.parseInt(ls[0]);
            Main.c = Integer.parseInt(ls[1]);
          }
        }
      }catch(Exception ex){
        ex.printStackTrace();
      }


      try {
        this.sleep(1000);
      } catch (InterruptedException ie) {
      }
    }
  }
}


class RoomSelect_jbtn_submit_actionAdapter implements java.awt.event.ActionListener {
  RoomSelect adaptee;

  RoomSelect_jbtn_submit_actionAdapter(RoomSelect adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_submit_actionPerformed(e);
  }
}

class RoomSelect_jbtn_open_actionAdapter implements java.awt.event.ActionListener {
  RoomSelect adaptee;

  RoomSelect_jbtn_open_actionAdapter(RoomSelect adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_open_actionPerformed(e);
  }
}
