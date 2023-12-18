package entregable.selector.evil;

import java.util.ArrayList;
import java.util.List;
import game.components.Monster;
import game.monsters.evil.EvilBeast;
import entregable.monstruos.evil.*;

public class EvilMonsterSelector {

    /* Test getEvilMonsterList(n) function
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            List<Monster> list = getEvilMonsterList(10);
            System.out.println(list);
     
            int d = 0,m = 0,f = 0;
            for (int j = 0; j < list.size(); j++) {
                Monster monster = list.get(j);
                if (monster instanceof EvilBeast || monster instanceof DeathKnight) {
                    f++;
                } else if (monster instanceof Vampire || monster instanceof Skeleton) {
                    m++;
                } else {
                    d++;
                }
            }
            System.out.println("Cant: \n\tFuerte: " + f + "\n\tMedio: " + m + "\n\tDebil: " + d + "\n");

        }
    }
    */
    
    public static List<Monster> getEvilMonsterList (int n) {

        List<Monster> listMonsters = new ArrayList<>();

        // Cantidad de monstruos entre 1.
        // double percentage = 0.25;
        // double minCant = n * 1.5 + percentage * n;
        // double maxCant = n * 2;
        // int cantMonsters = (int) (minCant + Math.random() * (maxCant - minCant));

        double base = n * 1.2;        
        double aditional = n * 0.5;
        int cantMonsters = (int) (base + Math.random() * aditional);

        for (int i = 0; i < cantMonsters; i++) {
            Monster monster = null;
            int dice = aleaJactaEst(100);
            if (dice < 20) {
                // Select Strong monster
                // 20 / 100
                if (aleaJactaEst(2) == 1) {
                    monster = new DeathKnight("DeathKing " + i);
                } else {
                    monster = new EvilBeast("EvilBeast " + i);
                }
            } else if (dice < 50) {
                // Select Medium monster
                // 30 / 100
                // Every 1 of 3 Medium monsters are Vampire
                if (aleaJactaEst(3) == 2) {
                    monster = new Vampire("Vampire " + i);
                } else {
                    monster = new Skeleton("Skeleton " + i);
                }
            } else {
                // Select Weak monster
                // 50 / 100
                if (aleaJactaEst(2) == 1) {
                    monster = new Spider("Spider " + i);
                } else {
                    monster = new Ghost("Ghost " + i);
                }
            }
            listMonsters.add(monster);            
        }

        return listMonsters;
    }

    private static int aleaJactaEst(int n) {
        // alea jacta est means roll the dice
        return (int) (Math.random() * n);
    }
}
