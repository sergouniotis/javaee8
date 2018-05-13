package com.tns.webapp.web.listeners;


import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

@WebListener
public class FlywayListener implements ServletContextListener {

	@Resource(lookup = "java:jboss/webapp/jdbc/ds")
	private DataSource datasource;

	public void contextInitialized(ServletContextEvent sce) {
		Flyway flyway = new Flyway();
		flyway.setDataSource(datasource);
		flyway.setLocations("classpath:db/migration");
		flyway.setBaselineOnMigrate(true);
		flyway.setOutOfOrder(true);
		flyway.migrate();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}

