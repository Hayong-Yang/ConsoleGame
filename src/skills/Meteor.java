package skills;

import characters.Champion;

public class Meteor extends Skill
{
    // constructor
    public Meteor()
    {
        super("Meteor", 17, 55);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int)(target.getHp() - (player.getPower() * 0.5) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 4));
    }
}
