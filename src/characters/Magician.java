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

    @Override
    public void levelUp(int exp)
    {
        this.setExp(this.getExp() + exp);
        if (this.getExp() >= this.getMaxExp())
        {
            int rest = this.getMaxExp() - this.getExp();
            this.setExp(rest);

            this.setLevel(this.getLevel() + 1);
            this.setMaxHp(this.getMaxHp() + 15);
            this.setMaxMp(this.getMaxMp() + 25);
            this.setPower(this.getPower() + 6);
            this.setDefence(this.getDefence() + 2);
            this.setCritical(this.getCritical() + 1);

            this.setMaxExp(this.getMaxExp() + 100);
            this.setSkillPoint(this.getSkillPoint() + 1);
        }
    }// end of levelUp();

}// end of class{};
