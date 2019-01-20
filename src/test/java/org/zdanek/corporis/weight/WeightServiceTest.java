package org.zdanek.corporis.weight;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zdanek.corporis.CorporisApplication;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WeightServiceTest {

	@Autowired
	WeightService weightService;
	
	//private static Logger logger = LogManager.getLogger();
	private static final Logger logger 
	  = LoggerFactory.getLogger(WeightServiceTest.class);
	@Test
	public void findByUserId() {
		List<Weight> weightList= weightService.findByUserId(new Long(1));
		
		
		weightList.stream().forEach(weight-> System.out.println(weight));
		logger.debug("Success");
		assert(true);
	}
	
	@Test
	public void save() {
		Weight weight= new Weight();
		
		weight.setWeight(99);
		weight.setDate(new Date());
		weight.setUser_id(new Long(1));
		
		; 
		weight= weightService.save(weight);
		logger.debug("Saved: {}",weight);
		logger.debug("Success");
		assert(true);
	}
	

}
