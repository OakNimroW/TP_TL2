package entregable.monstruos.good;

import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

import java.util.Arrays;

import entregable.ataques.MultiSlice;

public class SwordsMan extends Monster {

    public SwordsMan(String name) {
        super(name, 300, Arrays.asList(Type.SWORD, Type.FIGHTER), new SpriteSheet("swordsman_1"));
        this.activeSkill = new MultiSlice();
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
}
