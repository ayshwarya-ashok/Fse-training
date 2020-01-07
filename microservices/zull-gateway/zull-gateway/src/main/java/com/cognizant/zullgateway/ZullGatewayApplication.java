package com.cognizant.zullgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZullGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullGatewayApplication.class, args);
	}

}
