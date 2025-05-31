package main;

import characters.*;
import gameOptions.*;
import skills.Attack;
import java.util.Objects;
import java.util.Scanner;

public class Play {

    public static Scanner scn = new Scanner(System.in);
    public static int gameTurns = 1;

    public static void main(String[] args) {

        System.out.println("류지 월드에 오신 것을 환영합니다...");
        System.out.println("----------------------------\n");

        System.out.println("1. Warrior | 2. Thief | 3. Archer | 4. Magician");
        System.out.print("당신의 캐릭터를 선택하세요: ");

        int userChoice;
        while (true) {
            try {
                int t = Integer.parseInt(scn.nextLine());
                if (t >= 1 && t <= 4) { userChoice = t; break; }
                System.out.println("1~4 사이의 숫자로 입력해주세요.");
            } catch (Exception e) {
                System.out.println("숫자로 입력해주세요. [1,2,3,4]");
            }
        }

        System.out.print("닉네임을 정해주세요: ");
        String name = scn.nextLine();

        // 캐릭터 생성
        Champion player = switch (userChoice) {
            case 1 -> new Warrior (100,100,3,5,2,0,name,gameTurns);
            case 2 -> new Thief   (100,100,3,2,5,0,name,gameTurns);
            case 3 -> new Archer  (100,100,4,3,3,0,name,gameTurns);
            case 4 -> new Magician(100,100,6,2,1,0,name,gameTurns);
            default -> throw new IllegalStateException();
        };
        player.speak();
        System.out.println(player);

        /* --- DB INSERT --- */
        int playerId = PlayerDAO.createPlayer(player.toPlayer());
        System.out.println("플레이어 생성 완료! ID: " + playerId);

        player.setId(playerId);   // ★ Champion 에 DB id 주입 ★

        /* main loop */
        Hunting hunting   = new Hunting();
        Battle  battle    = new Battle(player, gameTurns);
        Training training = new Training();
        Rest     rest     = new Rest();

        while (player.isAlive()) {
    System.out.printf("day: %d%n", gameTurns);
    System.out.println("당신의 여정을 선택하세요..");
    System.out.println("1. Hunting | 2. Battle | 3. Training | 4. Rest");

    int sel;
    try {
        sel = Integer.parseInt(scn.nextLine());

        switch (sel) {
            case 1 -> hunting.startBattle(player, gameTurns);
            case 2 -> battle.playBattle(player);
            case 3 -> training.train(player);
            case 4 -> rest.rest(player);
            default -> {
                System.out.println("1~4 입력!");
                continue; // 잘못된 입력이므로 턴 증가 X
            }
        }

        gameTurns++; // 유효한 선택에 대해서만 턴 증가

        /* DB 업데이트 */
        PlayerDAO.updatePlayer(player.toPlayer());

    } catch (Exception e) {
        System.out.println("숫자로 입력해주세요. [1~4]");
    }

    if (!player.isAlive()) {
        System.out.printf("당신의 여정... %d일 패배하셨습니다... | %s%n", gameTurns, player);
    }
}
    }
}
