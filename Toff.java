package Avatar;

public class Toff extends Earth {
    public Toff(){
        System.out.println("TOFF SUMMONED !");
    }
    public Toff(boolean isP1){
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

    }
    public void skill2(){

    }
    public void skill3(){

    }
    public void skill4(){

    }
    public void skill5(){
        skills.skill5();
    }
}
