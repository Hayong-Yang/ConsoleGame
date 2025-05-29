q# 🏱️ 텍스트 RPG 게임 설계

## 🎮 게임 주요 시스템

- **직업**: 전사, 도적, 마법사, 궁수
- **행동 선택지**:
    1. 사낭하기
    2. 대전하기
    3. 훈련하기
    4. 휴식하기 *(HP, MP 회복)*
    5. 정비 *(장비 장착 / 한 턴 소모 X)*

- **게임 종료 조건**:
    - 마지막 보스 처치
    - HP 0 (사망)

---

## 👤 Character 클래스

```java
public abstract class Character {
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

    public Character(int hp, int mp, int power, int defence, int critical, int exp, int level, String name) {
        // 초기화
    }

    public abstract void speak();
    public boolean isAlive() { return this.hp > 0; }
    public boolean isCritical() {
        // 크리트컬 확률 체크
    }

    // getter & setter
}
```

---

## ⚔️ 공격 인터페이스

```java
@FunctionalInterface
interface Attack {
    public Character attack(Character target);
}
```

---

## 💥 스킬 시스템

```java
public abstract class Skill {
    protected int damage;
    protected int mp;
    protected String name;

    public abstract Character doSkill(Character target);

    // getter & setter
}
```

---

## 🔁 행동 클래스들

```java
public class Hunting { ... }      // 사낭
public class Battle { ... }       // 대전
public class Training { ... }     // 훈련
public class Rest { ... }         // 휴식
public class Equipment { ... }    // 정비
```

---

## 📜 게임 진행 화력

1. 캐릭터 생성 (이름, 직업 선택)
2. 내 정보 출력
3. 게임 반복 진행:
    - `Day` 출력
    - 랜덤 이벤트 발생 유무 결정
    - 행동 선택지 제시 (1~5)
    - 결과 출력

---

## 📈 기본 능력치 & 성장

### 초기 능력치

- `HP`: 100
- `MP`: 100
- `Power`: 10
- `Defence`: 5
- `Critical`: 10
- `Exp`: 100  
  → 레벨업 필요 경험치 *1.1씩 증가  
  (5레벨: 161, 10레벨: 259, 15레벨: 417, 20레벨: 672, 25레벨: 1082)

### 직업별 레벨업 성장치

| 직업     | HP   | MP   | Power | Defence | Critical |
|----------|------|------|-------|---------|----------|
| 전사     | +30  | +10  | +3    | +5      | +2       |
| 도적     | +25  | +15  | +3    | +2      | +5       |
| 궁수     | +20  | +15  | +4    | +3      | +3       |
| 마법사   | +15  | +25  | +6    | +2      | +1       |

---

## 👹 몬스터 정보

### 일반 몬스터

| 이름       | 등장 레벨 |
|------------|------------|
| 슬라임     | 1          |
| 고블린     | 5          |
| 오크       | 10         |
| 리자드맨   | 15         |
| 스켈레톤   | 20         |
| 골렘       | 25         |

### 특수 몬스터 (보스\ae4c)

- **트롤**
    - 체력 회복
    - 대지 강타
- **리치**
    - 해골 소환
    - 영혼 마법탄
    - 저주
- **드래곤**
    - 감아치기
    - 드래곤 피어
    - 화염브래스 

### 몬스터 스킬 요조

| 몬스터     | 스킬 이름            |
|------------|------------------|
| 오크       | 돌진               |
| 리자드맨   | 찌르기              |
| 스켈레톤   | 뼈마디 던지기          |
| 골렘       | 손바닥치기            |
| 트롤       | 체력회복, 대지강타       |
| 리치       | 해골소환, 영혼마법탄, 저주  |
| 드래곤     | 감아치기, 드래곤피어, 브래스 |

---