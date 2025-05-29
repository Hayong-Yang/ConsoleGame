package characters;

import skills.Skill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Champion
{
    private final int skillListSize = 3;

    private int hp;
    private int mp;
    private int maxHp;
    private int maxMp;
    private int power;
    private int defence;
    private int critical;
    private int exp;
    private int maxExp;
    private int level;
    private String name;
    private int skillPoint = 0;

    private ArrayList<Skill> skillsList = new ArrayList<>();

    public Champion(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name)
    {
        this.maxHp = maxHp;
        this.maxMp = maxMp;
        this.power = power;
        this.defence = defence;
        this.critical = critical;
        this.exp = exp;
        this.maxExp = 100;
        this.name = name;
        this.hp = maxHp;
        this.mp = maxMp;
        this.level = 1;
    }

    public ArrayList<Skill> getSkillsList()
    {
        return skillsList;
    }

    public void setSkillsList(ArrayList<Skill> skillsList)
    {
        this.skillsList = skillsList;
    }

    public void addSkill(Skill skill)
    {
        Set<Skill> set = new HashSet<>(skillsList);
        if (skillsList.size() < skillListSize && set.add(skill))
        {
            skillsList.add(skill);
        }
    }

    public void removeSkill(Skill skill)
    {
        skillsList.remove(skill);
    }

    public void levelUp(int exp)
    {
        this.exp += exp;

        if (this.exp >= maxExp)
        {
            int rest = this.maxExp - this.exp;
            this.exp = rest;

            this.level++;
            this.maxHp += 10;
            this.maxMp += 5;
            this.power += 2;
            this.defence += 1;
            this.critical += 1;

            this.maxExp += 100;
            this.skillPoint ++;
        }
    }// end of levelUp();

    public abstract void speak();

    public abstract void injured();

    public boolean isAlive()
    {
        return this.hp > 0;
    }

    public boolean isCritical()
    {
        int rand = (int) (Math.random() * 100) + 1;
        return (rand <= critical);
    }

    public int getSkillPoint() { return skillPoint; }

    @Override
    public String toString() {
        return "이름: " + name + ", Hp/MaxHp: " + hp+"/"+maxHp+", Mp/MaxMp: "+mp+"/"+maxMp +", 공격력: " + power + ", LV: "+ level;
    }
    public void setSkillPoint(int skillPoint)
    {
        this.skillPoint = skillPoint;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getMp()
    {
        return mp;
    }

    public void setMp(int mp)
    {
        this.mp = mp;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public void setMaxHp(int maxHp)
    {
        this.maxHp = maxHp;
    }

    public int getMaxMp()
    {
        return maxMp;
    }

    public void setMaxMp(int maxMp)
    {
        this.maxMp = maxMp;
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(int power)
    {
        this.power = power;
    }

    public int getDefence()
    {
        return defence;
    }

    public void setDefence(int defence)
    {
        this.defence = defence;
    }

    public int getCritical()
    {
        return critical;
    }

    public void setCritical(int critical)
    {
        this.critical = critical;
    }

    public int getExp()
    {
        return exp;
    }

    public void setExp(int exp)
    {
        this.exp = exp;
    }

    public int getMaxExp()
    {
        return maxExp;
    }

    public void setMaxExp(int maxExp)
    {
        this.maxExp = maxExp;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

} //Character class
