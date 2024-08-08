package web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController @RequestMapping("/product")
public class ProductController {
    @PostMapping("/register")
    public boolean pRegister( @RequestParam List<MultipartFile> files ) {
        System.out.println("files = " + files);
        return true;
    }
}
