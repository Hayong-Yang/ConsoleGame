package main;

import characters.Magician;
import skills.Attack;
import skills.FireBall;
import skills.Skill;

public class Play {
    public static void main(String[] args) {
        Magician magician = new Magician(100, 100, 10, 5, 0, 0, "minsu");
        Magician hayong = new Magician(100, 100, 10, 5, 0, 0, "minsu");

        Skill fireBall = new FireBall();

        fireBall.doSkill(magician, hayong);
        hayong.toString();

    }// main
} //class
