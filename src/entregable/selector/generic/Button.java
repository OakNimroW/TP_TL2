package entregable.selector.generic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import game.engine.GameFont;

class Button extends JButton {
  private ImageIcon background = new ImageIcon("assets/selector_button.png");

  Button(String text) {
    super(text);
    this.setHorizontalTextPosition(JButton.CENTER);
    this.setFont(GameFont.getRegular().deriveFont(18f));
    this.setForeground(Color.WHITE);
    this.setFocusable(false);
    this.setContentAreaFilled(false);
    this.setFocusPainted(false);
    this.setBorder(new EmptyBorder(10, 20, 10, 20));
  }

  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;
    g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
    g2D.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    super.paintComponent(g);
  }
}
