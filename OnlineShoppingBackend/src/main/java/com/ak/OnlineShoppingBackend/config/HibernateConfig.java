package com.ak.OnlineShoppingBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.ak.OnlineShoppingBackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/spgdb?useSSL=false";
	private final static String DATABASE_DRIVER="com.mysql.jdbc.Driver";
	private final static String DATABASE_URSERNAME = "root";
	private final static String DATABASE_PASSWORD = "root";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQL5Dialect";

	@Bean
	public DataSource getDataSource() throws Exception  {
		//ComboPooledDataSource dataSource= new ComboPooledDataSource();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//BasicDataSource dataSource = new BasicDataSource();
		// provide database connection information
		dataSource.setDriverClass(DATABASE_DRIVER);
		dataSource.setJdbcUrl(DATABASE_URL);
		dataSource.setUser(DATABASE_URSERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.ak.OnlineShoppingBackend.dto");
		return builder.buildSessionFactory();
	}

	// All the Hibernate properties will be return in this method
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	// Hibernate TransactionManagement Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
