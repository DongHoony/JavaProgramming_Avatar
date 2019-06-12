package Avatar;

public class Ozai extends Fire {
    public Ozai(){
        System.out.println("OZAI SUMMONED !");
    }
    public Ozai(boolean isP1){
        this();
        this.isP1 = isP1;
        this.activeSkills();
        this.name = "Ozai";
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
        skills.setRequiredEnergy(0,30);
        skills.setRange(0,1,3,4,5,7);
        skills.setSkillName(0,"파이어 볼");
    }
    public void skill2(){
        skills.setDamage(1, 20);
        skills.setRequiredEnergy(1,40);
        skills.setRange(1,0,1,2,3,4,5,6,7,8);
        skills.setSkillName(1,"파이어 토네이도");
    }
    public void skill3(){
        skills.setDamage(2,25);
        skills.setRequiredEnergy(2,30);
        skills.setRange(2,0,2,3,5,6,8);
        skills.setSkillName(2,"파이어 슬래쉬");
    }
    public void skill4(){
        skills.setDamage(3,20);
        skills.setRequiredEnergy(3,30);
        skills.setRange(3,3,4,5);
        skills.setBurnTick(3, 3);
        skills.setSkillName(3,"플라즈마 분사");
    }
    public void skill5(){
        skills.setDamage(4, 0);
        skills.setSkillName(4, "Guard");
        skills.setRequiredEnergy(4, 15);
    }
}

