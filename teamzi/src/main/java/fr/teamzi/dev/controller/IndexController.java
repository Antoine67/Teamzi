package fr.teamzi.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index() {
		// Name of a definition in WEB-INF/tiles.xml
		return "index";
	}
  
}