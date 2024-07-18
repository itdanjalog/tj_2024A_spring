console.log( 'header.js' )

doLoginCheck();
function doLoginCheck(){
    $.ajax({
        method:'get' , url:"/member/login/check" ,
        success : (result)=>{ console.log( result ); }
    })
}
