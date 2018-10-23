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

For bootstrapping the form, and also getting the current date/time
-->

<form:form method="POST" action="posttopic" modelAttribute="topic">

<div class="form-horizontal">
	<h2>Post a New Topic</h2>
	<hr/>
	<br/>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="date">Date:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="date" readonly="true" value="<%= (new java.util.Date()).toLocaleString()%>"></form:input>
    			<form:errors path="date" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="title">Topic:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="title"></form:input>
    			<form:errors path="title" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="col-md-2 control-label" path="category" for="categories">Category:</form:label>
    		<div class="col-md-10">
    			<form:select class="form-control text-body" path="category" id="categories">
				    <option>Education</option>
				    <option>Stock Market</option>
				    <option>Entertainment</option>
				    <option>Social Media</option>
				    <option>Politics</option>
				</form:select>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="body">Body:</form:label>
    		<div class="col-md-10">
    			<form:textarea class="form-control" rows="5" path="body"></form:textarea>
    			<form:errors path="body" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Post" class="btn btn-default" />
		</div>
	</div>

</div>

</form:form>
