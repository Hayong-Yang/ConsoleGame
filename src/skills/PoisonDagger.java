package skills;

import characters.Champion;

public class PoisonDagger extends Skill {

    public PoisonDagger() {
        super("Poison Dagger", 8, 12);
    }

    @Override
    public void doSkill(Champion player, Champion target) {
        if (player.getMp() < this.getRequiredMp()) {
            System.out.println("마나가 부족하여 스킬을 사용하지 못했습니다.");
            return;
        }
        int totalDamage = (int)((player.getPower() * 0.2) * this.getDamage());
        int poisonBonus = 5 + this.getSkillLevel();  // 중독 추가 피해

        System.out.println(player.getName() + "이(가) Poison Dagger를 사용하여 " +
                totalDamage + " + " + poisonBonus + " 중독 피해를 입혔습니다!");

        target.setHp(target.getHp() - (totalDamage + poisonBonus));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

    }
}
