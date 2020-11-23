<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="freeasg.CustomerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ConfirmCancel</title>
</head>
<body>
<%!
String getDate(){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	return sdf.format(new Date());
}
%>

<%=getDate() %>
<br>
<form action="CancelingIsDone" method="post">
<input type="submit" value="予約取消">
</form>
<table border = "1">
<tr><td>番号</td><td>名前</td><td>人数</td><td>座席</td><td>予約時刻</td></tr>

<%
List<CustomerInfo> clist = (ArrayList<CustomerInfo>)request.getAttribute("clist");
for(CustomerInfo c : clist){
%>
<tr>
<td><%=c.getNumber() %></td>
<td><%=c.getName() %></td>
<td><%=c.getCusCount() %>人</td>
<td><%=c.getSeat() %></td>
<td><%=c.getCusTime() %></td>
</tr>
<%
}
%>
</table>
</body>
</html>