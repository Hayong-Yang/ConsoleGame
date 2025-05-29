package skills;

import characters.Champion;

public class SlowHeal extends Skill
{
    public SlowHeal()
    {
        super("Slow Heal", 0, 5);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp(target.getHp() + (this.getSkillLevel() * 10));
        target.setMp(target.getMp() - this.getRequiredMp());
    }

}// end of class{};
