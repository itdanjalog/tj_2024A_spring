console.log( "write.js" )

// 1. 카테고리 호출 , 실행조건 : js열렸을때
bcFindAll()
function bcFindAll(){
    $.ajax({
        method : "get" ,
        url : "/board/category",
        success : (r)=>{  console.log(r);
            // 1. 어디에
            let categoryBox = document.querySelector('.categoryBox');
            // 2. 무엇을 ( AJAX 이용한 서버로부터 받은 데이터 )
            let html =``;
                // - 서버로부터 응답받은 데이터를 타입 확인했더니 . List 타입 이므로 반복문 사용하자.
                    // 언어별 화살표 함수 표현 방식  JAVA : ()->{}  vs  JS : ()=>{}
                r.forEach( ( c ) => {
                    html += `<option value="${c.bcno}">${ c.bcname }</option>`
                })

            // 3. 출력
            categoryBox.innerHTML = html;
        },
        error : (e)=>{ console.log(e); }
    })
}

