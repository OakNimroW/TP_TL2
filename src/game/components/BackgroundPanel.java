package game.components;

import javax.swing.*;

import game.engine.GameCursor;

import java.awt.*;

public class BackgroundPanel extends JComponent {

    private ImageIcon background = new ImageIcon("assets/background.png");

    public BackgroundPanel() {
        GameCursor.setDefault(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2D.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
