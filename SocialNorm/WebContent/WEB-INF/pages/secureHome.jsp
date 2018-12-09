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

	#carouselButtons {
	    margin-left: 100px;
	    position: absolute;
	    bottom: 0px;
	}

</style>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="6000">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>
 
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="${pageContext.request.contextPath}/resources/images/image1.jpg">
      <div class="carousel-caption">
      	<h1>Welcome to SocialNorm!</h1>
          <p>The root for all your social networking needs.</p>
          <p><a class="btn btn-lg btn-primary" href="#">Learn More</a></p>
      </div>
    </div>
    <div class="item">
      <img src="${pageContext.request.contextPath}/resources/images/image2.jpg">
      <div class="carousel-caption">
      	<h1>Explore!</h1>
          <p>Feel free to browse our site and enjoy all our content.</p>
          <p><a class="btn btn-large btn-primary" href="#">Learn more</a></p>
      </div>
    </div>
    <div class="item">
      <img src="${pageContext.request.contextPath}/resources/images/image3.jpg">
      <div class="carousel-caption">
      	<h1>Sign Up and Get Started!</h1>
          <p>Register and login to connect, view, and share your accomplishments with anyone across the world.</p>
          <p><a class="btn btn-large btn-primary" href="#">Learn More</a></p>
      </div>
    </div>
  </div>
 
  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div> <!-- Carousel -->









<script>
	$('.carousel').carousel({
		interval: 3000
	})
</script>
