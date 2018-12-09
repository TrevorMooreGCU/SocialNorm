<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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

<style>
	@media only screen and (max-width: 420px) {
	h1 {
		font-size: 30px !important;
	}
	h2 {
		font-size: 25px;
	}
	}
	.custom-tooltip {
		color: black;
	}
	.navbar{
		margin-bottom:0;
	}
	section{
		width:100%;
		float:left;
	}
	.post-title-block{
		padding:100px 0;
	}
	.post-title-block h1 {
		color: #fff;
		font-size: 85px;
		font-weight: bold;
		text-transform: capitalize;
	}
	.post-title-block li{
		font-size:20px;
		color: #fff;
	}
	.image-block{
		float:left;
		width:100%;
		margin-bottom:10px;
	}
	.footer-link{
		float:left;
		width:100%;
		background:#222222;
		text-align:center;
		padding:30px;
	}
	.footer-link a{
		color:#A9FD00;
		font-size:18px;
		text-transform:uppercase;
	}
	*{
	  margin:0;
	  padding:0;
	}
	.accordian{
	  width: 100%;
	  height: 333px;
	  overflow:hidden;
	  margin: 5px auto;
	  margin-left: 0px;
	  -webkit-box-shadow: 0 8px 6px -6px black;
	  -moz-box-shadow: 0 8px 6px -6px black;
	  box-shadow: 0px 8px 6px -6px black;
	}
	.accordian ul{
	  
	}
	.accordian li{
	  position: relative;
	  display:block;
	  width:160px;
	  float: left;
	  border-left: 1px solid #888;
	  -webkit-box-shadow: 0 0 25px 10px rgba(0,0,0,0.5);
	  -moz-box-shadow: 0 0 25px 10px rgba(0,0,0,0.5);
	  transition: all 0.5s;
	  -webkit-transition: all 0.5s;
	  -moz-transition: all 0.5s;
	}
	.accordian ul:hover li{
	  width: 160px;
	}
	.accordian ul li:hover{
	  width:500px;
	}
	.accordian li img{
	  width: 500px;
	  height: 333px;
	
	}
	.image_title{
	  background: rgba(0,0,0,0.5);
	  position:absolute;
	  left:0;
	  bottom:0;
	  width:500px;
	}
	.image_title a{
	  display: block;
	  color: #fff;
	  text-decoration: none;
	  padding:20px;
	  font-size:16px;
	}
	.simg {
	  overflow: hidden;
	  position: relative;
	  height: 290px;
	}
	.simg.Education {
	  background-image: url("${pageContext.request.contextPath}/resources/images/Education.jpg");
	  background-position: center;
	  background-repeat: no-repeat;
	  background-size: cover;
	}
	.simg.Stockmarket {
	  background-image: url("${pageContext.request.contextPath}/resources/images/Stock Market.jpg");
	  background-position: center;
	  background-repeat: no-repeat;
	  background-size: cover;
	}
	.simg.Entertainment {
	  background-image: url("${pageContext.request.contextPath}/resources/images/Entertainment.jpg");
	  background-position: center;
	  background-repeat: no-repeat;
	  background-size: cover;
	}
	.simg.Politics {
	  background-image: url("${pageContext.request.contextPath}/resources/images/Politics.jpg");
	  background-position: center;
	  background-repeat: no-repeat;
	  background-size: cover;
	}
	.simg.Socialmedia {
	  background-image: url("${pageContext.request.contextPath}/resources/images/Social Media.jpg");
	  background-position: center;
	  background-repeat: no-repeat;
	  background-size: cover;
	}
	.simg simg {
	  max-width: 100%;
	  min-width: 100%;
	  min-height: 100%;
	}
	#pinBoot {
	  position: relative;
	  max-width: 100%;
	  width: 100%;
	}
	.specialimg {
	  width: 100%;
	  max-width: 100%;
	  height: auto;
	}
	.specialig {
	  width: auto;
	  max-width: auto;
	}
	.white-panel {
	  position: absolute;
	  background: white;
	  box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3);
	  padding: 10px;
	}
	.bloggies {
		color: #000000;
	}
	.white-panel h1 {
	  font-size: 1em;
	}
	.white-panel h1 a {
	  color: #A92733;
	}
	.white-panel:hover {
	  box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.5);
	  margin-top: -5px;
	  -webkit-transition: all 0.3s ease-in-out;
	  -moz-transition: all 0.3s ease-in-out;
	  -o-transition: all 0.3s ease-in-out;
	  transition: all 0.3s ease-in-out;
	}
	option {
	  	color: #000000;
	}
	.errors {
		color: #ff0000;
	}
	.navbar {
    	position: fixed;
	}
	.brand {
	    position: absolute;
	    display: block;
	}
	h4, .control-label {
		color: #fff
	}
	.form-horizontal {
		min-height: 70%;
		width: 100%;
		padding: 19px;
		position: relative;
		
		background: rgba(0, 0, 0, 0.6);
		margin-bottom: 80px;
		padding-bottom: 20px;
		border: 1px solid #464646;
		border-radius: 4px;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
	}
	*{
		color: #fff;
	
	}
	body {
		background: url("${pageContext.request.contextPath}/resources/images/background.jpg");
		padding: 0px;
		height: 100%;
		background-attachment: fixed;
		background-repeat: no-repeat;
		background-size: cover;
		margin: 0px;
	}
	#login-dp{
		min-width: 250px;
		padding: 14px 14px 0;
		overflow:hidden;
		background-color:rgba(255,255,255,.8);
	}
	#login-dp .help-block{
		font-size:12px
	}
	#login-dp .bottom{
		background-color:rgba(255,255,255,.8);
		border-top:1px solid #ddd;
		clear:both;
		padding:14px;
	}
	#login-dp .social-buttons{
		margin:12px 0
	}
	#login-dp .social-buttons a{
		width: 49%;
	}
	#login-dp .form-group {
		margin-bottom: 10px;
	}
	.btn-fb{
		color: #fff;
		background-color:#3b5998;
	}
	.btn-fb:hover{
		color: #fff;
		background-color:#496ebc
	}
	.btn-tw{
		color: #fff;
		background-color:#55acee;
	}
	.btn-tw:hover{
		color: #fff;
		background-color:#59b5fa;
	}
</style>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>SocialNorm</title>
	<script src="<c:url value="/resources/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/mdb.js" />"></script>
	<script src="<c:url value="/resources/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery-1.10.2.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery.unobtrusive-ajax.js" />"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"></link>
</head>

<body>
	<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<div class="container body-content" style="padding-bottom: 100px">
		<tiles:insertAttribute name="body" />
	</div>

	<!-- Footer -->
	<div class="footer" style="padding-top: 15%;">
		<tiles:insertAttribute name="footer" />
	</div>
</body>

</html>