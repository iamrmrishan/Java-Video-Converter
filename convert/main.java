package convert;

import java.io.File;

public class main {

  public static void main(String[] args) {

    // mp4Tomp3 conversion
    try {
      File[] files = new File("C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media\\mp4Tomp3").listFiles();

      File destination = new File(
          "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media-converted\\mp4Tomp3-converted");

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + ".mp3");

        Convert.convertMp4ToMp3(file, target);
        System.out.println("Successfully Converted!");

        // delete the original file
        file.deleteOnExit();
        System.out.println("Deleted file" + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // mp4Toflv conversion
    try {
      File[] files = new File("C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media\\mp4Toflv").listFiles();

      File destination = new File(
          "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media-converted\\mp4Toflv-converted");

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + ".flv");

        Convert.convertMp4ToFlv(file, target);
        System.out.println("Successfully Converted!");

        // delete the original file
        file.deleteOnExit();
        System.out.println("Deleted file" + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // mp4Tomkv conversion
    try {
      File[] files = new File("C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media\\mp4Tomkv").listFiles();

      File destination = new File(
          "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media-converted\\mp4Tomkv-converted");

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + ".mkv");

        Convert.convertMp4ToMkv(file, target);
        System.out.println("Successfully Converted!");

        // delete the original file
        file.deleteOnExit();
        System.out.println("Deleted file" + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}