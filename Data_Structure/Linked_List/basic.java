package Data_Structure.Linked_List;

import java.util.Arrays;
import java.util.LinkedList;

public class basic {
    public static void main(String[] args) {

        // 생성과 초기화 동시에 가능 (Head -> A -> B -> C)
        LinkedList<String> list = new LinkedList<String>(Arrays.asList("A", "B", "C"));

        // 가장 앞에 데이터 추가 (Head -> First -> A -> B -> C)
        list.addFirst("First");

        // 가장 뒤에 데이터 추가 (Head -> First -> A -> B -> C -> Last)
        list.addLast("Last");

        // index 2 중간 위치에 데이터 Middle 추가 (Head -> First -> A -> Middle -> B -> C -> Last)
        list.add(2, "Middle");

        // 각각의 값 삭제 또한 가능
        list.removeFirst();
        list.removeLast();
        list.remove(2);

        // 해당 값을 가지고 있는 인덱스 위치를 반환
        list.indexOf("B");

        // 뒤에서 부터 검색 (결과 값은 -1)
        list.lastIndexOf("D");

        // list 값에 A가 있는지 확인 (반환값 : True or False)
        list.contains("A");
    }
}
