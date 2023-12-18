package game.engine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ResourceLoader {
  static ResourceLoader rl = new ResourceLoader();
  static Toolkit tk = Toolkit.getDefaultToolkit();

  public static Image loadImage(String imageName) {
    return tk.getImage(rl.getClass().getResource("/assets/" + imageName));
  }

  public static BufferedImage loadBufferedImage(String imageName) throws IOException {
    return ImageIO.read(rl.getClass().getResource("/assets/" + imageName));
  }

  public static void setDefaultCursor(JComponent component) {
    Image image = ResourceLoader.loadImage("Cursor_1.png");
    Point hotspot = new Point(0, 0);
    Cursor cursor = tk.createCustomCursor(image, hotspot, "pixelart");
    component.setCursor(cursor);
  }

  public static Font getFontRegular() {
    try {
      return Font.createFont(
          Font.TRUETYPE_FONT,
          rl.getClass().getResource("/assets/NicoClean-Regular.ttf").openStream());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static Font getFontBold() {
    try {
      ;
      return Font.createFont(
          Font.TRUETYPE_FONT,
          rl.getClass().getResource("/assets/NicoBold-Regular.ttf").openStream());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}