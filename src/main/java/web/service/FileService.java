package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService {
    // [1] 파일 업로드
        // 매개변수로 파일의바이트가 저장된 MultipartFile 인터페이스
        // 업로드 된 파일명 반환
    public String fileUpload(MultipartFile multipartFile ){
        System.out.println( multipartFile.getContentType() );   // 첨부파일의 확장자
        System.out.println( multipartFile.getSize() );          // 첨부파일의 바이트 사이즈/용량
        System.out.println( multipartFile.isEmpty() );          // 첨부파일이 없으면 true , 있으면 false
        // 1. 첨부 파일의 실제 파일 이름 추출
        String fileName = multipartFile.getOriginalFilename();
        System.out.println("fileName = " + fileName);
        // 2. 첨부파일을 저장/복사/이동 할 경로 만들기
        String uploadPath = "C:\\Users\\TJ-BU-703-강사PC\\Desktop\\tj_2024A_spring\\src\\main\\resources\\static\\upload\\";
        // 3. 첨부파일을 저장/복사/이동 경로 와 파일명 합치기
        String filePath = uploadPath + fileName;
        // 4. 해당 경로로 설정한 file 객체 , transferTo( file객체 )
        File file = new File( filePath );
        // 5. transferTo( file객체 ) : file객체내 설정한 해당 경로 로 파일 복사/저장/이동
            // 일반예외 무조걵 발생
        try {
            multipartFile.transferTo(file);
        }catch (Exception e ){ System.out.println(e);  }
        return fileName;
    }
    // [2] 파일 다운로드

}
