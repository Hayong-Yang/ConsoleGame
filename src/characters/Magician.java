package characters;

import skills.Attack;

public class Magician extends Champion
{
    //constructor
    public Magician(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name)
    {
        super(maxHp, maxMp, power, defence, critical, exp, name);
    }

    @Override
    public void speak() { System.out.println("대마법사 " + this.getName() + "님이 행차하신다!!!"); }

    @Override
    public void injured() { System.out.println("네가 감히 대 마법사 " + this.getName() + "님을 건드리다니!"); }

    public Attack defaultAttack = (target) -> { target.setHp(target.getHp() - this.getPower()); return target; };


    //rest: 마나(MP)**를 주요 자원으로 사용하는 직업이므로, rest() 메서드에서도 마나 회복 중심으로 설계
    public void rest() {
        int recoverHp = (int)(this.getMaxHp() * 0.15); // 체력은 15% 회복
        int recoverMp = (int)(this.getMaxMp() * 0.5);  // 마나는 50% 회복

        this.setHp(Math.min(this.getHp() + recoverHp, this.getMaxHp()));
        this.setMp(Math.min(this.getMp() + recoverMp, this.getMaxMp()));

        System.out.println(this.getName() + "이(가) 마력을 응축하며 조용히 휴식을 취합니다...");
        System.out.println("HP 회복: +" + recoverHp);
        System.out.println("MP 회복: +" + recoverMp);
    }

}// end of class{};
