package example.day07.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController //  @Controller +  @ResponseBody
@RequestMapping( value = "/rest3")
public class RestController3 {
    // 1. Get   : GET http://localhost/day11/red
    // @RequestMapping( value = "/day11/red" , method = RequestMethod.GET)
    @GetMapping(value = "")
    public String getRed( HttpServletRequest req  )  {
        String key = req.getParameter("key");    System.out.println("key = " + key);
        return "[GET] Client HI";
    } // end

    // 2. Post : POST http://localhost/day11/red
    @PostMapping("")
    public Map< String , String > postRed(HttpServletRequest req  ) {
        String key = req.getParameter("key");    System.out.println("key = " + key);
        Map< String , String > strArray = new HashMap<>();
        strArray.put("POST","Client HI");
        return strArray;
    }
    // 3. Put : PUT http://localhost/day11/red
    @PutMapping("")
    public int putRed( HttpServletRequest req  ) {
        String key = req.getParameter("key");    System.out.println("key = " + key);
        return 10;
    }
    // 4. delete : DELETE http://localhost/day11/white
    @DeleteMapping("")
    public boolean deleteRed( HttpServletRequest req  ) {
        String key = req.getParameter("key");    System.out.println("key = " + key);
        return true;
    }
}
