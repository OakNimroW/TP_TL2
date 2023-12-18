package game.engine;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JComponent;

public class GameCursor {
  private static Toolkit toolkit = Toolkit.getDefaultToolkit();

  public static void setDefault(JComponent component) {
    Image image = toolkit.getImage("assets/Cursor_1.png");
    Point hotspot = new Point(0, 0);
    Cursor cursor = toolkit.createCustomCursor(image, hotspot, "pixelart");
    component.setCursor(cursor);
  }
}
