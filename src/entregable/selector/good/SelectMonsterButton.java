package entregable.selector.good;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import game.components.Monster;
import game.engine.GameFont;

class SelectMonsterButton extends JButton {
  private final int MONSTER_SIZE = 64;
  private final int BUTTON_WIDTH = 96;
  private final int BUTTON_HEIGHT = 80;

  private int id = 1;
  private String name;
  private ImageIcon monsterIcon;
  private ImageIcon overlay = new ImageIcon("assets/selector_monster_overlay.png");
  private MonsterSelector selector;
  private CreateMonsterOperation createMonster;

  SelectMonsterButton(MonsterSelector selector, String name, String iconName,
      CreateMonsterOperation createMonster) {
    super();
    this.name = name;
    this.monsterIcon = new ImageIcon("assets/icon_" + iconName + "_32x32.png");
    this.selector = selector;
    this.createMonster = createMonster;
    this.setFocusable(false);
    this.setContentAreaFilled(false);
    this.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    this.setBorder(new EmptyBorder(0, 0, 0, 0));
    this.addMouseListener(new InnerMouseAdapter());
  }

  public String getName() {
    return String.format("%s %d", name, id++);
  }

  public ImageIcon getIcon() {
    return monsterIcon;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int offsetLeft;
    Graphics2D g2D = (Graphics2D) g;
    g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

    offsetLeft = (BUTTON_WIDTH - MONSTER_SIZE) / 2;
    g2D.drawImage(monsterIcon.getImage(), offsetLeft, 0, MONSTER_SIZE, MONSTER_SIZE, null);
    g2D.drawImage(overlay.getImage(), offsetLeft, 0, MONSTER_SIZE, MONSTER_SIZE, null);

    Font font = GameFont.getRegular().deriveFont(12f);
    FontMetrics metrics = g2D.getFontMetrics(font);
    offsetLeft = (BUTTON_WIDTH - metrics.stringWidth(name)) / 2;
    g2D.setFont(font);
    g2D.setColor(Color.WHITE);
    g2D.drawString(name, offsetLeft, BUTTON_HEIGHT - 3);
  }

  class InnerMouseAdapter extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
      super.mouseClicked(e);
      Monster monster = createMonster.operate(String.format("%s %d", name, id++));
      selector.addSelectedMonster(new SelectedMonsterButton(selector, monster, monsterIcon));
    }
  }
}