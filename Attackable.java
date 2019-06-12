package Avatar;

public interface Attackable {
    void attack(Player p, Player target, SkillSet s, int skillNum, GameBoard g, GUI_Menu gui);
}
