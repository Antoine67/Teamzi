
$( document ).ready(function() {
    $("#defaut-tab").addClass("active");
    $('#fields').css("display","block");
});

function openTab(evt, tabId) {
  //Hide all
  $( ".tabcontent" ).css("display","none");
  $( ".tablinks" ).removeClass("active");

  //Show only selected one, and active button
  $('#'+tabId).css("display","block");
  evt.currentTarget.className += " active";
}


function saveAsDraft(div) {
var data = $("#"+div).html();
var tempId = getRelativeUrl(window.location.href ).split('-')[0];


	
	$.ajax({
		url : '/template',
		type : 'POST',
		data : {tempId: tempId, content: data , aim : "save"},
		success: function(data) {
			console.log("success");
		},
			error: function() {
				console.log("error");
		}
	});
}

function finalizeDoc(div) {

}

function getRelativeUrl(url){
    return url.split('/').pop()
}