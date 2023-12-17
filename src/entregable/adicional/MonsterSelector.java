package entregable.adicional;

import game.components.Monster;
import game.components.Player;
import game.monsters.Spartan;

import entregable.ordenadores.*;
import entregable.monstruos.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class MonsterSelector {
    
    private static MonsterSelector INSTANCE = new MonsterSelector();

    private List<Monster> monsters = new ArrayList<>();

    private static Scanner sn = new Scanner(System.in);


    private MonsterSelector(){};

    public static MonsterSelector getInstance() {
        return INSTANCE;
    }

    public List<Monster> getList () {
        return monsters;
    }

    public void clearList() {
        // if (monsters != null) {
        //     monsters.clear();
        // }
        monsters.clear();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void ordenarLista(Ordenador ordenador) {
        monsters = ordenador.ordenar(monsters);
    }

    public void setPlayer(Player player) {

        List<Monster> monsters_copy = new ArrayList<>();

        for (Monster monster : this.monsters) {
            monsters_copy.add(monster);
        }

        player.setMonsters(monsters_copy);
    }

    private void addMonstersCLI() {
        int monster_index = -31337;
        String monster_name;
            
        System.out.println("\n[!] TODO: Hacer una exepcion de si alguient mete un no numero para el indice o un no texto (? para el nombre.\n");

        while (monster_index != 0) {
            System.out.print("Select Monster\n\t1. Spartan\n\t2. Tank\n\t3. SwordsMan\n\t\n\t0. End selection.\n\n> ");
            monster_index = sn.nextInt();
            sn.nextLine(); // read '\n' character
            
            switch (monster_index) {
                case 1:
                    System.out.print("\n Spartan's name: ");
                    monster_name = sn.nextLine();
                    this.addMonster(new Spartan(monster_name));
                    break;
                case 2:
                    System.out.print("\n Tank's name: ");
                    monster_name = sn.nextLine();
                    this.addMonster(new Tank(monster_name));
                    break;
                case 3:
                    System.out.print("\n SwordsMan's name: ");
                    monster_name = sn.nextLine();
                    this.addMonster(new SwordsMan(monster_name));
                    break;
                case 0:
                    System.out.println("[*] Monster List: " + monsters);
                    break;
                default:
                    if (monster_index != -31337) {
                        System.out.println("[!] Index Not Known.");
                    }
                    break;
            }
        }
    }

    public void configurePlayerCLI(Player player) {
        System.out.println("[+] Configuracion CLI para jugador: " + player);
        
        clearList();
        
        addMonstersCLI();

        selectOrdenador();

        setPlayer(player);

        System.out.println("[+] Final config:\n\tPlayer: "  + player + "\n\tMonsterList: " + monsters + "\n");
    }

    private void selectOrdenador() {
        System.out.println("\n[!] TODO: Hacer una exepcion de si alguient mete un no numero. (todo un HDP >:c)\n");
        System.out.print("Select Order:\n\t1. FIFO\n\t2. Alphabeticall Order\n\t3. Max HP First\n\t4. Min HP First\n\t5. Type Preference\n\n> ");
        int order_index = sn.nextInt();
        sn.nextLine(); // read '\n' character
        switch (order_index) {
            case 2:
                ordenarLista(new OrdenadorAlfabeticamente());
                break;
            case 3:
                ordenarLista(new OrdenadorVidaInicioMayor());
                break;
            case 4:
                ordenarLista(new OrdenadorVidaInicioMenor());
                break;
            case 5:
                System.out.println("[-] Opcion no implementada, queda en FIFO.");
                break;
        
            default:
                break;
        }
    }

    public void selectMonstersGUI() {
        System.out.println("[!] TODO: Create an GUI where the player can select the monsters to use clicking buttons.");
        System.out.println("\tIt has to have one button per usable monster, one buton to reset the list and another to confirm.");
        System.out.println("\tIt has to have an text area where shows the desitions made.");

        System.out.println("\n\t Temporary an Spartan has ben added.\n");

        this.addMonster(new Spartan("Spartan Temp"));

    }

}

