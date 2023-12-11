package entregable.ordenadores;

import java.util.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.components.Monster;

public class OrdenadorVidaInicioMenor implements Ordenador, Comparator<Monster> {
    
    public int compare (Monster m1, Monster m2) {
        return m1.getLife() - m2.getLife();
    }

    public List<Monster> ordenar(List<Monster> listMonsters) {
        
        List<Monster> listaMountrosOrdenada = new ArrayList<Monster>();

        for (Monster monster : listMonsters) {
            listaMountrosOrdenada.add(monster);
        }
        
        Collections.sort(listaMountrosOrdenada, new OrdenadorVidaInicioMenor());

        return listaMountrosOrdenada;
    };

}
