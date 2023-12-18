package entregable.ordenadores;

import java.util.Comparator;

import game.components.Monster;

/**
 * Esta clase implementa la interfaz Comparator para ordenar objetos de tipo
 * Monster
 * alfabéticamente según su representación en forma de cadena.
 */
public class OrdenadorAlfabetico implements Comparator<Monster> {
    /**
     * Compara dos objetos de tipo Monster y devuelve un valor entero que indica su
     * orden relativo.
     * 
     * @param m1 el primer objeto Monster a comparar
     * @param m2 el segundo objeto Monster a comparar
     * @return un valor negativo si m1 es menor que m2, cero si son iguales, o un
     *         valor positivo si m1 es mayor que m2
     */
    public int compare(Monster m1, Monster m2) {
        return m1.toString().compareTo(m2.toString());
    }
}
