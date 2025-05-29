package main;

import characters.Champion;
import characters.Warrior;
import skills.Attack;

public class Play
{
    public static int gameTurn = 0;

    public static void main(String[] args)
    {
        Champion minsu = new Warrior(100, 100, 10, 100, 100, 100, "minsu", gameTurn);
        Champion hayong = new Warrior(100, 100, 100, 5, 100, 100, "hayong", gameTurn);

        minsu.defaultAttack.attack(hayong);
        System.out.println(hayong);
    }// main
} //class
