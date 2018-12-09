<!-- 
Trevor Moore
CST-341
11/1/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://bootsnipp.com/snippets/RE68M

For the section
-->

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<style>
.banner-section{background-image:url("${pageContext.request.contextPath}/resources/images/${topic.category}.jpg"); background-size:cover; height: 380px; left: 0; position: absolute; top: 0; background-position:0;}
</style>

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
				<p style="color: #000000">${topic.body}</p>
                 <div class="well">
                    <large style="color: #696969">Comments coming soon!</large>
                </div>
<!-- 
                <blockquote>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
  <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>
</blockquote>
-->
                
<!-- 
                 <div class="image-block">
                     <img src="https://static.pexels.com/photos/268455/pexels-photo-268455.jpeg" class="img-responsive" >
                 </div>
-->

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
	                    <a href="#" class="btn btn-default" style="color: #000000">Comment</a>
                	</div>
            	</div>
            
            
            
            
        </div>
    </div> <!-- /container -->
</section>

