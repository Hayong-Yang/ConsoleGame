package skills;

import characters.Champion;

import java.awt.*;

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
        if (player.getMp() < this.getRequiredMp()) {
            System.out.println("마나가 부족하여 스킬을 사용하지 못했습니다.");
            return;
        }
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.6 : 1.0;
        if (isCrit){
            System.out.println("대마법 파이어볼을 너의 얼굴에 던져주마! 너는 영원히 불타오를 것이다~!");
        }
        int totalDamage = (int) ((player.getPower() * 0.25) * this.getDamage() * multiplier - target.getDefence());
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp((int)(target.getHp() - totalDamage));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));
    }// end of doSkill();
}// end of class{};