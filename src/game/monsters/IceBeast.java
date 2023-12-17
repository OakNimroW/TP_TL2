package game.monsters;

import game.attacks.ColdBreath;
import game.attacks.IceSpike;
import game.components.Monster;
import game.components.PathBox;
import game.engine.SpriteSheet;
import game.attacks.Cold;
import game.types.Type;

import java.util.Arrays;
import java.util.List;

public class IceBeast extends Monster {

    private List<Cold> skills = Arrays.asList(new ColdBreath(), new IceSpike());

    public IceBeast(String name) {
        this.maxLife = this.life = 200;
        this.monsterName = name;
        this.activeSkill = skills.get(0);
        this.types = Arrays.asList(Type.COLD, Type.BEAST);
        this.spriteSheet = new SpriteSheet("ice_elemental_0");
        this.animation = spriteSheet.getIdleAnimation();
    }

    @Override
    public void attack(Monster monster) {
        animation = spriteSheet.getAttackAnimation();
        monster.onDamageReceive(this.activeSkill.damage(monster), this);
    }

    @Override
    public void move(PathBox oldPathBox, PathBox newPathBox) {
        super.move(oldPathBox, newPathBox);
        if (activeSkill instanceof ColdBreath) {
            this.activeSkill = skills.get(1);
        } else {
            this.activeSkill = skills.get(0);
        }
    }
}
