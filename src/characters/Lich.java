package characters;

public class Lich extends Champion {
    public Lich(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 가소로운 인간이구나!  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 따갑구나..!! ");
    }

    public static void main(String[] args) {
        Lich s = new Lich(5,5,5,5,5,5,"리치");
        s.setLevel(5);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
}
