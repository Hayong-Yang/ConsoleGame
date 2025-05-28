package characters;

public class Gobblin extends Champion {
    public Gobblin(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 캬오오!  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 키에엑!! 아프다 인간! ");
    }

    public static void main(String[] args) {
        Gobblin s = new Gobblin(5,5,5,5,5,5,"고블린");
        s.setLevel(5);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
}
