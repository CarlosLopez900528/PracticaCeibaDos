package com.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.repositories")
@EnableTransactionManagement
public class JpaConfig {

@Bean()
@ConfigurationProperties(prefix = "spring.datasource")
public DataSource dataSource() {
return DataSourceBuilder.create().build();
}

@Bean()
public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
return builder.dataSource(dataSource()).packages("com.entities").build();
}

@Bean
public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
return new JpaTransactionManager(emf);
}
}


