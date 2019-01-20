package org.zdanek.corporis.weight;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class WeightService {
	
	@Autowired
	WeightRepository weightRepository;
	
	
	private static final Logger logger 
	  = LoggerFactory.getLogger(WeightService.class);
	
    public List<Weight> findByUserId(@PathVariable Long userId) {
    	logger.debug("find objects by id: {}", userId);
    	return weightRepository.findByUserId(userId);
    }

	public Weight save(Weight weight) {
		logger.debug("save object: {}", weight);
		return weightRepository.save(weight);
		
	}
}
