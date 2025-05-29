package characters;

public class Golem extends Champion {
    public Golem(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 인간 발견. 제거한다.  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 그륵..인간 강하다. ");
    }

    public static void main(String[] args) {
        Golem s = new Golem(5,5,5,5,5,270,"골렘");
        s.setLevel(5);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
}
