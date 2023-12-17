package entregable.monstruos.good;

import java.util.Arrays;

import entregable.ataques.MultiSlice;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

public class Pikeman extends Monster {

    private final int pike_damage = 80;

    public Pikeman(String name) {
        super(name, 400, Arrays.asList(Type.FIGHTER, Type.SWORD, Type.PROTECTED), new SpriteSheet("pikeman_1"));
        activeSkill = new MultiSlice(20, 3, 8);
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }

    @Override
    public void onDamageReceive(Integer damage, Monster enemy) {
        /* Recibe el daño que le corresponde, pero además hace daño al oponente */
        super.onDamageReceive(damage, enemy);
        if (this.getLife() > 0)
            enemy.onDamageReceive(pike_damage, enemy);
    }
}
