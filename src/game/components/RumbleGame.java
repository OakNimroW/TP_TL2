package game.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import game.random.RandomGenerator;

public class RumbleGame implements ActionListener {

    private static RumbleGame instance = new RumbleGame();
    private final int TIMER_DELAY = 30;

    private Player playerOne, playerTwo;
    private Path westPath, eastPath;
    private boolean isPlaying = false;
    private int timeSinceLastRound = 0;
    private int round = 0;
    private SegundaEvaluacionUI segundaEvaluacionUI;
    private Timer timer = new Timer(TIMER_DELAY, this);

    public static RumbleGame getInstance() {
        return instance;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    private RumbleGame() {
    }

    public void init() {
        playerOne = new Player(1L);
        playerTwo = new Player(2L);

        Castle castleOne = new Castle();
        Castle castleTwo = new Castle();

        westPath = new Path();
        eastPath = new Path();

        castleOne.setEastPath(eastPath);
        castleOne.setWestPath(westPath);

        castleTwo.setEastPath(eastPath);
        castleTwo.setWestPath(westPath);

        playerOne.setCastle(castleOne);
        playerTwo.setCastle(castleTwo);

        segundaEvaluacionUI = new SegundaEvaluacionUI();
        segundaEvaluacionUI.init().setVisible(true);

        PathBox box15 = new PathBox("Noroeste");
        PathBox box27 = new PathBox("Oeste");
        PathBox box39 = new PathBox("Suroeste");

        box15.setNorthBox(null);
        box15.setSouthBox(box27);
        segundaEvaluacionUI.addPathBox(2, 6, box15);

        box27.setNorthBox(box15);
        box27.setSouthBox(box39);
        segundaEvaluacionUI.addPathBox(2, 9, box27);

        box39.setNorthBox(box27);
        box39.setSouthBox(null);
        segundaEvaluacionUI.addPathBox(2, 12, box39);

        westPath.getPathBoxes().add(box15);
        westPath.getPathBoxes().add(box27);
        westPath.getPathBoxes().add(box39);

        PathBox box17 = new PathBox("Noreste");
        PathBox box29 = new PathBox("Este");
        PathBox box41 = new PathBox("Sureste");

        box17.setNorthBox(null);
        box17.setSouthBox(box29);
        segundaEvaluacionUI.addPathBox(9, 6, box17);

        box29.setNorthBox(box17);
        box29.setSouthBox(box41);
        segundaEvaluacionUI.addPathBox(9, 9, box29);

        box41.setNorthBox(box29);
        box41.setSouthBox(null);
        segundaEvaluacionUI.addPathBox(9, 12, box41);

        eastPath.getPathBoxes().add(box17);
        eastPath.getPathBoxes().add(box29);
        eastPath.getPathBoxes().add(box41);

        castleOne.setLifeLabel(segundaEvaluacionUI.getVidasPlayerOneLabel());
        castleTwo.setLifeLabel(segundaEvaluacionUI.getVidasPlayerTwoLabel());
        segundaEvaluacionUI.refresh();
    }

    public void nextRound() {
        System.out.println();
        System.out.println();
        System.out.println("Siguiente Ronda numero: " + round);
        int jugador = RandomGenerator.getInstance().nextPlayer();
        System.out.println("Mueve primero el Jugador numero " + jugador);
        if (jugador == 1) {
            playerOne.nextRound();
            playerTwo.nextRound();
        } else {
            playerTwo.nextRound();
            playerOne.nextRound();
        }
        segundaEvaluacionUI.refresh();
        round++;
        if (playerOne.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Azul!!!         ****");
            isPlaying = false;
        }
        if (playerTwo.getCastle().getCastleLife() <= 0) {
            System.out.println("****         Ganador el Jugador Rojo!!!         ****");
            isPlaying = false;
        }
        if (round == 100) {
            isPlaying = false;
        }
    }

    public void startGame() {
        timer.start();
        isPlaying = true;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == timer) {
            timeSinceLastRound += TIMER_DELAY;
            if (timeSinceLastRound >= 1500) {
                timeSinceLastRound -= 1500;
                nextRound();
            }
            westPath.tick();
            eastPath.tick();

            if (!isPlaying) {
                timer.stop();
                System.exit(0);
            }
        }
    }
}
