package entregable.ataques;

import game.components.Monster;
import game.random.RandomGenerator;

public class Punch implements Hit {
    
    @Override
    public int damage(Monster monster) {
        return RandomGenerator.getInstance().calculateDamage(50, 250);
    }

}
