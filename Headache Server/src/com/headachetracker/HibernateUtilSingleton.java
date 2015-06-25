package com.headachetracker;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilSingleton {
	
	private static final SessionFactory sessionFactory;

	static {
		
		Configuration configuration = new Configuration();

		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/syptomtracker");
		configuration.setProperty("hibernate.connection.username", "hibernate");
		configuration.setProperty("hibernate.connection.password", "cangetin");

		//change the pool size to reflect how many users you expect your application to have initially

		configuration.setProperty("hibernate.connection.pool_size", "1");
		configuration.setProperty("hibernate.connection.autocommit", "true");
		configuration.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

		// un-comment the next line of code if you want to be able to drop and recreate tables for your data classes listed below.  This is generally a bad idea for security reasons.
		// configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		configuration.setProperty("hibernate.show_sql", "true");

		configuration.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

		configuration.setProperty("hibernate.current_session_context_class", "thread");

		// register classes that will persist in the database

		configuration.addAnnotatedClass(Headache.class);
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	}

	public static SessionFactory getSessionFactory(){

		return sessionFactory;

	}

	//make a private default constructor so that no other HibernateUtil can be created.

	private HibernateUtilSingleton(){

	}

}
