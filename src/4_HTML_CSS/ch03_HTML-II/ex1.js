// JavaScript source code
/*여러줄 주석
 * */

// 한줄 주석
function chk() {
    if (frm.name.value.length < 2) {
        frm.name.focus();
        alert("이름은 2글자 이상 입력하세요");
        return false;
    } else if (frm.id.value.length < 4) {
        frm.id.focus();
        alert("아이디는 4글자 이상 입력하세요");
        return false;
    } else if (frm.pwd.value.length < 1) {
        frm.pwd.focus();
        alert("비밀번호는 1글자 이상 입력하세요");
        return false;
    } else if (frm.pwd2.value.length < 1) {
        frm.pwd2.focus();
        alert("비밀번호확인은 1글자 이상 입력하세요");
        return false;
    } else if (frm.pwd.value != frm.pwd2.value) {
        frm.pwd2.value = "";
        frm.pwd2.focus();
        alert("같은 비밀번호를 입력하세요");
        return false;
    } 

}


