package example.day13;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Step2 {
    public static void main(String[] args) {

        // 1. 이진 트리
        TreeSet<Integer> scores = new TreeSet<>();
            // Set 인터페이스 에는 Tree 자료구조의 메소드가 없다.
        // 2.
        scores.add( 23 );    scores.add( 10 );
        scores.add( 48 );   scores.add( 15 );
        scores.add( 7 );    scores.add( 22 );
        scores.add( 56 );
        // 3.
        System.out.println("scores = " + scores);
        // 4. 순회
        scores.forEach( score -> {  System.out.println("score = " + score);   });
        // 5. 트리 관련 메소드 제공
        System.out.println(" 가장 낮은 점수,가장 왼쪽 데이터  = " + scores.first() );
        System.out.println(" 가장 높은 점수,가장 오른쪽 데이터  = " + scores.last() );
        System.out.println(" 48 보다 아래 점수  = " + scores.lower( 48 ) );
        System.out.println(" 48 보다 위 점수 = " + scores.higher( 48 ));
        System.out.println(" 48 이거나 보다 아래 점수  = " + scores.floor( 48 ) ) ;
        System.out.println(" 48 이거나 보다 위 점수 = " + scores.ceiling( 48 ));
        System.out.println(" 내림차순으로 반환 = " + scores.descendingSet() );
        System.out.println(" 48보다 이상  = " + scores.tailSet( 48 , true ) ); // true : 이상 , false : 초과
        System.out.println(" 48보다 이하   = " + scores.headSet( 48 , true ) );
        System.out.println(" 10이상 이면서 48미만  = " + scores.subSet( 10 , true , 48 , false ) );
        





        

    }
}
