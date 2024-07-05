console.log( 'phonebook.js 열림')
let phonebookDB = [ ]
// 1. 등록함수 : 등록버튼을 클릭했을때.
function postPhone(){
    let name = document.querySelector('#name').value;   // 1. 입력받은 값 호출 해서 변수에 저장
    let phone = document.querySelector('#phone').value;
    let phoneDto = { name : name , phone : phone  } // 2. 객체화
    phonebookDB.push( phoneDto ) // 3. 객체를 배열에 저장
    alert('save');  getPhone();  // 4. 안내 / 새로고침
}
// 2. 출력함수 : 등록처리가 되었을때 , js열렸을때 최초1번
getPhone()
function getPhone(){
    let phoneListBox = document.querySelector('#phoneListBox') // 1. 어디에
    let html = ''; // 2. 무엇을      // JAVA : ->  , js : =>
    phonebookDB.forEach(  phone  => {
        html +=  `<div>
                    <span> ${ phone.name } </span>
                    <span> ${ phone.phone } </span>
                </div>`
    })
    phoneListBox.innerHTML = html // 3. 출력
}
