package Avatar;

public class Katara extends Water{
    public Katara() {
        System.out.println("물의 부족, 북극의 수호자 카타라!");
    }
    public Katara(boolean isP1){
        this();
        this.isP1 = isP1;
        this.activeSkills();
        this.name = "카타라";
    }

    public void activeSkills() {
        this.skill1();
        this.skill2();
        this.skill3();
        this.skill4();
        this.skill5();
    }
    public void skill1() {
        skills.setDamage(0, 0);
        skills.setRange(0, 4);
        skills.setSkillName(0, "치유의 물결");
        skills.setHealAmount(0, 30);
        skills.setRequiredEnergy(0, 20);
    }
    public void skill2() {
        skills.setDamage(1, 40);
        skills.setRequiredEnergy(1,20);
        skills.setRange(1,2,4,6);
        skills.setSkillName(1, "물의 감옥");
    }
    public void skill3() {
        skills.setDamage(2,25);
        skills.setRequiredEnergy(2, 30);
        skills.setRange(2,0,2,4,6,8);
        skills.setSkillName(2, "썰물");
    }
    public void skill4() {
        skills.setDamage(3, 25);
        skills.setRequiredEnergy(3, 30);
        skills.setRange(3, 1,3,4,5,7);
        skills.setSkillName(3, "해일");
    }
    public void skill5(){
        skills.setDamage(4, 0);
        skills.setSkillName(4, "가드");
        skills.setRequiredEnergy(4, 15);
    }

}
