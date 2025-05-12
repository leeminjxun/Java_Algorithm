package Data_Structure.Stack;

import java.util.Stack;

public class basic {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        stack.add(0, "four"); // add 메서드를 호출함으로써 stack의 의미와 다른 특정 인덱스 값이 추가된다.

        // 이 때, pop 을 하게되면 four 가 아닌 three 값이 출력되게 된다.
        String str = stack.pop();
        System.out.println(str);
        System.out.println(str.equals("four"));
    }
}
