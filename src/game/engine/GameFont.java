package game.engine;

import java.awt.Font;
import java.io.File;

/**
 * La clase GameFont representa una fuente de texto utilizada en el juego.
 * Proporciona métodos estáticos para obtener diferentes estilos de fuente.
 */
public class GameFont {
  /**
   * Devuelve una instancia de Font que representa una fuente regular.
   *
   * @return la fuente regular
   * @throws RuntimeException si ocurre un error al cargar la fuente
   */
  public static Font getRegular() {
    try {
      return Font.createFont(Font.TRUETYPE_FONT, new File("assets/NicoClean-Regular.ttf"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Devuelve una instancia de Font que representa una fuente en negrita.
   *
   * @return la fuente en negrita
   * @throws RuntimeException si ocurre un error al cargar la fuente
   */
  public static Font getBold() {
    try {
      return Font.createFont(Font.TRUETYPE_FONT, new File("assets/NicoBold-Regular.ttf"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
