/*
 *   Created on : 28.01.2018, 23:09:24
 *   Author     : Popov Aleksey
 *   Site       : alexnerd.com
 *   Email      : alexnerd85@gmail.com
 *   GitHub     : https://github.com/alexnerd85/EmployeeTimeAccount
 */

package com.alexnerd.employeetimeaccount.config;

import java.util.Properties;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages={"com.alexnerd.employeetimeaccount.daoServices",
                            "com.alexnerd.employeetimeaccount.dao"})
@EnableTransactionManagement
public class ApplicationContext {
    
    @Autowired
    private Environment environment;

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
        //dataSource.setUrl("jdbc:mysql://localhost:3306/employeetimeaccount");
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        //dataSource.setUsername("alexnerd");
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        //dataSource.setPassword("alexnerd85");
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) throws NamingException {
        JpaTransactionManager jpaTransaction = new JpaTransactionManager();
        jpaTransaction.setEntityManagerFactory(emf);
        return jpaTransaction;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEMF() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getDataSource());
        emf.setPersistenceUnitName("spring-jpa-unit");
        emf.setJpaVendorAdapter(getHibernateAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "create");
        jpaProperties.put("hibernate.show_sql", "true");
        jpaProperties.put("hibernate.format_sql", "false");
        emf.setJpaProperties(jpaProperties);
        return emf;
    }

    @Bean
    public JpaVendorAdapter getHibernateAdapter() {
        return new HibernateJpaVendorAdapter();
    }
}
