import game.components.Monster;
import game.components.RumbleGame;

import java.util.Arrays;
import java.util.List;

import entregable.monstruos.evil.*;
import game.monsters.evil.*;
import entregable.monstruos.good.*;
import game.monsters.good.*;

import entregable.ordenadores.*;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(
                // new Deer("Oh deer"),
                // new Pikeman("Pikeman"),
                // new SwordsMan("Swordsman"),
                new WolfRider("WolfRider")
                );

        List<Monster> monstersTwo = Arrays.asList(
                // new DeathKnight("Death knight")
                // new Skeleton("Skeleton"),
                new EvilBeast("Evil beast")
                );

        Ordenador ordenadorOne = new OrdenadorVidaInicioMayor();
        monstersOne = ordenadorOne.ordenar(monstersOne);
        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        Ordenador ordenadorTwo = new OrdenadorVidaInicioMayor();
        monstersTwo = ordenadorTwo.ordenar(monstersTwo);
        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        // TODO(b-Tomas): reenable selector before merging. The lists made above are for
        // testing purposes only.
        // MonsterSelector selector = MonsterSelector.getInstance();

        // selector.configurePlayerCLI(rumbleGame.getPlayerOne());

        // selector.configurePlayerCLI(rumbleGame.getPlayerTwo());

        rumbleGame.startGame();
    }

}