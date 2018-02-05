<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户订单列表</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>订单号</td>
				<td>订单总额</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.orderNo}</td>
					<td>${order.orderMoney}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>