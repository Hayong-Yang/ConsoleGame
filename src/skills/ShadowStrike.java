package skills;

import characters.Champion;

public class ShadowStrike extends Skill {

    public ShadowStrike() {
        super("Shadow Strike", 35, 20);
    }

    @Override
    public void doSkill(Champion player, Champion target) {
        if (!target.isAlive()) {
            System.out.println(target.getName() + "는 이미 쓰러졌습니다.");
            return;
        }

        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 2.0 : 1.0;
        int damage = (int)((player.getPower() * 0.3) * this.getDamage() * multiplier);

        target.setHp(target.getHp() - damage);

        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

        System.out.println(player.getName() + "이(가) Shadow Strike를 사용하여 " +
                (isCrit ? "치명적인 " : "") + damage + " 피해를 입혔습니다!");
    }
}
