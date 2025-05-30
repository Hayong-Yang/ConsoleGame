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
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.6 : 1.0;

        if (isCrit) {
            System.out.println("분노의 절규! 치명적인 광폭화 일격이 터집니다!");
        }

        int totalDamage = (int) ((player.getPower() * 0.5) * this.getDamage() * multiplier);
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp(target.getHp() - totalDamage);

        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

        player.setHp(player.getHp() - 10);
        System.out.println(player.getName() + "님이 광폭화하여 HP 10을 소모했습니다!");
    } // end of doSkill();
}

