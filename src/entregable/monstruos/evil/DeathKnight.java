package entregable.monstruos.evil;

import java.util.Arrays;
import java.util.List;

import entregable.ataques.Kick;
import game.attacks.Attack;
import game.attacks.Slice;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

public class DeathKnight extends Monster {

    private List<Attack> skills = Arrays.asList(new Kick(), new Slice());

    public DeathKnight(String name) {
        super(name, 300, Arrays.asList(Type.ANIMAL, Type.DEMON, Type.PROTECTED), new SpriteSheet("death_knight_1"));
        activeSkill = skills.get(0);
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
        if (this.activeSkill == skills.get(0)) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }
}
