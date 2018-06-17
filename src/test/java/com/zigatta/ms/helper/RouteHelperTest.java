/**
 * 
 */
package com.zigatta.ms.helper;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zigatta.ms.constants.RouteConstants;
/**
 * @author dipak
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RouteHelperTest {
	@Mock
	private FileReader fileReader;
	
	@InjectMocks
	private RouteHelper routeHelper;
	
	
	
	@Test
	public void testConnectionBetweenCities() throws IOException, URISyntaxException{
		Mockito.doReturn(readFile()).when(fileReader).readFile(Mockito.anyString());
		assertTrue(routeHelper.isConnectionExists("Boston","newark"));
		assertTrue(routeHelper.isConnectionExists("boston","Philadelphia"));
		assertFalse(routeHelper.isConnectionExists("philadelphia","Albany"));
		assertFalse(routeHelper.isConnectionExists("Boston","a"));
		assertFalse(routeHelper.isConnectionExists("b","Philadelphia"));
		assertFalse(routeHelper.isConnectionExists("a","b"));
		assertFalse(routeHelper.isConnectionExists("",""));
		
	}

	private List<String> readFile() throws IOException, URISyntaxException {
		return Files.readAllLines(Paths.get("./opt/etc/config/city.txt"));
	}
	
	
}
