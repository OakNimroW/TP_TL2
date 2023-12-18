package entregable.ordenadores;

import java.util.Comparator;
import game.components.Monster;

public class OrdenadorPorVida implements Comparator<Monster> {
    private boolean ascendente;

    public OrdenadorPorVida(boolean ascendente) {
        this.ascendente = ascendente;
    }

    public int compare(Monster m1, Monster m2) {
        return (m1.getMaxLife() - m2.getMaxLife()) * (ascendente ? 1 : -1);
    }
}
