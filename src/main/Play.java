package main;

import characters.Champion;
import characters.Thief;
import characters.Warrior;
import gameOptions.Battle;
import skills.Attack;

public class Play
{
    public static int gameTurn = 0;

    public static void main(String[] args)
    {
        Champion minsu = new Thief(100, 100, 10, 5, 5, 0, "minsu", 0);

        Battle battle = new Battle(minsu, gameTurn);
        gameTurn = battle.playBattle(minsu);

        System.out.println("전투가 끝났습니다.");
        System.out.println(gameTurn);
    }// main
} //class
