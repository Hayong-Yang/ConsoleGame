package skills;

import characters.Champion;

public class ArrowRain extends Skill
{
    // constructor
    public ArrowRain()
    {
        super("ArrowRain", 25, 50);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - Math.max((target.getDefence() - (10 * player.getLevel() + (player.getPower() * 0.20) * this.getDamage())), 0)));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

    }// end of doSkill();
}// end of class{};