package edu.msoft.clientmtls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientMtlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientMtlsApplication.class, args);
	}

}
