package entregable.monstruos;

import game.components.Monster;
import game.monsters.Spartan;
import game.types.Type;

import java.util.Arrays;

import entregable.ataques.Punch;

public class Tank extends Monster{

    // TODO Hacer que Tank se mueva ciclo por medio

    public Tank(String name) {
        this.life = 1800;
        this.activeSkill = new Punch();
        this.monsterName = name;
        this.types = Arrays.asList(Type.BEAST, Type.TANK, Type.FIGHTER);

    }

    // TODO onDamageReceive
    // Debilidad hacia SowrdsMans
    // Fortaleza hacia Spartans (recibe la mitad de daño)

    @Override
    public void onDamageReceive(Integer damage, Monster monster) {
        //System.out.println("[+] " + this + " esta siendo atacado por " + monster);
        
        int damageReceived = damage;
        
        if (monster.getTypes().contains(Type.ANTITANK)) {
            damageReceived = damageReceived * 5;    
        } else if (monster.getTypes().contains(Type.SWORD)) {
            damageReceived = damageReceived / 3;
        }

        //System.out.println("Damage: " + damage);
        //System.out.println("DamageReceived: " + damageReceived);
        //System.out.println("Life Bef: " + this.life);

        this.life = this.life - damageReceived;
        //System.out.println("Life Aft: " + this.life);
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
