package entregable.monstruos.evil;

import java.util.Arrays;

import game.attacks.Slice;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

/**
 * Esqueleto.
 * 
 * Monstruo de tipo FRAGILE, DEMON y SWORD.
 * 
 * Ataca con cortes.
 */
public class Skeleton extends Monster {

    public Skeleton(String name) {
        super(name, 200, Arrays.asList(Type.FRAGILE, Type.DEMON, Type.SWORD), new SpriteSheet("skeleton_0"));
        activeSkill = new Slice();

    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }

}
