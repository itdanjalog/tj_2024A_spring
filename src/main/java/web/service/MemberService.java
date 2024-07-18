package web.service;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

@Service
public class MemberService {

    @Autowired MemberDao memberDao;

    public boolean mSignup( MemberDto memberDto ){
        System.out.println("MemberService.mSignup");
        System.out.println("memberDto = " + memberDto);
        return memberDao.mSignup( memberDto );
    }

    // 2. 로그인
    public boolean mLogin( MemberDto memberDto ){
        System.out.println("MemberService.mLogin");
        System.out.println("memberDto = " + memberDto);
        int no =  memberDao.mLogin( memberDto );
        if( no == 0 ){ return false; }
        MemberDto loginDto = MemberDto.builder()
                .id( memberDto.getId() ).no( no )
                .build();
        request.getSession().setAttribute( "loginDto" , loginDto );
        return true;
    }

    @Autowired
    HttpServletRequest request;
    public MemberDto mLoginCheck(){
        return (MemberDto) request.getSession().getAttribute( "loginDto");
    }

}
