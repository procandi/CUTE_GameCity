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

public class NetConnect extends Frame {
  private boolean isStandalone = false;
  JButton jbtn_submit = new JButton();
  BorderLayout borderLayout1 = new BorderLayout();
  JRadioButton jrb_server = new JRadioButton();
  JRadioButton jrb_client = new JRadioButton();
  JTextField jtxtf_ip = new JTextField();
  ButtonGroup bg_netselect = new ButtonGroup();


  //Construct the applet
  public NetConnect() {
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
    jbtn_submit.addActionListener(new NetConnect_jbtn_submit_actionAdapter(this));
    jbtn_submit.addActionListener(new NetConnect_jbtn_submit_actionAdapter(this));
    this.setLayout(borderLayout1);
    this.setTitle("");
    jrb_server.setVerifyInputWhenFocusTarget(true);
    jrb_server.setSelected(true);
    jrb_server.setText("等待連線模式");
    jrb_client.setText("連線模式(請輸入要連線的IP)");
    jtxtf_ip.setText("127.0.0.1");
    this.add(jrb_server, BorderLayout.NORTH);
    this.add(jrb_client, BorderLayout.WEST);
    this.add(jtxtf_ip, BorderLayout.CENTER);
    this.add(jbtn_submit, BorderLayout.SOUTH);


    bg_netselect.add(jrb_server);
    bg_netselect.add(jrb_client);
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
    clsNet.RemoteIP=jtxtf_ip.getText();
    clsNet.RemotePort=1234;

    if(jrb_server.isSelected()){
      /*Socket S;
      ServerSocket SS;

      try {
        SS = new ServerSocket(1234);
        S = SS.accept();

        if (S.isConnected() && Main.pm==0) {
          SS.close();
          S.close();
          SS=null;
          S=null;

          Main.pm=1;
          Main.first=false;
          this.dispose();
          Main.gameloader = new GameLoader();
          Main.gameloader.setVisible(true);
        }
      } catch (IOException ioe) {
      }*/
      if (Main.pm==0) {
        Main.pm=1;
        Main.first=false;
        this.dispose();
        Main.gameloader = new GameLoader();
        Main.gameloader.setVisible(true);
      }

    }else if(jrb_client.isSelected()){
      /*Socket S;

      try {
        S = new Socket(jtxtf_ip.getText(), 1234);

        if(Main.pm==0){
          S.close();
          S=null;

          Main.pm=1;
          Main.first = true;
          this.dispose();
          Main.gameloader = new GameLoader();
          Main.gameloader.setVisible(true);
        }
      } catch (IOException ioe) {
      }*/
      if(Main.pm==0){
        Main.pm=1;
        Main.first = true;
        this.dispose();
        Main.gameloader = new GameLoader();
        Main.gameloader.setVisible(true);
      }
    }

  }
}

class NetConnect_jbtn_submit_actionAdapter implements java.awt.event.ActionListener {
  NetConnect adaptee;

  NetConnect_jbtn_submit_actionAdapter(NetConnect adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_submit_actionPerformed(e);
  }
}
