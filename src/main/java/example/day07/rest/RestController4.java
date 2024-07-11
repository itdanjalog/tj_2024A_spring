package example.day07.rest;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController// @Controller + @ResponseBody
@RequestMapping("/rest4") // 해당 클래스내 매핑함수들의 공통URL
public class RestController4 {
    // 1. 통신
    @GetMapping("/ddd")
    public String ajax1(){
        System.out.println("RestController4.ajax1");
        return "응답1";
    }
    // 2. 경로상 변수 활용한 매개변수 요청 받기.
    @GetMapping("/{id}/{content}")
    public String ajax2( @PathVariable int id , @PathVariable("content") String content2 ){
        System.out.println("RestController4.ajax2");
        System.out.println("id = " + id + ", content2 = " + content2);
        return "응답2";
    }
    // 3. 쿼리스트링
    //// 1. @RequestParam
    //    @GetMapping("")
    //    public String ajax3( int id , @RequestParam("content") String content2  ){
    //        System.out.println("RestController4.ajax3");
    //        System.out.println("id = " + id + ", content2 = " + content2);
    //        return "응답3";
    //    }
    // 2. HttpServletRequest 객체
    //    @GetMapping("")
    //    public String ajax3(HttpServletRequest req ){
    //        int id =  Integer.parseInt( req.getParameter("id") ) ;
    //        String content2 = req.getParameter("content");
    //        System.out.println("id = " + id + ", content2 = " + content2);
    //        return "응답";
    //    }
    // 3. @RequestParam Map
    //    @GetMapping("")
    //    public String ajax3( @RequestParam Map<String , String > map ){
    //        System.out.println("RestController4.ajax3");
    //        System.out.println("map = " + map);
    //        return "응답3";
    //    }
    // 4. DTO
    @GetMapping("")
    public String ajax3( AjaxDto ajaxDto ){
        System.out.println("RestController4.ajax3");
        System.out.println("ajaxDto = " + ajaxDto);
        return "응답3";
    }
    // 4. HTTP BODY 본문
    // 1.
//    @GetMapping("/ajax4")
//    public String ajax4( int id , @RequestParam("content") String content  ){
//        System.out.println("RestController4.ajax4");
//        System.out.println("id = " + id + ", content = " + content);
//        return "응답4";
//    }
    @GetMapping("/gg")
    public String ajax4( @RequestParam Map<String,String> map  ){
        System.out.println("RestController4.ajax4");
        System.out.println("map = " + map);
        return "응답4";
    }

} // class end














