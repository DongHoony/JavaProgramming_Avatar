package Avatar;

import java.util.Scanner;

public class Main {
    public static void showSleep(GameBoard g) throws InterruptedException{
        g.showBoard();
        Thread.sleep(1000);
    }
    public static void main(String[] args) throws InterruptedException{
        Scanner sc = new Scanner(System.in);
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
            g.showBoard();

            // Shows range
            for (int i = 0; i<4;i++){
                for(int k = 0; k < 9; k++){
                    if (p1.skills.range[i][k]) System.out.printf("%d",k+1);
                }
                System.out.printf("[%d, -%d]/ ", p1.skills.damage[i], p1.skills.requiredEnergy[i]);
            }
            System.out.println();
            for (int i = 0; i<4;i++){
                for(int k = 0; k < 9; k++){
                    if (p2.skills.range[i][k]) System.out.printf("%d",k+1);
                }
                System.out.printf("[%d, -%d]/ ", p2.skills.damage[i], p2.skills.requiredEnergy[i]);
            }
            System.out.println();
            //end show range

            System.out.printf("P1 HP: %d, EN: %d, ULT: %d\nP1 COMMAND : ",
                                          p1.getHealth(), p1.getEnergy(), p1.getUltCharge());
            char[] cmdP1 = sc.next().toCharArray();
            System.out.printf("P2 HP: %d, EN: %d, ULT: %d\nP2 COMMAND : ",
                                          p2.getHealth(), p2.getEnergy(), p2.getUltCharge());
            char[] cmdP2 = sc.next().toCharArray();

            //MOVE AND ATTACK, NEED TO SIMPLIFY
            for(int i = 0; i < 3; i++){
                System.out.printf("%c %c\n", cmdP1[i], cmdP2[i]);
                //P1-P2 * 3 or P2-P1 * 3
                if (turnP1){
                    if (Character.toString(cmdP1[i]).matches("[1-5]+")){
                        p1.attack(p1, p2, p1.skills, Integer.parseInt(Character.toString(cmdP1[i]))-1, g);
                        showSleep(g);
                        if (p2.isDead) System.exit(0);
                    }
                    else {
                        p1.move(g, cmdP1[i]);
                        showSleep(g);
                    }
                    if (Character.toString(cmdP2[i]).matches("[1-5]+")){
                        p2.attack(p2, p1, p2.skills, Integer.parseInt(Character.toString(cmdP1[i]))-1, g);
                        showSleep(g);
                        if (p1.isDead) System.exit(0);
                    }
                    else {
                        p2.move(g, cmdP2[i]);
                        showSleep(g);
                    }
                }

                else{
                    if (Character.toString(cmdP2[i]).matches("[1-5]+")){
                        p2.attack(p2, p1, p2.skills, Integer.parseInt(Character.toString(cmdP1[i]))-1, g);
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


//            switch(cmd){
//                case "U":
//                    if (turnP1) p1.move(g, 'U');
//                    else p2.moveUp(g);
//                    break;
//                case "D":
//                    if (turnP1) p1.moveDown(g);
//                    else p2.moveDown(g);
//                    break;
//                case "L":
//                    if (turnP1) p1.moveLeft(g);
//                    else p2.moveLeft(g);
//                    break;
//                case "R":
//                    if (turnP1) p1.moveRight(g);
//                    else p2.moveRight(g);
//                    break;
//                default:
//                    if (cmd.matches("[1-5]+")){
//                        if (turnP1) p1.attack(p1, p2, p1.skills, Integer.parseInt(cmd)-1, g);
//                        else p2.attack(p2, p1, p2.skills, Integer.parseInt(cmd)-1, g);
//                        break;
//                    }
//                    System.out.println("Wrong input");
//                    continue;
//            }
//            turnP1 = !turnP1;
        }
    }
}

