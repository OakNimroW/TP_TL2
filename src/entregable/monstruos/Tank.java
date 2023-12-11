package entregable.monstruos;

import game.types.Type;
import game.components.Monster;

import java.util.Arrays;

import entregable.ataques.Punch;

public class Tank extends Monster{

    // [LM] TODO Hacer que Tank se mueva ciclo por medio

    public Tank(String name) {
        this.life = 1800;
        this.activeSkill = new Punch();
        this.monsterName = name;
        this.types = Arrays.asList(Type.BEAST, Type.TANK);

    }

    // TODO onDamageReceive
    // Debilidad hacia SowrdsMans
    // Fortaleza hacia Spartans (recibe la mitad de daño)

    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        //System.out.println("[+] " + this + " esta siendo atacado por " + monster);

        if (Math.random() > 0.95) {
            damage = 0;
        }

        this.life = this.life - damage;
        if(this.life < 0) {
            this.life = 0;
        }

        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }


    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }

}
