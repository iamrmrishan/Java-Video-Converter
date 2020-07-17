package convert;

import java.io.File;

public class main {

  private static String mp3Path = convert.config.getMp4ToMp3Path();
  private static String mkvPath = convert.config.getMp4ToMkvPath();
  private static String flvPath = convert.config.getMp4ToFlvPath();
  private static String mp3ConvertPath = convert.config.getMp4ToMp3ConvertPath();
  private static String mkvConvertPath = convert.config.getMp4ToMkvConvertPath();
  private static String flvConvertPath = convert.config.getMp4ToFlvConvertPath();

  public static void main(String[] args) {
    mp3Thread mp3Thread = new mp3Thread();
    mp3Thread.start();

    mkvThread mkvThread = new mkvThread();
    mkvThread.start();

    flvThread flvThread = new flvThread();
    flvThread.start();
  }

  public static void mp4Tomp3() {
    try {
      File[] files = new File(mp3Path).listFiles();

      File destination = new File(mp3ConvertPath);

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + ".mp3");

        Convert.convertMp4ToMp3(file, target);
        System.out.println("Successfully Converted " + file.getName() + " to " + target.getName());

        // delete the original file
        file.delete();
        System.out.println("Deleted file" + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void mp4Toflv() {
    try {
      File[] files = new File(flvPath).listFiles();

      File destination = new File(flvConvertPath);

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + ".flv");

        Convert.convertMp4ToFlv(file, target);
        System.out.println("Successfully Converted!");

        // delete the original file
        file.delete();
        System.out.println("Deleted file" + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static void mp4Tomkv() {
    try {
      File[] files = new File(mkvPath).listFiles();

      File destination = new File(mkvConvertPath);

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + ".mkv");

        Convert.convertMp4ToMkv(file, target);
        System.out.println("Successfully Converted!");

        // delete the original file
        file.delete();
        System.out.println("Deleted file" + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}