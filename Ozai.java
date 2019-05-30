package Avatar;

public class Ozai extends Fire {
    public Ozai(){
        System.out.println("OZAI SUMMONED !");
    }
    public Ozai(boolean isP1){
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
        skills.setDamage(0, 25);
        skills.setRequiredEnergy(0,15);
        skills.setRange(0,1,3,4,5,7);
        skills.setSkillName(0,"Fire ball");
    }
    public void skill2(){
        skills.setDamage(1, 15);
        skills.setRequiredEnergy(1,10);
        skills.setRange(1,0,1,2,3,4,5,6,7,8);
        skills.setSkillName(1,"Fire tornado");
    }
    public void skill3(){
        skills.setDamage(2,35);
        skills.setRequiredEnergy(2,20);
        skills.setRange(2,0,2,3,5,6,8);
        skills.setSkillName(2,"Fire slash");
    }
    public void skill4(){
        skills.setDamage(3,50);
        skills.setRequiredEnergy(3,40);
        skills.setRange(3,3,4,5);
        skills.setSkillName(3,"Plasma spray");
    }
    public void skill5(){
        skills.skill5();
    }
}

