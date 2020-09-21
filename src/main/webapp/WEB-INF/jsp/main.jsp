<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>

<h1>MAIN</h1>

<form action="/search" method="get">
	검색어를 입력하세요.
	<input type="text" name="keyword" /><br/>
	페이지 : <input type="number" name="page" /><br/>
	페이지 사이즈 : <input type="number" name="size" />
	<input type="submit" value="검색" />
</form>

<div style="display:flex;flex-direction:row;justify-content:space-around;align-content:center">
	<div style="width:70%">
		<table border="1">
			<thead>
				<tr>
					<th>장소명</th>
					<th>주소</th>
					<th>도로명주소</th>
					<th>전화번호</th>
					<th>카테고리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${locationList}" varStatus="idx">
					<tr>
						<td style="width:20%"><a href="${item.placeUrl}" target="_blank"><c:out value="${item.placeName}" /></a></td>
						<td style="width:20%"><c:out value="${item.addressName}" /></td>
						<td style="width:20%"><c:out value="${item.roadAddressName}" /></td>
						<td style="width:10%"><c:out value="${item.phone}" /></td>
						<td style="width:30%"><c:out value="${item.categoryName}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div style="width:30%">
		<table border="1">
			<thead>
				<tr>
					<th>검색어</th>
					<th>횟수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${keywordList}" varStatus="idx">
					<tr>
						<td style="width:30%"><c:out value="${item.keyword}" /></td>
						<td style="width:30%"><c:out value="${item.count}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


</body>
</html>