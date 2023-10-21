package juanp.laliguria.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "juanp.laliguria.sales")
public class LaliguriaBackendSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaliguriaBackendSalesApplication.class, args);
	}

}
