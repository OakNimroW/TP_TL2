package entregable.monstruos;

import game.types.Type;
import game.components.Monster;
import game.engine.SpriteSheet;

import java.util.Arrays;

import entregable.ataques.Punch;

public class Tank extends Monster {

    // [LM] TODO Hacer que Tank se mueva ciclo por medio

    public Tank(String name) {
        this.maxLife = this.life = 1800;
        this.activeSkill = new Punch();
        this.monsterName = name;
        this.types = Arrays.asList(Type.BEAST, Type.TANK);
        this.spriteSheet = new SpriteSheet("treant_1");
        this.animation = spriteSheet.getIdleAnimation();

    }

    // TODO onDamageReceive
    // Debilidad hacia SowrdsMans
    // Fortaleza hacia Spartans (recibe la mitad de daño)

    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        // System.out.println("[+] " + this + " esta siendo atacado por " + monster);

        if (Math.random() > 0.95) {
            damage = 0;
        }

        super.onDamageReceive(damage, monster);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     [" + this + "] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(damage, this);
    }

}
