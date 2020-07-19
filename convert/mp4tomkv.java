package convert;
//import com.sun.org.apache.bcel.internal.Repository;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;

//import java.util.Scanner;
import java.io.File;

public class mp4tomkv{
    // convert mp4 to mkv
public static void convertMp4ToMkv(File source, File output) {
    Encoder forMkv = new Encoder();

    EncodingAttributes specificationsForMkv = new EncodingAttributes();
    specificationsForMkv.setFormat("matroska");
    AudioAttributes audioForMkv = new AudioAttributes();
    audioForMkv.setCodec("libmp3lame");
    audioForMkv.setBitRate(new Integer(64000));
    audioForMkv.setChannels(new Integer(1));
    audioForMkv.setSamplingRate(new Integer(22050));
    VideoAttributes videoForMkv = new VideoAttributes();
    videoForMkv.setCodec("mpeg4");
    videoForMkv.setBitRate(new Integer(160000));
    videoForMkv.setFrameRate(new Integer(15));
    specificationsForMkv.setAudioAttributes(audioForMkv);
    specificationsForMkv.setVideoAttributes(videoForMkv);

    try {
        forMkv.encode(source, output, specificationsForMkv);
    } catch (EncoderException ex) {
        ex.printStackTrace();
    }
    
}

}
