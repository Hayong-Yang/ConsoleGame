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
        if (player.getMp() < this.getRequiredMp()) {
            System.out.println("마나가 부족하여 스킬을 사용하지 못했습니다.");
            return;
        }
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.6 : 1.0;
        if (isCrit){
            System.out.println("대마법 유성 폭발!~!");
        }
        int totalDamage = (int) ((player.getPower() * 0.22) * this.getDamage() * multiplier - target.getDefence());
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp(target.getHp() - totalDamage);
        player.setMp(player.getMp() - this.getRequiredMp());
    }// end of doSkill();
}
