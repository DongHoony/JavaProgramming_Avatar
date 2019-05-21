package Avatar;

public class Zuko extends Fire {
    public Zuko(){
        System.out.println("ZUKO SUMMONED !");
    }
    public Zuko(boolean isP1){
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
        //Fireball
        skills.setDamage(0, 25);
        skills.setRequiredEnergy(0, 15);
        skills.setRange(0, 1,3,4,5,7);
    }
    public void skill2(){
        //FlameWheel
        skills.setDamage(1, 40);
        skills.setRequiredEnergy(1, 30);
        skills.setRange(1, 3,4,5);
    }
    public void skill3(){
        //Flame
        skills.setDamage(2, 35);
        skills.setRequiredEnergy(2, 25);
        skills.setRange(2, 0,2,6,8);
    }
    public void skill4(){
        //FireFist
        skills.setDamage(3, 75);
        skills.setRequiredEnergy(3, 100);
        skills.setRange(3, 4);
    }
    public void skill5(){
        skills.skill5();
    }
}
