package skills;

import characters.Champion;

public class ShadowStrike extends Skill {

    public ShadowStrike() {
        super("Shadow Strike", 35, 20);
    }

    @Override
    public void doSkill(Champion player, Champion target) {
        if (player.getMp() < this.getRequiredMp()) {
            System.out.println("마나가 부족하여 스킬을 사용하지 못했습니다.");
            return;
        }

        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.6 : 1.0;
        if (isCrit){
            System.out.println("⚡ Shadow Strike! 치명타 적중!");
        }

        int totalDamage = (int)((player.getPower() * 0.3) * this.getDamage() * multiplier - target.getDefence());
        System.out.printf("Shadow Strike를 사용하여 " + (isCrit ? "치명적인 " : "") + totalDamage + " 피해를 입혔습니다!");

        target.setHp((int)(target.getHp() - totalDamage));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

    }
}
