package game.monsters.evil;

import game.attacks.Curse;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

import java.util.Arrays;

public class EvilBeast extends Monster {

    public EvilBeast(String name) {
        this.maxLife = this.life = 700;
        this.monsterName = name;
        this.activeSkill = new Curse();
        this.types = Arrays.asList(Type.BEAST, Type.DEMON, Type.FIRE);
        this.spriteSheet = new SpriteSheet("devil_1");
        this.animation = spriteSheet.getIdleAnimation();
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
}
