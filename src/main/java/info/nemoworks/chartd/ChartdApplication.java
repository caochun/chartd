package info.nemoworks.chartd;

import info.nemoworks.chartd.domain.model.BidChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"info.nemoworks.chartd"})
public class ChartdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChartdApplication.class, args);
	}

}
