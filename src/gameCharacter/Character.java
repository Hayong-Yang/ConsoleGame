package gameCharacter;

import skills.Skill;
import game.Grid;

import java.util.ArrayList;

public abstract class Character {
    protected String name;
    protected int maxHp = 100;
    protected int hp;
    protected int maxMp = 100;
    protected int mp;
    protected int x, y; // 현재 위치
    protected boolean defending = false;

    public Character(String name, int hp, int mp, int x, int y) {
        this.name = name;
        this.hp = maxHp;
        this.mp = maxMp;
        this.x = x;
        this.y = y;
    }

    public abstract ArrayList<Skill> getUniqueSkills(); // 캐릭터들의 고유 스킬들 배열

    // 캐릭터들의 일반 스킬
    public void moveUp(Grid grid) {
        int newX = x - 1;
        int newY = y;
    }

    public void moveDown(Grid grid) {
        int newX = x + 1;
        int newY = y;
    }

    public void moveLeft(Grid grid) {
        int newX = x;
        int newY = y - 1;
    }

    public void moveRight(Grid grid) {
        int newX = x;
        int newY = y + 1;
    }

    public void defend() {
        defending = true;
    }

    public void restoreMp(int amount) {
            mp += amount;
        if (mp > 100) mp = 100;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void useMp(int amount) {
        if (mp >= amount) {
            mp -= amount;
        }
        if (mp < amount) {
            System.out.println("You don't have enough Mp!");
        }
        if (mp < 0) mp = 0;
    }

    boolean isAlive() {
        return hp > 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }


} // abstract class
