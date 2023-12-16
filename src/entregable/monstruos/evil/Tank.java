package entregable.monstruos.evil;

import game.types.Type;
import game.components.Monster;
import game.components.PathBox;
import game.engine.SpriteSheet;

import java.util.Arrays;

import entregable.ataques.Punch;

public class Tank extends Monster {

    private final int turnsPerMove = 2;
    private int turnsSiceLastMove = turnsPerMove;

    public Tank(String name) {
        this.maxLife = this.life = 1800;
        this.activeSkill = new Punch();
        this.monsterName = name;
        this.types = Arrays.asList(Type.BEAST, Type.TANK);
        this.spriteSheet = new SpriteSheet("treant_1");
        this.animation = spriteSheet.getIdleAnimation();
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        if (turnsPerMove == turnsSiceLastMove) {
            turnsSiceLastMove = 0;
            super.move(oldPathBox, newPathBox);
        } else {
            turnsSiceLastMove++;
            return;
        }
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(damage, this);
    }

}
