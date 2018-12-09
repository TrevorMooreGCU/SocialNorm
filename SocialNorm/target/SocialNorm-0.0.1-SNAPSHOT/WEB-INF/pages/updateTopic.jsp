<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>

<!-- 
Trevor Moore
CST-341
10/10/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://www.w3schools.com/bootstrap/bootstrap_forms.asp
https://www.w3schools.com/bootstrap/bootstrap_forms_inputs.asp
https://www.guru99.com/jsp-date-handling.html

For bootstrapping the form
-->

<form:form method="POST" action="updatetopic" modelAttribute="topic">

<div class="form-horizontal" style="overflow-x:scroll;">
	<h2>Update Your Topic</h2>
	<hr/>
	<br/>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="date">Date:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="date" readonly="true" value="${date}"></form:input>
    			<form:errors path="date" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="title">Topic:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="title" value="${title}"></form:input>
    			<form:errors path="title" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="category" for="categories">Category:</form:label>
    		<div class="col-md-10">
				<form:input class="form-control" path="category" readonly="true" value="${category}"></form:input>
    			<form:errors path="category" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="body">Body:</form:label>
    		<div class="col-md-10">
    			<form:textarea class="form-control" rows="5" path="body" value="${body}"></form:textarea>
    			<form:errors path="body" cssClass="errors"/>
			</div>
	</div>
	
	<form:hidden path="id" value="${id}" />
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Update" class="btn btn-default" />
		</div>
	</div>

</div>

</form:form>
