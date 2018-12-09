<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!-- 
Trevor Moore
CST-341
9/22/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://www.w3schools.com/bootstrap/bootstrap_navbar.asp
https://bootsnipp.com/snippets/featured/fancy-navbar-login-sign-in-form
https://www.w3schools.com/bootstrap/bootstrap_ref_comp_glyphs.asp

For boostrapping the navbar
-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/resources/Site.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet" type="text/css" id="bootstrap-css"/>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<body>
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation" style="background-image:none; background-color:rgba(0, 0, 0, 0.7); padding: 0px; left: 0; top: 0; width: 100%; position:fixed !important; border-radius: 0;">
		<div class="container-fluid">
		
		
		
		
		
			<!-- Brand and toggle get grouped for better mobile display (responsive hamburger) -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="<c:url value="/Home" />"><img src="<c:url value="/resources/images/socialnormlogo.png" />" width="120" height="40" align="left" style="margin-top: 3px; padding-left: 5px" class="logo" /></a>
			</div>
			<!-- end responsive hamburger -->
			
			
			
			
			<!-- Everything inside this will be collapsed into hamburger if resized (responsive) -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

<%
if(session.getAttribute("user") != null) {
%>
    	
    	<li><a href="<c:url value="/Home" />">Home</a></li>
					
					<li><a href="<c:url value="/create/socialize" />">Share</a></li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Socialize <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<c:url value="/view/category?id=Education" />">Education</a></li>
							<li><a href="<c:url value="/view/category?id=Stock Market" />">Stock Market</a></li>
							<li><a href="<c:url value="/view/category?id=Entertainment" />">Entertainment</a></li>
							<li><a href="<c:url value="/view/category?id=Social Media" />">Social Media</a></li>
							<li><a href="<c:url value="/view/category?id=Politics" />">Politics</a></li>
						</ul>
					</li>
    	
<% 
}
else {
%>

<!-- Link to the home page -->
					<li><a href="<c:url value="/" />">Home</a></li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">What's New? <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Education</a></li>
							<li><a href="#">Stock Market</a></li>
							<li><a href="#">Entertainment</a></li>
							<li><a href="#">Social Media</a></li>
							<li><a href="#">Politics</a></li>
						</ul>
					</li>
					<!-- dropdown option end -->
<%
}
%>
					
				</ul>
				
				

				<!--Search form start ${pageContext.request.contextPath}/search/usersearch -->
				<form method="POST" action="#" class="navbar-form navbar-left" role="search">
				    <div class="form-group">
				        <input type="text" class="form-control" placeholder="Search" ></input>
				    </div>
				    <a href="#" type="submit" class="btn btn-default" >Search</a>
				</form>
				<!--Search form end -->

				




				<!--the right side of the navbar -->
				<ul class="nav navbar-nav navbar-right">
<%
if(session.getAttribute("user") != null) {
%>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Profile <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<c:url value="/view/mytopics" />">My Topics</a></li>
						</ul>
					</li>
					<!-- Register link start -->
					<li><a href="<c:url value="/" />"><b>Logout</b> <span class="glyphicon glyphicon-log-out"></span></a></li>
<% 
}
else {
%>
					<!-- Register link start -->
					<li><a href="<c:url value="/register/" />"><b>Register</b> <span class="glyphicon glyphicon-user"></span></a></li>
					<!-- register link end -->
					
					<!--Login form start-->
					<li><a href="<c:url value="/login/" />"><b>Login</b> <span class="glyphicon glyphicon-log-in"></span></a></li>
<%
}
%>
					
				</ul>
				
				
				
				
			</div><!-- navbar-collapse end -->
			
			
			
			
		</div><!-- container-fluid end -->
		
		
		
		
	</nav><!-- navbar end -->

</body>

<br/>
<br/>

