package characters;

import skills.Attack;

public class Warrior extends Champion
{
    public Warrior(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name);
    }

    @Override
    public void speak() { System.out.println("전사 " + this.getName() + "가 전장에 나선다!"); }

    @Override
    public void injured() { System.out.println("크윽... 아직 끝나지 않았다! 나는 전사 " + this.getName() + "다!"); }

    public Attack defaultAttack = (target) -> { target.setHp(target.getHp() - this.getPower()); return target; };



}// end of class{};