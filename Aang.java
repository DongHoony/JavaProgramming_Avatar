package Avatar;

public class Aang extends Air {
    public Aang(){
        System.out.println("AANG SUMMONED !");
    }
    public Aang(boolean isP1){
        this();
        this.isP1 = isP1;
        this.activeSkills();
        this.name = "Aang";
    }

    public void activeSkills(){
        this.skill1();
        this.skill2();
        this.skill3();
        this.skill4();
        this.skill5();
    }

    public void skill1(){
    	/*skills.setDamage(0, 0);
        skills.setRequiredEnergy(0, -50);
        skills.setRange(0, 4);
        skills.setSkillName(0, "High Altitude Flight");
        */
        skills.setDamage(0, 20);
        skills.setRequiredEnergy(0, 30);
        skills.setRange(0, 1, 3, 4, 5, 7);
        skills.setSkillName(0, "Sylphid");       
        skills.setAirMoveAfterSkill(0, 'R');
    }
    public void skill2(){
    	skills.setDamage(1, 30);
        skills.setRequiredEnergy(1, 10);
        skills.setRange(1, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        skills.setSkillName(1, "Monsoon");
    }
    public void skill3(){
    	skills.setDamage(2, 30);
        skills.setRequiredEnergy(2, 40);
        skills.setRange(2, 0, 1, 2, 4, 6, 7, 8);
        skills.setSkillName(2, "Mesocyclone");
        //??? ??? ??????
    }
    public void skill4(){
    	skills.setDamage(3, 100);
        skills.setRequiredEnergy(3, 50);
        skills.setRange(3, 3, 4, 5);
        skills.setSkillName(3, "Vacuum");
    }
    public void skill5(){
        skills.setDamage(4, 0);
        skills.setSkillName(4, "Guard");
        skills.setRequiredEnergy(4, 15);
    }
}
