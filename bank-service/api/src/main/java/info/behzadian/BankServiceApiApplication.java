package info.behzadian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApiApplication.class, args);
	}

}
