package convert;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class mp3Thread implements Runnable {

  Thread t = new Thread(this);

  private static String mp3Path = config.getMp4ToMp3Path();
  private static String mp3ConvertPath = config.getMp4ToMp3ConvertPath();
  private static Path mp4Tomp3Path = FileSystems.getDefault().getPath(mp3Path);

  @Override
  public void run() {
    try {
      Convert.assignPath(mp3Path, mp3ConvertPath, ".mp3");

      WatchService watchServiceMp4ToMp3 = mp4Tomp3Path.getFileSystem().newWatchService();
      mp4Tomp3Path.register(watchServiceMp4ToMp3, StandardWatchEventKinds.ENTRY_CREATE);

      // Start infinite loop to watch changes on the directory
      do {
        WatchKey watchKeyMp4ToMp3 = watchServiceMp4ToMp3.take();

        // poll for file system events on the WatchKey
        for (final WatchEvent<?> event : watchKeyMp4ToMp3.pollEvents()) {
          Convert.assignPath(mp3Path, mp3ConvertPath, ".mp3");
        }
        // Break out of the loop if watch directory got deleted
        if (!watchKeyMp4ToMp3.reset()) {
          watchKeyMp4ToMp3.cancel();
          watchServiceMp4ToMp3.close();
          System.out.println("Directory got deleted. Stop watching it.");
          break;
        }
      } while (true);
    } catch (InterruptedException interruptedException) {
      System.out.println("Thread got interrupted:" + interruptedException);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    }
  }

  public void start() {
    t.start();
  }
}