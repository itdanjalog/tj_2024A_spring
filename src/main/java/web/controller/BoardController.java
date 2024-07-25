package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.model.dto.BoardDto;
import web.service.BoardService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired private BoardService boardService;
    // 1. 전체 카테고리 호출
    @GetMapping("/category")
    // public List<BoardDto> bcFindAll(){
    public List< Map<String,String> > bcFindAll( ) {
        System.out.println("BoardController.bcFindAll");
        return boardService.bcFindAll();
    }
}

