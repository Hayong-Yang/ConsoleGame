package main;

import characters.Champion;
import characters.Magician;
import characters.Warrior;
import gameOptions.Hunting;
import skills.Attack;
import skills.FireBall;

public class Play
{
    public static int gameTurn = 0;

    public static void main(String[] args)
    {
        int gameTurn = 1;

        // 플레이어 생성
        Champion player = new Magician(60, 100, 5, 2, 1, 0, "킹민수", gameTurn);

        // 스킬 등록
        player.addSkill(new FireBall());

        // 사냥 로직
        Hunting hunting = new Hunting();

        while (player.isAlive()) {
            System.out.println("========== [현재 턴: " + gameTurn + "] ==========");
            hunting.startBattle(player, gameTurn);
            gameTurn++;
        }

        System.out.println("\n💀 킹민수가 쓰러졌습니다... 게임 오버!");
    }// main
} //class
