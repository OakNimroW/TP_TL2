package entregable.ordenadores;

import java.util.Comparator;
import game.components.Monster;

/**
 * Clase que implementa la interfaz Comparator para ordenar objetos de tipo Monster por su vida máxima.
 */
public class OrdenadorPorVida implements Comparator<Monster> {
    private boolean ascendente;

    /**
     * Constructor de la clase OrdenadorPorVida.
     * @param ascendente indica si el ordenamiento es ascendente (true) o descendente (false).
     */
    public OrdenadorPorVida(boolean ascendente) {
        this.ascendente = ascendente;
    }

    /**
     * Compara dos objetos de tipo Monster por su vida máxima.
     * @param m1 el primer objeto Monster a comparar.
     * @param m2 el segundo objeto Monster a comparar.
     * @return un valor negativo si m1 tiene una vida máxima menor que m2, un valor positivo si m1 tiene una vida máxima mayor que m2,
     *         o cero si ambos tienen la misma vida máxima.
     */
    public int compare(Monster m1, Monster m2) {
        return (m1.getMaxLife() - m2.getMaxLife()) * (ascendente ? 1 : -1);
    }
}
