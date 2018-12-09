<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

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

<form:form method="POST" action="deletetopic" modelAttribute="topic">

<div class="form-horizontal" style="overflow-x:scroll;">
	<h2>Delete Your Topic</h2>
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
    			<form:input class="form-control" path="title" readonly="true" value="${title}"></form:input>
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
    			<form:textarea class="form-control" rows="5" path="body" readonly="true" value="${body}"></form:textarea>
    			<form:errors path="body" cssClass="errors"/>
			</div>
	</div>
	
	<form:hidden path="id" value="${id}" />
	
	
	
	<div class="form-group">
		<label class="control-label col-md-2">Delete this topic?</label>
		<div class="col-md-10">
			<input type="submit" value="Yes" class="btn btn-default" style="width: 55px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="<c:url value="/view/topic?id=${topic.id}" />" class="btn btn-default" style="width: 55px">No</a>
		</div>
	</div>

</div>

</form:form>