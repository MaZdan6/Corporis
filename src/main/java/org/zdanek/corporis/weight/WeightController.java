package org.zdanek.corporis.weight;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
	
	@RequestMapping("new")
	public String newWeight(@RequestParam("userId") long userId, Model model){
		logger.debug("newWeight for user {}", userId);
		Weight weight= new Weight();
		weight.setUserId(userId);
		
		model.addAttribute("weightEntity", weight);
		
		return "weightForm";
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("weightEntity") Weight weight,
			BindingResult result, Model model) {
		weight.setDate(new Date());
		logger.debug("/save {}", weight);
		
		if(result.hasErrors()) {
			logger.error(result.getAllErrors().toString());
			return "weightForm";
		}
		else {
			String message="";
			boolean flag=true;
			try {
				weightService.save(weight);
				flag=true;
			} catch (Exception e) {
				e.printStackTrace();
				message= e.getMessage();
				flag=false;
			}
			if(!flag) {
				model.addAttribute("message", message);
				return "weightForm";
			}
			model.addAttribute("weight", weight);
			return "redirect:/weight/list";
			
		}
			
	}
	
	
	
	@RequestMapping("delete")
	public String delete(@RequestParam("id") long id, Model model){
		logger.debug("delete");
		
		weightService.delete(id);
		
		return "redirect:/weight/list";
		
	}
	

}
