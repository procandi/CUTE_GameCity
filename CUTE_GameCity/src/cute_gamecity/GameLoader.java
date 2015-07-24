package cute_gamecity;

import java.awt.*;
import javax.swing.*;

public class GameLoader extends Frame{
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  GridLayout gridLayout2 = new GridLayout();
  GridLayout gridLayout3 = new GridLayout();
  BorderLayout borderLayout1 = new BorderLayout();

  public GameLoader() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    this.setLocale(java.util.Locale.getDefault());
    this.setLayout(borderLayout1);
    this.setIgnoreRepaint(false);
    this.setBounds(0,0,1024,768);
    jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel1.setBounds(new Rectangle(0, 0, 1024, 600));
    jPanel1.setLayout(gridLayout2);
    jPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanel2.setBounds(new Rectangle(0, 600, 1024, 168));
    jPanel2.setLayout(gridLayout3);
    this.add(jPanel1, BorderLayout.CENTER);
    this.add(jPanel2, BorderLayout.SOUTH);



    if(Main.gs==105){
      if(Main.pm==0){
        this.setTitle("������Q�I�b");
        Computer105 com105=new Computer105();
        jPanel1.add(com105);
      }else{
        /*if(Main.first){
          this.setTitle("�s�u���Ȥ�ݤQ�I�b");
        }else{
          this.setTitle("�s�u�����A�ݤQ�I�b");
        }*/
        this.setTitle("�s�u���Q�I�b");
        Connect105 connect105 = new Connect105();
        jPanel1.add(connect105);
      }
    }else{
      if(Main.pm==0){
        this.setTitle("������G�Q�@�I");
        Computer210 com210 = new Computer210();
        jPanel1.add(com210);
      }else{
        /*if(Main.first){
          this.setTitle("�s�u���Ȥ�ݤG�Q�@�I");
        }else{
          this.setTitle("�s�u�����A�ݤG�Q�@�I");
        }*/
        this.setTitle("�s�u���G�Q�@�I");
        Connect210 connect210 = new Connect210();
        jPanel1.add(connect210);
      }
    }

    Main.plurk=new Plurk();
    //this.add("South",Main.plurk);
    jPanel2.add(Main.plurk);
  }
}
