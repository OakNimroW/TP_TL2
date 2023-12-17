package entregable.ataques;

import game.components.Monster;
import game.types.Type;

/**
 * Ataque de patada.
 * Si el monstruo es de tipo "PROTECTED" (con armadura) y de tipo "SWORD" (con espada), el daño es 1.
 * Si el monstruo es de tipo "FRAGILE" (frágil), el daño es el doble de estándar.
 * De lo contrario, el daño es el estándar.
 */
public class Kick implements Hit {

    private final int standardDamage;

    public Kick(int standardDamage) {
        this.standardDamage = standardDamage;
    }

    public Kick() {
        this.standardDamage = 150;
    }

    /**
     * Calcula el daño infligido al enemigo al realizar el ataque.
     *
     * @param enemy el monstruo enemigo al que se le realiza el ataque
     * @return el daño infligido al enemigo
     */
    @Override
    public int damage(Monster enemy) {
        if (enemy.isType(Type.PROTECTED) && enemy.isType(Type.SWORD)) {
            return 1;
        } else if (enemy.isType(Type.FRAGILE)) {
            return standardDamage * 2;
        } else {
            return standardDamage;
        }
    }
}