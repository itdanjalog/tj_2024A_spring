package example.day08.thread;

import java.awt.*;
import java.util.Arrays;

public class Step1 {
    public static void main(String[] args) {
        // =================== 싱글 스레드 ============================
        // [1]. '띵' 5회 소리 출력
        Toolkit toolkit = Toolkit.getDefaultToolkit();
            // Toolkit : java.awt 자바의 UI(화면,소리 등등) 라이브러리
        for( int i = 1 ; i<=5 ; i++ ) { // 5회반복 
            toolkit.beep(); // '띵' 비프음 소리 출력
            // 비프음 소리1회 출력 속도보다 for문의 5회반복 속도가 더 빠르다.
            // for문을 처리하는 흐름[ 스레드 ] 를 잠시 일시정지
                // Thread.sleep( 밀리초 ) : 밀리초 만큼 스레드가 일시정지
                // 밀리초 : 1/1000 초 
            try {Thread.sleep(1000);}
            catch (Exception e ){
                System.out.println("e = " + e);
            }
        }
        // [2]. '띵; 5회 console 출력
        for( int i = 1 ; i<=5 ; i++ ){
            System.out.println("띵");
            try {Thread.sleep( 1000 );}
            catch ( Exception e ){  System.out.println(e); }
        }
        // =============================================================
        // ===================== 멀티 스레드 1 =============== //
        // 1. 작업스레드A 의 객체 생성
        작업스레드A threadA = new 작업스레드A();
        // 2. 작업스레드A 의 스레드 실행( run 메소드 실행 )
        threadA.start();
        // [2]. '띵; 5회 console 출력
        for( int i = 1 ; i<=5 ; i++ ){
            System.out.println("띵");
            try {Thread.sleep( 1000 );}
            catch ( Exception e ){  System.out.println(e); }
        } // for end

    } // main method end
} // class end
