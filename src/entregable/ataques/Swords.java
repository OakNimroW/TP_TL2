package entregable.ataques;

import game.attacks.Attack;

import game.components.Monster;
import game.random.RandomGenerator;

public class Swords implements Attack{

    private int basicDamage;
    private int minAttacks;
    private int maxAttacks;


    public Swords () {
        this.basicDamage = 100;
        this.minAttacks = 3;
        this.maxAttacks = 8;
    }

    public Swords (int basicDamage, int minAttacks, int maxAttacks) {
        this.basicDamage = basicDamage;
        this.minAttacks = minAttacks;
        this.maxAttacks = maxAttacks;
    }

    @Override
    public int damage(Monster monster) {
        // Swords realiza un ataque de poco daño pero multiples veces
        // Daño_de_golpe * Cantidad_de_golpes

        // Num random entre 3 y 8
        int cant_attacks = (int) Math.round( Math.random() * (maxAttacks - minAttacks) + minAttacks );

        return this.basicDamage * cant_attacks;
    }

}
