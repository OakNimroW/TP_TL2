import game.components.RumbleGame;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        rumbleGame.pickMonsters(1L);
        rumbleGame.pickMonsters(2L);

        rumbleGame.startGame();
    }

}