package gameOptions;

import characters.*;
import skills.Attack;
import skills.Skill;

import java.util.*;

public class Battle
{
    private Champion player;
    private Champion enemy;
    private int gameTurns;

    public Champion getPlayer()
    {
        return player;
    }

    public void setPlayer(Champion player)
    {
        this.player = player;
    }

    public int getGameTurns()
    {
        return gameTurns;
    }

    public void setGameTurns(int gameTurns)
    {
        this.gameTurns = gameTurns;
    }

    //constructor
    public Battle(Champion player, int gameTurns)
    {
        this.player = player;
        this.gameTurns = gameTurns;
        System.out.println(player + " 가 결투장에 입장합니다.");
        this.enemy = createEnemy();
        System.out.println(enemy + " 가 상대합니다.");
    }

    public Champion createEnemy()
    {
        int gameTurns = this.getGameTurns();
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
    }// end of createEnemy();

    public int playBattle(Champion player)
    {
        String[] playerChoices = {"기본 공격", "스킬 선택", "도망 가기"};
        Scanner scn = new Scanner(System.in);

        outer:
        while (player.isAlive() && enemy.isAlive())
        {

            for (int i = 1; i <= playerChoices.length; i++)
            {
                System.out.printf("%s (%d) | ", playerChoices[i - 1], i);
            }

            int userChoice = Integer.parseInt(scn.nextLine());
            switch (userChoice)
            {
                case 1:
                    this.player.defaultAttack.attack(enemy);
                    System.out.println(enemy.getName() + "가 당했습니다." + enemy);
                    break;
                case 2:
                    if (this.player.getSkillList().size() == 0)
                    {
                        System.out.println("보유한 스킬이 없습니다.");
                        continue;
                    }
                    this.player.getSkillsList().forEach(System.out::println);
                    int skillChoice = Integer.parseInt(scn.nextLine());
                    this.player.getSkillsList().get(skillChoice - 1).doSkill(player, enemy);

                    System.out.println(enemy.getName() + "가 당했습니다." + enemy);
                    break;
                case 3:
                    System.out.println("적에게 겁을 먹어 줄행랑 도망칩니다.");
                    break outer;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
        return ++gameTurns;
    }// end of playBattle();

}// end of class{};
