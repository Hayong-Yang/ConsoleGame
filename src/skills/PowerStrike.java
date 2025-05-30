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
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.6 : 1.0;

        if (isCrit) {
            System.out.println("강철의 일격! 적의 약점을 정확히 찔렀습니다!");
        }

        int totalDamage = (int) ((player.getPower() * 0.4) * this.getDamage() * multiplier);
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp(target.getHp() - totalDamage);

        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));
    } // end of doSkill();
}
