package convert;

import java.io.File;

public class Convert {

  public static void assignPath(String mediaPath, String convertMediaPath, String extension) {
    try {
      File[] files = new File(mediaPath).listFiles();

      File destination = new File(convertMediaPath);

      for (File file : files) {
        String[] nameFile = file.getAbsolutePath().split("\\\\");
        String[] removeExtension = nameFile[nameFile.length - 1].split("\\.");

        File target = new File(destination.getAbsolutePath() + "\\" + removeExtension[0] + extension);

        switch (extension) {
          case ".mp3":
            mp4tomp3.convertMp4ToMp3(file, target);
            break;
          case ".mkv":
            mp4tomkv.convertMp4ToMkv(file, target);
            break;
          case ".flv":
            mp4toflv.convertMp4ToFlv(file, target);
            break;
          default:
            break;
        }
        System.out.println("Successfully Converted " + file.getName() + " to " + target.getName());

        // delete the original file
        file.delete();
        System.out.println("Deleted file " + file.getName());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}