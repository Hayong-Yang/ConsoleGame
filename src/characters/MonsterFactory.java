package characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterFactory {

    public static Champion createRandomMonster(int gameTurn) {
        List<Champion> possibleMonsters = new ArrayList<>();

        // 기본 슬라임은 항상 포함
        possibleMonsters.add(new Slime(20, 5, 5, 1, 2, 35, "슬라임", gameTurn));

        // 5턴 이상이면 고블린 등장 가능
        if (gameTurn >= 5) {
            possibleMonsters.add(new Gobblin(30, 5, 10, 2, 5, 40, "고블린", gameTurn));
        }

        // 10턴 이상이면 오크도 등장
        if (gameTurn >= 10) {
            possibleMonsters.add(new Orc(55, 5, 15, 10, 10, 50, "오크", gameTurn));
        }

        // 15턴 이상이면 리자드맨
        if (gameTurn >= 15) {
            possibleMonsters.add(new Lizardman(45, 2, 20, 5, 20, 60, "리자드맨", gameTurn));
        }

        // 20턴 이상이면 스켈레톤, 골렘 추가
        if (gameTurn >= 20) {
            possibleMonsters.add(new Skeleton(50, 5, 30, 8, 15, 80, "스켈레톤", gameTurn));
            possibleMonsters.add(new Golem(80, 5, 25, 10, 10, 100, "골렘", gameTurn));
        }

        // 랜덤 선택
        Random rand = new Random();
        return possibleMonsters.get(rand.nextInt(possibleMonsters.size()));
    }
}