package entregable.ordenadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import game.components.Monster;
import game.types.Type;

public class OrdenadorPorTipo implements Comparator<Monster> {
    private boolean ascendente;

    public OrdenadorPorTipo(boolean ascendente) {
        this.ascendente = ascendente;
    }

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
