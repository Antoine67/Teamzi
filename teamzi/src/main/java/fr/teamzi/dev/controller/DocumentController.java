package fr.teamzi.dev.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DocumentController {

	
	@RequestMapping(value="/document", method = RequestMethod.GET)
	public String templateGet(Model model) {
		
		// Name of a definition in WEB-INF/tiles.xml
		return "document";
	}
  
}