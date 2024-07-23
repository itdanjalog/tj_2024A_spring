package web.service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.util.Random;


@Service // 스프링 컨테이너의 등록하고 빈(객체) 생성
public class AuthService {

    @Autowired HttpServletRequest request; // HTTP 요청 객체

    // 1. 인증번호 요청/생성
    public boolean authCode() {
        try {
            // 1. 인증코드가 문자인 이유 : 앞자리에 0이 들어가야 해서
            String authCode = "";
            // 2. 난수 생성 , Random 클래스
            Random random = new Random(); // random.nextInt(); // int타입의 표현범위내 난수생성 함수
            for (int i = 0; i < 6; i++) {
                authCode += random.nextInt(10); // 0~9 까지의 난수 생성
            };System.out.println("authCode = " + authCode);
            // 3. (선택) DB : 영구적인 데이터 vs JVM(스택,힙,메소드) vs 세션( 웹서버 저장소 - 요청하는 클라이언트의 브라우저마다 )
            // 1. 서버 세션 객체 속성의 인증 코드 를 저장
            request.getSession().setAttribute("authCode", authCode);
            // 2. 서버 세션 객체 의 생명주기(세션이 유지되는 시간 ) // 초 기준 // 10 초 동안 세션 유지하고 10초 후 삭제
            request.getSession().setMaxInactiveInterval(10);
            // 3. 이메일 전송 --
            return true;
        }catch (Exception e ){ System.out.println("e = " + e); }
        return false;
    }

    // 2. 입력받은 값과 인증 번호 를 인증/비교
    public boolean authCheck( String authCodeInput ){
        System.out.println("AuthService.authCheck");
        System.out.println("authCodeInput = " + authCodeInput);
        // 1. 인증 번호 호출
        Object object = request.getSession().getAttribute("authCode");
        System.out.println("object = " + object);
        if( object != null ){ // 세션객체의 인증번호가 존재하지 않으면
            String authCode = (String)object;   // 강제타입 변환
            System.out.println("authCode = " + authCode);
            // 2. 입력받은 인증번호 와 인증번호 비교
            if( authCode.equals( authCodeInput ) ) {
                return true; // 동일하면 true
            }
        }
        return false;
    }


} // class end








