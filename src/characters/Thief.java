package characters;

public class Thief extends Champion {

    public Thief(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name);
    }
//체력 80, 마나 50, 공격력 20, 방어력 5, 크리티컬 확률 30%
    @Override
    public void speak() {
        System.out.println("도적 " + getName() + ": 그림자처럼 조용히… 그리고 치명적으로.");
    }

    @Override
    public void injured() {
        System.out.println(getName() + "이(가) 빠르게 몸을 피했지만 피해를 입었습니다!");
    }


}
