package Avatar;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static void makeCharacter(int isP1, int c) {
        switch (c) {
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

    public static void attackPhase(boolean isP1, char cmd, GUI_Menu gui, GameBoard g) throws InterruptedException {
        Player p = (isP1) ? p1 : p2;
        switch (cmd) {
            case '1': case '2': case '3': case '4': case '5':
                ArrayList<Integer> range = p.getRangeByIntArray(p, p.skills, Integer.parseInt(Character.toString(cmd)) - 1, g);
                gui.blinkBoard(convertIntegers(range), isP1);
                p.attack(p.skills, Integer.parseInt(Character.toString(cmd)) - 1, g, gui);
                gui.refreshBars();
                Thread.sleep(500);
                break;
            case 'E':
                gui.logAppend(String.format("\n%s은(는) 기력을 회복합니다.\n", p.name));
                Thread.sleep(1000);
                p.setEnergy((p.getEnergy() + 30 > 100) ? 100 : p.getEnergy() + 30);
                break;
            default:
                p.move(g, cmd);
                Thread.sleep(500);
        }
        if (p.equals(p1) ? p2.isDead() : p1.isDead()) {
            setWinner(p);
            gui.showWinner(p.equals(p1) ? 1 : 2);
            System.exit(0);
        }
        gui.refreshGuiBoard();
        gui.refreshBars();
    }

    public static int setWinner(Player p) {
        return (p.isP1) ? 1 : 2;
    }

    static Player p1, p2;
    static Player[] t = {p2, p1};

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        GUI_Menu gui = new GUI_Menu();
        gui.setBtnsDisable();

        //CHARACTER SELECT : USE IF TO GET P1, P2 CHARACTERS
        while (!GUI_Menu.isGameStarted) {
            Thread.sleep(100);
        }

        int p1Char = GUI_Menu.p1Char;
        int p2Char = GUI_Menu.p2Char;
        makeCharacter(1, p1Char);
        makeCharacter(0, p2Char);
        gui.setCharacterImage(p1Char, p2Char);
        p1 = t[1];
        p2 = t[0];
        gui.setBtnsActive();
        GameBoard g = new GameBoard();
        int winner = -1;
        boolean turnP1 = false;

        //game cycle
        while (true) {
            gui.refreshGuiBoard();
            gui.refreshBars();

            turnP1 = !turnP1;
            gui.guiLog.setText(String.format("\n%s이(가) 선공입니다.\n", (turnP1) ? p1.name : p2.name));

            //wait for confirm
            while (true) {
                Thread.sleep(50);
                if (gui.isP1Confirmed && gui.isP2Confirmed) break;
            }

            char[] cmdP1 = gui.p1SkillMoves;
            char[] cmdP2 = gui.p2SkillMoves;

            if (turnP1) {
                for (int i = 0; i < 3; i++) {
                    attackPhase(true, cmdP1[i], gui, g);
                    attackPhase(false, cmdP2[i], gui, g);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    attackPhase(false, cmdP2[i], gui, g);
                    attackPhase(true, cmdP1[i], gui, g);
                }
            }

            if (p1.takeBurnDamageAndReturnTickBefore() > 1) {
                gui.logAppend(String.format("\n%s은(는) 화염 데미지를 입었습니다. (남은 턴 : %d)\n", p1.name, p1.getBurnTick()));
                if (p1.isDead()) setWinner(p2);
            }
            if (p2.takeBurnDamageAndReturnTickBefore() > 1) {
                gui.logAppend(String.format("\n%s은(는) 화염 데미지를 입었습니다. (남은 턴 : %d)\n", p2.name, p2.getBurnTick()));
                if (p2.isDead()) setWinner(p1);
            }
            if (winner > 0) break;

            gui.logAppend(String.format("\n턴을 종료하고 에너지를 회복합니다.\n"));
            Thread.sleep(1000);
            p1.setEnergy(p1.getEnergy() + 20 > 100 ? 100 : p1.getEnergy() + 20);
            p2.setEnergy(p2.getEnergy() + 20 > 100 ? 100 : p2.getEnergy() + 20);

            //Guard off when turn ends
            p1.isGuardOn = false;
            p2.isGuardOn = false;
            gui.isP1Confirmed = false;
            gui.isP2Confirmed = false;
            g.earthBoardRefresh();
            gui.refreshGuiBoard();
            gui.refreshBars();
            gui.setBtnsActive();
        }
        gui.showWinner(winner);
    }
}