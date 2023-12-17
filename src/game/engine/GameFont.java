package game.engine;

import java.awt.Font;
import java.io.File;

public class GameFont {
  public static Font getRegular() {
    try {
      return Font.createFont(Font.TRUETYPE_FONT, new File("assets/NicoClean-Regular.ttf"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static Font getBold() {
    try {
      return Font.createFont(Font.TRUETYPE_FONT, new File("assets/NicoBold-Regular.ttf"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
