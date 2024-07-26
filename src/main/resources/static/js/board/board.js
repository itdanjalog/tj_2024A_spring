console.log( "board.js")

// 1. 전체 게시물 조회
doBoardFindAll();
function doBoardFindAll(){
    let list = []
    $.ajax({
        // async : false ,  // false동기화 vs true비동기화( innerHTML 후 에 응답 온다.)
        method : "get" ,
        url : "/board/find/all" ,
        success : r => {    console.log( r );
            // 응답 데이터 : 타입 확인!!
            list = r;
        }
    })
    // 1. 어디에
    let boardBody = document.querySelector('.boardBody')
    // 2. 무엇을
    let html = ''
        //
        list.forEach( b =>{
            html += `<tr>
                    <th> 1 </th>
                    <th> <a href="/board/view?bno=1">안녕하세요</a>
                    </th> <th> 유재석 </th>
                    <th> 2024-07-25 </th>
                    <th> 3 </th>
                    </tr>`
        })
    // 3. 출력
    boardBody.innerHTML = html;
}