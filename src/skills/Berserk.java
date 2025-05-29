package skills;

import characters.Champion;

public class Berserk extends Skill
{
    public Berserk()
    {
        super("Berserk", 10, 25);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - (player.getPower() * 0.5) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel()));
        player.setHp(player.getHp() - 10);
        System.out.println(player.getName() + "님이 광폭화하여 HP 10을 소모했습니다!");
    }
}

