package cute_gamecity;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.SourceDataLine;


public class clsAudio {
  public clsAudio() {
  }

  public static boolean PlayAudio(String AudioFilePath){
    try {
      File f = new File(AudioFilePath);
      AudioInputStream ais = AudioSystem.getAudioInputStream(f);
      AudioFormat af = ais.getFormat();
      Info inf = new Info(SourceDataLine.class,af);
      SourceDataLine sdl = (SourceDataLine) AudioSystem.getLine(inf);

      sdl.open(af);
      sdl.start();

      byte[] buf = new byte[65536];
      for (int i = 0; (i = ais.read(buf, 0, buf.length)) > 0; ) {
        sdl.write(buf, 0, i);
      }

      sdl.drain();
      sdl.close();

      return true;
    } catch (Exception e) {
      e.printStackTrace();

      return false;
    }
  }
}
