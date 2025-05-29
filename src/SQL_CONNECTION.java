import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQL_CONNECTION
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/java?serverTimezone=Asia/Seoul";
        String user = "root";
        String password = "tc4079tcmbc@";
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL connect successfully!");
            conn = DriverManager.getConnection(url, user, password);

//            String sql = "select * from words where bit_length() = ?";
//            String sql = "insert into words (eng, kor, lev) values (?, ?, ?)";

            String sql = "delete from words where eng = ?";
            pStmt = conn.prepareStatement(sql);

//            pStmt.setString(1, "apple");

//            pStmt.setString(1, "banana");
//            pStmt.setString(2, "바나나");
//            pStmt.setInt(3, 1);

//            pStmt.setString(1, "모르지롱");
//            pStmt.setInt(2, 2);
//            pStmt.setString(3, "apple");

            pStmt.setString(1, "apple");


            // 배열로 입력값 저장하고 반복문에서 인덱스로 돌려가면서 파라미터 전달하면 되지 않나?



            int count = pStmt.executeUpdate();

//            rs = pStmt.executeQuery();

            /* select
            while (rs.next())
            {
                String eng = rs.getString("eng");
                String kor = rs.getString("kor");
                int level = rs.getInt("lev");

                System.out.printf("%s: %s (level: %d)", eng, kor, level);
            }
             */
            System.out.println(count + "개 행이 처리되었습니다.");
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
//                rs.close();
                pStmt.close();
                conn.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        }// end of try/catch{};

    }// end of main();
}
