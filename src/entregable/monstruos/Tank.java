package entregable.monstruos;

import game.components.Monster;
import game.types.Type;

import java.util.Arrays;

import entregable.ataques.Punch;

public class Tank extends Monster{

    // TODO Hacer que Tank se mueva ciclo por medio

    public Tank(String name) {
        this.life = 750;
        this.activeSkill = new Punch();
        this.monsterName = name;
        this.types = Arrays.asList(Type.BEAST);

    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }

}
