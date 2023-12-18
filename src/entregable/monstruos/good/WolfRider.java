package entregable.monstruos.good;

import java.util.Arrays;

import entregable.ataques.Bite;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

public class WolfRider extends Monster {

    public WolfRider(String name) {
        super(name, 300, Arrays.asList(Type.ANIMAL, Type.MYSTIC), new SpriteSheet("wolf_rider_0"));
        activeSkill = new Bite();
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);        
    }
    
}
