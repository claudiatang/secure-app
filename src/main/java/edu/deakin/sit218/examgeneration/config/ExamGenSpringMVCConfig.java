package edu.deakin.sit218.examgeneration.config;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.deakin.sit218.examgeneration")
@PropertySource("classpath:persistence-mysql-properties.proprerties")
public class ExamGenSpringMVCConfig {
	
	@Autowired	
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());

	
	// Define a bean for the View Resolver 
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	// Define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {
		//create a connection pool
		ComboPooledDataSource securityDataSource = 
				new ComboPooledDataSource();
		
		//set the jdbc driver class
		try {
			securityDataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.user"));
				
		//set database connection props
		//securityDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/qarepodbschema?useSSL=false");
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		//securityDataSource.setUser("lecturerdbadmin");
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		//securityDataSource.setPassword("lecturerdbadmin");
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
	}
	
	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
	
}
