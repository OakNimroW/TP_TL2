package game.components;

import javax.swing.*;
import java.awt.*;

public class PathBox extends JPanel {
    private Monster monster;
    private PathBox southBox;
    private PathBox northBox;
    private String name;
    private final int BOX_WIDTH = 64;

    public PathBox(String name) {
        this.name = name;
        this.setBounds(0, 0, BOX_WIDTH, BOX_WIDTH + 8);
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
        Graphics2D g2D = (Graphics2D) g;

        if (this.monster != null) {
            g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            g2D.drawImage(monster.animation.getSprite(), 0, 0, BOX_WIDTH, BOX_WIDTH, null);

            if (monster.getPlayer().getId().equals(1L)) {
                g2D.setPaint(new Color(123, 179, 252));
            } else {
                g2D.setPaint(new Color(231, 123, 123));
            }
            int lifeBarWidth = (int) (BOX_WIDTH * ((double) monster.getLife() / monster.maxLife));
            g2D.fillRect(0, BOX_WIDTH + 4, lifeBarWidth, 4);
            g2D.setPaint(Color.BLACK);
            g2D.fillRect(lifeBarWidth, BOX_WIDTH + 4, BOX_WIDTH - lifeBarWidth, 4);
        }
    }

    public void tick() {
        if (this.monster != null) {
            monster.animation.tick();
        }
        repaint();
    }
}
