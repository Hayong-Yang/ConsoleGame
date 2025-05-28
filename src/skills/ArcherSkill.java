package skills;

import characters.Champion;

public class ArcherSkill extends Skill {
    public ArcherSkill(String name, int damage, int requiredMp) {
        super(name, damage, requiredMp);
    }

    @Override
    public Champion doSkill(Champion target) {
        return null;
    }
}
