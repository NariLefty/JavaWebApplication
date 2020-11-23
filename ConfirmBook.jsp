<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Book</title>
</head>
<body>
<h3>Confirm Book</h3>
<h4>予約確認</h4>

<table>
<tr><td>
お名前：
</td><td>
<%=request.getParameter("name") %>
</td></tr><tr><td>
人数:
</td><td>
<%=request.getParameter("cusCount") %>
</td></tr><tr><td colspan=2>
<%=request.getParameter("radio1") %>
</td></tr>
<tr><td>
<form action="BookkingIsDone" method="post">
<input type="submit" value="予約完了">
</form>
</td><td>
<form action="Book.jsp" method="post">
<input type="submit" value="戻る">
</form>
</table>

</body>
</html>