package gameOptions;

import characters.Champion;
import characters.MonsterFactory;
import skills.Skill;

import java.util.Scanner;

public class Hunting {

    private final Scanner scanner = new Scanner(System.in);

    public void startBattle(Champion player, int gameTurn) {
        Champion monster = MonsterFactory.createRandomMonster(gameTurn); // 랜덤 몬스터 생성

        System.out.println("전투 시작!");
        System.out.println("플레이어: " + player.getName());
        player.speak();
        System.out.println("몬스터: " + monster.getName());
        monster.speak();

        while (player.isAlive() && monster.isAlive()) {
            // 상태 출력
            System.out.println("\n플레이어 상태 → " + player);
            System.out.println("몬스터 상태 → " + monster);

            // 1. 플레이어 턴
            System.out.println("\n[당신의 턴]");
            playerTurn(player, monster);
            if (!monster.isAlive()) break;

            // 2. 몬스터 턴
            System.out.println("\n[몬스터의 턴]");
            monsterTurn(monster, player);
        }

        // 3. 전투 결과
        if (player.isAlive()) {
            int gainedExp = monster.getExp(); // 몬스터의 보유 경험치 획득
            player.levelUp(gainedExp);
            System.out.println("승리! 경험치 +" + gainedExp);
        } else {
            System.out.println("패배했습니다...");
        }
    }

    private void playerTurn(Champion player, Champion monster) {
        System.out.println("1. 일반 공격  2. 스킬 사용");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                player.defaultAttack.attack(monster); // 직접 객체의 attack 사용
                monster.injured(); // 몬스터가 데미지를 입었을 때 대사 출력
            }
            case 2 -> {
                useSkill(player, monster);
            }
            default -> {
                System.out.println("잘못된 입력입니다. 일반 공격을 수행합니다.");
                player.defaultAttack.attack(monster); // 기본 공격
                monster.injured();
            }
        }
    }

    private void monsterTurn(Champion monster, Champion player) {
        monster.defaultAttack.attack(player);
        player.injured(); // 플레이어도 공격 당할 시 반응 출력
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
            System.out.println("잘못된 선택입니다. 턴이 소모되었습니다.");
            return;
        }

        Skill selectedSkill = player.getSkillsList().get(choice - 1);

        if (player.getMp() < selectedSkill.getRequiredMp()) {
            System.out.println("MP가 부족합니다. 턴이 소모되었습니다.");
            return;
        }

        selectedSkill.doSkill(player, target);
    }
}