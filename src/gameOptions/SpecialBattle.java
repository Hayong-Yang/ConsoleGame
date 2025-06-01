package gameOptions;

import characters.Champion;
import characters.Troll;
import characters.Lich;
import characters.Dragon;
import characters.Ryuzi;
import skills.Skill;

import java.util.Scanner;

public class SpecialBattle {

    private final Scanner scanner = new Scanner(System.in);

    public void fight(Champion player, int gameTurn) {
        // 예시 몬스터 설정
        Champion boss = switch (gameTurn) {
            case 10 -> new characters.Troll(25, 25, 7, 6, 5, 550, "대족장 트롤", gameTurn);
            case 15 -> new characters.Lich(22, 40, 9, 4, 6, 700, "죽음의 해골 리치", gameTurn);
            case 20 -> new characters.Dragon(40, 50, 10, 8, 7, 1000, "암흑의 본드래곤", gameTurn);
            case 25 -> new characters.Ryuzi(55, 100, 11, 12, 10, 2000, "코리아 류지", gameTurn);
            default -> null;
        };

        if (boss == null) {
            System.out.println("잘못된 게임 턴입니다.");
            return;
        }
        // 특수 보스 레벨 설정
        int bossLevel = Math.max(1, gameTurn / 5 + 5);  // 예: 10턴이면 레벨 3, 25턴이면 레벨 6
        boss.setLevel(bossLevel);

        System.out.println(" 특수 전투 개시! 보스: " + boss.getName());
        player.speak();
        boss.speak();

        while (player.isAlive() && boss.isAlive()) {
            System.out.println("\n 당신의 상태 → " + player);
            System.out.println(" 보스의 상태 → " + boss);

            // 1. 플레이어 턴
            System.out.println("\n[당신의 턴]");
            playerTurn(player, boss);
            if (!boss.isAlive()) break;

            // 2. 보스 턴
            System.out.println("\n[보스의 턴]");
            bossTurn(boss, player);
        }

        // 3. 결과 처리
        if (player.isAlive()) {
            int gainedExp = boss.getExp();
            player.levelUp(gainedExp);

            switch (boss.getName()) {
                case "대족장 트롤" -> System.out.println("트롤: 크억... 내... 고기... 어디... 가져가지 마라...");
                case "죽음의 해골 리치" -> System.out.println("리치: 이 몸은... 죽지... 않는... 자...인데...");
                case "암흑의 본드래곤" -> System.out.println("드래곤: 영원... 히... 사라지는... 기분이다...");
                case "코리아 류지" -> System.out.println("류지: 어.. 그럼 다음주에 뵙겠습니다..!");
                default -> System.out.println(" ???: 알 수 없는 존재가 쓰러졌습니다...");
            }

            System.out.println(" 승리! 경험치 +" + gainedExp);
        } else {
            System.out.println(" 패배했습니다... 류지 월드가 과제로 뒤덮히다....");
        }
    }

    private void playerTurn(Champion player, Champion monster) {
        System.out.println("1. 일반 공격  2. 스킬 사용");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                player.defaultAttack.attack(monster);
                monster.injured();
            }
            case 2 -> {
                useSkill(player, monster);
            }
            default -> {
                System.out.println("잘못된 입력입니다. 일반 공격으로 대체됩니다.");
                player.defaultAttack.attack(monster);
                monster.injured();
            }
        }
    }

    private void bossTurn(Champion boss, Champion player) {
        boss.defaultAttack.attack(player);
        player.injured();
    }

    private void useSkill(Champion player, Champion target) {
        if (player.getSkillsList().isEmpty()) {
            System.out.println("스킬이 없습니다. 일반 공격으로 대체됩니다.");
            player.defaultAttack.attack(target);
            return;
        }

        System.out.println("사용할 스킬을 선택하세요:");
        for (int i = 0; i < player.getSkillsList().size(); i++) {
            Skill skill = player.getSkillsList().get(i);
            System.out.printf("%d. %s (MP:%d, Lv:%d, DMG:%d)\n",
                    i + 1, skill.getName(), skill.getRequiredMp(), skill.getSkillLevel(), skill.getDamage());
        }

        int choice = scanner.nextInt();

        if (choice < 1 || choice > player.getSkillsList().size()) {
            System.out.println("잘못된 선택입니다. 턴이 소모됩니다.");
            return;
        }

        Skill selectedSkill = player.getSkillsList().get(choice - 1);

        if (player.getMp() < selectedSkill.getRequiredMp()) {
            System.out.println("MP가 부족합니다. 턴이 소모됩니다.");
            return;
        }

        selectedSkill.doSkill(player, target);
    }
}