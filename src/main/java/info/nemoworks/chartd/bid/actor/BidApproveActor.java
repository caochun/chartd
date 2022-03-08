package info.nemoworks.chartd.bid.actor;

import info.nemoworks.chartd.bid.message.query.ApprovingQuery;
import info.nemoworks.chartd.framework.Actor;
import info.nemoworks.chartd.framework.Subscriber;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BidApproveActor extends Actor {
    private Map<String, ApprovingQuery> queries = new HashMap<>();

    public BidApproveActor() {
        this.getStub().register(new Subscriber<ApprovingQuery>(this::handleApproving));
    }

    public void handleApproving(ApprovingQuery query) {
        LoggerFactory.getLogger(BidApproveActor.class).info("handling " + query.toString());
        this.queries.put(query.getSource().toString(), query);
    }
}
