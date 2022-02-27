package info.nemoworks.chartd;

import info.nemoworks.chartd.chart.BidChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChartdApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChartdApplication.class, args);
	}

	@Autowired
	private BidChart bidChart;

	@Override
	public void run(String... args) throws Exception {
		bidChart.fireEvent("process");
	}
}
