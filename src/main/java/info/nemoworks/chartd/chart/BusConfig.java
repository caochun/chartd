package info.nemoworks.chartd.chart;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusConfig {

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
