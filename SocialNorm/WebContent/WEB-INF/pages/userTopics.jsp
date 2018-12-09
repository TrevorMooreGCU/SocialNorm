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

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.banner-section{background-image:url("${pageContext.request.contextPath}/resources/images/usertopics.jpg"); background-size:cover; height: 380px; left: 0; position: absolute; top: 0; background-position:0;}
</style>

<section class="banner-section">
</section>
<section class="post-content-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 post-title-block">
               <div style="background-color:rgba(0, 0, 0, 0.5);">
                <h1 style="text-align: center; font-size: 60px; font-weight: bold;">Welcome, ${user.username}</h1>
                	<ul class="list-inline text-center">
                    	<li>Stay Connected | Get Involved</li>
                	</ul>
            	</div>
        	</div>
        
        <div class="col-lg-9 col-md-9 col-sm-12">
            <div class="well">
            <a href="<c:url value="/update/account" />"><small class="pull-right text-muted">
           		<span class="glyphicon glyphicon-pencil" style="color: #696969"></span> Edit</small></a>
            	<h4 style="color: #000000">Bio (Public)</h4>
				<p style="color: #696969">${user.bio}</p>
			</div>
				
			<div class="well">
			<a href="<c:url value="/update/account" />"><small class="pull-right text-muted">
           		<span class="glyphicon glyphicon-pencil" style="color: #696969"></span> Edit</small></a>
            	<h4 style="color: #000000">Info (Private)</h4>
				<p style="color: #696969">Username: ${user.username}</p>
				<p style="color: #696969">Name: ${user.firstName} ${user.lastName}</p>
				<p style="color: #696969">Email: ${user.email}</p>
				<p style="color: #696969">Phone #: ${user.phone}</p>
			</div>
        
        
    	</div>
    	
    	<div class="col-lg-3  col-md-3 col-sm-12">
	    	<div class="well">
	            <h2 style="color: #000000">Welcome to Your Profile!</h2>
	            <p style="color: #000000">Your Bio is public and anyone can view it - however, your Info is completely private and safe with us. You can DM anyone by clicking on a comment they left. Also, no one can see what you post, but they can see any comments you make. Have fun!</p>
	            <!-- <a href="#" class="btn btn-default" style="color: #000000">Comment</a>-->
	       	</div>
        </div>
  </div><!-- /row -->
  </div><!-- /container -->
</section>

<br>

<div class="container" style="width: 100% !important; margin-left: 0px !important; padding-left: 0px !important; margin-right: 0px !important; padding-right: 0px !important; padding-bottom: 0 !important;">
  <div class="row" style="width: 100% !important; margin-left: 0px !important; padding-left: 0px !important; margin-right: 0px !important; padding-right: 0px !important;">
	
	<br>
    <section id="pinBoot">
    
	<c:forEach var="topic" items="${topics}">
	
      <article class="white-panel"><img class="specialimg" src="<c:url value="/resources/images/${topic.category}.jpg" />" alt="placeholder.jpg">
        <h4><a href="<c:url value="/view/topic?id=${topic.id}" />" style="color: #E50000;">${topic.title}</a></h4>
        <p class="bloggies">${topic.body}</p>
        <br>
        <p style="color: #696969;">${topic.date}</p>
      </article>
      
    </c:forEach>

    </section>

  </div>

</div>


<script>
$(document).ready(function() {
	$('#pinBoot').pinterest_grid({
	no_columns: 4,
	padding_x: 10,
	padding_y: 10,
	margin_bottom: 50,
	single_column_breakpoint: 700
	});
	});

	/*
	Ref:
	Thanks to:
	http://www.jqueryscript.net/layout/Simple-jQuery-Plugin-To-Create-Pinterest-Style-Grid-Layout-Pinterest-Grid.html
	*/

	;(function ($, window, document, undefined) {
	    var pluginName = 'pinterest_grid',
	        defaults = {
	            padding_x: 10,
	            padding_y: 10,
	            no_columns: 3,
	            margin_bottom: 50,
	            single_column_breakpoint: 700
	        },
	        columns,
	        $article,
	        article_width;

	    function Plugin(element, options) {
	        this.element = element;
	        this.options = $.extend({}, defaults, options) ;
	        this._defaults = defaults;
	        this._name = pluginName;
	        this.init();
	    }

	    Plugin.prototype.init = function () {
	        var self = this,
	            resize_finish;

	        $(window).resize(function() {
	            clearTimeout(resize_finish);
	            resize_finish = setTimeout( function () {
	                self.make_layout_change(self);
	            }, 11);
	        });

	        self.make_layout_change(self);

	        setTimeout(function() {
	            $(window).resize();
	        }, 500);
	    };

	    Plugin.prototype.calculate = function (single_column_mode) {
	        var self = this,
	            tallest = 0,
	            row = 0,
	            $container = $(this.element),
	            container_width = $container.width();
	            $article = $(this.element).children();

	        if(single_column_mode === true) {
	            article_width = $container.width() - self.options.padding_x;
	        } else {
	            article_width = ($container.width() - self.options.padding_x * self.options.no_columns) / self.options.no_columns;
	        }

	        $article.each(function() {
	            $(this).css('width', article_width);
	        });

	        columns = self.options.no_columns;

	        $article.each(function(index) {
	            var current_column,
	                left_out = 0,
	                top = 0,
	                $this = $(this),
	                prevAll = $this.prevAll(),
	                tallest = 0;

	            if(single_column_mode === false) {
	                current_column = (index % columns);
	            } else {
	                current_column = 0;
	            }

	            for(var t = 0; t < columns; t++) {
	                $this.removeClass('c'+t);
	            }

	            if(index % columns === 0) {
	                row++;
	            }

	            $this.addClass('c' + current_column);
	            $this.addClass('r' + row);

	            prevAll.each(function(index) {
	                if($(this).hasClass('c' + current_column)) {
	                    top += $(this).outerHeight() + self.options.padding_y;
	                }
	            });

	            if(single_column_mode === true) {
	                left_out = 0;
	            } else {
	                left_out = (index % columns) * (article_width + self.options.padding_x);
	            }

	            $this.css({
	                'left': left_out,
	                'top' : top
	            });
	        });

	        this.tallest($container);
	        $(window).resize();
	    };

	    Plugin.prototype.tallest = function (_container) {
	        var column_heights = [],
	            largest = 0;

	        for(var z = 0; z < columns; z++) {
	            var temp_height = 0;
	            _container.find('.c'+z).each(function() {
	                temp_height += $(this).outerHeight();
	            });
	            column_heights[z] = temp_height;
	        }

	        largest = Math.max.apply(Math, column_heights);
	        _container.css('height', largest + (this.options.padding_y + this.options.margin_bottom));
	    };

	    Plugin.prototype.make_layout_change = function (_self) {
	        if($(window).width() < _self.options.single_column_breakpoint) {
	            _self.calculate(true);
	        } else {
	            _self.calculate(false);
	        }
	    };

	    $.fn[pluginName] = function (options) {
	        return this.each(function () {
	            if (!$.data(this, 'plugin_' + pluginName)) {
	                $.data(this, 'plugin_' + pluginName,
	                new Plugin(this, options));
	            }
	        });
	    }

	})(jQuery, window, document);
	
</script>

