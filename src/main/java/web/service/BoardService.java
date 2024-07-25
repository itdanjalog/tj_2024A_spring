package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
import web.model.dto.MemberDto;

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

    @Autowired MemberService memberService;
    @Autowired FileService fileService;
    // 2.
    public boolean bWrite( BoardDto boardDto) {
        // - 파일 업로드
        fileService.fileUpload( boardDto.getBfile() );

        // 글자 작성을 요청한 회원의 로그인회원번호 구하기
        // 1. 로그인 세션에서 값 호출
        Object object = memberService.mLoginCheck();
        if( object == null ) return  false; // 비로그인시 함수 강제종료/취소
        // 2. 세션내 회원번호 속성 호출
        MemberDto memberDto = (MemberDto)object;
        // 3. 속성 호출
        int loginNo = memberDto.getNo();
        // 4. BoardDto 담아주기
        boardDto.setNo( loginNo );
        return boardDao.bWrite( boardDto );
    }
}








