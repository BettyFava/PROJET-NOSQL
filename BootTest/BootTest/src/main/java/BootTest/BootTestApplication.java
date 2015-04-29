package BootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.HiddenHttpMethodFilter;
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
    @Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
}
