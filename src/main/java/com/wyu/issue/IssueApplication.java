package com.wyu.issue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wyu.issue.dao.mapper")

public class IssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueApplication.class, args);
	}

}