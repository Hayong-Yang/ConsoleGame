package characters;

public class Skeleton extends Champion {
    public Skeleton(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 구워어!  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 삐그덕! 탈골된거 같다. ");
    }

    public static void main(String[] args) {
        Skeleton s = new Skeleton(5,5,5,5,5,200,"스켈레톤");
        s.setLevel(20);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
}
