<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Weight</title>
</head>
<body>
	<div class="container">
		<%@include file="header.jsp"%>

		<div class="row">
			<div class="col-12">
				<a href="<c:url value='/newAccount'/>"
					class="btn btn-large	 btn-primary">Add new weight</a>
			</div>


			<table class="table table-bordered table-hover">
				<thead class="bg-success">
					<tr>
						<th>id</th>
						<th>date</th>
						<th>weight</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
				
									<c:forEach var="weight" items="${weightList}">
						<c:url var="updateLink" value="/edit">
							<c:param name="id" value="${weight.id}" />
						</c:url>
						<c:url var="deleteLink" value="/delete">
							<c:param name="id" value="${weight.id}" />
						</c:url>
						<tr>
							<td>${weight.id}</td>
							<td>${weight.date}</td>
							<td>${weight.weight}</td>
							<td><a href="${updateLink}" class="btn btn-warning">Edit</a>
								<a href="${deleteLink}" class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>