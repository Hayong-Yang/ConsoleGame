package characters;

import skills.Attack;

public class Magician extends Champion
{
    //constructor
    public Magician(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name, int gameTurn)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name, gameTurn);
    }

    @Override
    public void speak() { System.out.println("대마법사 " + this.getName() + "님이 행차하신다!!!"); }

    @Override
    public void injured() { System.out.println("네가 감히 대 마법사 " + this.getName() + "님을 건드리다니!"); }


    public Attack defaultAttack = (target) -> { target.setHp(target.getHp() - this.getPower()); return target };

}// end of class{};
