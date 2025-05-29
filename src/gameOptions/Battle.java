package gameOptions;

import characters.*;

public class Battle
{
    private static int battleTurns = 0;
    private Champion player;
    private int gameTurns;

    public Battle(Champion player, int gameTurns)
    {
        this.player = player;
        this.gameTurns = gameTurns;
    }

    public Champion createEnemy()
    {
        int randomNumber = (int) (Math.random() * 4);

        Champion enemy = switch (randomNumber)
        {
            case 0 -> new Warrior(100, 100, 3, 5, 2, 0, "적군 전사", gameTurns);
            case 1 -> new Archer(100, 100, 4, 3, 3, 0, "적군 궁수", gameTurns);
            case 2 -> new Magician(100, 100, 6, 3, 2, 0, "적군 마법사", gameTurns);
            case 3 -> new Thief(100, 100, 3, 2, 5, 0, "적군 도적", gameTurns);
            default -> null;
        };
        return enemy;
    }

}// end of class{};
