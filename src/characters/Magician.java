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
    public void speak()
    {
        System.out.println("대마법사 " + this.getName() + "님이 행차하신다!!!");
    }

    @Override
    public void injured()
    {
        System.out.println("네가 감히 대 마법사 " + this.getName() + "님을 건드리다니!");
    }

    @Override
    public void levelUp(int exp) {
        this.setExp(this.getExp() + exp);

        while (this.getExp() >= this.getMaxExp()) {
            // 현재 경험치에서 다음 레벨까지 필요 경험치 차감
            this.setExp(this.getExp() - this.getMaxExp());

            // 레벨 증가 및 능력치 상승
            this.setLevel(this.getLevel() + 1);
            this.setMaxHp(this.getMaxHp() + 20);
            this.setMaxMp(this.getMaxMp() + 30);
            this.setPower(this.getPower() + 6);
            this.setDefence(this.getDefence() + 3);
            this.setCritical(this.getCritical() + 1);
            this.setSkillPoint(this.getSkillPoint() + 1);

            // 다음 레벨의 필요 경험치 재계산
            int nextMaxExp = 100 + 100 * (this.getLevel() - 1);
            this.setMaxExp(nextMaxExp);

            // 출력
            System.out.println("level이 올랐습니다! (" + this.getLevel() + ")" + this);
        }
    }


}// end of class{};
