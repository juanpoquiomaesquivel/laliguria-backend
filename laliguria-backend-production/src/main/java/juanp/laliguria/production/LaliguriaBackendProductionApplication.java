package juanp.laliguria.production;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "juanp.laliguria.production")
public class LaliguriaBackendProductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaliguriaBackendProductionApplication.class, args);
	}

}
