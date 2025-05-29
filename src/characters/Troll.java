package characters;

public class Troll extends Champion{
    public Troll(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 크르르르...!  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 크아악..! ");
    }

    public static void main(String[] args) {
        Troll s = new Troll(5,5,5,5,5,5,"트롤");
        s.setLevel(5);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
}
