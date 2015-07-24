package cute_gamecity;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import com.borland.jbcl.layout.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Login extends Frame {
  private boolean isStandalone = false;
  JTextField jtxtf_ID = new JTextField();
  JPasswordField jtxtf_PW = new JPasswordField();
  JButton jbtn_Submit = new JButton();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JRadioButton jrb_105 = new JRadioButton();
  JRadioButton jrb_210 = new JRadioButton();
  JRadioButton jrb_login = new JRadioButton();
  JRadioButton jrb_edit = new JRadioButton();
  JRadioButton jrb_single = new JRadioButton();
  JRadioButton jrb_connect = new JRadioButton();
  ButtonGroup bg_gameselect = new ButtonGroup();
  ButtonGroup bg_regist = new ButtonGroup();
  ButtonGroup bg_mode = new ButtonGroup();
  JRadioButton jrb_regist = new JRadioButton();
  JRadioButton jrb_rank = new JRadioButton();
  JComboBox jcb_color = new JComboBox();


  //Construct the applet
  public Login() {
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
    jtxtf_ID.setSelectionStart(11);
    jtxtf_ID.setText("test1");
    jtxtf_PW.setBorder(BorderFactory.createLineBorder(Color.black));
    jtxtf_PW.setToolTipText("");
    jtxtf_PW.setVerifyInputWhenFocusTarget(true);
    jtxtf_PW.setSelectionEnd(11);
    jtxtf_PW.setText("1111");
    jtxtf_PW.setScrollOffset(0);
    jbtn_Submit.setText("確定");
    jbtn_Submit.addActionListener(new Login_jbtn_Submit_actionAdapter(this));
    this.setFont(new java.awt.Font("MS Sans Serif", 0, 11));
    //this.setBackground(Color.pink);
    this.setForeground(Color.black);
    this.setLocale(java.util.Locale.getDefault());
    this.setLayout(gridBagLayout1);
    jLabel1.setText("  帳  號：");
    jLabel2.setText("  密  碼：");
    jLabel3.setFont(new java.awt.Font("Dialog", 1, 24));
    jLabel3.setAlignmentX((float) 0.0);
    jLabel3.setToolTipText("");
    jLabel3.setText("線上P-GAME連網");
    jrb_105.setSelected(false);
    jrb_105.setBackground(Color.pink);
    jrb_105.setBorderPainted(false);
    jrb_105.setContentAreaFilled(true);
    jrb_105.setText("  十點半");
    jrb_210.setBackground(Color.pink);
    jrb_210.setText("二十一點");
    jrb_login.setBackground(Color.pink);
    jrb_login.setText("    登入");
    jrb_edit.setBackground(Color.pink);
    jrb_edit.setToolTipText("");
    jrb_edit.setVerifyInputWhenFocusTarget(true);
    jrb_edit.setActionCommand("註冊");
    jrb_edit.setText("修改個人資料");
    jrb_single.setBackground(Color.pink);
    jrb_single.setAlignmentY((float) 0.5);
    jrb_single.setText("單機模式");
    jrb_connect.setBackground(Color.pink);
    jrb_connect.setAlignmentY((float) 0.5);
    jrb_connect.setText("連線模式");
    jrb_regist.setText("註冊   ");
    jrb_regist.setActionCommand("註冊");
    jrb_regist.setVerifyInputWhenFocusTarget(true);
    jrb_regist.setBackground(Color.pink);
    jrb_rank.setText("排行榜");
    jrb_rank.setAlignmentY((float) 0.5);
    jrb_rank.setBackground(Color.pink);
    this.add(jLabel1,                                                   new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel2,                                              new GridBagConstraints(0, 2, 1, 2, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jtxtf_PW,                                                                   new GridBagConstraints(2, 2, 2, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 44), 220, 0));
    this.add(jtxtf_ID,                                                  new GridBagConstraints(2, 1, 2, 1, 1.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 40), 212, 0));
    this.add(jbtn_Submit,                                      new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(17, 0, 18, 0), 68, 0));
    this.add(jrb_connect,                         new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 6, 0));
    this.add(jrb_single,                     new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jrb_210,                      new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 6, 0));
    this.add(jrb_105,                  new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 4, 0));
    this.add(jrb_login,                                                         new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 9), 1, 0));
    this.add(jrb_edit,                                 new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 43, 0, 3), 24, 0));
    this.add(jrb_regist,                new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jrb_rank,               new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jcb_color,                  new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 1, 0));
    this.add(jLabel3,      new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(1, 46, 3, 74), 175, 50));

    bg_gameselect.add(jrb_105);
    bg_gameselect.add(jrb_210);
    bg_gameselect.add(jrb_rank);
    jrb_105.setSelected(true);

    bg_regist.add(jrb_regist);
    bg_regist.add(jrb_login);
    bg_regist.add(jrb_edit);
    jrb_login.setSelected(true);


    bg_mode.add(jrb_single);
    bg_mode.add(jrb_connect);
    jrb_single.setSelected(true);

    jcb_color.addItem("遊戲背景：白色");
    jcb_color.addItem("遊戲背景：黑色");
    jcb_color.addItem("遊戲背景：黃色");
    jcb_color.addItem("遊戲背景：紅色");
    jcb_color.addItem("遊戲背景：藍色");
    jcb_color.addItem("遊戲背景：綠色");
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

  /*登入驗證的部份*/
  void jbtn_Submit_actionPerformed(ActionEvent e) {
    //登入帳號
    if (jrb_login.isSelected()) {
      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " r l " + jtxtf_ID.getText() + " " + jtxtf_PW.getText(),50000);

      try {
        Main.messagedata=clsNet.GetData(clsNet.SS, 50000);
        System.out.println(Main.messagedata);
        if (Main.messagedata.equals("true1") || Main.messagedata.equals("true2") || Main.messagedata.equals("true3") || Main.messagedata.equals("true4")) {
          if (jrb_105.isSelected()) {
            Main.gs = 105;
          }else if(jrb_210.isSelected()){
            Main.gs = 210;
          }else{
            Main.gs=0;
          }

          if(Main.gs!=0){
            Main.backcolor=jcb_color.getSelectedIndex();

            Main.playpicselc[0]=Integer.parseInt(Main.messagedata.substring(4));
            Main.ID = jtxtf_ID.getText();
            Main.PW = jtxtf_PW.getText();
            this.dispose();
            if(jrb_connect.isSelected()){
              //Main.netconnect = new NetConnect();
              //Main.netconnect.setVisible(true);
              Main.roomselect=new RoomSelect();
              Main.roomselect.setVisible(true);
            }else{
              Main.gameloader = new GameLoader();
              Main.gameloader.setVisible(true);
            }
          }else{
            Main.ranklist=new Ranklist();
            Main.ranklist.setBounds(0,0,800,600);
            Main.ranklist.setVisible(true);
            this.setVisible(false);
          }
        } else {
          JOptionPane.showMessageDialog(null, "帳號或密碼錯誤，請重新輸入。");
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    //註冊帳號
    } else if(jrb_regist.isSelected()){
      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " r q " + jtxtf_ID.getText(),50000);

      try {
        if (clsNet.GetData(clsNet.SS, 50000).equals("true")) {
          JOptionPane.showMessageDialog(null, "此帳號格式不合或已有人註冊，請重新輸入。");
        } else {
          Main.ID=jtxtf_ID.getText();
          Main.PW="";
          Main.rore = 1;

          Main.regist = new Regist();
          Main.regist.setVisible(true);
          this.setVisible(false);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    //修改帳號
    }else{
      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " r l " + jtxtf_ID.getText() + " " + jtxtf_PW.getText(),50000);

      try {
        if (clsNet.GetData(clsNet.SS, 50000).equals("true")) {
          Main.ID=jtxtf_ID.getText();
          Main.PW=jtxtf_PW.getText();
          Main.rore = 0;

          Main.regist = new Regist();
          Main.regist.setVisible(true);
          this.setVisible(false);
        } else {
          JOptionPane.showMessageDialog(null, "帳號或密碼錯誤，請重新輸入。");
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    }
  }
  /**/
}

class Login_jbtn_Submit_mouseAdapter extends java.awt.event.MouseAdapter {
  Login adaptee;

  Login_jbtn_Submit_mouseAdapter(Login adaptee) {
    this.adaptee = adaptee;
  }
}

class Login_jbtn_Submit_actionAdapter implements java.awt.event.ActionListener {
  Login adaptee;

  Login_jbtn_Submit_actionAdapter(Login adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_Submit_actionPerformed(e);
  }
}

