package main;

import characters.Magician;
import skills.Attack;
import skills.FireBall;
import skills.Skill;

import javax.lang.model.util.SimpleTypeVisitor6;

public class Play
{
    public static void main(String[] args)
    {
        Magician magician = new Magician(100, 100, 10, 5, 100, 0, "minsu");
        Magician hayong = new Magician(100, 100, 10, 5, 0, 0, "hayong");

        Skill fireBall = new FireBall();

        fireBall.doSkill(magician, hayong);
        System.out.println(hayong);


    }// main
} //class
