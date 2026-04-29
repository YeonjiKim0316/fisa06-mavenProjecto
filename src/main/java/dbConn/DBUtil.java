package dbConn;

import java.sql.*;

// 재사용 가능한 방식으로 코드 분리
public class DBUtil {

    // 무조건 프로그램이 시작되면서 실행
    static {
        // 1. JDBC 통역기(드라이버)를 받아옵니다.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    // 2. DB접속을 위한 객체를 만들어서 url, id, pw를 넘겨줍니다.
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://db명/fisa";
        String id = "아이디";
        String pw = "비밀번호";
        return DriverManager.getConnection(url, id, pw);
    }


    // 5. 자원 반납
    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }
}
