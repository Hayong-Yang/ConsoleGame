create database consolegame;

use consolegame;

CREATE TABLE players (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nickname VARCHAR(50) NOT NULL,
  job ENUM('Warrior', 'Thief', 'Archer', 'Magician') NOT NULL,
  level INT DEFAULT 1,
  exp INT DEFAULT 0,
  hp INT DEFAULT 100,
  max_hp INT DEFAULT 100,
  mp INT DEFAULT 50,
  max_mp INT DEFAULT 50,
  power INT DEFAULT 5,
  defense INT DEFAULT 5,
  critical FLOAT DEFAULT 2,
  day INT DEFAULT 1
);

select * from players;
