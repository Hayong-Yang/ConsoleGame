package main;

import characters.Player;
import java.sql.*;

public class PlayerDAO {

    public static int createPlayer(Player p) {
        String sql = "INSERT INTO players (nickname, job, level, exp, hp, max_hp, mp, max_mp, power, defense, critical, day) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getNickname());
            ps.setString(2, p.getJob());
            ps.setInt(3, p.getLevel());
            ps.setInt(4, p.getExp());
            ps.setInt(5, p.getHp());
            ps.setInt(6, p.getMaxHp());
            ps.setInt(7, p.getMp());
            ps.setInt(8, p.getMaxMp());
            ps.setInt(9, p.getAtk());
            ps.setInt(10, p.getDefense());
            ps.setFloat(11, p.getCritical());
            ps.setInt(12, p.getDay());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // 자동 생성된 id 반환
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Player findPlayerById(int id) {
        String sql = "SELECT * FROM players WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Player p = new Player();
                    p.setId(rs.getInt("id"));
                    p.setNickname(rs.getString("nickname"));
                    p.setJob(rs.getString("job"));
                    p.setLevel(rs.getInt("level"));
                    p.setExp(rs.getInt("exp"));
                    p.setHp(rs.getInt("hp"));
                    p.setMaxHp(rs.getInt("max_hp"));
                    p.setMp(rs.getInt("mp"));
                    p.setMaxMp(rs.getInt("max_mp"));
                    p.setAtk(rs.getInt("power"));
                    p.setDefense(rs.getInt("defense"));
                    p.setCritical(rs.getFloat("critical"));
                    p.setDay(rs.getInt("day"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updatePlayer(Player p) {
        String sql = "UPDATE players " +
                "SET level=?, exp=?, hp=?, max_hp=?, mp=?, max_mp=?, " +
                "power=?, defense=?, critical=?, day=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt   (1, p.getLevel());
            ps.setInt   (2, p.getExp());
            ps.setInt   (3, p.getHp());
            ps.setInt   (4, p.getMaxHp());
            ps.setInt   (5, p.getMp());
            ps.setInt   (6, p.getMaxMp());
            ps.setInt   (7, p.getAtk());
            ps.setInt   (8, p.getDefense());
            ps.setFloat (9, p.getCritical());
            ps.setInt   (10, p.getDay());
            ps.setInt   (11, p.getId());   // ★ 반드시 0이 아닌 값 ★

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

