//정규식 객체
//문자열
//골뱅이를 기준으로 이루어지므로 개수가 넘어도 true가 나옴
//^을 사용해서 시작지점을 정해줘야함
// const r = /^[a-zA-Z1-9]{4,12}@[a-zA-Z]{2,}(.)[a-zA-Z]{2,}$/;
// const s = "helloworl123@naver.com";

//검증
// const result = r.test(s);
// console.log(result);

//아이디 길이 검사하여, 제출 결정
function checkUserIdValidation() {
    const userId = document.querySelector("input[name=userId]").value;
    const r = /^[a-zA-Z0-9]{4,12}$/;
    const result = r.test(userId);
    if(result) {
        alert("통과")
    }
    else {
        alert("아이디 길이는 4~12 글자!!!!")
    }
    return result;
}

//========= 파일 미리보기 =============

const pro_qs = document.querySelector('input[name=profile]');
const body = document.querySelector("body");
pro_qs.addEventListener('change', (e) => {

    f = e.target.files[0];

    //파일 객체 > 문자열 형태
    const fr = new FileReader();
    fr.readAsDataURL(f);

    fr.addEventListener("load", (evt) => {
        const image = document.createElement('img')
        image.src = evt.target.result;
        image.width = 200;
        image.height = 200;
        body.appendChild(image);
        
    })
    
})

