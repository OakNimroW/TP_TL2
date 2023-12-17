package game.engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * La clase SpriteSheet representa una hoja de sprites que contiene múltiples imágenes de sprites.
 * Cada imagen de sprite en la hoja de sprites se puede acceder mediante su posición en la cuadrícula.
 */
public class SpriteSheet {
  private BufferedImage spriteSheet;
  private static final int TILE_SIZE = 16;

  /**
   * Crea una nueva instancia de SpriteSheet con el nombre especificado.
   *
   * @param name el nombre de la hoja de sprites
   */
  public SpriteSheet(String name) {
    try {
      spriteSheet = ImageIO.read(new File("assets/sprite_sheet_" + name + "_16x16.png"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Obtiene una fila de imágenes de sprite de la hoja de sprites en la posición de la cuadrícula especificada.
   *
   * @param yGrid la posición de la cuadrícula en el eje Y
   * @return un arreglo de BufferedImage que representa la fila de imágenes de sprite
   */
  private BufferedImage[] getRowFromSpriteSheet(int yGrid) {
    BufferedImage[] row = new BufferedImage[spriteSheet.getWidth() / TILE_SIZE];
    for (int i = 0; i < row.length; i++) {
      row[i] = spriteSheet.getSubimage(i * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
    return row;
  }

  /**
   * Obtiene la animación de inactividad.
   *
   * @return la animación de inactividad
   */
  public Animation getIdleAnimation() {
    return new Animation(getRowFromSpriteSheet(0), 8, Animation.Direction.FORWARD_LOOP);
  }

  /**
   * Obtiene la animación de caminar.
   *
   * @return la animación de caminar
   */
  public Animation getWalkAnimation() {
    return new Animation(getRowFromSpriteSheet(1), 8, Animation.Direction.FORWARD_LOOP);
  }

  /**
   * Obtiene la animación de ataque.
   *
   * @return la animación de ataque
   */
  public Animation getAttackAnimation() {
    return new Animation(getRowFromSpriteSheet(2), 8, Animation.Direction.FORWARD_ONCE);
  }

  /**
   * Obtiene la animación de recibir daño.
   *
   * @return la animación de recibir daño
   */
  public Animation getDamageTakenAnimation() {
    return new Animation(getRowFromSpriteSheet(3), 8, Animation.Direction.FORWARD_ONCE);
  }

  /**
   * Obtiene la animación de muerte.
   *
   * @return la animación de muerte
   */
  public Animation getDeathAnimation() {
    return new Animation(getRowFromSpriteSheet(4), 8, Animation.Direction.FORWARD_ONCE);
  }

  /**
   * Obtiene una animación alternativa.
   *
   * @return la animación alternativa
   */
  public Animation getAlternativeAnimation() {
    return new Animation(getRowFromSpriteSheet(5), 8, Animation.Direction.FORWARD_ONCE);
  }
}
