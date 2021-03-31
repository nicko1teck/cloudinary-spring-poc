package com.o1teck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.cloudinary.Cloudinary;

@Configuration
public class Config implements WebMvcConfigurer {
	
		
	
	    @Bean
	    @Description("Thymeleaf template resolver serving HTML 5")
	    public ClassLoaderTemplateResolver templateResolver() {
	    	ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	        templateResolver.setPrefix("templates/");
	        templateResolver.setCacheable(true);
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode("HTML5");
	        templateResolver.setCharacterEncoding("UTF-8");
	        return templateResolver;
	    }

	    @Bean
	    @Description("Thymeleaf template engine with Spring integration")
	    public SpringTemplateEngine templateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(templateResolver());
	        return templateEngine;
	    }

	    @Bean
	    @Description("Thymeleaf view resolver")
	    public ViewResolver viewResolver() {
	        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        viewResolver.setCharacterEncoding("UTF-8");
	        return viewResolver;
	    }
	    
	    @Bean
		public Cloudinary cloudinaryConfig() {
			Cloudinary cloudinary = null;
			cloudinary = new Cloudinary();
			cloudinary.config.cloudName = "nicko1teck";
			cloudinary.config.apiKey = "697697678268857";
			cloudinary.config.apiSecret = "UFH1ZXH_4UZ8XNHchIj8Lwhpszw";
			return cloudinary;
		}
	    
	    /*
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("uploadview");
	    }
	  
	    */
}


