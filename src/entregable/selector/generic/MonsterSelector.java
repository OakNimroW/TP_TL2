package entregable.selector.generic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
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

import game.components.Player;
import game.engine.GameCursor;
import game.engine.GameFont;

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
    panel.add(buttonsPanel);

    JButton continueButton = new Button("Continuar");
    continueButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
    continueButton.addMouseListener(new MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent e) {
        super.mouseClicked(e);
        player.setMonsters(selectedMonsters.stream().map(m -> m.getMonster()).toList());
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

  void addSelectedMonster(SelectedMonsterButton selectedMonsterButton) {
    if (selectedMonsters.size() >= 30) {
      System.out.println("No se pueden seleccionar mas de 30 monstruos");
      return;
    }
    selectedMonsters.add(selectedMonsterButton);
    selectedPanel.add(selectedMonsterButton);
    selectedPanel.revalidate();
    selectedPanel.repaint();
    System.out.println("Se ha seleccionado el monstruo " + selectedMonsterButton.getMonster());
  }

  void removeSelectedMonster(SelectedMonsterButton selectedMonsterButton) {
    selectedMonsters.remove(selectedMonsterButton);
    selectedPanel.remove(selectedMonsterButton);
    selectedPanel.revalidate();
    selectedPanel.repaint();
    System.out.println("Se ha eliminado el monstruo " + selectedMonsterButton.getMonster());
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

  private class Button extends JButton {
    private ImageIcon background = new ImageIcon("assets/selector_button.png");

    public Button(String text) {
      this(text, new Insets(10, 20, 10, 20));
    }

    public Button(String text, Insets insets) {
      super(text);
      this.setHorizontalTextPosition(JButton.CENTER);
      this.setFont(GameFont.getRegular().deriveFont(18f));
      this.setForeground(Color.WHITE);
      this.setFocusable(false);
      this.setContentAreaFilled(false);
      this.setBorder(new EmptyBorder(insets));
    }

    @Override
    protected void paintComponent(Graphics g) {
      Graphics2D g2D = (Graphics2D) g;
      g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
      g2D.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
      super.paintComponent(g);
    }
  }
}