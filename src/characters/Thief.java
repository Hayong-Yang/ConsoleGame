package characters;

import skills.Attack;

public class Thief extends Champion
{

    public Thief(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name, int gameTurn)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name, gameTurn);
    }

    //체력 80, 마나 50, 공격력 20, 방어력 5, 크리티컬 확률 30%
    @Override
    public void speak()
    {
        System.out.println("도적 " + getName() + ": 그림자처럼 조용히… 그리고 치명적으로.");
    }

    @Override
    public void injured()
    {
        System.out.println(getName() + "이(가) 빠르게 몸을 피했지만 피해를 입었습니다!");
    }

    @Override
    public void levelUp(int exp)
    {
        this.setExp(this.getExp() + exp);
        if (this.getExp() >= this.getMaxExp())
        {
            int rest = this.getMaxExp() - this.getExp();
            this.setExp(rest);

            this.setLevel(this.getLevel() + 1);
            this.setMaxHp(this.getMaxHp() + 20);
            this.setMaxMp(this.getMaxMp() + 10);
            this.setPower(this.getPower() + 3);
            this.setDefence(this.getDefence() + 2);
            this.setCritical(this.getCritical() + 5);

            this.setMaxExp(this.getMaxExp() + 100);
            this.setSkillPoint(this.getSkillPoint() + 1);
        }
    }// levelUp();

}// end of class{};
