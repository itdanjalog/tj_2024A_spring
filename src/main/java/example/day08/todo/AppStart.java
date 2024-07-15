package example.day08.todo;

import java.util.ArrayList;

public class AppStart {

    // [1] Console 일때 Controller+Dao 테스트
    public static void main(String[] args) {
        // 1. 할일 등록      , 주고( 할일내용 ) 받기( 결과 )
        TodoController.getInstance().todoCreate("파이썬공부");
        // 2. 할일 전체 출력  , 주고( x ) 받기( 할일리스트 )
        ArrayList<TodoDto> result
                = TodoController.getInstance().todoReadAll();
        System.out.println( result );
        // 3. 할일 (상태) 수정 , 주고( 수정할할일번호 ) 받기( 결과 )
        TodoController.getInstance().todoUpdate( 3 );
        // 4. 할일 삭제       ,  주고( 삭제할할일번호 ) 받기( 결과 )
        TodoController.getInstance().todoDelete( 2 );
    }

}
