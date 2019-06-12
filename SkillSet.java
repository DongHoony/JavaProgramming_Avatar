package Avatar;

public class SkillSet {

    int[][] earthCCRange = {{-3, -3}, {-3, -3}, {-3, -3}, {-3, -3}, {-3, -3}};
    int[] burnTick = {0, 0, 0, 0, 0};
    int[] healAmount = {0, 0, 0, 0, 0};
    char[] airMoveAfterSkill = new char[5];
    boolean[][] range = new boolean[5][9];
    int[] damage = new int[5], requiredEnergy = new int[5];
    String[] skillName = new String[5];
    boolean isGuardOn = false;

    public SkillSet() {
        System.out.println("SKILLSET ENABLED");
    }

    public void setBurnTick(int skillNum, int b) {
        this.burnTick[skillNum] = b;
    }

    public void setHealAmount(int skillNum, int h) {
        this.healAmount[skillNum] = h;
    }

    public void setDamage(int skillNum, int d) {
        this.damage[skillNum] = d;
    }

    public void setRequiredEnergy(int skillNum, int e) {
        this.requiredEnergy[skillNum] = e;
    }

    public void setAirMoveAfterSkill(int skillNum, char moveToward) {
        this.airMoveAfterSkill[skillNum] = moveToward;
    }

    public int getDamage(int skillNum) {
        return this.damage[skillNum];
    }

    public int getRequiredEnergy(int skillNum) {
        return this.requiredEnergy[skillNum];
    }

    public void setSkillName(int skillNum, String name) {
        this.skillName[skillNum] = name;
    }

    public void setEarthCCRange(int skillNum, int y, int x) {
        this.earthCCRange[skillNum][0] = y;
        this.earthCCRange[skillNum][1] = x;
    }

    public void setRange(int skillNum, int... i) {
        range[skillNum] = new boolean[9];
        for (int k : i) {
            range[skillNum][k] = true;
        }
    }
}
