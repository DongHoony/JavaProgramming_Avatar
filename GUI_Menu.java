package Avatar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI_Menu extends JFrame {
    private JPanel menuGui, btnsPanel,
            guiBoard0, guiBoard1, guiBoard2, guiBoard3, guiBoard4, guiBoard5, guiBoard6, guiBoard7, guiBoard8, guiBoard9, guiBoard10, guiBoard11,
            p1s1Panel, p1s2Panel, p1s3Panel, p1s4Panel, p1m1Panel, p1m2Panel, p1m3Panel, p1m4Panel, p1s5Panel, p1m5Panel, p2s1Panel, p2s2Panel, p2s3Panel,
            p2s4Panel, p2m1Panel, p2m2Panel, p2m3Panel, p2m4Panel, p2s5Panel, p2m5Panel,
            p1SkillQ1, p1SkillQ2, p1SkillQ3, p2SkillQ1, p2SkillQ2, p2SkillQ3, p1SkillQueue;
    private JButton p1m1, p1m2, p1m3, p1m4, p1s1, p1s2, p1s3, p1s4, p2m1, p2m2, p2m3, p2m4, p2s1, p2s2, p2s3, p2s4, changePanel, p1m5, p2m5, p1s5, p2s5,
            p1SkillQ1Btn, p1SkillQ2Btn, p1SkillQ3Btn, p2SkillQ1Btn, p2SkillQ2Btn, p2SkillQ3Btn, p1ResetBtn, p2ResetBtn, p1ConfirmBtn, p2ConfirmBtn, gameStartBtn;
    private JProgressBar p1HealthBar, p1EnergyBar, p2HealthBar, p2EnergyBar;
    JTextPane guiLog;
    private JLabel p1HealthLabel, p1EnergyLabel, p2HealthLabel, p2EnergyLabel,
            p1s1Label, p1s2Label, p1s3Label, p1s4Label, p1s5Label, p2s1Label, p2s2Label, p2s3Label, p2s4Label, p2s5Label,
            p1m1Label, p1m2Label, p1m3Label, p1m4Label, p1m5Label, p2m1Label, p2m2Label, p2m3Label, p2m4Label, p2m5Label;
    private JComboBox p1SelCharBox, p2SelCharBox;
    private JLabel[] moveLabels = {p1s1Label, p1s2Label, p1s3Label, p1s4Label, p1s5Label, p2s1Label, p2s2Label, p2s3Label, p2s4Label, p2s5Label},
            skillLabels = {p1m1Label, p1m2Label, p1m3Label, p1m4Label, p1m5Label, p2m1Label, p2m2Label, p2m3Label, p2m4Label, p2m5Label};
    private JPanel[] p1SkillImgPanel = {p1m1Panel, p1m2Panel, p1m3Panel, p1m4Panel, p1m5Panel},
            p2SkillImgPanel = {p2m1Panel, p2m2Panel, p2m3Panel, p2m4Panel, p2m5Panel},
            p1MovePanel = {p1s1Panel, p1s2Panel, p1s3Panel, p1s4Panel, p1s5Panel},
            p2MovePanel = {p2s1Panel, p2s2Panel, p2s3Panel, p2s4Panel, p2s5Panel},
            guiBoard = {guiBoard0, guiBoard1, guiBoard2, guiBoard3, guiBoard4, guiBoard5, guiBoard6, guiBoard7, guiBoard8, guiBoard9, guiBoard10, guiBoard11};
    private JButton[] p1Btn = {p1m1, p1m2, p1m3, p1m4, p1m5, p1s1, p1s2, p1s3, p1s4, p1s5}, p2Btn = {p2m1, p2m2, p2m3, p2m4, p2m5, p2s1, p2s2, p2s3, p2s4, p2s5},
            p1SkillQBtn = {p1SkillQ1Btn, p1SkillQ2Btn, p1SkillQ3Btn}, p2SkillQBtn = {p2SkillQ1Btn, p2SkillQ2Btn, p2SkillQ3Btn};
    public static boolean isP1Confirmed, isP2Confirmed, isGameStarted;
    public static int p1Char, p2Char;
    public static char[] p1SkillMoves, p2SkillMoves, pSkillMoves;
    JLabel p1Label, p2Label;


    public void logAppend(String s) {
        guiLog.setText(guiLog.getText() + s);
    }

    public void setBarLabelValue(boolean isP1, boolean isHealthBar, int v) throws InterruptedException {
        JProgressBar bar;
        JLabel label;
        if (isP1) {
            bar = (isHealthBar) ? p1HealthBar : p1EnergyBar;
            label = (isHealthBar) ? p1HealthLabel : p1EnergyLabel;
        } else {
            bar = (isHealthBar) ? p2HealthBar : p2EnergyBar;
            label = (isHealthBar) ? p2HealthLabel : p2EnergyLabel;
        }

        label.setText(String.format("%s : %d", (isHealthBar) ? "HEALTH" : "ENERGY", v));
        while (v != bar.getValue()) {
            if (bar.getValue() > v) bar.setValue(bar.getValue() - 1);
            else bar.setValue(bar.getValue() + 1);
            Thread.sleep(10);
        }
        bar.setValue(v);
    }

    public void refreshBars() throws InterruptedException {
        setBarLabelValue(true, true, Main.p1.getHealth());
        setBarLabelValue(true, false, Main.p1.getEnergy());
        setBarLabelValue(false, true, Main.p2.getHealth());
        setBarLabelValue(false, false, Main.p2.getEnergy());
    }

    public void showWinner(int w) {
        JOptionPane.showMessageDialog(null, String.format("%s가 이겼습니다 !", (w == 1) ? Main.p1.name : Main.p2.name), "게임 종료", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setCharacterImage(int p1CharacterNum, int p2CharacterNum) throws IOException {
        // Aang, Giaso, Toff, Bumi, Katara, Pakku, Zuko, Ozai
        BufferedImage p1Pic = ImageIO.read(new File(String.format("img/%d.png", p1CharacterNum)));
        BufferedImage p2Pic = ImageIO.read(new File(String.format("img/%d.png", p2CharacterNum)));
        p1Label = new JLabel(new ImageIcon(p1Pic.getScaledInstance(60, 120, Image.SCALE_SMOOTH)));
        p2Label = new JLabel(new ImageIcon(p2Pic.getScaledInstance(60, 120, Image.SCALE_SMOOTH)));


        for (int i = 0; i < 4; i++) {
            BufferedImage img = ImageIO.read(new File(String.format("img/skillimg/%d_%d.png", p1CharacterNum, i + 1)));
            skillLabels[i] = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            skillLabels[i].setBounds(0, 0, 100, 100);
            p1SkillImgPanel[i].setLayout(null);
            p1SkillImgPanel[i].add(skillLabels[i]);
            p1SkillImgPanel[i].repaint();
        }
        for (int i = 0; i < 4; i++) {
            BufferedImage img = ImageIO.read(new File(String.format("img/skillimg/%d_%d.png", p2CharacterNum, i + 1)));
            skillLabels[i + 5] = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            skillLabels[i + 5].setBounds(0, 0, 100, 100);
            p2SkillImgPanel[i].setLayout(null);
            p2SkillImgPanel[i].add(skillLabels[i + 5]);
            p2SkillImgPanel[i].repaint();
        }

        BufferedImage imge = ImageIO.read(new File("img/skillimg/guard.png"));
        skillLabels[4] = new JLabel(new ImageIcon(imge.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        skillLabels[4].setBounds(0, 0, 100, 100);
        skillLabels[9] = new JLabel(new ImageIcon(imge.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        skillLabels[9].setBounds(0, 0, 100, 100);
        p2SkillImgPanel[4].setLayout(null);
        p2SkillImgPanel[4].add(skillLabels[4]);
        p2SkillImgPanel[4].repaint();
        p1SkillImgPanel[4].setLayout(null);
        p1SkillImgPanel[4].add(skillLabels[9]);
        p1SkillImgPanel[4].repaint();

        for (int i = 0; i < 5; i++) {
            BufferedImage img = ImageIO.read(new File(String.format("img/moveimg/%d.png", i + 1)));
            moveLabels[i] = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            moveLabels[i].setBounds(0, 0, 100, 100);
            p1MovePanel[i].setLayout(null);
            p1MovePanel[i].add(moveLabels[i]);
            p1MovePanel[i].repaint();

            moveLabels[i] = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            moveLabels[i].setBounds(0, 0, 100, 100);
            p2MovePanel[i].setLayout(null);
            p2MovePanel[i].add(moveLabels[i]);
            p2MovePanel[i].repaint();

        }
    }

    public GUI_Menu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, InterruptedException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        String[] selCharMsg = {"공기의 유목민, 아바타 아앙!\n아앙 : 자연은 멈출 때를 알지.",
                                "공기의 유목민, 최강의 에어 번더 기아소!\n기아소 : 과거보다 한 발 앞서 나간다.",
                                "흙의 왕국, 베이 퐁 가문의 토프!\n토프 : 마법의 베틀로, 바위를 엮어내리라.",
                                "흙의 왕국, 최강의 어스 벤더 부미!\n부미 : 모든 걸 땅에서 일궈내야 하는 법.",
                                "남극의 물의 부족, 수호자 카타라!\n카타라 : 생명의 순환은 여기까지다.",
                                "북극의 물의 부족, 최강의 워터 벤더 파쿠!\n파쿠 : 내가 곧 눈과 바람, 그리고 얼음이다.",
                                "불의 제국, 왕자 주코! \n주코 : 바로 네 녀석이 이 땅의 재앙이다.",
                                "불의 제국, 제왕 오자이! \n오자이 : 쓰디쓴 최후를 선사하마."};
        this.setTitle("Avatar X Inuyasha");
        for (JPanel p : guiBoard) p.setLayout(null);
        setBarLabelValue(true, true, 100);
        setBarLabelValue(true, false, 100);
        setBarLabelValue(false, true, 100);
        setBarLabelValue(false, false, 100);
        guiLog.setBackground(new Color(158, 166, 134, 80));
        guiLog.setEditable(false);

        this.setContentPane(menuGui);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1600, 850);
        this.setResizable(false);

        gameStartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (p1SelCharBox.getSelectedIndex() == -1 || p2SelCharBox.getSelectedIndex() == -1) {
                    logAppend("캐릭터를 골라 주세요.\n");
                    return;
                }
                logAppend("\n잠시 후 게임이 시작됩니다!\n");
                gameStartBtn.setEnabled(false);
                p1SelCharBox.setEnabled(false);
                p2SelCharBox.setEnabled(false);
                gameStartBtn.setVisible(false);
                p1SelCharBox.setVisible(false);
                p2SelCharBox.setVisible(false);
                p1Char = p1SelCharBox.getSelectedIndex() + 1;
                p2Char = p2SelCharBox.getSelectedIndex() + 1;
                isGameStarted = true;
            }
        });
        for (JButton btn : p1Btn) btn.addActionListener(this::actionPerformed);
        for (JButton btn : p2Btn) btn.addActionListener(this::actionPerformed);
        p1ResetBtn.addActionListener(this::actionPerformed);
        p2ResetBtn.addActionListener(this::actionPerformed);
        p1ConfirmBtn.addActionListener(this::actionPerformed);
        p2ConfirmBtn.addActionListener(this::actionPerformed);
        p1SelCharBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.paramString().split(",")[2].charAt(12) == 'S'){
                    guiLog.setText(String.format(
                            "P1 : %s\n\nP2 : %s\n", (p1SelCharBox.getSelectedIndex() > -1) ? selCharMsg[p1SelCharBox.getSelectedIndex()] : "캐릭터를 선택해 주세요",
                            (p2SelCharBox.getSelectedIndex() > -1) ? selCharMsg[p2SelCharBox.getSelectedIndex()] : "캐릭터를 선택해 주세요"));
                }
            }
        });
        p2SelCharBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.paramString().split(",")[2].charAt(12) == 'S'){
                    guiLog.setText(String.format(
                            "P1 : %s\n\nP2 : %s\n", (p1SelCharBox.getSelectedIndex() > -1) ? selCharMsg[p1SelCharBox.getSelectedIndex()] : "캐릭터를 선택해 주세요",
                            (p2SelCharBox.getSelectedIndex() > -1) ? selCharMsg[p2SelCharBox.getSelectedIndex()] : "캐릭터를 선택해 주세요"));

                }
            }
        });
    }

    public void resetQueue(boolean isP1) {
        for (JButton b : (isP1) ? p1SkillQBtn : p2SkillQBtn) {
            b.setText("Skill Slot");
        }
        for (JButton b : (isP1) ? p1Btn : p2Btn) {
            b.setEnabled(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setEnabled(false);
        // IF P1 : QUEUE P1
        int flag = 0;
        for (JButton b : p1Btn) {
            if (b.equals(btn)) flag = 1;
        }
        for (JButton b : p2Btn) {
            if (b.equals(btn)) flag = 2;
        }
        // IF RESET
        if (btn.equals(p1ResetBtn) || btn.equals(p2ResetBtn)) {
            resetQueue(btn.equals(p1ResetBtn) ? true : false);
            btn.setEnabled(true);
        }
        //IF P1 BTN
        if (flag == 1 || flag == 2) {
            JButton[] QBtns;
            QBtns = (flag == 1) ? p1SkillQBtn : p2SkillQBtn;
            if (QBtns[0].getText().charAt(0) == 'S' && QBtns[0].getText().charAt(1) == 'k') {
                QBtns[0].setText(btn.getText());
            } else if (QBtns[1].getText().charAt(0) == 'S' && QBtns[1].getText().charAt(1) == 'k') {
                QBtns[1].setText(btn.getText());
            } else if (QBtns[2].getText().charAt(0) == 'S' && QBtns[2].getText().charAt(1) == 'k') {
                QBtns[2].setText(btn.getText());
                for (JButton b : (flag == 1) ? p1Btn : p2Btn) {
                    b.setEnabled(false);
                }
            }
        }
        //IF CONFIRM
        boolean isEnergyEnoughtoSpell = true;
        if (btn.equals(p1ConfirmBtn) || btn.equals(p2ConfirmBtn)) {
            boolean isP1 = (btn.equals(p1ConfirmBtn) ? true : false);
            Player p = (isP1) ? Main.p1 : Main.p2;
            int cnt = 0, energyUsage = 0;
            for (JButton b : (isP1) ? p1SkillQBtn : p2SkillQBtn) {
                if (b.getText().charAt(0) == 'S' && b.getText().charAt(1) == 'k') ;
                else cnt += 1;
            }
            // IF QUEUE HAS 3 SKILLS
            if (cnt == 3) {
                pSkillMoves = new char[3];

                for (int i = 0; i < 3; i++) {
                    String t = ((isP1) ? p1SkillQBtn : p2SkillQBtn)[i].getText();
                    if (t.charAt(0) == 'S') {
                        // IF SKILL
                        energyUsage += p.skills.requiredEnergy[Integer.parseInt(Character.toString(t.charAt(1))) - 1];
                        if (energyUsage > p.getEnergy()) isEnergyEnoughtoSpell = false;
                        pSkillMoves[i] = t.charAt(1);
                    } else if (t.charAt(0) == 'E') {
                        pSkillMoves[i] = t.charAt(0);
                        energyUsage -= 30;
                    } else {
                        //IF MOVES
                        pSkillMoves[i] = t.charAt(0);
                    }
                }
                if (isEnergyEnoughtoSpell) {
                    if (isP1) {
                        isP1Confirmed = true;
                        p1ResetBtn.setEnabled(false);
                        p1SkillMoves = pSkillMoves;
                    } else {
                        isP2Confirmed = true;
                        p2ResetBtn.setEnabled(false);
                        p2SkillMoves = pSkillMoves;
                    }
                    for (JButton b : (isP1) ? p1Btn : p2Btn) b.setEnabled(false);
                    for (JButton b : (isP1) ? p1SkillQBtn : p2SkillQBtn) b.setEnabled(false);
                } else {
                    logAppend("\n에너지가 모자랍니다.\n");
                    if (isP1) p1ConfirmBtn.setEnabled(true);
                    else p2ConfirmBtn.setEnabled(true);
                }
            }
            // IF YOU PICK LESS THAN 3
            else {
                logAppend("\n3개의 움직임을 모두 골라 주세요.\n");
                if (isP1) p1ConfirmBtn.setEnabled(true);
                else p2ConfirmBtn.setEnabled(true);
            }
        }
    }

    public void setBtnsDisable() {
        for (JButton b : p1Btn) {
            b.setEnabled(false);
        }
        for (JButton b : p2Btn) {
            b.setEnabled(false);
        }
        for (JButton b : p2SkillQBtn) {
            b.setEnabled(false);
        }
        for (JButton b : p1SkillQBtn) {
            b.setEnabled(false);
        }
        p1ResetBtn.setEnabled(false);
        p2ResetBtn.setEnabled(false);
        p1ConfirmBtn.setEnabled(false);
        p2ConfirmBtn.setEnabled(false);
    }

    public void setBtnsActive() {
        for (JButton b : p1Btn) {
            b.setEnabled(true);
        }
        for (JButton b : p2Btn) {
            b.setEnabled(true);
        }
        for (JButton b : p2SkillQBtn) {
            b.setEnabled(true);
        }
        for (JButton b : p1SkillQBtn) {
            b.setEnabled(true);
        }
        p1ResetBtn.setEnabled(true);
        p2ResetBtn.setEnabled(true);
        p1ConfirmBtn.setEnabled(true);
        p2ConfirmBtn.setEnabled(true);
        resetQueue(true);
        resetQueue(false);
    }

    public void blinkBoard(int[] tileNum, boolean isP1) throws InterruptedException {
        for (int t = 0; t < 4; t++) {
            for (int i : tileNum) {
                if (t % 2 == 0) {
                    if (isP1) guiBoard[i].setBackground(new Color(255, 0, 0));
                    else guiBoard[i].setBackground(new Color(0, 0, 255));
                } else {
                    refreshGuiBoard();
                }
                guiBoard[i].repaint();
            }
            Thread.sleep(300);
        }
        for (int i : tileNum) {
            refreshGuiBoard();
            guiBoard[i].repaint();
        }
    }

    public void refreshGuiBoard() {
        p1Label.setBounds(5, 5, 55, 110);
        p2Label.setBounds(60, 5, 55, 110);
        for (int i = 0; i < 12; i++) {
            if (GameBoard.gameBoard[i / 4][i % 4][0]) {
                guiBoard[i].add(p1Label);
            }
            if (GameBoard.gameBoard[i / 4][i % 4][1]) {
                guiBoard[i].add(p2Label);
            }
            if (GameBoard.gameBoard[i / 4][i % 4][2]) {
                guiBoard[i].setBackground(new Color(93, 61, 41));
            } else guiBoard[i].setBackground(new Color(158, 166, 134));
        }
        for (JPanel p : guiBoard) {
            p.repaint();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, InterruptedException {
        new GUI_Menu();
    }
}