package com.abdullahteke.main;

import static java.lang.System.exit;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.abdullahteke.model.SymmetrixMetrics;
import com.abdullahteke.service.SymmetrixService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
@ComponentScan(basePackages = "tr.gov.nvi")
public class GetInfoFromEmcSymetrix implements CommandLineRunner {
	
    private static final Logger logger = (Logger) LoggerFactory.getLogger(GetInfoFromEmcSymetrix.class);

	
	@Autowired
	private SymmetrixService symmetrixService;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        SpringApplication app = new SpringApplication(GetInfoFromEmcSymetrix.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
	
    @Override
    public void run(String... args) {
    	

    	XmlMapper xmlMapper = new XmlMapper();
    	
    	try {
    		symmetrixService.createXmlFile();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
    	
    
    	
    	exit(0);
    }

}
