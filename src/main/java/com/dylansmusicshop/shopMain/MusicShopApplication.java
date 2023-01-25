package com.dylansmusicshop.shopMain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages =  {"com.dylansmusicshop.login",  "com.dylansmusicshop.users", "com.dylansmusicshop.registration", "com.dylansmusicshop.security"} )
@ServletComponentScan({"com.dylansmusicshop.registration", "com.dylansmusicshop.login"})

public class MusicShopApplication {


	public static void main(String[] args) {
		SpringApplication.run(MusicShopApplication.class, args);
	}
}









