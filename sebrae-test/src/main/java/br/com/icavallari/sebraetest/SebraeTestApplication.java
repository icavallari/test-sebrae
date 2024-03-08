package br.com.icavallari.sebraetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SebraeTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SebraeTestApplication.class, args);
	}

}
