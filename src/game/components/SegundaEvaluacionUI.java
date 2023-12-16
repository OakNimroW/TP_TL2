package game.components;

import javax.swing.*;
import java.awt.*;

public class SegundaEvaluacionUI extends JFrame {
    private JLabel label1;
    private JLabel label2;

    public SegundaEvaluacionUI init() {
        this.addLabels();
        setContentPane(new BackgroundPanel());
        setTitle("Segunda Evaluacion");
        setSize(600, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        setLocationRelativeTo(null);
        return this;
    }

    public void addPathBox(Point point, PathBox pathBox) {
        pathBox.setLocation(point);
        pathBox.setVisible(true);
        this.add(pathBox);
    }

    private void addLabels() {
        label1 = new JLabel();
        label1.setText("Vidas: 3");
        label1.setForeground(Color.RED);
        label1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        // panelList.get(0).setLayout(new FlowLayout(FlowLayout.LEFT));
        // panelList.get(0).add(label1);

        label2 = new JLabel();
        label2.setText("Vidas: 3");
        label2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        label2.setForeground(Color.BLUE);
        // panelList.get(57).setLayout(new FlowLayout(FlowLayout.LEFT));
        // panelList.get(57).add(label2);
    }

    public JLabel getVidasPlayerOneLabel() {
        return label1;
    }

    public JLabel getVidasPlayerTwoLabel() {
        return label2;
    }

    public void refresh() {
        this.revalidate();
        this.repaint();
    }
}
