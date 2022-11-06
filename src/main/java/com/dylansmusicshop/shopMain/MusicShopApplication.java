package com.dylansmusicshop.shopMain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages =  {"com.dylansmusicshop.controller",  "com.dylansmusicshop.users", "com.dylansmusicshop.registration"} )
@ServletComponentScan("com.dylansmusicshop.registration")

public class MusicShopApplication {


	public static void main(String[] args) {
		SpringApplication.run(MusicShopApplication.class, args);
	}
}









