package entregable.monstruos.good;

import java.util.Arrays;

import entregable.ataques.Kick;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

/**
 * Ciervo.
 * 
 * Monstruo de tipo ANIMAL.
 * 
 * Ataca con patadas.
 * Si recibe daño de un monstruo de tipo SWORD, utiliza su cornamenta para
 * reducir el daño a un décimo del original.
 */
public class Deer extends Monster {

    public Deer(String name) {
        super(name, 150, Arrays.asList(Type.ANIMAL), new SpriteSheet("deer_1"));
        activeSkill = new Kick();
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }

    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        /* The deer can parry attacks from sword monsters */
        if (monster.isType(Type.SWORD)) {
            damage /= 10;
        }
        super.onDamageReceive(damage, monster);
    }

}
