package Avatar;

public class Pakku extends Water{

	public Pakku() {
		System.out.println("물의 부족, 남극의 수호자 파쿠!");
	}

	public void activeSkills() {
		this.skill1();
		this.skill2();
		this.skill3();
		this.skill4();

	}
	public Pakku(boolean isP1){
		this();
		this.isP1 = isP1;
		this.activeSkills();
	}
	public void skill1() {
		skills.setDamage(0, 0);
		skills.setRange(0, 4);
		skills.setSkillName(0, "Healing Wave");
		skills.setRequiredEnergy(0, -20);

	}
	public void skill2() {
		skills.setDamage(1, 40);
		skills.setRange(1, 3,4,5);
		skills.setSkillName(1, "Ice Spear");
		skills.setRequiredEnergy(1, -20);
	}
	public void skill3() {
		skills.setDamage(2, 30);
		skills.setRange(2, 0,2,4,6,8);
		skills.setSkillName(0, "Blizzard");
		skills.setRequiredEnergy(0, -30);
	}
	public void skill4() {
		skills.setDamage(3, 0);
		skills.setRange(3, 4);
		skills.setSkillName(3, "Shield of Ice");
		skills.setRequiredEnergy(3, -20);
	}
	public void skill5(){
		skills.skill5();
	}

}
