package characters;

public class Player {
    private int id;
    private String nickname;
    private String job;
    private int level, exp, hp, maxHp, mp, maxMp;
    private int atk, defense;
    private float critical;
    private int day;

    // 생성자, getter, setter 등 추가 (생략 가능)

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getExp() { return exp; }
    public void setExp(int exp) { this.exp = exp; }

    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }

    public int getMaxHp() { return maxHp; }
    public void setMaxHp(int maxHp) { this.maxHp = maxHp; }

    public int getMp() { return mp; }
    public void setMp(int mp) { this.mp = mp; }

    public int getMaxMp() { return maxMp; }
    public void setMaxMp(int maxMp) { this.maxMp = maxMp; }

    public int getAtk() { return atk; }
    public void setAtk(int atk) { this.atk = atk; }

    public int getDefense() { return defense; }
    public void setDefense(int defense) { this.defense = defense; }

    public float getCritical() { return critical; }
    public void setCritical(float critical) { this.critical = critical; }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }
}
