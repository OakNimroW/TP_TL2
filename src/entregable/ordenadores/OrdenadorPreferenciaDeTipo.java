package entregable.ordenadores;

import java.util.ArrayList;
import java.util.List;

import game.components.Monster;
import game.types.Type;

/**
 * Esta clase implementa la interfaz Ordenador y representa un ordenador de
 * monstruos
 * basado en preferencia de tipos. Ordena una lista de monstruos colocando
 * primero
 * aquellos que contienen tipos preferidos y luego los demás.
 */
public class OrdenadorPreferenciaDeTipo implements Ordenador {

    private List<Type> tiposPreferidos = null;

    /**
     * Constructor de la clase OrdenadorPreferenciaDeTipo.
     * 
     * @param tiposPreferidos La lista de tipos preferidos para ordenar los
     *                        monstruos.
     */
    public OrdenadorPreferenciaDeTipo(List<Type> tiposPreferidos) {
        this.tiposPreferidos = tiposPreferidos;
    }

    /**
     * Establece la lista de tipos preferidos para ordenar los monstruos.
     * 
     * @param tiposPreferidos La lista de tipos preferidos.
     */
    public void setTiposPreferidos(List<Type> tiposPreferidos) {
        this.tiposPreferidos = tiposPreferidos;
    }

    /**
     * Obtiene la lista de tipos preferidos para ordenar los monstruos.
     * 
     * @return La lista de tipos preferidos.
     */
    public List<Type> getTiposPreferidos() {
        return this.tiposPreferidos;
    }

    /**
     * Ordena una lista de monstruos basado en la preferencia de tipos.
     * 
     * @param listMonsters La lista de monstruos a ordenar.
     * @return La lista de monstruos ordenada.
     */
    public List<Monster> ordenar(List<Monster> listMonsters) {

        List<Monster> listaMonstruosCopia = new ArrayList<Monster>();
        List<Monster> listaMonstruosOrdenada = new ArrayList<Monster>();

        // Copia de lista para no modificar la original
        for (Monster monster : listMonsters) {
            listaMonstruosCopia.add(monster);
        }

        // Recorrer todos los monstruos que se tienen
        for (Monster monster : listaMonstruosCopia) {
            // Chequear si el monstruo contiene un tipo preferido
            if (contieneTipo(monster)) {
                // En caso de ser preferido agregarlo a la lista ordenada
                listaMonstruosOrdenada.add(monster);
            }
        }

        // Eliminar de la copia los monstruos ya tratados
        for (Monster monster : listaMonstruosOrdenada) {
            listaMonstruosCopia.remove(monster);
        }

        // Agregar monstruos restantes (no preferidos)
        for (Monster monster : listaMonstruosCopia) {
            listaMonstruosOrdenada.add(monster);
        }

        return listaMonstruosOrdenada;
    };

    /**
     * Verifica si un monstruo contiene al menos un tipo preferido.
     * 
     * @param monstruo El monstruo a verificar.
     * @return true si el monstruo contiene un tipo preferido, false de lo
     *         contrario.
     */
    private boolean contieneTipo(Monster monstruo) {
        for (Type tipo : monstruo.getTypes()) {
            if (this.tiposPreferidos.contains(tipo)) {
                return true;
            }
        }
        return false;
    }

}
