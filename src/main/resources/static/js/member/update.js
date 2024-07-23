console.log( 'update.js' )

// 1. 내정보 호출
doMyInfo();
function doMyInfo(){
    $.ajax({
        method : 'get',
        url : "/member/my/info",
        success : result =>{ console.log( result );
            if( result == '' ){
                alert('로그인하고 오세요');  location.href="/member/login";
            }
            //
            document.querySelector('.no').innerHTML = `${result.no}`;
            document.querySelector('.id').innerHTML = `${result.id}`;
            document.querySelector('.name').value = `${result.name}`;
            document.querySelector('.phone').value = `${result.phone}`;
            document.querySelector('.email').innerHTML = `${result.email}`;

        }
    })
}
function doUpdate(){ console.log( 'doUpdate()' )

}
