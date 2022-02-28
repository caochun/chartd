package info.nemoworks.chartd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"info.nemoworks.chartd"})
public class ChartdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartdApplication.class, args);
	}

}
