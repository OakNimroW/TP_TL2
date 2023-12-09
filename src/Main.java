import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.EvilBeast;
import game.monsters.IceBeast;
import game.monsters.Spartan;

import java.util.Arrays;
import java.util.List;

import entregable.monstruos.SwordsMan;
import entregable.monstruos.Tank;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new Spartan("Spartan 1"),
                new Spartan("Spartan 2"),
                new Spartan("Spartan 3"),
                new Spartan("Spartan 4"),
                new Spartan("Spartan 5"),
                new Spartan("Spartan 6"),
                new Spartan("Spartan 7"),
                new Spartan("Spartan 8"),
                new Spartan("Spartan 9"),
                new Spartan("Spartan 10"),
                new IceBeast("Ice Beast"),
                new Spartan("Spartan 24"),
                new Spartan("Spartan 224"),
                new Spartan("Spartan 34"),
                new Spartan("Spartan 44"),
                new Spartan("Spartan 64"),
                new Spartan("Spartan 15"));

        //TODO ordenar el listado de monstruos que recibe el jugador uno
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new Spartan("Spartan A"),
                new Spartan("Spartan B"),
                new Tank("Tank A"),
                new Tank("Tank B"),
                new SwordsMan("Samurai A", 25, 8, 12),
                new SwordsMan("Samurai B"),
                new SwordsMan("Samurai C", 50, 5, 15));

        //TODO ordenar el listado de monstruos que recibe el jugador dos
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }
}