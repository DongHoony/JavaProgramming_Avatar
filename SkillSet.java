package Avatar;

public class SkillSet {

    int[] healAmount = {0, 0, 0, 0, 0};
    boolean[][] range = new boolean[5][9];
    int[] damage = new int[5], requiredEnergy = new int[5];
    String[] skillName = new String[5];

    public SkillSet(){
        System.out.println("SKILLSET ENABLED");
    }

    public void setHealAmount(int skillNum, int h){ this.healAmount[skillNum] = h; }
    public void setDamage(int skillNum, int d){
        this.damage[skillNum] = d;
    }
    public void setRequiredEnergy(int skillNum, int e){
        this.requiredEnergy[skillNum] = e;
    }

    public int getDamage(int skillNum){
        return this.damage[skillNum];
    }
    public int getRequiredEnergy(int skillNum){
        return this.requiredEnergy[skillNum];
    }
    public void setSkillName(int skillNum, String name){this.skillName[skillNum] = name;}

    public void setRange(int skillNum, int... i){
        range[skillNum] = new boolean[9];
        for(int k : i){
            range[skillNum][k] = true;
        }
    }

    public void guard(Player p, GameBoard g){

    }

    public void skill1(){}
    public void skill2(){}
    public void skill3(){}
    public void skill4(){}
    public void skill5(){
        //GUARD
        this.setDamage(4, 0);
        this.setRequiredEnergy(4, -15);
        this.setRange(4, 4);

    }

}
