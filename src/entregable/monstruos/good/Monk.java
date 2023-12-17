package entregable.monstruos.good;

import java.util.Arrays;

import entregable.ataques.Punch;
import entregable.ataques.Spell;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.engine.SpriteSheet;
import game.types.Type;
import java.util.Random;

public class Monk extends Monster {

    private Attack spellAttack = new Spell();
    private Attack punchAttack = new Punch();

    private final int turnsPerMove = 2;
    private int turnsSiceLastMove = turnsPerMove;

    private Random random = new Random();

    public Monk(String name) {
        super(name, 600, Arrays.asList(Type.FIGHTER, Type.MYSTIC), new SpriteSheet("monk_0"));
        activeSkill = punchAttack;
    }

    @Override
    public void attack(Monster enemy) {
        /* Si el enemigo es Místico o Demonio, hay 50% chance de que el Monje ataque con un hechizo */
        if (enemy.isType(Type.MYSTIC) || enemy.isType(Type.DEMON)) {
            int randomNumber = random.nextInt(2); // Numero aleatorio entre 0 y 1
            if (randomNumber == 0) {
                activeSkill = spellAttack;
            } else {
                activeSkill = punchAttack;
            }
        } else {
            activeSkill = punchAttack;
        }
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        /* Moves every two turns */
        if (turnsPerMove == turnsSiceLastMove) {
            turnsSiceLastMove = 0;
            super.move(oldPathBox, newPathBox);
        } else {
            turnsSiceLastMove++;
            return;
        }
    }

}