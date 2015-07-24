package cute_gamecity_support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class clsFile {

  /*移動檔案*/
  public static boolean MoveFile(String SourcePath, String TargetPath) {
    int ch;
    FileInputStream fins;
    FileOutputStream fouts;
    File SourceFileList;
    File TargetFileList;

    try {
      SourceFileList = new File(SourcePath);
      TargetFileList = new File(TargetPath);

      if (SourceFileList.exists()) {
        fins = new FileInputStream(SourceFileList);
        fouts = new FileOutputStream(TargetFileList);

        ch = 0;
        while ( (ch = fins.read()) != -1) {
          fouts.write(ch);
        }

        fins.close();
        fouts.close();

        SourceFileList.delete();

        return true;
      }

      return false;
    }
    catch (Exception e) {
      return false;
    }
  }

  /**/



  /*切割檔案路徑的字串，把檔案路徑、檔案名稱、檔案類別給分出來，ChoiceReturn為0代表傳路徑、1代表傳名稱、2代表傳類別*/
  public static String DivisionFilePath(String InputPath, int ChoiceReturn) {
    String Output_File_Path = "";
    String Output_File_Name = "";
    String Output_File_Class = "";

    int i;

    for (i = InputPath.length(); i > 0; i--) {
      if (InputPath.substring(i - 1, i).equals(".")) {
        Output_File_Name = InputPath.substring(0, i - 1);
        Output_File_Class = InputPath.substring(i, InputPath.length());
        break;
      }
    }

    for (i = Output_File_Name.length(); i > 0; i--) {
      if (Output_File_Name.substring(i - 1, i).equals("\\")) {
        Output_File_Path = InputPath.substring(0, i - 1);
        Output_File_Name = Output_File_Name.substring(i,
            Output_File_Name.length());
        break;
      }
    }

    switch (ChoiceReturn) {
      case 0:
        return Output_File_Path;
      case 1:
        return Output_File_Name;
      case 2:
        return Output_File_Class;
      default:
        return "";
    }
  }

  /**/

}
