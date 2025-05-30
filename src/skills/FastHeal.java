package skills;

import characters.Champion;

public class FastHeal extends Skill
{
    public FastHeal()
    {
        super("Slow Heal", 0, 5);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp(target.getHp() + (this.getSkillLevel() * 15));
        target.setMp(target.getMp() - this.getRequiredMp());
    }

}// end of class{};
