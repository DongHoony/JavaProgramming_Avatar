package Avatar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Menu extends JFrame{
    private JPanel menuGui;
    private JButton p1m1, p1m2, p1m3, p1m4, p1s1, p1s2, p1s3, p1s4, p2m1, p2m2, p2m3, p2m4, p2s1, p2s2, p2s3, p2s4;
    private JButton changePanel;
    private JPanel btnsPanel;
    private JProgressBar p1HealthBar, p1EnergyBar, p2Healthbar,p2EnergyBar;
    private JButton p1m5;
    private JButton p2m5;
    private JButton p1s5;
    private JButton p2s5;
    private JTextField guiLog;
    private JPanel p1SkillQueue;
    private JPanel p1SkillQ1;
    private JPanel p1SkillQ2;
    private JPanel p1SkillQ3;
    private JPanel p2SkillQ1;
    private JPanel p2SkillQ2;
    private JPanel p2SkillQ3;
    private JButton p1SkillQ1Btn;
    private JButton p1SkillQ2Btn;
    private JButton p1SkillQ3Btn;
    private JButton p2SkillQ1Btn;
    private JButton p2SkillQ2Btn;
    private JButton p2SkillQ3Btn;
    private JButton p1ResetBtn;
    private JButton p2ResetBtn;
    private JButton p2ConfirmBtn;
    private JButton p1ConfirmBtn;
    private JButton[] p1Btn = {p1m1, p1m2, p1m3, p1m4, p1m5, p1s1, p1s2, p1s3, p1s4, p1s5}, p2Btn = {p2m1, p2m2, p2m3, p2m4, p2m5, p2s1, p2s2, p2s3, p2s4, p2s5};
    private JButton[] p1SkillQBtn = {p1SkillQ1Btn, p1SkillQ2Btn, p1SkillQ3Btn};
    private JButton[] p2SkillQBtn = {p2SkillQ1Btn, p2SkillQ2Btn, p2SkillQ3Btn};
    public static boolean isP1Confirmed, isP2Confirmed;
    public static char[] p1SkillMoves, p2SkillMoves;
    public void logAppend(String s){
        guiLog.setText(guiLog.getText() + s);
    }

    public GUI_Menu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        guiLog.setEditable(false);
        this.setContentPane(menuGui);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1500, 700);
        this.setResizable(false);
        changePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnsPanel.isVisible()){
                btnsPanel.setVisible(false);}
                else btnsPanel.setVisible(true);
            }
        });

        for (JButton btn : p1Btn){
            btn.addActionListener(this::actionPerformed);
        }
        for (JButton btn : p2Btn){
            btn.addActionListener(this::actionPerformed);
        }
        p1ResetBtn.addActionListener(this::actionPerformed);
        p2ResetBtn.addActionListener(this::actionPerformed);
        p1ConfirmBtn.addActionListener(this::actionPerformed);
        p2ConfirmBtn.addActionListener(this::actionPerformed);
    }
    public void actionPerformed(ActionEvent e){
        JButton btn = (JButton)e.getSource();
        btn.setEnabled(false);
        // IF P1 : QUEUE P1
        int flag = 0;
        for(JButton b : p1Btn){
            if (b.equals(btn)) flag = 1;
        }
        for(JButton b: p2Btn){
            if(b.equals(btn)) flag = 2;
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
        if (btn.equals(p2ResetBtn)){
            p2SkillQ1Btn.setText("Skill Slot");
            p2SkillQ2Btn.setText("Skill Slot");
            p2SkillQ3Btn.setText("Skill Slot");
            for(JButton b : p2Btn){
                b.setEnabled(true);
            }
            btn.setEnabled(true);
        }

        //IF P1 BTN
        if (flag == 1){
            if (p1SkillQ1Btn.getText().charAt(0) == 'S' && p1SkillQ1Btn.getText().charAt(1) == 'k'){
                p1SkillQ1Btn.setText(btn.getText());
            }
            else if (p1SkillQ2Btn.getText().charAt(0) == 'S' && p1SkillQ2Btn.getText().charAt(1) == 'k'){
                p1SkillQ2Btn.setText(btn.getText());
            }
            else if (p1SkillQ3Btn.getText().charAt(0) == 'S' && p1SkillQ3Btn.getText().charAt(1) == 'k'){
                p1SkillQ3Btn.setText(btn.getText());
                for(JButton b : p1Btn){
                    b.setEnabled(false);
                }
            }
        }
        // IF P2 BTN
        else if (flag == 2){
            if (p2SkillQ1Btn.getText().charAt(0) == 'S' && p2SkillQ1Btn.getText().charAt(1) == 'k'){
                p2SkillQ1Btn.setText(btn.getText());
            }
            else if (p2SkillQ2Btn.getText().charAt(0) == 'S' && p2SkillQ2Btn.getText().charAt(1) == 'k'){
                p2SkillQ2Btn.setText(btn.getText());
            }
            else if (p2SkillQ3Btn.getText().charAt(0) == 'S' && p2SkillQ3Btn.getText().charAt(1) == 'k'){
                p2SkillQ3Btn.setText(btn.getText());
                for(JButton b : p2Btn){
                    b.setEnabled(false);
                }
            }
        }

        //IF CONFIRM
        if (btn.equals(p1ConfirmBtn)){
            int cnt = 0;
            for(JButton b: p1SkillQBtn){
                if (b.getText().charAt(0) == 'S' && b.getText().charAt(1) == 'k');
                else cnt += 1;
            }
            if (cnt == 3){
                for(JButton b : p1Btn){
                    b.setEnabled(false);
                }
                for(JButton b: p1SkillQBtn){
                    b.setEnabled(false);
                }
                p1ResetBtn.setEnabled(false);

                p1SkillMoves = new char[3];
                for(int i = 0; i < 3; i++){
                    String t = p1SkillQBtn[i].getText();
                    if (t.charAt(0) == 'S'){
                        //SKILL
                        p1SkillMoves[i] = t.charAt(1);
                    }
                    else{
                        //MOVES
                        p1SkillMoves[i] = t.charAt(0);
                    }
                }
                isP1Confirmed = true;
                System.out.printf("CONFIRM, %s\n", p1SkillMoves.toString());
            }
            else {
                System.out.println("PICK 3 SKILLS/MOVES");
                p1ConfirmBtn.setEnabled(true);
            }
        }


        else if (btn.equals(p2ConfirmBtn)){
            int cnt = 0;
            for(JButton b: p2SkillQBtn){
                if (b.getText().charAt(0) == 'S' && b.getText().charAt(1) == 'k');
                else cnt += 1;
            }
            if (cnt == 3){
                for(JButton b : p2Btn){
                    b.setEnabled(false);
                }
                for(JButton b: p2SkillQBtn){
                    b.setEnabled(false);
                }
                p2ResetBtn.setEnabled(false);

                p2SkillMoves = new char[3];
                for(int i = 0; i < 3; i++){
                    String t = p2SkillQBtn[i].getText();
                    if (t.charAt(0) == 'S'){
                        //SKILL
                        p2SkillMoves[i] = t.charAt(1);
                    }
                    else{
                        //MOVES
                        p2SkillMoves[i] = t.charAt(0);
                    }
                }
                isP2Confirmed = true;
                System.out.printf("CONFIRM, %s\n", p2SkillMoves);
            }
            else {
                System.out.println("PICK 3 SKILLS/MOVES");
                p2ConfirmBtn.setEnabled(true);
            }
        }
    }
    public char[] skillClicked(ActionEvent e){
        JButton btn = (JButton)e.getSource();
        String btnText = btn.getText();

        char[] s = {btnText.charAt(1),  btnText.charAt(2), btnText.charAt(3)};
        return s;
    }
    public void btnActive(){
        for(JButton b : p1Btn){
            b.setEnabled(true);
        }
        for(JButton b:p2Btn){
            b.setEnabled(true);
        }
        for(JButton b: p2SkillQBtn){
            b.setEnabled(true);
        }
        for(JButton b: p1SkillQBtn){
            b.setEnabled(true);
        }
        p1ResetBtn.setEnabled(true);
        p2ResetBtn.setEnabled(true);
        p1ConfirmBtn.setEnabled(true);
        p2ConfirmBtn.setEnabled(true);
    }
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        new GUI_Menu();
    }

}
