package characters;

import skills.Attack;

public class Archer extends Champion
{

    public Archer(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name, int gameTurn)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name, gameTurn);
    }

    @Override
    public void speak()
    {
        System.out.println("바람은 계산하는 것이 아니라 극복하는 것이다.");
    }

    @Override
    public void injured()
    {
        System.out.println("싸늘하다. 가슴에 화살이 날아와 꽂힌다...");
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
            this.setMaxMp(this.getMaxMp() + 15);
            this.setPower(this.getPower() + 4);
            this.setDefence(this.getDefence() + 3);
            this.setCritical(this.getCritical() + 3);

            this.setMaxExp(this.getMaxExp() + 100);
            this.setSkillPoint(this.getSkillPoint() + 1);
        }
    }// end of levelUp();

}// end of class{};




