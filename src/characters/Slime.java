package characters;

public class Slime extends Champion{

    public Slime(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 스..ㄹ.라..임 ");
    }

    public static void main(String[] args) {
        Slime s = new Slime(5,5,5,5,5,5,"슬라임");
        s.setLevel(5);
        System.out.println(s);
    }
}
