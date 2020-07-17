package convert;

public class config {
  private static String mp4Tomp3Path = "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media\\mp4Tomp3";
  private static String mp4TomkvPath = "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media\\mp4Tomkv";
  private static String mp4ToflvPath = "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media\\mp4Toflv";
  private static String mp4Tomp3ConvertedPath = "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media-converted\\mp4Tomp3-converted";
  private static String mp4TomkvConvertedPath = "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media-converted\\mp4Tomkv-converted";
  private static String mp4ToflvConvertedPath = "C:\\Users\\Ishara\\Desktop\\Java-Video-Converter\\media-converted\\mp4Toflv-converted";

  public static String getMp4ToMp3Path() {
    return mp4Tomp3Path;
  }

  public static String getMp4ToMkvPath() {
    return mp4TomkvPath;
  }

  public static String getMp4ToFlvPath() {
    return mp4ToflvPath;
  }

  public static String getMp4ToMp3ConvertPath() {
    return mp4Tomp3ConvertedPath;
  }

  public static String getMp4ToMkvConvertPath() {
    return mp4TomkvConvertedPath;
  }

  public static String getMp4ToFlvConvertPath() {
    return mp4ToflvConvertedPath;
  }
}