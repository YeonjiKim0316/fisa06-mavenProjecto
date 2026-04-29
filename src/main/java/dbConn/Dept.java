package dbConn;

import lombok.AllArgsConstructor;
import lombok.Data;


//@EqualsAndHashCode
//@ToString
//@RequiredArgsConstructor // 한번 넣으면 바꾸지 않을 값은 필수로 받겠다
//@NoArgsConstructor
//@Setter
//@Getter // getter들을 생성
@AllArgsConstructor
@Data
public class Dept {

    int deptno;
    String dname;
    String loc;

}
