package entregable.ataques;

import game.attacks.Fire;
import game.components.Monster;
import game.random.RandomGenerator;
import game.types.Type;

public class FlameThrower implements Fire {

    /**
     * Calcula el daño infligido por el ataque lanzallamas a un monstruo dado.
     * El daño se basa en el tipo del monstruo.
     * Si el monstruo es de tipo ANIMAL, el rango de daño es entre 120 y 200.
     * Si el monstruo es de tipo COLD, el daño es 0.
     * Para cualquier otro tipo, el rango de daño es entre 80 y 120.
     * 
     * Nótese que de ser el monstruo de tipo ICE y COLD al mismo tiempo, recibirá
     * daño completo por tipo ICE.
     *
     * @param monster el monstruo a atacar
     * @return el daño infligido por el ataque Lanzallamas
     */
    @Override
    public int damage(Monster monster) {
        if (monster.getTypes().contains(Type.ANIMAL)) {
            return RandomGenerator.getInstance().calculateDamage(120, 200);
        } else if (monster.getTypes().contains(Type.COLD)) {
            return 0;
        } else {
            return RandomGenerator.getInstance().calculateDamage(80, 120);
        }
    }

}
