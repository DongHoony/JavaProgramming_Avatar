package Avatar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

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
    JTextPane guiLog;
    private JLabel p1HealthLabel;
    private JLabel p1EnergyLabel;
    private JLabel p2HealthLabel;
    private JLabel p2EnergyLabel;
    private JPanel p1s1Panel;
    private JPanel p1s2Panel;
    private JPanel p1s3Panel;
    private JPanel p1s4Panel;
    private JPanel p1m1Panel;
    private JPanel p1m2Panel;
    private JPanel p1m3Panel;
    private JPanel p1m4Panel;
    private JPanel p1s5Panel;
    private JPanel p1m5Panel;
    private JPanel p2s1Panel;
    private JPanel p2s2Panel;
    private JPanel p2s3Panel;
    private JPanel p2s4Panel;
    private JPanel p2m1Panel;
    private JPanel p2m2Panel;
    private JPanel p2m3Panel;
    private JPanel p2m4Panel;
    private JPanel p2s5Panel;
    private JPanel p2m5Panel;
    private JComboBox p1SelCharBox;
    private JButton gameStartBtn;
    private JComboBox p2SelCharBox;
    private JLabel p1s1Label, p1s2Label, p1s3Label, p1s4Label, p1s5Label, p2s1Label, p2s2Label, p2s3Label, p2s4Label, p2s5Label;
    private JLabel[] moveLabels = {p1s1Label, p1s2Label, p1s3Label, p1s4Label, p1s5Label, p2s1Label, p2s2Label, p2s3Label, p2s4Label, p2s5Label};
    private JLabel p1m1Label, p1m2Label, p1m3Label, p1m4Label, p1m5Label, p2m1Label, p2m2Label, p2m3Label, p2m4Label, p2m5Label;
    private JLabel[] skillLabels = {p1m1Label, p1m2Label, p1m3Label, p1m4Label, p1m5Label, p2m1Label, p2m2Label, p2m3Label, p2m4Label, p2m5Label};
    private JPanel[] p1SkillImgPanel = {p1m1Panel, p1m2Panel, p1m3Panel, p1m4Panel, p1m5Panel};
    private JPanel[] p2SkillImgPanel = {p2m1Panel, p2m2Panel, p2m3Panel, p2m4Panel, p2m5Panel};
    private JPanel[] p1MovePanel = {p1s1Panel, p1s2Panel, p1s3Panel, p1s4Panel, p1s5Panel};
    private JPanel[] p2MovePanel = {p2s1Panel, p2s2Panel, p2s3Panel, p2s4Panel, p2s5Panel};
    private JPanel[] guiBoard = {guiBoard0, guiBoard1, guiBoard2, guiBoard3, guiBoard4, guiBoard5, guiBoard6, guiBoard7, guiBoard8, guiBoard9, guiBoard10, guiBoard11};
    private JButton[] p1Btn = {p1m1, p1m2, p1m3, p1m4, p1m5, p1s1, p1s2, p1s3, p1s4, p1s5}, p2Btn = {p2m1, p2m2, p2m3, p2m4, p2m5, p2s1, p2s2, p2s3, p2s4, p2s5};
    private JButton[] p1SkillQBtn = {p1SkillQ1Btn, p1SkillQ2Btn, p1SkillQ3Btn};
    private JButton[] p2SkillQBtn = {p2SkillQ1Btn, p2SkillQ2Btn, p2SkillQ3Btn};
    public static boolean isP1Confirmed, isP2Confirmed, isGameStarted;
    public static int p1Char, p2Char;
    public static char[] p1SkillMoves, p2SkillMoves;
    JLabel p1Label, p2Label;


    public void logAppend(String s) {
        guiLog.setText(guiLog.getText() + s);
    }

    public void setP1HealthBar(int h) {
        p1HealthLabel.setText(String.format("HEALTH : %d", h));
        while (h != p1HealthBar.getValue()){
            if (p1HealthBar.getValue() > h){
                p1HealthBar.setValue(p1HealthBar.getValue() - 1);
                try{Thread.sleep(10);} catch(InterruptedException e) {}
            }
            else{
                p1HealthBar.setValue(p1HealthBar.getValue() + 1);
                try{Thread.sleep(10);} catch(InterruptedException e) {}
            }
        }
        p1HealthBar.setValue(h);
    }

    public void setP2HealthBar(int h) {
        p2HealthLabel.setText(String.format("HEALTH : %d", h));
        while (h != p2HealthBar.getValue()){
            if (p2HealthBar.getValue() > h){
                p2HealthBar.setValue(p2HealthBar.getValue() - 1);
                try{Thread.sleep(10);} catch(InterruptedException e) {}
            }
            else{
                p2HealthBar.setValue(p2HealthBar.getValue() + 1);
                try{Thread.sleep(10);} catch(InterruptedException e) {}
            }
        }
        p2HealthBar.setValue(h);
    }

    public void setP1EnergyBar(int e) {
        p1EnergyLabel.setText(String.format("ENERGY : %d", e));
        while (e != p1EnergyBar.getValue()){
            if (p1EnergyBar.getValue() > e){
                p1EnergyBar.setValue(p1EnergyBar.getValue() - 1);
                try{Thread.sleep(10);} catch(InterruptedException ee) {}
            }
            else{
                p1EnergyBar.setValue(p1EnergyBar.getValue() + 1);
                try{Thread.sleep(10);} catch(InterruptedException ee) {}
            }
        }
        p1EnergyBar.setValue(e);
    }

    public void setP2EnergyBar(int e) {
        p2EnergyLabel.setText(String.format("ENERGY : %d", e));
        while (e != p2EnergyBar.getValue()){
            if (p2EnergyBar.getValue() > e){
                p2EnergyBar.setValue(p2EnergyBar.getValue() - 1);
                try{Thread.sleep(10);} catch(InterruptedException ee) {}
            }
            else{
                p2EnergyBar.setValue(p2EnergyBar.getValue() + 1);
                try{Thread.sleep(10);} catch(InterruptedException ee) {}
            }
        }
        p2EnergyBar.setValue(e);
    }

    public void refreshBars(){
        setP1EnergyBar(Main.p1.getEnergy());
        setP2EnergyBar(Main.p2.getEnergy());
        setP1HealthBar(Main.p1.getHealth());
        setP2HealthBar(Main.p2.getHealth());
    }

    public void setCharacterImage (int p1CharacterNum, int p2CharacterNum) throws IOException {
        // Aang, Giaso, Toff, Bumi, Katara, Pakku, Zuko, Ozai
//        String url1 = String.format("/img/%d.png", p1CharacterNum);
//        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(url1));
        System.out.printf("%d %d ", p1CharacterNum, p2CharacterNum);
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
        for(int i = 0; i < 4; i++){
            BufferedImage img = ImageIO.read(new File(String.format("img/skillimg/%d_%d.png", p2CharacterNum, i + 1)));
            skillLabels[i+5] = new JLabel(new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            skillLabels[i+5].setBounds(0, 0, 100, 100);
            p2SkillImgPanel[i].setLayout(null);
            p2SkillImgPanel[i].add(skillLabels[i+5]);
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
            System.out.println(i);
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
        this.setBounds(100, 100, 1600, 850);
        this.setResizable(false);


        gameStartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p1SelCharBox.getSelectedIndex() == -1 || p2SelCharBox.getSelectedIndex() == -1){
                    logAppend("캐릭터를 골라 주세요.\n");
                    return;
                }


                gameStartBtn.setEnabled(false);
                p1SelCharBox.setEnabled(false);
                p2SelCharBox.setEnabled(false);
                gameStartBtn.setVisible(false);
                p1SelCharBox.setVisible(false);
                p2SelCharBox.setVisible(false);
                isGameStarted = true;
                p1Char = p1SelCharBox.getSelectedIndex() + 1;
                p2Char = p2SelCharBox.getSelectedIndex() + 1;
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
        boolean isEnergyEnoughtoSpell = true;
        if (btn.equals(p1ConfirmBtn)) {
            int cnt = 0, energyUsage = 0;
            for (JButton b : p1SkillQBtn) {
                if (b.getText().charAt(0) == 'S' && b.getText().charAt(1) == 'k') ;
                else cnt += 1;
            }
            // IF QUEUE HAS 3 SKILLS
            if (cnt == 3) {
                p1SkillMoves = new char[3];
                for (int i = 0; i < 3; i++) {
                    String t = p1SkillQBtn[i].getText();
                    if (t.charAt(0) == 'S') {
                        // IF SKILL
                        energyUsage += Main.p1.skills.requiredEnergy[Integer.parseInt(Character.toString(t.charAt(1))) - 1];
                        if (energyUsage > Main.p1.getEnergy()) isEnergyEnoughtoSpell = false;
                        p1SkillMoves[i] = t.charAt(1);
                    } else if (t.charAt(0) == 'E') {
                        p1SkillMoves[i] = t.charAt(0);
                        energyUsage -= 30;
                    } else {
                        //IF MOVES
                        p1SkillMoves[i] = t.charAt(0);
                    }
                }
                if (isEnergyEnoughtoSpell) {
                    isP1Confirmed = true;
                    System.out.printf("CONFIRM, %s\n", p1SkillMoves.toString());
                    for (JButton b : p1Btn) {
                        b.setEnabled(false);
                    }
                    for (JButton b : p1SkillQBtn) {
                        b.setEnabled(false);
                    }
                    p1ResetBtn.setEnabled(false);
                } else {
                    logAppend("\n에너지가 모자랍니다.\n");
                    System.out.println("LACK OF ENERGY !");
                    p1ConfirmBtn.setEnabled(true);
                }
            }
            // IF YOU PICK LESS THAN 3
            else {
                logAppend("\n3개의 움직임을 모두 골라 주세요.\n");
                System.out.println("PICK 3 SKILLS/MOVES");
                p1ConfirmBtn.setEnabled(true);
            }
        } else if (btn.equals(p2ConfirmBtn)) {
            int cnt = 0, energyUsage = 0;
            for (JButton b : p2SkillQBtn) {
                if (b.getText().charAt(0) == 'S' && b.getText().charAt(1) == 'k') ;
                else cnt += 1;
            }
            if (cnt == 3) {
                p2SkillMoves = new char[3];
                for (int i = 0; i < 3; i++) {
                    String t = p2SkillQBtn[i].getText();
                    if (t.charAt(0) == 'S') {
                        //SKILL
                        energyUsage += Main.p2.skills.requiredEnergy[Integer.parseInt(Character.toString(t.charAt(1))) - 1];
                        if (energyUsage > Main.p1.getEnergy()) isEnergyEnoughtoSpell = false;
                        p2SkillMoves[i] = t.charAt(1);
                    } else if (t.charAt(0) == 'E') {
                        energyUsage -= 30;
                        p2SkillMoves[i] = t.charAt(0);
                    } else {
                        //MOVES
                        p2SkillMoves[i] = t.charAt(0);
                    }
                }
                if (isEnergyEnoughtoSpell) {
                    isP2Confirmed = true;
                    System.out.printf("CONFIRM, %s\n", p2SkillMoves);
                    for (JButton b : p2Btn) {
                        b.setEnabled(false);
                    }
                    for (JButton b : p2SkillQBtn) {
                        b.setEnabled(false);
                    }
                    p2ResetBtn.setEnabled(false);
                } else {
                    logAppend("\n에너지가 모자랍니다.\n");
                    System.out.println("LACK OF ENERGY !");
                    p2ConfirmBtn.setEnabled(true);
                }
            } else {
                logAppend("\n3개의 움직임을 모두 골라 주세요.\n");
                System.out.println("PICK 3 SKILLS/MOVES");
                p2ConfirmBtn.setEnabled(true);
            }
        }
    }

    public void setBtnsDisable(){
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
            if (GameBoard.gameboard[i / 4][i % 4][0]) {
                guiBoard[i].add(p1Label);
            }
            if (GameBoard.gameboard[i / 4][i % 4][1]) {
                guiBoard[i].add(p2Label);
            }
            if (GameBoard.gameboard[i / 4][i % 4][2]) {
                guiBoard[i].setBackground(new Color(93, 61, 41));
            } else guiBoard[i].setBackground(new Color(158, 166, 134));
        }
        for (JPanel p : guiBoard) {
            p.repaint();
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        new GUI_Menu();
    }
}
