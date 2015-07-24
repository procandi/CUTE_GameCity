package cute_gamecity_support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


class clsProperty {
  public final static String PDF2JPEG_PROPERTIES="PDF2JPEG.properties";

  public static String LoadProperty(String ClassKeyWord, String EndKeyWord,
                                    String FilePath) {
    try {
      Properties propery = new Properties();
      FileInputStream FIS = new FileInputStream(FilePath);
      String ret = new String();

      propery.load(FIS);

      ret = (String) propery.get(ClassKeyWord);
      if (EndKeyWord == null || EndKeyWord.equals("")) {
        return ret;
      }
      else {
        int index;

        index = ret.lastIndexOf(EndKeyWord);
        return ret.substring(0, index);
      }

    }
    catch (FileNotFoundException fnfe) {
      return null;
    }
    catch (IOException ioe) {
      return null;
    }
  }
}
