package Avatar;

public class GiAso extends Air {
    public GiAso() {
        System.out.println("GIASO SUMMONED !");
    }

    public GiAso(boolean isP1) {
        this();
        this.isP1 = isP1;
        this.activeSkills();
        this.name = "Giaso";
    }

    public void activeSkills() {
        this.skill1();
        this.skill2();
        this.skill3();
        this.skill4();
        this.skill5();
    }

    public void skill1() {
        skills.setDamage(0, 20);
        skills.setRequiredEnergy(0, 30);
        skills.setRange(0, 0,2,3,4,6);
        skills.setSkillName(0, "날갯짓");

    }

    public void skill2() {
        skills.setDamage(1, 30);
        skills.setRequiredEnergy(1, 30);
        skills.setRange(1, 0, 1, 4, 7, 8);
        skills.setSkillName(1, "편서풍");
    }

    public void skill3() {
        skills.setDamage(2, 30);
        skills.setRequiredEnergy(2, 50);
        skills.setRange(2, 0, 2, 3, 4, 5, 6, 8);
        skills.setSkillName(2, "폭풍");
    }

    public void skill4() {
        skills.setDamage(3, 70);
        skills.setRequiredEnergy(3, 50);
        skills.setRange(3, 4);
        skills.setSkillName(3, "최후의 숨결");
    }

    public void skill5() {
        skills.setDamage(4, 0);
        skills.setSkillName(4, "Guard");
        skills.setRequiredEnergy(4, 15);
    }
}
