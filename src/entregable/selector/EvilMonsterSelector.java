package entregable.selector;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import entregable.monstruos.evil.*;
import entregable.selector.generic.MonsterSelector;
import entregable.selector.generic.SelectMonsterButton;
import game.components.Player;
import game.monsters.evil.*;

/**
 * Selector de monstruos del equipo malvado.
 */
public class EvilMonsterSelector {
  public EvilMonsterSelector(JFrame owner, Player player) {
    List<SelectMonsterButton> monsters = Arrays.<SelectMonsterButton>asList(
        new SelectMonsterButton("Bestia maligna", "devil_1", name -> new EvilBeast(name)),
        new SelectMonsterButton("Caballero de la muerte", "death_knight_1", name -> new DeathKnight(name)),
        new SelectMonsterButton("Fantasma", "ghost_0", name -> new Ghost(name)),
        new SelectMonsterButton("Esqueleto", "skeleton_0", name -> new Skeleton(name)),
        new SelectMonsterButton("Araña", "spider_1", name -> new Spider(name)),
        new SelectMonsterButton("Vampiro", "vampire_1", name -> new Vampire(name)));

    new MonsterSelector(owner, player, monsters);
  }
}
