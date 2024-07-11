package example.day07.rest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class RestController1 {

    // 1. Get   : GET http://localhost:8080/rest1?key=ControllerHi
    @RequestMapping( value = "/example/rest1" , method = RequestMethod.GET)
    public void geRest1(HttpServletRequest req , HttpServletResponse resp ) throws IOException  {
        System.out.println("RestController1.geRest1");
        // 요청   http://localhost/day11/black?sendMsg=안녕[컨트롤]
        String key = req.getParameter("key");    System.out.println("key = " + key);
        // 응답
        resp.getWriter().print("[GET] Client HI");
    } // end
    // 2. Post : POST http://localhost:8080/rest1?key=ControllerHi
    @RequestMapping( value = "/example/rest1" , method = RequestMethod.POST )
    public void postRest1( HttpServletRequest req , HttpServletResponse resp ) throws IOException {
        System.out.println("RestController1.postRest2");
        // -------- 요청/응답 -----------
        String key = req.getParameter("key");    System.out.println("key = " + key);
        resp.getWriter().print("[POST] Client HI");
        // ----------------------------
    }
    // 3. Put : PUT http://localhost:8080/rest1?key=ControllerHi
    @RequestMapping( value = "/example/rest1" , method = RequestMethod.PUT )
    public void putRest1( HttpServletRequest req , HttpServletResponse resp ) throws IOException {
        System.out.println("RestController1.putRest3");
        // -------- 요청/응답 -----------
        String key = req.getParameter("key");    System.out.println("key = " + key);
        resp.getWriter().print("[PUT] Client HI");
        // ----------------------------
    }
    // 4. delete : DELETE http://localhost:8080/rest1?key=ControllerHi
    @RequestMapping( value = "/example/rest1" , method = RequestMethod.DELETE )
    public void deleteRest1( HttpServletRequest req , HttpServletResponse resp ) throws IOException {
        System.out.println("RestController1.deleteRest4");
        // -------- 요청/응답 -----------
        String key = req.getParameter("key");    System.out.println("key = " + key);
        resp.getWriter().print("[DELETE] Client HI");
        // ----------------------------
    }

}
