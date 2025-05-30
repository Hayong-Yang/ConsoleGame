package characters;

public class MonsterFactory {
    public static Champion createRandomMonster(int gameTurn) {
        int rand = (int) (Math.random() * 6); // 0~5

        return switch (rand) {
            case 0 -> new Slime(20,5,2,1,2,35,"슬라임", gameTurn);
            case 1 -> new Gobblin(20,5,2,1,2,35,"고블린", gameTurn);
            case 2 -> new Orc(20,5,2,1,2,35,"오크", gameTurn);
            case 3 -> new Lizardman(20,5,2,1,2,35,"리자드맨", gameTurn);
            case 4 -> new Skeleton(20,5,2,1,2,35,"스켈레톤", gameTurn);
            case 5 -> new Golem(20,5,2,1,2,35,"골렘", gameTurn);
            default -> throw new IllegalStateException("Unexpected value: " + rand);
        };
    }


} // class
