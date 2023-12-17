package entregable.ataques;

import game.attacks.Attack;

import game.components.Monster;

public class MultiSlice implements Attack {

    private int basicDamage;
    private int minAttacks;
    private int maxAttacks;

    public MultiSlice() {
        this(70, 3, 8);
    }

    public MultiSlice(int basicDamage, int minAttacks, int maxAttacks) {
        this.basicDamage = basicDamage;
        this.minAttacks = minAttacks;
        this.maxAttacks = maxAttacks;
    }

    @Override
    public int damage(Monster monster) {
        // MultiSlice realiza un ataque de poco daño pero multiples veces

        // Num random entre minAttacks y maxAttacks
        int cant_attacks = (int) Math.round(Math.random() * (maxAttacks - minAttacks) + minAttacks);

        System.out.println("MultiSlice: El monstruo '" + monster.toString() + "' recibe " + cant_attacks + " ataques de daño "
                + this.basicDamage);

        return this.basicDamage * cant_attacks;
    }

}
