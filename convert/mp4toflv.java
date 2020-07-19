package convert;

//import com.sun.org.apache.bcel.internal.Repository;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;

//import java.util.Scanner;
import java.io.File;

public class mp4toflv extends Convert {

    // convert mp4 to flv
    public static void convertMp4ToFlv(File source, File output) {
        Encoder forFlv = new Encoder();

        EncodingAttributes specificationsForFlv = new EncodingAttributes();
        specificationsForFlv.setFormat("flv");
        AudioAttributes audioForFlv = new AudioAttributes();
        audioForFlv.setCodec("libmp3lame");
        audioForFlv.setBitRate(new Integer(64000));
        audioForFlv.setChannels(new Integer(1));
        audioForFlv.setSamplingRate(new Integer(22050));
        VideoAttributes videoForFlv = new VideoAttributes();
        videoForFlv.setCodec("flv");
        videoForFlv.setBitRate(new Integer(160000));
        videoForFlv.setFrameRate(new Integer(15));
        specificationsForFlv.setAudioAttributes(audioForFlv);
        specificationsForFlv.setVideoAttributes(videoForFlv);

        try {
            forFlv.encode(source, output, specificationsForFlv);
        } catch (EncoderException ex) {
            ex.printStackTrace();
        }
    }

}