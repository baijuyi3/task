package com.jy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jy.dao")
public class HrmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmanagementApplication.class, args);
	}
}
