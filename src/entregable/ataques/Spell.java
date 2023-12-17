package entregable.ataques;

import game.attacks.Demon;
import game.components.Monster;
import game.types.Type;

/**
 * Ataque de hechizo.
 * Si el monstruo es de tipo DEMON o MYSTIC, el daño es 250.
 * De lo contrario, el daño es 3.
 */
public class Spell implements Demon {

    /**
     * Calcula el daño infligido al enemigo al realizar el ataque.
     *
     * @param enemy el monstruo enemigo al que se le realiza el ataque
     * 
     * @return el daño infligido al enemigo
     */
    @Override
    public int damage(Monster enemy) {
        if (enemy.isType(Type.DEMON) || enemy.isType(Type.MYSTIC)) {
            return 250;
        } else {
            return 3;
        }
    }

}
