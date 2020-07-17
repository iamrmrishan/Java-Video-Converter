package convert;

//import com.sun.org.apache.bcel.internal.Repository;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.VideoAttributes;

//import java.util.Scanner;
import java.io.File;

public class Convert {

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

    // convert mp4 to mp3
    public static void convertMp4ToMp3(File source, File output) {
        Encoder forMp3 = new Encoder();
        EncodingAttributes specificationsForMp3 = new EncodingAttributes();
        specificationsForMp3.setFormat("mp3");
        AudioAttributes audioForMp3 = new AudioAttributes();
        audioForMp3.setVolume(256);
        audioForMp3.setCodec("mp2");
        specificationsForMp3.setAudioAttributes(audioForMp3);

        try {
            forMp3.encode(source, output, specificationsForMp3);
        } catch (EncoderException ex) {
            ex.printStackTrace();
        }
    }

    // convert mp4 to mkv
    public static void convertMp4ToMkv(File source, File output) {
        Encoder forMkv = new Encoder();

        EncodingAttributes specificationsForMkv = new EncodingAttributes();
        specificationsForMkv.setFormat("matroska");
        AudioAttributes audioForMkv = new AudioAttributes();
        audioForMkv.setCodec("libmp3lame");
        audioForMkv.setBitRate(new Integer(30000));
        audioForMkv.setChannels(new Integer(1));
        audioForMkv.setSamplingRate(new Integer(11050));
        VideoAttributes videoForMkv = new VideoAttributes();
        videoForMkv.setCodec("h263");
        videoForMkv.setBitRate(new Integer(100000));
        videoForMkv.setFrameRate(new Integer(20));
        specificationsForMkv.setAudioAttributes(audioForMkv);
        specificationsForMkv.setVideoAttributes(videoForMkv);

        try {
            forMkv.encode(source, output, specificationsForMkv);
        } catch (EncoderException ex) {
            ex.printStackTrace();
        }
    }

}
