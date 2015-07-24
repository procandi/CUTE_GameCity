package cute_gamecity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;

public class SelectPicture extends Canvas {
  final int ALLFACE=5;
  final int facewidth=100;
  final int faceheight=100;

  int i,j;
  boolean firsttime=true;
  Image[] faceimg=new Image[ALLFACE];
  int[] facex=new int[5];
  int[] facey=new int[5];



  public SelectPicture() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void paint(Graphics g){
    if (firsttime) {
      for (i = 0; i < ALLFACE; i++) {
        faceimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase + "img/face/f" + i + ".jpg").substring(6));
      }

      for (i = 0; i < ALLFACE; i++) {
        facex[i] = (i + 1) * (facewidth + 20);
        facey[i] = (size().height/2) - (faceheight);
      }


      firsttime = false;
    }

    repaint(g);
  }


  public void repaint(Graphics g){
    g.fillRect(0,0,800,600);

    for(i=0;i<ALLFACE;i++){
      g.drawImage(faceimg[i], facex[i], facey[i], this);
    }

  }
  private void jbInit() throws Exception {
    this.addMouseListener(new SelectPicture_this_mouseAdapter(this));
  }

  void this_mouseClicked(MouseEvent e) {
    for(i=0;i<ALLFACE;i++){
      if (clsGraphic.MouseInTarget(e.getX(), e.getY(), facex[i], facey[i],facewidth, faceheight)) {
        Main.picsel=i;
        Main.selpiclod.dispose();
        Main.regist.show();
      }
    }
  }
}

class SelectPicture_this_mouseAdapter extends java.awt.event.MouseAdapter {
  SelectPicture adaptee;

  SelectPicture_this_mouseAdapter(SelectPicture adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.this_mouseClicked(e);
  }
}
