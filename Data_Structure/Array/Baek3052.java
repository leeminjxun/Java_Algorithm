package Data_Structure.Array;

// 백준 [3052] 문제 유형 = 1차원 배열

// 문제 : 나머지
// 두 자연수 A와 B 가 있을 때, A%%B 는 A를 B로 나눈 나머지이다.
// 수 10개를 입력 받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇개 있는지 출력하는 프로그램을 작성하라.


// 이 문제를 푸는 방식은 2가지로 나뉜다.
// 1. 배열을 사용하여 각각 값을 비교 / 2. HashSet 을 이용

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Baek3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        // 1. 배열을 사용하여 반복문을 이용한 방법
        /*int[] arr = new int[10];
        boolean check;
        int count = 0;

        for (int i = 0; i < 10; i++){
            arr[i] = Integer.parseInt(br.readLine()) % 42;
        } // 입력 받은 값을 42로 나머지 연산하여 배열 arr 에 저장한다.
        br.close();
        for (int i = 0; i < 10; i++) {
            check = false; // check 의 기본 값은 false
            for (int j = i + 1; j < arr.length; j++){ // arr[i] 를 i + 1 번째 arr 부터 비교한다. 작은 수 부터 비교하니 뒤의 값은 비교하지 않아도 된다.
                if(arr[i] == arr[j]) {
                    check = true; // 같은 값이 있을 경우 true 로 변경
                    break; // 같은 값이 있으면 더 이상 비교하지 않아도 되므로 반복문을 중단한다.
                }
            }
            if (check == false) count++; // 같은 값이 없을 경우에는 count 값을 + 1 한다.
        }
        System.out.println(count);*/

        // 2. HashSet 을 이용하는 방법
        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {
            hs.add(Integer.parseInt(br.readLine()) % 42);
        }
        br.close();
        System.out.println(hs.size());

    }
}

/*
HashSet 은 Collection 중 Set의 파생 클래스로, 몇가지 특징이 존재.
1. 중복되는 원소는 하나만 저장한다. --> 위 문제와 매우 적합
2. HashSet은 순서 개념이 없어, Collection.sort() 메소드 사용이 불가하다.

위의 문제에서 " 서로 다른 나머지의 개수를 구하라 " 의 뜻은 " 중복된 값을 제거하라 " 와 같다.
*/
