import game.components.RumbleGame;
import entregable.adicional.MonsterSelector;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        MonsterSelector selector = MonsterSelector.getInstance();

        selector.configurePlayerCLI(rumbleGame.getPlayerOne());

        selector.configurePlayerCLI(rumbleGame.getPlayerTwo());

        rumbleGame.startGame();
    }

}