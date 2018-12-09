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

<script>

	// Creating the function for toolTip, a Jquery feature!
	$(function toolTip() {
		//Setting the tooltip to the document. By default, the tooltip will show any element with a title tag.
		//Even if you put a title tag on the submit button it'd show the text in the tool tip
		$('.form-control').tooltip({

			//Defining the custom class to modify the ui-tooltip-content class.
			//This was we change the text from white on white to black on white
			classes: {
			    "ui-tooltip-content": "custom-tooltip"
			  },
			  //Track means the tooltip follows the map
			track : true,
			//This is the show effect, in this case, it's slide down with a 250 ms delay
			show : {
				effect : "slideDown",
				delay : 700
			},
			// This is the hide effect, either slideUp or explode are both fun effects. Can be changed if we prefer "explode". 250 ms delay
			hide: {
		        effect: "slideUp",
		        delay: 250
		      }
		});
	});

</script>

<form:form id="register" method="POST" action="registeruser" modelAttribute="register">

<div class="form-horizontal">
	<h2>Sign Up</h2>
	<hr/>
	<br/>
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="firstName">First Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="firstName"
    			title="Input your first name. Cannot be left blank. Must be between 2 and 25 characters."></form:input>
    			<form:errors path="firstName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="lastName">Last Name:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="lastName"
    			title="Input your last name. Cannot be left blank. Must be between 2 and 25 characters."></form:input>
    			<form:errors path="lastName" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="email">Email:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="email"
    			title="Input your email. Cannot be left blank. Must be a valid email."></form:input>
    			<form:errors path="email" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="phone">Phone:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="phone"
    			title="Input your phone number. Cannot be left blank. Must be a valid phone number."></form:input>
    			<form:errors path="phone" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="username">Username:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" path="username"
    			title="Input your username. Cannot be left blank. Must be between 8 and 25 characters."></form:input>
    			<form:errors path="username" cssClass="errors"/>
			</div>
	</div>
	
	<div class="form-group">
    	<form:label class="control-label col-md-2" path="password">Password:</form:label>
    		<div class="col-md-10">
    			<form:input class="form-control" type="password" path="password"
    			title="Cannot be left blank. Must contain at least 8 characters, 1 uppercase and lowercase letter, 1 number and 1 special character."></form:input>
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
