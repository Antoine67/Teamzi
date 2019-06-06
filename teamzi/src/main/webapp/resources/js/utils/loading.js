function enableLoading() {
	stopLoading();
	$("html").append("<div id='loading'></div>");
	$("html").append("<div id='loading-transparant-bg'></div>")
	$('#loading').fadeIn(3000);
}


function stopLoading() {
	$("#loading").remove();
	$("#loading-transparant-bg").remove();
}