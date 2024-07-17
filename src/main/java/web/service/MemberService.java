package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
