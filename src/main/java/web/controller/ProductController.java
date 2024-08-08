package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.model.dto.ProductDto;
import web.service.ProductService;

import java.util.List;

@RestController @RequestMapping("/product")
public class ProductController {
    @Autowired private ProductService productService;
    // 1. 제품등록
    @PostMapping("/register")
    public boolean pRegister( ProductDto productDto  ) {
        return productService.pRegister( productDto );
    }
}
