package BootTest;


import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages="BootTest")
public class BootTestApplication {
	
	

    public static void main(String[] args) {
        SpringApplication.run(BootTestApplication.class, args);
    }
    
    
    
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("reached here ");
        registry.addResourceHandler("/resources/**").addResourceLocations("/static/");
    }

  
    

}
