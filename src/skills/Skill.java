package skills;

import gameCharacter.Character;
import game.Grid;

public interface Skill {
    void execute(Character user, Character target, Grid grid);
    int getMpCost();
    String getName();
}
