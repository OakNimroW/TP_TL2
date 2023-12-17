package game.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.engine.GameFont;

/**
 * Esta clase representa un diálogo de fin de juego que se muestra en una
 * ventana emergente.
 */
public class EndDialog extends JDialog {

  /**
   * Crea un nuevo objeto EndDialog con el propietario, el título y el mensaje
   * especificados.
   * 
   * @param owner   el JFrame propietario del diálogo
   * @param title   el título del diálogo
   * @param message el mensaje del diálogo
   */
  public EndDialog(JFrame owner, String title, String message) {
    super(owner, title);
    this.setUndecorated(true);
    this.setResizable(false);
    this.setModalityType(ModalityType.APPLICATION_MODAL);

    JPanel panel = new BackgroundPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(new EmptyBorder(50, 100, 50, 100));

    JLabel titleLabel = new JLabel(title);
    titleLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    titleLabel.setFont(GameFont.getBold().deriveFont(32f));
    panel.add(titleLabel);

    panel.add(Box.createVerticalStrut(20));

    JLabel messageLabel = new JLabel(message);
    messageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    messageLabel.setFont(GameFont.getRegular().deriveFont(20f));
    panel.add(messageLabel);

    panel.add(Box.createVerticalStrut(30));

    JButton exitButton = new Button("Salir");
    exitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
    exitButton.addActionListener(e -> System.exit(0));
    panel.add(exitButton);

    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setBackground(new Color(0, 0, 0, 0));
    this.setVisible(true);
  }

  /**
   * Esta clase interna representa un panel de fondo para el diálogo.
   * Extiende la clase JPanel y proporciona un método para pintar una imagen de
   * fondo.
   */
  private class BackgroundPanel extends JPanel {
    private ImageIcon background = new ImageIcon("assets/end_background.png");

    public BackgroundPanel() {
      super();
      this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2D = (Graphics2D) g;
      g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
      g2D.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
  }

  /**
   * Esta clase interna representa un botón personalizado para el diálogo.
   * Extiende la clase JButton y proporciona un método para pintar una imagen de
   * fondo.
   */
  private class Button extends JButton {
    private ImageIcon background = new ImageIcon("assets/button.png");

    public Button(String text) {
      this(text, new Insets(10, 20, 10, 20));
    }

    public Button(String text, Insets insets) {
      super(text);
      this.setHorizontalTextPosition(JButton.CENTER);
      this.setFont(GameFont.getRegular().deriveFont(18f));
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
