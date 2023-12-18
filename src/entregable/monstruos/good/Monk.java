package entregable.monstruos.good;

import java.util.Arrays;

import entregable.ataques.Punch;
import entregable.ataques.Spell;
import game.attacks.Attack;
import game.components.Monster;
import game.components.PathBox;
import game.engine.SpriteSheet;
import game.random.RandomGenerator;
import game.types.Type;

/**
 * Monje.
 * 
 * Monstruo de tipo FIGHTER y MYSTIC.
 * 
 * Ataca con puñetasos si el enemigo no es de tipo DEMON o MYSTIC.
 * Si el enemigo es de tipo DEMON o MYSTIC, tiene un 65% de chance de atacar con
 * un hechizo y 35% de chance de atacar con un puñetazo.
 * Se mueve una vez cada dos llamadas a move().
 */
public class Monk extends Monster {

    private Attack spellAttack = new Spell();
    private Attack punchAttack = new Punch();

    private final int turnsBetweenMoves = 1;
    private int turnsSiceLastMove = 0;

    public Monk(String name) {
        super(name, 500, Arrays.asList(Type.FIGHTER, Type.MYSTIC), new SpriteSheet("monk_0"));
        activeSkill = punchAttack;
    }

    @Override
    public void attack(Monster enemy) {
        /*
         * Si el enemigo es Místico o Demonio, hay 65% chance de que el Monje ataque con
         * un hechizo
         */
        activeSkill = punchAttack;
        if (enemy.isType(Type.MYSTIC) || enemy.isType(Type.DEMON)) {
            if (RandomGenerator.getInstance().randomBernoulli(0.65f)) {
                activeSkill = spellAttack;
            }
        }
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        /* Moves every two turns */
        if (turnsBetweenMoves == turnsSiceLastMove) {
            turnsSiceLastMove = 0;
            super.move(oldPathBox, newPathBox);
        } else {
            animation = spriteSheet.getIdleAnimation();
            turnsSiceLastMove++;
            return;
        }
    }

}
