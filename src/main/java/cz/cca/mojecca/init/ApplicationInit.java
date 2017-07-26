package cz.cca.mojecca.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cz.cca.mojecca.util.MojeCcaBigDecimalConverter;

public class ApplicationInit implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		MojeCcaBigDecimalConverter.register();
	}

}
