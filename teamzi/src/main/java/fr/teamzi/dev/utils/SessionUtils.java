package fr.teamzi.dev.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import fr.teamzi.dev.controller.LoginController;
import fr.teamzi.dev.dao.TeamziUserDAO;

public class SessionUtils {
	
	private static final Logger logger = Logger.getLogger(SessionUtils.class);

	@Autowired
    private TeamziUserDAO userDAO;
	
	public static void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String name = session.getAttribute("userName").toString();
			String email = session.getAttribute("userEmail").toString();
			session.invalidate();
			logger.info("Log out : "+name+" "+email);
		}
	}
}
