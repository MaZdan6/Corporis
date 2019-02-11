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

<style type="text/css">
</style>
</head>
<body>
	<div class="container">
		<%@include file="header.jsp"%>
		
		
		

		<div class="row">
			<div class="col-12">

				<c:url var="newLink" value='/weight/new'>
					<c:param name="userId" value="1"></c:param>
				</c:url>

				<a href="${newLink}" class="btn btn-large	 btn-primary">Add new
					weight</a>
			</div>


			<%-- <table class="table table-bordered table-hover">
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
						<c:url var="updateLink" value="/weight/edit">
							<c:param name="id" value="${weight.id}" />
						</c:url>
						<c:url var="deleteLink" value="/weight/delete">
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
			</table> --%>
			
			
			
			
			
			<div id="example-table"></div>
			
			<c:url var="getWeightList" value='/api/weight/getWeightList'>
				</c:url>
			<script type="text/javascript">
			//create Tabulator on DOM element with id "example-table"
			 var table = new Tabulator("#example-table", {
			  	layout:"fitColumns", //fit columns to width of table (optional)
			  	columns:[ //Define Table Columns
			 	 	{title:"id", field:"id", width:150},
			 	 	{title:"date", field:"date", sorter:"date", align:"center", width:250},
			 	 	{title:"userId", field:"userId"},
			 	 	{title:"weight", field:"weight"},
			 	 	{title:"id", field:"id", align:"center", editor:true, formatter:"cross"}
			 	 	
			  	],
			  	rowClick:function(e, row){ //trigger an alert message when the row is clicked
			  		alert("Row " + row.getData().id + " Clicked!!!!");
			  	},
			  	
			  	 pagination:"remote", //enable remote pagination
			     ajaxURL:"${getWeightList}", //set url for ajax request
			     ajaxParams:{userId:1}, //set any standard parameters to pass with the request
			     paginationSize:5, //optional parameter to request a certain number of rows per page
			     paginationDataReceived:{
			         "data":"content", //change last_page parameter name to "max_pages"
			         "last_page":"totalPages"
			     } ,
			 });
			</script>
			
			
		
		</div>



</body>
</html>