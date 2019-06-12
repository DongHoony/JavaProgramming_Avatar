package Avatar;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static void showSleep(GameBoard g) throws InterruptedException {
        g.showBoard();
        Thread.sleep(500);
    }

    public static void makeCharacter(int isP1, int c){

        switch(c){
            case 1:
                t[isP1] = new Aang((isP1 == 1) ? true : false);
                break;
            case 2:
                t[isP1] = new GiAso((isP1 == 1) ? true : false);
                break;
            case 3:
                t[isP1] = new Toff((isP1 == 1) ? true : false);
                break;
            case 4:
                t[isP1] = new Earthian((isP1 == 1) ? true : false);
                break;
            case 5:
                t[isP1] = new Katara((isP1 == 1) ? true : false);
                break;
            case 6:
                t[isP1] = new Pakku((isP1 == 1) ? true : false);
                break;
            case 7:
                t[isP1] = new Zuko((isP1 == 1) ? true : false);
                break;
            case 8:
                t[isP1] = new Ozai((isP1 == 1) ? true : false);
                break;

        }
    }

    static Player p1, p2;
    static Player[] t = {p2, p1};
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        GUI_Menu gui = new GUI_Menu();

        gui.setBtnsDisable();

        //CHARACTER SELECT : USE IF TO GET P1, P2 CHARACTERS
        while (!GUI_Menu.isGameStarted){
            Thread.sleep(100);
        }

        int p1Char = GUI_Menu.p1Char;
        int p2Char = GUI_Menu.p2Char;
        makeCharacter(1, p1Char);
        makeCharacter(0, p2Char);

        // Aang, Giaso, Toff, Bumi, Katara, Pakku, Zuko, Ozai
        gui.setCharacterImage(p1Char, p2Char);

        p1 = t[1];
        p2 = t[0];

        gui.setBtnsActive();

        //ATTACH CHARACTERS TO GAME BOARD
        GameBoard g = new GameBoard(p1, p2);
        ArrayList<Integer> range;
        boolean turnP1 = false;
        while (true) {

            gui.refreshGuiBoard();
            gui.refreshBars();

            //TURN BY TURN, CHANGES FIRST
            turnP1 = !turnP1;
            System.out.printf("\n!!!! TURN %s !!!!\n", (turnP1) ? "P1" : "P2");
            gui.guiLog.setText(String.format("\n%s이(가) 선공입니다.\n", (turnP1) ? p1.name : p2.name));
            g.showBoard();

            // IF READY, CONTINUE
            while (true) {
                Thread.sleep(50);
                if (gui.isP1Confirmed && gui.isP2Confirmed) break;
            }

//            // Shows range print
//            for (int i = 0; i < 5; i++) {
//                for (int k = 0; k < 9; k++) {
//                    if (p1.skills.range[i][k]) System.out.printf("%d", k + 1);
//                }
//                System.out.printf("[%d, -%d]/ ", p1.skills.damage[i], p1.skills.requiredEnergy[i]);
//            }
//            System.out.println();
//            for (int i = 0; i < 5; i++) {
//                for (int k = 0; k < 9; k++) {
//                    if (p2.skills.range[i][k]) System.out.printf("%d", k + 1);
//                }
//                System.out.printf("[%d, -%d]/ ", p2.skills.damage[i], p2.skills.requiredEnergy[i]);
//            }
//            System.out.println();
            //end show range print
//
//            System.out.printf("P1 HP: %d, EN: %d\nP1 COMMAND : ",
//                    p1.getHealth(), p1.getEnergy());
//            //char[] cmdP1 = sc.next().toCharArray();
//            System.out.printf("P2 HP: %d, EN: %d\nP2 COMMAND : ",
//                    p2.getHealth(), p2.getEnergy());
//            //char[] cmdP2 = sc.next().toCharArray();

            char[] cmdP1 = gui.p1SkillMoves;
            char[] cmdP2 = gui.p2SkillMoves;

            //MOVE AND ATTACK, NEED TO SIMPLIFY
            for (int i = 0; i < 3; i++) {
                System.out.printf("%c %c\n", cmdP1[i], cmdP2[i]);
                //P1-P2 * 3 or P2-P1 * 3
                if (turnP1) {
                    //P1 ATTACK
                    if (Character.toString(cmdP1[i]).matches("[1-5]+")) {
                        range = p1.getRangeByIntArray(p1, p1.skills, Integer.parseInt(Character.toString(cmdP1[i])) - 1, g);
                        gui.blinkBoard(convertIntegers(range), true);
                        p1.attack(p1, p2, p1.skills, Integer.parseInt(Character.toString(cmdP1[i])) - 1, g, gui);
                        gui.refreshBars();
                        showSleep(g);
                        if (p2.isDead) System.exit(0);
                    } else if (cmdP1[i] == 'E') {
                        gui.logAppend(String.format("\n%s은(는) 기력을 회복합니다.\n", p1.name));
                        Thread.sleep(1000);
                        p1.setEnergy((p1.getEnergy() + 30 > 100) ? 100 : p1.getEnergy() + 30);
                    }
                        //P1 MOVE
                    else {
                        p1.move(g, cmdP1[i]);
                        showSleep(g);

                    }
                    gui.refreshGuiBoard();
                    gui.refreshBars();
                    //P2 ATTACK
                    if (Character.toString(cmdP2[i]).matches("[1-5]+")) {
                        range = p2.getRangeByIntArray(p2, p2.skills, Integer.parseInt(Character.toString(cmdP2[i])) - 1, g);
                        gui.blinkBoard(convertIntegers(range), false);
                        p2.attack(p2, p1, p2.skills, Integer.parseInt(Character.toString(cmdP2[i])) - 1, g, gui);
                        gui.refreshBars();
                        showSleep(g);
                        if (p1.isDead) System.exit(0);
                    } else if (cmdP2[i] == 'E') {
                        gui.logAppend(String.format("\n%s은(는) 기력을 회복합니다.\n", p2.name));
                        p2.setEnergy((p2.getEnergy() + 30 > 100) ? 100 : p2.getEnergy() + 30);
                        Thread.sleep(1000);
                    }
                        //P2 MOVE
                    else {
                        p2.move(g, cmdP2[i]);
                        showSleep(g);

                    }
                    gui.refreshGuiBoard();
                    gui.refreshBars();
                } else {
                    if (Character.toString(cmdP2[i]).matches("[1-5]+")) {
                        range = p2.getRangeByIntArray(p2, p2.skills, Integer.parseInt(Character.toString(cmdP2[i])) - 1, g);
                        gui.blinkBoard(convertIntegers(range), false);
                        p2.attack(p2, p1, p2.skills, Integer.parseInt(Character.toString(cmdP2[i])) - 1, g, gui);
                        gui.refreshBars();
                        showSleep(g);
                        if (p1.isDead) System.exit(0);
                    } else if (cmdP2[i] == 'E') {
                        gui.logAppend(String.format("\n%s은(는) 기력을 회복합니다.\n", p2.name));
                        p2.setEnergy((p2.getEnergy() + 30 > 100) ? 100 : p2.getEnergy() + 30);
                        Thread.sleep(1000);
                    }
                    else {
                        p2.move(g, cmdP2[i]);
                        showSleep(g);

                    }
                    gui.refreshGuiBoard();
                    if (Character.toString(cmdP1[i]).matches("[1-5]+")) {
                        range = p1.getRangeByIntArray(p1, p1.skills, Integer.parseInt(Character.toString(cmdP1[i])) - 1, g);
                        gui.blinkBoard(convertIntegers(range), true);
                        p1.attack(p1, p2, p1.skills, Integer.parseInt(Character.toString(cmdP1[i])) - 1, g, gui);
                        gui.refreshBars();
                        showSleep(g);
                        if (p2.isDead) System.exit(0);
                    } else if (cmdP1[i] == 'E') {
                        gui.logAppend(String.format("\n%s은(는) 기력을 회복합니다.\n", p1.name));
                        Thread.sleep(1000);
                        p1.setEnergy((p1.getEnergy() + 30 > 100) ? 100 : p1.getEnergy() + 30);
                    }
                    else {
                        p1.move(g, cmdP1[i]);
                        showSleep(g);
                    }
                    gui.refreshGuiBoard();
                    gui.refreshBars();
                }
            }
            // gets burn damage when turn ends
            if (p1.getBurnTick() > 0) {
                p1.setHealth(p1.getHealth() - 5);
                p1.setBurnTick(p1.getBurnTick() - 1);
                System.out.println("P1 : 5 BURN DAMAGED!");
                gui.logAppend(String.format("\n%s은(는) 화염 데미지를 입었습니다. (남은 턴 : %d)\n", p1.name, p1.getBurnTick()));
            }
            if (p2.getBurnTick() > 0) {
                p2.setHealth(p2.getHealth() - 5);
                p2.setBurnTick(p2.getBurnTick() - 1);
                System.out.println("P2 : 5 BURN DAMAGED!");
                gui.logAppend(String.format("\n%s은(는) 화염 데미지를 입었습니다. (남은 턴 : %d)\n", p2.name, p2.getBurnTick()));
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

            g.earthBoardRefresh();

            gui.isP1Confirmed = false;
            gui.isP2Confirmed = false;
            gui.refreshGuiBoard();
            gui.refreshBars();
            gui.setBtnsActive();
        }
    }
}

