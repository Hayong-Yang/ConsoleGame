package skills;

import characters.Champion;

import java.util.Timer;
import java.util.TimerTask;

public class ExplosiveArrow extends Skill
{
    private int dot = 3;

    public int getDot()
    {
        return this.dot;
    }
    public void setDot(int dot)
    {
        this.dot = dot;
    }
    // constructor
    public ExplosiveArrow()
    {
        super("ExplosiveArrow", 18, 30);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.1 : 1.0;
        if (isCrit){
            System.out.println("죽음의 불길은 화살을 타고 온다!");
        }
        int totalDamage = (int) ((player.getPower() * 0.2) * this.getDamage() * multiplier - target.getDefence());
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp((int) (target.getHp() - totalDamage));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));
        target.setDotted(dot);

    }// end of doSkill();


}// end of class{};