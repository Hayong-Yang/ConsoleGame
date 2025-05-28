package skills;

import characters.Champion;

public class FireBall extends Skill
{
    public FireBall()
    {
        super("Fireball", 11, 20);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - (player.getPower() * 0.25) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + player.getLevel() * 2));
    }
}