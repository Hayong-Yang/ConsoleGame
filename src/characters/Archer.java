package characters;

import skills.Attack;

public class Archer extends Champion{
    public Archer(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name);
    }

    @Override
    public void speak() {
        System.out.println("바람은 계산하는 것이 아니라 극복하는 것이다.");
    }

    @Override
    public void injured() {
        System.out.println("싸늘하다. 가슴에 화살이 날아와 꽂힌다...");

    }
    public Attack defaultAttack = (target) -> { target.setHp(target.getHp() - this.getPower()); return target; };


}// end of class{};




