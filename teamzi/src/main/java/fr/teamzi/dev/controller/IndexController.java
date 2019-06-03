package fr.teamzi.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.teamzi.dev.dao.DepartmentDAO;
import fr.teamzi.dev.dao.TeamziUserDAO;
import fr.teamzi.dev.model.Department;
import fr.teamzi.dev.model.TeamziUser;

@Controller
public class IndexController {

	@Autowired
    private TeamziUserDAO userDAO;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		//departmentDAO.insertDepartment("HR", "Chicago");
	    //departmentDAO.insertDepartment("INV", "Hanoi");
	    List<TeamziUser> list = userDAO.getUsers();
	    model.addAttribute("users", list);
		
		// Name of a definition in WEB-INF/tiles.xml
		return "index";
	}
  
}