package entregable.ordenadores;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.components.Monster;

/**
 * Clase que implementa la interfaz Ordenador y el comparador Comparator para
 * ordenar objetos Monster alfabéticamente.
 */
public class OrdenadorAlfabeticamente implements Ordenador, Comparator<Monster> {

    /**
     * Compara dos objetos Monster alfabéticamente.
     * 
     * @param m1 el primer objeto Monster a comparar
     * @param m2 el segundo objeto Monster a comparar
     * @return un valor negativo si m1 es menor que m2, cero si son iguales, o un
     *         valor positivo si m1 es mayor que m2
     */
    public int compare(Monster m1, Monster m2) {
        return m1.toString().compareTo(m2.toString());
    }

    /**
     * Ordena una lista de objetos Monster alfabéticamente.
     * 
     * @param listMonsters la lista de objetos Monster a ordenar
     * @return la lista de objetos Monster ordenada alfabéticamente
     */
    public List<Monster> ordenar(List<Monster> listMonsters) {

        List<Monster> listaMountrosOrdenada = new ArrayList<Monster>();

        for (Monster monster : listMonsters) {
            listaMountrosOrdenada.add(monster);
        }

        Collections.sort(listaMountrosOrdenada, new OrdenadorAlfabeticamente());

        return listaMountrosOrdenada;
    };

}
