package characters;

import skills.Attack;
import skills.FastHeal;
import skills.PoisonDagger;
import skills.ShadowStrike;

public class Thief extends Champion
{

    public Thief(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name, int gameTurn)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name, gameTurn);
        addSkill(new ShadowStrike());     // 그림자 타격
        addSkill(new PoisonDagger());     // 독 단검
        addSkill(new FastHeal());
    }


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
    public void levelUp(int exp) {
        this.setExp(this.getExp() + exp);

        while (this.getExp() >= this.getMaxExp()) {
            // 현재 경험치에서 다음 레벨까지 필요 경험치 차감
            this.setExp(this.getExp() - this.getMaxExp());

            this.setLevel(this.getLevel() + 1);
            this.setMaxHp(this.getMaxHp() + 20);
            this.setMaxMp(this.getMaxMp() + 10);
            this.setPower(this.getPower() + 3);
            this.setDefence(this.getDefence() + 2);
            this.setCritical(this.getCritical() + 5);

            // 다음 레벨의 필요 경험치 재계산
            int nextMaxExp = 100 + 100 * (this.getLevel() - 1);
            this.setMaxExp(nextMaxExp);

            System.out.println("level이 올랐습니다! (" + this.getLevel() + ")" + this);
        }
    }// levelUp();

}// end of class{};
