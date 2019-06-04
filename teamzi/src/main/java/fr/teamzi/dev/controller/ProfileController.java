package fr.teamzi.dev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import fr.teamzi.dev.dao.TeamziUserDAO;
import fr.teamzi.dev.utils.SessionUtils;

@Controller
@Scope("session")
public class ProfileController {
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
    private TeamziUserDAO userDAO;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public Object profileGet(HttpServletRequest request) {
		if(request.getSession().getAttribute("userName") == null) {
			 return new RedirectView("/login"); //Redirect on login page
		};
		// Name of a definition in WEB-INF/tiles.xml
		return "profile";
		
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public Object profilePost(HttpServletRequest request)
	{
		SessionUtils.logout(request);
		return new RedirectView("/"); //Redirect on home page
	}

}
