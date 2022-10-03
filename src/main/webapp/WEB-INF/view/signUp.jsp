<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/css/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>회원가입</title>
</head>
<body>
<div id="wrapper">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5">
                <div class="card mt-5">
                    <div class="card-header p-3">
                        <h3 class="text-center">회원가입</h3>
                    </div>
                    <div class="card-body">
                        <form action="/registrations" method="post">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="username" id="username"
                                       placeholder="nickname" onclick="return check_nickname()">
                                <label for="username" class="form-label">Nickname</label>
                                <button type="button" class="btn btn-primary" onclick="return check_nickname();">중복체크</button>
                                <input type="hidden" name="nicknameDuplication" id="nicknameDuplication" value="unCheck"/>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="password">
                                <label for="password" class="form-label">Password</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" name="passwordCheck" id="passwordCheck"
                                       placeholder="passwordCheck">
                                <label for="passwordCheck" class="form-label">Password Check</label>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                <a class="small" href="/login">로그인</a>
                                <button type="submit" class="btn btn-dark" onclick="return check_signUp();">회원가입</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="bg-light py-4 px-4">
        Copyright &copy; todays-workout. All Rights Reserved.
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<script type="text/javascript">
    function check_nickname() {
        document.getElementById("nicknameDuplication").value = "unCheck";
        window.open('/registrations/nickname-check', "_blank", "width=500, height=300, resizable=no, scrollbars=no")
    };

    function check_signUp() {
        const nickname = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const passwordCheck = document.getElementById("passwordCheck").value;
        const nicknameDuplication = document.getElementById("nicknameDuplication").value;

        const nicknameRegExp = /^[a-z, 0-9]{4,12}$/;
        const passwordRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
        if (nickname == "") {
            alert("닉네임을 입력해주세요.");
            return false;
        }

        if (!nicknameRegExp.test(nickname)) {
            alert("닉네임은 영문 소문자와 숫자를 포함한 형태의 4~12자리를 입력해야합니다.");
            return false;
        }

        if (nicknameDuplication == "unCheck") {
            alert("닉네임 중복체크해주세요.");
            return false;
        }

        if (password == "") {
            alert("비밀번호를 입력해주세요.");
            return false;
        }

        if (!passwordRegExp.test(password)) {
            alert("비밀번호는 특수문자, 문자, 숫자를 포함한 형태의 8~15자리를 입력해야합니다.");
            return false;
        }

        if (password != passwordCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            return false;
        }
    };
</script>
</body>
</html>