package cute_gamecity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ranklist extends Frame{
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JButton jbtn_return = new JButton();
  JList jtxta_105play = new JList();
  JList jtxta_105win = new JList();
  JList jtxta_210play = new JList();
  JList jtxta_210win = new JList();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  int i;
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JList jtxta_105score = new JList();
  JList jtxta_210score = new JList();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel18 = new JLabel();


  public Ranklist() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel1.setText("遊戲次數排行");
    this.setLayout(gridBagLayout1);
    jLabel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel2.setText("獲勝次數排行");
    jLabel3.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel3.setToolTipText("");
    jLabel3.setText("遊戲次數排行");
    jLabel4.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel4.setText("獲勝次數排行");
    jbtn_return.setText("返回");
    jbtn_return.addActionListener(new Ranklist_jbtn_return_actionAdapter(this));
    jtxta_105win.setBorder(BorderFactory.createLineBorder(Color.black));
    jtxta_105win.setToolTipText("");
    jLabel5.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel5.setText("平均分數排行");
    jLabel6.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel6.setRequestFocusEnabled(true);
    jLabel6.setText("平均分數排行 ");
    this.setFocusTraversalKeysEnabled(true);
    this.setIgnoreRepaint(false);
    this.setEnabled(true);
    this.setFocusable(false);
    this.setVisible(false);
    this.setForeground(Color.black);
    this.setFocusTraversalPolicy(null);
    this.setFocusableWindowState(true);
    this.setFocusCycleRoot(true);
    this.setExtendedState(0);
    this.setResizable(true);
    this.setUndecorated(false);
    this.setTitle("");
    jLabel7.setText("        ");
    jLabel8.setText("        ");
    jLabel9.setText("        ");
    jLabel10.setText("        ");
    jLabel11.setText("        ");
    jLabel12.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel12.setToolTipText("");
    jLabel12.setText("十點半");
    jLabel13.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel13.setText("二十一點");
    jLabel14.setText("        ");
    jLabel15.setText("        ");
    jLabel16.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel16.setText("平均績分排行");
    jtxta_210win.setBorder(BorderFactory.createLineBorder(Color.black));
    jtxta_210play.setBorder(BorderFactory.createLineBorder(Color.black));
    jtxta_105play.setBorder(BorderFactory.createLineBorder(Color.black));
    jtxta_105score.setBorder(BorderFactory.createLineBorder(Color.black));
    jtxta_210score.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabel17.setText("        ");
    jLabel18.setText("        ");
    this.add(jtxta_210win,                                                                                                          new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jtxta_210play,                                                                                                             new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jtxta_105win,                                                                                            new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jtxta_105play,                                                                                          new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel5,                                              new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jtxta_105score,                                              new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jtxta_210score,                                              new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel1,                                         new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel7,                                 new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel8,                                  new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel3,                                 new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel4,                            new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel10,                   new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 9, 0, 11), 0, 0));
    this.add(jLabel11,                new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel17,                 new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel14,            new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel13, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jbtn_return, new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel2, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel12, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel16, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel18, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel9, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel6,     new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel15, new GridBagConstraints(6, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));



    clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " q",50000);
    String[] ls;
    String[] lsbk;
    //Main.messagedata=clsNet.GetData(clsNet.SS,50000);
    //lsbk=Main.messagedata.split(":");

    /*十點半遊戲次數排行*/
    Main.messagedata=clsNet.GetData(clsNet.SS,50000);
    ls=Main.messagedata.split(",");
    //ls=lsbk[0].split(",");
    jtxta_105play.setListData(ls);

    /*十點半獲勝次數排行*/
    Main.messagedata=clsNet.GetData(clsNet.SS,50000);
    ls=Main.messagedata.split(",");
    //ls=lsbk[1].split(",");
    jtxta_105win.setListData(ls);


    /*十點半平均分數排行*/
    Main.messagedata=clsNet.GetData(clsNet.SS,50000);
    ls=Main.messagedata.split(",");
    //ls=lsbk[2].split(",");
    jtxta_105score.setListData(ls);

    /*二十一點遊戲次數排行*/
    Main.messagedata=clsNet.GetData(clsNet.SS,50000);
    ls=Main.messagedata.split(",");
    //ls=lsbk[3].split(",");
    jtxta_210play.setListData(ls);

    /*二十一點獲勝次數排行*/
    Main.messagedata=clsNet.GetData(clsNet.SS,50000);
    ls=Main.messagedata.split(",");
    //ls=lsbk[4].split(",");
    jtxta_210win.setListData(ls);

    /*十點半平均分數排行*/
    Main.messagedata=clsNet.GetData(clsNet.SS,50000);
    ls=Main.messagedata.split(",");
    //ls=lsbk[5].split(",");
    jtxta_210score.setListData(ls);
  }

  public void paint(Graphics g){
    if(Main.FramBackground==null){
      Main.FramBackground=Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/bk/purple.png").substring(6));
    }
    g.drawImage(Main.FramBackground, 0, 0, this);
    this.paintComponents(g);
  }


  void jbtn_return_actionPerformed(ActionEvent e) {
    Main.login.setVisible(true);
    this.dispose();
  }
}

class Ranklist_jbtn_return_actionAdapter implements java.awt.event.ActionListener {
  Ranklist adaptee;

  Ranklist_jbtn_return_actionAdapter(Ranklist adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_return_actionPerformed(e);
  }
}
