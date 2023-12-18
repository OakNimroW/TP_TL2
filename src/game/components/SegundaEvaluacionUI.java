package game.components;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.function.Consumer;

public class SegundaEvaluacionUI extends JFrame {
    private final int ROWS = 19;
    private final int COLUMNS = 12;

    private JPanel[][] panelMatrix = new JPanel[ROWS][COLUMNS];
    private LifePanels life1, life2;
    private HashMap<Integer, PathBox> pathBoxes = new HashMap<>();

    public SegundaEvaluacionUI init() {
        this.addLifePanels();
        this.addPathBoxes();
        this.fillPanels();
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

    private void addLifePanels() {
        // "Castle one" no es el castillo del
        // jugador 1, es el castillo al que
        // ataca el jugador 1

        life1 = new LifePanels("castle_one");
        panelMatrix[0][9] = life1.getPanel(0);
        panelMatrix[0][10] = life1.getPanel(1);
        panelMatrix[0][11] = life1.getPanel(2);

        life2 = new LifePanels("castle_two");
        panelMatrix[18][0] = life2.getPanel(0);
        panelMatrix[18][1] = life2.getPanel(1);
        panelMatrix[18][2] = life2.getPanel(2);
    }

    private void addPathBoxes() {
        PathBox box;

        box = new PathBox("Nortoeste");
        panelMatrix[6][2] = box;
        pathBoxes.put(15, box);

        box = new PathBox("Oeste");
        panelMatrix[9][2] = box;
        pathBoxes.put(27, box);

        box = new PathBox("Suroeste");
        panelMatrix[12][2] = box;
        pathBoxes.put(39, box);

        box = new PathBox("Noreste");
        panelMatrix[6][9] = box;
        pathBoxes.put(17, box);

        box = new PathBox("Este");
        panelMatrix[9][9] = box;
        pathBoxes.put(29, box);

        box = new PathBox("Sureste");
        panelMatrix[12][9] = box;
        pathBoxes.put(41, box);
    }

    public LifePanels getLifePanelsCastleOne() {
        return life1;
    }

    public LifePanels getLifePanelsCastleTwo() {
        return life2;
    }

    public PathBox getPathBox(int i) {
        return pathBoxes.get(i);
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

    private void fillPanels() {
        JPanel panel;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (panelMatrix[i][j] != null)
                    continue;
                panel = new JPanel();
                panel.setOpaque(false);
                panel.setBackground(new Color(0, 0, 0, 0));
                // panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelMatrix[i][j] = panel;
            }
        }
    }
}
