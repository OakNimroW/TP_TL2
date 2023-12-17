package entregable.monstruos.evil;

import java.util.List;

import entregable.ataques.Spell;
import game.components.Monster;
import game.engine.SpriteSheet;
import game.types.Type;

public class Ghost extends Monster {

    public Ghost(String name) {
        super(name, 100, List.of(Type.DEMON, Type.MYSTIC), new SpriteSheet("ghost_0"));
        activeSkill = new Spell();
    }

    @Override
    public void attack(Monster enemy) {
        animation = spriteSheet.getAttackAnimation();
        enemy.onDamageReceive(this.activeSkill.damage(enemy), this);
    }
    
}
