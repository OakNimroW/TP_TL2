package game.engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
  private BufferedImage spriteSheet;
  private static final int TILE_SIZE = 16;

  public SpriteSheet(String name) {
    try {
      spriteSheet = ImageIO.read(new File("assets/sprite_sheet_" + name + "_16x16.png"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private BufferedImage[] getRowFromSpriteSheet(int yGrid) {
    BufferedImage[] row = new BufferedImage[spriteSheet.getWidth() / TILE_SIZE];
    for (int i = 0; i < row.length; i++) {
      row[i] = spriteSheet.getSubimage(i * TILE_SIZE, yGrid * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
    return row;
  }

  public Animation getIdleAnimation() {
    return new Animation(getRowFromSpriteSheet(0), 8, Animation.Direction.FORWARD_LOOP);
  }

  public Animation getWalkAnimation() {
    return new Animation(getRowFromSpriteSheet(1), 8, Animation.Direction.FORWARD_LOOP);
  }

  public Animation getAttackAnimation() {
    return new Animation(getRowFromSpriteSheet(2), 8, Animation.Direction.FORWARD_ONCE);
  }

  public Animation getDamageTakenAnimation() {
    return new Animation(getRowFromSpriteSheet(3), 8, Animation.Direction.FORWARD_ONCE);
  }

  public Animation getDeathAnimation() {
    return new Animation(getRowFromSpriteSheet(4), 8, Animation.Direction.FORWARD_ONCE);
  }

  public Animation getAlternativeAnimation() {
    return new Animation(getRowFromSpriteSheet(5), 8, Animation.Direction.FORWARD_ONCE);
  }
}
