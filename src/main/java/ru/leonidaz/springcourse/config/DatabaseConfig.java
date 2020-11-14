//package ru.leonidaz.springcourse.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//
//@Configuration
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScan("ru.leonidaz.springcourse")
//
//public class DatabaseConfig {
//
//    @Autowired
//    private Environment environment;
//
//    //Настройки Entity Manager
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//        entityManager.setDataSource(dataSource());
//        entityManager.setPackagesToScan("ru.leonidaz.springcourse");
//        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManager.setJpaProperties(getHibernateProperties());
//        return entityManager;
//    }
//    //Настройки Hibernate
//    @Bean
//    public Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        return properties;
//    }
//    //Настройки БД
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
//        dataSource.setDriverClassName(environment.getRequiredProperty("db.url"));
//        dataSource.setUsername(environment.getRequiredProperty("db.username"));
//        dataSource.setPassword(environment.getRequiredProperty("db.password"));
//        return dataSource;
//    }
//    //Connection pool
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager(){
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return manager;
//    }
////    Для теста
////    @Autowired
////    @Bean
////    public PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory){
////        JpaTransactionManager manager = new JpaTransactionManager();
////        manager.setEntityManagerFactory(entityManagerFactory);
////        return manager;
//    }
//
