package characters;

public class Dragon extends Champion {
    public Dragon(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name) {
        super(maxHp, maxMp, power, defence, critical, exp, name);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 쿠와아아!   ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 가소롭다 인간! ");
    }

    public static void main(String[] args) {
        Dragon s = new Dragon(5,5,5,5,5,5,"드래곤");
        s.setLevel(5);
        System.out.println(s);
        s.speak();
        s.injured();
    } // main
}
