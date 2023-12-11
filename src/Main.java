import game.components.Monster;
import game.components.RumbleGame;
import game.monsters.EvilBeast;
import game.monsters.IceBeast;
import game.monsters.Spartan;
import game.types.Type;

import java.util.Arrays;
import java.util.List;

import entregable.monstruos.SwordsMan;
import entregable.monstruos.Tank;
import entregable.ordenadores.*;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(new Spartan("Spartan 1"),
                new Spartan("Spartan 2"),
                new Spartan("Spartan 3"),
                new Spartan("Spartan 4"),
                new IceBeast("Ice Beast 2"),
                new Spartan("Spartan 5"),
                //new SwordsMan("Samurai 1",200, 3, 8),
                new Tank("Gordo Mounstro"),
                new Spartan("Spartan 6"),
                new SwordsMan("Samurai 3"),
                new Spartan("Spartan 9"),
                new Spartan("Spartan 10"),
                new IceBeast("Ice Beast"),
                new Spartan("Spartan 24"),
                new SwordsMan("Samurai 2"),
                new Spartan("Spartan 64"),
                new Spartan("Spartan 15"));

        //TODO ordenar el listado de monstruos que recibe el jugador uno
        monstersOne = ordenarListaMonstruo(monstersOne, new OrdenadorPreferenciaDeTipo(Arrays.asList(Type.ANTITANK, Type.FIGHTER, Type.BEAST)));

        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(new Spartan("Spartan A"),
                new Spartan("Spartan B"),
                new EvilBeast("EvilBeast arr >:O"),
                new Tank("Tank B"),
                new SwordsMan("Samurai A", 200, 3, 8),
                new SwordsMan("Samurai B"),
                new Tank("Tank A"),
                new SwordsMan("Samurai C", 300, 1, 5));

        //TODO ordenar el listado de monstruos que recibe el jugador dos

        monstersTwo = ordenarListaMonstruo(monstersTwo, new OrdenadorVidaInicioMayor());

        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }

    private static List<Monster> ordenarListaMonstruo(List<Monster> lista, Ordenador orden) {
        return orden.ordenar(lista);

    }
}