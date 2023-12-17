package entregable.ataques;

import game.attacks.Demon;
import game.components.Monster;
import game.types.Type;

public class Spell implements Demon {

    @Override
    public int damage(Monster enemy) {
        if (enemy.isType(Type.DEMON) || enemy.isType(Type.MYSTIC)) {
            return 250;
        } else {
            return 3;
        }
    }

}
