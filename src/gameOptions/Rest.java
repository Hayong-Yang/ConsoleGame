package gameOptions;

import characters.Champion;

public class Rest {

    public static void rest(Champion c) {
        String className = c.getClass().getSimpleName();
        int recoverHp;
        int recoverMp;

        switch (className) {
            case "Warrior":
                recoverHp = (int)(c.getMaxHp() * 0.35);
                recoverMp = (int)(c.getMaxMp() * 0.1);
                System.out.println(c.getName() + "이(가) 전장의 틈 속에서 숨을 돌립니다...");
                break;

            case "Thief":
                recoverHp = (int)(c.getMaxHp() * 0.25);
                recoverMp = (int)(c.getMaxMp() * 0.1);
                System.out.println(c.getName() + "이(가) 어둠 속에서 조용히 숨을 돌립니다...");
                break;

            case "Archer":
                recoverHp = (int)(c.getMaxHp() * 0.2);
                recoverMp = (int)(c.getMaxMp() * 0.3);
                System.out.println("바람이 잠잠해진 틈을 타 " + c.getName() + "이(가) 숨을 고릅니다...");
                break;

            case "Magician":
                recoverHp = (int)(c.getMaxHp() * 0.15);
                recoverMp = (int)(c.getMaxMp() * 0.5);
                System.out.println(c.getName() + "이(가) 마력을 응축하며 조용히 휴식을 취합니다...");
                break;

            default:
                // 기본값 (예: 모르는 캐릭터 타입일 경우)
                recoverHp = (int)(c.getMaxHp() * 0.2);
                recoverMp = (int)(c.getMaxMp() * 0.2);
                System.out.println(c.getName() + "이(가) 조용히 휴식을 취합니다...");
        }

        // 실제 회복 적용
        c.setHp(Math.min(c.getHp() + recoverHp, c.getMaxHp()));
        c.setMp(Math.min(c.getMp() + recoverMp, c.getMaxMp()));

        System.out.println("HP 회복: +" + recoverHp + " → 현재 HP: " + c.getHp());
        System.out.println("MP 회복: +" + recoverMp + " → 현재 MP: " + c.getMp());

    }
}
