package fr.teamzi.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import fr.teamzi.dev.dao.TeamziUserDAO;
import fr.teamzi.dev.model.TeamziUser;
import fr.teamzi.dev.utils.IdTokenVerifierAndParser;

@Controller
public class LoginController{
	
		private static final Logger logger = Logger.getLogger(LoginController.class);

		@Autowired
	    private TeamziUserDAO userDAO;
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginGet() {
			// Name of a definition in WEB-INF/tiles.xml
			return "login";
		}

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		@ResponseBody
	    protected Object loginPost (HttpServletRequest req,HttpServletResponse resp)
	                        throws ServletException, IOException {
	        
			if(req.getParameter("aim") !=null ) {
				switch (req.getParameter("aim")) {
				case "login" :
					return loginUser(req);
				}
			}
			return null;
		}

		
		
		private Object loginUser(HttpServletRequest req) {
			 try {
		            String idToken = req.getParameter("id_token");
		            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
		            String name = (String) payLoad.get("name");
		            String email = payLoad.getEmail();
		            String picture = (String) payLoad.get("picture");

		            HttpSession session = req.getSession(true);

		            TeamziUser user = userDAO.findUser(email);
		            Integer userId;
		            if ( user != null) { //If user exists already in DB
		            	userId = user.getUserId();
		            }else {
		            	userId = userDAO.addUser(name, email);
		            }
		            
		            session.setAttribute("userId", userId);
		            session.setAttribute("userName", name);
		            session.setAttribute("userEmail", email);
		            session.setAttribute("userPicture", picture);
		            
		            session.setAttribute("success", "connection.success");
		           
		            
		            
		            logger.info("Connection : "+name+" "+email);
		            return new ResponseEntity<>("redirectOk",HttpStatus.OK);
		            //return new RedirectView("/"); //Redirect on home page
		        } catch (Exception e) {
		            throw new RuntimeException(e);
		        }
			
		}
}
