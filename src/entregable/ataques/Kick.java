package entregable.ataques;

import game.components.Monster;
import game.types.Type;

public class Kick implements Hit {

    private final int standardDamage = 150;

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
