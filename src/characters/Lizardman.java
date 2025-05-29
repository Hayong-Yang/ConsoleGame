package characters;

public class Lizardman extends Champion{
    public Lizardman(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 키리리릭!  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 키에엑! 아프다! ");
    }

    public static void main(String[] args) {
        Lizardman s = new Lizardman(5,5,5,5,5,130,"리자드맨");
        s.setLevel(15);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
}

