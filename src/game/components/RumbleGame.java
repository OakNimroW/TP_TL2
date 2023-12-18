package game.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import entregable.selector.good.MonsterSelector;
import game.exceptions.NoMonstersException;
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

        PathBox box15 = segundaEvaluacionUI.getPathBox(15);
        PathBox box27 = segundaEvaluacionUI.getPathBox(27);
        PathBox box39 = segundaEvaluacionUI.getPathBox(39);

        box15.setNorthBox(null);
        box15.setSouthBox(box27);

        box27.setNorthBox(box15);
        box27.setSouthBox(box39);

        box39.setNorthBox(box27);
        box39.setSouthBox(null);

        westPath.getPathBoxes().add(box15);
        westPath.getPathBoxes().add(box27);
        westPath.getPathBoxes().add(box39);

        PathBox box17 = segundaEvaluacionUI.getPathBox(17);
        PathBox box29 = segundaEvaluacionUI.getPathBox(29);
        PathBox box41 = segundaEvaluacionUI.getPathBox(41);

        box17.setNorthBox(null);
        box17.setSouthBox(box29);

        box29.setNorthBox(box17);
        box29.setSouthBox(box41);

        box41.setNorthBox(box29);
        box41.setSouthBox(null);

        eastPath.getPathBoxes().add(box17);
        eastPath.getPathBoxes().add(box29);
        eastPath.getPathBoxes().add(box41);

        castleOne.setLifePanels(segundaEvaluacionUI.getLifePanelsCastleOne());
        castleTwo.setLifePanels(segundaEvaluacionUI.getLifePanelsCastleTwo());
        segundaEvaluacionUI.refresh();
    }

    public void pickMonsters(Long playerId) {
        if (playerId == 1L) {
            new MonsterSelector(segundaEvaluacionUI, playerOne);
        } else {
            // TODO: implementar mostruos aleatorios
        }
    }

    public void nextRound() throws NoMonstersException {
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
        if (isPlaying) {
            if (round == 100) {
                System.out.println("****          Se llegó a la ronda 100           ****");
                isPlaying = false;
            } else if (!eastPath.hasAnyMonster()
                    && !westPath.hasAnyMonster()
                    && !playerOne.hasMonstersLeft()
                    && !playerTwo.hasMonstersLeft()) {
                throw new NoMonstersException();
            }
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
            try {
                timeSinceLastRound += TIMER_DELAY;
                if (timeSinceLastRound >= 1500) {
                    timeSinceLastRound -= 1500;
                    nextRound();
                }
                westPath.tick();
                eastPath.tick();

                if (!isPlaying) {
                    timer.stop();

                    if (playerOne.getCastle().getCastleLife() <= 0) {
                        if (playerTwo.getCastle().getCastleLife() <= 0) {
                            new EndDialog(segundaEvaluacionUI, "Empate", "Ambos jugadores se han quedado sin vidas.");
                        } else {
                            new EndDialog(segundaEvaluacionUI, "¡Fin del juego!", "¡El jugador 2 ha ganado!");
                        }
                    } else if (playerTwo.getCastle().getCastleLife() <= 0) {
                        new EndDialog(segundaEvaluacionUI, "¡Fin del juego!", "¡El jugador 1 ha ganado!");
                    } else {
                        new EndDialog(segundaEvaluacionUI, "Empate", "Se ha llegado a la ronda 100.");
                    }
                }
            } catch (NoMonstersException e) {
                timer.stop();
                System.out.println("****          No hay mas monstruos           ****");
                isPlaying = false;
                new EndDialog(segundaEvaluacionUI, "Empate", "Ambos jugadores se han quedado sin monstruos.");
            }
        }
    }
}
