loginCheck();
function loginCheck(){
    $.ajax({
        url : '/member/login/check',
        method : 'get',
        success : (r)=>{  console.log(r);
            if( r == '' ){
                console.log('비로그인');
            }else{
                console.log('로그인')
            }
        } // s end
    }); // ajax end
}
