package cute_gamecity_support;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frmSupport extends java.awt.Frame{
  JButton jbtn_exit = new JButton();
  public frmSupport() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    jbtn_exit.setText("Ãö³¬¦øªA¾¹");
    jbtn_exit.addActionListener(new frmSupport_jbtn_exit_actionAdapter(this));
    this.add(jbtn_exit, BorderLayout.CENTER);
  }

  void jbtn_exit_actionPerformed(ActionEvent e) {
    appSupport.isClose=true;
    this.dispose();
  }
}

class frmSupport_jbtn_exit_actionAdapter implements java.awt.event.ActionListener {
  frmSupport adaptee;

  frmSupport_jbtn_exit_actionAdapter(frmSupport adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jbtn_exit_actionPerformed(e);
  }
}
