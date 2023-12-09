package entregable.monstruos;

import game.components.Monster;
import game.types.Type;

import java.util.Arrays;

import entregable.ataques.Swords;

public class SwordsMan extends Monster{
    

    public SwordsMan(String name) {
        this.life = 300;
        this.activeSkill = new Swords();
        this.monsterName = name;
        this.types = Arrays.asList(Type.SWORD);
    }

    public SwordsMan(String name, int basicDamage, int minAttacks, int maxAttacks) {
        this.life = 100;
        this.activeSkill = new Swords(basicDamage, minAttacks, maxAttacks);
        this.monsterName = name;
        this.types = Arrays.asList(Type.SWORD);
    }

    @Override
    public void attack(Monster enemy) {
        int damage = this.activeSkill.damage(enemy);
        System.out.println("--     ["+ this +"] ataca a [" + enemy + "] haciendole " + damage + " de daño");
        enemy.onDamageReceive(damage, this);
    }


}
