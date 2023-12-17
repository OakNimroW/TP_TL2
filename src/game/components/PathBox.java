package game.components;

import javax.swing.*;
import java.awt.*;

public class PathBox extends JPanel {
    private Monster monster;
    private PathBox southBox;
    private PathBox northBox;
    private String name;

    ImageIcon healthBar = new ImageIcon("assets/bar_03.png");

    public PathBox(String name) {
        this.name = name;
        this.setOpaque(false);
    }

    public String getName() {
        return name;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public PathBox getSouthBox() {
        return southBox;
    }

    public void setSouthBox(PathBox southBox) {
        this.southBox = southBox;
    }

    public PathBox getNorthBox() {
        return northBox;
    }

    public void setNorthBox(PathBox northBox) {
        this.northBox = northBox;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.monster != null) {
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

            int width = this.getWidth();
            int height = this.getHeight();
            g2D.drawImage(monster.animation.getSprite(), 0, 0, width, height, null);

            int healthBarHeight = (height * 13) / 100;
            g2D.setPaint(Color.BLACK);
            g2D.fillRect(1, 1, width - 2, healthBarHeight - 2);
            if (monster.getPlayer().getId().equals(1L)) {
                g2D.setPaint(new Color(123, 179, 252));
            } else {
                g2D.setPaint(new Color(231, 123, 123));
            }
            g2D.fillRect(1, 1, ((width - 2) * monster.getLife()) / monster.maxLife, healthBarHeight - 2);
            g2D.drawImage(healthBar.getImage(), 0, 0, width, healthBarHeight, null);
        }
    }

    public void tick() {
        if (this.monster != null) {
            monster.animation.tick();
        }
        repaint();
    }
}
