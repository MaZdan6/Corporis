package org.zdanek.corporis.weight;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.zdanek.corporis.weight.Weight;

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
    
	/*
	 * public List<Weight> findByUserId(Long userId, Pageable page) {
	 * logger.debug("find objects by id: {}, page:{}", userId,page); return
	 * weightRepository.findByUserId(userId,page); }
	 */
    
    
    public Page<Weight> findByUserId(Long userId, Pageable page) {
    	logger.debug("find objects by id: {}, page:{}", userId,page);
    	return weightRepository.findByUserId(userId,page);
	}

	public Weight save(Weight weight) {
		logger.debug("save object: {}", weight);
		return weightRepository.save(weight);
		
	}

	public void delete(long id) {
		logger.debug("deleteById: {}", id);
		weightRepository.deleteById(id);
		
	}

	
}
