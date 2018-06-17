/**
 * 
 */
package com.zigatta.ms.helper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.zigatta.ms.constants.RouteConstants;
import com.zigatta.ms.resource.RouteResourceImpl;

/**
 * @author dipak
 *
 */
@Component
public class FileReader {
	private static final Logger log = LoggerFactory.getLogger(FileReader.class);
	
	@Cacheable("routes")
	public List<String> readFile(String fileName) throws IOException, URISyntaxException {
		log.info("Reading file : {}",fileName);
		return Files.readAllLines(Paths.get(RouteConstants.DATA_FILE_NAME));	
	}

}
