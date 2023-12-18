package entregable.selector.generic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import game.components.Monster;

class SelectedMonsterButton extends JButton {
  private final int BUTTON_SIZE = 48;

  private Monster monster;
  private ImageIcon icon;
  private ImageIcon overlay = new ImageIcon("assets/selector_monster_overlay.png");
  private MonsterSelector selector;

  SelectedMonsterButton(MonsterSelector selector, Monster monster, ImageIcon icon) {
    super();
    this.selector = selector;
    this.monster = monster;
    this.icon = icon;
    this.setFocusable(false);
    this.setContentAreaFilled(false);
    this.setFocusPainted(false);
    this.setPreferredSize(new Dimension(BUTTON_SIZE, BUTTON_SIZE));
    this.setBorder(new EmptyBorder(0, 0, 0, 0));
    this.addMouseListener(new InnerMouseAdapter());
    this.setToolTipText(monster.toString());
  }

  public Monster getMonster() {
    return monster;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g;

    g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
    g2D.drawImage(icon.getImage(), 0, 0, BUTTON_SIZE, BUTTON_SIZE, null);
    g2D.drawImage(overlay.getImage(), 0, 0, BUTTON_SIZE, BUTTON_SIZE, null);
  }

  class InnerMouseAdapter extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
      super.mouseClicked(e);
      selector.removeSelectedMonster(SelectedMonsterButton.this);
    }
  }
}
