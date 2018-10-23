<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- 
Trevor Moore
CST-341
9/22/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://www.w3schools.com/bootstrap/bootstrap_forms.asp

For boostrapping the div
-->

<form:form modelAttribute="search">

<div class="form-horizontal">

	<div class="form-group">
    		<div class="col-md-10">
    			<form:errors path="search" cssClass="errors"/>
			</div>
	</div>
	
</div>

</form:form>