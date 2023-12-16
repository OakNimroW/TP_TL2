package entregable.monstruos.good;

import java.util.Arrays;

import entregable.ataques.Kick;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

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
            damage = 2;
        }
        super.onDamageReceive(damage, monster);
    }

}
