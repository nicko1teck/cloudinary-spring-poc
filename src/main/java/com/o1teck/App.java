package com.o1teck;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;



@SpringBootApplication
public class App extends SpringBootServletInitializer
{
	
	@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Value("${cloudinary.api_key}")
	private String apiKey;

	@Value("${cloudinary.api_secret}")
	private String apiSecret;
	
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app)
    {
        return app.sources(App.class);
    }
	
	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = null;
		
		cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", cloudName,
				  "api_key", apiKey,
				  "api_secret", apiSecret));
		
		return cloudinary;
	}
	
	
	@Bean // We're telling Spring to consider this a bean
	public UrlBasedViewResolver tilesViewResolver() {
		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();

		tilesViewResolver.setViewClass(TilesView.class);

		return tilesViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {

		TilesConfigurer tilesConfigurer = new TilesConfigurer();

		// Tell Tiles what configuration to use
		String[] defs = { "/WEB-INF/tiles.xml" };
		tilesConfigurer.setDefinitions(defs);

		return tilesConfigurer;
	}
	
	/*
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
	*/
   
   
	
	
	
	public static void main(String [] args)
    {
        SpringApplication.run(App.class, args);
    }
    
	
	
	

	
	
	

	
    
    
    /*
    @Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Add Custom Filter
		// FilterRegistration customFilter = servletContext.addFilter("customFilter",
		// new customFilter());
		// customFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),
		// true, "*.do");
		// customFilter.setInitParameter("appName", "employee");

		super.onStartup(servletContext);
	}
	*/

    


    
    
    
    
}
