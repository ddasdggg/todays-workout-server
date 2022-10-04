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

    <title>닉네임 중복체크</title>
</head>
<body>
<%
    Object result = request.getAttribute("idCheck");
    String nickname = (String) request.getAttribute("nickname");
    System.out.println(result);
%>

<div class="card-body">
    <form action="/registrations/nickname-check" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="username" id="username"
                   placeholder="nickname">
            <label for="username" class="form-label">nickname</label>
            <button type="submit" class="btn btn-dark" onclick="return search_nickname()">검색</button>
        </div>
        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
            <%if (result == null) { %>
            <button type="button" class="btn btn-primary" onclick="window.close()">취소</button>
            <%} else {%>
                <%if ((boolean) result) { %>
                <span style="color:blue">해당 ID는 사용이 가능합니다.</span>
                <button type="button" class="btn btn-dark" onclick="return use_nickname()">사용하기</button>
                <%} else { %>
                <span style="color:red">해당 ID는 이미 사용 중합니다.</span>
                <button type="button" class="btn btn-primary" onclick="window.close()">취소</button>
                <%} %>
            <%} %>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<script type="text/javascript">
    function search_nickname() {
        const nickname = document.getElementById("username").value;
        const nicknameRegExp = /^[a-z, 0-9]{4,12}$/;
        if (nickname == "") {
            alert("닉네임을 입력해주세요.");
            return false;
        }
        if (!nicknameRegExp.test(nickname)) {
            alert("닉네임은 영문 소문자와 숫자를 포함한 형태의 4~12자리를 입력해야합니다.");
            return false;
        }
    }

    function use_nickname() {
        window.opener.document.getElementById('nickname').value = '<%=nickname%>';
        window.opener.document.getElementById('nicknameDuplication').value = 'check';
        window.close();
    }
</script>
</body>
</html>