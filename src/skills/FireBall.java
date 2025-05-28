package skills;

import characters.Champion;

public class FireBall extends Skill
{
    // constructor
    public FireBall()
    {
        super("Fireball", 11, 20);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - (player.getPower() * 0.25) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

    }// end of doSkill();
}// end of class{};