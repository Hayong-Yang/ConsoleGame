package characters;

import skills.Attack;
import skills.Skill;

public class Warrior extends Champion implements Attack {

    private Skill equippedSkill;

    public Warrior(String name) {
        super(220,    35,    28,    10,       12,      0,  name);
    }

    @Override
    public void speak() {
        System.out.println(getName() + " : \"명예와 강철을 위해, 나는 오늘도 싸운다!\"");
    }

    @Override
    public Champion attack(Champion target) {
        if (!isAlive()) {
            System.out.println(getName() + "는(은) 쓰러져 있어 공격할 수 없습니다!");
            return target;
        }

        int dmg = Math.max(0, getPower() - target.getDefence());

        if (isCritical()) {
            System.out.println("★ CRITICAL HIT! ★");
            dmg *= 2;
        }

        int remainingHp = Math.max(0, target.getHp() - dmg);
        target.setHp(remainingHp);

        System.out.printf("%s가(이) %s에게 %d의 피해를 주었습니다. (남은 HP: %d)\n",
                getName(), target.getName(), dmg, remainingHp);

        return target;
    }

    public Champion useSkill(Skill skill, Champion target) {
        if (getMp() < skill.getRequiredMp()) {
            System.out.println("MP가 부족합니다!");
            return target;
        }
        setMp(getMp() - skill.getRequiredMp());
        return skill.doSkill(target);
    }

    public void gainExp(int amount) {
        setExp(getExp() + amount);
        while (getExp() >= getMaxExp()) {
            levelUp();
        }
    }

    private void levelUp() {
        setExp(getExp() - getMaxExp());
        setLevel(getLevel() + 1);
        setMaxExp(getMaxExp() + 50);

        setMaxHp(getMaxHp() + 25);
        setMaxMp(getMaxMp() + 6);
        setPower(getPower() + 4);
        setDefence(getDefence() + 3);

        setHp(getMaxHp());
        setMp(getMaxMp());

        System.out.printf("=== LEVEL UP! %s는(은) Lv.%d이(가) 되었습니다! ===\n",
                getName(), getLevel());
    }

    public Skill getEquippedSkill() {
        return equippedSkill;
    }

    public void setEquippedSkill(Skill equippedSkill) {
        this.equippedSkill = equippedSkill;
    }
}
