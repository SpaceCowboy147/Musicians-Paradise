package com.dylansmusicshop.shopMain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {"com.dylansmusicshop.controller"})


public class MusicShopApplication {


	public static void main(String[] args) {
		SpringApplication.run(MusicShopApplication.class, args);
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicshop", "root", "1234");
			System.out.println("Database connected successfully");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	}









