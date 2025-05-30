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
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.6 : 1.0;

        if (isCrit) {
            System.out.println("방패로 내리찍기! 적을 잠시 멍하게 만들었습니다!");
        }

        int totalDamage = (int) ((player.getPower() * 0.3) * this.getDamage() * multiplier);
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp(target.getHp() - totalDamage);

        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));
    } // end of doSkill();
}
