package Avatar;

public class Toff extends Earth{

    public Toff() {
        System.out.println("흙의 왕국, 왕국의 수호자 토프!");
    }
    public Toff(boolean isP1){
        this();
        this.isP1 = isP1;
        this.activeSkills();
        this.name = "토프";
    }
    public void activeSkills() {
        this.skill1();
        this.skill2();
        this.skill3();
        this.skill4();
        this.skill5();
    }
    public void skill1() {
        skills.setDamage(0, 20);
        skills.setRange(0,0,1,2,6,7,8);
        skills.setEarthCCRange(0, 0, 0);
        skills.setSkillName(0, "지진");
        skills.setRequiredEnergy(0, 30);
    }
    public void skill2() {
        skills.setDamage(1, 25);
        skills.setRange(1, 1,2,4,5,7,8);
        skills.setSkillName(1, "진흙 분사");
        skills.setRequiredEnergy(1, 20);
    }
    public void skill3() {
        skills.setDamage(2, 30);
        skills.setRange(2, 1,2,5,6,7,8);
        skills.setSkillName(2, "바위술사의 벽");
        skills.setRequiredEnergy(2, 25);
    }
    public void skill4() {
        skills.setDamage(3, 40);
        skills.setRange(3, 1,3,4,5,7);
        skills.setSkillName(3, "진흙 분쇄");
        skills.setRequiredEnergy(3, 30);
    }

    public void skill5(){
        skills.setDamage(4, 0);
        skills.setSkillName(4, "가드");
        skills.setRequiredEnergy(4, 15);
    }

}



