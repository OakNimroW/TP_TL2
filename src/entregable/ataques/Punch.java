package entregable.ataques;

import game.components.Monster;
import game.random.RandomGenerator;

/**
 * Ataque de golpe de puño.
 * 
 * Realiza daño entre 50 y 250.
 */
public class Punch implements Hit {

    /**
     * Calcula el daño infligido al enemigo al realizar el ataque.
     *
     * @param enemy el monstruo enemigo al que se le realiza el ataque
     * @return el daño infligido al enemigo
     */
    @Override
    public int damage(Monster monster) {
        return RandomGenerator.getInstance().calculateDamage(50, 250);
    }

}
