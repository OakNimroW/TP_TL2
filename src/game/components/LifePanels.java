package game.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LifePanels {
  private final int MAX_LIFES = 3;
  LifePanel[] life = new LifePanel[MAX_LIFES];

  ImageIcon heart = new ImageIcon("assets/heart.png");
  ImageIcon slot;

  public LifePanels(String slotImageFile) {
    this.slot = new ImageIcon("assets/" + slotImageFile + "_slot.png");
    for (int i = 0; i < MAX_LIFES; i++) {
      life[i] = new LifePanel();
    }
  }

  public void setLife(int life) {
    for (int i = 0; i < MAX_LIFES; i++) {
      this.life[i].setShowHeart(i < life);
    }
  }

  public JPanel getPanel(int i) {
    return life[i];
  }

  private class LifePanel extends JPanel {
    private boolean showHeart;

    public LifePanel() {
      super();
      showHeart = true;
      this.setOpaque(false);
    }

    public void setShowHeart(boolean showHeart) {
      this.showHeart = showHeart;
      this.repaint();
    }

    @Override
    public void paint(Graphics g) {
      super.paint(g);
      Graphics2D g2D = (Graphics2D) g;
      g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
      int width = this.getWidth();
      int height = this.getHeight();

      g2D.drawImage(slot.getImage(), 0, 0, width, height, null);
      if (showHeart) {
        g2D.drawImage(heart.getImage(), 0, 0, width, height, null);
      }
    }
  }
}
