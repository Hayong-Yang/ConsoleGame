package characters;

public class Slime extends Champion{

    public Slime(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 스..ㄹ.라..임 ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 주르륵.. ");
    }

    public static void main(String[] args) {
        Slime s = new Slime(20,5,2,1,2,35,"슬라임");
        s.setLevel(1);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
} //class
