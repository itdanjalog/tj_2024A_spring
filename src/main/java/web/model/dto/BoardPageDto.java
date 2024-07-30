package web.model.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter@Setter@ToString
@AllArgsConstructor @NoArgsConstructor
public class BoardPageDto {
    // - 검색,카테고리별 페이징처리에 다양한 매개변수가 필요하므로 집합 Dto
    private int page; // 1. 현재 페이지 번호
        // (지역/매개) 변수 와 필드 차이점 : 초기값의 차이
    private int totalBoardSize; // 2. 전체 게시물수
    private int totalPage; // 3. 전체 페이지수
    private List<BoardDto> data; // 4. 조회된 게시물 정보 목록/리스트

}
