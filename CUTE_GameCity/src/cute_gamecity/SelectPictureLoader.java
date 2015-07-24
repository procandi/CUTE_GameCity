package cute_gamecity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectPictureLoader extends Frame{
  JButton jbtn_exit = new JButton();
  BorderLayout borderLayout1 = new BorderLayout();

  public SelectPictureLoader() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    jbtn_exit.setText("¤£¿ï¾Ü¡AÂ÷¶}");
    jbtn_exit.addActionListener(new SelectPictureLoader_jbtn_exit_actionAdapter(this));
    SelectPicture selpic=new SelectPicture();
    this.add("Center",selpic);
    this.add("South",jbtn_exit);


  }

  void jbtn_exit_actionPerformed(ActionEvent e) {
    Main.regist.show();
    this.dispose();
  }
}

class SelectPictureLoader_jbtn_exit_actionAdapter implements java.awt.event.ActionListener {
  SelectPictureLoader adaptee;

  SelectPictureLoader_jbtn_exit_actionAdapter(SelectPictureLoader adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_exit_actionPerformed(e);
  }
}
