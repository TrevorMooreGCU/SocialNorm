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

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
	.banner-section{
		background-image:url("${pageContext.request.contextPath}/resources/images/${topic.category}.jpg");
		background-size:cover;
		height: 380px;
		left: 0;
		position: absolute;
		top: 0;
		background-position:0;
	}
	li.ui-state-default{
	    background:#fff0;
	    border:none;
	    border-bottom:1px solid #ddd;
	    text-align: left;
	    padding-bottom: 10px;
	}
	
	li.ui-state-default:last-child{
	    border-bottom:none;
	}
	
	@import url(http://fonts.googleapis.com/css?family=Roboto:400);
	body {
	  background-color:#fff;
	  -webkit-font-smoothing: antialiased;
	  font: normal 14px Roboto,arial,sans-serif;
	}
	
	.btn,.form-control,.well {
	    border-radius:1px;
	    box-shadow:0 0 0;
	}
	
	.form-control {
	    border-color:#d7d7d7;
	}
	
	.btn-primary {
	    border-color:transparent;
	}
	
	.btn-primary, .list-group-item.active:focus {
	    background-color:#4285f4;
	} 
	
	.btn-plus {
	    background-color:#ffffff;
	    border-width:1px;
	    border-color:#dddddd;
	    box-shadow:1px 1px 0 #999999;
	    border-radius:3px;color:#666666;
	    text-shadow:0 0 1px #bbbbbb;
	}
	
	.well,.panel {
	    border-color:#d2d2d2;
	    box-shadow:0 1px 0 #cfcfcf;
	    border-radius:3px;
	}
	
	hr {
	 border-color:#ececec;
	}
	
	button {
	 outline: 0;
	}
	
	.btn span{
	 color:#666666;
	}
	
	.list-group-item:first-child,.list-group-item:last-child {
	 border-radius:0;
	}
</style>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<section class="banner-section">
</section>
<section class="post-content-section">
    <div class="container">

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 post-title-block">
               <div style="background-color:rgba(0, 0, 0, 0.5);">
                <h1 style="text-align: center; font-size: 60px; font-weight: bold;">${topic.title}</h1>
                <ul class="list-inline text-center">
                    <li>${topic.category} | ${topic.date}</li>
                </ul>
               </div>
            </div>
            <div class="col-lg-9 col-md-9 col-sm-12">
            <div class="well">
				<p style="color: #000000">${topic.body}</p>
				
				<p style="color: #696969"><span class="glyphicon glyphicon-time" style="color: #696969"></span> ${topic.date}</p>
			</div>
				<!--  
                 <div class="well">
                    <large style="color: #696969">Comments coming soon!</large>
                </div>
                -->
<!-- 
                <blockquote>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
  <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>
</blockquote>
-->
                
<!-- 
                 <div class="image-block">
                     <img src="https://static.pexels.com/photos/268455/pexels-photo-268455.jpeg" class="img-responsive" >
                 </div> input-sm chat-input
-->
<div class="well">
        <h4 style="color: #000000">What's on your mind?</h4>
        <form:form method="POST" action="${pageContext.request.contextPath}/create/addcomment?id=${topic.id}" modelAttribute="thecomment">
    <div class="input-group">
        <form:input type="text" path="comment" class="form-control" placeholder="Write your comment here..." style="max-width: 100% !important"/>
	    <span class="input-group-btn" >
            <button type="submit" class="btn btn-default" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-comment" style="color: #DCDCDC"></span> Comment</button>
        </span>
    </div>
    <form:errors path="comment" cssClass="errors"/>
    </form:form>
    </div>
    <div class="well">
    <h5 style="color: #000000">Comments:</h5>
    <hr data-brackets-id="12673">
    <ul data-brackets-id="12674" id="sortable" class="list-unstyled ui-sortable">
    <c:forEach var="comment" items="${comments}">
    <c:choose>
        <c:when test="${comment.userid == userid}">
        	<strong class="pull-left primary-font" style="color: #000000">${comment.username}</strong>
        </c:when>
        <c:otherwise>
        	<a href="<c:url value="/view/account?id=${comment.userid}" />"><strong class="pull-left primary-font" style="color: #000000">${comment.username}</strong></a>
        </c:otherwise>
    </c:choose>
    
        <small class="pull-right text-muted">
           <span class="glyphicon glyphicon-time" style="color: #696969"></span> ${comment.date}</small>
        <br/>
        <br/>
        <li class="ui-state-default">${comment.comment} </li>
        <br/>
    </c:forEach>
    </ul>
    </div>

             </div>
             
             
             <div class="col-lg-3  col-md-3 col-sm-12">
             <c:choose>
            <c:when test="${topic.userid == userid}">
                 
                	<div class="well">
	                    <h2 style="color: #000000">Update Your Topic</h2>
	                    <img src="" class="img-rounded" />
	                    <p style="color: #000000">Feel free to change or delete your Topic. If you accidentally made any grammar mistakes in your Title or Body, we've got your back.</p>
	                    <a href="<c:url value="/update/topic?id=${topic.id}" />" class="btn btn-default" style="color: #000000">Update</a>
	                    <a href="<c:url value="/delete/topic?id=${topic.id}" />" class="btn btn-default" style="color: #000000">Delete</a>
                	</div>

            </c:when>
            <c:otherwise>
                
            </c:otherwise>
        </c:choose>
             
           
                	<div class="well">
	                    <h2 style="color: #000000">Get Social!</h2>
	                    <img src="" class="img-rounded" />
	                    <p style="color: #000000">Feel free to comment on the topic. Don't worry about what you say, we'll make sure you stay anonymous. </p>
	                    <!-- <a href="#" class="btn btn-default" style="color: #000000">Comment</a>-->
                	</div>
            	</div>
            
            
            
            
        </div><!--  end row  -->
        

        
    </div> <!-- /container -->
</section>

