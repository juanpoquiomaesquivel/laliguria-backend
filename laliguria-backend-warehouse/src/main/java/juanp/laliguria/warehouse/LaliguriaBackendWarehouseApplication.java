package juanp.laliguria.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "juanp.laliguria.warehouse")
public class LaliguriaBackendWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaliguriaBackendWarehouseApplication.class, args);
	}

}
