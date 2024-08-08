package web.model.dao;

import org.springframework.stereotype.Component;
import web.model.dto.MemberDto;
import web.model.dto.ProductDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProductDao extends Dao {
    // 1.제품 등록
    public boolean pRegister( ProductDto productDto ){ System.out.println("productDto = " + productDto);
        // - 각 테이블의 따른 DTO 정보를 각 INSERT 한다.
        try {
            // -- 제품 등록
            String sql = "insert into product( ptitle , pcontent , pprice ) " +
                    " values( ? , ? , ? ) ";
                // -- JDBC 에서 insert 한 레코드의 자동번호(auto_increment)가 부여된 pk번호를 반환하는 방법
                    // 1. conn.prepareStatement( SQL ,Statement.RETURN_GENERATED_KEYS ) , GENERATED : 생성됨
                    // 2. ResultSet pkRs = ps.getGeneratedKeys();
                    // 3. pkPs.next()
                    // 4. int pk = pkPs.getInt(1);
            PreparedStatement ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS);
            ps.setString( 1, productDto.getPtitle() );
            ps.setString( 2, productDto.getPtitle() );
            ps.setInt( 3, productDto.getPprice() );
            int count = ps.executeUpdate();
            if( count == 1 ){ // 등록된 레코드가 1개 이면 ( 제품등록 성공 )
                // -- 제품 이미지 등록
                ResultSet pkRs = ps.getGeneratedKeys(); // 생성된 pk번호들을 ResultSet 반환된다.
                if( pkRs.next() ){ // ResultSet .next() -> 다음레코드 -> pk가 1개 존재하면
                    int pno = pkRs.getInt( 1 );         // pk 번호 추출
                    System.out.println("pno = " + pno); // 확인
                    // 이미지 등록
                }
            }
        }catch (Exception e ){  System.out.println( e );  }
        return false;
    } // method end
}


















