package Avatar;

public class Zuko extends Fire {
    public Zuko(){
        System.out.println("ZUKO SUMMONED !");
    }
    public Zuko(boolean isP1){
        this();
        this.isP1 = isP1;
        this.activeSkills();
        this.name = "Zuko";
    }
    public void activeSkills(){
        this.skill1();
        this.skill2();
        this.skill3();
        this.skill4();
        this.skill5();
    }
    public void skill1(){
        skills.setDamage(0, 25);
        skills.setRequiredEnergy(0,15);
        skills.setRange(0,1,3,4,5,7);
        skills.setSkillName(0,"Fire ball");
        skills.setBurnTick(0, 3);
    }
    public void skill2(){
        skills.setDamage(1, 40);
        skills.setRequiredEnergy(1,30);
        skills.setRange(1,3,4,5);
        skills.setSkillName(1,"Flame wheel");
    }
    public void skill3(){
        skills.setDamage(2,35);
        skills.setRequiredEnergy(2,25);
        skills.setRange(2,0,2,6,8);
        skills.setSkillName(2,"Flame throw");
    }
    public void skill4(){
        skills.setDamage(3,75);
        skills.setRequiredEnergy(3,50);
        skills.setRange(3,4);
        skills.setSkillName(3,"Fire fist");
    }
    public void skill5(){
        skills.setDamage(4, 0);
        skills.setSkillName(4, "Guard");
        skills.setRequiredEnergy(4, 15);
    }
}
