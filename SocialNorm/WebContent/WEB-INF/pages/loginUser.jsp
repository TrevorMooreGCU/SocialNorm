<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- 
Trevor Moore
CST-341
12/06/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://www.w3schools.com/bootstrap/bootstrap_navbar.asp
https://bootsnipp.com/snippets/featured/fancy-navbar-login-sign-in-form
https://www.w3schools.com/bootstrap/bootstrap_ref_comp_glyphs.asp
https://bootsnipp.com/snippets/featured/fancy-navbar-login-sign-in-form
https://bootsnipp.com/snippets/OORq
http://www.jqueryscript.net/layout/Simple-jQuery-Plugin-To-Create-Pinterest-Style-Grid-Layout-Pinterest-Grid.html
https://bootsnipp.com/snippets/featured/message-chat-box
https://bootsnipp.com/snippets/featured/simple-comment-block

For boostrapping the navbar with cool css, the pinterest grid, comment UI, and chats UI
-->

<form:form method="POST" action="loginuser" modelAttribute="login">

<div class="form-horizontal">
	<h2>Login</h2>
	<hr/>
	<br/>
	
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
			<input type="submit" value="Login" class="btn btn-default" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<p style="color:#ff0000;">${message}</p>
		</div>
	</div>
	
</div>

</form:form>


