package skills;

import characters.Champion;

public abstract class Skill
{
    private String name;
    private int damage;
    private int requiredMp;
    private int skillLevel;

    public Skill(String name, int damage, int requiredMp)
    {
        this.name = name;
        this.damage = damage;
        this.requiredMp = requiredMp;
        this.skillLevel = 1;
    }

    public abstract void doSkill(Champion player, Champion target);

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public int getRequiredMp()
    {
        return requiredMp;
    }

    public int getSkillLevel()
    {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel)
    {
        this.skillLevel = skillLevel;
    }

    public void setRequiredMp(int requiredMp)
    {
        this.requiredMp = requiredMp;
    }

    public void skillLevelUp(Champion player)
    {
        this.skillLevel++;
        this.damage += 5;
        this.requiredMp += 10;

        player.setSkillPoint( player.getSkillPoint() - 1);

        System.out.println(this.getName() + " level up! (" + this.getSkillLevel() + ")");
    }
  
} // class

