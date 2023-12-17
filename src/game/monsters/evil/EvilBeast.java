package game.monsters.evil;

import game.attacks.Curse;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

import java.util.Arrays;

public class EvilBeast extends Monster {

    public EvilBeast(String name) {
        super(name, 500, Arrays.asList(Type.BEAST, Type.DEMON, Type.FIRE), new SpriteSheet("devil_1"));
        this.activeSkill = new Curse();
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
}
