<!-- 
Trevor Moore
CST-341
9/22/2018
This assignment was completed in collaboration with Trevor Moore and Aaron Ross

We used source code from the following websites to complete this assignment:
https://bootstrapbay.com/blog/bootstrap-3-carousel-tutorial/ 
http://javawebtutor.com/articles/spring/configuring-static-resources-in-spring-mvc.php

For making the carousel
-->
  
<style>

	#carouselButtons {
	    margin-left: 100px;
	    position: absolute;
	    bottom: 0px;
	}

</style>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="3000">
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
