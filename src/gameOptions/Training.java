package gameOptions;

import characters.Champion;
import java.util.Scanner;

public final class Training {
    public enum TrainingType {
        STRENGTH,
        DEFENCE,
        AGILITY
    }

    private Training() {}

    public static void train(Champion champion) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== 훈련하기 메뉴 ===");
        System.out.println("1. 힘 훈련");
        System.out.println("2. 방어 훈련");
        System.out.println("3. 민첩 훈련");
        System.out.print("선택 ▶ ");

        int input;
        try {
            input = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return;
        }

        TrainingType type;
        switch (input) {
            case 1 -> type = TrainingType.STRENGTH;
            case 2 -> type = TrainingType.DEFENCE;
            case 3 -> type = TrainingType.AGILITY;
            default -> {
                System.out.println("잘못된 선택입니다.");
                return;
            }
        }
        train(champion, type);
    }

    public static void train(Champion c, TrainingType type) {

        final int POWER_INC    = 3;
        final int DEFENCE_INC  = 3;
        final int CRIT_INC     = 3;
        final int MAX_HP_INC   = 10;
        final int MAX_MP_INC   = 5;

        switch (type) {
            case STRENGTH -> {
                c.setPower(c.getPower() + POWER_INC);
                c.setMaxHp(c.getMaxHp() + MAX_HP_INC);
                System.out.printf("%s 힘 훈련 완료! 💪%n", c.getName());
            }
            case DEFENCE -> {
                c.setDefence(c.getDefence() + DEFENCE_INC);
                c.setMaxHp(c.getMaxHp() + MAX_HP_INC);
                System.out.printf("%s 방어 훈련 완료! 🛡️%n", c.getName());
            }
            case AGILITY -> {
                c.setCritical(c.getCritical() + CRIT_INC);
                c.setMaxMp(c.getMaxMp() + MAX_MP_INC);
                System.out.printf("%s 민첩 훈련 완료! 🗡️%n", c.getName());
            }
        }

        c.setSkillPoint(c.getSkillPoint() + 1);
        recover(c);
    }

    private static void recover(Champion c) {
        c.setHp(c.getMaxHp());
        c.setMp(c.getMaxMp());
    }
}

