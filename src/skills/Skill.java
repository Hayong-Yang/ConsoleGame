package skills;

import characters.Character;

public abstract class Skill {
    private String name;
    private int damage;
    private int requiredMp;

    public Skill(String name, int damage, int requiredMp) {
        this.name = name;
        this.damage = damage;
        this.requiredMp = requiredMp;
    }

    public abstract Character doSkill(Character target);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRequiredMp() {
        return requiredMp;
    }

    public void setRequiredMp(int requiredMp) {
        this.requiredMp = requiredMp;
    }
} // class
