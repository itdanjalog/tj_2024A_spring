console.log( 'todo.js' );
// let todoList = ["밥먹기,X"]; // 1달에는 JS에서 메모리 관리 했지만 // 3달 에는 웹서버( ->DB서버) 관리 하기 때문에 필요없다.

function todocreate(){ console.log( 'todocreate() load');
    // [1] HTML 입력받은 값 가져오기 
        // [1-1] DOM 가져오기 
    let todoInput = document.querySelector(`#todoInput`);   console.log(todoInput);
        // [1-2] 가져온 DOM의 입력값 호출 
    let tcontent = todoInput.value;                         console.log(tcontent);

    // [2] AJAX(JQUERY라이브러리) 이용한 웹서버(컨트롤러) 통신해서 요청과 응답 하기 
    let ajaxoption = {
        method : 'post',                            // HTTP 메소드 선택( GET , POST , PUT , DELETE )
        url : '/todo/create?tcontent='+tcontent ,   // HTTP 통신할 경로 작성( http://localhost:8080 IP와PORT 생략 ) , 
        success : function response( result ){      // HTTP 통신 성공시 응답값을 함수의 매개변수로 받는다.
            console.log( result ); // 응답 결과 확인 
            if( result == true ){
                 alert('할일등록성공');     // 성공 안내 
                 todoInput.value = '';      // 입력상자에 입력된 값 없애기.
            }
            else{ alert('할일등록실패'); } // 실패 안내
        } // success end 
    } // 옵션 end

    // AJAX 는 JQUERY 라이브러리 포함된 함수이다. $는 JQUERY의 문법이다.
    $.ajax( ajaxoption ); // AJAX (웹서버 와 통신 하기 ) 실행 

} // todocreate end 

function print(){
    let todoBox = document.querySelector(`#todoBox`);
    let html = ``;

    for(let i=0; i<todoList.length; i++){
        let s = todoList[i].split(",")[0];    // 문장     // split 함수로 떼어내기
        let e = todoList[i].split(",")[1];    // X  

        if(e == 'X'){                          // e == 'X'는 기본값으로 등록했을 때 화이트 박스가 나오게 하기 위함.
            html +=`<div id="whiteBox">
                        <span> ${s} </span>
                        <div>
                            <button type="button" onclick="change(${i})">변경</button>
                            <button type="button" onclick="remove(${i})">삭제</button>
                        </div>
                    </div>`            
        }else{
            html +=`<div id="blackBox">
                        <span> ${s} </span>
                        <div>
                            <button type="button" onclick="change(${i})">변경</button>
                            <button type="button" onclick="remove(${i})">삭제</button>
                        </div>
                    </div>`
        }
    }    
    todoBox.innerHTML = html;    
}
function remove(deleteIndex){
    //  1. 배열 내 특정 인덱스[i]의 요소 삭제
    todoList.splice(deleteIndex, 1);
    //  2. 삭제가 되면 배열의 상태가 변경되므로 배열의 상태를 다시 출력 - 화면 업데이트
    print();
}       
function change(i){ 
    let s = todoList[i].split(",")[0]
    let e = todoList[i].split(",")[1]

    if(e =='X'){                 // e == 'X' 여서 변경 하려면'X'가'O'로 바뀌어야함.
    todoList[i] = s + ",O"
    }else{
    todoList[i] = s + ",X"
    }
    print();
}