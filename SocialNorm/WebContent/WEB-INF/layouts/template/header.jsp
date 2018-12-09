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
https://bootsnipp.com/snippets/featured/fancy-navbar-login-sign-in-form
https://bootsnipp.com/snippets/OORq
http://www.jqueryscript.net/layout/Simple-jQuery-Plugin-To-Create-Pinterest-Style-Grid-Layout-Pinterest-Grid.html
https://bootsnipp.com/snippets/featured/message-chat-box
https://bootsnipp.com/snippets/featured/simple-comment-block

For boostrapping the navbar with cool css, the pinterest grid, comment UI, and chats UI
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
				<a href="<c:url value="/" />"><img src="<c:url value="/resources/images/socialnormlogo.png" />" width="120" height="40" align="left" style="margin-top: 3px; padding-left: 5px" class="logo" /></a>
			</div>
			<!-- end responsive hamburger -->
			
			
			
			
			<!-- Everything inside this will be collapsed into hamburger if resized (responsive) -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

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
				</ul>
				
				

				<!--Search form start -->
				<div class="navbar-form navbar-left" role="search">
				    <div class="form-group">
				        <input type="text" class="form-control" placeholder="Search" name="search" maxlength="25"></input>
				    </div>
				    <a href="#" ><input type="submit" class="btn btn-default" value="Search" /></a>
				</div>
				<!--Search form end -->

				




				<!--the right side of the navbar -->
				<ul class="nav navbar-nav navbar-right">
					<!-- Register link start -->
					<li><a href="<c:url value="/register/" />"><b>Register</b> <span class="glyphicon glyphicon-user"></span></a></li>
					<!-- register link end -->
					
					<!--Login form start-->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="glyphicon glyphicon-log-in"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								<div class="row">
									<div class="col-md-12">

										<!-- The actual login form: -->
										<form:form method="POST" action="${pageContext.request.contextPath}/login/loginuser" modelAttribute="login" class="form-inline">

										<div>

											<h4 style="color: #000000">Login</h4>
											<hr />
											<div class="form-group">
												<div class="col-md-12">
													<form:input path="username" class="form-control mr-sm-2" value="TrevorMMoore" placeholder="Username" aria-label="Username"/>
													<form:errors path="username" cssClass="errors"/>
												</div>
											</div>

											<div class="form-group">
												<div class="col-md-12">
													<form:input path="password" type="password" class="form-control mr-sm-2" value="$Shanklin86" placeholder="Password" aria-label="Password"/>
													<form:errors path="password" cssClass="errors"/>
												</div>
											</div>

											<div class="form-group">
												<div class="col-md col-md-12">
													<input type="submit" id="btnLogin" value="Login" class="btn btn-primary" />
												</div>
											</div>

										</div>
										</form:form>
										<!-- end actual login form -->
										</div>

									<div class="bottom text-center" style="color: #000000">
										Don't have an account?
										<br/>
										<!-- Link to the register page -->
										<a href="<c:url value="/register/" />"><b style="color: #0951a0">Sign Up Here</b></a>
									</div>
								</div>
							</li>
						</ul>
					</li><!-- login form end -->
				</ul>
				
				
				
				
			</div><!-- navbar-collapse end -->
			
			
			
			
		</div><!-- container-fluid end -->
		
		
		
		
	</nav><!-- navbar end -->

</body>

<br/>
<br/>

