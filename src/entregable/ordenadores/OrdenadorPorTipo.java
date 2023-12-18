package entregable.ordenadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import game.components.Monster;
import game.types.Type;

/**
 * Clase que implementa la interfaz Comparator para ordenar objetos de tipo
 * Monster por tipo.
 * El orden puede ser ascendente o descendente.
 */
public class OrdenadorPorTipo implements Comparator<Monster> {
    private boolean ascendente;

    /**
     * Constructor de la clase OrdenadorPorTipo.
     * 
     * @param ascendente indica si el orden es ascendente (true) o descendente
     *                   (false).
     */
    public OrdenadorPorTipo(boolean ascendente) {
        this.ascendente = ascendente;
    }

    /**
     * Compara dos objetos de tipo Monster por tipo.
     * 
     * @param m1 el primer objeto Monster a comparar.
     * @param m2 el segundo objeto Monster a comparar.
     * @return un valor negativo si m1 es menor que m2, un valor positivo si m1 es
     *         mayor que m2, o 0 si son iguales.
     */
    public int compare(Monster m1, Monster m2) {
        List<Type> t1, t2;
        t1 = new ArrayList<>(m1.getTypes());
        t1.sort(Comparator.naturalOrder());
        t2 = new ArrayList<>(m2.getTypes());
        t2.sort(Comparator.naturalOrder());

        if (!ascendente) {
            List<Type> aux = t1;
            t1 = t2;
            t2 = aux;
        }

        int c;
        while (true) {
            if (t1.isEmpty()) {
                if (t2.isEmpty()) {
                    return 0;
                } else {
                    return -1;
                }
            } else if (t2.isEmpty()) {
                return 1;
            } else {
                c = t1.get(0).compareTo(t2.get(0));
                if (c != 0) {
                    return c;
                } else {
                    t1.remove(0);
                    t2.remove(0);
                }
            }
        }
    }
}
