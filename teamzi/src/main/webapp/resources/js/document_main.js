


$( document ).ready(function() {

	var handlerLeft = $('#handler-left');
	var handlerRight = $('#handler-right');
	var wrapper = $('.wrapper');
	
	var handlerDragging = false;
	var element; // Current handler dragged
	
	var boxminWidth = 200;
	var boxmaxWidth = 400;
	
	// Mouse up/down event fired
	handlerLeft.mousedown(function() {handlerDragging = true; element = handlerLeft});

	handlerRight.mousedown(function() {handlerDragging = true; element = handlerRight});

	$(document).mouseup(function() {handlerDragging = false; });

	document.addEventListener('mousemove', function(e) {
		// Skip if dragging flag is false
		if (!handlerDragging) {return false;}

		if(element === handlerLeft) {
		
			// Get left offset
			var containerOffsetLeft = wrapper.offset().left;

			// Get x-coordinate of pointer relative to container
			var pointerRelativeXpos = e.clientX - containerOffsetLeft;
			
			//Box's size, without excess max size
			var size = Math.min(pointerRelativeXpos,boxmaxWidth); 
			
			var width = $('#left-sidebar').css('width');
			width = width.slice(0, width.length-2);
			var lambdaSize = Math.abs(width - (Math.max(boxminWidth, size - 8))) ;
			var reduceMainContainer = width < (Math.max(boxminWidth, size - 8));
			
	
			var mainContainerWidth = $('#main-container').css('width');
			mainContainerWidth = mainContainerWidth.slice(0, mainContainerWidth.length-2);

			var newSize;
			
			if(reduceMainContainer) {
				newSize = parseFloat(mainContainerWidth) - parseFloat(lambdaSize);
				$('#main-container').css('width', newSize + 'px');
			}else {
				newSize = parseFloat(mainContainerWidth) + parseFloat(lambdaSize);
				$('#main-container').css('width',  newSize+ 'px');
			}
			
			
			
			$('#left-sidebar').css('width',(Math.max(boxminWidth, size - 8)) + 'px');

		}else if(element === handlerRight) {
			// Get right offset
			var containerOffsetRight = $(window).width() - wrapper.offset().left - wrapper.width();

			// Get x-coordinate of pointer relative to container
			var pointerRelativeXpos = e.clientX - containerOffsetRight;
			
			//Box's size, without excess max size
			var size = wrapper.width() - pointerRelativeXpos;
			size = Math.min(size,boxmaxWidth); 
			
			var width = $('#right-sidebar').css('width');
			width = width.slice(0, width.length-2);
			var lambdaSize = Math.abs(width - (Math.max(boxminWidth, size - 8))) ;
			var reduceMainContainer = width < (Math.max(boxminWidth, size - 8));
			
			var mainContainerWidth = $('#main-container').css('width');
			mainContainerWidth = mainContainerWidth.slice(0, mainContainerWidth.length-2);

			var newSize;
			
			if(reduceMainContainer) {
				newSize = parseFloat(mainContainerWidth) - parseFloat(lambdaSize);

				$('#main-container').css('width', newSize + 'px');

			}else {
				newSize = parseFloat(mainContainerWidth) + parseFloat(lambdaSize);

				$('#main-container').css('width',  newSize+ 'px');

			}
		  
			$('#right-sidebar').css('width',(Math.max(boxminWidth, size - 8)) + 'px');

		}
	  
	});

});



var htmlStart = "<!DOCTYPE html><html><body>";
var htmlEnd = "</body></html>";

function downloadDocx(div) {
	var data = htmlStart + $('#'+div).html() + htmlEnd;
	console.log(data);
	
	var converted = htmlDocx.asBlob(data);
	saveAs(converted, 'doc.docx');
}


function deleteDoc() {
	if (confirm('Êtes vous sûr de vouloir supprimer ce document ?')) {
	    
	}
}


function saveDoc(docId, content) {
	
	var data = $("#"+content).text();
	
	$.ajax({
		url : '/document',
		type : 'POST',
		data : {docId: docId, content: data , aim : "save"},
		success: function(data) {
			console.log("success");
			
		},
			error: function() {
				console.log("error");
		}
	});
}