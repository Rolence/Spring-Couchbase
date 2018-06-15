package com.rolence.couchbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.rolence.couchbase")
public class CouchbaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchbaseAppApplication.class, args);
	}
}
