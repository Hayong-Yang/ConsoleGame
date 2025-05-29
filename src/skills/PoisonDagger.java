package skills;

import characters.Champion;

public class PoisonDagger extends Skill {

    public PoisonDagger() {
        super("Poison Dagger", 8, 12);
    }

    @Override
    public void doSkill(Champion player, Champion target) {
        int baseDamage = (int)((player.getPower() * 0.2) * this.getDamage());
        int poisonBonus = 5 + this.getSkillLevel();  // 중독 추가 피해

        target.setHp(target.getHp() - (baseDamage + poisonBonus));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

        System.out.println(player.getName() + "이(가) Poison Dagger를 사용하여 " +
                baseDamage + " + " + poisonBonus + " 중독 피해를 입혔습니다!");
    }
}
