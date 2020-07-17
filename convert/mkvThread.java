package convert;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class mkvThread implements Runnable {

  Thread t = new Thread(this);

  private static String mkvPath = convert.config.getMp4ToMkvPath();
  private static Path mp4TomkvPath = FileSystems.getDefault().getPath(mkvPath);

  @Override
  public void run() {
    try {
      main.mp4Tomkv();

      WatchService watchServiceMp4ToMkv = mp4TomkvPath.getFileSystem().newWatchService();
      mp4TomkvPath.register(watchServiceMp4ToMkv, StandardWatchEventKinds.ENTRY_CREATE);

      // Start infinite loop to watch changes on the directory
      do {
        WatchKey watchKeyMp4ToMkv = watchServiceMp4ToMkv.take();

        // poll for file system events on the WatchKey
        for (final WatchEvent<?> event : watchKeyMp4ToMkv.pollEvents()) {
          main.mp4Tomkv();
        }
        // Break out of the loop if watch directory got deleted
        if (!watchKeyMp4ToMkv.reset()) {
          watchKeyMp4ToMkv.cancel();
          watchServiceMp4ToMkv.close();
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