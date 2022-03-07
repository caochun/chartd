package info.nemoworks.chartd.bid.actor;

import com.google.common.eventbus.Subscribe;
import info.nemoworks.chartd.bid.message.query.CreatingQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class BidCreateActor extends Actor {

    private Map<String, CreatingQuery> queries = new HashMap<>();


    private class CreatingQueryConsumer{
        @Subscribe
        public void accept(CreatingQuery creatingQuery) {
            BidCreateActor.this.handleCreating(creatingQuery);
        }
    }
    @PostConstruct
    public void register() {
        this.getStub().register(new CreatingQueryConsumer());
    }

    public void handleCreating(CreatingQuery query) {
        LoggerFactory.getLogger(BidCreateActor.class).info("handling " + query.toString());
        this.queries.put(query.getSubject().getId(), query);
    }


}
