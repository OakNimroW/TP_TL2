package entregable.ordenadores;

import java.util.ArrayList;
import java.util.List;

import game.components.Monster;
import game.types.Type;

public class OrdenadorPreferenciaDeTipo implements Ordenador{
    
    private List<Type> tiposPreferidos = null;

    public OrdenadorPreferenciaDeTipo (List<Type> tiposPreferidos) {
        this.tiposPreferidos = tiposPreferidos;
    }

    public void setTiposPreferidos (List<Type> tiposPreferidos) {
        this.tiposPreferidos = tiposPreferidos;
    }

    public List<Type> getTiposPreferidos () {
        return this.tiposPreferidos;
    }

    public List<Monster> ordenar(List<Monster> listMonsters) {
        
        List<Monster> listaMountrosCopia = new ArrayList<Monster>();
        List<Monster> listaMountrosOrdenada = new ArrayList<Monster>();

        // Copia de lista para no modificar la original
        for (Monster monster : listMonsters) {
            listaMountrosCopia.add(monster);
        }
        //System.out.println("Lista Copia: " + listaMountrosCopia);

        // Recorrer todos los mounstros que se tienen
        for (Monster monster : listaMountrosCopia) {
            // Chequear si el mounstro contiene un tipo preferido
            if (contieneTipo(monster)) {
                // En caso de ser preferido agregarlo a la lista ordenada 
                listaMountrosOrdenada.add(monster);
                //System.out.println("Monstruo " + monster + " agregado: " + listaMountrosOrdenada);
            }
        }
        
        // Eliminar de la copia los mounstros ya tratados
        for (Monster monster : listaMountrosOrdenada) {
            listaMountrosCopia.remove(monster);
        }

        // Agregar Mountros restantes (no preferidos)
        for (Monster monster : listaMountrosCopia) {
            listaMountrosOrdenada.add(monster);
        }

        // System.out.println("Lista Ordenada: " + listaMountrosOrdenada);

        return listaMountrosOrdenada;
    };

    private boolean contieneTipo(Monster mounstro) {
        for (Type tipo : mounstro.getTypes()) {
            if (this.tiposPreferidos.contains(tipo)) {
                return true;
            }
        }
        return false;
    }

}
