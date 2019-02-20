package org.zdanek.corporis.weight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


@Api
@RestController
@RequestMapping(value="/api/weight")
public class WeightRESTController {
	
	@Autowired
	WeightService weightService;
	
	private static final Logger logger 
	  = LoggerFactory.getLogger(WeightController.class);
	
	@RequestMapping(value="/getWeightList", method=RequestMethod.GET)
	public ResponseEntity<Page<Weight>> getWeight(@RequestParam int page, @RequestParam int size, @RequestParam long userId){
		logger.debug("getWeight");
		
		Pageable pageRequest= PageRequest.of(page-1, size);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.debug(auth.toString());
		
		Page<Weight> weightList=weightService.findByUserId(userId, pageRequest);
		
		return new ResponseEntity<Page<Weight>>(weightList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ResponseEntity<String> delete(@RequestParam("id") long id){
		logger.debug("delete weight by id: {}",id);
		
		weightService.delete(id);
		
		return new ResponseEntity<String>("delete weight by id: "+id,HttpStatus.OK);
		
	}
	

}
