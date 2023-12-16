package game.components;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class SegundaEvaluacionUI extends JFrame {
    private final int ROWS = 19;
    private final int COLUMNS = 12;

    private JPanel[][] panelMatrix = new JPanel[ROWS][COLUMNS];
    private JLabel label1, label2;

    public SegundaEvaluacionUI init() {
        this.initPanels();
        this.addLabels();
        setTitle("Segunda Evaluacion");
        int width = 600;
        setSize(width, width * ROWS / COLUMNS);
        setContentPane(new BackgroundPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(ROWS, COLUMNS);
        forEachPanel(SegundaEvaluacionUI.this::add);

        setLayout(gridLayout);
        setLocationRelativeTo(null);
        return this;
    }

    public void addPathBox(int x, int y, PathBox pathBox) {
        panelMatrix[y][x].add(pathBox);
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

    private void forEachPanel(Consumer<? super JPanel> consumer) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                consumer.accept(panelMatrix[i][j]);
            }
        }
    }

    private void initPanels() {
        JPanel panel;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                panel = new JPanel();
                panel.setOpaque(false);
                panel.setBackground(new Color(0, 0, 0, 0));
                // panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setLayout(new GridLayout(0, 1));
                panel.setVisible(true);
                panelMatrix[i][j] = panel;
            }
        }
    }
}
