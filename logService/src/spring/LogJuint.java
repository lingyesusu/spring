package spring;

import java.util.EmptyStackException;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogJuint{
	private final Logger logger = Logger.getLogger(LogJuint.class);
	
	@Test
	public void ggj() {
		new EmptyStackException();
		logger.assertLog(false, "g");
		
	}
}
