import game.components.Monster;
import game.components.RumbleGame;
import game.types.Type;

import java.util.Arrays;
import java.util.List;

import entregable.monstruos.evil.*;
import entregable.monstruos.good.*;
import entregable.ordenadores.*;

public class Main {
    public static void main(String[] args) {
        RumbleGame rumbleGame = RumbleGame.getInstance();
        rumbleGame.init();

        List<Monster> monstersOne = Arrays.asList(
                new Deer("Oh deer"));

        // TODO ordenar el listado de monstruos que recibe el jugador uno
        monstersOne = ordenarListaMonstruo(monstersOne,
                new OrdenadorPreferenciaDeTipo(Arrays.asList(Type.PROTECTED, Type.FIGHTER, Type.BEAST)));

        rumbleGame.getPlayerOne().setMonsters(monstersOne);

        List<Monster> monstersTwo = Arrays.asList(
                // new DeathKnight("Death knight")
                new Skeleton("Skeleton"));

        // TODO ordenar el listado de monstruos que recibe el jugador dos

        monstersTwo = ordenarListaMonstruo(monstersTwo, new OrdenadorVidaInicioMayor());

        rumbleGame.getPlayerTwo().setMonsters(monstersTwo);

        rumbleGame.startGame();
    }

    private static List<Monster> ordenarListaMonstruo(List<Monster> lista, Ordenador orden) {
        return orden.ordenar(lista);

    }
}