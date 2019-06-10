package Avatar;

import java.util.Scanner;

public class Main {
    public static void showSleep(GameBoard g) throws InterruptedException{
        g.showBoard();
        Thread.sleep(300);
    }
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
        GUI_Menu gui = new GUI_Menu();

        //CHARACTER SELECT : USE IF TO GET P1, P2 CHARACTERS
        Player p1 = new Pakku(true);
        Player p2 = new Zuko(false);

        //ATTACH CHARACTERS TO GAME BOARD
        GameBoard g = new GameBoard(p1, p2);

        boolean turnP1 = false;
        while (true){
            //TURN BY TURN, CHANGES FIRST
            turnP1 = !turnP1;
            System.out.printf("\n!!!! TURN %s !!!!\n", (turnP1) ? "P1" : "P2");
            gui.logAppend(String.format("\n!!!! TURN %s !!!!\n", (turnP1) ? "P1" : "P2"));
            g.showBoard();

            // Shows range print
            for (int i = 0; i<5;i++){
                for(int k = 0; k < 9; k++){
                    if (p1.skills.range[i][k]) System.out.printf("%d",k+1);
                }
                System.out.printf("[%d, -%d]/ ", p1.skills.damage[i], p1.skills.requiredEnergy[i]);
            }
            System.out.println();
            for (int i = 0; i<5;i++){
                for(int k = 0; k < 9; k++){
                    if (p2.skills.range[i][k]) System.out.printf("%d",k+1);
                }
                System.out.printf("[%d, -%d]/ ", p2.skills.damage[i], p2.skills.requiredEnergy[i]);
            }
            System.out.println();
            //end show range print

            System.out.printf("P1 HP: %d, EN: %d\nP1 COMMAND : ",
                                          p1.getHealth(), p1.getEnergy());
            char[] cmdP1 = sc.next().toCharArray();
            System.out.printf("P2 HP: %d, EN: %d\nP2 COMMAND : ",
                                          p2.getHealth(), p2.getEnergy());
            char[] cmdP2 = sc.next().toCharArray();

            //MOVE AND ATTACK, NEED TO SIMPLIFY
            for(int i = 0; i < 3; i++){
                System.out.printf("%c %c\n", cmdP1[i], cmdP2[i]);
                //P1-P2 * 3 or P2-P1 * 3
                if (turnP1){
                    //P1 ATTACK
                    if (Character.toString(cmdP1[i]).matches("[1-5]+")){
                        p1.attack(p1, p2, p1.skills, Integer.parseInt(Character.toString(cmdP1[i]))-1, g);
                        showSleep(g);
                        if (p2.isDead) System.exit(0);
                    }
                    //P1 MOVE
                    else {
                        p1.move(g, cmdP1[i]);
                        showSleep(g);
                    }
                    //P2 ATTACK
                    if (Character.toString(cmdP2[i]).matches("[1-5]+")){
                        p2.attack(p2, p1, p2.skills, Integer.parseInt(Character.toString(cmdP2[i]))-1, g);
                        showSleep(g);
                        if (p1.isDead) System.exit(0);
                    }
                    //P2 MOVE
                    else {
                        p2.move(g, cmdP2[i]);
                        showSleep(g);
                    }
                }

                else{
                    if (Character.toString(cmdP2[i]).matches("[1-5]+")){
                        p2.attack(p2, p1, p2.skills, Integer.parseInt(Character.toString(cmdP2[i]))-1, g);
                        showSleep(g);
                        if (p1.isDead) System.exit(0);
                    }
                    else {
                        p2.move(g, cmdP2[i]);
                        showSleep(g);
                    }

                    if (Character.toString(cmdP1[i]).matches("[1-5]+")){
                        p1.attack(p1, p2, p1.skills, Integer.parseInt(Character.toString(cmdP1[i]))-1, g);
                        showSleep(g);
                        if (p2.isDead) System.exit(0);
                    }
                    else {
                        p1.move(g, cmdP1[i]);
                        showSleep(g);
                    }
                }

            }
            // gets burn damage when turn ends
            if (p1.getBurnTick() > 0){
                p1.setHealth(p1.getHealth() - 10);
                p1.setBurnTick(p1.getBurnTick()-1);
                System.out.println("P1 : 10 BURN DAMAGED!");
            }
            if (p2.getBurnTick() > 0){
                p2.setHealth(p2.getHealth() - 10);
                p2.setBurnTick(p2.getBurnTick()-1);
                System.out.println("P2 : 10 BURN DAMAGED!");
            }
            if (p2.isDead()) System.exit(0);
            if (p1.isDead()) System.exit(0);

            // ADD ENERGY 20 when turn ends
            p1.setEnergy(p1.getEnergy() + 20);
            p2.setEnergy(p2.getEnergy() + 20);
            p1.setEnergy(p1.getEnergy() > 100 ? 100 : p1.getEnergy());
            p2.setEnergy(p2.getEnergy() > 100 ? 100 : p2.getEnergy());

            //Guard off when turn ends
            p1.skills.isGuardOn = false;
            p2.skills.isGuardOn = false;
        }
    }
}

