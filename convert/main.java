package convert;

import java.io.File;

public class main {

  public static void main(String[] args) {
    mp3Thread mp3Thread = new mp3Thread();
    mp3Thread.start();

    mkvThread mkvThread = new mkvThread();
    mkvThread.start();

    flvThread flvThread = new flvThread();
    flvThread.start();
  }
}