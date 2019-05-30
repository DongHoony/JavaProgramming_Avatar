package Avatar;
public class GiAso extends Air {
    public GiAso(){
        System.out.println("GIASO SUMMONED !");
    }

    public GiAso(boolean isP1){
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

        skills.setDamage(0, 20);
        skills.setRequiredEnergy(0, -20);
        skills.setRange(0, 1, 3, 4, 5, 7);
        skills.setSkillName(0, "Wingbeat");

    }
    public void skill2(){
        skills.setDamage(1, 40);
        skills.setRequiredEnergy(1, -30);
        skills.setRange(1, 0, 1,  4,  7, 8);
        skills.setSkillName(1, "Westery");
    }
    public void skill3(){
        skills.setDamage(2, 30);
        skills.setRequiredEnergy(2, -40);
        skills.setRange(2, 0,  2, 3, 4 ,5, 6, 8);
        skills.setSkillName(2, "Tornado");
    }
    public void skill4(){
        skills.setDamage(3, 100);
        skills.setRequiredEnergy(3, -50);
        skills.setRange(3,  4);
        skills.setSkillName(3, "Whisper of Wind");
    }
    public void skill5(){
        skills.skill5();
    }
}
