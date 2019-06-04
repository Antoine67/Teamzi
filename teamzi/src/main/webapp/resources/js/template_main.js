

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
		 
			$('#left-sidebar').css('width',(Math.max(boxminWidth, size - 8)) + 'px');
			$('#left-sidebar').css('flexGrow',0);
		}else if(element === handlerRight) {
			// Get right offset
			var containerOffsetRight = $(window).width() - wrapper.offset().left - wrapper.width();

			// Get x-coordinate of pointer relative to container
			var pointerRelativeXpos = e.clientX - containerOffsetRight;
			
			//Box's size, without excess max size
			var size = wrapper.width() - pointerRelativeXpos;
			size = Math.min(size,boxmaxWidth); 
		  
			$('#right-sidebar').css('width',(Math.max(boxminWidth, size - 8)) + 'px');
			$('#right-sidebar').css('flexGrow',0);
		}
	  
	});

});