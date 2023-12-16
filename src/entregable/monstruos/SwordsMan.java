package entregable.monstruos;

import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

import java.util.Arrays;

import entregable.ataques.Swords;

public class SwordsMan extends Monster {

    public SwordsMan(String name) {
        this.maxLife = this.life = 300;
        this.activeSkill = new Swords();
        this.monsterName = name;
        this.types = Arrays.asList(Type.SWORD, Type.ANTITANK, Type.FIGHTER);
        this.spriteSheet = new SpriteSheet("swordsman_1");
        this.animation = spriteSheet.getIdleAnimation();
    }

    public SwordsMan(String name, int basicDamage, int minAttacks, int maxAttacks) {
        this(name);
        this.activeSkill = new Swords(basicDamage, minAttacks, maxAttacks);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(damage, this);
    }

}
