package cute_gamecity;

import javax.imageio.ImageIO;


public class clsGraphic {
  /*列出所有圖形檔案格式*/
  public static String getImageFormats() {
    final StringBuffer ret = new StringBuffer();
    final String[] ImgFormat = ImageIO.getReaderFormatNames();

    for (int i = 0; i < ImgFormat.length; i++) {
      ret.append(ImgFormat[i]);
      if (i + 1 < ImgFormat.length) {
        ret.append(",");
      }
    }
    return ret.toString();
  }
  /**/


  /**/
  public static boolean MouseInTarget(int mx,int my,int tx,int ty,int tw,int th){
    if (mx >= tx && mx <= tx + tw && my >= ty && my <= ty + th) {
      return true;
    } else {
      return false;
    }
  }
  /**/
}
