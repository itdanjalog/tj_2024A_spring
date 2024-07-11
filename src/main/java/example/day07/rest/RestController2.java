package example.day07.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestController2 { // HttpServletResponse 없애기

    // 1. Get   : GET http://localhost/day11/white
    @RequestMapping( value = "/rest2" , method = RequestMethod.GET)
    @ResponseBody   // 응답 contentType : application/json
    public String geRest2(HttpServletRequest req  ) throws IOException  {
        // 요청
        String key = req.getParameter("key");    System.out.println("key = " + key);
        // 응답
        return "[GET] Client HI";
    } // end
    
    // 2. Post : POST http://localhost/day11/white
    @RequestMapping( value = "/rest2" , method = RequestMethod.POST )
    @ResponseBody   // 응답 contentType   컬렉션프레임워크 또는 배열  -->  	application/json;
    //public String[] postRest2(HttpServletRequest req  ) throws IOException {
    //public List<String> postRest2(HttpServletRequest req  ) throws IOException {
    public AjaxDto postRest2(HttpServletRequest req  ) throws IOException {
        // -------- 요청/응답 -----------
        String key = req.getParameter("key");    System.out.println("key = " + key);
        // ----------------------------
//        String[] strArray = new String[2];
//        strArray[0] = "POST";  strArray[1] = "Client HI";
        //
//        List<String> strArray = new ArrayList<>();
//        strArray.add("POST"); strArray.add("Client HI");
        //
        AjaxDto strArray = new AjaxDto( "POST" , "Client HI" );
        return strArray;
    }
    // 3. Put : PUT http://localhost/day11/white
    @RequestMapping( value = "/rest2" , method = RequestMethod.PUT )
    @ResponseBody   // 응답 contentType   int ---> application/json;
    public int putRest2( HttpServletRequest req  ) throws IOException {
        // -------- 요청/응답 -----------
        String key = req.getParameter("key");    System.out.println("key = " + key);
        return 10;
    }
    // 4. delete : DELETE http://localhost/day11/white
    @RequestMapping( value = "/rest2" , method = RequestMethod.DELETE )
    @ResponseBody   // 응답 contentType   int ---> application/json;
    public boolean deleteRest2( HttpServletRequest req  ) throws IOException {
        // -------- 요청/응답 -----------
        String key = req.getParameter("key");    System.out.println("key = " + key);
        // ----------------------------
        return true;
    }

}
