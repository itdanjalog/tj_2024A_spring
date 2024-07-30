# 조작어 : DML =======================================
# [2] 로그인
select * from member where id = 'qwe' and pw ='qwe';
# select * from member where id = ? and pw =?;
# [3] 내정보 검색 , 중복없는 식별 필드
select * from member where no = 1;
# select * from member where no = ?;
select * from member;
# [4] 아이디 중복검사
select * from member where id = 'qwe123';
select * from member where id = 'QWE123';
	# 만일 대소문자를 구분하는 데이터 검색 할때는 binary( 필드 ) 사용
    # binary( 필드 ) : 문자 가 아닌 바이트를 기준으로 비교,검색 한다.
select * from member where binary( id ) = 'qwe123';	# 소문자qwe
select * from member where binary( id ) = 'QWE123';	# 대문자qwe
	# JDBC : select * from member where binary( id ) = ? ;
# [5] 탈퇴
delete from member where no = 2;
delete from member where no = 2 and pw = '1234';	# 패스워드는 중복이 가능하므로 식별 역할이 불가능하다.
	# JDBC : delete from member where no = ? and pw = ? ;
    
# 1. 카테고리 샘플 
insert into bcategory( bcname ) values ( '자유' ) , ( '노하우' ) , ( '판매' ) , ( '구매') ;

# 2. 카테고리 전체 출력 
select * from bcategory;

# 3 . 글쓰기 , bcno[카테고리fk] , no[회원fk]
	# 3번 회원이 1번 카테고리의 안녕,하하하 작성
insert into board( bcno , btitle , bcontent , no ) value( 1 , '안녕' , '하하하' , 3 );
	# JDBC : insert into board( bcno , btitle , bcontent , no ) value(  , ? , ? , ?);
    
# 4. 게시물 전체 출력 
select * from board ;

# 5. limit 연산자 이용한 레코드 제한 출력
	# limit 개수 : 개수만큼의 레코드 조회 
    # limit 시작레코드 , 개수 : 시작레코드(0~) 부터 개수만큼의 레코드 조회
select * from board limit 0;		
select * from board limit 1;
select * from board limit 1 , 2;
select * from board limit 1 , 3;
select * from board limit 0 , 3;
	# 페이징 처리 활용 , 가정 : 하나의 페이지 당 게시물 표시 수 는 5개씩 
	# 1페이지  	limit 0 , 5;		1페이지일때 시작인덱스 : 0		, 0 * 5 -> 0
select * from board limit 0 , 5;
    # 2페이지		limit 5 , 5;		2페이지일때 시작인덱스 : 5		, 1 * 5	-> 5
select * from board limit 5 , 5;
    # 3페이지 	limit 10 , 5;		3페이지일때 시작인덱스 : 10 		, 2 * 5	-> 10
select * from board limit 10 , 5;
	# 시작인덱스의 계산식 : (현재페이지번호-1) * 페이지당게시물수 

-- 활용
	# 1페이지 
select * from board inner join member on board.no = member.no limit 0 , 5 ;
	# 2페이지 
select * from board inner join member on board.no = member.no limit 5 , 5 ;
	# JDBC
# select * from board inner join member on board.no = member.no limit ? , ? ;

-- 정렬 : 작성일 순으로 
select * from board inner join member on board.no = member.no order by board.bno desc limit 0 , 5 ;

-- [1] 레코드 개수 세기 











