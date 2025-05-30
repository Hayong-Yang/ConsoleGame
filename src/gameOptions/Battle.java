package gameOptions;

import characters.*;
import main.Play;
import skills.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
    }

    public Champion createEnemy(int randomNumber)
    {
        this.gameTurns = Play.gameTurns;
        Champion enemy = switch (randomNumber)
        {

            case 0 -> new Warrior(50, 80, 3, 5, 2, 50 * gameTurns, "적군 전사", gameTurns);
            case 1 -> new Archer(35, 80, 4, 3, 3, 30 * gameTurns, "적군 궁수", gameTurns);
            case 2 -> new Magician(40, 80, 6, 3, 2, 80 * gameTurns, "적군 마법사", gameTurns);
            case 3 -> new Thief(30, 80, 3, 2, 5, 70 * gameTurns, "적군 도적", gameTurns);
            default -> null;
        };
        enemy.setLevel(gameTurns / 2 + 1);
        if (enemy instanceof Warrior)
        {
            enemy.addSkill(new Berserk());
            enemy.addSkill(new PowerStrike());
            enemy.addSkill(new ShieldBash());
        } else if (enemy instanceof Archer)
        {
            enemy.addSkill(new ArrowRain());
            enemy.addSkill(new ExplosiveArrow());
            enemy.addSkill(new PreciseShot());
        } else if (enemy instanceof Magician)
        {
            enemy.addSkill(new FastHeal());
            enemy.addSkill(new Meteor());
            enemy.addSkill(new FireBall());
        } else
        {
            enemy.addSkill(new ShadowStrike());
            enemy.addSkill(new FastHeal());
            enemy.addSkill(new PoisonDagger());
        }


        return enemy;
    }// end of createEnemy();

    public void playBattle(Champion player)
    {
        System.out.println();
        this.enemy = createEnemy((int) (Math.random() * 4));
        System.out.println(enemy + " 가 상대합니다.");
        System.out.println();
        String[] playerChoices = {"기본 공격", "스킬 선택", "도망 가기"};

        Scanner scn = new Scanner(System.in);

        outer:
        while (true)
        {

            for (int i = 1; i <= playerChoices.length; i++)
            {
                System.out.printf("%s (%d) | ", playerChoices[i - 1], i);
            }
            int userChoice;

            try
            {
                userChoice = Integer.parseInt(scn.nextLine());
            } catch (Exception e)
            {
                System.out.println("올바른 값을 입력해주세요.");
                continue;
            }
            switch (userChoice)
            {
                case 1:
                    this.player.defaultAttack.attack(enemy);
                    System.out.println(enemy);
                    break;
                case 2:
                    if (this.player.getSkillList().isEmpty())
                    {
                        System.out.println("보유한 스킬이 없습니다.");
                        continue;
                    }
                    AtomicInteger skillCount = new AtomicInteger(1);
                    this.player.getSkillsList().forEach(skill -> System.out.printf("%s (%d) | ", skill.getName(), skillCount.getAndIncrement()));
                    System.out.println();
                    System.out.print("스킬을 선택해주세요: ");
                    int skillChoice = Integer.parseInt(scn.nextLine());
                    System.out.println();
                    this.player.getSkillsList().get(skillChoice - 1).doSkill(player, enemy);
                    System.out.println(enemy);
                    System.out.println();

                    break;
                case 3:
                    System.out.println("적에게 겁을 먹어 줄행랑 도망칩니다.");
                    break outer;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
            if (!enemy.isAlive())
            {
                System.out.println();
                System.out.println(enemy.getExp() + "의 경험치를 획득하였습니다!");
                player.levelUp(enemy.getExp());
                break;
            }

            int enemyChoice = (int) (Math.random() * 2);

            switch (enemyChoice)
            {
                case 0:
                    enemy.defaultAttack.attack(player);
                    player.injured();
                    System.out.println(player);

                    break ;
                case 1:
                    int randomSkill = (int) (Math.random() * 3);
                    System.out.println();
                    System.out.println(enemy.getName() + "가 " + enemy.getSkill(randomSkill).getName() + "을 사용했다!");
                    enemy.getSkill(randomSkill).doSkill(enemy, player);
                    player.injured();
                    System.out.println();
                    System.out.println(player);
                    break ;
            }
            if (!player.isAlive()) break;

        }// end of while();
    }// end of playBattle();

}// end of class{};
