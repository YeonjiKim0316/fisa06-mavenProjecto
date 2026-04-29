package lombok;

@ToString
@RequiredArgsConstructor // 한번 넣으면 바꾸지 않을 값은 필수로 받겠다
//@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter // getter들을 생성
public class HelloLombok {

    // 인스턴스 변수
    int num;
    String name;

    @ToString.Exclude // toString()으로 출력되는 값에서 숨김
    final String ssn;

//    public int getNum() {
//        return this.num;
//    }
}
