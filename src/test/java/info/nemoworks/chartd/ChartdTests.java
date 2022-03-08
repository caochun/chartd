package info.nemoworks.chartd;

import com.google.common.eventbus.EventBus;
import info.nemoworks.chartd.bid.actor.BidActor;
import info.nemoworks.chartd.bid.actor.BidApproveActor;
import info.nemoworks.chartd.bid.actor.BidCreateActor;
import info.nemoworks.chartd.bid.actor.BidEditActor;
import info.nemoworks.chartd.bid.domain.BidService;
import info.nemoworks.chartd.bid.domain.BidServiceImp;
import info.nemoworks.chartd.bid.repository.BidRepository;
import info.nemoworks.chartd.framework.MessageStub;
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
        public MessageStub stub() {
            return new MessageStub();
        }

        @Bean
        public BidRepository bidRepository() {
            return new BidRepository();
        }

        @Bean
        public BidActor bidAggregateActor() {
            return new BidActor();
        }

        @Bean
        public BidCreateActor bidCreateActor() {
            return new BidCreateActor();
        }

        @Bean
        public BidService bidService() {
            return new BidServiceImp();
        }

        @Bean
        public BidApproveActor bidApproveActor() {
            return new BidApproveActor();
        }

        @Bean
        public BidEditActor bidEditActor() {
            return new BidEditActor();
        }

    }

    @Autowired
    private BidCreateActor bidCreateActor;

    @Autowired
    private BidService bidService;

    @Test
    public void testWhenBootstrap_CreateActorReceives() throws ModelException {

        assertNotNull(bidService);
        assertNotNull(bidCreateActor);

        bidService.bootstrap();

        bidCreateActor.pubCreateCommandMessage();

    }
}
