package skills;

import characters.Champion;

@FunctionalInterface
public interface Attack {
    public void attack(Champion target);
}
