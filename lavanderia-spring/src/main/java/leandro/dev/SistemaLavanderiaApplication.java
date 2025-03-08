package leandro.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SistemaLavanderiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaLavanderiaApplication.class, args);
	}

}
