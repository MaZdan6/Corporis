package org.zdanek.corporis.weight;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/weight")
public class WeightController {
	
	@Autowired
	WeightService weightService;
	
	private static final Logger logger 
	  = LoggerFactory.getLogger(WeightController.class);
	
	/* 
	 * localhost:8080/corporis/weight/list
	 * */
	@GetMapping("/list")
    public String list(Model model) {
		logger.debug("weightList");
		
		List<Weight> weightList= weightService.findByUserId(new Long(1));
		
		model.addAttribute("weightList", weightList);
		logger.debug(weightList.toString());
		//model.addAttribute("name", name);
		
        return "weightList";
    }

}
