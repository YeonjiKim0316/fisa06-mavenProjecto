package org.example;

import dbConn.DBUtil;
import dbConn.Dept;
import lombok.HelloLombok;

import java.sql.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        HelloLombok lombok1 = new HelloLombok(1, "김연지", "123-45");
        System.out.println(lombok1.getNum());
        lombok1.setNum(1);
        System.out.println(lombok1.getNum());

        HelloLombok lombok2 = new HelloLombok(3, "김연지", "123-45");
        HelloLombok lombok3 = new HelloLombok(3, "김연지", "123-45");
        System.out.println(lombok3.toString()); // __repr__
        System.out.println(lombok2.equals(lombok3)); // 각 속성의 값을 따로따로 비교 true
        System.out.println(lombok2.hashCode()); // 값이 일치하는지를 hashCode()로 변환
        System.out.println(lombok3.hashCode()); // 값이 일치하는지를 hashCode()로 변환
                // hashcode() 원래는 HashMap 자료구조를 위해 각 메모리주소를 hash알고리즘으로 바꿔서 일치하는지 확인하는 메서드
        // lombok에서는 논리적으로 데이터 일치여부를 확인해서 같은 값이면 같은 값을 리턴하도록 재정의(내용이 같으면 ㄱ
        Connection conn = DBUtil.getConnection();

        // 3. 문장 실행해줄 객체
        Statement stmt = conn.createStatement();

        // 3-1. executeUpdate - Read를 제외한 모든 sql 명령어를 실행
        // Create
        String sql2 = "INSERT INTO dept VALUES (199, 'OPERATION', '김연지')";

        // Update
        // String sql2 = "UPDATE dept SET dname='OPERATION2' WHERE deptno=99";


        // DELETE
//            String sql2 = "DELETE FROM dept WHERE deptno=99";

        // 그 결과로 실제 영향을 끼친 row의 수를 리턴
        int rs2 = stmt.executeUpdate(sql2);
        System.out.println(rs2);



        // 3-2. excuteQuery() : select문(get method)
        String sql = "select * from dept";

        // 그 결과로 실제 영향을 받은 값 또는 영향을 미친 행의 수를 리턴해주는 ResultSet 객체
        // 실제 Result를 가지고 있는 객체
        /* 1. 커서(포인터)를 이동시키는 기능 next()
         * 2. 데이터를 리턴하는 기능 : getXxx(컬럼의 번호 or 컬럼 이름)
         * 				정수로 된 자료형의 컬럼 반환 : getInt(컬럼번호 or 컬럼명)
         * 				문자열로 된 자료형 컬럼 반환 : getString(컬럼번호 or 컬럼명)
         */
        // executeQuery - Read를 실행
        // 그 결과로 SELECT된 전체 행을 가져 리턴
        ResultSet rs = stmt.executeQuery(sql); // Get

        Dept dept = new Dept();

        // 4. DB에서 가져온 값으로 실제 동작을 수행
        while (rs.next()) {
            System.out.println(rs.getInt(1)); // deptno  컬럼 순번(SQL의 규칙대로 1부터 시작) 정수형으로 된 자료 컬럼을 출력
            System.out.println(rs.getString("deptno")); // 컬럼명으로 문자열로 된 자료형을 출력
            System.out.println(rs.getString("dname")); // 컬럼명으로 문자열로 된 자료 컬럼을 출력
        }



        // 5. 자원 반납 DBUtil.close()
        rs.close();
        stmt.close();
        conn.close();

    }
}