package org.example;

import lombok.HelloLombok;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
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
        // hashcode() HashMap 자료구조를 위해 각 메모리주소를 hash알고리즘으로 바꿔서 일치하는지 확인하는 메서드

    }
}