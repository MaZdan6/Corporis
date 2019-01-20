package org.zdanek.corporis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CorporisController {
	
	private static final Logger logger 
	  = LoggerFactory.getLogger(CorporisController.class);
	
	/* 
	 * localhost:8080/corporis/
	 * */
	@GetMapping("/")
    public String greeting() {
        //model.addAttribute("name", name);
		logger.debug("greeting");
        return "index";
    }

}
