package skills;

import characters.Champion;

public class PreciseShot extends Skill
{
    // constructor
    public PreciseShot()
    {
        super("PreciseShot", 8, 15);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - (player.getPower() * 0.20) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

    }// end of doSkill();
}// end of class{};