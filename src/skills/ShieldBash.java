package skills;

import characters.Champion;

public class ShieldBash extends Skill
{
    public ShieldBash()
    {
        super("ShieldBash", 6, 15);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - (player.getPower() * 0.3) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel()));
    }
}
