
$( document ).ready(function() {
	$('#newTemplateButton').on('click',function() {
	    newTemplate($(this));
	});
});


function newTemplate(el) {
	el.prop("disabled",true);
	enableLoading();
		
		$.ajax({
			url : '/template',
			type : 'POST',
			data : {aim : "create"},
			success: function(data) {
				console.log("success");;
				redirectTemplatePage(data);
			},
			error: function() {
				console.log("error");
			}
		});
}

function redirectTemplatePage(data) {
	window.location.href = data; //+"?newfile=true";
}