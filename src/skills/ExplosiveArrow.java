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
        target.setHp((int) (target.getHp() - (player.getPower() * 0.20) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));
        target.setDotted(dot);

    }// end of doSkill();


}// end of class{};