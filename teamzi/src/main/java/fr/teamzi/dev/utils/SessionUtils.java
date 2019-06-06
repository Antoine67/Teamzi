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
	
	/**
	 * Logout the connected user
	 * @param request
	 */
	public static void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String name = session.getAttribute("userName").toString();
			String email = session.getAttribute("userEmail").toString();
			session.invalidate();
			logger.info("Log out : "+name+" "+email);
		}
	}
	
	/**
	 * Is a user currently connected ?
	 * @param session
	 * @return true if user connected, false if not
	 */
	public static boolean userConnected(HttpSession session) {
		
		return session.getAttribute("userId") != null ? true : false;
	}
	
	
	/**
	 * Check if user is connected, if not log that an attempt of connection has been made from the request's IP
	 * @param session current session
	 * @param request HTTP Post request made
	 * @param logger use to log request's IP if necessary
	 * @return true if user connected, false if not
	 */
	public static boolean userConnectedPostData(HttpSession session, HttpServletRequest req, Logger logger) {
		if(session.getAttribute("userId") == null ) {
		    String ipAddress = req.getHeader("X-FORWARDED-FOR");  
		       if (ipAddress == null) {  
		         ipAddress = req.getRemoteAddr();  
		   }
		   logger.error("Post data without login from "+ipAddress);
		   return false;
		}else return true;
	}
}
