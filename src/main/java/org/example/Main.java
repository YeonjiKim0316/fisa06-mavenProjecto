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

        HelloLombok lombok2 = new HelloLombok("123-45");
        HelloLombok lombok3 = new HelloLombok(3, "김연지", "123-46");
        System.out.println(lombok3.toString()); // __repr__
    }
}