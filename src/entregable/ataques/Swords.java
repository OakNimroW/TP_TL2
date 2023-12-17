package entregable.ataques;

import game.attacks.Attack;

import game.components.Monster;

public class Swords implements Attack {

    private int basicDamage;
    private int minAttacks;
    private int maxAttacks;

    public Swords() {
        this(100, 5, 12);
    }

    public Swords(int basicDamage, int minAttacks, int maxAttacks) {
        this.basicDamage = basicDamage;
        this.minAttacks = minAttacks;
        this.maxAttacks = maxAttacks;
    }

    @Override
    public int damage(Monster monster) {
        // Swords realiza un ataque de poco daño pero multiples veces
        // Daño_de_golpe * Cantidad_de_golpes

        int cant_attacks = (int) Math.round(Math.random() * (maxAttacks - minAttacks) + minAttacks);

        return this.basicDamage * cant_attacks;
    }

}
