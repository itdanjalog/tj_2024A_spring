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
        try { // -- 제품 등록
            String sql = "insert into product( ptitle , pcontent , pprice ) values( ? , ? , ? ) ";
            PreparedStatement ps = conn.prepareStatement( sql , Statement.RETURN_GENERATED_KEYS);
            ps.setString( 1, productDto.getPtitle() );
            ps.setString( 2, productDto.getPcontent() );
            ps.setInt( 3, productDto.getPprice() );
            int count = ps.executeUpdate();
            if( count == 1 ){ // 등록된 레코드가 1개 이면 ( 제품등록 성공 )
                // -- 제품 이미지 등록
                ResultSet pkRs = ps.getGeneratedKeys(); // 생성된 pk번호들을 ResultSet 반환된다.
                if( pkRs.next() ){ // ResultSet .next() -> 다음레코드 -> pk가 1개 존재하면
                    int pno = pkRs.getInt( 1 );         // pk 번호 추출
                    System.out.println("pno = " + pno); // 확인
                    // 반복문 이용한 여러개 이미지 이름을 레코드 에 등록하기
                    productDto.getFileNames().forEach( fileName -> {
                            try { String sql2 = "insert into productimg( pimgname , pno ) values(?,?) ";
                                PreparedStatement ps2 = conn.prepareStatement(sql2);
                                ps2.setString(1, fileName);
                                ps2.setInt(2, pno);
                                ps2.executeUpdate();
                            }catch (Exception e ){  System.out.println(e);  }
                        } // 실행문 end
                    ); // forEach end
                } // if end
            } // if end
        }catch (Exception e ){  System.out.println( e );  }
        return false;
    } // method end

    // 2. 제품 전체 출력 ( 1개 : dto  , 여러개 : List<Dto> )
    public List<ProductDto> getProductFindAll( ){
        List<ProductDto> list = new ArrayList<>();
        try{ // - 1. 전체 제품 조회
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){ // - 제품 객체 생성
                ProductDto productDto = ProductDto.builder()
                        .ptitle( rs.getString( "ptitle" ) ) .pcontent( rs.getString( "pcontent") )
                        .pprice( rs.getInt( "pprice") ) .pno( rs.getInt("pno") )
                        .pdate( rs.getString("pdate")) .pview( rs.getInt("pview"))
                        .build();
                // - 2. 제품의 모든 이미지 조회 : fileNames
                List<String> fileNames = new ArrayList<>();
                // 해당 제품의 모든 이미지 조회
                String sql2 = "select * from productimg where pno = ? ";
                PreparedStatement ps2 = conn.prepareStatement( sql2 );
                ps2.setInt( 1 , rs.getInt("pno") );
                ResultSet rs2 = ps2.executeQuery();
                while ( rs2.next() ){
                    fileNames.add( rs2.getString("pimgname") );
                } // w end
                // 조회한 모든 이미지를 DTO 담기
                productDto.setFileNames( fileNames );
                // - 제품 객체를 리스트에 담기
                list.add( productDto );
            } // while end
        }catch (Exception e ){ System.out.println(e);}
        return list; // 제품 리스트 반환
    }
}// class end


// -- JDBC 에서 insert 한 레코드의 자동번호(auto_increment)가 부여된 pk번호를 반환하는 방법
// 1. conn.prepareStatement( SQL ,Statement.RETURN_GENERATED_KEYS ) , GENERATED : 생성됨
// 2. ResultSet pkRs = ps.getGeneratedKeys();
// 3. pkPs.next()
// 4. int pk = pkPs.getInt(1);

















