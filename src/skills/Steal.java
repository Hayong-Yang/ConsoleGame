package skills;

import characters.Champion;

public class Steal extends Skill {

    public Steal() {
        super("Steal", 12, 18);
    } // 기본 데미지 계수 12, MP 소모 18

    @Override
    public void doSkill(Champion player, Champion target) {
        // 크리티컬 확률 적용
        boolean isCrit = player.isCritical();
        double damageMultiplier = isCrit ? 2.0 : 1.0;

        // 최종 피해 계산 (공격력 * 0.3 * 스킬 데미지 계수)
        int damage = (int)((player.getPower() * 0.3) * this.getDamage() * damageMultiplier);
        target.setHp(target.getHp() - damage);

        // 마나 소모량 = 기본 MP + 스킬레벨 * 2
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

        System.out.println(player.getName() + "이(가) Shadow Strike를 사용하여 " +
                (isCrit ? "치명적인 " : "") + damage + " 피해를 입혔습니다!");
    }

}
