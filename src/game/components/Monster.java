package game.components;

import game.attacks.Attack;
import game.engine.Animation;
import game.engine.SpriteSheet;
import game.types.Type;

import java.util.List;

public abstract class Monster {

    protected Integer maxLife;
    protected Integer life;
    protected Attack activeSkill;
    private Player player;
    protected String monsterName;
    protected List<Type> types;
    protected SpriteSheet spriteSheet;
    protected Animation animation;

    protected Monster(String name, Integer maxLife, List<Type> types, SpriteSheet spriteSheet) {
        this.monsterName = name;
        this.maxLife = maxLife;
        this.life = maxLife;
        this.types = types;
        this.spriteSheet = spriteSheet;
        this.animation = spriteSheet.getIdleAnimation();
    }

    public abstract void attack(Monster enemy);

    public void onDamageReceive(Integer damage, Monster enemy) {
        this.life = this.life - damage;
        if (this.life <= 0) {
            this.life = 0;
            animation = spriteSheet.getDeathAnimation();
        } else {
            animation = spriteSheet.getDamageTakenAnimation();
        }
        System.out.println(this + " fue herido, queda con " + this.life + " puntos de vida");
    }

    public void move(PathBox oldPathBox, PathBox newPathBox) {
        animation = spriteSheet.getWalkAnimation();
        oldPathBox.setMonster(null);
        newPathBox.setMonster(this);
    }

    public Integer getLife() {
        return life;
    }

    public Integer getMaxLife() {
        return maxLife;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Type> getTypes() {
        return types;
    }

    public boolean isType(Type type) {
        return types.contains(type);
    }

    @Override
    public String toString() {
        return monsterName;
    }

}
