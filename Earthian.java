package Avatar;

public class Earthian extends Earth {

    public Earthian() {
        System.out.println("Earthian SUMMONED !");
    }

    public Earthian(boolean isP1) {
        this();
        this.isP1 = isP1;
        this.activeSkills();
        this.name = "Bumi";
    }

    public void activeSkills() {
        this.skill1();
        this.skill2();
        this.skill3();
        this.skill4();
        this.skill5();
    }

    public void skill1() {
        skills.setDamage(0, 30);
        skills.setRequiredEnergy(0, 30);
        skills.setRange(0, 2, 5, 8);
        skills.setEarthCCRange(0, 0, 0);
        skills.setSkillName(0, "지각변동");
    }

    public void skill2() {
        skills.setDamage(1, 20);
        skills.setRequiredEnergy(1, 40);
        skills.setRange(1, 0,1,2,3,4,5,6,7,8);
        skills.setSkillName(1, "지진파");
    }

    public void skill3() {
        skills.setDamage(2, 30);
        skills.setRequiredEnergy(2, 35);
        skills.setRange(2, 0, 1, 2, 6, 7, 8);
        skills.setSkillName(2, "여진");
    }

    public void skill4() {
        skills.setDamage(3, 70);
        skills.setRequiredEnergy(3, 50);
        skills.setRange(3, 4);
        skills.setSkillName(3, "그라운드 슬램");
    }

    public void skill5() {
        skills.setDamage(4, 0);
        skills.setSkillName(4, "Guard");
        skills.setRequiredEnergy(4, 15);
    }
}