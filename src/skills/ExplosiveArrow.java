package skills;

import characters.Champion;

import java.util.Timer;
import java.util.TimerTask;

public class ExplosiveArrow extends Skill
{
    // constructor
    public ExplosiveArrow()
    {
        super("ExplosiveArrow", 18, 30);
    }

    @Override
    public void doSkill(Champion player, Champion target)
    {
        target.setHp((int) (target.getHp() - (player.getPower() * 0.20) * this.getDamage()));
        player.setMp(player.getMp() - (this.getRequiredMp() + this.getSkillLevel() * 2));


        int dotDamage = 3;      // 한 번당 피해량
        int repeat = 3;         // 몇 번 반복할지
        int intervalMs = 2000;  // 간격: 1초

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                if (count >= repeat || target.getHp() <= 0) {
                    timer.cancel();
                    System.out.println("지속 피해 종료");
                    return;
                }
                target.setHp(target.getHp() - dotDamage);
                System.out.println("지속 피해 " + dotDamage + " → 남은 체력: " + target.getHp());
                count++;
            }

        };

        timer.scheduleAtFixedRate(task, 1000, intervalMs);//1초후 시작

        }// end of doSkill();


}// end of class{};