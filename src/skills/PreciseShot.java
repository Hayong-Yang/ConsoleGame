package skills;

import characters.Champion;

public class PreciseShot extends Skill
{
    // constructor
    public PreciseShot()
    {
        super("PreciseShot", 8, 15);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        boolean isCrit = player.isCritical();
        double multiplier = isCrit ? 1.3 : 1.0;
        if (isCrit){
            System.out.println("굉장히 따끔할 거야~");
        }
        int totalDamage = (int) ((player.getPower() * 0.20) * this.getDamage() * multiplier - target.getDefence());
        System.out.printf("데미지 %d가 들어갔습니다 효과는 굉장했다!\n", totalDamage);

        target.setHp((int) (target.getHp() - totalDamage));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));

    }// end of doSkill();
}// end of class{};