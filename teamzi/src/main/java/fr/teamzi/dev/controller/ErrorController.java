package fr.teamzi.dev.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
 
    @RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
         
        ModelAndView errorPage = new ModelAndView("errorMsg");
        String errorMsg = "error.undefined";
        String errorStacktrace= getStacktrace(httpRequest);
        int httpErrorCode = getErrorCode(httpRequest);
 
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "error.400";
                break;
            }
            case 401: {
                errorMsg = "error.401";
                break;
            }
            case 404: {
                errorMsg = "error.404";
                break;
            }
            case 500: {
                errorMsg = "error.500";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        errorPage.addObject("errorStacktrace",errorStacktrace);
        return errorPage;
    }
     
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
          .getAttribute("javax.servlet.error.status_code");
    }
    
    private String getStacktrace(HttpServletRequest httpRequest) {
    	return (String) httpRequest
    	          .getAttribute("javax.servlet.error.message");
    }
}
