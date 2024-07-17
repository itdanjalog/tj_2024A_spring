package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index(){
        return "/index.html";
    }
    @GetMapping("/member/signup")
    public String memberSignup(){
        return "/member/signup.html";
    }
    @GetMapping("/member/login")
    public String memberLogin(){
        return "/member/login.html";
    }

}
