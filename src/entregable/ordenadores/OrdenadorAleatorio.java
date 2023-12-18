package entregable.ordenadores;

import java.util.ArrayList;
import java.util.List;

import game.components.Monster;

/**
 * Esta clase implementa la interfaz Ordenador y proporciona un método para
 * ordenar una lista de monstruos de forma aleatoria.
 */
public class OrdenadorAleatorio implements Ordenador {

    /**
     * Ordena una lista de monstruos de forma aleatoria.
     * 
     * @param listMonsters la lista de monstruos a ordenar
     * @return la lista de monstruos ordenada de forma aleatoria
     */
    public List<Monster> ordenar(List<Monster> listMonsters) {

        List<Monster> listMonstersCopy = new ArrayList<Monster>();

        for (Monster monster : listMonsters) {
            listMonstersCopy.add(monster);
        }

        List<Monster> listaMontrosOrdenada = new ArrayList<Monster>();

        while (listMonstersCopy.size() > 0) {
            int index = (int) Math.round(Math.random() * (listMonstersCopy.size() - 1));
            Monster monster_tmp = listMonstersCopy.get(index);
            listaMontrosOrdenada.add(monster_tmp);
            listMonstersCopy.remove(monster_tmp);
        }

        return listaMontrosOrdenada;

    };

}
