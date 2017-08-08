package com.rest.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.rest.controller.AdCampaignController;

@SpringBootApplication
@ComponentScan(basePackageClasses = AdCampaignController.class)
public class CampaignAdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignAdApplication.class, args);
	}
}
