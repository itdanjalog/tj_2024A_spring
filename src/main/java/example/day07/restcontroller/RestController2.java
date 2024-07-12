package example.day07.restcontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController2 {
    // [1] HTTP GET
    @RequestMapping( value = "/example/rest2" , method = RequestMethod.GET)
    @ResponseBody   // 응답할 데이터의 자바타입을 HTTP타입으로 자동 타입 설정 : (java) String -> (HTTP) text/plain;
    public String getRest2(HttpServletRequest request ){
        System.out.println("RestController2.getRest2");
        // 1.요청
        String key = request.getParameter("key");
        System.out.println("key = " + key);
        // 2.응답   // 2-1 메소드의 반환타입을 정의한다.
        return "[GET]ClientHi";  // 2-2 @ResponseBody 메소드위에 정의한다.
    }
    // [2] HTTP POST
    @RequestMapping( value = "/example/rest2" , method = RequestMethod.POST )
    @ResponseBody    // 응답할 데이터의 자바타입을 HTTP타입으로 자동 타입 설정 : (java) [] -> (HTTP) application/json;
    public String[] getPost2( HttpServletRequest request ){
        System.out.println("RestController2.getPost2");
        String key = request.getParameter("key");
        System.out.println("key = " + key);
        // 데이터 구성
        String[] strArray = new String[2];
        strArray[0] = "[POST]"; strArray[1] ="ClientHi";
        return strArray;        // JSON : [ "[POST]","ClientHi" ]
    }
}
