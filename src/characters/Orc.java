package characters;

public class Orc extends Champion {
    public Orc(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 그르르..!  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 쿠악! 강하다 인간..! ");
    }

    public static void main(String[] args) {
        Orc s = new Orc(5,5,5,5,5,87,"오크");
        s.setLevel(10);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main



}
