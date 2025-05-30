package skills;

import characters.Champion;

public class ArrowRain extends Skill
{
    // constructor
    public ArrowRain()
    {
        super("ArrowRain", 25, 50);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.5 : 1.0;
        if (isCrit){
            System.out.println("나의 분노는 화살비가 되어 쏟아진다!");
        }
        int totalDamage = (int) ((player.getPower() * 0.20) * this.getDamage() * multiplier - target.getDefence());
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp((int) (target.getHp() - totalDamage));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

    }// end of doSkill();
}// end of class{};