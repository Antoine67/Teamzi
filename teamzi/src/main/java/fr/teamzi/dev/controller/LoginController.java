package fr.teamzi.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import fr.teamzi.dev.utils.IdTokenVerifierAndParser;

@Controller
public class LoginController{
	
		private static final Logger logger = Logger.getLogger(LoginController.class);

		@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login() {
			// Name of a definition in WEB-INF/tiles.xml
			return "login";
		}

		@RequestMapping(value = "/login", method = RequestMethod.POST)
	    protected @ResponseBody RedirectView doPost (HttpServletRequest req,HttpServletResponse resp)
	                        throws ServletException, IOException {
	        //resp.setContentType("text/html");
	        
	        try {
	            String idToken = req.getParameter("id_token");
	            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
	            String name = (String) payLoad.get("name");
	            String email = payLoad.getEmail();
	            String picture = (String) payLoad.get("picture");
	            
	            System.out.println("User name: " + name);
	            System.out.println("User email: LoginController" + email);

	            HttpSession session = req.getSession(true);
	            session.setAttribute("userName", name);
	            session.setAttribute("userEmail", email);
	            session.setAttribute("userPicture", picture);
	            
	            session.setAttribute("codeMessage", "connexion.success");
	           
	            logger.info("Connexion : "+name+" "+email);
	            return new RedirectView("/"); //Redirect on home page
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
