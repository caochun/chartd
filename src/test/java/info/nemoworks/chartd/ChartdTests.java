package info.nemoworks.chartd;

import com.google.common.eventbus.EventBus;
import info.nemoworks.chartd.bid.actor.BidAggregateActor;
import info.nemoworks.chartd.bid.actor.BidCreateActor;
import info.nemoworks.chartd.bid.repository.BidRepository;
import info.nemoworks.chartd.framework.Stub;
import org.apache.commons.scxml2.model.ModelException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
public class ChartdTests {


    @TestConfiguration
    public static class Config {

        @Bean
        public EventBus eventBus() {
            return new EventBus();
        }

        @Bean
        public Stub stub() {
            return new Stub();
        }

        @Bean
        public BidRepository bidRepository() {
            return new BidRepository();
        }

        @Bean
        public BidAggregateActor bidAggregateActor() {
            return new BidAggregateActor();
        }

        @Bean
        public BidCreateActor bidCreateActor() {
            return new BidCreateActor();
        }


    }

    @Autowired
    private BidCreateActor bidCreateActor;

    @Autowired
    private BidAggregateActor bidAggregateActor;

    @Test
    public void testWhenBootstrap_CreateActorReceives() throws ModelException {

        assertNotNull(bidAggregateActor);
        assertNotNull(bidCreateActor);

    }
}
