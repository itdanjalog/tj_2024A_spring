package web.service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@Service
public class MemberService {

    @Autowired MemberDao memberDao;

    // 1. 회원가입
    public boolean mSignup( MemberDto memberDto ){
        System.out.println("MemberService.mSignup");
        System.out.println("memberDto = " + memberDto);
        return memberDao.mSignup( memberDto );
    }

    @Autowired // 현재 요청을 보낸 클라이언트의 HTTP 요청정보를 가지고 있는 객체를 주입
    HttpServletRequest request;
    // 2. 로그인
    public boolean mLogin( MemberDto memberDto ){
        System.out.println("MemberService.mLogin");
        System.out.println("memberDto = " + memberDto);
        boolean result =  memberDao.mLogin( memberDto );
        if( result ) {
            // ----- HTTP 세션 처리 ----- //
            // 1. 현재 요청을 보내온 클라이언트의 세션객체 호출
            HttpSession session = request.getSession();
            // 2. 세션객체에 속성 추가
            session.setAttribute("loginDto", memberDto.getId() );
        }
        return result;
    }
    // 3. 로그인의 상태 반환
    public String mLoginCheck( ){
        HttpSession session = request.getSession();
        String str = (String)session.getAttribute( "loginDto" );
        return str;
    }

} // class end








