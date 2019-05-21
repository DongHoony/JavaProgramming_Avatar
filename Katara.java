package Avatar;

public class Katara extends Water {
    public Katara(){
        System.out.println("KATARA SUMMONED !");
    }
    public Katara(boolean isP1){
        this();
        this.isP1 = isP1;
        this.activeSkills();
    }

    public void activeSkills(){
        this.skill1();
        this.skill2();
        this.skill3();
        this.skill4();
    }
    public void skill1(){
        skills.setDamage(0, 0);
        skills.setRequiredEnergy(0, 20);
        skills.setRange(0, 4);
        this.setHealth(this.getHealth()+20);
        skills.setSkillName(0, "Skill name");
    }
    public void skill2(){
        skills.setDamage(1, 35);
        skills.setRequiredEnergy(1, 35);
        skills.setRange(1, 2,4,6);
        skills.setSkillName(1, "Skill name");
    }
    public void skill3(){
        skills.setDamage(2, 50);
        skills.setRequiredEnergy(2, 35);
        skills.setRange(2, 1,3,4,5,7);
        skills.setSkillName(2, "Skill name");
    }
    public void skill4(){
        skills.setDamage(3, 30);
        skills.setRequiredEnergy(3, 30);
        skills.setRange(3, 0,2,4,6,8);
        skills.setSkillName(3, "Skill name");
    }
    public void skill5(){
        skills.skill5();
    }
}
