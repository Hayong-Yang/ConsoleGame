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
        if (player.getMp() < this.getRequiredMp())
        {
            System.out.println("마나가 부족하여 스킬을 사용하지 못했습니다.");
            return;
        }
        target.setHp(target.getHp() + 10 * player.getPower());
        player.setMp(player.getMp() - this.getRequiredMp());
    }// end of doSkill();
}// end of class{};
