package cute_gamecity;

import java.awt.*;
import java.util.Date;
import java.applet.Applet;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;




public class Computer105 extends Canvas{
  /*���C���|�`�Ψ쪺�`��*/
  private final int ALLCARD=52;
  private final int MAXGETCARD=5;
  private final int MAXGETPASS=3;
  private final int MAXGETFACE=4;
  private final double MAXPOINT=10.5;
  private final int GameClass=105;
  private final int RND_PLA=0;
  private final int RND_COM=1;
  private final int RND_COM2=2;
  private final int RND_COM3=3;
  private final int RND_WIN=4;
  private final int RND_LOSE=5;
  private final int RND_AVER=6;
  /**/

  /*��C���y�{����������B�ܼ�*/
  private int i;
  private int j;
  private Font ft;
  private boolean firsttime=true;
  private int clk=0;
  private boolean playpass=false;
  private boolean compass=false;
  private boolean compass2=false;
  private boolean compass3=false;
  private boolean enab=false;
  private boolean needrefresh=false;
  private double playscore=0;
  private double comscore=0;
  private double comscore2=0;
  private double comscore3=0;
  private int PlayFrequency=0;
  private int WinFrequency=0;
  private int LoseFrequency=0;
  private int HighScore=0;
  private int TotalScore=0;
  private boolean updated=false;
  /**/

  /*��P����������B�ܼơB�`��*/
  private Image background;

  private Image cardimg[]=new Image[ALLCARD+1];
  private final int cardwidth = 80;
  private final int cardheight = 110;
  private int[] card=new int[ALLCARD+1];
  private int[] cardx=new int[ALLCARD+1];
  private int[] cardy=new int[ALLCARD+1];
  private int cardlist=0;

  private Image[] playcardimg=new Image[MAXGETCARD];
  private int[] playcard=new int[MAXGETCARD];
  private int[] playcardx=new int[MAXGETCARD];
  private int[] playcardy=new int[MAXGETCARD];
  private int playlist=0;

  private Image[] comcardimg=new Image[MAXGETCARD];
  private int[] comcard=new int[MAXGETCARD];
  private int[] comcardx=new int[MAXGETCARD];
  private int[] comcardy=new int[MAXGETCARD];
  private int comlist=0;

  private Image[] comcardimg2=new Image[MAXGETCARD];
  private int[] comcard2=new int[MAXGETCARD];
  private int[] comcardx2=new int[MAXGETCARD];
  private int[] comcardy2=new int[MAXGETCARD];
  private int comlist2=0;


  private Image[] comcardimg3=new Image[MAXGETCARD];
  private int[] comcard3=new int[MAXGETCARD];
  private int[] comcardx3=new int[MAXGETCARD];
  private int[] comcardy3=new int[MAXGETCARD];
  private int comlist3=0;
  /**/

  /*^^���Y������������ܼ�*/
  private Image[] faceimg=new Image[MAXGETFACE];
  private int[] facex=new int[MAXGETFACE];
  private int[] facey=new int[MAXGETFACE];
  /**/

  /*�����ξ�Tbar����������B�ܼơB�`��*/
  private Image[] passimg=new Image[MAXGETPASS];
  private int[] passx=new int[MAXGETPASS];
  private int[] passy=new int[MAXGETPASS];
  private int passlist=0;
  private final int passwidth = 88;
  private final int passheight = 86;

  private Image gameover;
  private Image[] result = new Image[3];
  private final int barwidth=214;
  private final int barheight=91;
  private int resultx;
  private int resulty;
  private int gameoverx;
  private int gameovery;
  /**/


  public Computer105() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void paint(Graphics g) {
    if (firsttime) {
      /*���J�I���ϥH�ΩҦ��d���Ϥ��B���s���Ϥ�*/
      //background = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/bk/bk1.jpg").substring(6));
      cardimg[ALLCARD] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/card/backcard.jpg").substring(6));

      for (i = 0; i < ALLCARD; i++) {
        switch (card[i] / 13) {
          case 0:

            //System.out.println(card[i]+"spade"+(card[i]%13+1));
            cardimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/card/" + (card[i] % 13 + 1) + "/spade" + (card[i] % 13 + 1) +".jpg").substring(6));
            break;
          case 1:

            //System.out.println(card[i]+"heart"+(card[i]%13+1));
            cardimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/card/" + (card[i] % 13 + 1) + "/heart" + (card[i] % 13 + 1) +".jpg").substring(6));
            break;
          case 2:

            //System.out.println(card[i]+"diamond"+(card[i]%13+1));
            cardimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/card/" + (card[i] % 13 + 1) + "/diamond" +(card[i] % 13 + 1) + ".jpg").substring(6));
            break;
          case 3:

            //System.out.println(card[i]+"club"+(card[i]%13+1));
            cardimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/card/" + (card[i] % 13 + 1) + "/club" + (card[i] % 13 + 1) +".jpg").substring(6));
            break;
        }
      }

      //^^��Ϲ������J
      for(i=0;i<4;i++){
        if (Main.playpicselc[i] == -1) {
          faceimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase + "img/face/f.jpg").substring(6));
        }else{
          faceimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase + "img/face/f" + Main.playpicselc[i] + ".jpg").substring(6));
        }
      }


      /*for (i = 0; i < ALLCARD; i++) {
        cardimg[i] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase + "img/card/backcard.jpg").substring(6));
      }*/

      passimg[0] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/btn/green_rect_pass.jpg").substring(6));
      passimg[1] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/btn/yellow_rect_pass.jpg").substring(6));
      passimg[2] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/btn/red_rect_pass.jpg").substring(6));

      gameover = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/btn/blue_bar_gameover.jpg").substring(6));
      result[0] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/btn/blue_bar_win.jpg").substring(6));
      result[1] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/btn/blue_bar_lose.jpg").substring(6));
      result[2] = Toolkit.getDefaultToolkit().getImage( (Main.CodeBase +"img/btn/blue_bar.jpg").substring(6));
      /**/


      /*���w���a��q���A��X�Ӫ��P�A�b�ୱ�W���\���m*/
      cardx[ALLCARD] = size().width / 2;
      cardy[ALLCARD] = size().height / 2;

      for (i = 0; i < MAXGETCARD; i++) {
        playcardx[i] = (i + 1) * (cardwidth + 40);
        playcardy[i] = size().height - (cardheight);

        comcardx[i] = (i + 1) * (cardwidth + 40);
        comcardy[i] = 0;

        comcardx2[i] = 0;
        comcardy2[i] = (i + 1) * (cardheight + 20);

        comcardx3[i] = size().width-(cardwidth);
        comcardy3[i] = (i + 1) * (cardheight + 20);
      }
      /**/


      /*^^���w�Ϲ����\�񪺦�m*/
      facex[0] = (size().width / 2) - (cardwidth + 40);
      facey[0] = (size().height / 2) + (cardwidth);
      facex[1] = (size().width / 2) + (cardwidth + 40);
      facey[1] = (size().height / 2) - (cardwidth);
      facex[2] = (size().width / 2) - (cardwidth + 40);
      facey[2] = (size().height / 2) - (cardwidth);
      facex[3] = (size().width / 2) + (cardwidth + 40);
      facey[3] = (size().height / 2) + (cardwidth);
      /**/


      /*���wpass���s���\�񪺦�m*/
      for (i = 0; i < MAXGETPASS; i++) {
        passx[i] = size().width - (passwidth);
        passy[i] = size().height - (passheight);
      }
      /**/


      /*���w�C��������bar���\���m*/
      resultx = size().width / 2 - (barwidth / 2);
      resulty = size().height / 2 - (barheight / 2);
      gameoverx = size().width / 2 - (barwidth / 2);
      gameovery = size().height / 2 + (barheight / 2);
      /**/

      firsttime = false;
    }

    this.repaint(g);
  }

  public void repaint(Graphics g){
    /*�̬y�{�����ܼơA�M�w�C���{�b���Ӷi�����@�B*/
    if(playpass && compass && compass2 && compass3) {
      /*�Y���賣pass�F�A�h�P�w�֪��I������ӨM�w��Ӫ�*/
      CalcPlayRecord();
      if (playscore > comscore && playscore > comscore2 && playscore > comscore3) {
        clk = RND_WIN;
      } else if (playscore < comscore || playscore < comscore2 || playscore < comscore3) {
        clk = RND_LOSE;
      } else if (playscore == comscore && playscore == comscore2 && playscore == comscore3){
        clk = RND_AVER;
      }
      /**/

    }else if(clk==RND_PLA && enab && playlist<MAXGETCARD){
      /*���a�ʧ@���^�X�A�P�_�⧹�P��O�_���W�L�I�ơA�W�L�Y��ܹC�������A�_�h�~��*/
      playpass=false;

      playcardimg[playlist] = cardimg[cardlist];
      playcard[playlist++] = card[cardlist++];

      for (playscore = 0, i = 0; i < playlist; i++) {
        if ( ( (playcard[i] % 13) + 1) > 10) {
          playscore += 0.5;
        } else {
          playscore += ( (playcard[i] % 13) + 1);
        }
      }

      if (playscore <= MAXPOINT) {
          clk = RND_COM;
      } else {
          clk = RND_LOSE;
      }
      needrefresh = true;
      /**/

    }else if(clk==RND_COM && enab){
        /*�q���@�ʧ@���^�X�A�P�_�O�_�ӭn��P�A�B���O�_���W�L�I�ơA�W�L�Y��ܹC�������A�_�h�~��*/
        if (comscore <= 10 && comlist<MAXGETCARD) {
          compass=false;

          comcardimg[comlist] = cardimg[cardlist];
          comcard[comlist++] = card[cardlist++];

          for (comscore = 0, i = 0; i < comlist; i++) {
            if ( ( (comcard[i] % 13) + 1) > 10) {
              comscore += 0.5;
            } else {
              comscore += ( (comcard[i] % 13) + 1);
            }
          }

          if (comscore <= MAXPOINT) {
            clk = RND_COM2;
          } else if(playscore > comscore2 && playscore > comscore3){
            clk = RND_WIN;
          } else {
            clk = RND_LOSE;
          }

        } else {
          compass=true;
          clk = RND_COM2;
        }
        needrefresh = true;
        /**/

    }else if(clk==RND_COM2 && enab){
      /*�q���G�ʧ@���^�X�A�P�_�O�_�ӭn��P�A�B���O�_���W�L�I�ơA�W�L�Y��ܹC�������A�_�h�~��*/
      if (comscore2 <= 10 && comlist2<MAXGETCARD) {
        compass2 = false;

        comcardimg2[comlist2] = cardimg[cardlist];
        comcard2[comlist2++] = card[cardlist++];

        for (comscore2 = 0, i = 0; i < comlist2; i++) {
          if ( ( (comcard2[i] % 13) + 1) > 10) {
            comscore2 += 0.5;
          } else {
            comscore2 += ( (comcard2[i] % 13) + 1);
          }
        }

        if (comscore2 <= MAXPOINT) {
          clk = RND_COM3;
        } else if(playscore > comscore && playscore > comscore3){
          clk = RND_WIN;
        } else {
          clk = RND_LOSE;
        }


      } else {
        compass2 = true;
        clk = RND_COM3;
      }
      needrefresh = true;
      /**/

    }else if(clk==RND_COM3 && enab){
      /*�q���T�ʧ@���^�X�A�P�_�O�_�ӭn��P�A�B���O�_���W�L�I�ơA�W�L�Y��ܹC�������A�_�h�~��*/
      if (comscore3 <= 10 && comlist3<MAXGETCARD) {
        compass3 = false;

        comcardimg3[comlist3] = cardimg[cardlist];
        comcard3[comlist3++] = card[cardlist++];

        for (comscore3 = 0, i = 0; i < comlist3; i++) {
          if ( ( (comcard3[i] % 13) + 1) > 10) {
            comscore3 += 0.5;
          } else {
            comscore3 += ( (comcard3[i] % 13) + 1);
          }
        }

        if (comscore3 <= MAXPOINT) {
          clk = RND_PLA;
          enab = false;
        } else if(playscore > comscore && playscore > comscore2){
          clk = RND_WIN;
        } else {
          clk = RND_LOSE;
        }


      } else {
        compass3 = true;
        clk = RND_PLA;
        enab = false;
      }
      needrefresh = true;
      /**/

    }
    /**/



    /*��I���ϡB�d���B���s�e�X��*/
    //g.drawImage(background, 0, 0, this);
    switch(Main.backcolor){
      case 0:
        g.setColor(Color.WHITE);
        break;
      case 1:
        g.setColor(Color.BLACK);
        break;
      case 2:
        g.setColor(Color.YELLOW);
        break;
      case 3:
        g.setColor(Color.RED);
        break;
      case 4:
        g.setColor(Color.BLUE);
        break;
      case 5:
        g.setColor(Color.GREEN);
        break;
    }
    g.fillRect(0,0,1024,768);
    /**/

    /*^^�L�X�Y��*/
    for (i = 0; i < 4; i++) {
      g.drawImage(faceimg[i], facex[i], facey[i], this);
    }
    /**/

    /*�L�X�������P�B���a��q���̪��P*/
    g.setColor(Color.ORANGE);
    g.drawString("�Ѿl�P�ơG"+(ALLCARD-cardlist),cardx[ALLCARD],cardy[ALLCARD]+cardheight+20);
    g.drawImage(cardimg[ALLCARD], cardx[ALLCARD], cardy[ALLCARD], this);

    for (i = 0; i < playlist; i++) {
      g.drawImage(playcardimg[i], playcardx[i], playcardy[i], this);
    }

    if (clk == RND_WIN || clk == RND_LOSE || clk == RND_AVER) {
      for (i = 0; i < comlist; i++) {
        g.drawImage(comcardimg[i], comcardx[i], comcardy[i], this);
      }
      for (i = 0; i < comlist2; i++) {
        g.drawImage(comcardimg2[i], comcardx2[i], comcardy2[i], this);
      }
      for (i = 0; i < comlist3; i++) {
        g.drawImage(comcardimg3[i], comcardx3[i], comcardy3[i], this);
      }
    } else {
      for (i = 0; i < comlist; i++) {
        g.drawImage(cardimg[ALLCARD], comcardx[i], comcardy[i], this);
      }
      for (i = 0; i < comlist2; i++) {
        g.drawImage(cardimg[ALLCARD], comcardx2[i], comcardy2[i], this);
      }
      for (i = 0; i < comlist3; i++) {
        g.drawImage(cardimg[ALLCARD], comcardx3[i], comcardy3[i], this);
      }
    }
    /**/

    g.drawImage(passimg[passlist], passx[passlist], passy[passlist], this);
    /**/


    /*�P�_�O�_�w�g�o�X�C�����G�A�O���ܡA�h�q�X�C���������e���A�åB��s�C������Ʈw*/
    if((clk==RND_WIN || clk==RND_LOSE || clk==RND_AVER) && !updated){
      updated=true;

      /*���񭵮�*/
      clsAudio.PlayAudio("rocket.wav");
      /**/

      /*�o���o�ӱb���O�_���Ĥ@�����A���O���ܡA�N�h����e���Ҧ����Z�����*/
      String[] ls;
      String SQLString = null;
      boolean isnew=false;

      clsNet.SendData(clsNet.RemoteIP, clsNet.RemotePort, clsNet.LocalPort + " g s " + Main.ID + " " + GameClass,50000);

      try {
        Main.messagedata=clsNet.GetData(clsNet.SS,50000);
        if (!Main.messagedata.equals("true 0 0 0 0 0")) {
          ls=Main.messagedata.split(" ");

          PlayFrequency = Integer.parseInt(ls[1]);
          WinFrequency = Integer.parseInt(ls[2]);
          LoseFrequency = Integer.parseInt(ls[3]);
          HighScore = Integer.parseInt(ls[4]);
          TotalScore = Integer.parseInt(ls[5]);

          isnew=false;
        } else {
          PlayFrequency=0;
          WinFrequency=0;
          LoseFrequency=0;
          HighScore=0;
          TotalScore=0;

          isnew=true;
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      /**/


      /*�P�_��Ĺ*/
      HighScore=(int)playscore;
      PlayFrequency++;
      if (clk == RND_WIN) {
        //Ĺ�F
        g.drawImage(result[0], resultx, resulty, this);
        g.drawImage(gameover, gameoverx, gameovery, this);

        WinFrequency++;
        TotalScore+=HighScore;
      } else if (clk == RND_LOSE) {
        //��F
        g.drawImage(result[1], resultx, resulty, this);
        g.drawImage(gameover, gameoverx, gameovery, this);

        LoseFrequency++;
      } else if (clk == RND_AVER) {
        //����
        g.drawImage(result[2], resultx, resulty, this);
        g.drawImage(gameover, gameoverx, gameovery, this);
      }
      /**/

      /*�s�W�Χ�s�o�����C���O�����Ʈw��*/
      if(isnew){
        String table=null;
        String values=null;

        table="ID,Class,PlayFrequency,WinFrequency,LoseFrequency,HighScore,TotalScore";
        values="'" + Main.ID + "'," + GameClass + "," + PlayFrequency + "," + WinFrequency + "," + LoseFrequency + "," + HighScore + "," + TotalScore + "";
        SQLString = "insert into TB_Game_Score (" + table + ") values (" + values + ")";
      }else{
        SQLString = "update TB_Game_Score set PlayFrequency=" + PlayFrequency +
            ",WinFrequency=" + WinFrequency + ",LoseFrequency=" +
            LoseFrequency + ",HighScore=" + HighScore + ",TotalScore=" +
            TotalScore + " where ID='" + Main.ID + "' and Class=" + GameClass + "";
      }
      clsNet.SendData(clsNet.RemoteIP,clsNet.RemotePort,"e " + SQLString,50000);
      /**/
    }else if (clk == RND_WIN) {
        //Ĺ�F
        g.drawImage(result[0], resultx, resulty, this);
        g.drawImage(gameover, gameoverx, gameovery, this);
    } else if (clk == RND_LOSE) {
        //��F
        g.drawImage(result[1], resultx, resulty, this);
        g.drawImage(gameover, gameoverx, gameovery, this);
    } else if (clk == RND_AVER) {
        //����
        g.drawImage(result[2], resultx, resulty, this);
        g.drawImage(gameover, gameoverx, gameovery, this);
    }
    /**/

    /*���ծɨϥΡA�i�H�ݨ쪱�a��q�����P���O�O�h�֡A�U�۪��`�X�I�ƬO�h��*/
    /*for (i = 0; i < playlist; i++) {
      System.out.print(playcard[i] % 13 + 1 + ",");
    }
    System.out.println();
    for (i = 0; i < comlist; i++) {
      System.out.print(comcard[i] % 13 + 1 + ",");
    }
    System.out.println();
    System.out.println(playscore + "," + comscore + "," + playpass + "," + compass + "," + clk);
    System.out.println();*/
    /**/



    /*�p�G���q���ʧ@�A�h���歫ø�A�H���q�����H�u���ೡ���}�l����A�P�_�O�_��P��*/
    /*�Ϊ̦��Hpass�F�A�h�]�n��ø*/
    if (needrefresh) {
      needrefresh = false;
      this.repaint(g);
    }
    /**/

  }


  /*�p�⦨�Z(�ȥΩ�Q�I�b��)*/
  void CalcPlayRecord(){
    for (playscore = 0, i = 0; i < playlist; i++) {
      if ( ( (playcard[i] % 13) + 1) > 10) {
        playscore += 0.5;
      } else {
        playscore += ( (playcard[i] % 13) + 1);
      }
    }


    for (comscore = 0, i = 0; i < comlist; i++) {
      if ( ( (comcard[i] % 13) + 1) > 10) {
        comscore += 0.5;
      } else {
        comscore += ( (comcard[i] % 13) + 1);
      }
    }


    for (comscore2 = 0, i = 0; i < comlist2; i++) {
      if ( ( (comcard2[i] % 13) + 1) > 10) {
        comscore2 += 0.5;
      } else {
        comscore2 += ( (comcard2[i] % 13) + 1);
      }
    }


    for (comscore3 = 0, i = 0; i < comlist3; i++) {
      if ( ( (comcard3[i] % 13) + 1) > 10) {
        comscore3 += 0.5;
      } else {
        comscore3 += ( (comcard3[i] % 13) + 1);
      }
    }


  }
  /**/


  // �]�w �̤p�d��
  public Dimension minimumSize() {
    return new Dimension(150, 130);
  }
  // �]�w �z�Q�d��
  public Dimension preferredSize() {
    return minimumSize();
  }


  private void jbInit() throws Exception {
    this.addMouseMotionListener(new Computer105_this_mouseMotionAdapter(this));
    this.addMouseListener(new Computer105_this_mouseAdapter(this));

    /*�üƵo�P��w�]�P�ո̡A�H����Q��P�ɡA�P����Ʒ|�O�ê�*/
    for(i=0;i<ALLCARD;i++){
      card[i]=(int)((Math.random()*100)%ALLCARD);
      for(j=0;j<i;j++){
        if(card[i]==card[j]){
          i--;
          break;
        }
      }
    }
    /**/

    /*�o�O���ծɥΡA��ܹw�]�P���Ҧ��ƦC*/
    //for(i=0;i<ALLCARD;i++)
    //  System.out.print(card[i]+",");
    //System.out.println();
    /**/
  }


  /*��e�����U�w�]�P�ծɡA�Y�o�s���P�C������O�n�O���a��ʪ��^�X�A�B���W�L�̤j�i���P�ơB�C���]�|������*/
  void this_mouseClicked(MouseEvent e) {
    if(clk==RND_PLA){
      if (playlist + 1 < MAXGETCARD) {
        if (clsGraphic.MouseInTarget(e.getX(), e.getY(), cardx[ALLCARD], cardy[ALLCARD], cardwidth, cardheight)) {
          enab=true;
          this.repaint();
        }
      }
    }
  }
  /**/


  /*�B�z��ƹ����S�w�ƥ�A�n��ܤ���˪�pass���s*/
  void this_mouseMoved(MouseEvent e) {
    if(clk==RND_PLA){
      if (passlist == 1) {
        if (!clsGraphic.MouseInTarget(e.getX(), e.getY(), passx[passlist], passy[passlist], passwidth, passheight)) {
          passlist = 0;
          this.repaint();
        }
      } else if (passlist == 0) {
        if (clsGraphic.MouseInTarget(e.getX(), e.getY(), passx[passlist], passy[passlist], passwidth, passheight)) {
          passlist = 1;
          this.repaint();
        }
      }
    }
  }

  void this_mousePressed(MouseEvent e) {
    if(clk==RND_PLA){
      if (clsGraphic.MouseInTarget(e.getX(), e.getY(), passx[passlist], passy[passlist], passwidth, passheight)) {
        clk = RND_COM;
        enab=true;
        playpass=true;

        passlist = 2;
        this.repaint();
      }
    }else if(clk==RND_WIN || clk==RND_LOSE || clk==RND_AVER){
      if (clsGraphic.MouseInTarget(e.getX(), e.getY(), gameoverx, gameovery, barwidth, barheight)) {
        Main.gameloader.dispose();
        Main.login.setVisible(true);
      }
    }
  }

  void this_mouseReleased(MouseEvent e) {
    if(clk==RND_PLA){
      if (clsGraphic.MouseInTarget(e.getX(), e.getY(), passx[passlist], passy[passlist], passwidth, passheight)) {
        passlist = 1;
        this.repaint();
      } else if(passlist==1){
        passlist = 0;
        this.repaint();
      }
    }
  }
  /**/
}


class Computer105_this_mouseAdapter extends java.awt.event.MouseAdapter {
  Computer105 adaptee;

  Computer105_this_mouseAdapter(Computer105 adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.this_mouseClicked(e);
  }
  public void mousePressed(MouseEvent e) {
    adaptee.this_mousePressed(e);
  }
  public void mouseReleased(MouseEvent e) {
    adaptee.this_mouseReleased(e);
  }
}

class Computer105_this_mouseMotionAdapter extends java.awt.event.MouseMotionAdapter {
  Computer105 adaptee;

  Computer105_this_mouseMotionAdapter(Computer105 adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseMoved(MouseEvent e) {
    adaptee.this_mouseMoved(e);
  }
}
