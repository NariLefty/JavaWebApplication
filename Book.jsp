<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>
<h4>予約画面</h4>

<form action="ConfirmBook" method="post">
<table>
<tr>
<td>名前：</td><td><input type="text" name="name"></td>
</tr><tr>
<td>人数：</td><td><input type="text" name="cusCount"></td>
</tr><tr><td>座席</td><td>
<input type="radio" name="radio1" value="禁煙" checked>禁煙
<input type="radio" name="radio1" value="喫煙">喫煙</td>
</tr><tr><td colspan=2>
<input type="submit" value="予約確認に進む">
</td></tr></table>
</form>
<form action="Customer" method="post">
<table><tr><td>
<input type="submit" value="戻る">
</td></tr></table>
</form>
</body>
</html>