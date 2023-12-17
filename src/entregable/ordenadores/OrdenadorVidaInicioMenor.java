package entregable.ordenadores;

import java.util.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.components.Monster;

/**
 * Clase que implementa la interfaz Ordenador y el comparador
 * Comparator<Monster>.
 * Ordena una lista de monstruos por su vida en orden ascendente.
 */
public class OrdenadorVidaInicioMenor implements Ordenador, Comparator<Monster> {

    /**
     * Compara dos monstruos por su vida.
     * 
     * @param m1 El primer monstruo a comparar.
     * @param m2 El segundo monstruo a comparar.
     * @return Un valor negativo si m1 tiene menos vida que m2, un valor positivo si
     *         m1 tiene más vida que m2, o 0 si tienen la misma vida.
     */
    public int compare(Monster m1, Monster m2) {
        return m1.getLife() - m2.getLife();
    }

    /**
     * Ordena una lista de monstruos por su vida en orden ascendente.
     * 
     * @param listMonsters La lista de monstruos a ordenar.
     * @return La lista de monstruos ordenada por su vida en orden ascendente.
     */
    public List<Monster> ordenar(List<Monster> listMonsters) {

        List<Monster> listaMountrosOrdenada = new ArrayList<Monster>();

        for (Monster monster : listMonsters) {
            listaMountrosOrdenada.add(monster);
        }

        Collections.sort(listaMountrosOrdenada, new OrdenadorVidaInicioMenor());

        return listaMountrosOrdenada;
    };

}
