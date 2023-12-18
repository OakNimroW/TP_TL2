package entregable.selector.generic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import game.components.Monster;
import game.engine.GameFont;

/**
 * Botón de selección de monstruo
 */
public class SelectMonsterButton extends JButton {
  private final int MONSTER_SIZE = 64;
  private final int BUTTON_WIDTH = 84;
  private final int BUTTON_HEIGHT = 94;

  private int id = 1;
  private String name;
  private ImageIcon monsterIcon;
  private MonsterSelector selector;
  private CreateMonsterOperation createMonster;

  private ImageIcon overlay = new ImageIcon("assets/selector_monster_overlay.png");
  private Font font = GameFont.getRegular().deriveFont(12f);

  public SelectMonsterButton(String name, String iconName, CreateMonsterOperation createMonster) {
    super();
    this.name = name;
    this.monsterIcon = new ImageIcon("assets/icon_" + iconName + "_32x32.png");
    this.createMonster = createMonster;
    this.setFocusable(false);
    this.setContentAreaFilled(false);
    this.setFocusPainted(false);
    this.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
    this.setBorder(new EmptyBorder(0, 0, 0, 0));
    this.addMouseListener(new InnerMouseAdapter());
  }

  public void setSelector(MonsterSelector selector) {
    this.selector = selector;
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

    AttributedString styledText = new AttributedString(name);
    styledText.addAttribute(TextAttribute.FONT, font);
    styledText.addAttribute(TextAttribute.FOREGROUND, Color.WHITE);
    AttributedCharacterIterator styledTextIterator = styledText.getIterator();
    FontRenderContext frc = g2D.getFontRenderContext();
    LineBreakMeasurer measurer = new LineBreakMeasurer(styledTextIterator, frc);
    measurer.setPosition(styledTextIterator.getBeginIndex());

    float x = 0, y = MONSTER_SIZE + 4;
    while (measurer.getPosition() < styledTextIterator.getEndIndex()) {
      TextLayout layout = measurer.nextLayout(BUTTON_WIDTH);

      y += layout.getAscent();
      float dx = (BUTTON_WIDTH - layout.getAdvance()) / 2;

      layout.draw(g2D, x + dx, y);
      y += layout.getDescent() + layout.getLeading();
    }
  }

  class InnerMouseAdapter extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
      super.mouseClicked(e);
      if (selector == null) {
        return;
      }
      Monster monster = createMonster.operate(String.format("%s %d", name, id++));
      selector.addSelectedMonster(new SelectedMonsterButton(selector, monster, monsterIcon));
    }
  }
}
