package com.example.springdatajpa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = {"com.example.springdatajpa"})
public class JpaAppConfiguration {
	
	@Bean
	public DataSource dataSource() {  //added the properties in application.properties
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		  dataSource.setUsername("root");
		  dataSource.setPassword("mysql");
		  dataSource.setUrl("jdbc:mysql://localhost:3306/projects?createDatabaseIfNotExist=true&useSSL=false");
	      return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdaptor = new HibernateJpaVendorAdapter();
		vendorAdaptor.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdaptor);
		factory.setPackagesToScan("com.example.springdatajpa");
		factory.setDataSource(dataSource());
		
		return factory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		
		return jpaTransactionManager;
	}

}
