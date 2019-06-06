package fr.teamzi.dev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


import fr.teamzi.dev.dao.DocumentDAO;
import fr.teamzi.dev.dao.DocumentsAccessDAO;
import fr.teamzi.dev.error.ResourceForbiddenException;
import fr.teamzi.dev.error.ResourceNotFoundException;
import fr.teamzi.dev.model.Document;
import fr.teamzi.dev.utils.SessionUtils;
import fr.teamzi.dev.utils.Utils;



@Controller
@Scope("session")
@RequestMapping(path="/document")
public class DocumentController {

	private static final Logger logger = Logger.getLogger(DocumentController.class);

	@Autowired
    private DocumentDAO docsDAO;
	
	@Autowired
    private DocumentsAccessDAO docsAccessDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String documentGet(Model model, HttpSession session) {
		if(!SessionUtils.userConnected(session)) {
			session.setAttribute("error", "connection.required");
		}else {
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			List<Document> docs = docsDAO.getAllDocsFromUserId(userId);
			model.addAttribute("documents",docs);
		}
		
		
		
		// Name of a definition in WEB-INF/tiles.xml
		return "document";
	}
	
	
	
	@RequestMapping(path="/{docDenom}", method = RequestMethod.GET)
	public Object documentSpecificGet(Model model, @PathVariable String docDenom, HttpSession session, HttpServletRequest req, HttpServletResponse response) {

		if(!SessionUtils.userConnected(session)) {
			//session.setAttribute("error", "connection.required");
			return new RedirectView("/login?ref="+"/document/"+docDenom);
		}
		
		return linkDocSpecific(model, docDenom, session);
		
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void templatePost(HttpServletRequest req, HttpSession session) {
		if(!SessionUtils.userConnectedPostData(session, req,logger)) return; 
		
		if(req.getParameter("aim") !=null ) {
			switch (req.getParameter("aim")) {
			case "save" :
				saveDoc(req, session);
				break;
			case "delete" :
				deleteDoc(req, session);
				break;
			}
		}
	}
	
	
	// --- HANDLERS --- //
	
	public void deleteDoc(HttpServletRequest req, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	public boolean saveDoc(HttpServletRequest req, HttpSession session) {
		String docId = req.getParameter("docId");

		Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
		
		if(docId == null || !Utils.isInteger(docId)) {
			logger.error("Error saving : no document id specified");
			return false; // No doc ID
		}
		
		if(req.getParameter("content") == null) {
			logger.error("Error saving : no document data specified");
			return false; // No content
		}
		
		if(docsDAO.findDocument(Integer.parseInt(docId)) == null) {
			logger.error("Error saving : no document id specified");
			return false; // No doc corresponding
		}
		
		if(!docsAccessDAO.hasAccess(Integer.parseInt(docId), userId)) {
			logger.error("Error saving : user ["+userId+"] trying to access document with no right access");
			return false; // No access on doc from current session
		}

		docsDAO.updateDocument(Integer.parseInt(docId), req.getParameter("content"));
		logger.info("Saved document ["+docId+"] user ["+userId+"]");
		return true;
	}

	public String linkDocSpecific(Model model, String docDenom, HttpSession session) {
		// Checking if url is well formed :
		// .../document/ {id} - {docName}
		int pos = docDenom.indexOf("-");
		if(pos == -1) throw new ResourceNotFoundException(); 

		String documentId = docDenom.substring(0, pos);
		if(!Utils.isInteger(documentId)) throw new ResourceNotFoundException(); 

		String documentName = docDenom.substring (pos+1, docDenom.length());
		if(documentName.isEmpty()) throw new ResourceNotFoundException(); 

		//Checking if user has access to this document
		if (!docsAccessDAO.hasAccess(Integer.parseInt(documentId), Integer.parseInt(session.getAttribute("userId").toString()))) {
			throw new ResourceForbiddenException(); 
		}
				
		Document docRequested = docsDAO.findDocument(Integer.parseInt(documentId));

		//If requested name is the same as the real document's name
		if(!Utils.cleanName(docRequested.getDocumentName()).equals(Utils.cleanName(documentName))) throw new ResourceNotFoundException(); 
				
		model.addAttribute("document", docRequested);
		// Name of a definition in WEB-INF/tiles.xml
		return "document_specific";
	}

	
  
}