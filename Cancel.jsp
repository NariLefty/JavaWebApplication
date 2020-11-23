<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cancel</title>
</head>
<body>
<h4>予約取消画面</h4>

<form action="ConfirmCancel" method="post">
<table>
<tr>
<td>番号：</td><td><input type="text" name="number"></td>
</tr><tr>
<td colspan=2>
<input type="submit" value="予約取消確認に進む">
</td></tr></table>
</form>
<form action="Admin" method="post">
<table><tr><td>
<input type="submit" value="戻る">
</td></tr></table>
</form>
</body>
</html>