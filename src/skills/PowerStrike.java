package skills;

import characters.Champion;

public class PowerStrike extends Skill
{
    public PowerStrike()
    {
        super("PowerStrike", 8, 30);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - (player.getPower() * 0.4) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel()));
    }
}
