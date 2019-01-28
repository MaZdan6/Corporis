package org.zdanek.corporis.weight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ResponseEntity<Page<Weight>> getWeight(@RequestBody
			WeightDTO weightDTO){
		logger.debug("getWeight");
		logger.debug("weightDTO: {}"+weightDTO.toString());
		
		
		Pageable page= PageRequest.of(weightDTO.getPageNumber(), weightDTO.getPageSize());
		
		Page<Weight> weightList=weightService.findByUserId(weightDTO.getWeight().getUserId(), page);
		
		return new ResponseEntity<Page<Weight>>(weightList, HttpStatus.OK);
		
	}
	

}
