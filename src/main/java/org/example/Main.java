package org.example;

import dbConn.DBUtil;
import dbConn.Dept;
import lombok.HelloLombok;

import java.sql.*;
import java.util.ArrayList;

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


        System.out.println("------------------ DBUtil을 활용한 MySQL DB 접근 ----------------------");
        // 어떤 sql문을 실행하면 결과를 가변적으로 담을 수 있는 ArrayList를 만들어서 달라지는 쿼리에 대한 결과를 담도록
        ArrayList<Dept> deptList = new ArrayList<>();

        Connection conn = DBUtil.getConnection(); // DB에 접속하는 객체를 재사용

        // 3. 문장 실행
        // 문장 실행해줄 객체
        Statement stmt = conn.createStatement();

        String sql = "select * from dept";

        ResultSet rs = stmt.executeQuery(sql); // Get, Set,

        // DB에서 가져온 값으로 실제 동작을 수행
        while (rs.next()) {
            int deptno = rs.getInt(1); // 컬럼 순번(SQL의 규칙대로 1부터 시작) 정수형으로 된 자료 컬럼을 출력
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");// 컬럼명으로 문자열로 된 자료 컬럼을 출력

            Dept dept = new Dept(deptno, dname, loc); // [deptno=10, dname=SALES, loc=NEW YORK]
            deptList.add(dept);

            System.out.println(dept);
        }

        System.out.println(deptList);

        DBUtil.close(conn, stmt, rs); // 자원을 한꺼번에 닫도록 재사용
    }
}