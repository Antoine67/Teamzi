 function onSuccess(googleUser) {
	 	enableLoading();
	 	
        var profile = googleUser.getBasicProfile();

        var redirectUrl = 'login';

        /*var form = $('<form hidden action="' + redirectUrl + '" method="post">' +
                         '<input type="text" name="id_token" value="' +
                          googleUser.getAuthResponse().id_token + '" />' +
                                                           '</form>');
                                                           */
        $('#success-conn').remove();  
        $('body').append("<div id='success-conn' class='alert alert-success'>Connexion en cours...</div>");
        //$('body').append(form);
        
        $.ajax({
			url : '/login',
			type : 'POST',
			data : {aim : "login", id_token : googleUser.getAuthResponse().id_token},
			success: function(data) {
				console.log("success");
				if(data == "redirectOk") {
					window.location.href = $_GET("ref");
					
					
				}
				stopLoading();
				
			},
			error: function() {
				console.log("error");
				stopLoading();
			}
        });
        
        
        
        //form.submit();
    }
 
    function onFailure(error) {
      console.log(error);
    }
    function renderButton() {
      gapi.signin2.render('google-signin', {
        'scope': 'profile email',
        'width': 240,
        'height': 50,
        'longtitle': true,
        'theme': 'light',
        'onsuccess': onSuccess,
        'onfailure': onFailure
      });
    }
    
    
    
    
    function $_GET(param) {
    	var vars = {};
    	window.location.href.replace( location.hash, '' ).replace( 
    		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
    		function( m, key, value ) { // callback
    			vars[key] = value !== undefined ? value : '';
    		}
    	);

    	if ( param ) {
    		return vars[param] ? vars[param] : null;	
    	}
    	return vars;
    }    