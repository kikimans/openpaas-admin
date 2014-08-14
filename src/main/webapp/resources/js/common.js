$(function(){
	$('form').validate({
		focusCleanup: true,
		onfocusout: false,
		onkeyup: false,
		rules:{
			email :{
				required : true,
				email : true
			}			
		},
		messages : {
			email : {
				required : '빈값은 전송되지 않습니다.',
				email : '이메일 주소 name@domain.com 같은 형식이어야 합니다.'
			}				
		},	
		errorElement : 'span',
		errorClass : 'help-block',
	    errorPlacement: function(error, element) {	    	
	        error.insertAfter(element);
	        error.css('color','red');
	        
	    }
	});
});

