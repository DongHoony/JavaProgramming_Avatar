package Avatar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player p1 = new Katara(true);
        Player p2 = new Zuko(false);

        GameBoard g = new GameBoard(p1, p2);



//        int[] p1Pos = g.getPlayerPos(p1, true);
//        int[] p2Pos = g.getPlayerPos(p2, false);

        boolean turnP1 = true;
        while (true){

            g.showBoard();
            if (turnP1)System.out.printf("P1 MOVE, HP: %d, EN: %d, ULT: %d\nCOMMAND : ",
                                          p1.getHealth(), p1.getEnergy(), p1.getUltCharge());
            else System.out.printf("P2 MOVE, HP: %d, EN: %d, ULT: %d\nCOMMAND : ",
                                          p2.getHealth(), p2.getEnergy(), p2.getUltCharge());
            String cmd = sc.next();
            switch(cmd){
                case "U":
                    if (turnP1) p1.moveUp(g);
                    else p2.moveUp(g);
                    break;
                case "D":
                    if (turnP1) p1.moveDown(g);
                    else p2.moveDown(g);
                    break;
                case "L":
                    if (turnP1) p1.moveLeft(g);
                    else p2.moveLeft(g);
                    break;
                case "R":
                    if (turnP1) p1.moveRight(g);
                    else p2.moveRight(g);
                    break;
                default:
                    if (cmd.matches("[1-5]+")){
                        if (turnP1) p1.attack(p1, p2, p1.skills, Integer.parseInt(cmd)-1, g);
                        else p2.attack(p2, p1, p2.skills, Integer.parseInt(cmd)-1, g);
                        break;
                    }
                    System.out.println("Wrong input");
                    continue;
            }
            turnP1 = !turnP1;
        }
    }
}

