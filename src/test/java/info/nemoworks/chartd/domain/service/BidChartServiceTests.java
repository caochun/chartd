package info.nemoworks.chartd.domain.service;

import com.google.common.eventbus.EventBus;
import info.nemoworks.chartd.bid.service.BidChartService;
import info.nemoworks.chartd.chart.event.StateEvent;
import info.nemoworks.chartd.chart.event.ChartStateHandler;
import info.nemoworks.chartd.chart.event.EventDispatcher;
import info.nemoworks.chartd.bid.domain.Bid;
import info.nemoworks.chartd.bid.repository.BidChartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BidChartServiceTests {

    @TestConfiguration
    static class BidChartServiceTestContextConfiguration {

        @Bean
        public EventBus eventBus() {
            return new EventBus();
        }

        @Bean
        public EventDispatcher eventDispatcher() {
            return new EventDispatcher();
        }

        @Bean
        public BidChartService bidChartService() {
            return new BidChartService();
        }

        @Bean
        public BidChartRepository bidChartRepository() {
            return new BidChartRepository();
        }

        @Bean
        public ChartStateHandler chartStateHandler() {
            return new ChartStateHandler() {
                @Override
                public void handle(StateEvent event) {
                    System.out.println("handling" + event.getEntity().getId());
                }
            };
        }
    }


    @Autowired
    private BidChartService bidChartService;

    @Test
    public void testChartCreate() {

        Bid bid = new Bid();
        bidChartService.createBidChart(bid);

    }
}
