package skills;

import characters.Champion;

@FunctionalInterface
public interface Attack {
    public Champion attack(Champion target);
}
