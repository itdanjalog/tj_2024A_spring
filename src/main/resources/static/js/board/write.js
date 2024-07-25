console.log( "write.js" )

// 1. 카테고리 호출 , 실행조건 : js열렸을때
bcFindAll()
function bcFindAll(){
    // 1. 어디에
    let categoryBox = document.querySelector('.categoryBox');
    // 2. 무엇을
    let html =`<option>안녕</option>`;
    // 3. 출력
    categoryBox.innerHTML = html;
}

