package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.BoardDao;

import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired private BoardDao boardDao;
    // 1. 전체 카테고리 호출
    public List< Map<String,String> > bcFindAll( ) {
        System.out.println("BoardService.bcFindAll");
        return boardDao.bcFindAll();
    }
}
