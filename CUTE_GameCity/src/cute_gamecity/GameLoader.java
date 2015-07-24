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
        this.setTitle("單機版十點半");
        Computer105 com105=new Computer105();
        jPanel1.add(com105);
      }else{
        /*if(Main.first){
          this.setTitle("連線版客戶端十點半");
        }else{
          this.setTitle("連線版伺服端十點半");
        }*/
        this.setTitle("連線版十點半");
        Connect105 connect105 = new Connect105();
        jPanel1.add(connect105);
      }
    }else{
      if(Main.pm==0){
        this.setTitle("單機版二十一點");
        Computer210 com210 = new Computer210();
        jPanel1.add(com210);
      }else{
        /*if(Main.first){
          this.setTitle("連線版客戶端二十一點");
        }else{
          this.setTitle("連線版伺服端二十一點");
        }*/
        this.setTitle("連線版二十一點");
        Connect210 connect210 = new Connect210();
        jPanel1.add(connect210);
      }
    }

    Main.plurk=new Plurk();
    //this.add("South",Main.plurk);
    jPanel2.add(Main.plurk);
  }
}
