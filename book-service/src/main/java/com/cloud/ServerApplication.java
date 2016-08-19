package com.cloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class ServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServerApplication.class).web(true).run(args);
	}
}
