package entregable.selector;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import entregable.monstruos.good.*;
import entregable.selector.generic.MonsterSelector;
import entregable.selector.generic.SelectMonsterButton;
import game.components.Player;
import game.monsters.good.*;

public class GoodMonsterSelector {
  public GoodMonsterSelector(JFrame owner, Player player) {
    List<SelectMonsterButton> monsters = Arrays.<SelectMonsterButton>asList(
        new SelectMonsterButton("Bestia de hielo", "ice_elemental_0", name -> new IceBeast(name)),
        new SelectMonsterButton("Ciervo", "deer_1", name -> new Deer(name)),
        new SelectMonsterButton("Monje", "monk_0", name -> new Monk(name)),
        new SelectMonsterButton("Piquero", "pikeman_1", name -> new Pikeman(name)),
        new SelectMonsterButton("Espadachín", "swordsman_1", name -> new SwordsMan(name)),
        new SelectMonsterButton("Jinete de lobo", "wolf_rider_0", name -> new WolfRider(name)));

    new MonsterSelector(owner, player, monsters);
  }
}
