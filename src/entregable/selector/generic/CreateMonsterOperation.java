package entregable.selector.generic;

import game.components.Monster;

public interface CreateMonsterOperation {
  Monster operate(String name);
}
