package gameOptions;

import characters.*;
import main.Play;
import skills.*;

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
    }

    public Champion createEnemy(int randomNumber)
    {
        this.gameTurns = Play.gameTurns;
        Champion enemy = switch (randomNumber)
        {

            case 0 -> new Warrior(10, 100, 3, 5, 2, 0, "적군 전사", gameTurns);
            case 1 -> new Archer(10, 100, 4, 3, 3, 0, "적군 궁수", gameTurns);
            case 2 -> new Magician(10, 100, 6, 3, 2, 0, "적군 마법사", gameTurns);
            case 3 -> new Thief(10, 100, 3, 2, 5, 0, "적군 도적", gameTurns);
            default -> null;
        };
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
        this.enemy = createEnemy((int) (Math.random() * 4));
        System.out.println(enemy + " 가 상대합니다.");
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
                    if (!enemy.isAlive())
                    {
                        System.out.println("!!!!!! 700 !!!!!!!");
                        player.levelUp(700);
                        break outer;
                    }

                    System.out.println(enemy.getName() + "가 당했습니다." + enemy);
                    break;
                case 2:
                    if (this.player.getSkillList().isEmpty())
                    {
                        System.out.println("보유한 스킬이 없습니다.");
                        continue;
                    }
                    List<Skill> skills = this.player.getSkillsList();

                    System.out.println("사용할 스킬을 선택하세요:");
                    for (int i = 0; i < skills.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, skills.get(i));
                    }

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
            if (player.isAlive() && !enemy.isAlive())
            {
                System.out.println("700 얻음");
                player.levelUp(700);
            }

            int enemyChoice = (int) (Math.random() * 2);

            switch (enemyChoice)
            {
                case 0:
                    enemy.defaultAttack.attack(player);
                    player.injured();
                    System.out.println(player);
                case 1:
                    int randomSkill = (int) (Math.random() * 3);
                    enemy.getSkill(randomSkill).doSkill(enemy, player);
                    System.out.println(enemy.getName() + "가 " + enemy.getSkill(randomSkill).getName() + "을 사용했다!");
                    player.injured();
                    System.out.println(player);
            }
            if (!player.isAlive()) break;
            if (!enemy.isAlive())
            {
                System.out.println("700 얻음");
                player.levelUp(700);
            }

        }// end of while();
    }// end of playBattle();

}// end of class{};
