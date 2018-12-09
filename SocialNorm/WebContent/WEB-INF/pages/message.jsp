<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
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

<style>
	.banner-section{background-image:url("${pageContext.request.contextPath}/resources/images/directmessages.jpg"); background-size:cover; height: 380px; left: 0; position: absolute; top: 0; background-position:0;}
	.container {
		max-width:1170px;
		margin:auto;
	}
	img {
		max-width:100%;
	}
	.inbox_people {
		background: #f8f8f8 none repeat scroll 0 0;
		float: left;
		overflow: hidden;
		width: 40%; border-right:1px solid #c4c4c4;
	}
	.inbox_msg {
		border: 1px solid #c4c4c4;
		clear: both;
		overflow: hidden;
	}
	.top_spac {
		margin: 20px 0 0;
	}
	.recent_heading {
		float: left;
		width:40%;
	}
	.srch_bar {
		display: inline-block;
		text-align: right;
		width: 60%; padding:
	}
	.headind_srch{
		padding:10px 29px 10px 20px;
		overflow:hidden;
		border-bottom:1px solid #c4c4c4;
	}
	.recent_heading h4 {
		color: #05728f;
		font-size: 21px;
		margin: auto;
	}
	.srch_bar input { 
		border:1px solid #cdcdcd;
		border-width:0 0 1px 0;
		width:80%;
		padding:2px 0 4px 6px;
		background:none;
	}
	.srch_bar .input-group-addon button {
		background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
		border: medium none;
		padding: 0;
		color: #707070;
		font-size: 18px;
	}
	.srch_bar .input-group-addon {
		margin: 0 0 0 -27px;
	}
	.chat_ib h5 {
		font-size:15px;
		color:#464646;
		margin:0 0 8px 0;
	}
	.chat_ib h5 span {
		font-size:13px;
		float:right;
	}
	.chat_ib p {
		font-size:14px;
		color:#989898;
		margin:auto;
	}
	.chat_img {
		float: left;
		width: 11%;
	}
	.chat_ib {
		float: left;
		padding: 0 0 0 15px;
		width: 88%;
	}
	.chat_people {
		overflow:hidden;
		clear:both;
	}
	.chat_list {
		border-bottom: 1px solid #c4c4c4;
		margin: 0;
		padding: 18px 16px 10px;
	}
	.inbox_chat { 
		height: 280px;
		overflow-y: scroll;
	}
	.active_chat{ 
		background:#ebebeb;
	}
	.incoming_msg_img {
		display: inline-block;
		width: 6%;
	}
	.received_msg {
		display: inline-block;
		padding: 0 0 0 10px;
		vertical-align: top;
		width: 92%;
	 }
	 .received_withd_msg p {
		background: #ebebeb none repeat scroll 0 0;
		border-radius: 3px;
		color: #646464;
		font-size: 14px;
		margin: 0;
		padding: 5px 10px 5px 12px;
		width: 100%;
	}
	.time_date {
		color: #747474;
		display: block;
		font-size: 12px;
		margin: 8px 0 0;
	}
	.received_withd_msg { 
		width: 57%;
	}
	.mesgs {
		float: left;
		padding: 30px 15px 0 25px;
		width: 60%;
	}
	 .sent_msg p {
		background: #05728f none repeat scroll 0 0;
		border-radius: 3px;
		font-size: 14px;
		margin: 0; color:#fff;
		padding: 5px 10px 5px 12px;
		width:100%;
	}
	.outgoing_msg {
		overflow:hidden;
		margin:26px 0 26px;
	}
	.sent_msg {
		float: right;
		width: 46%;
	}
	.input_msg_write input {
		background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
		border: medium none;
		color: #4c4c4c;
		font-size: 15px;
		min-height: 48px;
		width: 100%;
		max-width: 100% !important;
	}
	.type_msg {
		border-top: 1px solid #c4c4c4;
		position: relative;
	}
	.msg_send_btn {
		background: #05728f none repeat scroll 0 0;
		border: medium none;
		border-radius: 50%;
		color: #fff;
		cursor: pointer;
		font-size: 17px;
		height: 33px;
		position: absolute;
		right: 0;
		top: 11px;
		width: 33px;
	}
	.messaging { 
		padding: 0 0 50px 0;
	}
	.msg_history {
		height: 516px;
		overflow-y: auto;
	}
	input {
		margin: 0 !important;
	}
</style>




<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet">


<!-- <section class="post-content-section">
<div class="container">


<div class="messaging">
      <div class="inbox_msg">-->
<section class="banner-section">
</section>

<section class="post-content-section">
    <div class="container">
        <div class="row">
        
        <div class="col-lg-12 col-md-12 col-sm-12 post-title-block">
              <div style="background-color:rgba(0, 0, 0, 0.5);">
               <h1 style="text-align: center; font-size: 60px; font-weight: bold;">Direct Messages</h1>
               	<ul class="list-inline text-center">
                   	<li>Stay Connected | Down in the DMs</li>
               	</ul>
           	</div>
       	</div>
        
        <div class="col-lg-9 col-md-9 col-sm-12">
	      <div class="well">
	       <h4 style="color: #000000">${usersender.username}</h4>
			<div class="inbox_chat">
			
			
			<c:forEach var="message" items="${messages}">
			
			<c:choose>
        	<c:when test="${message.senderid == usersender.id}">
	            <div class="incoming_msg">
	              <div class="incoming_msg_img"> <img src="<c:url value="/resources/images/profile.png" />"> </div>
	              <div class="received_msg">
	                <div class="received_withd_msg">
	                  <p>${message.messagebody}</p>
	                  <span class="time_date" style="color: #000000"> ${message.creationdate}</span></div>
	              </div>
	            </div>
	         </c:when>
       		 <c:otherwise>
	            <div class="outgoing_msg">
	              <div class="sent_msg">
	                <p>${message.messagebody}</p>
	                <span class="time_date" style="color: #000000"> ${message.creationdate}</span> </div>
	            </div>
            </c:otherwise>
            </c:choose>
            </c:forEach>

	          </div>

	          <form:form method="POST" action="${pageContext.request.contextPath}/create/sendmessage?id=${usersender.id}" modelAttribute="message">
	          <div class="type_msg">
	            <div class="input_msg_write">
	            	<div style="width: 95%">
	              <form:input class="form-control" type="text" path="messagebody" placeholder="Type your message" style="margin: 0px;"/>
					</div>
	              <form:hidden path="senderid" value="${senderid}" />
	              <form:hidden path="receiverid" value="${receiverid}" />
	              <button class="msg_send_btn" type="submit"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
	              </div>
	            <form:errors path="messagebody" cssClass="errors"/>
	          </div>
    		</form:form>
    		
			</div>
	    </div>
	    
      
    <div class="col-lg-3  col-md-3 col-sm-12">
   		<div class="well">
	          <h4 style="color: #000000">All Conversations</h4>
	          <div class="inbox_chat">
	          
	          <c:forEach var="chat" items="${chats}">
	          
	            <div class="chat_list">
	              <div class="chat_people">
	                <div class="chat_img"> <img src="<c:url value="/resources/images/profile.png" />"> </div>
	                <div class="chat_ib">
	                  <h5><a href="<c:url value="/create/message?id=${chat.userid}" />">${chat.username}</a></h5>
	                  <p>${chat.messagebody}</p>
	                </div>
	              </div>
	            </div>
	            
            </c:forEach>
	            
          </div>
        </div>
       </div>
        
        
  
        
        
      </div>
    </div>
</section>

