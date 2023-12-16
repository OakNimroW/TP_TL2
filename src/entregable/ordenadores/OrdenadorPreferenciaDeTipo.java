package entregable.ordenadores;

import java.util.ArrayList;
import java.util.List;

import game.components.Monster;
import game.types.Type;

public class OrdenadorPreferenciaDeTipo implements Ordenador {

    private List<Type> tiposPreferidos = null;

    public OrdenadorPreferenciaDeTipo(List<Type> tiposPreferidos) {
        this.tiposPreferidos = tiposPreferidos;
    }

    public void setTiposPreferidos(List<Type> tiposPreferidos) {
        this.tiposPreferidos = tiposPreferidos;
    }

    public List<Type> getTiposPreferidos() {
        return this.tiposPreferidos;
    }

    public List<Monster> ordenar(List<Monster> listMonsters) {

        List<Monster> listaMonstruosCopia = new ArrayList<Monster>();
        List<Monster> listaMonstruosOrdenada = new ArrayList<Monster>();

        // Copia de lista para no modificar la original
        for (Monster monster : listMonsters) {
            listaMonstruosCopia.add(monster);
        }
        // System.out.println("Lista Copia: " + listaMountrosCopia);

        // Recorrer todos los monstruos que se tienen
        for (Monster monster : listaMonstruosCopia) {
            // Chequear si el monstruo contiene un tipo preferido
            if (contieneTipo(monster)) {
                // En caso de ser preferido agregarlo a la lista ordenada
                listaMonstruosOrdenada.add(monster);
                // System.out.println("Monstruo " + monster + " agregado: " +
                // listaMountrosOrdenada);
            }
        }

        // Eliminar de la copia los monstruos ya tratados
        for (Monster monster : listaMonstruosOrdenada) {
            listaMonstruosCopia.remove(monster);
        }

        // Agregar Mountros restantes (no preferidos)
        for (Monster monster : listaMonstruosCopia) {
            listaMonstruosOrdenada.add(monster);
        }

        // System.out.println("Lista Ordenada: " + listaMountrosOrdenada);

        return listaMonstruosOrdenada;
    };

    private boolean contieneTipo(Monster monstruo) {
        for (Type tipo : monstruo.getTypes()) {
            if (this.tiposPreferidos.contains(tipo)) {
                return true;
            }
        }
        return false;
    }

}
