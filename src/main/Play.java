package main;

import characters.*;
import gameOptions.Battle;
import gameOptions.Hunting;
import gameOptions.Rest;
import gameOptions.Training;
import skills.Attack;

import java.util.Objects;
import java.util.Scanner;

public class Play
{
    public static Scanner scn = new Scanner(System.in);
    public static int gameTurns = 1;

    public static void main(String[] args)
    {

        System.out.println("류지 월드에 오신 것을 환영합니다...");
        System.out.println("----------------------------");
        System.out.println("");

        System.out.println("1. Warrior | 2. Thief | 3. Archer | 4. Magician");

        System.out.print("당신의 캐릭터를 선택하세요: ");
        int userChoice;

        select:
        while (true)
        {
            try
            {
                int temp = Integer.parseInt(scn.nextLine());
                if (temp >= 1 && temp <= 4)
                {
                    userChoice = temp;
                    break;
                } else
                {
                    System.out.println("1~4 사이의 숫자로 입력해주세요.");
                    continue select;
                }

            } catch (Exception e)
            {
                System.out.println("숫자로 입력해주세요. [1, 2, 3, 4]");
            }
        }


        System.out.print("닉네임을 정해주세요: ");
        String name = scn.nextLine();

        Champion player = null;

        switch (userChoice)
        {
            case 1 -> player = new Warrior(100, 100, 3, 5, 2, 0, name, gameTurns);
            case 2 -> player = new Thief(100, 100, 3, 2, 5, 0, name, gameTurns);
            case 3 -> player = new Archer(100, 100, 4, 3, 3, 0, name, gameTurns);
            case 4 -> player = new Magician(100, 100, 6, 2, 1, 0, name, gameTurns);
        }
        player.speak();
        System.out.println(player);

        //main logic
        Hunting hunting = new Hunting();
        Battle battle = new Battle(player, gameTurns);
        Training training = new Training();
        Rest rest = new Rest();


        while (player.isAlive())
        {
            System.out.println("day: " + gameTurns);
            System.out.println("당신의 여정을 선택하세요..");
            System.out.println("1. Hunting | 2. Battle | 3. Training | 4. Rest");
            int userChoice2 = Integer.parseInt(scn.nextLine());
            switch (userChoice2)
            {
                case 1 ->
                {
                    hunting.startBattle(player, gameTurns);
                    gameTurns++;
                }
                case 2 ->
                {
                    battle.playBattle(player);
                    gameTurns++;
                }
                case 3 ->
                {
                    training.train(player);
                    gameTurns++;
                }
                case 4 ->
                {
                    rest.rest(player);
                    gameTurns++;
                }
            }
            if (!player.isAlive())
            {
                System.out.printf("당신의 여정... %d일 패배하셨습니다... | %s", gameTurns, player);
                break;
            }

        }// end of while();

    }// main
} //class
