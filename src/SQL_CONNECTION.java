import java.sql.*;

public class SQL_CONNECTION
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/consolegame?serverTimezone=Asia/Seoul";
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ MySQL 연결 성공!");
        } catch (SQLException e) {
            System.out.println("❌ 연결 실패: " + e.getMessage());
        }
    }
}
