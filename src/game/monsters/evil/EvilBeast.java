package game.monsters.evil;

import game.attacks.Attack;
import game.attacks.Curse;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

import java.util.Arrays;

import entregable.ataques.FlameThrower;

public class EvilBeast extends Monster {

    private Attack curseSkill = new Curse();
    private Attack flameThrowerSkill = new FlameThrower();

    public EvilBeast(String name) {
        super(name, 500, Arrays.asList(Type.BEAST, Type.DEMON, Type.FIRE), new SpriteSheet("devil_1"));
        activeSkill = curseSkill;
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        if (enemy.isType(Type.ANIMAL)) {
            activeSkill = flameThrowerSkill;
        } else {
            activeSkill = curseSkill;
        }
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
}
