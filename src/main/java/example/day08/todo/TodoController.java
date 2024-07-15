package example.day08.todo;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class TodoController {
    // [1] 싱글톤 패턴
    private static TodoController todoController = new TodoController();
    private TodoController(){ }
    public static TodoController getInstance( ){ return todoController;  }

    // 1. 할일 등록
    public boolean todoCreate( String tcontent ){
        boolean result = TodoDao.getInstance().todoCreate( tcontent );
        return result;
    }
    // 2. 할일 전체 출력
    public ArrayList<TodoDto> todoReadAll( ){
        ArrayList<TodoDto> result = TodoDao.getInstance().todoReadAll();
        return result;
    }
    // 3. 할일 (상태) 수정
    public boolean todoUpdate( int tno ){
        boolean result = TodoDao.getInstance().todoUpdate( tno );
        return result;
    }
    // 4. 할일 삭제
    public boolean todoDelete( int tno ){
        boolean result = TodoDao.getInstance().todoDelete( tno );
        return result;
    }

}
