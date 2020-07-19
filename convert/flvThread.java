package convert;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class flvThread implements Runnable {

  Thread t = new Thread(this);

  private static String flvPath = config.getMp4ToFlvPath();
  private static String flvConvertPath = config.getMp4ToFlvConvertPath();
  private static Path mp4ToflvPath = FileSystems.getDefault().getPath(flvPath);

  @Override
  public void run() {
    try {
      Convert.assignPath(flvPath, flvConvertPath, ".flv");

      WatchService watchServiceMp4ToFlv = mp4ToflvPath.getFileSystem().newWatchService();
      mp4ToflvPath.register(watchServiceMp4ToFlv, StandardWatchEventKinds.ENTRY_CREATE,
          StandardWatchEventKinds.ENTRY_MODIFY);

      // Start infinite loop to watch changes on the directory
      do {
        WatchKey watchKeyMp4ToFlv = watchServiceMp4ToFlv.take();

        // poll for file system events on the WatchKey
        for (final WatchEvent<?> event : watchKeyMp4ToFlv.pollEvents()) {
          Convert.assignPath(flvPath, flvConvertPath, ".flv");
        }
        // Break out of the loop if watch directory got deleted
        if (!watchKeyMp4ToFlv.reset()) {
          watchKeyMp4ToFlv.cancel();
          watchServiceMp4ToFlv.close();
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