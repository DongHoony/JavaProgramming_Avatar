package Avatar;

public abstract class Player implements Attackable {
    private int health;
    private int energy;
    private int ultCharge;
    private boolean isGuardOn;
    public boolean isP1;
    public boolean isDead;
    SkillSet skills;

    public Player(){
        this.isDead = false;
        this.health = 100;
        this.energy = 100;
        this.ultCharge = 0;
        this.isGuardOn = false;
        this.skills = new SkillSet();
    }

    public Player(boolean isP1) {
        this.isP1 = isP1 ? true : false;
    }

    public void attack(Player p, Player target, SkillSet s, int skillNum, GameBoard g){
        // ATTACK HAS TO BE PLAYED *AFTER* SKILL MODIFIED
        boolean isP1 = p.isP1;
        // USE REQUIRED ENERGY
        p.setEnergy(p.getEnergy() - s.requiredEnergy[skillNum]);
        int[][] dydxRange = {{-1, -1}, {-1, 0},{-1, 1},{0, -1},{0, 0},{0, 1},{1, -1},{1, 0},{1, 1}};
        // GET POSITION -> RANGE INDEX CHECK AND IF THERE'S OTHER PLAYER => ATTACK
        int[] playerPos = g.getPlayerPos(p.isP1? true : false);
        for (int i = 0; i < 9; i++){
            if (s.range[skillNum][i]){
                // SKILL RANGE BASED ON PLAYER POSITION
                int[] skillRange = {playerPos[0] + dydxRange[i][0], playerPos[1] + dydxRange[i][1]};
                // RANGE CHECK
                if (skillRange[0] >= 0 && skillRange[0] < 3 && skillRange[1] >= 0 && skillRange[1] < 4){
                    // PLAYER CHECK
                    if (g.gameboard[skillRange[0]][skillRange[1]][isP1?1:0]){
                        target.setHealth(target.getHealth() - p.skills.damage[skillNum]);
                        System.out.printf("DAMAGED %d!\n", p.skills.damage[skillNum]);
                        // DEATH CHECK
                        if (target.health <= 0){
                            System.out.printf("%s KILLED %s ! GAME OVER ! \n", (p.isP1) ? "P1" : "P2", (p.isP1) ? "P2": "P1");
                            target.isDead = true;
                        }
                        // ULT CHARGE

                    }
                }
            }
        }
    }



    public void setHealth(int h){
        this.health = h;
    }
    public int getHealth(){
        return this.health;
    }
    public void setEnergy(int e){
        this.energy = e;
    }
    public int getEnergy(){
        return this.energy;
    }
    public void setUltCharge(int u){
        this.ultCharge = u;
    }
    public int getUltCharge(){
        return this.ultCharge;
    }
    public void setGuardOn(boolean b){
        this.isGuardOn = b;
    }
    public boolean isGuardOn(){
        return this.isGuardOn;
    }


    public void move(GameBoard g, char moveToward){
        int[] pos = g.getPlayerPos(this.isP1);
        System.out.printf("Now pos is %d, %d\n", pos[0], pos[1]);
        switch(moveToward){
            case 'L':
                if (pos[1] == 0){
                    System.out.println("Cannot move more, continue");
                }
                else{
                    g.setPlayerPos(this,  this.isP1, pos[0], pos[1]-1);
                    System.out.printf("Moved %d to %d, %d\n", isP1?1:2, pos[0], pos[1]-1);
                }
                break;
            case 'R':
                if (pos[1] == 3){
                    System.out.println("Cannot move more, continue");
                }
                else{
                    g.setPlayerPos(this,  this.isP1, pos[0], pos[1]+1);
                    System.out.printf("Moved P%d to %d, %d\n", isP1?1:2, pos[0], pos[1]+1);
                }
                break;
            case 'U':
                if (pos[0] == 0){
                    System.out.println("Cannot move more, continue");
                }
                else{
                    g.setPlayerPos(this,  this.isP1, pos[0]-1, pos[1]);
                    System.out.printf("Moved %d to %d, %d\n", isP1?1:2, pos[0]-1, pos[1]);
                }
                break;
            case 'D':
                if (pos[0] == 2){
                    System.out.println("Cannot move more, continue");
                }
                else{
                    g.setPlayerPos(this,  this.isP1, pos[0]+1, pos[1]);
                    System.out.printf("Moved %d to %d, %d\n", isP1?1:2, pos[0]+1, pos[1]);
                }
                break;

        }
    }
//    public void moveLeft(GameBoard g){
//
//        int[] pos = g.getPlayerPos(this.isP1);
//        System.out.printf("Now pos is %d, %d\n", pos[0], pos[1]);
//        if (pos[1] == 0){
//            System.out.println("Cannot move more, continue");
//        }
//        else{
//            g.setPlayerPos(this,  this.isP1, pos[0], pos[1]-1);
//            System.out.printf("Moved %d to %d, %d\n", isP1?1:2, pos[0], pos[1]-1);
//        }
//    }
//    public void moveRight(GameBoard g){
//        int[] pos = g.getPlayerPos(this.isP1);
//        System.out.printf("Now pos is %d, %d\n", pos[0], pos[1]);
//        if (pos[1] == 3){
//            System.out.println("Cannot move more, continue");
//        }
//        else{
//            g.setPlayerPos(this,  this.isP1, pos[0], pos[1]+1);
//            System.out.printf("Moved P%d to %d, %d\n", isP1?1:2, pos[0], pos[1]+1);
//        }
//    }
//    public void moveUp(GameBoard g){
//        int[] pos = g.getPlayerPos(this.isP1);
//        System.out.printf("Now pos is %d, %d\n", pos[0], pos[1]);
//        if (pos[0] == 0){
//            System.out.println("Cannot move more, continue");
//        }
//        else{
//            g.setPlayerPos(this,  this.isP1, pos[0]-1, pos[1]);
//            System.out.printf("Moved %d to %d, %d\n", isP1?1:2, pos[0]-1, pos[1]);
//        }
//
//    }
//    public void moveDown(GameBoard g){
//        int[] pos = g.getPlayerPos(this.isP1);
//        System.out.printf("Now pos is %d, %d\n", pos[0], pos[1]);
//        if (pos[0] == 2){
//            System.out.println("Cannot move more, continue");
//        }
//        else{
//            g.setPlayerPos(this,  this.isP1, pos[0]+1, pos[1]);
//            System.out.printf("Moved %d to %d, %d\n", isP1?1:2, pos[0]+1, pos[1]);
//        }
}