package org.zdanek.corporis;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.zdanek.corporis.weight.WeightService;

@SpringBootApplication
public class CorporisApplication {
	
//	private static final Logger logger = LogManager.getLogger(CorporisApplication.class);
	

	
	
	public static void main(String[] args) {
		SpringApplication.run(CorporisApplication.class, args);
		
		System.out.println("START");
	}

}

