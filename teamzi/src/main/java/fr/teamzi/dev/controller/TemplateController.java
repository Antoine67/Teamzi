package fr.teamzi.dev.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;


import fr.teamzi.dev.dao.TemplateDAO;
import fr.teamzi.dev.error.ResourceForbiddenException;
import fr.teamzi.dev.error.ResourceNotFoundException;
import fr.teamzi.dev.model.Template;
import fr.teamzi.dev.utils.SessionUtils;
import fr.teamzi.dev.utils.Utils;


@Controller
@RequestMapping(path="/template")
public class TemplateController {
	
	private static final Logger logger = Logger.getLogger(TemplateController.class);


	
	@Autowired
    private TemplateDAO templateDAO;
	

	@RequestMapping(method = RequestMethod.GET)
	public String documentGet(Model model, HttpSession session) {
		if(!SessionUtils.userConnected(session)) {
			session.setAttribute("error", "connection.required");
		}else {
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			List<Template> docs = templateDAO.getAllTemplatesFromUserId(userId);
			model.addAttribute("templates",docs);
		}
		
		// Name of a definition in WEB-INF/tiles.xml
		return "template";
	}
	
	
	@RequestMapping(path="/{templateDenom}", method = RequestMethod.GET)
	public Object documentSpecificGet(Model model, @PathVariable String templateDenom, HttpSession session) {

		if(!SessionUtils.userConnected(session)) {
			//session.setAttribute("error", "connection.required");
			return new RedirectView("/login?ref="+"/template/"+templateDenom);
		}
		
		return linkTempSpecific(model, templateDenom, session);

	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Object templatePost(HttpServletRequest req, HttpSession session) {
		//If user not connected
		if(!SessionUtils.userConnectedPostData(session, req,logger)) return null; 
	
		if(req.getParameter("aim") !=null ) {
			switch (req.getParameter("aim")) {
			case "save" :
				saveTemplate(req, session);
				break;
			case "delete" :
				deleteTemplate(req, session);
				break;
			case "create" : 
				return createTemplate(req, session);
			}
		}
		return null;
	}
	



	// --- HANDLERS --- //
	
	
	public String linkTempSpecific(Model model, String templateDenom, HttpSession session) {
		// Checking if url is well formed :
		// .../document/ {id} - {docName}
		int pos = templateDenom.indexOf("-");
		if(pos == -1) throw new ResourceNotFoundException(); 

		String templateId = templateDenom.substring(0, pos);
		if(!Utils.isInteger(templateId)) throw new ResourceNotFoundException(); 

		String templateName = templateDenom.substring (pos+1, templateDenom.length());
		if(templateName.isEmpty()) throw new ResourceNotFoundException(); 

		System.out.println(templateDAO + templateId + session);
		
		//Checking if user has access to this document
		if (!templateDAO.isOwnerTemplate(Integer.parseInt(templateId), Integer.parseInt(session.getAttribute("userId").toString()))) {
			throw new ResourceForbiddenException(); 
		}
				
		Template templateRequested = templateDAO.findTemplate(Integer.parseInt(templateId));

		//If requested name is the same as the real document's name
		if(!Utils.cleanName(templateRequested.getTemplateName()).equals(Utils.cleanName(templateName))) throw new ResourceNotFoundException(); 
				
		model.addAttribute("template", templateRequested);
		// Name of a definition in WEB-INF/tiles.xml
		return "template_specific";
	}

	public boolean saveTemplate(HttpServletRequest req, HttpSession session) {
		String tempId = req.getParameter("tempId");

		Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
		
		if(tempId == null || !Utils.isInteger(tempId)) {
			logger.error("Error saving : no template id specified");
			return false; // No doc ID
		}
		
		if(req.getParameter("content") == null) {
			logger.error("Error saving : no template data specified");
			return false; // No content
		}
		
		if(templateDAO.findTemplate(Integer.parseInt(tempId)) == null) {
			logger.error("Error saving : no template id specified");
			return false; // No doc corresponding
		}
		
		if(!templateDAO.isOwnerTemplate(Integer.parseInt(tempId), userId)) {
			logger.error("Error saving : user ["+userId+"] trying to access template with no right access");
			return false; // No access on doc from current session
		}

		templateDAO.updateTemplate(Integer.parseInt(tempId), req.getParameter("content"));
		logger.info("Saved document ["+tempId+"] user ["+userId+"]");
		return true;
	}

	public boolean deleteTemplate(HttpServletRequest req, HttpSession session) {
		return false;
		
	}
	
	@ResponseBody
	private Object createTemplate(HttpServletRequest req, HttpSession session) {
		System.out.println("createTemplate");
		Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
		int templateId = templateDAO.addTemplate(userId, "Document", "");
		String newUrl = "/template/"+templateId+"-Document";
		return new ResponseEntity<>(newUrl, HttpStatus.OK);
	}
	
	
	
	
  
}