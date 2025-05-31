package characters;

import org.w3c.dom.events.EventTarget;
import skills.Berserk;
import skills.PowerStrike;
import skills.ShieldBash;
import java.util.Scanner;
import skills.Attack;


public class Warrior extends Champion
{
    public Warrior(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name, int gameTurn)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name, gameTurn);

        this.addSkill(new Berserk());
        this.addSkill(new PowerStrike());
        this.addSkill(new ShieldBash());
    }

    @Override
    public void speak()
    {
        System.out.println("전사 " + this.getName() + "가 전장에 나선다!");
    }

    @Override
    public void injured()
    {
        System.out.println("크윽... 아직 끝나지 않았다! 나는 전사 " + this.getName() + "다!");
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

            System.out.println("level이 올랐습니다! (" + this.getLevel() + ")");
        }
    }// levelUp();



}// end of class{};