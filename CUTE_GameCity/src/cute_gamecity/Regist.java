package cute_gamecity;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.tree.TreePath;

public class Regist extends Frame{
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JTextField jtxtf_ID = new JTextField();
  JPasswordField jtxtf_PW = new JPasswordField();
  JTextField jtxtf_name = new JTextField();
  JTextField jtxtf_birth = new JTextField();
  JTextField jtxtf_email = new JTextField();
  JButton jbtn_submit = new JButton();
  JButton jbtn_return = new JButton();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JButton jbtn_clear = new JButton();
  JLabel jLabel8 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JPasswordField jtxtf_CPW = new JPasswordField();
  JComboBox jcb_sex = new JComboBox();
  JButton jbtn_upload = new JButton();
  JLabel jLabel11 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel13 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel16 = new JLabel();
  JLabel jLabel17 = new JLabel();

  String[] temp;


  public Regist() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.setLocale(java.util.Locale.getDefault());

    this.setLayout(gridBagLayout1);
    this.setIgnoreRepaint(false);
    this.setBounds(100,75,800,600);

    jtxtf_birth.setSelectionStart(11);
    jtxtf_birth.setText("1900/01/01");
    jbtn_submit.setText("確定註冊");
    jbtn_submit.addActionListener(new Regist_jbtn_submit_actionAdapter(this));
    jbtn_return.setText("返回");
    jbtn_return.addActionListener(new Regist_jbtn_return_actionAdapter(this));
    jLabel1.setRequestFocusEnabled(true);
    jLabel1.setToolTipText("");
    jLabel1.setText("帳號：");
    jLabel2.setText("密碼：");
    jLabel3.setText("姓名：");
    jLabel4.setText("性別：");
    jLabel5.setText("生日：");
    jLabel6.setPreferredSize(new Dimension(34, 17));
    jLabel6.setRequestFocusEnabled(true);
    jLabel6.setText("電子郵件：");
    jtxtf_ID.setAlignmentY((float) 0.5);
    jtxtf_ID.setEditable(false);
    jtxtf_ID.setText(Main.ID);
    jtxtf_PW.setText(Main.PW);
    jtxtf_email.setText("");
    jtxtf_name.setText("");
    jbtn_clear.setToolTipText("");
    jbtn_clear.setText("清除");
    jbtn_clear.addActionListener(new Regist_jbtn_clear_actionAdapter(this));
    jLabel8.setText("                               ");
    jLabel9.setText("再次輸入密碼：");
    jLabel10.setText("照片：");
    jtxtf_CPW.setToolTipText("");
    jtxtf_CPW.setText("");
    jbtn_upload.setText("選擇照片");
    jbtn_upload.addActionListener(new Regist_jbtn_upload_actionAdapter(this));
    jLabel11.setText("                               ");
    jLabel12.setText("                               ");
    jLabel13.setText("                               ");
    jLabel14.setText("                               ");
    jLabel15.setText("                               ");
    jLabel16.setText("                               ");
    jLabel17.setText("                               ");
    this.add(jbtn_submit,                                                                         new GridBagConstraints(1, 16, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jbtn_return,                                                                         new GridBagConstraints(5, 16, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel6,                                                                         new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 25, 0));
    this.add(jbtn_clear,                                                                new GridBagConstraints(4, 16, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel5,                                                                           new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 12), 11, 0));
    this.add(jLabel9,                                                  new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 1, 0, 3), 8, 0));
    this.add(jLabel3,                                                    new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 22, 0));
    this.add(jLabel4,                                                     new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 23, 0));
    this.add(jLabel2,                                                  new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE, new Insets(0, 24, 0, 14), 32, 0));
    this.add(jLabel1,                                                        new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 21, 0));
    this.add(jtxtf_name,                                                      new GridBagConstraints(1, 6, 4, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 138, 0));
    this.add(jtxtf_PW,                                                     new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 138, 0));
    this.add(jtxtf_ID,                                                    new GridBagConstraints(1, 0, 4, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 139, 0));
    this.add(jtxtf_CPW,                                                                new GridBagConstraints(1, 4, 4, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 138, 0));
    this.add(jtxtf_birth,                                                    new GridBagConstraints(1, 10, 4, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, -1, 0, 1), 86, 0));
    this.add(jtxtf_email,                                                    new GridBagConstraints(1, 12, 3, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 140, 0));
    this.add(jcb_sex,                                                           new GridBagConstraints(1, 8, 4, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 123, 0));
    this.add(jLabel8,                                     new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 23, 0));
    this.add(jLabel12,                               new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel11,                         new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel13,                            new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel14,                         new GridBagConstraints(1, 9, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel15,                      new GridBagConstraints(1, 11, 2, 1, 0.0, 0.0
            ,GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel16,             new GridBagConstraints(1, 13, 2, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel17,          new GridBagConstraints(1, 15, 2, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jbtn_upload,  new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    this.add(jLabel10,       new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 12), 11, 0));

    jcb_sex.insertItemAt("女",0);
    jcb_sex.insertItemAt("男",1);
    jcb_sex.setSelectedIndex(0);


    //若rore為0，亦即是要修改資料的話，代表以前已有舊的資料存在，在此就先把那些資料讀取並顯示出來
    if(Main.rore==0){
      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " r d " + jtxtf_ID.getText(),50000);

      try {
        Main.messagedata=clsNet.GetData(clsNet.SS, 50000);

        if (!Main.messagedata.equals("")) {
          temp=Main.messagedata.split(" ");

          jtxtf_ID.setText(temp[0]);
          jtxtf_name.setText(temp[1]);

          if(temp[2].equals("女")){
            jcb_sex.setSelectedIndex(0);
          }else{
            jcb_sex.setSelectedIndex(1);
          }

          jtxtf_birth.setText(temp[3]);
          jtxtf_email.setText(temp[4]);
          Main.picsel=Integer.parseInt(temp[5]);
       }

      } catch (Exception ex) {
         ex.printStackTrace();
         System.out.println( Main.messagedata);
      }
    }
  }


  public void paint(Graphics g){
    if(Main.FramBackground==null){
      Main.FramBackground=Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/bk/purple.png").substring(6));
    }
    g.drawImage(Main.FramBackground, 0, 0, this);
    this.paintComponents(g);
  }



  void jbtn_clear_actionPerformed(ActionEvent e) {
    jtxtf_ID.setText("");
    jtxtf_PW.setText("");
    jtxtf_CPW.setText("");
    jcb_sex.setSelectedIndex(0);
    jtxtf_birth.setText("1900/01/01");
    jtxtf_email.setText("");
  }

  void jbtn_return_actionPerformed(ActionEvent e) {
    Main.login.setVisible(true);
    this.setVisible(false);
    this.dispose();
  }

  void jbtn_submit_actionPerformed(ActionEvent e) {
    if(jtxtf_PW.getText().equals(jtxtf_CPW.getText())){
      //把sex的值給二進位化
      int sex;
      if(jcb_sex.getSelectedItem().equals("女")){
        sex=0;
      }else{
        sex=1;
      }


      //若rore為1則為插入新資料，為0則為更新舊資料
      String SQLString;
      if(Main.rore==1){
        String table;
        String values;

        table="ID,PW,name,sex,birthday,email,picture";
        values="'" + jtxtf_ID.getText() + "','" + jtxtf_PW.getText() + "','" + jtxtf_name.getText() + "'," + sex + ",'" + jtxtf_birth.getText() + "','" + jtxtf_email.getText() + "'," + Main.picsel;
        SQLString = "insert into TB_Account (" + table + ") values (" +values + ")";
      }else{
        SQLString = "update TB_Account set ID='" + jtxtf_ID.getText() + "',PW='" + jtxtf_PW.getText() + "',name='" + jtxtf_name.getText() + "',sex=" + sex + ",birthday='" + jtxtf_birth.getText() + "',email='" + jtxtf_email.getText() + "',picture=" +Main.picsel + " where ID='" + jtxtf_ID.getText() + "'";
      }
      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " e " + SQLString,50000);

      if (clsNet.GetData(clsNet.SS, 50000).equals("true")) {
        //跳回登入畫面
        Main.login.setVisible(true);
        this.setVisible(false);
        this.dispose();
      }else{
        JOptionPane.showMessageDialog(null,"註冊或修改失敗！");
      }
    }else{
      JOptionPane.showMessageDialog(null, "兩次密碼比對不符，請重新輸入。");
    }
  }

  void jbtn_upload_actionPerformed(ActionEvent e) {
    Main.selpiclod=new SelectPictureLoader();
    Main.selpiclod.setBounds(0,0,800,600);
    Main.selpiclod.setVisible(true);
    this.setVisible(false);
  }
}

class Regist_jbtn_clear_actionAdapter implements java.awt.event.ActionListener {
  Regist adaptee;

  Regist_jbtn_clear_actionAdapter(Regist adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_clear_actionPerformed(e);
  }
}

class Regist_jbtn_return_actionAdapter implements java.awt.event.ActionListener {
  Regist adaptee;

  Regist_jbtn_return_actionAdapter(Regist adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_return_actionPerformed(e);
  }
}

class Regist_jbtn_submit_actionAdapter implements java.awt.event.ActionListener {
  Regist adaptee;

  Regist_jbtn_submit_actionAdapter(Regist adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_submit_actionPerformed(e);
  }
}

class Regist_jbtn_upload_actionAdapter implements java.awt.event.ActionListener {
  Regist adaptee;

  Regist_jbtn_upload_actionAdapter(Regist adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_upload_actionPerformed(e);
  }
}
