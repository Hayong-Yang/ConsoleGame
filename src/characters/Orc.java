package characters;

public class Orc extends Champion {
    public Orc(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name, int gameTurn) {
        super(maxHp, maxMp, power, defence, critical, exp, name, gameTurn);

    }

    @Override
    public void speak() {
        System.out.println(this.getName() + " 등장! 그르르..!  ");
    }

    @Override
    public void injured() {
        System.out.println(this.getName() + "이 공격받다. 쿠악! 강하다 인간..! ");
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
            this.setMaxHp(this.getMaxHp() + 30);
            this.setMaxMp(this.getMaxMp() + 10);
            this.setPower(this.getPower() + 3);
            this.setDefence(this.getDefence() + 5);
            this.setCritical(this.getCritical() + 2);

            this.setMaxExp(this.getMaxExp() + 100);
            this.setSkillPoint(this.getSkillPoint() + 1);
        }
    }// levelUp();



}
