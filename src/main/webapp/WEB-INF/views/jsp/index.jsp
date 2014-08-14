<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>OpenPaas Admin Site</title>
	<link href="images/favicon.ico" type="image/x-icon" rel="shortcut icon">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<!--  Navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">OpenPaas 관리자</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="#member"><a href="#">회원관리</a></li>
            <li><a href="#about">게시판관리</a></li>
            <li><a href="#contact">Contact</a></li>            
          </ul>  
          <div class="nav navbar-nav navbar-right">
          	 <button type="button" class="btn btn-success" style="margin-top:8px;">Sign up</button>
          </div>       
        </div><!--/.nav-collapse -->
        
      </div>
    </div>
    
    <div class="container">
      <form id="login" class="form-signin" role="form">
        <h2 class="form-signin-heading">Please sign in</h2>
        <div id="email-group" class="form-group">
        	 <input id="email" name="email" type="email" class="form-control" placeholder="Email address" data-validate="true" data-type="email" required autofocus>        	 
        </div>
        <div id="passwd-group" class="form-group">
        	 <input id="passwd" name="passwd" type="password" class="form-control" placeholder="Password" required>
        </div>       
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id="submit" class="btn btn-lg btn-primary btn-block" type="button" data-loading-text="전송중...">Sign in</button>
      </form>

    </div> <!-- /container -->

	<div class="modal fade">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">알림</h4>
	      </div>
	      <div class="modal-body">
	        <p>테스트&hellip;</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>	        
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<div id="alertModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">알림</h4>
	      </div>
	      <div class="modal-body">
	        <p>테스트&hellip;</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>	        
	      </div>
	    </div>
	  </div>
	</div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/jquery.validate.min.js"></script>
    <script src="js/common.js"></script>
   <script type="text/javascript">
   	$(document).ready(function(){
   		$('button#submit').on('click', function(e){   	
   			$(this).submit();
   			/*
   			$(this).button('loading');
   			if($('input[type=email]').val() == ''){   				
   				$('#email-group').addClass('has-error');
   				$('#emailhelp').text("이메일을 입력해주세요");
   				$('#emailhelp').show();   				
   				
   			}else if($('input[type=password]').val() == ''){
   				return;
   			}
   			*/
   			
   		});
   		
   		$('#email').on('focusin', function(e){
   			$('#email-group').removeClass('has-error');
   			$('#emailhelp').hide();
   		});
   	});
   	
//    	function formValidater(form){
//    		var $el = form.find('input');
//    		$el.each(function(e){
//    			if($(this).data().validate){
//    				if($(this).attr('type') == 'email'){
//    					emailValidater($(this).val());
//    				}
//    			}
//    		})
   		
//    	}
   	
//    	function emailValidater(email){
//    		console.log(email);
//    	}
   </script>
    
  </body>
</html>