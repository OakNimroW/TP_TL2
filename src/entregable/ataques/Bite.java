package entregable.ataques;

import game.components.Monster;
import game.types.Type;

/**
 * Ataque de mordida.
 * 
 * Si el monstruo es de tipo "PROTECTED" (con armadura), el daño es 1.
 * De lo contrario, el daño es 300.
 */
public class Bite implements Hit {

    /**
     * Calcula el daño infligido al monstruo dado.
     *
     * @param enemy el monstruo que está siendo atacado
     * @return el daño infligido por el ataque
     */
    @Override
    public int damage(Monster enemy) {
        if (enemy.isType(Type.PROTECTED)) {
            return 1;
        } else {
            return 300;
        }
    }

}
