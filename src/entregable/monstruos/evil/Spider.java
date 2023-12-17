package entregable.monstruos.evil;

import java.util.Arrays;

import entregable.ataques.Bite;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

/**
 * Araña.
 * 
 * Monstruo de tipo ANIMAL y FRAGILE.
 * 
 * Ataca con mordidas.
 */
public class Spider extends Monster {

    public Spider(String name) {
        super(name, 150, Arrays.asList(Type.ANIMAL, Type.FRAGILE), new SpriteSheet("spider_1"));
        activeSkill = new Bite();
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
    
}
