/**
 * 
 */
package com.zigatta.ms.helper;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dipak
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FileReaderTest {
	
	private static final String FILE_NAME = "city.txt";
	@InjectMocks
	private FileReader fileReader;

	@Test
	public void readFileReaderTest_Success() throws IOException, URISyntaxException{
		List<String> lines = fileReader.readFile(FILE_NAME);
		assertTrue(lines.size()>0);
	}
}
