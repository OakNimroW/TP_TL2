package entregable.selector.generic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entregable.ordenadores.OrdenadorAlfabetico;
import entregable.ordenadores.OrdenadorPorTipo;
import entregable.ordenadores.OrdenadorPorVida;
import game.components.Monster;
import game.components.Player;
import game.engine.GameCursor;
import game.engine.GameFont;

/**
 * Clase que representa un selector de monstruos para ser desplegado al inicio del juego.
 */
public class MonsterSelector extends JDialog {
  private List<SelectedMonsterButton> selectedMonsters = new ArrayList<>();
  private JPanel selectedPanel;

  public MonsterSelector(JFrame owner, Player player, List<SelectMonsterButton> selectMonsterButtons) {
    super(owner);
    String title = String.format("Seleccionar monstruos para el jugador %d", player.getId());
    this.setTitle(title);
    this.setUndecorated(true);
    this.setResizable(false);
    this.setModalityType(ModalityType.APPLICATION_MODAL);

    JPanel panel = new BackgroundPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(new EmptyBorder(30, 100, 50, 100));

    panel.add(Box.createVerticalStrut(20));

    JLabel titleLabel = new JLabel(title);
    titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    titleLabel.setFont(GameFont.getRegular().deriveFont(24f));
    titleLabel.setForeground(Color.WHITE);
    panel.add(titleLabel);

    panel.add(Box.createVerticalStrut(20));

    JPanel selectablePanel = new JPanel();
    selectablePanel.setLayout(new FlowLayout());
    selectablePanel.setOpaque(false);
    selectMonsterButtons.forEach(button -> {
      button.setSelector(this);
      selectablePanel.add(button);
    });
    panel.add(selectablePanel);

    panel.add(Box.createVerticalStrut(20));

    selectedPanel = new JPanel();
    selectedPanel.setPreferredSize(new Dimension(0, 200));
    selectedPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
    selectedPanel.setBackground(new Color(0x060608));
    selectedPanel.setOpaque(true);
    panel.add(selectedPanel);

    panel.add(Box.createVerticalStrut(30));

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
    buttonsPanel.setOpaque(false);
    JButton sortButton;
    sortButton = new Button("Ordenar por nombre");
    sortButton.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        sortMonsters(new OrdenadorAlfabetico());
      }
    });
    buttonsPanel.add(sortButton);
    sortButton = new Button("Ordenar por vida");
    sortButton.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        sortMonsters(new OrdenadorPorVida(true));
      }
    });
    buttonsPanel.add(sortButton);
    sortButton = new Button("Ordenar por tipo");
    sortButton.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        sortMonsters(new OrdenadorPorTipo(true));
      }
    });
    buttonsPanel.add(sortButton);
    panel.add(buttonsPanel);

    panel.add(Box.createVerticalStrut(30));

    JButton continueButton = new Button("Continuar");
    continueButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
    continueButton.addMouseListener(new MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent e) {
        super.mouseClicked(e);
        List<Monster> monsters = selectedMonsters.stream().map(SelectedMonsterButton::getMonster).toList();
        player.setMonsters(monsters);
        int i = 0;
        for (Monster m : monsters) {
          System.out.printf("%d: %s\n", ++i, m);
        }
        MonsterSelector.this.dispose();
      }
    });
    panel.add(continueButton);

    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setBackground(new Color(0, 0, 0, 0));
    this.setVisible(true);
  }

  void refreshSelected() {
    selectedPanel.revalidate();
    selectedPanel.repaint();
  }

  void addSelectedMonster(SelectedMonsterButton selectedMonsterButton) {
    if (selectedMonsters.size() >= 30) {
      System.out.println("No se pueden seleccionar mas de 30 monstruos");
      return;
    }
    selectedMonsters.add(selectedMonsterButton);
    selectedPanel.add(selectedMonsterButton);
    this.refreshSelected();
    System.out.println("Se ha seleccionado el monstruo " + selectedMonsterButton.getMonster());
  }

  void removeSelectedMonster(SelectedMonsterButton selectedMonsterButton) {
    selectedMonsters.remove(selectedMonsterButton);
    selectedPanel.remove(selectedMonsterButton);
    this.refreshSelected();
    System.out.println("Se ha eliminado el monstruo " + selectedMonsterButton.getMonster());
  }

  void sortMonsters(Comparator<Monster> comparator) {
    selectedPanel.removeAll();
    selectedMonsters.sort((b1, b2) -> comparator.compare(b1.getMonster(), b2.getMonster()));
    selectedMonsters.forEach(selectedPanel::add);
    this.refreshSelected();
  }

  private class BackgroundPanel extends JPanel {
    private ImageIcon background = new ImageIcon("assets/selector_background.png");

    public BackgroundPanel() {
      super();
      this.setOpaque(false);
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
}
