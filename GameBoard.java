package Avatar;
public class GameBoard {
    static boolean[][][] gameBoard;
    static int[][] earthCCBoard;
    Player p1, p2;
    public GameBoard(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        // 3th dimension : P1, P2, ROCK
        gameBoard = new boolean[3][4][3];
        earthCCBoard = new int[3][4];
        //Default position
        gameBoard[1][0][0] = true;
        gameBoard[1][3][1] = true;
    }
    public void earthBoardRefresh(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                if (earthCCBoard[i][j] > 0) {
                    earthCCBoard[i][j] -= 1;
                    if (earthCCBoard[i][j] == 0) {
                        gameBoard[i][j][2] = false;
                    }
                }
            }
        }
    }
    public void setPlayerPos(boolean isP1, int y, int x) {
        int[] curPos = this.getPlayerPos((isP1) ? true : false);
        gameBoard[curPos[0]][curPos[1]][(isP1) ? 0 : 1] = false;
        gameBoard[y][x][(isP1) ? 0 : 1] = true;
    }
    public int[] getPlayerPos(boolean isP1) {
        int[] pos = {-1, -1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameBoard[i][j][(isP1) ? 0 : 1]) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }
}
