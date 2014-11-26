import java.io.*;
import javax.sound.sampled.*;
public class MusicPlayer{

    private File music;
    private AudioInputStream stream;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip clip;

    public MusicPlayer(String fileUrl){
        try{
            this.music = new File(fileUrl);
            stream = AudioSystem.getAudioInputStream(this.music);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class,format);
            clip = (Clip)AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        }catch(Exception e){
            e.printStackTrace();
        }   

    }
   
}
