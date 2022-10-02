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

    <title>로그인</title>
</head>
<body>
<div id="wrapper">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5">
                <div class="card mt-5">
                    <div class="card-header p-3">
                        <h3 class="text-center">로그인</h3>
                    </div>
                    <div class="card-body">
                        <form method="post">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" name="username" id="username"
                                       placeholder="nickname">
                                <label for="username" class="form-label">Nickname</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" name="password" id="password"
                                       placeholder="password">
                                <label for="password" class="form-label">Password</label>
                            </div>
                            <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                <a class="small" href="password.html">비밀번호 찾기</a>
                                <button type="submit" class="btn btn-dark" onclick="return check_login()">로그인</button>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer text-center py-3">
                        <div class="small"><a href="/registrations">회원가입</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <div class="bg-light py-4 px-4">
        Copyright &copy; todays-workout. All Rights Reserved.</div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script>
    function check_login() {
        const nickname = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if (nickname == "") {
            alert("닉네임을 입력해주세요.");
            return false;
        }
        if (password == "") {
            alert("비밀번호를 입력해주세요.");
            return false;
        }
    }
</script>
</body>
</html>