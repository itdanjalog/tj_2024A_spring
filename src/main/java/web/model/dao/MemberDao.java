package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class MemberDao extends Dao {
    // 1. 회원가입
    public boolean mSignup( MemberDto memberDto ){
        System.out.println("MemberDao.mSignup");
        System.out.println("memberDto = " + memberDto);
        try{
            String sql = "insert into member( id , pw , name , email , phone ) values( ? , ? , ? , ? , ? )";
            PreparedStatement ps = super.conn.prepareStatement(sql);
            ps.setString( 1 , memberDto.getId() );
            ps.setString( 2 , memberDto.getPw() );
            ps.setString( 3 , memberDto.getName() );
            ps.setString( 4 , memberDto.getEmail() );
            ps.setString( 5 , memberDto.getPhone() );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        }catch (Exception e ){  System.out.println("e = " + e);     }
        return false;
    }
    // 2. 로그인
    public int mLogin( MemberDto memberDto ){
        System.out.println("MemberDao.mLogin");
        System.out.println("memberDto = " + memberDto);
        try{String sql = "select * from member where id = ? and pw =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1 , memberDto.getId() );
            ps.setString( 2 , memberDto.getPw() );
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){ return rs.getInt(1); }
        }catch (Exception e ){ System.out.println(e);   }
        return 0;
    }
}
