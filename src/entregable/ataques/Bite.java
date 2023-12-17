package entregable.ataques;

import game.components.Monster;
import game.types.Type;

public class Bite implements Hit {

    @Override
    public int damage(Monster enemy) {
        if (enemy.isType(Type.PROTECTED)) {
            return 1;
        } else {
            return 300;
        }
    }
    
}
