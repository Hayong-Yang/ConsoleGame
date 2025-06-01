package characters;

import main.Play;
import skills.Attack;
import skills.Skill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Champion
{
    private int id;   // DB primary key

    // id getter/setter
    public int getId()          { return id; }
    public void setId(int id)   { this.id = id; }

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

    private int restDotCount = 0;
    private boolean isDotted = false;


    private ArrayList<Skill> skillsList = new ArrayList<>();

    public Champion(int maxHp, int maxMp, int power, int defence, int critical, int exp, String name, int gameTurn)
    {
        this.maxHp = maxHp + (int)(maxHp * gameTurn * 0.35);
        this.maxMp = maxMp + (int)(maxMp * gameTurn * 0.25);
        this.power = power + (int)(power * gameTurn * 0.3);
        this.defence = defence + (int)(defence * gameTurn * 0.11);
        this.critical = critical + (int)(critical * gameTurn * 0.1);
        this.exp = exp;
        this.maxExp = 100 * gameTurn;
        this.name = name;
        this.hp = this.maxHp;
        this.mp = this.maxMp;
        this.level = 1;
    }

    public Player toPlayer() {
        Player p = new Player();
        p.setNickname(this.getName());

        p.setId(this.id);

        // job 컬럼은 직업명 문자열인데, Champion의 구체 클래스를 통해 결정
        // 클래스 이름을 가져오거나, 하위 클래스에서 getJobName() 같은 메서드가 있다면 사용하세요
        p.setJob(this.getClass().getSimpleName());

        p.setLevel(this.getLevel());
        p.setExp(this.getExp());
        p.setHp(this.getHp());
        p.setMaxHp(this.getMaxHp());
        p.setMp(this.getMp());
        p.setMaxMp(this.getMaxMp());
        p.setAtk(this.getPower());       // power -> atk
        p.setDefense(this.getDefence()); // defence -> defense
        p.setCritical((float)this.getCritical()); // critical은 float이므로 형변환
        p.setDay(Play.gameTurns);

        return p;
    }

    public List<Skill> getSkillsList()
    {
        return skillsList;
    }
    public Skill getSkill(int idx) {return this.skillsList.get(idx); }

    public void addSkillsList(Skill skill)
    {
        this.skillsList.add(skill);
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

    public abstract void levelUp(int exp);

    public abstract void speak();

    public abstract void injured();

    public Attack defaultAttack = (Champion target) -> {
        int baseDamage = Math.max(this.getPower() - target.getDefence(), 0);
        int damage = this.isCritical() ? baseDamage * 2 : baseDamage;

        target.setHp(Math.max(target.getHp() - damage, 0));

        System.out.printf("💥 %s이(가) %s에게 %d의 피해를 입혔습니다.\n", this.getName(), target.getName(), damage);
    };

    public boolean isAlive()
    {
        return this.hp > 0;
    }

    public boolean isCritical()
    {
        int rand = (int) (Math.random() * 100) + 1;
        return (rand <= critical);
    }

    public int getSkillPoint()
    {
        return skillPoint;
    }

    public List<Skill> getSkillList()
    {
        return skillsList;
    }

    public void setDotted(int count)
    {
        this.restDotCount += count;
    }

    public void takeDottedDamage()
    {
        if (this.restDotCount == 0)
        {
            this.isDotted = false;
            System.out.println("중독이 해제되었습니다!");
            return;
        }
        this.hp -= (int) (this.hp * 0.05);
        this.restDotCount--;
        System.out.println("남은 중독 데미지: " + this.restDotCount);
    }

    @Override
    public String toString()
    {
        return "이름: " + name +
                ", Hp/MaxHp: " + hp + "/" + maxHp +
                ", Mp/MaxMp: " + mp + "/" + maxMp +
                ", 공격력: " + power +
                ", 방어력: " + defence +
                ", 크리티컬: " + critical + "%" +
                ", LV: " + level +
                ", EXP: " + exp + "/" + maxExp;
    }

    public void setSkillPoint(int skillPoint)
    {
        this.skillPoint = skillPoint;
    }

    public int getHp()
    {
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
