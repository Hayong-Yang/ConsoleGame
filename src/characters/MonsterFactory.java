package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactory {

    public static Champion createRandomMonster(int gameTurn) {
        List<Champion> possibleMonsters = new ArrayList<>();

        // 기본 슬라임은 항상 포함
        possibleMonsters.add(new Slime(10, 5, 3, 1, 1, 200, "슬라임", gameTurn));

        // 5턴 이상이면 고블린 등장 가능
        if (gameTurn >= 3) {
            possibleMonsters.add(new Gobblin(13, 5, 4, 2, 2, 270, "고블린", gameTurn));
        }

        // 10턴 이상이면 오크도 등장
        if (gameTurn >= 8) {
            possibleMonsters.add(new Orc(25, 5, 6, 5, 3, 330, "오크", gameTurn));
        }

        // 15턴 이상이면 리자드맨
        if (gameTurn >= 13) {
            possibleMonsters.add(new Lizardman(20, 5, 7, 4, 5, 450, "리자드맨", gameTurn));
        }

        // 20턴 이상이면 스켈레톤, 골렘 추가
        if (gameTurn >= 18) {
            possibleMonsters.add(new Skeleton(22, 5, 9, 6, 6, 600, "스켈레톤", gameTurn));
            possibleMonsters.add(new Golem(30, 5, 7, 10, 4, 800, "골렘", gameTurn));
        }

        // 랜덤 선택
        Random rand = new Random();
        Champion monster = possibleMonsters.get(rand.nextInt(possibleMonsters.size()));

        // 게임 턴에 따라 레벨 조정
        int monsterLevel = Math.max(1, gameTurn / 3 + 1);
        monster.setLevel(monsterLevel);

        return monster;

    }
}