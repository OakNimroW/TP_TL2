package entregable.selector.evil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import game.components.Monster;
import game.monsters.evil.EvilBeast;
import entregable.monstruos.evil.*;


public class EvilMonsterSelector {

    // Test getEvilMonsterList(n) function
    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++) {
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

        }*/

        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println((int) (20 + 20 * r.nextGaussian() * 0.1));
        }
    }
    
    public static List<Monster> getEvilMonsterList (int n) {

        List<Monster> listMonsters = new ArrayList<>();

        Random ran = new Random();
        
        double base = n * 1.45;      
        double aditional = n * ran.nextGaussian() * 0.1;
        int cantMonsters = (int) (base + aditional);

        for (int i = 0; i < cantMonsters; i++) {
            Monster monster = null;
            int dice = ran.nextInt(100);
            if (dice < 15) {
                // Select Strong monster
                if (ran.nextInt(2) == 1) {
                    monster = new DeathKnight("DeathKing " + i);
                } else {
                    monster = new EvilBeast("EvilBeast " + i);
                }
            } else if (dice < 55) {
                // Select Medium monster
                // Every 1 of 3 Medium monsters are Vampire
                if (ran.nextInt(3) == 2) {
                    monster = new Vampire("Vampire " + i);
                } else {
                    monster = new Skeleton("Skeleton " + i);
                }
            } else {
                // Select Weak monster
                if (ran.nextInt(2) == 1) {
                    monster = new Spider("Spider " + i);
                } else {
                    monster = new Ghost("Ghost " + i);
                }
            }
            listMonsters.add(monster);            
        }

        return listMonsters;
    }

}
