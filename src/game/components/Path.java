package game.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Path {
    private List<PathBox> pathBoxes = new ArrayList<>();

    public List<PathBox> getPathBoxes() {
        return pathBoxes;
    }

    public void setPathBoxes(List<PathBox> pathBoxes) {
        this.pathBoxes = pathBoxes;
    }

    public boolean hasAnyMonster() {
        return pathBoxes.stream().anyMatch(pathBox -> pathBox.getMonster() != null);
    }

    public boolean haveMonster(Long playerId) {
        return pathBoxes.stream().anyMatch(
                pathBox -> pathBox.getMonster() != null && pathBox.getMonster().getPlayer().getId().equals(playerId));
    }

    // Arreglamos un error:
    // Cuando se realiza un ataque, ambos monstruos se atacan entre si.
    // Originalmente, solo se comprobaba si el monstruo atacado por el
    // monstruo del jugador del turno actual tenía vida <= 0, pero no
    // se comprobaba si el monstruo del jugador del turno moría.
    public void nextRound(Long playerId, Castle castle) {
        Optional<PathBox> occupiedPathBox = pathBoxes.stream().filter(
                pathBox -> pathBox.getMonster() != null && pathBox.getMonster().getPlayer().getId().equals(playerId))
                .findFirst();
        if (occupiedPathBox.isPresent()) {
            if (playerId.equals(1L)) {
                if (occupiedPathBox.get().getNorthBox() == null) {
                    castle.setLife(castle.getLife() - 1);
                    occupiedPathBox.get().setMonster(null);
                } else {
                    if (occupiedPathBox.get().getNorthBox().getMonster() == null) {
                        occupiedPathBox.get().getMonster().move(occupiedPathBox.get(),
                                occupiedPathBox.get().getNorthBox());
                    } else {
                        System.out.println(
                                "Casilla " + occupiedPathBox.get().getNorthBox().getName() + " Esta ocupada!!!");
                        System.out.println("Monstruo " + occupiedPathBox.get().getMonster() + " Ataca a "
                                + occupiedPathBox.get().getNorthBox().getMonster());
                        occupiedPathBox.get().getMonster().attack(occupiedPathBox.get().getNorthBox().getMonster());
                        occupiedPathBox.get().getNorthBox().getMonster().attack(occupiedPathBox.get().getMonster());
                        if (occupiedPathBox.get().getNorthBox().getMonster().getLife() <= 0) {
                            occupiedPathBox.get().getNorthBox().setMonster(null);
                        }
                        if (occupiedPathBox.get().getMonster().getLife() <= 0) {
                            occupiedPathBox.get().setMonster(null);
                        }
                    }
                }
            } else {
                if (occupiedPathBox.get().getSouthBox() == null) {
                    castle.setLife(castle.getLife() - 1);
                    occupiedPathBox.get().setMonster(null);
                } else {
                    if (occupiedPathBox.get().getSouthBox().getMonster() == null) {
                        occupiedPathBox.get().getMonster().move(occupiedPathBox.get(),
                                occupiedPathBox.get().getSouthBox());
                    } else {
                        System.out.println(
                                "Casilla " + occupiedPathBox.get().getSouthBox().getName() + " Esta ocupada!!!");
                        System.out.println("Monstruo " + occupiedPathBox.get().getMonster() + " Ataca a "
                                + occupiedPathBox.get().getSouthBox().getMonster());
                        occupiedPathBox.get().getMonster().attack(occupiedPathBox.get().getSouthBox().getMonster());
                        occupiedPathBox.get().getSouthBox().getMonster().attack(occupiedPathBox.get().getMonster());
                        if (occupiedPathBox.get().getSouthBox().getMonster().getLife() <= 0) {
                            occupiedPathBox.get().getSouthBox().setMonster(null);
                        }
                        if (occupiedPathBox.get().getMonster().getLife() <= 0) {
                            occupiedPathBox.get().setMonster(null);
                        }
                    }
                }
            }
        }
    }

    public void tick() {
        this.pathBoxes.forEach(PathBox::tick);
    }

    public void releaseMonster(Long playerId, Monster monster) {
        if (playerId.equals(1L)) {
            if (pathBoxes.get(2).getMonster() == null) {
                pathBoxes.get(2).setMonster(monster);
            }
        } else {
            if (pathBoxes.get(0).getMonster() == null) {
                pathBoxes.get(0).setMonster(monster);
            }
        }
    }
}
