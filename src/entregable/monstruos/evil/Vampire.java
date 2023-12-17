package entregable.monstruos.evil;

import java.util.List;

import entregable.ataques.Bite;
import entregable.ataques.Spell;
import game.attacks.Attack;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

public class Vampire extends Monster {

    private Attack spellAttack = new Spell();
    private Attack biteAttack = new Bite();

    public Vampire(String name) {
        super(name, 300, List.of(Type.ANIMAL, Type.DEMON, Type.MYSTIC), new SpriteSheet("vampire_1"));
        activeSkill = biteAttack;
    }

    @Override
    public void attack(Monster enemy) {
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
        if (activeSkill == biteAttack) {
            animation = spriteSheet.getAlternativeAnimation();
            activeSkill = spellAttack;
        } else {
            animation = spriteSheet.getAttackAnimation();
            activeSkill = biteAttack;
        }
    }
    
}
