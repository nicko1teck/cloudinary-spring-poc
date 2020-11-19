package com.o1teck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.cloudinary.Cloudinary;



@SpringBootApplication
public class App extends SpringBootServletInitializer
{
	
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app)
    {
        return app.sources(App.class);
    }

    public static void main(String [] args)
    {
    	
        SpringApplication.run(App.class, args);
    }
    
    
   
    
    

    
    
    
    
}
