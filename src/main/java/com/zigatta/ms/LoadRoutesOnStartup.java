package com.zigatta.ms;

import java.io.IOException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.zigatta.ms.constants.RouteConstants;
import com.zigatta.ms.helper.FileReader;

@Component
public class LoadRoutesOnStartup{
	private static final Logger log = LoggerFactory.getLogger(LoadRoutesOnStartup.class);
	@Autowired
	private FileReader fileReader;
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			fileReader.readFile(RouteConstants.DATA_FILE_NAME);
		} catch (IOException e) {
			log.error("Error while reading file : {}",e);
		} catch (URISyntaxException e) {
			log.error("Error while reading file : {}",e);
		}
	}

}
