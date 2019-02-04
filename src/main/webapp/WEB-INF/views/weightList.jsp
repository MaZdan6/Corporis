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
			</table>
			
			
			
			
			
			<div id="example-table"></div>
			<script type="text/javascript">
			//define some sample data
			 var tabledata = [
			        {
			            "id": 6,
			            "date": "2019-01-01T19:56:38.656+0000",
			            "userId": 1,
			            "weight": 90.1
			        },
			        {
			            "id": 7,
			            "date": "2019-01-02T19:56:47.747+0000",
			            "userId": 1,
			            "weight": 91.1
			        },
			        {
			            "id": 8,
			            "date": "2019-01-03T19:56:54.501+0000",
			            "userId": 1,
			            "weight": 92.1
			        },
			        {
			            "id": 9,
			            "date": "2019-01-04T19:57:01.232+0000",
			            "userId": 1,
			            "weight": 93.1
			        },
			        {
			            "id": 10,
			            "date": "2019-01-05T19:57:15.641+0000",
			            "userId": 1,
			            "weight": 94.1
			        }
			    ];
			
			
			//create Tabulator on DOM element with id "example-table"
			 var table = new Tabulator("#example-table", {
			  	height:205, // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
			  	data:tabledata, //assign data to table
			  	layout:"fitColumns", //fit columns to width of table (optional)
			  	columns:[ //Define Table Columns
			 	 	{title:"id", field:"id", width:150},
			 	 	{title:"date", field:"date", sorter:"date", align:"center", width:250},
			 	 	{title:"userId", field:"userId"},
			 	 	{title:"weight", field:"weight"}
			 	 	
			  	],
			  	rowClick:function(e, row){ //trigger an alert message when the row is clicked
			  		alert("Row " + row.getData().id + " Clicked!!!!");
			  	},
			  	
			  	 pagination:"remote", //enable remote pagination
			     ajaxURL:"http://localhost:8080/corporis/api/weight/getWeightList", //set url for ajax request
			     ajaxParams:{userId:1}, //set any standard parameters to pass with the request
			     paginationSize:5, //optional parameter to request a certain number of rows per page
			     paginationDataReceived:{
			         "data":"content", //change last_page parameter name to "max_pages"
			         "last_page":"totalPages"
			     } ,
			 });
			</script>
			
			
			<script type="text/javascript">
			//define some sample data
/*			 var tabledata = [
			 	{id:1, name:"Oli Bob", age:"12", col:"red", dob:""},
			 	{id:2, name:"Mary May", age:"1", col:"blue", dob:"14/05/1982"},
			 	{id:3, name:"Christine Lobowski", age:"42", col:"green", dob:"22/05/1982"},
			 	{id:4, name:"Brendon Philips", age:"125", col:"orange", dob:"01/08/1980"},
			 	{id:5, name:"Margret Marmajuke", age:"16", col:"yellow", dob:"31/01/1999"},
			 ];
			
			
			//create Tabulator on DOM element with id "example-table"
 			 var table = new Tabulator("#example-table", {
			  	height:205, // set height of table (in CSS or here), this enables the Virtual DOM and improves render speed dramatically (can be any valid css height value)
			  	data:tabledata, //assign data to table
			  	layout:"fitColumns", //fit columns to width of table (optional)
			  	columns:[ //Define Table Columns
			 	 	{title:"Name", field:"name", width:150},
			 	 	{title:"Age", field:"age", align:"left", formatter:"progress"},
			 	 	{title:"Favourite Color", field:"col"},
			 	 	{title:"Date Of Birth", field:"dob", sorter:"date", align:"center"},
			  	],
			  	rowClick:function(e, row){ //trigger an alert message when the row is clicked
			  		alert("Row " + row.getData().id + " Clicked!!!!");
			  	},
			 }); */
			</script>
		</div>



</body>
</html>