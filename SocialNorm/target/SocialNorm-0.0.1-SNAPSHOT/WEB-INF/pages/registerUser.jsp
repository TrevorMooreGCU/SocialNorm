<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- 
Trevor Moore
CST-341
9/22/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://www.w3schools.com/bootstrap/bootstrap_forms.asp

For bootstrapping the form
-->

<form:form method="POST" action="registeruser" modelAttribute="register">

<div class="form-horizontal" style="overflow-x:scroll;">
	<h2>Sign Up</h2>
	<hr/>
	<br/>
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="firstName">First Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="firstName"></form:input>
    			<form:errors path="firstName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="lastName">Last Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="lastName"></form:input>
    			<form:errors path="lastName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="email">Email:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="email"></form:input>
    			<form:errors path="email" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="phone">Phone:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="phone"></form:input>
    			<form:errors path="phone" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="username">Username:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="username"></form:input>
    			<form:errors path="username" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="password">Password:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" type="password" path="password"></form:input>
    			<form:errors path="password" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Sign Up" class="btn btn-default" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<p style="color:#ff0000;">${message}</p>
		</div>
	</div>

</div>

</form:form>
