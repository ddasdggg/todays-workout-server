<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<script type="text/javascript">
    var message = "${message}";
    var url = "${url}";
    alert(message);
    document.location.href = url;
</script>
</body>
</html>