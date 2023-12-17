package entregable.ordenadores;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.components.Monster;

/**
 * Clase que implementa la interfaz Ordenador y la interfaz Comparator para ordenar una lista de monstruos
 * en base a su vida en orden descendente.
 */
public class OrdenadorVidaInicioMayor implements Ordenador, Comparator<Monster> {
    
    /**
     * Compara dos monstruos en base a su vida.
     * @param m1 El primer monstruo a comparar.
     * @param m2 El segundo monstruo a comparar.
     * @return Un valor negativo si m1 tiene una vida mayor que m2, un valor positivo si m2 tiene una vida mayor que m1,
     *         o cero si ambos monstruos tienen la misma vida.
     */
    public int compare (Monster m1, Monster m2) {
        return m2.getLife() - m1.getLife();
    }

    /**
     * Ordena una lista de monstruos en base a su vida en orden descendente.
     * @param listMonsters La lista de monstruos a ordenar.
     * @return La lista de monstruos ordenada en base a su vida en orden descendente.
     */
    public List<Monster> ordenar(List<Monster> listMonsters) {
        
        List<Monster> listaMountrosOrdenada = new ArrayList<Monster>();

        for (Monster monster : listMonsters) {
            listaMountrosOrdenada.add(monster);
        }
        
        Collections.sort(listaMountrosOrdenada, new OrdenadorVidaInicioMayor());

        return listaMountrosOrdenada;
    };

}
