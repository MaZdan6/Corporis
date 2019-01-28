<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<div class="container">
	<%@include file="header.jsp"%>

	<div class="row">
		<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
			<h2 class="page-header">Please fill up the form details</h2>
		</div>
		

		<div class="row">
			<div class="col-12">
				<form:form method="POST" action="/corporis/weight/save" modelAttribute="weightEntity"	
					cssClass="form-horizontal" role="form">

					<form:hidden path="userId"/>

					<div class="form-group row">
						<Label for="weight" class="col-6 col-form-label">Weight</Label>
						<div class="col-6">
							<form:input path="weight" cssClass="form-control"/>
							<form:errors path="weight" cssClass="error" />
							<text class="alert-danger">${message}</text>
						</div>
					</div>



					<div class="form-group row col-12">
						<input type="submit" value="Save Weight" name="btnSubmit"
							class="btn btn-primary">
					</div>


				</form:form>
			</div>

		</div>


	</div>
	</div>
</body>
</html>