package main;

import characters.*;
import gameOptions.Battle;
import gameOptions.Hunting;
import gameOptions.Rest;
import skills.Attack;

import java.util.Scanner;

public class Play
{
    public static int gameTurn = 0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int day=1;

//        직업선택
        System.out.println("직업을 선택하세요");
        System.out.println("1.전사 2.궁수 3.마법사 4.도적 ");
        int input = sc.nextInt();

        Champion player = switch (input) {
            case 1 -> new Warrior(120, 100, 4, 4, 2, 0, "전사", 0);
            case 2 -> new Archer(100, 100, 5, 3, 3, 0, "궁수", 0);
            case 3 -> new Magician(90, 120, 6, 2, 2, 0, "마법사", 0);
            case 4 -> new Thief(100, 100, 4, 2, 5, 0, "도적", 0);
            default -> throw new IllegalArgumentException("잘못된 선택입니다.");
        };

        Hunting hunting = new Hunting();
        Battle battle = new Battle(player,0);

        boolean playing = true;

        while (playing) {
            System.out.println("\n===== " + day + "일차 아침입니다. =====");
            System.out.println("무엇을 하시겠습니까?");
            System.out.println("1. 사냥하기");
            System.out.println("2. 대전하기");
            System.out.println("3. 휴식하기");
            System.out.println("4. 게임 종료");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    hunting.startBattle(player);
                    day++;
                }
                case 2 -> {
                    Champion enemy = battle.createEnemy();
                    System.out.println("⚔️ 대전 상대로 " + enemy.getName() + "이(가) 등장했습니다!");

                    hunting.startBattle(player, enemy);
                    day++;
                }
                case 3 -> {
                    Rest.rest(player);
                    day++;
                }
                case 4 -> {
                    System.out.println("게임을 종료합니다.");
                    playing = false;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
            }
        }

    }// main
} //class
