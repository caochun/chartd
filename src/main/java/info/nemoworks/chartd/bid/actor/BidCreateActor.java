package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.query.CreatingQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BidCreateActor extends Actor {

    private Map<String, CreatingQuery> queries = new HashMap<>();


    @PostConstruct
    public void register() {
        this.getStub().register(new Subscriber<>(this::handleCreating));
    }

    public void handleCreating(CreatingQuery query) {
        LoggerFactory.getLogger(BidCreateActor.class).info("handling " + query.toString());
        this.queries.put(query.getSource().toString(), query);
    }


}
