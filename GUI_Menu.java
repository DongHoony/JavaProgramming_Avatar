package Avatar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI_Menu extends JFrame {
    private JPanel menuGui;
    private JButton p1m1, p1m2, p1m3, p1m4, p1s1, p1s2, p1s3, p1s4, p2m1, p2m2, p2m3, p2m4, p2s1, p2s2, p2s3, p2s4;
    private JButton changePanel;
    private JPanel btnsPanel;
    private JProgressBar p1HealthBar, p1EnergyBar, p2HealthBar, p2EnergyBar;
    private JButton p1m5;
    private JButton p2m5;
    private JButton p1s5;
    private JButton p2s5;
    private JPanel p1SkillQueue;
    private JPanel p1SkillQ1, p1SkillQ2, p1SkillQ3, p2SkillQ1, p2SkillQ2, p2SkillQ3;
    private JButton p1SkillQ1Btn, p1SkillQ2Btn, p1SkillQ3Btn;
    private JButton p2SkillQ1Btn, p2SkillQ2Btn, p2SkillQ3Btn;
    private JButton p1ResetBtn;
    private JButton p2ResetBtn;
    private JButton p2ConfirmBtn;
    private JButton p1ConfirmBtn;
    private JPanel guiBoard0, guiBoard1, guiBoard2, guiBoard3, guiBoard4, guiBoard5, guiBoard6, guiBoard7, guiBoard8, guiBoard9, guiBoard10, guiBoard11;
    private JTextArea guiLog;
    private JLabel p1HealthLabel;
    private JLabel p1EnergyLabel;
    private JLabel p2HealthLabel;
    private JLabel p2EnergyLabel;
    private JPanel[] guiBoard = {guiBoard0, guiBoard1, guiBoard2, guiBoard3, guiBoard4, guiBoard5, guiBoard6, guiBoard7, guiBoard8, guiBoard9, guiBoard10, guiBoard11};
    private JButton[] p1Btn = {p1m1, p1m2, p1m3, p1m4, p1m5, p1s1, p1s2, p1s3, p1s4, p1s5}, p2Btn = {p2m1, p2m2, p2m3, p2m4, p2m5, p2s1, p2s2, p2s3, p2s4, p2s5};
    private JButton[] p1SkillQBtn = {p1SkillQ1Btn, p1SkillQ2Btn, p1SkillQ3Btn};
    private JButton[] p2SkillQBtn = {p2SkillQ1Btn, p2SkillQ2Btn, p2SkillQ3Btn};
    public static boolean isP1Confirmed, isP2Confirmed;
    public static char[] p1SkillMoves, p2SkillMoves;
    JLabel p1Label, p2Label;


    public void logAppend(String s) {
        guiLog.setText(guiLog.getText() + s);
    }

    public void setP1HealthBar(int h) {
        p1HealthLabel.setText(String.format("HEALTH : %d", h));
        p1HealthBar.setValue(h);
    }

    public void setP2HealthBar(int h) {
        p2HealthLabel.setText(String.format("HEALTH : %d", h));
        p2HealthBar.setValue(h);
    }

    public void setP1EnergyBar(int e) {
        p1EnergyLabel.setText(String.format("ENERGY : %d", e));
        p1EnergyBar.setValue(e);
    }

    public void setP2EnergyBar(int e) {
        p2EnergyLabel.setText(String.format("ENERGY : %d", e));
        p2EnergyBar.setValue(e);
    }

    public void setCharacterImage(int p1CharacterNum, int p2CharacterNum) throws IOException {
        // Aang, Giaso, Toff, Bumi, Katara, Pakku, Zuko, Ozai
        BufferedImage p1Pic = ImageIO.read(new File(String.format("src/Avatar/img/%d.png", p1CharacterNum)));
        BufferedImage p2Pic = ImageIO.read(new File(String.format("src/Avatar/img/%d.png", p2CharacterNum)));
        p1Label = new JLabel(new ImageIcon(p1Pic.getScaledInstance(50, 100, Image.SCALE_SMOOTH)));
        p2Label = new JLabel(new ImageIcon(p2Pic.getScaledInstance(50, 100, Image.SCALE_SMOOTH)));
    }


    public GUI_Menu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        for (JPanel p : guiBoard) {
            p.setLayout(null);
        }
        setP1HealthBar(100);
        setP2HealthBar(100);
        setP1EnergyBar(100);
        setP2EnergyBar(100);
        guiLog.setBackground(new Color(158, 166, 134, 80));
        guiLog.setEditable(false);

        this.setContentPane(menuGui);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1500, 700);
        this.setResizable(false);

        changePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnsPanel.isVisible()) {
                    btnsPanel.setVisible(false);
                } else btnsPanel.setVisible(true);
            }
        });
        for (JButton btn : p1Btn) {
            btn.addActionListener(this::actionPerformed);
        }
        for (JButton btn : p2Btn) {
            btn.addActionListener(this::actionPerformed);
        }
        p1ResetBtn.addActionListener(this::actionPerformed);
        p2ResetBtn.addActionListener(this::actionPerformed);
        p1ConfirmBtn.addActionListener(this::actionPerformed);
        p2ConfirmBtn.addActionListener(this::actionPerformed);
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
        if (btn.equals(p1ResetBtn)) {
            p1SkillQ1Btn.setText("Skill Slot");
            p1SkillQ2Btn.setText("Skill Slot");
            p1SkillQ3Btn.setText("Skill Slot");
            for (JButton b : p1Btn) {
                b.setEnabled(true);
            }
            btn.setEnabled(true);
        }
        if (btn.equals(p2ResetBtn)) {
            p2SkillQ1Btn.setText("Skill Slot");
            p2SkillQ2Btn.setText("Skill Slot");
            p2SkillQ3Btn.setText("Skill Slot");
            for (JButton b : p2Btn) {
                b.setEnabled(true);
            }
            btn.setEnabled(true);
        }

        //IF P1 BTN
        if (flag == 1) {
            if (p1SkillQ1Btn.getText().charAt(0) == 'S' && p1SkillQ1Btn.getText().charAt(1) == 'k') {
                p1SkillQ1Btn.setText(btn.getText());
            } else if (p1SkillQ2Btn.getText().charAt(0) == 'S' && p1SkillQ2Btn.getText().charAt(1) == 'k') {
                p1SkillQ2Btn.setText(btn.getText());
            } else if (p1SkillQ3Btn.getText().charAt(0) == 'S' && p1SkillQ3Btn.getText().charAt(1) == 'k') {
                p1SkillQ3Btn.setText(btn.getText());
                for (JButton b : p1Btn) {
                    b.setEnabled(false);
                }
            }
        }
        // IF P2 BTN
        else if (flag == 2) {
            if (p2SkillQ1Btn.getText().charAt(0) == 'S' && p2SkillQ1Btn.getText().charAt(1) == 'k') {
                p2SkillQ1Btn.setText(btn.getText());
            } else if (p2SkillQ2Btn.getText().charAt(0) == 'S' && p2SkillQ2Btn.getText().charAt(1) == 'k') {
                p2SkillQ2Btn.setText(btn.getText());
            } else if (p2SkillQ3Btn.getText().charAt(0) == 'S' && p2SkillQ3Btn.getText().charAt(1) == 'k') {
                p2SkillQ3Btn.setText(btn.getText());
                for (JButton b : p2Btn) {
                    b.setEnabled(false);
                }
            }
        }

        //IF CONFIRM
        if (btn.equals(p1ConfirmBtn)) {
            int cnt = 0;
            for (JButton b : p1SkillQBtn) {
                if (b.getText().charAt(0) == 'S' && b.getText().charAt(1) == 'k') ;
                else cnt += 1;
            }
            if (cnt == 3) {
                for (JButton b : p1Btn) {
                    b.setEnabled(false);
                }
                for (JButton b : p1SkillQBtn) {
                    b.setEnabled(false);
                }
                p1ResetBtn.setEnabled(false);

                p1SkillMoves = new char[3];
                for (int i = 0; i < 3; i++) {
                    String t = p1SkillQBtn[i].getText();
                    if (t.charAt(0) == 'S') {
                        //SKILL
                        p1SkillMoves[i] = t.charAt(1);
                    } else {
                        //MOVES
                        p1SkillMoves[i] = t.charAt(0);
                    }
                }
                isP1Confirmed = true;
                System.out.printf("CONFIRM, %s\n", p1SkillMoves.toString());
            } else {
                System.out.println("PICK 3 SKILLS/MOVES");
                p1ConfirmBtn.setEnabled(true);
            }
        } else if (btn.equals(p2ConfirmBtn)) {
            int cnt = 0;
            for (JButton b : p2SkillQBtn) {
                if (b.getText().charAt(0) == 'S' && b.getText().charAt(1) == 'k') ;
                else cnt += 1;
            }
            if (cnt == 3) {
                for (JButton b : p2Btn) {
                    b.setEnabled(false);
                }
                for (JButton b : p2SkillQBtn) {
                    b.setEnabled(false);
                }
                p2ResetBtn.setEnabled(false);

                p2SkillMoves = new char[3];
                for (int i = 0; i < 3; i++) {
                    String t = p2SkillQBtn[i].getText();
                    if (t.charAt(0) == 'S') {
                        //SKILL
                        p2SkillMoves[i] = t.charAt(1);
                    } else {
                        //MOVES
                        p2SkillMoves[i] = t.charAt(0);
                    }
                }
                isP2Confirmed = true;
                System.out.printf("CONFIRM, %s\n", p2SkillMoves);
            } else {
                System.out.println("PICK 3 SKILLS/MOVES");
                p2ConfirmBtn.setEnabled(true);
            }
        }
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
        p1SkillQ1Btn.setText("Skill Slot");
        p1SkillQ2Btn.setText("Skill Slot");
        p1SkillQ3Btn.setText("Skill Slot");
        p2SkillQ1Btn.setText("Skill Slot");
        p2SkillQ2Btn.setText("Skill Slot");
        p2SkillQ3Btn.setText("Skill Slot");
    }

    public void blinkBoard(int[] tileNum, boolean isP1) throws InterruptedException {
        for (int t = 0; t < 4; t++) {
            for (int i : tileNum) {
                if (t % 2 == 0) {
                    if (isP1) guiBoard[i].setBackground(new Color(255, 0, 0));
                    else guiBoard[i].setBackground(new Color(0, 0, 255));
                } else {
                    guiBoard[i].setBackground(new Color(158, 166, 134));
                }
                guiBoard[i].repaint();
            }
            Thread.sleep(300);
        }
        for (int i : tileNum) {
            guiBoard[i].setBackground(new Color(158, 166, 134));
            guiBoard[i].repaint();
        }
    }

    public void refreshGuiBoard(GameBoard g) {
        p1Label.setBounds(0, 0, 50, 100);
        p2Label.setBounds(50, 0, 50, 100);
        for (int i = 0; i < 12; i++) {
            if (g.gameboard[i / 4][i % 4][0]) {
                System.out.printf("FOUND P1 AT %d\n", i);
                guiBoard[i].add(p1Label);
            }
            if (g.gameboard[i / 4][i % 4][1]) {
                System.out.printf("FOUND P2 AT %d\n", i);
                guiBoard[i].add(p2Label);
            }
        }
        for (JPanel p : guiBoard) {
            p.repaint();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        new GUI_Menu();
    }

}
