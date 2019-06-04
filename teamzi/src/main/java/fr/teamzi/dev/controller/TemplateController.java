package fr.teamzi.dev.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TemplateController {

	
	@RequestMapping(value="/template", method = RequestMethod.GET)
	public String templateGet(Model model) {
		
		// Name of a definition in WEB-INF/tiles.xml
		return "template";
	}
  
}