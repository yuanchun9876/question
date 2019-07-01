package com.yuzo.question;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.yuzo.question.mapper")
public class QuestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionApplication.class, args);
	}

}
