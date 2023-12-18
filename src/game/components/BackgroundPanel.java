package game.components;

import javax.swing.*;

import game.engine.ResourceLoader;

import java.awt.*;

public class BackgroundPanel extends JComponent {

    private Image background = ResourceLoader.loadImage("background.png");

    public BackgroundPanel() {
        ResourceLoader.setDefaultCursor(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2D.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
}
