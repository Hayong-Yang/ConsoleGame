package game;

import gameCharacter.Character;

public class Grid {
    private Character[][] map;
    private int rows;
    private int cols;

    // 생성자: 격자의 행, 열 크기 지정
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.map = new Character[rows][cols];
    }
}

