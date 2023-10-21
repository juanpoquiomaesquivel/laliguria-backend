package juanp.laliguria.general;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "juanp.laliguria.general")
public class LaliguriaBackendGeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaliguriaBackendGeneralApplication.class, args);
	}

}
